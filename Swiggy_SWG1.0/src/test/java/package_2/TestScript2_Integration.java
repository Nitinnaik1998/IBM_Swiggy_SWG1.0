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

public class TestScript2_Integration extends BaseClass {

	@Test
	public void VerifyProductInformation() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		// 1. Home Page
		HomePage_Nykaa hpn = new HomePage_Nykaa(driver);

		Assert.assertTrue(hpn.getSearchTextField().isDisplayed(), "Search field is not displayed");

		// 2. Search Pants
		hpn.getSearchTextField().sendKeys("Pants" + Keys.ENTER);

		SearchDetails_Nykaa sdn = new SearchDetails_Nykaa(driver);

		// 3. Verify Product Listing
		wait.until(ExpectedConditions.visibilityOf(sdn.getFirstProduct()));

		Assert.assertTrue(sdn.getFirstProduct().isDisplayed(), "Product listing is not displayed");

		System.out.println("Product listing displayed");

		// 4. Click First Product
		WebElement firstProduct = sdn.getFirstProduct();

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView({block:'center'});", firstProduct);

		wait.until(ExpectedConditions.elementToBeClickable(firstProduct));

		js.executeScript("arguments[0].click();", firstProduct);

		// 5. Product Details
		ProductDetails_Nykaa pdn = new ProductDetails_Nykaa(driver);

		wait.until(ExpectedConditions.visibilityOf(pdn.getProductName()));

		// 6. Verify Product Name
		String productName = pdn.getProductName().getText();

		Assert.assertFalse(productName.isEmpty(), "Product name is not displayed");

		System.out.println("Product Name: " + productName);

		// 7. Verify Product Price
		Assert.assertTrue(pdn.getProductPrice().isDisplayed(), "Product price is not displayed");

		System.out.println("Product price displayed");

		System.out.println("================================");

		System.out.println("PRODUCT INFORMATION INTEGRATION PASSED");

		System.out.println("================================");
	}
}