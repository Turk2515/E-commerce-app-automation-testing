package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class SearchProduct {
    WebDriver driver = null;

    @Before
    public void openSite() throws InterruptedException {
        String path = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path); // connect between selenium and chrome driver
        driver = new ChromeDriver();
        driver.navigate().to("https://www.amazon.com"); // go to amazon website
        driver.manage().window().maximize(); // fullscreen
        driver.findElement(By.id("nav-link-accountList")).click();
        Thread.sleep(2000);
    }

    @And("go to home page")
    public void go_to_home_page(){
        driver.findElement(By.id("nav-logo-sprites")).click();
    }
    @Then("click on search field successfully")
    public void click_on_search_field(){
        Boolean  actualResult = driver.findElement(By.id("twotabsearchtextbox")).isDisplayed();
        driver.findElement(By.id("twotabsearchtextbox")).click();
        Boolean expectedResult = true;
        Assert.assertEquals(expectedResult,actualResult);
    }


    @After
    public void closeBrowser(){
        driver.quit();
    }

}
