package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    @FindBy(id="Email")
    WebElement usernameTextbox;

    @FindBy(id="Password")
    WebElement passwordTextbox;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;

//    private By usernameTextBox = By.id("Email");
//    private By passwordTextBox = By.id("Password");
//    private By LoginButton = By.xpath("//button[@type='submit']");

    public LoginPage( WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUsername (String username) {

        usernameTextbox.clear();
        usernameTextbox.sendKeys(username);
//        driver.findElement(usernameTextBox).clear();
//        driver.findElement(usernameTextBox).sendKeys(username);
    }

    public  void enterPassword (String password) {

        passwordTextbox.clear();
        passwordTextbox.sendKeys(password);

//        driver.findElement(passwordTextBox).clear();
//        driver.findElement(passwordTextBox).sendKeys(password);
    }

    public void clickLogin () {
        loginButton.click();
//        driver.findElement(LoginButton).click();
    }
}
