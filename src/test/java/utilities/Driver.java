package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {

    static WebDriver driver;

    public static WebDriver getDriver(){


        // we added if statement because, when we ran test methods it may try to open another driver by using this method
        // in each step. if the driver is not noll, this method will not open another driver.
        if (driver==null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driver;
    }

    // to close opened driver // if a driver is opened, this method will close it. If there is no drider, it wont do anything
    public static void closeDriver(){
        if (driver!=null) {
            driver.close();
            driver=null;
        }

    }



}
