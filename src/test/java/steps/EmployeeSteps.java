package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BasePage;
import pages.EmployeePage;
import pages.LoginPage;

import static org.junit.Assert.assertTrue;
import static pages.BasePage.driver;

public class EmployeeSteps {

    EmployeePage employeePage;
    LoginPage loginPage;

    @Before
    public void setUp() {
        BasePage.initDriver();
        loginPage = new LoginPage(driver);
        employeePage = new EmployeePage(driver);
    }

    @Given("the user is logged in and on the Add Employee page")
    public void userIsLoggedInAndOnAddEmployeePage() {
        loginPage.login("Admin", "admin123");
        employeePage.navigateToAddEmployee();
    }

    @When("the user enters first name {string} and last name {string} and clicks save")
    public void enterNamesAndClickSave(String firstName, String lastName) {
        employeePage.addEmployee(firstName, lastName);
    }

    @When("the user enters first name and last name as blank and clicks save")
    public void enterBlankNamesAndClickSave() {
        employeePage.clickSaveWithBlankFields();
    }

    @Then("the Personal Details page should be displayed successfully")
    public void personalDetailsPageDisplayed() {
        assertTrue(employeePage.isPersonalDetailsPageLoaded());
    }

    @Then("an error message should be displayed showing the required fields")
    public void errorMessageForRequiredFieldsDisplayed() {
        assertTrue(employeePage.isRequiredFieldErrorDisplayed());
    }

    @After
    public void quitDriver() {
        driver.quit();
    }
}
