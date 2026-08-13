
package package_2;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.swiggy.BaseclassUtility.BaseClass;
import com.swiggy.ObjectRepo.HomePage_Nykaa;
import com.swiggy.ObjectRepo.SearchDetails_Nykaa;

public class TestScript3_Smoke extends BaseClass {

	@Test
	public void VerifyProductSorting() {
		HomePage_Nykaa hpn = new HomePage_Nykaa(driver);

		// Search Pants
		hpn.getSearchTextField().sendKeys("Pants" + Keys.ENTER);

		SearchDetails_Nykaa sdn = new SearchDetails_Nykaa(driver);

		// Verify products are displayed
		Assert.assertTrue(sdn.getFirstProduct().isDisplayed(), "Products are not displayed");

		Actions action = new Actions(driver);
		action.moveToElement(sdn.getSortBy()).perform();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.elementToBeClickable(sdn.getLowtoHigh()));

		sdn.getLowtoHigh().click();
		System.out.println("Products sorted successfully");
	}

}
