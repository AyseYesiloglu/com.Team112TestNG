package tests.day16_POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualityDemyPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_PositiveLoginTest {

    @Test(groups = {"reg2","smoke"})
    public void test01(){

        // 1) go to the "https://www.qualitydemy.com/
        /*
        2) click login button
        3) enter a valid email in emailTextBox  (valid email : a@a.com )
        4) enter a valid password in passwordTextBox ( Az.123123123 )
        5) click login button
        6) test that user could be able to login

         */
        // we created this object to be able to reach class nonstatic variables like located webelements
        QualityDemyPage qualityDemyPage = new QualityDemyPage();

        Driver.getDriver().get("https://www.qualitydemy.com/");

        //2) click login button
        qualityDemyPage.homePageSignInButton.click();

        ReusableMethods.waitFor(3);
        //3) enter a valid email in emailTextBox  (valid email : a@a.com )
        qualityDemyPage.loginPageEmailTextBox.sendKeys("a@a.com");

        //4) enter a valid password in passwordTextBox ( Az.123123123 )
        qualityDemyPage.loginPagePasswordTextBox.sendKeys("Az.123123123");

        //5) click login button
        qualityDemyPage.loginPageLoginButton.click();

        //6) test that user could be able to login
        Assert.assertTrue(qualityDemyPage.userHomePageMyCoursesButton.isDisplayed());

        Driver.closeDriver();



    }
}
