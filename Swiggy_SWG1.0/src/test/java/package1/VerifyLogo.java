package package1;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.swiggy.BaseclassUtility.BaseClass;
import com.swiggy.FileUtility.FileUtility;

public class VerifyLogo extends BaseClass {
	@Test
	public void verifyNykaaLogoTest() throws IOException {

	    FileUtility flib = new FileUtility();

	    driver.get(flib.getDataFromPropertiesFile("Url"));

	    WebElement logo = driver.findElement(
	            By.xpath("//a[@title='logo']")
	    );

	    Assert.assertTrue(logo.isDisplayed(),
	            "Nykaa logo is not displayed");
	}

}
