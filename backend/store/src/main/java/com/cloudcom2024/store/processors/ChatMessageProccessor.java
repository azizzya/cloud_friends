package com.cloudcom2024.store.processors;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.cloudcom2024.store.daos.AccessTokenDAO;
import com.cloudcom2024.store.daos.MessageResponseDAO;
import com.cloudcom2024.store.daos.MessageWithParammetersDAO;
import com.cloudcom2024.store.dtos.GigaChatAccessTockenResponse;
import com.cloudcom2024.store.proxies.GigaChatGetTokenProxy;
import com.cloudcom2024.store.proxies.GigaChatMessageProxy;

import lombok.extern.log4j.Log4j2;

@Component
@SessionScope
@Log4j2
public class ChatMessageProccessor {
    private GigaChatAccessTockenResponse currentToken;
    @Value("${gigachat.authtoken}")
    private String authToken;

    final private GigaChatGetTokenProxy gigaChatGetTokenProxy;
    final private GigaChatMessageProxy gigaChatMessageProxy;

    public ChatMessageProccessor(
        GigaChatGetTokenProxy gigaChatGetTokenProxy,
        GigaChatMessageProxy gigaChatMessageProxy
    ) {
        this.gigaChatGetTokenProxy = gigaChatGetTokenProxy;
        this.gigaChatMessageProxy = gigaChatMessageProxy;
    }

    public void setToken(GigaChatAccessTockenResponse newToken) {
        currentToken = newToken;
    }

    public GigaChatAccessTockenResponse getCurrentToken() {
        return currentToken;
    }

    public void updateToken() {
        String rqUID = UUID.randomUUID().toString();
        Map<String, Object> headers = new HashMap<>();
        headers.put("RqUID", rqUID);
        log.info(authToken);
        headers.put("Authorization", "Basic " + authToken);
        AccessTokenDAO scope = new AccessTokenDAO();
        scope.setScope("GIGACHAT_API_PERS");

        currentToken = gigaChatGetTokenProxy.createAccessTocken(
            headers,
            scope
        );
    }

    public String sendRequestToModel(MessageWithParammetersDAO messageWithParammetersDAO) {
        Map<String, Object> headers = new HashMap<>();
        String authorizationCredentials = String.format("Bearer %s", currentToken.getAccessToken());
        headers.put("Authorization", authorizationCredentials);

        messageWithParammetersDAO.setTemperature(1.25f);
        messageWithParammetersDAO.setN(1);

        MessageResponseDAO messageResponse = gigaChatMessageProxy.sendMessage(headers, messageWithParammetersDAO);

        log.info(messageResponse);

        int lastIndex = messageResponse.getChoices().size() - 1;

        return messageResponse.getChoices().get(lastIndex)
            .getMessage()
            .getContent();
    }
}