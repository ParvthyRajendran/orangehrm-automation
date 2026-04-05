package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static pages.BasePage.wait;

public class EmployeePage {

    private WebDriver driver;

    private By pimMenu = By.xpath("//span[text()='PIM']");
    private By pimPageHeader = By.xpath("//h6[text()='PIM']");
    private By addButton = By.xpath("//button[contains(@class,'oxd-button--secondary') and contains(.,'Add')]");
    private By firstNameField = By.name("firstName");
    private By lastNameField = By.xpath("//input[@name='lastName']");
    private By saveButton = By.xpath("//button[@type='submit' and contains(@class,'orangehrm-left-space')]");
    private By personalDetailsHeader = By.xpath("//h6[contains(@class,'orangehrm-main-title') and text()='Personal Details']");
    private By requiredFieldError = By.cssSelector(".oxd-input-field-error-message");

    public EmployeePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToAddEmployee() {
        wait.until(ExpectedConditions.elementToBeClickable(pimMenu)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(pimPageHeader));
        wait.until(ExpectedConditions.elementToBeClickable(addButton)).click();
    }

    public void addEmployee(String firstName, String lastName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField)).sendKeys(firstName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField)).sendKeys(lastName);
        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(personalDetailsHeader));
    }

    public void clickSaveWithBlankFields() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField)).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField)).clear();
        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
    }

    public boolean isEmployeeInList(String fullName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(personalDetailsHeader));
        return driver.getCurrentUrl().contains("empNumber");
    }

    public boolean isPersonalDetailsPageLoaded() {
        return !wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(personalDetailsHeader)).isEmpty();
    }

    public boolean isRequiredFieldErrorDisplayed() {
        return !wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(requiredFieldError)).isEmpty();
    }
}
