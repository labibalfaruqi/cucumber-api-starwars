# Star Wars API Automation Framework

A professional API automation framework built with **Java**, **Cucumber**, **Spring Boot**, and **Serenity BDD** for testing the [Star Wars API (SWAPI)](https://swapi.info/).

## 🚀 Features
- **Behavior-Driven Development (BDD)**: Uses Cucumber Gherkin syntax for readable and maintainable test scenarios.
- **Spring Boot Integration**: Leverages Dependency Injection (`@Autowired`) and Type-Safe Configuration Properties.
- **Dynamic Environment Management**: Seamlessly switch between `prod`, `qa`, and `preprod` environments via Maven profiles.
- **Rich Reporting**: Integrated with Serenity BDD for detailed, living documentation and execution reports.
- **Clean Architecture**: Separation of concerns between Step Definitions, API Controllers, and Data Models.

## 🛠 Technologies
- **Java 21**: Core programming language.
- **Maven**: Dependency management and build tool.
- **Cucumber**: Gherkin scenario execution.
- **Serenity BDD**: Enhanced reporting and test management.
- **Spring Boot 3.x**: Core framework for DI and configuration.
- **Jackson**: JSON serialization/deserialization.
- **Lombok**: Reducing boilerplate code.

## 📋 Prerequisites
- **JDK 21** or higher.
- **Maven 3.8** or higher.

## 🏃 How to Run

### Command Line (CLI)
Run all tests using the default environment (`prod`):
```bash
mvn clean test
```

Run tests on a specific environment (e.g., `qa`):
```bash
mvn clean test -Denv=qa
```

### IDE (IntelliJ IDEA / Eclipse)
1. Open the project as a Maven project.
2. Navigate to `src/test/java/team/worldder/api/starwars/AppTest.java`.
3. Right-click and select **Run 'AppTest'**.
4. To change the environment, update the `<env>` tag in the `pom.xml`.

## ⚙️ Environment Configuration
The framework uses Spring Profiles to load different base URLs and settings.
Config files are located in `src/test/resources/`:
- `application-prod.properties`
- `application-qa.properties`
- `application-preprod.properties`

The active environment is controlled by the `<env>` property in your `pom.xml`.

## 📁 Project Structure
- `src/main/java`:
  - `config`: Spring Configuration classes.
  - `services`: API Controllers (HTTP logic).
  - `properties`: Type-safe configuration mapping.
  - `models`: Response POJOs for JSON mapping.
- `src/test/java`:
  - `steps`: Cucumber Step Definitions and Spring Context Setup.
  - `AppTest.java`: Main test runner.
- `src/test/resources`:
  - `features`: Gherkin feature files (`Films.feature`, `Vehicles.feature`, etc.).

## 📊 Reports
After execution, Serenity reports are generated at:
`target/site/serenity/index.html`
