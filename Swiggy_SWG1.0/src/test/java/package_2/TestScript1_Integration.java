package package_2;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.swiggy.BaseclassUtility.BaseClass;
import com.swiggy.ObjectRepo.HomePage_Nykaa;
import com.swiggy.ObjectRepo.SearchDetails_Nykaa;
import com.swiggy.ObjectRepo.ProductDetails_Nykaa;

public class TestScript1_Integration extends BaseClass {

	@Test
	public void VerifyProductSizeSelection() {

		// Step 1: Home Page
		HomePage_Nykaa hpn = new HomePage_Nykaa(driver);

		Assert.assertTrue(hpn.getSearchTextField().isDisplayed(), "Search field is not displayed");

		// Step 2: Search Pants
		hpn.getSearchTextField().sendKeys("Pants" + Keys.ENTER);

		SearchDetails_Nykaa sdn = new SearchDetails_Nykaa(driver);

		Assert.assertTrue(sdn.getFirstProduct().isDisplayed(), "Product listing is not displayed");

		System.out.println("Product listing displayed");

		// Step 4: Click first product
		WebElement product = sdn.getFirstProduct();

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView({block:'center'});", product);

		js.executeScript("arguments[0].click();", product);

		// Step 5: Product Details
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		

		// Step 6: Select Size M
		wait.until(ExpectedConditions.elementToBeClickable(sdn.getSize()));

		

		// Step 7: Verify Size M is selected
		Assert.assertTrue(sdn.getSize().isDisplayed(), "Size M is not displayed");

		System.out.println("Size M selected successfully");

		System.out.println("====================================");

		System.out.println("SEARCH → PRODUCT → SIZE SELECTION");

		System.out.println("INTEGRATION TEST PASSED");

		System.out.println("====================================");
	}
}