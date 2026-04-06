package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import pages.BasePage;
import pages.LoginPage;

import static org.junit.Assert.assertTrue;
import static pages.BasePage.driver;

public class LoginSteps {

      LoginPage loginPage;  // ← here, outside all methods

      @Before
      public void setUp() {
         BasePage.initDriver();
         loginPage = new LoginPage(driver);  // ← assign here
      }

      @Given("the user is on the login page")
      public void OnloginPage() {

      }

      @When("the user enters username {string} and password {string}")
      public void enterCredentials(String username, String password) {
         loginPage.login(username, password);
      }

      @Then("the user should be redirected to the dashboard")
      public void userRedirectedToDashboard() {
         WebDriverWait wait = new WebDriverWait(BasePage.driver, Duration.ofSeconds(15));
         wait.until(ExpectedConditions.urlContains("dashboard"));
         assertTrue(BasePage.driver.getCurrentUrl().contains("dashboard"));
      }

    @Then("an error message should be displayed")
    public void errorMessageDisplayed() {
        String errorText = BasePage.wait
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector(".oxd-alert-content-text")))
                .getText();
        assertTrue(errorText.contains("Invalid credentials"));
    }

      @After
      public void quitDriver() {
         driver.quit();
      }

}
