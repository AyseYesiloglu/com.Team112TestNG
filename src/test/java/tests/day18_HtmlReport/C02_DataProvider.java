package tests.day18_HtmlReport;

import org.openqa.selenium.Keys;
import org.openqa.selenium.devtools.v85.network.model.DataReceived;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_DataProvider {



    /*
    to execute same test with a lot of different data, we can use @DataProvider

    we should create the test according to the data provider

    1) we should add parameters for changable data values
    2) after the @Test annotation we should add (dataProvider = "theValue")
    3) then we should create a method to provide data (we can right click on the data provider value to create it)
    4) we should enter all the data in a two-dimensional object array and we should return the array

     */

    @DataProvider
    public static Object[][] wordsToSearchInAmazon() {

        Object[][] wordsToSearchInAmazonArray ={ {"Nutella"},{"Java"},{"Apple"},{"Samsung"},{"GPU"}};

        return wordsToSearchInAmazonArray;
    }


    // search for nutella in amazon.com and test it

    @Test(dataProvider = "wordsToSearchInAmazon")
    public void test(String wordToSearch){

        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        AmazonPage amazonPage = new AmazonPage();

        amazonPage.amazonSearchBox.sendKeys(wordToSearch+ Keys.ENTER); // search for nutella

        String expectedWord = wordToSearch;
        String actualResultText = amazonPage.amazonResultText.getText();

        Assert.assertTrue(actualResultText.contains(expectedWord));

        Driver.closeDriver();

    }


}
