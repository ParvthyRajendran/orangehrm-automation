@employee
Feature: OrangeHRM Employee Management

  Scenario: Successful add a new Employee
    Given the user is logged in and on the Add Employee page
    When the user enters first name "John" and last name "Smith" and clicks save
    Then the Personal Details page should be displayed successfully

  Scenario: Failed addition of a new employee
    Given the user is logged in and on the Add Employee page
    When the user enters first name and last name as blank and clicks save
    Then an error message should be displayed showing the required fields