package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FirstScript {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-extensions");
        options.addArguments("--incognito");
        options.addArguments("window-size=1920,1080");

        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        driver.get("https://admin-demo.nopcommerce.com/login");

        String title = driver.getTitle();

        System.out.println("Title is : " + title);

        WebElement Email = driver.findElement(By.id("Email"));
        Email.clear();
        Email.sendKeys("admin@yourstore.com");
        WebElement Password = driver.findElement(By.id("Password"));
        Password.clear();
        Password.sendKeys("admin");
        WebElement LogIn = driver.findElement(By.xpath("//button[@type='submit']"));
        LogIn.click();


//        driver.quit();
    }
}