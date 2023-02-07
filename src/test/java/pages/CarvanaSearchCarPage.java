package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CarvanaSearchCarPage extends CarvanaBasePage {
    public CarvanaSearchCarPage() {
        super();
    }

    @FindBy(css = "div[data-qa= 'menu-flex']>button")
    public List<WebElement> filterOptions;

    @FindBy(css = "input[data-qa='search-bar-input']")
    public WebElement searchCarInput;

    @FindBy(css = "button[data-qa='go-button']")
    public WebElement goButton;

    @FindBy(css = "picture[data-qa='base-vehicle-image']")
    public List<WebElement> carImages;

    @FindBy(css = "svg[data-qa='favorite-icon']")
    public List<WebElement> favoriteButton;

    @FindBy(css = "div[data-qa='inventory-type-experiment']")
    public List<WebElement> inventoryType;

    @FindBy(css = "div[data-qa='make-model']")
    public List<WebElement> yearMakeModel;

    @FindBy(css = "div[data-qa='trim-mileage']")
    public List<WebElement> trimMileage;

    @FindBy(css = "div[data-qa='price']")
    public List<WebElement> carPrice;

    @FindBy(css = "div[data-qa='monthly-payment']")
    public List<WebElement> monthlyPayment;

    @FindBy(className = "down-payment")
    public List<WebElement> downPayment;

    @FindBy(css = "div[class='tk-pane full-width']:nth-child(2)")
    public List<WebElement> deliveryChip;
}
