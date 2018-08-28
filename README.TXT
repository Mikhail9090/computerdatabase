This is a test project for testing http://computer-database.herokuapp.com/computers web-application.

To run the tests of this project via Maven you need to execute the following command:
mvn clean install test

The generated Allure report will be available in computerdatabase\acceptance-tests\target\site\allure-maven-plugin folder after the run.
NOTE: index.html file should be open in only Firefox because the Allure plugin doesn't work with other browsers

The settings file is located in computerdatabase\test-config\src\main\resources directory.
You can change the browser in webdriver.browse property (Chrome or Firefox). make sure that you have got these browsers installed on your local machine.

The feature files are locaated in computerdatabase\acceptance-tests\src\test\resources\computerdatabase folder.
There you can find all the test scenarios and execute them separately via your IDE.