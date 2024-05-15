Чтобы запустить бэк приложения, нужно выполнить несколько шагов:

1. Сгенерировать файл .jar:  
    1.1. Перейдите в директорию сервиса: store  
    1.2. Выполните команду: ./mvnw clean clean install -DskipTests  

2. Запустить docker compose:  
! Если приложение выдает ошибку, пропишите команду следующее:
    * docker system prune -a -f
    * docker compose build
    * (далее идите по нормланой инструкции)

    В случае нормального выполнения:  
    2.1. Перейдите в директорию backend  !Перед следующим шагом поставьте локальную переменную GIGACHAT_AUTHTOKEN
    2.2. Выполните команду: docker compose up -d

Swagger доступен по ссылке:
http://localhost:8080/swagger-ui/index.html

Есть две роли:
* ADMIN (нужен для POST /register):   
пользователь по умолчанию для роли: admin:admin  
Authorization: Basic YWRtaW46YWRtaW4=
* USER:  
пользователь по умолчанию для роли: user:user  
Authorization: Basic dXNlcjp1c2Vy

Пояснение к взаимодействию с AI chat'ом:  
* Сообщение оправляется в виде {"role":"user", "message":"сколько планет в солнечной системе?"} 
* role может быть:   
user (обычный запрос по типу {"role":"user", "message":"сколько солнечных планет в системе}) и system (задается промпт по типу "role":"system", "message":"ты великий астроном")
* Для общения с API гигачата нужно скачать сертификат Мин Цифры: https://www.gosuslugi.ru/crt
* Получить аутентификационный токен можно по ссылке: https://developers.sber.ru/docs/ru/gigachat/individuals-quickstart