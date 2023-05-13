package tests.day01;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class C03_NutellaTest  {

    @Test
    public void test01() {

                  //driver
        Driver.getDriver().get("https://amazon.com");
        Driver.getDriver();
        Driver.getDriver();
        Driver.getDriver();

        // search for nutella 50 // If you are planing to use same locater a lot of times/ you can locate it in
                                    //pages package

        // to reach any variable from AmazonPage Class , we need to create an object from that class
        // if the variable or methos is not static we have to create an object from the class
        AmazonPage amazonPage = new AmazonPage();

        amazonPage.amazonSearchBox.sendKeys("Nutella"+ Keys.ENTER);

        // test that result has nutella keyword
        String expectedResultWord = "Nutella";
        String actualResultText =  amazonPage.amazonResultText.getText();

        Assert.assertTrue(actualResultText.contains(expectedResultWord));

        Driver.closeDriver();








    }
}
