# Проект по автоматизации тестирования API на Regres.In

## Технологии и инструменты

<p  align="center">

<a href="https://www.jetbrains.com/idea/"><img width="5%" title="IntelliJ IDEA" src="media/icons/Idea.svg"></a>
<a href="https://www.java.com/"><img width="5%" title="Java" src="media/icons/Java.svg"></a>
<a href="https://selenide.org/"><img width="5%" title="Selenide" src="media/icons/Selenide.svg"></a>
<a href="https://gradle.org/"><img width="5%" title="Gradle" src="media/icons/Gradle.svg"></a>
<a href="https://junit.org/junit5/"><img width="5%" title="Junit5" src="media/icons/Junit5.svg"></a>
<a href="https://github.com/"><img width="5%" title="GitHub" src="media/icons/GitHub.svg"></a>
<a href="https://allurereport.org/"><img width="5%" title="Allure Report" src="media/icons/Allure.svg"></a>
<a href="https://qameta.io/"><img width="5%" title="Allure TestOps" src="media/icons/Allure_TO.svg"></a>
<a href="https://www.jenkins.io/"><img width="5%" title="Jenkins" src="media/icons/Jenkins.svg"></a>
<a href="https://www.atlassian.com/ru/software/jira"><img width="5%" title="Jira" src="media/icons/Jira.svg"></a>
<a href="https://web.telegram.org/"><img width="5%" title="Telegram" src="media/icons/Telegram.svg"></a>
</p>

### Автотесты написаны на <code>Java</code> с использованием <code>API RestAssured</code> 

- Gradle — используется как инструмент автоматизации сборки.
- Jenkins — CI/CD для удаленного запуска тестов.
- Allure TestOps - как система управления тестированием.
- Telegram Bot — для уведомлений о результатах прохождения тестов.
- Осуществлена интеграция с Allure TestOps и Jira.
- По итогу прохождения автотестов генерируется Allure отчет. 

<a id="cases"></a>
<a name="Список проверок, реализованных в автотестах">**Список проверок, реализованных в автотестах:**</a>
* Проверка userId переданного пользователя
* Проверка статус кода при передаче пользователя отсутствующего в базе
* Успешная операция логина
* Успешное удаление пользователя

## Запуск тестов
### Локальный запуск тестов

Для запуска следует открыть IntelliJ IDEA и выполнить в терминале:
```
gradle clean test
```

или

```
gradle clean test -Denv=local
```

### Удалённый запуск через Jenkins
```bash  
clean ${TASK} 
"-Denv=${ENVIRONMENT}"  
```
***Tasks для запуска тестов:***
- *test - запуск всех api тестов*
- *user_test - запуск api тестов на проверку пользователя*
- *login_test - запуск api тестов на авторизацию*

