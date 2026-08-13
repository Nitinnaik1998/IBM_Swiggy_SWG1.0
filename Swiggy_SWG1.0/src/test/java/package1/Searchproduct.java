package package1;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.swiggy.BaseclassUtility.BaseClass;
import com.swiggy.FileUtility.FileUtility;
import com.swiggy.WebDriverUtility.WebDriverutility;

public class Searchproduct extends BaseClass {
	
		 @Test
		    public void searchProductTest() throws IOException {

		        FileUtility flib = new FileUtility();
		        WebDriverutility wlib = new WebDriverutility();

		        String URL = flib.getDataFromPropertiesFile("Url");

		        driver.get(URL);

		        // Wait for page
		        wlib.waitForPageToLoad(driver);

		        // Search product
		        WebElement search = driver.findElement(
		                By.xpath("//input[@placeholder='Search on Nykaa']")
		        );

		        wlib.waitForElementPresent(driver, search);

		        search.sendKeys("Lipstick");
		        search.sendKeys(Keys.ENTER);

		        Assert.assertTrue(
		                driver.getPageSource().contains("Lipstick"),
		                "Lipstick search results are not displayed"
		            );
		   
		    }
		}


