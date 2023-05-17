package tests.day16_POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualityDemyPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C04_NegativeLoginTestWithConfPro {

    @Test(groups = "smoke")
    public void invalidEmailAndValidPasswordLoginTest(){

        QualityDemyPage qualityDemyPage = new QualityDemyPage();

        // 1) go to the "https://www.qualitydemy.com/

        Driver.getDriver().get(ConfigReader.getProperty("qualityDemyUrl"));

        //2) click login button
        qualityDemyPage.homePageSignInButton.click();

        //3) enter a Invalid email in emailTextBox  (valid email : a@a.com )
        qualityDemyPage.loginPageEmailTextBox.sendKeys(ConfigReader.getProperty("qualityDemyInValidEmail"));

        //4) enter a valid password in passwordTextBox ( Az.123123123 )
        qualityDemyPage.loginPagePasswordTextBox.sendKeys(ConfigReader.getProperty("qualityDemyValidPassword"));

        //5) click login button
        qualityDemyPage.loginPageLoginButton.click();

        //6) test that user should not be able to login
        Assert.assertTrue(qualityDemyPage.enterYourCredText.isDisplayed());

        Driver.closeDriver();
    }


    @Test(groups = "smoke")
    public void validEmailAndInvalidPasswordLoginTest(){

        QualityDemyPage qualityDemyPage = new QualityDemyPage();

        // 1) go to the "https://www.qualitydemy.com/

        Driver.getDriver().get(ConfigReader.getProperty("qualityDemyUrl"));

        //2) click login button
        qualityDemyPage.homePageSignInButton.click();

        //3) enter a valid email in emailTextBox  (valid email : a@a.com )
        qualityDemyPage.loginPageEmailTextBox.sendKeys(ConfigReader.getProperty("qualityDemyValidEmail"));

        //4) enter a Invalid password in passwordTextBox ( Az.123123123 )
        qualityDemyPage.loginPagePasswordTextBox.sendKeys(ConfigReader.getProperty("qualityDemyInValidPassword"));

        //5) click login button
        qualityDemyPage.loginPageLoginButton.click();

        //6) test that user should not be able to login
        Assert.assertTrue(qualityDemyPage.enterYourCredText.isDisplayed());

        Driver.closeDriver();
    }


    @Test(groups = "smoke")
    public void InvalidEmailAndInvalidPasswordLoginTest(){

        QualityDemyPage qualityDemyPage = new QualityDemyPage();

        // 1) go to the "https://www.qualitydemy.com/

        Driver.getDriver().get(ConfigReader.getProperty("qualityDemyUrl"));

        //2) click login button
        qualityDemyPage.homePageSignInButton.click();

        //3) enter an Invalid email in emailTextBox  (valid email : a@a.com )
        qualityDemyPage.loginPageEmailTextBox.sendKeys(ConfigReader.getProperty("qualityDemyInValidEmail"));

        //4) enter an Invalid password in passwordTextBox ( Az.123123123 )
        qualityDemyPage.loginPagePasswordTextBox.sendKeys(ConfigReader.getProperty("qualityDemyInValidPassword"));

        //5) click login button
        qualityDemyPage.loginPageLoginButton.click();

        //6) test that user should not be able to login
        Assert.assertTrue(qualityDemyPage.enterYourCredText.isDisplayed());

        Driver.quitDriver();
    }



}
