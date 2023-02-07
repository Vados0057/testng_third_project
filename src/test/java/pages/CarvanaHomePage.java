package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CarvanaHomePage extends CarvanaBasePage{
    public CarvanaHomePage(){
        super();
    }

    @FindBy(css = "div[data-qa='logo-wrapper']")
    public WebElement carvanaLogo;

    @FindBy(css = "div[data-qa='menu-wrapper']")
    public List<WebElement> carvanaNavigationSection;

    @FindBy(css = "div[data-qa='sign-in-wrapper']")
    public WebElement signInButton;

    @FindBy(id = "email")
    public WebElement email;

    @FindBy(css = "button[data-qa='enter-email-submit']")
    public WebElement continueButton;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(css = "button[data-qa='sign-in-submit']")
    public WebElement signInButtonEnd;

    @FindBy(id = "error-banner")
    public WebElement errorMessage;

    @FindBy(css ="a[data-cv-test='headerSearchLink']")
    public WebElement searchCarsButton;

}
