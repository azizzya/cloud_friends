package com.cloudcom2024.store.scheduledTasks;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.cloudcom2024.store.models.User;
import com.cloudcom2024.store.repositories.UserRepository;

@Component
public class LeaderBoardEngine {    
final private BigDecimal[] REWARDS_FOR_FIRST_THREE_PLACES = {new BigDecimal(1500), new BigDecimal(1000), new BigDecimal(500)};

    final private UserRepository userRepository;

    LeaderBoardEngine(
        UserRepository userRepository
    ) {
        this.userRepository = userRepository;
    }
     
    @Scheduled(cron = "@monthly")
    public void updateLeaderBoardAndGiveRewardForFirst3() {
        List<User> allUsers = userRepository.getAllUsersSortByCoinBalanceDESCWithLimit100();
        for (int i = 0; i < allUsers.size(); i++) {
            if (i == 0 || i == 1 || i == 2) {
                rewardUser(allUsers, i);
            }
            allUsers.get(i).setCoinTotalScore(new BigDecimal(0));
        }
        userRepository.saveAll(allUsers);
    }

    private void rewardUser(List<User> users, int n) {
        BigDecimal bestUserCoinBalance = users.get(n).getCoinBalance();
        users.get(n).setCoinBalance(bestUserCoinBalance.add(REWARDS_FOR_FIRST_THREE_PLACES[n]));
    }
}
