# Проект по автоматизации тестирования API на <a target="_blank" href="https://reqres.in/">Reqres.In</a>

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
</p>

### Автотесты написаны на <code>Java</code> с использованием <code>API RestAssured</code> 

- Gradle — используется как инструмент автоматизации сборки.
- Jenkins — CI/CD для удаленного запуска тестов.
- Allure TestOps - как система управления тестированием.
- Осуществлена интеграция с Allure TestOps и Jira.
- По итогу прохождения автотестов генерируется Allure отчет. 

<a id="cases"></a>
<a name="Список проверок, реализованных в автотестах">**Список проверок, реализованных в автотестах:**</a>
* Проверка userId переданного пользователя
* Проверка статус кода при передаче пользователя отсутствующего в базе
* Успешная операция логина
* Неуспешная операция логина с пустым паролем
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

### Сборка тестов в  <a target="_blank" href="https://jenkins.autotests.cloud/job/024_stasia_shpakova_ApiProject/">Jenkins</a>

<p align="center">
<img title="Jenkins" src="media/screenshots/Jenkins_Api1.png">
</p>

>Для запуска сборки необходимо перейти в раздел `Build with Parameters` и нажать кнопку `Build`

<p align="center">
<img src="media/screenshots/Jenkins_Api_Parameters.png"/>
</p>

## Интеграция с <b><a target="_blank" href="https://jenkins.autotests.cloud/job/024_stasia_shpakova_ApiProject/1/allure/#">Allure report</a></b>
#### Результаты прохождения тестов
`ALLURE REPORT` - отображает дату и время прохождения тестов, общее количество запущенных тестов, а также процент и количество успешных и упавших тестов <br/>
`TREND` - отображает тенденцию выполнения тестов для всех запусков <br/>
`SUITES` - отображает распределение тестов по сьютам <br/>

<img src="media/screenshots/AllureReport_API_5cases.png">

#### Развернутый результат прохождения тестов:
1. Общий список автотестов
2. Содержание автотеста
3. Вложения

<img src="media/screenshots/AllureReport_API_project.png">

## Интеграция с <b><a target="_blank" href="https://allure.autotests.cloud/project/4176/test-cases/31657?treeId=0">Allure TestOps</a></b>

>Результаты прохождения тестов
>
<img src="media/screenshots/AllureTestOps_API.png">

## Интеграция с <b><a target="_blank" href="https://jira.autotests.cloud/browse/HOMEWORK-1205">Jira</a></b>

>В Jira создана задача и в разделе `Allure:Test Cases` отображаются интегрированные автоматизированные тесты
>
<img src="media/screenshots/Jira_API_5cases.png">


