package package_2;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.swiggy.BaseclassUtility.BaseClass;
import com.swiggy.ObjectRepo.HomePage_Nykaa;
import com.swiggy.ObjectRepo.MenCategory_Nykaa;

public class TestScript4_Smoke extends BaseClass {

	@Test
	public void VerifyCategoryNavigation() {

		// Create Home Page object
		HomePage_Nykaa hpn = new HomePage_Nykaa(driver);

		// Verify Home Page
		Assert.assertTrue(hpn.getMenCategory().isDisplayed(), "Men category is not displayed");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		// Click Men category
		wait.until(ExpectedConditions.elementToBeClickable(hpn.getMenCategory()));

		hpn.getMenCategory().click();

		System.out.println("Men category clicked successfully");

		// Create Search Details object
		MenCategory_Nykaa mcn = new MenCategory_Nykaa(driver);

		// Verify products are displayed
		wait.until(ExpectedConditions.visibilityOf(mcn.getFirstProdInMen()));

		Assert.assertTrue(mcn.getFirstProdInMen().isDisplayed(), "Products are not displayed in Men category");

		System.out.println("Men category products displayed successfully");

		System.out.println("Category Navigation Smoke Test PASSED");
	}
}