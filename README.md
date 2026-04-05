# OrangeHRM Test Automation Framework

![CI](https://github.com/ParvthyRajendran/orangehrm-automation/actions/workflows/test.yml/badge.svg)

## 🧪 About

A Selenium-based BDD test automation framework for [OrangeHRM](https://opensource-demo.orangehrmlive.com), built with Cucumber and JUnit. Tests are written in Gherkin and executed via GitHub Actions with Allure reporting.

## 🛠️ Tech Stack

| Tool | Purpose |
|---|---|
| Java 17 | Core language |
| Selenium 4 | Browser automation |
| Cucumber 7 | BDD / Gherkin step definitions |
| JUnit 4 | Test runner |
| Maven | Build & dependency management |
| Allure | Test reporting |
| GitHub Actions | CI/CD pipeline |

## 📁 Project Structure

```
src/
├── test/
│   ├── java/
│   │   ├── pages/        # Page Object classes (BasePage, LoginPage, EmployeePage)
│   │   ├── steps/        # Cucumber step definitions (LoginSteps, EmployeeSteps)
│   │   └── runner/       # JUnit runners (TestRunner, EmployeeRunner, MasterRunner)
│   └── resources/
│       └── features/     # Gherkin feature files (login.feature, Employee.feature)
```

## 📋 Test Scenarios

| Module | Scenario | Tag |
|---|---|---|
| Login | Successful login with valid credentials | `@login` |
| Login | Failed login with invalid credentials | `@login` |
| Employee | Successful add a new Employee | `@employee` |
| Employee | Failed addition of a new employee | `@employee` |

## ▶️ How to Run Locally

**Run all tests:**
```bash
mvn clean test -Dtest=MasterRunner
```

**Run by module:**
```bash
mvn test -Dtest=TestRunner       # Login tests only
mvn test -Dtest=EmployeeRunner   # Employee tests only
```

## 📊 Allure Report

The latest test report is published to GitHub Pages after every push:

🔗 [View Allure Report](https://parvthyrajendran.github.io/orangehrm-automation/)

## 👩‍💻 Author

**Parvathy Rajendran**
