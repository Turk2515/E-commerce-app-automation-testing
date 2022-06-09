package PagesClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResetClass {
    public void resetPassword(WebDriver driver, String id, String P) throws InterruptedException {
        driver.findElement(By.id(id)).click();
        driver.findElement(By.id(id)).sendKeys(P);
        Thread.sleep(1000);
    }
}
