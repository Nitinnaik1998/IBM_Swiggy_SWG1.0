package com.swiggy.BaseclassUtility;

import java.sql.SQLException;
import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


import com.swiggy.FileUtility.FileUtility;
import com.swiggy.ObjectRepo.HomePage;
import com.swiggy.WebDriverUtility.UtilityClassObject;

public class BaseClass {
     public FileUtility fu=new FileUtility();
     public WebDriver driver=null;
 	public static WebDriver sdriver=null;
	@BeforeSuite
	public void configBS() throws SQLException {
		System.out.println("Connect To DB , Report config");
		
	}
	@BeforeClass
	public void configBC() throws Throwable {
		System.out.println("Launch Browser");
		String BROWSER =fu.getDataFromPropertiesFile("Browser");
		
		if(BROWSER.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(BROWSER.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equals("edge")) {
			driver=new EdgeDriver();
		}
		else {
			
			driver=new ChromeDriver();
		}
		
		if (driver != null) {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		}
		sdriver=driver;
		UtilityClassObject.setDriver(driver);

}
	@BeforeMethod
	public void configBM() throws Throwable {
		System.out.println("Login to application");
		String URL = fu.getDataFromPropertiesFile("Url");
	}
	@AfterMethod
	public void configAM() {
		System.out.println("LogOut from application");
		HomePage hp=new HomePage(driver);
		hp.logout();
	}
	
	@AfterClass(groups= {"ST","RT"})
	public void configAC() {
		System.out.println("Close the  Browser");
		driver.quit();
	}
		
	@AfterSuite(groups= {"ST","RT"})
	public void configAS() throws SQLException {
		System.out.println("Close  DB , Report backup");
		
	}
	
	
	
		
}