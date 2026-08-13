/**
 * @author AnjaliChowdhary
 **/

package AnjaliTestCases;

import java.time.Duration;

import org.openqa.selenium.By;
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
import com.swiggy.ObjectRepo.HomePage_Nykaa;
import com.swiggy.ObjectRepo.ProductPage;
import com.swiggy.WebDriverUtility.UtilityClassObject;
import com.swiggy.WebDriverUtility.WebDriverutility;

@Listeners(ListenerUtility.class)
public class EndToEndTestCases extends BaseClass {
	WebDriverutility wlib = new WebDriverutility();

	@Test
	public void verifySearchToProductDetails() {

		HomePage_Nykaa homePage = new HomePage_Nykaa(driver);
		ProductPage productPage = new ProductPage(driver);
		UtilityClassObject.getTest().log(Status.INFO, "Search product");
		homePage.getSrchTxtBx().sendKeys("Lakme lipstick");
		homePage.getSrchTxtBx().submit();
		UtilityClassObject.getTest().log(Status.INFO, "Scroll using javascript");
		WebElement product = wlib.waitForElementToClickable(driver, productPage.getFirstPrct());

		product.click();
		UtilityClassObject.getTest().log(Status.INFO, "verifying expected with actual result");
		Assert.assertTrue(driver.getCurrentUrl().contains("nykaa"), "Product details page was not opened");
	}

	@Test(groups = "EndToEnd")
	public void verifyIncreaseProductQuantity() throws Exception {

		HomePage_Nykaa homePage = new HomePage_Nykaa(driver);
		ProductPage productPage = new ProductPage(driver);
		CartPage cartPage = new CartPage(driver);
		UtilityClassObject.getTest().log(Status.INFO, "Search product");
		homePage.getSrchTxtBx().sendKeys("Lakme lipstick");
		homePage.getSrchTxtBx().submit();

		productPage.getFirstPrct().click();
		UtilityClassObject.getTest().log(Status.INFO, "checking all windows");
		wlib.noOfWindows(driver, 2);
		UtilityClassObject.getTest().log(Status.INFO, "Switching to child window");
		wlib.switchingToChildWindow(driver);
		UtilityClassObject.getTest().log(Status.INFO, "Scrolling through javascrit");
		wlib.waitForElementToClickable(driver, productPage.getaddToBag()).click();
		UtilityClassObject.getTest().log(Status.INFO, "clicking on cart page");
		cartPage.clickCart();
		UtilityClassObject.getTest().log(Status.INFO, "clicking on dropdown in cart page");
		wlib.waitForElementToClickable(driver, cartPage.getdropdwnBtn()).click();

		wlib.waitForElementPresent(driver, cartPage.getIncreaseQty());
		wlib.waitForElementToClickable(driver, cartPage.getIncreaseQty()).click();
		wlib.waitForElementPresent(driver, driver.findElement(By.xpath("//p[@data-test-id=\"product-quantity-text\"]")));

		UtilityClassObject.getTest().log(Status.INFO,"Verify the quantity displayed after dropdown closes");
		String actualQty = driver.findElement(By.xpath("//p[@data-test-id=\"product-quantity-text\"]")).getText();
		UtilityClassObject.getTest().log(Status.INFO,"verifying the result");
		Assert.assertTrue(actualQty.contains("2"), "Quantity could not be increased");

	}

