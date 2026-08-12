/**
 * @author AnjaliChowdhary
 **/

package AnjaliTestCases;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.swiggy.BaseclassUtility.BaseClass;
import com.swiggy.ListenerUtility.ListenerUtility;
import com.swiggy.ObjectRepo.CartPage;
import com.swiggy.ObjectRepo.HomePage;
import com.swiggy.ObjectRepo.ProductPage;
import com.swiggy.WebDriverUtility.UtilityClassObject;
import com.swiggy.WebDriverUtility.WebDriverutility;
@Listeners(ListenerUtility.class)
public class IntegrationTestCases extends BaseClass {

	@Test(groups="IntegrationTest")
	public void verifySearchToProductDetails() {

		HomePage homePage = new HomePage(driver);
		ProductPage productPage = new ProductPage(driver);

		homePage.getSrchTxtBx().sendKeys("Lakme lipstick");

		homePage.getSrchTxtBx().submit();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement product = wait.until(ExpectedConditions.elementToBeClickable(productPage.getFirstPrct()));

		product.click();

		wait.until(ExpectedConditions.urlContains("nykaa"));

		Assert.assertTrue(driver.getCurrentUrl().contains("nykaa"), "Product details page was not opened");
	}

	@Test(groups="IntegrationTest")
	public void verifyAddToBag() {

		HomePage homePage = new HomePage(driver);
		ProductPage productPage = new ProductPage(driver);

		UtilityClassObject.getTest().log(Status.INFO, "Search product");
		homePage.getSrchTxtBx().sendKeys("Lakme lipstick");

		homePage.getSrchTxtBx().submit();

		UtilityClassObject.getTest().log(Status.INFO, "Store parent window");
		String parentWindow = driver.getWindowHandle();

		UtilityClassObject.getTest().log(Status.INFO," Click first product");
		productPage.getFirstPrct().click();

		UtilityClassObject.getTest().log(Status.INFO," Wait until new window opens");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(ExpectedConditions.numberOfWindowsToBe(2));

		UtilityClassObject.getTest().log(Status.INFO," Switch to new window");
		Set<String> windows = driver.getWindowHandles();

		for (String window : windows) {

			if (!window.equals(parentWindow)) {
				driver.switchTo().window(window);
				break;
			}
		}

		UtilityClassObject.getTest().log(Status.INFO," Now we are in Product Details window");

		WebElement addToBag = wait.until(ExpectedConditions.visibilityOf(productPage.getaddToBag()));

		UtilityClassObject.getTest().log(Status.INFO,"Scroll to Add To Bag");
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView({block:'center'});", addToBag);

		UtilityClassObject.getTest().log(Status.INFO,"Wait until clickable");
		wait.until(ExpectedConditions.elementToBeClickable(addToBag));

		UtilityClassObject.getTest().log(Status.INFO,"Click Add To Bag");
		addToBag.click();

		UtilityClassObject.getTest().log(Status.INFO," Verify the result");
		Assert.assertTrue(driver.getPageSource().toLowerCase().contains("bag"), "Product was not added to bag");
	}
	
	@Test(groups="IntegrationTest")
			public void clickToCartIcon() throws Exception {
		HomePage homePage = new HomePage(driver);

		ProductPage productPage = new ProductPage(driver);

		CartPage cartPage = new CartPage(driver);
		WebDriverutility wlib = new WebDriverutility();
		UtilityClassObject.getTest().log(Status.INFO," searching the product ");
		homePage.getSrchTxtBx().sendKeys("Lakme lipstick");
		homePage.getSrchTxtBx().click();
		UtilityClassObject.getTest().log(Status.INFO,"clicking on First link of the product ");
		productPage.getFirstPrct().click();
		UtilityClassObject.getTest().log(Status.INFO," switching window ");
		wlib.switchtoTabonTitle(driver, "lakme-forever-matte");
		UtilityClassObject.getTest().log(Status.INFO," add to bag ");
		productPage.getaddToBag().click();
		UtilityClassObject.getTest().log(Status.INFO,"clicking on cart button");
		cartPage.clickCart();

		UtilityClassObject.getTest().log(Status.INFO,"verifying the result ");
		Assert.assertTrue(cartPage.getshpbag().isDisplayed(), "Product is not displayed in cart");
	}
	
	@Test(groups = "IntegrationTest")
	public void verifySwitchBackToParentWindow() {

		HomePage homePage = new HomePage(driver);
		ProductPage productPage = new ProductPage(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		homePage.getSrchTxtBx().sendKeys("Lakme lipstick");

		homePage.getSrchTxtBx().submit();

		String parentWindow = driver.getWindowHandle();

		productPage.getFirstPrct().click();

		wait.until(ExpectedConditions.numberOfWindowsToBe(2));

		UtilityClassObject.getTest().log(Status.INFO,"Switch to new window ");
		for (String window : driver.getWindowHandles()) {

			if (!window.equals(parentWindow)) {
				driver.switchTo().window(window);
				break;
			}
		}

		UtilityClassObject.getTest().log(Status.INFO," Verify we are in new window ");
		Assert.assertNotEquals(driver.getWindowHandle(), parentWindow, "New product window was not opened");

		UtilityClassObject.getTest().log(Status.INFO," Switch back");
		driver.switchTo().window(parentWindow);

		Assert.assertEquals(driver.getWindowHandle(), parentWindow, "Could not switch back to parent window");
	}
	
	@Test(groups = "IntegrationTest")
	public void verifyScrollAndAddToBag() {

		HomePage homePage = new HomePage(driver);
		ProductPage productPage = new ProductPage(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		UtilityClassObject.getTest().log(Status.INFO, "search the produc");
		homePage.getSrchTxtBx().sendKeys("Lakme lipstick");

		homePage.getSrchTxtBx().submit();

		String parentWindow = driver.getWindowHandle();

		UtilityClassObject.getTest().log(Status.INFO, "Open product");
		productPage.getFirstPrct().click();

		wait.until(ExpectedConditions.numberOfWindowsToBe(2));

		UtilityClassObject.getTest().log(Status.INFO, "Switch window");
		for (String window : driver.getWindowHandles()) {

			if (!window.equals(parentWindow)) {
				driver.switchTo().window(window);
				break;
			}
		}

		UtilityClassObject.getTest().log(Status.INFO, "Locate Add to Bag");
		WebElement addToBag = wait.until(ExpectedConditions.visibilityOf(productPage.getaddToBag()));

		UtilityClassObject.getTest().log(Status.INFO, "Scroll");
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView({block:'center'});", addToBag);

		UtilityClassObject.getTest().log(Status.INFO, "Click to bag");
		wait.until(ExpectedConditions.elementToBeClickable(addToBag)).click();

		Assert.assertTrue(driver.getPageSource().toLowerCase().contains("bag"), "Add to Bag operation failed");
	}

}
