# Calley Automation Framework

## Overview

This project is a Selenium WebDriver automation framework developed using Java, Maven, and TestNG. The framework automates the complete Calley Teams setup workflow, including user registration, login, CSV upload, agent selection, and validation of successful setup.

## Tech Stack

- Java
- Selenium WebDriver
- TestNG
- Maven
- Page Object Model (POM)

## Project Structure

```text
src/main/java
├── com.calley.CalleyTeamsFullSetup
│   └── BaseClass.java
└── pompages
    ├── RegistrationPage.java
    ├── LoginPage.java
    ├── CSVUploadPage.java
    └── AgentPage.java

src/main/resources
└── data.properties

src/test/java
└── com.calley.CalleyTeamsFullSetup
    ├── RegistrationTest.java
    └── FullSetupTest.java
```

## Features Automated

- User Registration
- User Login
- CSV File Upload
- Agent Selection
- Success Message Validation
- End-to-End Team Setup Flow

## Framework Design

This framework follows the Page Object Model (POM) design pattern to improve maintainability, reusability, and readability of test scripts.

## Prerequisites

- Java 8 or above
- Maven
- Chrome Browser
- ChromeDriver (compatible with installed Chrome version)

## Project Demo Video

[Registration Process] https://drive.google.com/file/d/16DccTf_FxqW_XeXOhfHsUYy1o7rOf5t1/view?usp=sharing
[Login, Adding Agent, CSV File Upload] https://drive.google.com/file/d/1FZqcDwM9KzHMefAbXN5aT8peDSI5rG6G/view?usp=drive_link

## Execution

Clone the repository:

```bash
git clone https://github.com/vidyasreeps11/Calley-Automation-Framework.git
```

Navigate to the project directory:

```bash
cd Calley-Automation-Framework
```

Run the test suite:

```bash
mvn test
```

## Author

Vidyasree PS
