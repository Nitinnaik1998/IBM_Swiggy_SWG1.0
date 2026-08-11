package offer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.FileUtility;
import com.swiggy.BaseclassUtility.BaseClass;
import com.swiggy.WebDriverUtility.WebDriverutility;


public class OfferTest extends BaseClass {
	@Test
	public void verifyofferpage() throws Throwable {
		
		FileUtility flib=new FileUtility();
		WebDriverutility wlib= new WebDriverutility();
		
		
		String BROWSER = flib.getDataFromPropertiesfile("Browser");
		String URL=flib.getDataFromPropertiesfile("Url");
		
		wlib.waitForPageToLoad(driver);
		driver.get(URL);
		driver.findElement(By.xpath("//div[@type='button']")).click();
		
		
		
		
		
		
		
		
		
		
	}

}
