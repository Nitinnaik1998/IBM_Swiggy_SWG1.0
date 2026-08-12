/**
 * @author AnjaliChowdhary
 **/


package AnjaliTestCases;
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
public class SmokeTestCases extends BaseClass {

	@Test(groups="smokeTest")
	public void launchTheApplication() {
		UtilityClassObject.getTest().log(Status.INFO," fetching the title ");
		String title = driver.getTitle();
		UtilityClassObject.getTest().log(Status.INFO,"printing the title");
		System.out.println("Title = " + title);
		UtilityClassObject.getTest().log(Status.INFO,"verifying the title");
		Assert.assertTrue(title.toLowerCase().contains("nykaa"), "Nykaa home page did not load");
	}

	@Test(groups="smokeTest")
	public void verifyProductSearch() {
		UtilityClassObject.getTest().log(Status.INFO,"Launching the HomePage ");
		HomePage hp = new HomePage(driver);
		UtilityClassObject.getTest().log(Status.INFO,"entering the product that needs to be searched");
		hp.getSrchTxtBx().sendKeys("Lakhme Lipstick");
		UtilityClassObject.getTest().log(Status.INFO,"fetching the title");
		String title = driver.getTitle();
		UtilityClassObject.getTest().log(Status.INFO,"verifying the url");
		Assert.assertTrue(title.contains("lakme") || driver.getPageSource().toLowerCase().contains("lakme"),
				"Product search failed");
	}

	@Test(groups="smokeTest")
	public void verifyProductDetailsPage() {
		UtilityClassObject.getTest().log(Status.INFO,"launching the HomePage");
		HomePage homePage = new HomePage(driver);
		UtilityClassObject.getTest().log(Status.INFO,"launching the ProductPage");
		ProductPage productPage = new ProductPage(driver);
		UtilityClassObject.getTest().log(Status.INFO,"searching the product");
		homePage.getSrchTxtBx().sendKeys("Lakme lipstick");
		homePage.getSrchTxtBx().submit();
		UtilityClassObject.getTest().log(Status.INFO,"clicking on First link of the product");
		productPage.getFirstPrct().click();
		UtilityClassObject.getTest().log(Status.INFO,"verifying the script");
		Assert.assertTrue(driver.getCurrentUrl().contains("nykaa"), "Product details page was not opened");
		
	}
	
	@Test(groups="smokeTest")
	public void verifyAddToBag() throws InterruptedException {
		WebDriverutility wlib = new WebDriverutility();
		HomePage homePage = new HomePage(driver);

		ProductPage productPage = new ProductPage(driver);
		UtilityClassObject.getTest().log(Status.INFO,"searching the product");
		homePage.getSrchTxtBx().sendKeys("Lakme lipstick");
		homePage.getSrchTxtBx().submit();
		UtilityClassObject.getTest().log(Status.INFO,"clicking on First link of the product");
		productPage.getFirstPrct().click();
		UtilityClassObject.getTest().log(Status.INFO,"switching window");
		wlib.switchtoTabonTitle(driver, "lakme-forever-matte");
		UtilityClassObject.getTest().log(Status.INFO,"add to bag");
		productPage.getaddToBag().click();
		UtilityClassObject.getTest().log(Status.INFO,"verifying the result");
		Assert.assertTrue(driver.getPageSource().toLowerCase().contains("bag"), "Product was not added to bag");
	}

	@Test(groups="smokeTest")
	public void clickToCartIcon() throws Exception {
		HomePage homePage = new HomePage(driver);

		ProductPage productPage = new ProductPage(driver);

		CartPage cartPage = new CartPage(driver);
		WebDriverutility wlib = new WebDriverutility();
		UtilityClassObject.getTest().log(Status.INFO," searching the product");
		homePage.getSrchTxtBx().sendKeys("Lakme lipstick");
		homePage.getSrchTxtBx().click();
		UtilityClassObject.getTest().log(Status.INFO,"clicking on First link of the product");
		productPage.getFirstPrct().click();
		UtilityClassObject.getTest().log(Status.INFO,"switching window");
		wlib.switchtoTabonTitle(driver, "lakme-forever-matte");
		UtilityClassObject.getTest().log(Status.INFO,"add to bag");
		productPage.getaddToBag().click();
		UtilityClassObject.getTest().log(Status.INFO,"clicking on cart button");
		cartPage.clickCart();

		UtilityClassObject.getTest().log(Status.INFO,"verifying the result");
		Assert.assertTrue(cartPage.getshpbag().isDisplayed(), "Product is not displayed in cart");
	}
}