	@Test(groups = "EndToEnd")
	public void verifySearchToCartFlow() {

		HomePage_Nykaa homePage = new HomePage_Nykaa(driver);

		ProductPage productPage = new ProductPage(driver);

		CartPage cartPage = new CartPage(driver);
		UtilityClassObject.getTest().log(Status.INFO,"serach for product");
		homePage.getSrchTxtBx().sendKeys("Lakme lipstick");

		homePage.getSrchTxtBx().submit();

		wlib.waitForElementToClickable(driver, productPage.getFirstPrct()).click();
		UtilityClassObject.getTest().log(Status.INFO,"checking all windows");
		wlib.noOfWindows(driver, 2);
		UtilityClassObject.getTest().log(Status.INFO,"switching to child window");
		wlib.switchingToChildWindow(driver);
		UtilityClassObject.getTest().log(Status.INFO,"clicking on add to bag");
		wlib.waitForElementToClickable(driver, productPage.getaddToBag()).click();
		UtilityClassObject.getTest().log(Status.INFO,"clicking on cart button");
		cartPage.clickCart();
		UtilityClassObject.getTest().log(Status.INFO,"verifying the result");
		Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("nykaa"), "Cart page was not opened");
	}

	@Test(groups = "EndToEnd")
	public void verifyCompleteShoppingBagFlow() {

		HomePage_Nykaa homePage = new HomePage_Nykaa(driver);

		ProductPage productPage = new ProductPage(driver);

		CartPage cartPage = new CartPage(driver);
		UtilityClassObject.getTest().log(Status.INFO,"searching for product");
		homePage.getSrchTxtBx().sendKeys("Lakme lipstick");

		homePage.getSrchTxtBx().submit();
		UtilityClassObject.getTest().log(Status.INFO,"clicking on 1st product");
		productPage.getFirstPrct().click();
		UtilityClassObject.getTest().log(Status.INFO,"checking all windows");
		wlib.noOfWindows(driver, 2);
		UtilityClassObject.getTest().log(Status.INFO,"switching to child window");
		wlib.switchingToChildWindow(driver);

		WebElement addToBag = wlib.waitForElementToClickable(driver, productPage.getaddToBag());
		UtilityClassObject.getTest().log(Status.INFO,"scrolling using javascprit");
		wlib.scrollIntoViewUsingJavaScript(driver, addToBag);
		UtilityClassObject.getTest().log(Status.INFO,"clicking on add to bag");
		addToBag.click();
		UtilityClassObject.getTest().log(Status.INFO,"clicking on cart button");
		cartPage.clickCart();
		UtilityClassObject.getTest().log(Status.INFO,"verifying the result");
		Assert.assertTrue(cartPage.getshpbag().isDisplayed(), "Shopping bag was not displayed");
	}

	@Test(groups = "EndToEnd")
	public void verifyOpenCartAfterAddingProduct() {

		HomePage_Nykaa homePage = new HomePage_Nykaa(driver);

		ProductPage productPage = new ProductPage(driver);

		CartPage cartPage = new CartPage(driver);

		homePage.getSrchTxtBx().sendKeys("Lakme lipstick");

		homePage.getSrchTxtBx().submit();

		productPage.getFirstPrct().click();

		wlib.noOfWindows(driver, 2);

		wlib.switchingToChildWindow(driver);

		wlib.waitForElementToClickable(driver, productPage.getaddToBag()).click();

		cartPage.clickCart();

		Assert.assertTrue(cartPage.getshpbag().isDisplayed(), "Shopping bag is not displayed");
	}

	@Test(groups = "EndToEnd")
	public void verifySwitchBackToParentWindow() {

		HomePage_Nykaa homePage = new HomePage_Nykaa(driver);

		ProductPage productPage = new ProductPage(driver);

		homePage.getSrchTxtBx().sendKeys("Lakme lipstick");

		homePage.getSrchTxtBx().submit();

		String parentWindow = wlib.fetchingParentWindow(driver);

		productPage.getFirstPrct().click();
		System.out.println("Before wait: "
		        + driver.getWindowHandles().size());

		wlib.noOfWindows(driver, 2);
		System.out.println("after wait: "
		        + driver.getWindowHandles().size());

		wlib.switchingToChildWindow(driver);

		Assert.assertNotEquals(driver.getWindowHandle(), parentWindow, "Child window was not opened");

		driver.switchTo().window(parentWindow);

		Assert.assertEquals(driver.getWindowHandle(), parentWindow, "Unable to switch back to parent window");
	}

	@Test(groups = "EndToEnd")
	public void verifyCompleteCustomerShoppingJourney() {

		HomePage_Nykaa homePage = new HomePage_Nykaa(driver);

		ProductPage productPage = new ProductPage(driver);

		CartPage cartPage = new CartPage(driver);

		UtilityClassObject.getTest().log(Status.INFO," Search");
		homePage.getSrchTxtBx().sendKeys("Lakme lipstick");

		homePage.getSrchTxtBx().submit();

		UtilityClassObject.getTest().log(Status.INFO," Select Product");
		wlib.waitForElementToClickable(driver, productPage.getFirstPrct()).click();

		UtilityClassObject.getTest().log(Status.INFO," Switch to Child Window");
		wlib.noOfWindows(driver, 2);

		wlib.switchingToChildWindow(driver);

		UtilityClassObject.getTest().log(Status.INFO," Verify Product Page");
		Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("nykaa"), "Product page was not opened");

		UtilityClassObject.getTest().log(Status.INFO,"Scroll to Add To Bag");
		WebElement addToBag = wlib.waitForElementToClickable(driver, productPage.getaddToBag());

		wlib.scrollIntoViewUsingJavaScript(driver, addToBag);

		UtilityClassObject.getTest().log(Status.INFO,"Add Product");
		addToBag.click();

		UtilityClassObject.getTest().log(Status.INFO,"Verify Bag");
		Assert.assertTrue(driver.getPageSource().toLowerCase().contains("bag"), "Product was not added to bag");

		UtilityClassObject.getTest().log(Status.INFO,"Open Cart");
		cartPage.clickCart();

		UtilityClassObject.getTest().log(Status.INFO,"Verify Shopping Bag");
		wlib.waitForElementPresent(driver, cartPage.getshpbag());
		UtilityClassObject.getTest().log(Status.INFO,"verifying the result");
		Assert.assertTrue(cartPage.getshpbag().isDisplayed(), "Shopping bag is not displayed");
	}

	@Test(groups = "EndToEnd")
	public void verifyChildWindow() {

		HomePage_Nykaa homePage = new HomePage_Nykaa(driver);
		ProductPage productPage = new ProductPage(driver);

		homePage.getSrchTxtBx().sendKeys("Lakme lipstick");
		homePage.getSrchTxtBx().submit();
		UtilityClassObject.getTest().log(Status.INFO,"capturing the parent window");
		String parentWindow = wlib.fetchingParentWindow(driver);

		productPage.getFirstPrct().click();
		UtilityClassObject.getTest().log(Status.INFO,"verifying all windows");
		wlib.noOfWindows(driver, 2);
		UtilityClassObject.getTest().log(Status.INFO,"switching the child window");
		wlib.switchingToChildWindow(driver);
		UtilityClassObject.getTest().log(Status.INFO,"verifying the child window");
		Assert.assertNotEquals(driver.getWindowHandle(), parentWindow, "Child window was not opened");
	}

	@Test(groups = "EndToEnd")
	public void verifyCartAfterPageRefresh() {

		HomePage_Nykaa homePage = new HomePage_Nykaa(driver);
		ProductPage productPage = new ProductPage(driver);
		CartPage cartPage = new CartPage(driver);

		homePage.getSrchTxtBx().sendKeys("Lakme lipstick");
		homePage.getSrchTxtBx().submit();

		productPage.getFirstPrct().click();

		wlib.noOfWindows(driver, 2);

		wlib.switchingToChildWindow(driver);

		wlib.waitForElementToClickable(driver, productPage.getaddToBag()).click();

		cartPage.clickCart();

		driver.navigate().refresh();

		wlib.waitForElementPresent(driver, cartPage.getshpbag());

		Assert.assertTrue(cartPage.getshpbag().isDisplayed(), "Shopping bag was not displayed after refresh");
	}

	@Test(groups = "EndToEnd")
	public void scrollAndAddProductToBag() {

		HomePage_Nykaa homePage = new HomePage_Nykaa(driver);
		ProductPage productPage = new ProductPage(driver);

		WebDriverutility wlib = new WebDriverutility();

		homePage.getSrchTxtBx().sendKeys("Lakme lipstick");
		homePage.getSrchTxtBx().submit();

		productPage.getFirstPrct().click();

		wlib.noOfWindows(driver, 2);
		System.out.println("Number of windows: " + driver.getWindowHandles().size());

		wlib.switchingToChildWindow(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement addToBag = wait.until(ExpectedConditions.presenceOfElementLocated(
				org.openqa.selenium.By.xpath("//div[@class='css-vp18r8']/descendant::span[.='Add to Bag']")));

		wlib.scrollIntoViewUsingJavaScript(driver, addToBag);

		wait.until(ExpectedConditions.elementToBeClickable(addToBag));

		addToBag.click();

		Assert.assertTrue(driver.getPageSource().toLowerCase().contains("bag"), "Add To Bag failed");
	}
}
