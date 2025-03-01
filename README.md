# Java Cucumber Saucedemo

This project uses the test website [saucedemo](https://www.saucedemo.com) to demo a project set up using Java, Selenium and Cucumber.

Tests use the gherkin syntax with feature files, step definitions and supporting classes.
It also makes use of the Page Object Model design pattern to organise locators and methods for website interaction.


## Install

To compile the project run:

```
mvnw clean compile
```


## Run the tests

You can run all tests using:

```
mvnw test
```

### Suites

Tags have also been added to the features to group them into test suites.

You can choose from:
 - login
 - inventory
 - cart
 - regrression (runs all 3 of the above)

You run this by using (for e.g.):

```
mvnw test -Dgroups="cart"
```

If you want to run a select few then separate with a pipe | character in the string.

For example:

```
mvnw test -Dgroups="cart | login"
```

### Reporting

A test report can be viewed on completion of the test run at _target/cucumber/report.html_