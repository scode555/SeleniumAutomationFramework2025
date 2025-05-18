package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    private By usernameTextBox = By.id("Email");
    private By passwordTextBox = By.id("Password");
    private By LoginButton = By.xpath("//button[@type='submit']");

    public LoginPage( WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername (String username) {
        driver.findElement(usernameTextBox).clear();
        driver.findElement(usernameTextBox).sendKeys(username);
    }

    public  void enterPassword (String password) {
        driver.findElement(passwordTextBox).clear();
        driver.findElement(passwordTextBox).sendKeys(password);
    }

    public void clickLogin () {
        driver.findElement(LoginButton).click();
    }
}
