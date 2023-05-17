package tests.day16_POM;

import org.openqa.selenium.devtools.v85.network.model.DataReceived;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualityDemyPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_PositiveLoginTestWithConfPro {

    @Test(groups = "smoke")
    public void positiveLoginTest(){
        // 1) go to the "https://www.qualitydemy.com/
        /*
        2) click login button
        3) enter a valid email in emailTextBox  (valid email : a@a.com )
        4) enter a valid password in passwordTextBox ( Az.123123123 )
        5) click login button
        6) test that user could be able to login


         */

        QualityDemyPage qualityDemyPage = new QualityDemyPage();

        // 1) go to the "https://www.qualitydemy.com/

        Driver.getDriver().get(ConfigReader.getProperty("qualityDemyUrl"));

        //2) click login button
        qualityDemyPage.homePageSignInButton.click();

        //3) enter a valid email in emailTextBox  (valid email : a@a.com )
        qualityDemyPage.loginPageEmailTextBox.sendKeys(ConfigReader.getProperty("qualityDemyValidEmail"));

        //4) enter a valid password in passwordTextBox ( Az.123123123 )
        qualityDemyPage.loginPagePasswordTextBox.sendKeys(ConfigReader.getProperty("qualityDemyValidPassword"));

        //5) click login button
        qualityDemyPage.loginPageLoginButton.click();

        //6) test that user could be able to login
        Assert.assertTrue(qualityDemyPage.userHomePageMyCoursesButton.isDisplayed());

        Driver.closeDriver();

    }
}
