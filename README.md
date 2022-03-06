# user-blog
This repository contains [REST Assured](https://rest-assured.io/) tests for the [JSON Placeholder](https://jsonplaceholder.typicode.com/) API.

## Tools

* Maven
* REST Assured
* JUnit
* Surefire

## Dependencies

1. Make sure you have [Java](http://www.java.com/) and [Maven](http://maven.apache.org/) installed on your system, if not follow the vendor instructions for installing them on your operating system.
2. In order to run tests in [CircleCI](https://app.circleci.com/) pipeline, make sure you have access to the project's pipeline on this link [here](https://app.circleci.com/pipelines/github/gitvitorbin/user-blog?filter=all).

## Adding Tests
Please remember to keep this repository up to date as the tests become worthless otherwise. A good rule of thumb is to add a new test that covers whatever bug you're fixing so we can track regressions on it. 

## Running Tests

The following steps should get you set up for running Selenium tests locally on your machine:

1. Clone this repository to your local machine.
2. Compile project (make sure all dependencies are downloaded/installed successfuly).
3. Open up a terminal and navigate to the root directory of the repository and execute command "mvn test site" (tests will be available on )
3a. asoidj
3b. sodiajsd
5. Open up project's [pipeline](https://app.circleci.com/pipelines/github/gitvitorbin/user-blog?filter=all) and lick on "Rerun workflow from start" on the last run.
