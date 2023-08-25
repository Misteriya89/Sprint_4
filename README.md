Sprint_4;   
Проект по автотестированию на Java UI для приложения по заказу самокатов.

Описание
Версия Java 11.

В проекте тестируется функциональность в Google Chrome и Mozilla Firefox.

Проект использует следующие библиотеки:

JUnit 4
Selenium
Документация
Ссылка на приложение https://qa-scooter.praktikum-services.ru/

Запуск автотестов
Для запуска автотестов необходимо:

Скачать код
git clone https://github.com/Misteriya89/Sprint_4
Запустить команду в проекте
mvn clean test
Структура проекта
.gitignore
pom.xml
README.md
```
src
-- main
|   |-- java
|   |   |-- pages
|   |   |   |-- MainPage.java
|   |   |   |-- OrderPage.java
|-- test
|   |-- java
|   |   |-- MainPageTest.java
|   |   |-- OrderTest.java
```