package tests.day18_HtmlReport;

import org.openqa.selenium.devtools.v85.network.model.DataReceived;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.QualityDemyPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.io.ObjectInputFilter;

public class C03_DataProviderNegativeLoginTest {


    // 1) go to the QualityDemy homepage
    // 2) enter wrong password and username
    // 3) test that user can not login
    /*
    // username     password
    // A11          A12345
    // B12          B12345
    // C13          C12345
    // D14          D12345
    // E15          E12345
     */


    @DataProvider
    public static Object[][] provideUsernameAndPassword() {

        Object[][] usernameAndPassword ={{"A11","A12345"},{"B12","B12345"},{"C13","C12345"} ,{"D14","D12345"},{"E15","E12345"}   };

        return usernameAndPassword;
    }


    @Test(dataProvider = "provideUsernameAndPassword")
    public void test(String username, String password){

        // 1) go to the QualityDemy homepage
        Driver.getDriver().get(ConfigReader.getProperty("qualityDemyUrl"));

        // 2) enter wrong password and username
        QualityDemyPage qualityDemyPage = new QualityDemyPage();

        qualityDemyPage.homePageSignInButton.click();

        qualityDemyPage.loginPageEmailTextBox.sendKeys(username);
        qualityDemyPage.loginPagePasswordTextBox.sendKeys(password);

        qualityDemyPage.loginPageLoginButton.click();

        String actualText = qualityDemyPage.enterYourCredText.getText();
        String expectedText = "Provide your valid login credentials";

        Assert.assertEquals(actualText,expectedText);





    }




}
