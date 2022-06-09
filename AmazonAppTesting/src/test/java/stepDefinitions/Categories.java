package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Categories {
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


    @When("click on all category")
    public void click_on_all_category() throws InterruptedException {
        driver.findElement(By.id("nav-hamburger-menu")).click();
        Thread.sleep(1500);
    }


    @And("choose one category")
    public void choose_one_category() throws InterruptedException {
        driver.findElement(By.cssSelector("a[data-menu-id=\"6\"]")).click();
        Thread.sleep(1500);
    }


    @And("choose one sub-category")
    public void choose_one_sub_category() throws InterruptedException {
        driver.findElement(By.cssSelector("a[href=\"/s?bbn=16225007011&rh=i%3Aspecialty-aps%2Cn%3A16225007011%2Cn%3A172456&ref_=nav_em__nav_desktop_sa_intl_computer_accessories_and_peripherals_0_2_6_2\"]")).click();
        Thread.sleep(1500);
    }


    @Then("choose a product")
    public void choose_a_product(){
        Assert.assertEquals("https://www.amazon.com/s?i=specialty-aps&bbn=16225007011&rh=n%3A16225007011%2Cn%3A172456&ref=nav_em__nav_desktop_sa_intl_computer_accessories_and_peripherals_0_2_6_2",driver.getCurrentUrl());
    }


    @After
    public void closeBrowser(){
        driver.quit();

    }
}
