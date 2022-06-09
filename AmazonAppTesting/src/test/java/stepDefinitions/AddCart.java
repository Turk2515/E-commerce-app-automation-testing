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

public class AddCart {
    WebDriver driver = null;
    String actualResult = driver.findElement(By.id("item added to cart successfully")).getText();
    String expectedResult = null;

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


    @And("select item")
    public void select_item() throws InterruptedException {
        driver.findElement(By.cssSelector("img[data-image-index=\"3\"]")).click();
        Thread.sleep(2000);
    }


    @When("select size")
    public void select_size(){
        driver.findElement(By.cssSelector("span[data-csa-c-func-deps=\"aui-da-a-dropdown-button\"]")).click();
        driver.findElement(By.id("native_dropdown_selected_size_name_7")).click();
    }
    //nav-cart-count

    @And("add item to cart")
    public void add_item_to_cart(){
        driver.findElement(By.id("add-to-cart-button")).click();
    }


    @Then("item added to cart successfully")
    public void item_added_to_cart_successfully(){

        if(actualResult!="0"){
            expectedResult.equals(actualResult);
        }
        Assert.assertEquals(expectedResult,actualResult);

    }


    @After
    public void closeBrowser(){
        driver.quit();

    }

}
