package tests.day19_CrossBrowserTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.TestBaseCross;

public class C01_AmazonNutellaTest extends TestBaseCross {

    // Go to the amazon.com

    // search for nutella

    // test that result text contains nutella


    @Test
    public void test01(){

        // Go to the amazon.com
        driver.get(ConfigReader.getProperty("amazonUrl"));

        // search for nutella
        // we did not use AmazonPage class because in amazonPage class we are using normal Driver class
        // But to do crossBrowser testing we need to use CrossDriver
        /*
        there are two ways to handle this problem
            ) we can cretae another page class for cross testing
            ) or we can directly locate the webelement without using any page class  (*)
         */

        // search for nutella
        WebElement amazonSearchBox= driver.findElement(By.id("twotabsearchtextbox"));
        amazonSearchBox.sendKeys("Nutella"+ Keys.ENTER);

        // test that result text contains nutella
        WebElement amazonResultext = driver.findElement(By.xpath("//div[@class='sg-col-14-of-20 sg-col-18-of-24 sg-col s-breadcrumb sg-col-10-of-16 sg-col-6-of-12']"));

        String actualResultText = amazonResultext.getText();
        String expectedResultWord = "Nutella";

        Assert.assertTrue(actualResultText.contains(expectedResultWord));



    }




}
