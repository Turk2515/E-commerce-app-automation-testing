package stepDefinitions;

import PagesClasses.LoginClasses;
import PagesClasses.ResetClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ResetPassword {
    private String username = ""; // Enter your correct  amazon email here
    private String password = "";
    private String oldPassword = "";
    private String newPassword = "";
    private String newPassword_1 = "";
    LoginClasses login = new LoginClasses();
    ResetClass reset = new ResetClass();
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


    @Given("user login firstly")
    public void user_login_firstly() throws InterruptedException {
        login.userEmailPOM(driver).clear();
        login.userEmailPOM(driver).sendKeys(username);
        driver.findElement(By.id("continue")).click();
        Thread.sleep(2000);
        login.userPasswordPOM(driver).sendKeys(password);
        login.userPasswordPOM(driver).sendKeys(Keys.ENTER);
    }
    @When("user go to account security settings to reset password")
    public void user_go_to_account_security_settings() throws InterruptedException {
        driver.findElement(By.id("nav-link-accountList")).click();
        Thread.sleep(2000);
        driver.findElement(By.className("a-box-inner")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("auth-cnep-edit-password-button")).click();
        Thread.sleep(2000);
    }
    @And("enter old password")
    public void enter_old_password() throws InterruptedException {
        reset.resetPassword(driver,"ap_password",oldPassword);
    }
    @And("enter new password")
    public void enter_new_password() throws InterruptedException {
        reset.resetPassword(driver,"ap_password_new",newPassword);
    }
    @And("re_enter new password and click save changes")
    public void re_enter_new_password() throws InterruptedException {
        reset.resetPassword(driver,"ap_password_new_check",newPassword_1);
        Thread.sleep(1000);
        driver.findElement(By.id("cnep_1D_submit_button")).click();
        Thread.sleep(2000);
    }
    @Then("password reset successfully")
    public void password_reset_successfully(){
        String expectedResult = "            You have successfully modified your account!\n" +
                "          ";
        String actualResult = driver.findElement(By.className("a-list-item")).getText();
        Assert.assertTrue("Email with instructions has been sent to you.",actualResult.contains(expectedResult));
    }


    @After
    public void closeBrowser(){
        driver.quit();
    }
}