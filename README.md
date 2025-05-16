# Bookstore API Automation Framework

This framework provides automated testing for the Bookstore FastAPI implementation.

## Features
- REST API testing using RestAssured
- TestNG for test execution and reporting
- Allure for beautiful test reporting
- Data-driven testing approach
- CI/CD integration with Jenkins/GitHub Actions

## Prerequisites
- Java 11 or higher
- Maven 3.8.6 or higher
- FastAPI bookstore service running locally or at configured URL

## Setup
1. Clone the repository
2. Configure the API base URL in `src/main/resources/config-dev.properties`
3. Install dependencies: `mvn clean install`

## Running Tests
- Run all tests: `mvn test`
- Run specific test group: `mvn test -Dgroups=smoke`
- Generate Allure report: `mvn allure:report`

## Test Structure
- `src/main/java/apis/` - API client implementations
- `src/main/java/models/` - Response models
- `src/test/java/steps/` - Step definitions for BDD tests
- `src/test/resources/features/` - Feature files for BDD scenarios

## CI/CD Integration
The framework includes:
- Jenkinsfile for Jenkins pipeline
- GitHub Actions workflow (configured in .github/workflows)

## Test Reports
After test execution, Allure reports can be generated with:
```bash
mvn allure:serve
