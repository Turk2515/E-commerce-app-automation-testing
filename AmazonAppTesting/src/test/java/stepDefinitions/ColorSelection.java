package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ColorSelection {
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


    @And("choose men fashion category")
    public void choose_men_fashion_category() throws InterruptedException {
        driver.findElement(By.cssSelector("a[data-menu-id=\"13\"]")).click();
        Thread.sleep(1500);
    }


    @And("choose shoes category")
    public void choose_shoes_category() throws InterruptedException {
        driver.findElement(By.cssSelector("a[href=\"/s?bbn=16225019011&rh=i%3Aspecialty-aps%2Cn%3A7141123011%2Cn%3A16225019011%2Cn%3A679255011&ref_=nav_em__nav_desktop_sa_intl_shoes_0_2_13_3\"]")).click();
        Thread.sleep(1500);
    }


    @Then("select color")
    public void select_color(){
        driver.findElement(By.cssSelector("id[href=\"/s?i=fashion-mens-intl-ship&bbn=16225019011&rh=n%3A7141123011%2Cn%3A16225019011%2Cn%3A679255011%2Cp_n_size_two_browse-vebin%3A5391082011&dc&qid=1654784694&rnid=5391076011&ref=sr_nr_p_n_size_two_browse-vebin_6\"")).click();
        
    }


    @After
    public void closeBrowser(){
        driver.quit();
    }

}
