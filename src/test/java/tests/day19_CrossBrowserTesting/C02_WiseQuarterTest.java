package tests.day19_CrossBrowserTesting;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseCross;

public class C02_WiseQuarterTest extends TestBaseCross {

    // go to the https://wisequarter.com

    // test that you are in wiseQuarter website


    @Test
    public void test(){
        // go to the https://wisequarter.com
        driver.get("https://wisequarter.com");

        // test that you are in wiseQuarter website
        String actualUrl = driver.getCurrentUrl();
        String expectedUrlWord = "wisequarter";

        Assert.assertTrue(actualUrl.contains(expectedUrlWord));


    }

}
