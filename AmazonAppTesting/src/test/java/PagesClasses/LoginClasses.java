package PagesClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginClasses {
    public WebElement userEmailPOM(WebDriver driver){
        return driver.findElement(By.id("ap_email"));
    }

    public WebElement userPasswordPOM(WebDriver driver){
        return driver.findElement(By.id("ap_password"));
    }
}
