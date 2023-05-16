package tests.day15_hard_soft_assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ZeroPage;
import utilities.Driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C04_SoftAssert {

    @Test
    public void test01(){

        //Create a New Class: C03_SoftAssert
        //1. Go to “http://zero.webappsecurity.com/”
        //2. Press the Sign in button
        //3. Type “username” in the login box
        //4. Type “password” in the Password box
        //5. Press the Sign in button
        //6. Go to the Pay Bills page in the online banking menu
        //7. Press the “Purchase Foreign Currency” key
        //8. Select Eurozone from the “Currency” drop down menu
        //9. Test that "Eurozone (euro)" is selected using soft assert
        /*
        10. Test that the DropDown list has these options using soft assert "Select One",
        "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)",
        "Denmark (krone) ","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)",
        "Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand ( dollar)","Sweden (krona)",
        "Singapore (dollar)","Thailand (baht)"
         */

        ZeroPage zeroPage = new ZeroPage();

        //1. Go to “http://zero.webappsecurity.com/”
        Driver.getDriver().get("http://zero.webappsecurity.com/");

        //2. Press the Sign in button
        zeroPage.signInButton.click();

        //3. Type “username” in the login box
        zeroPage.loginPageUserTextBox.sendKeys("username");

        //4. Type “password” in the Password box
        zeroPage.loginPagePasswordTextBox.sendKeys("password");

        //5. Press the Sign in button
        zeroPage.loginPageSignInButton.click();
        Driver.getDriver().navigate().back(); // page gives error, to fix it we navigated back

        //6. Go to the Pay Bills page in the online banking menu
        Driver.getDriver().findElement(By.xpath("//strong[text()='Online Banking']")).click();
        // if you are planing to use webElement only once, you can directly locate and click on it.
        zeroPage.payBillsButton.click();

        //7. Press the “Purchase Foreign Currency” tab
        zeroPage.foreignCurrency.click();

        //8. Select Eurozone from the “Currency” drop down menu
        Select select = new Select(zeroPage.payBillsCurrencyDropDown);// when we try to inspect the web element
        // we saw select tag, it means we are working on a dropdown menu. First we need to locate the webelement
        // then we should create a select object by using this element.

        //9. Test that "Eurozone (euro)" is selected using soft assert
        select.selectByVisibleText("Eurozone (euro)");

        /*
               10. Test that the DropDown list has these options using soft assert
               "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)",
        "Denmark (krone) ","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)",
        "Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand ( dollar)","Sweden (krona)",
        "Singapore (dollar)","Thailand (baht)"
         */

        SoftAssert softAssert = new SoftAssert();

        List<WebElement> listOfDropDownOptions =select.getOptions();
        List<String> actualOptionsList = new ArrayList<>();

        String textOfEachWebElement=""; // not to create a lot of unused variables in a loop, we should create the variable
        // outside of the loop.

        for (WebElement eachOptionWebElement: listOfDropDownOptions
             ) {
            textOfEachWebElement = eachOptionWebElement.getText();
            actualOptionsList.add(textOfEachWebElement);

        }

        String[] arr = {"Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)",
                "Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)",
                "Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)",
                "Singapore (dollar)","Thailand (baht)"};

        List<String> expectedOptionList = Arrays.asList(arr);

        softAssert.assertEquals(actualOptionsList,expectedOptionList);

        softAssert.assertAll();

        Driver.closeDriver();












    }
}
