package main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import main.pages.NavigationPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

public class Utils {

    public static WebDriver driver;

    public void setup() {
        System.out.println("driver starting");
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions opts = new ChromeOptions();
        opts.setHeadless(false);
        driver = new ChromeDriver(opts);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://minesweeper.online/");
        NavigationPage navigationPage = PageFactory.initElements(driver, NavigationPage.class);
        navigationPage.getIntermediate().click();
    }

    public void play(){
        Play play = new Play();
        System.out.println("Element matrix initialising");
        play.fields.setPlayField();
        System.out.println("Element matrix initialised, game starting");
        play.play();
    }


    public void teardown(){
        driver.quit();
    }
}
