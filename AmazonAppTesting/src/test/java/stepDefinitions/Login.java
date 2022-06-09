package stepDefinitions;

import PagesClasses.LoginClasses;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import sun.awt.windows.ThemeReader;
//import org.junit.Assert;
import io.cucumber.junit.Cucumber;
import java.security.Key;

public class Login {
    // username and password change them in different test cases
    private String username = ""; // Enter your correct  amazon email here
    private String password = ""; // Enter your correct amazon password here
    private String fakeUsername = "gdfgdf";
    private String fakePassword = "gfgdf";

    LoginClasses login = new LoginClasses(); // import pattern of email and password classes

    private String actualResult = null;
    private String expectedResult =null;
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


    @When("user enter valid username and password")
    public void user_enter_valid_username_and_password() throws InterruptedException {
        login.userEmailPOM(driver).clear();
        login.userEmailPOM(driver).sendKeys(username);
        driver.findElement(By.id("continue")).click();
        Thread.sleep(2000);
        login.userPasswordPOM(driver).sendKeys(password);
        login.userPasswordPOM(driver).sendKeys(Keys.ENTER);
    }
    @And("user press enter button")
    public void user_press_enter_button() throws InterruptedException {
        login.userPasswordPOM(driver).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
    }
    @Then("user could login successfully")
    public void user_could_login_successfully(){
        expectedResult = "Buy Again";
        actualResult = driver.findElement(By.cssSelector("a[href=\"/gp/buyagain?ie=UTF8&ref_=nav_cs_buy_again\"]")).getText();
        Assert.assertEquals("nice",expectedResult,actualResult);
    }


    @When("user enter invalid username")
    public void user_enter_invalid_username() throws InterruptedException {
        login.userEmailPOM(driver).clear();
        login.userEmailPOM(driver).sendKeys(fakeUsername);
        driver.findElement(By.id("continue")).click();
        Thread.sleep(2000);
    }
    @Then("user couldn't login successfully by username")
    public void user_couldnt_login_successfully_by_username(){
        expectedResult = "We cannot find an account with that email address";
        actualResult = driver.findElement(By.className("a-list-item")).getText();
        Assert.assertEquals("Right",expectedResult,actualResult);
    }


    @When("user enter valid username")
    public void user_enter_valid_username() throws InterruptedException {
        login.userEmailPOM(driver).clear();
        login.userEmailPOM(driver).sendKeys(username);
        driver.findElement(By.id("continue")).click();
        Thread.sleep(2000);
    }
    @And("enter invalid password")
    public void enter_invalid_password() throws InterruptedException {
        login.userPasswordPOM(driver).sendKeys(fakePassword);
        login.userPasswordPOM(driver).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
    }
    @Then("user couldn't login successfully by password")
    public void user_couldnt_login_successfully_by_password(){
        expectedResult = "Your password is incorrect";
        actualResult = driver.findElement(By.className("a-list-item")).getText();
        //Assert.assertTrue(actualResult.contains(expectedResult),"valid password");
    }


    @After
    public void closeBrowser(){
        driver.quit();
    }

}
