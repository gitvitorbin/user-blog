# user-blog

## Description
This repository contains [REST Assured](https://rest-assured.io/) automated tests written in JAVA language for the [JSON Placeholder](https://jsonplaceholder.typicode.com/) API validation.

## Tools/Technologies
* Maven
* REST Assured
* JUnit 
* Surefire

## Dependencies
 - Make sure you have [Java](http://www.java.com/) and [Maven](http://maven.apache.org/) installed on your system, if not follow the vendor instructions for installing them on your operating system.

## Installation
Put the ```mvn``` command on your path and make sure you can run java from the command line. Now you can run ```mvn clean install``` and Maven will compile your project. 
How you run this code is up to you, but usually you would start by using an IDE like NetBeans, Intellij IDEA, or Eclipse.

Note: If you need more information, please take a look at this [quick tutorial](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html).

## Running Tests Locally
The following steps should get you set up for running the tests locally on your machine:
1. Clone this repository to your local machine.
2. Compile project (make sure all dependencies are downloaded/installed successfully).
3. Open up a terminal and navigate to the root directory of the repository and execute the following command: 

```
mvn surefire:test -Dtest=TestSuite
```

4. Results will be available on ~\target\site\surefire-report.html.

## Running Tests On CircleCI Pipeline
The following steps should get you set up for running the tests locally on your machine:
1. Make sure you have access to the project's pipeline on this link [here](https://app.circleci.com/pipelines/github/gitvitorbin/user-blog?filter=all).
2. - In order to run tests in [CircleCI](https://app.circleci.com/) pipeline,

## Adding/Editing Tests
Please remember to keep this repository up to date, as the tests become worthless otherwise. A good rule of thumb is to add a new test that covers whatever bug you're fixing, so we can track regressions on it. 

## Author
- [Vitor Binsfeld](https://github.com/gitvitorbin)
