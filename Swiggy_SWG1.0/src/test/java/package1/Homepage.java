package package1;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.swiggy.BaseclassUtility.BaseClass;
import com.swiggy.FileUtility.FileUtility;
import com.swiggy.WebDriverUtility.WebDriverutility;

public class Homepage extends BaseClass {
	@Test
	public void verifyHomePage() throws IOException {
		FileUtility flib = new FileUtility();
		WebDriverutility wlib= new WebDriverutility();
		
		String BROWSER = flib.getDataFromPropertiesFile("Browser");
		String URL=flib.getDataFromPropertiesFile("Url");
		
	    driver.get(URL);
	    wlib.waitForPageToLoad(driver);
	    
	    String title = driver.getTitle();
	    Assert.assertTrue(title.contains("Nykaa"));
	}


}
