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

    @FindBy(xpath = "//span[text()='Practice Form']")
    WebElement practiceForm;

    @FindBy(xpath = "//input[@id='firstName']")
    WebElement firstName;

    @FindBy(xpath = "//input[@id='lastName']")
    WebElement lastName;

    @FindBy(xpath = "//input[@id='userEmail']")
    WebElement email;

    @FindBy(xpath = "//label[text()='Male']")
    WebElement gender;

    @FindBy(xpath = "//input[@id='userNumber']")
    WebElement mobile;

    @FindBy(xpath = "//input[@id='dateOfBirthInput']")
    WebElement dob;

    @FindBy(xpath = "//input[@id='subjectsInput']")
    WebElement subjects;

    //@FindBy(xpath = "//label[text()='Sports']")
    //WebElement hobbies;

    @FindBy(xpath = "//input[@id='uploadPicture']")
    WebElement upload;

    @FindBy(xpath = "//textarea[@id='currentAddress']")
    WebElement address;

    @FindBy(xpath = "//button[@id='submit']")
    WebElement submitBtn;

    @FindBy(xpath = "//div[@id='example-modal-sizes-title-lg']")
    WebElement successPopup;

    public void openForm() {
        js.executeScript("arguments[0].click();", practiceForm);

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

    public void selectHobby(String hobby) {

        WebElement hobbyElement =
                driver.findElement(
                        By.xpath("//label[text()='" + hobby + "']")
                );

        ElementUtils.click(driver, hobbyElement);
    }

    public void uploadFile(String path) {
        upload.sendKeys(path);
    }

    public void setAddress(String addr) {
        ElementUtils.sendText(driver, address, addr);
    }

    public void selectStateCity(String state, String city) {

        js.executeScript("window.scrollBy(0,400)");

        WebElement stateInput =
                driver.findElement(
                        By.xpath("//input[@id='react-select-3-input']")
                );

        stateInput.sendKeys(state);
        stateInput.sendKeys(Keys.ENTER);

        WebElement cityInput =
                driver.findElement(
                        By.xpath("//input[@id='react-select-4-input']")
                );

        cityInput.sendKeys(city);
        cityInput.sendKeys(Keys.ENTER);
    }

    public void submitForm() {

        js.executeScript("arguments[0].scrollIntoView(true);", submitBtn);

        js.executeScript("arguments[0].click();", submitBtn);
    }

    public boolean isFormSubmitted() {
        return ElementUtils.isVisible(driver, successPopup);
    }
}