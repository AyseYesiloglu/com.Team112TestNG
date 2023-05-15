package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonPage {

    // we will locate our webelements in this class and to use them we will call then from here

    // to use a page class we need to create a constructor witout any parameters

    public AmazonPage() {

        PageFactory.initElements(Driver.getDriver(), this);

    }


    @FindBy (id="twotabsearchtextbox")
    public WebElement amazonSearchBox;

    @FindBy(xpath = "//div[@class='sg-col-14-of-20 sg-col-18-of-24 sg-col s-breadcrumb sg-col-10-of-16 sg-col-6-of-12']")
    public WebElement amazonResultText;

    @FindBy(xpath = "//div[@class='a-section a-spacing-base']")
    public WebElement firstProductOfSearch;

    @FindBy(xpath = "//span[@class='a-size-medium product-title-word-break product-title-resize']")
    public WebElement ProductTitle;


}
