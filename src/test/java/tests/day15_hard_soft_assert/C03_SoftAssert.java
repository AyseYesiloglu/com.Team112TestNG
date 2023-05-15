package tests.day15_hard_soft_assert;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AmazonPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C03_SoftAssert {

    @Test
    public void test01(){

        // amazon.com
        // verify that you are in amazon.com
        // search for nutella and click on the firt product
        // verify that you searched for nutella
        // search for java
        // verify that there are more than 1000 results
        // close driver

        // amazon.com



        Driver.getDriver().get("https://www.amazon.com");

        // verify that you are in amazon.com

        SoftAssert softAssert = new SoftAssert();
        String expectedUrlWord = "amazon";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        softAssert.assertTrue(actualUrl.contains(expectedUrlWord));

        // search for nutella
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.amazonSearchBox.sendKeys("nutella"+ Keys.ENTER);

//        //and click on the firt product and test the title
//        amazonPage.firstProductOfSearch.click();
//        String actualTitle = amazonPage.ProductTitle.getText();
//        System.out.println(actualTitle);
//        String expectedTitleWord ="Nutella";
//
//        softAssert.assertTrue(actualTitle.contains(expectedTitleWord));

        // verify that you searched for nutella

        String expectedResultWord = "nutella";
        String actualResultText = amazonPage.amazonResultText.getText();

        softAssert.assertTrue(actualResultText.contains(expectedResultWord));

        // search for java
        amazonPage.amazonSearchBox.clear();
        amazonPage.amazonSearchBox.sendKeys("java"+Keys.ENTER);

        // verify that there are more than 1000 results
        String actualResultTextForJava = amazonPage.amazonResultText.getText();
        System.out.println(actualResultTextForJava); // 1-48 of over 4,000 results for "java"

        // we need to reach 4000 and assign it to an integeger

        String[] arr = actualResultTextForJava.split(" ");
        String numberStr = arr[3].replace(",","");   //4,000   >>>>>  4000
        System.out.println(numberStr);

        int resultNumber = Integer.valueOf(numberStr);  //4000

        softAssert.assertTrue(resultNumber>1000);

         softAssert.assertAll();


         ReusableMethods.waitFor(3); // same methods // I would prefer creating method where I am planing to call
                    // it. So intelij will automatically arrange all data types.
         ReusableMethods.waitfor2(3); // same methods


        Driver.closeDriver();


        // we are using POM in this test
        // we have created an object from amazonPage and we have used this object to reach located elements
        // From Driver class we have used getDriver method
        // ReusableMethods, we called waitFor() method
        // also we have created an object from SoftAssert class to verify tests


        // When we create a static method or variable, we can reach it by using the class name
        // like Driver.getDriver() method
        // If the method or variable is not static, we have to create an object from the class

        // if the method named getDriver() was not static, to reach it we had to creat an object from Driver class
//        Driver driver = new Driver();
//        driver.getDriver();




    }
}
