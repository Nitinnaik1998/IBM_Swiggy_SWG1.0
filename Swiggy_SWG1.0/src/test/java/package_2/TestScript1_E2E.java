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
import com.swiggy.ObjectRepo.ProductDetails_Nykaa;
import com.swiggy.ObjectRepo.SearchDetails_Nykaa;

public class TestScript1_E2E extends BaseClass {
	@Test
	public void VerifyGuestEndToEndProductFlow() {

		// 1. Home Page
		HomePage_Nykaa hpn = new HomePage_Nykaa(driver);

		Assert.assertTrue(hpn.getSearchTextField().isDisplayed(), "Search field is not displayed");

		// 2. Search Product
		hpn.getSearchTextField().sendKeys("Pants" + Keys.ENTER);

		SearchDetails_Nykaa sdn = new SearchDetails_Nykaa(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));

		// 3. Verify Search Results
		wait.until(ExpectedConditions.visibilityOf(sdn.getFirstProduct()));

		Assert.assertTrue(sdn.getFirstProduct().isDisplayed(), "Search results are not displayed");

		System.out.println("Search results displayed");

		// 4. Click First Product
		WebElement firstProduct = sdn.getFirstProduct();

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", firstProduct);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", firstProduct);

		// 5. Product Details Page
		ProductDetails_Nykaa pdn = new ProductDetails_Nykaa(driver);

		wait.until(ExpectedConditions.visibilityOf(pdn.getProductName()));

		String productName = pdn.getProductName().getText();

		Assert.assertFalse(productName.isEmpty(), "Product name is not displayed");

		System.out.println("Product: " + productName);

		// 6. Scroll to Similar Products
		wait.until(ExpectedConditions.visibilityOf(pdn.getSimilarProducts()));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});",
				pdn.getSimilarProducts());

		// 7. Verify Similar Products
		Assert.assertTrue(pdn.getSimilarProducts().isDisplayed(), "Similar Products section is not displayed");

		System.out.println("Similar Products displayed");

		// 8. Click Similar Product
		pdn.getFirstSimilarProduct().click();

		// 9. Verify Similar Product Details
		wait.until(ExpectedConditions.visibilityOf(pdn.getProductName()));

		String similarProductName = pdn.getProductName().getText();

		Assert.assertFalse(similarProductName.isEmpty(), "Similar product details are not displayed");

		System.out.println("Similar Product: " + similarProductName);

		System.out.println("Guest End-to-End Product Flow PASSED");
	}

}
