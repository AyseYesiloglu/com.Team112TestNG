package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class QualityDemyPage {

    public QualityDemyPage(){

        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "//a[text()='Log in']")
    public WebElement homePageSignInButton;

    @FindBy(id = "login-email")
    public WebElement loginPageEmailTextBox;

    @FindBy(id = "login-password")
    public WebElement loginPagePasswordTextBox;

    @FindBy(xpath = "//button[@class='btn red radius-5 mt-4 w-100']")
    public WebElement loginPageLoginButton;

    @FindBy(xpath = "//a[text()='My courses']")
    public WebElement userHomePageMyCoursesButton;

    @FindBy(xpath = "//p[text()='Provide your valid login credentials']")
    public WebElement enterYourCredText;


}
