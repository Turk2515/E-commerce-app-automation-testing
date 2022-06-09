package stepDefinitions;

import PagesClasses.RegistrationClasses;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Registration {
    WebDriver driver = null;
    private String name = "name";
    private String email = "E-mail";
    private String password = "pass";
    private String repassword = "repass";
    private RegistrationClasses regist = new RegistrationClasses();




    @Before
    public void openBrowser() throws InterruptedException {
        String path = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path); // connect between selenium and chrome driver
        driver = new ChromeDriver();
        driver.navigate().to("https://www.amazon.com"); // go to amazon website
        driver.manage().window().maximize(); // fullscreen
        driver.findElement(By.id("nav-link-accountList")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("createAccountSubmit")).click();
    }


    @When("enter valid name")
    public void enter_valid_name() throws InterruptedException {
        regist.registPOM(driver,"ap_customer_name",name);
        Thread.sleep(2000);
    }
    @And("enter mobile number or email")
    public void enter_mobile_number_or_email() throws InterruptedException {
        regist.registPOM(driver,"ap_email",email);
        Thread.sleep(2000);
    }
    @And("enter password")
    public void enter_password() throws InterruptedException {
        regist.registPOM(driver,"ap_password",email);
        Thread.sleep(2000);
    }
    @And("re_enter password and click continue")
    public void re_enter_password() throws InterruptedException {
        regist.registPOM(driver,"ap_password_check",repassword);
        Thread.sleep(4000);
        driver.findElement(By.id("continue")).click();
    }
    @Then("registration successfully")
    public void registration_successfully(){
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }


}
