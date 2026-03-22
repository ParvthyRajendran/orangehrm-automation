Feature: OrangeHRM Login

  Scenario: Successful login with valid credentials
    Given the user is on the login page
    When the user enters username "Admin" and password "admin123"
    Then the user should be redirected to the dashboard

  Scenario: Failed login with invalid credentials
    Given the user is on the login page
    When the user enters username "user" and password "1234"
    Then an error message should be displayed