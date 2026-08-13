package package_2;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.swiggy.BaseclassUtility.BaseClass;
import com.swiggy.ObjectRepo.HomePage_Nykaa;
import com.swiggy.ObjectRepo.ParticularProductDetails_Nykaa;
import com.swiggy.ObjectRepo.SearchDetails_Nykaa;

public class TestScript3_Integration extends BaseClass {

	@Test
	public void VerifyProductRating() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));

		// Step 1: Home Page
		HomePage_Nykaa hpn = new HomePage_Nykaa(driver);

		// Step 2: Search Pants
		hpn.getSearchTextField().sendKeys("Pants" + Keys.ENTER);

		SearchDetails_Nykaa sdn = new SearchDetails_Nykaa(driver);

		// Step 3: Verify product listing
		wait.until(ExpectedConditions.visibilityOf(sdn.getFirstProduct()));

		Assert.assertTrue(sdn.getFirstProduct().isDisplayed(), "Product listing is not displayed");

		System.out.println("Product listing displayed");

		// Step 4: Click first product
		String parentWindow = driver.getWindowHandle();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement firstProduct = sdn.getFirstProduct();

		js.executeScript("arguments[0].scrollIntoView({block:'center'});", firstProduct);

		js.executeScript("arguments[0].click();", firstProduct);
		  Set<String> allWindows =
	                driver.getWindowHandles();

	        for (String window : allWindows) {

	            if (!window.equals(parentWindow)) {

	                driver.switchTo().window(window);

	                break;
	            }
	        }

		// Step 5: Product Details
		ParticularProductDetails_Nykaa ppdn = new ParticularProductDetails_Nykaa(driver);

		wait.until(ExpectedConditions.visibilityOf(ppdn.getRatingCount()));

		Assert.assertTrue(ppdn.getRatingCount().isDisplayed(), "Product details are not displayed");

		System.out.println("Product rating: " + ppdn.getRatingCount().getText());

		// Step 6: Verify Product Rating
		// wait.until(ExpectedConditions.visibilityOf(ppdn.getRatingDetails()));

		Assert.assertTrue(ppdn.getRatingDetails().isDisplayed(), "Product rating is not displayed");

		String rating = ppdn.getRatingDetails().getText();

		System.out.println("Product Rating: " + rating);

		System.out.println("Product Rating Verification PASSED");
	}
}