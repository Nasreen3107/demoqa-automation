package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import utils.ElementUtils;

public class FormPage extends BasePage {

    JavascriptExecutor js;

    public FormPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        js = (JavascriptExecutor) driver;
    }

    // ================= LOCATORS =================

    @FindBy(xpath = "//span[text()='Practice Form']")
    WebElement practiceForm;

    @FindBy(id = "firstName")
    WebElement firstName;

    @FindBy(id = "lastName")
    WebElement lastName;

    @FindBy(id = "userEmail")
    WebElement email;

    @FindBy(xpath = "//label[text()='Male']")
    WebElement gender;

    @FindBy(id = "userNumber")
    WebElement mobile;

    @FindBy(id = "dateOfBirthInput")
    WebElement dob;

    @FindBy(id = "subjectsInput")
    WebElement subjects;

    @FindBy(xpath = "//label[text()='Sports']")
    WebElement hobbies;

    @FindBy(id = "uploadPicture")
    WebElement upload;

    @FindBy(id = "currentAddress")
    WebElement address;

    @FindBy(id = "submit")
    WebElement submitBtn;

    @FindBy(id = "example-modal-sizes-title-lg")
    WebElement successPopup;

    // ================= ACTION METHODS =================

    public void openForm() {
        js.executeScript("arguments[0].click();", practiceForm);

        // ✅ wait for form to load
        ElementUtils.sendText(driver, firstName, ""); 
        firstName.clear();
    }

    public void fillBasicDetails(String fn, String ln, String em, String ph) {
        ElementUtils.sendText(driver, firstName, fn);
        ElementUtils.sendText(driver, lastName, ln);
        ElementUtils.sendText(driver, email, em);
        ElementUtils.click(driver, gender);
        ElementUtils.sendText(driver, mobile, ph);
    }

    public void setDOB(String date) {
        dob.sendKeys(Keys.CONTROL + "a");
        dob.sendKeys(date);
        dob.sendKeys(Keys.ENTER);
    }

    public void setSubjects(String sub) {
        ElementUtils.sendText(driver, subjects, sub);
        subjects.sendKeys(Keys.ENTER);
    }

    public void selectHobby() {
        ElementUtils.click(driver, hobbies);
    }

    public void uploadFile(String path) {
        upload.sendKeys(path);
    }

    public void setAddress(String addr) {
        ElementUtils.sendText(driver, address, addr);
    }

    public void selectStateCity() {

        js.executeScript("window.scrollBy(0,400)");

        WebElement stateInput = driver.findElement(By.id("react-select-3-input"));
        stateInput.sendKeys("NCR");
        stateInput.sendKeys(Keys.ENTER);

        WebElement cityInput = driver.findElement(By.id("react-select-4-input"));
        cityInput.sendKeys("Delhi");
        cityInput.sendKeys(Keys.ENTER);
    }

    public void submitForm() {

        js.executeScript("window.scrollBy(0,500)");
        ElementUtils.click(driver, submitBtn);
    }

    public boolean isFormSubmitted() {
        return ElementUtils.isVisible(driver, successPopup);
    }
}