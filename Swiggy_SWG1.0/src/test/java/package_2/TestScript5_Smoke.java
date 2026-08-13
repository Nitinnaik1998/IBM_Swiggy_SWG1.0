package package_2;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.swiggy.BaseclassUtility.BaseClass;
import com.swiggy.ObjectRepo.HomePage_Nykaa;
import com.swiggy.ObjectRepo.SearchDetails_Nykaa;

public class TestScript5_Smoke extends BaseClass {

	@Test
	public void VerifyInvalidProductSearch() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		// Home Page
		HomePage_Nykaa hpn = new HomePage_Nykaa(driver);

		// Search invalid product
		hpn.getSearchTextField().sendKeys("xyzabc123" + Keys.ENTER);

		SearchDetails_Nykaa sdn = new SearchDetails_Nykaa(driver);

		// Wait for no-result message
		wait.until(ExpectedConditions.visibilityOf(sdn.getNoResults()));

		// Validate
		Assert.assertTrue(sdn.getNoResults().isDisplayed(), "No result message is not displayed");

		System.out.println("Invalid search handled successfully");

		System.out.println("Invalid Product Search Smoke Test PASSED");
	}
}