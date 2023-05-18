package tests.day18_HtmlReport;

import org.openqa.selenium.Keys;
import org.openqa.selenium.devtools.v85.network.model.DataReceived;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class CO1_CreatingReport extends TestBaseRapor {

    /*
    To create report in TestNG

    1) add dependency com.aventstack  4.0.9
    2) extend the class to TestBaseRapor
    3) in the test class you should create the test by using objects from TestBaseRapor
    extentTest = extentReports.createTest("Amazon Nutella Test","User should be able to search for Nutella");

    4) write info for each step by using extentTest object
        - if it is not an assertion we should use extentTest.info method
        - if it is an assertion we should use extent.Test.pass method



     */


    @Test
    public void test01(){

        // 1) go to the amazon.com
        // 2) Search for nutella
        // 3) Test that result text has nutella

        extentTest = extentReports.createTest("Amazon Nutella Test","User should be able to search for Nutella");

        // 1) go to the amazon.com
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.info("User reached the website (amazon)");

        // 2) Search for nutella
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.amazonSearchBox.sendKeys(ConfigReader.getProperty("amazonWordToSearch")+ Keys.ENTER);
        extentTest.info("User searched for Nutella in amazon");

        // 3) Test that result text has nutella
        String expectedWord = ConfigReader.getProperty("amazonWordToSearch");
        String actualResultText = amazonPage.amazonResultText.getText();
        extentTest.info("System saved result text");

        Assert.assertTrue(actualResultText.contains(expectedWord));
        extentTest.pass("Tested that result text contains the word");



    }
}
