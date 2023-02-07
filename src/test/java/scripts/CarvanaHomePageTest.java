package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.CarvanaHomePage;
import pages.CarvanaSearchCarPage;
import utilities.TestData;
import utilities.Waiter;
import utilities.WindowHandler;

public class CarvanaHomePageTest extends CarvanaBase {

    @BeforeMethod
    public void setPage() {
        carvanaHomePage = new CarvanaHomePage();
        carvanaSearchCarPage = new CarvanaSearchCarPage();
    }

    /**
     * Test Case 1: Test name = Validate Carvana home page title and url
     * Test priority = 1
     * Given user is on "https://www.carvana.com/"
     * Then validate title equals  "Carvana | Buy & Finance Used Cars Online | At Home Delivery"
     * And validate url equals  "https://www.carvana.com/"
     */

    @Test(priority = 1, description = "Validate Carvana home page title and url")
    public void validateTitleAndURL() {
        Assert.assertEquals(driver.getTitle(), TestData.expectedTitle);
        Assert.assertEquals(driver.getCurrentUrl(), TestData.expectedURL);
    }

    /**
     * Test Case 2: Test name = Validate the Carvana logo
     * Test priority = 2
     * Given user is on "https://www.carvana.com/"
     * Then validate the logo of the “Carvana” is displayed
     */

