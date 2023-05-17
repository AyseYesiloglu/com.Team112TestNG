package tests.day17_ReusableMethods_XmlFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_SwitchToNewWindow {

    // go to the https://the-internet.herokuapp.com/iframe
    // click on elemental selenium link
    // title of new tab is "Elemental Selenium: Receive a Free, Weekly Tip on Using Selenium like a Pro"
    // switch to new tab


    @Test
    public void test(){

        // go to the https://the-internet.herokuapp.com/iframe
        Driver.getDriver().get("https://the-internet.herokuapp.com/iframe");

        // click on elemental selenium link
        String originalHandleValue =Driver.getDriver().getWindowHandle();
        Driver.getDriver().findElement(By.xpath("//a[text()='Elemental Selenium']")).click();


//        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
//        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
//
//        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
//        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
//        Driver.getDriver().switchTo().window(originalHandleValue);


        // title of new tab is "Elemental Selenium: Receive a Free, Weekly Tip on Using Selenium like a Pro"
        // switch to new tab

        // to switch to new tab we used a method from reusableMethods class
        ReusableMethods.switchToWindow("Elemental Selenium: Receive a Free, Weekly Tip on Using Selenium like a Pro");

        String expectedTex= "A free, once-weekly e-mail on how to use Selenium like a Pro";

        String actualText = Driver.getDriver().findElement(By.tagName("h2")).getText();

        Assert.assertEquals(actualText,expectedTex);

        Driver.getDriver().quit();

    }

}
