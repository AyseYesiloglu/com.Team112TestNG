package tests.day16_POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualityDemyPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C02_NegativeLoginTest {

    QualityDemyPage qualityDemyPage ;
    /*
    if you are planin to use same object in different test methods you have to reassing it in each test methods
     */

    @Test (priority = 1)
    public void unvalidEmailTest(){

        // let's test the system with invalid Email and valid password

        qualityDemyPage = new QualityDemyPage();

        // we created this object to be able to reach class nonstatic variables like located webelements

        Driver.getDriver().get("https://www.qualitydemy.com/");

        //2) click login button
        qualityDemyPage.homePageSignInButton.click();

        //3) enter a valid email in emailTextBox  (valid email : a@a.com )
        qualityDemyPage.loginPageEmailTextBox.sendKeys("a@a.com");

        //4) enter a Invalid password in passwordTextBox ( asdfasdfasdfAz. )
        qualityDemyPage.loginPagePasswordTextBox.sendKeys("asdfasdfasdfAz.");

        //5) click login button
        qualityDemyPage.loginPageLoginButton.click();

        //6) test that user Should not be able to login
        Assert.assertTrue(qualityDemyPage.enterYourCredText.isDisplayed());


        Driver.closeDriver();


    }


    @Test (priority = 2)
    public void unvalidPasswordTest(){

        // let's try to test the system with valid Email and invalid password

        qualityDemyPage = new QualityDemyPage();

        Driver.getDriver().get("https://www.qualitydemy.com/");

        //2) click login button
        qualityDemyPage.homePageSignInButton.click();

        //3) enter a Invalid email in emailTextBox  (valid email : qwerhfgdyuit@a.com )
        qualityDemyPage.loginPageEmailTextBox.sendKeys("qwerhfgdyuit@a.com");

        //4) enter a valid password in passwordTextBox ( Az.123123123 )
        qualityDemyPage.loginPagePasswordTextBox.sendKeys("Az.123123123");

        //5) click login button
        qualityDemyPage.loginPageLoginButton.click();

        //6) test that user Should not be able to login
        Assert.assertTrue(qualityDemyPage.enterYourCredText.isDisplayed());


        Driver.closeDriver();



    }


    @Test(priority = 3)
    public void invalidEmailAndInvalidPasswordTest(){

        qualityDemyPage = new QualityDemyPage();

        // let's try to test the system with Invalid Email and invalid password

        qualityDemyPage = new QualityDemyPage();

        Driver.getDriver().get("https://www.qualitydemy.com/");

        //2) click login button
        qualityDemyPage.homePageSignInButton.click();

        //3) enter a Invalid email in emailTextBox  (Invalid email : qwerhfgdyuit@a.com )
        qualityDemyPage.loginPageEmailTextBox.sendKeys("qwerhfgdyuit@a.com");

        //4) enter a Invalid password in passwordTextBox ( Az.aasdf345345 )
        qualityDemyPage.loginPagePasswordTextBox.sendKeys("Az.aasdf345345");

        //5) click login button
        qualityDemyPage.loginPageLoginButton.click();

        //6) test that user Should not be able to login
        Assert.assertTrue(qualityDemyPage.enterYourCredText.isDisplayed());


        Driver.closeDriver();


    }
}
