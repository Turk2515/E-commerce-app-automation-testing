package PagesClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationClasses {

    public void registPOM(WebDriver driver,String id,String s){
        driver.findElement(By.id(id)).click();
        driver.findElement(By.id(id)).sendKeys(s);
    }
}