    @Test(priority = 2, description = "Validate the Carvana logo")
    public void validatingCarvanaLogo() {
        for (int i = 0; i <= 2; i++) {
            try {
                Assert.assertTrue(carvanaHomePage.carvanaLogo.isDisplayed());
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Test Case 3: Test name = Validate the main navigation section items
     * Test priority = 3
     * Given user is on "https://www.carvana.com/"
     * Then validate the navigation section items below are displayed
     * |HOW IT WORKS      |
     * |ABOUT CARVANA     |
     * |SUPPORT & CONTACT |
     */
    @Test(priority = 3, description = "Validate the main navigation section items")
    public void validateMainNavigationSection() {

        for (int i = 0; i < carvanaHomePage.carvanaNavigationSection.size(); i++) {
            Assert.assertTrue(carvanaHomePage.carvanaNavigationSection.get(i).isDisplayed());
            Assert.assertEquals(TestData.expectedText[i], carvanaHomePage.carvanaNavigationSection.get(i).getText());
        }
    }

    /**
     * Test Case 4: Test name = Validate the sign in error message
     * Test priority = 4
     * Given user is on "https://www.carvana.com/"
     * When user clicks on “SIGN IN” button
     * Then user should be navigated to “Sign in” modal
     * When user enters email as johndoe   @gmail.com
     * And user clicks on "CONTINUE" button
     * And user enters password as "abcd1234"
     * And user clicks on "SIGN IN" button
     * Then user should see error message as "Email address and/or password combination is incorrect.
     */

    @Test(priority = 4, description = "Validate the sign in error message")
    public void validateSignInErrorMessage() {
        carvanaHomePage.signInButton.click();
        WindowHandler.switchToChildWindow();
        carvanaHomePage.email.sendKeys(TestData.invalidEmail);
        carvanaHomePage.continueButton.click();
        carvanaHomePage.password.sendKeys(TestData.invalidPassword);
        carvanaHomePage.signInButtonEnd.click();
        Assert.assertTrue(carvanaHomePage.errorMessage.isDisplayed());
        Assert.assertEquals(carvanaHomePage.errorMessage.getText(), TestData.expectedError);
    }

    /**
     * Test Case 5: Test name = Validate the search filter options and search button
     * Test priority = 5
     * Given user is on "https://www.carvana.com/"
     * When user clicks on "SEARCH CARS" link
     * Then user should be routed to "https://www.carvana.com/cars"
     * And user should see filter options
     * |PAYMENT & PRICE      |
     * |MAKE & MODEL      |
     * |BODY TYPE |
     * |YEAR & MILEAGE      |
     * |FEATURES      |
     * |MORE FILTERS
     */

    @Test(priority = 5, description = "Validate the search filter options and search button")
    public void validateFilterOptions() {
        carvanaHomePage.searchCarsButton.click();
        softAssert.assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/cars");
        for (int i = 0; i < TestData.expectedText2.length; i++) {
            softAssert.assertTrue(carvanaSearchCarPage.filterOptions.get(i).isDisplayed());
            softAssert.assertEquals(carvanaSearchCarPage.filterOptions.get(i).getText(), TestData.expectedText2[i]);
        }
    }

    /**
     * Test Case 6: Test name = Validate the search result tiles
     * Test priority = 6
     * Given user is on "https://www.carvana.com/"
     * When user clicks on "SEARCH CARS" link
     * Then user should be routed to "https://www.carvana.com/cars"
     * When user enters "mercedes-benz" to the search input box
     * And user clicks on "GO" button in the search input box
     * Then user should see "mercedes-benz" in the url
     * And validate each result tile
     * VALIDATION OF EACH TILE INCLUDES BELOW
     * Make sure each result tile is displayed with below information
     * 1. an image
     * 2. add to favorite button
     * 3. tile body
     * ALSO VALIDATE EACH TILE BODY:
     * Make sure each tile body has below information
     * 1. Inventory type - text should be displayed and should not be null or empty
     * 2. Year-Make-Model information - text should be displayed and should not be null or empty
     * 3. Trim-Mileage information - text should be displayed and should not be null or empty
     * 4. Price - Make sure that each price is more than zero
     * 5. Monthly Payment information - text should be displayed and should not be null or empty
     * 6. Down Payment information - text should be displayed and should not be null or empty
     * 7. Delivery chip must be displayed, and text is not null or empty
     */

    @Test(priority = 6, description = "Validate the search result tiles")
    public void validateSearchResults() {
        carvanaHomePage.searchCarsButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/cars");
        carvanaSearchCarPage.searchCarInput.sendKeys(TestData.searchCar);
        carvanaSearchCarPage.goButton.click();

        Waiter.pause(2);
        Assert.assertTrue(driver.getCurrentUrl().contains(TestData.searchCar));
        for (int i = 0; i < carvanaSearchCarPage.carImages.size(); i++) {
            Assert.assertTrue(carvanaSearchCarPage.carImages.get(i).isDisplayed());
            Assert.assertTrue(carvanaSearchCarPage.favoriteButton.get(i).isDisplayed());
            Assert.assertTrue(carvanaSearchCarPage.inventoryType.get(i).isDisplayed());
            Assert.assertFalse(carvanaSearchCarPage.inventoryType.get(i).getText().isEmpty());
            Assert.assertTrue(carvanaSearchCarPage.yearMakeModel.get(i).isDisplayed());
            Assert.assertFalse(carvanaSearchCarPage.yearMakeModel.get(i).getText().isEmpty());
            Assert.assertTrue(carvanaSearchCarPage.trimMileage.get(i).isDisplayed());
            Assert.assertFalse(carvanaSearchCarPage.trimMileage.get(i).getText().isEmpty());
            Assert.assertTrue(Integer.parseInt(carvanaSearchCarPage.carPrice.get(i).getText().substring(1).replaceAll(",", "")) > 0);
            Assert.assertTrue(carvanaSearchCarPage.monthlyPayment.get(i).isDisplayed());
            Assert.assertFalse(carvanaSearchCarPage.monthlyPayment.get(i).getText().isEmpty());
            Assert.assertTrue(carvanaSearchCarPage.downPayment.get(i).isDisplayed());
            Assert.assertFalse(carvanaSearchCarPage.downPayment.get(i).getText().isEmpty());
            Assert.assertTrue(carvanaSearchCarPage.deliveryChip.get(i).isDisplayed());
            Assert.assertFalse(carvanaSearchCarPage.deliveryChip.get(i).getText().isEmpty());
        }
    }
}

