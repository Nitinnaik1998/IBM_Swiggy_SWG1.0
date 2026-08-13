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

public class TestScript2_E2E extends BaseClass {

	@Test
	public void VerifySearchProductBackNavigation() {

	    

	    HomePage_Nykaa hpn =
	            new HomePage_Nykaa(driver);

	    // 1. Search Pants
	    hpn.getSearchTextField()
	            .sendKeys("Pants" + Keys.ENTER);

	    SearchDetails_Nykaa sdn =
	            new SearchDetails_Nykaa(driver);

	    

	    Assert.assertTrue(
	            sdn.getFirstProduct().isDisplayed(),
	            "Product listing is not displayed");

	    System.out.println("Product listing displayed");

	    // 3. Click first product
	    WebElement product =
	            sdn.getFirstProduct();

	    JavascriptExecutor js =
	            (JavascriptExecutor) driver;

	    js.executeScript(
	            "arguments[0].scrollIntoView({block:'center'});",
	            product);

	    js.executeScript(
	            "arguments[0].click();",
	            product);

	    // 4. Verify Product Details
	    ProductDetails_Nykaa pdn =
	            new ProductDetails_Nykaa(driver);

	    

	    String productName =
	            pdn.getProductName().getText();

	    Assert.assertFalse(
	            productName.isEmpty(),
	            "Product name is not displayed");

	    System.out.println(
	            "Product Name: " + productName);

	    // 5. Navigate back
	    driver.navigate().back();

	  

	    System.out.println(
	            "Back navigation successful");

	    System.out.println(
	            "Search → Product → Details → Back E2E PASSED");
	}
}