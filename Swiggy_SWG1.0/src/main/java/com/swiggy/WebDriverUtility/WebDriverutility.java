package com.swiggy.WebDriverUtility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverutility {
	
		public void waitForPageToLoad(WebDriver driver) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			
		}
		public void waitForElementPresent(WebDriver driver, WebElement element) {
			WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOf(element));
			
		}
		public WebElement waitForElementToClickable(WebDriver driver, WebElement element) {
			WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			return element;
		}
		public void noOfWindows(WebDriver driver, int n) {
			WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.numberOfWindowsToBe(n));
			
		}
		public void switchtoTabonUrl(WebDriver driver,String partialUrl) {
			Set<String> set = driver.getWindowHandles();
			   Iterator<String> it = set.iterator();
			   
			   while(it.hasNext()) {
				  String windowID = it.next();
				  driver.switchTo().window(windowID);
				  
				String acturl = driver.getCurrentUrl();
				if(acturl.contains(partialUrl)) {
					break;
			
		        }
			   }
		     }
		public String fetchingParentWindow(WebDriver driver)
		{
			String parentId=driver.getWindowHandle();
			return parentId;
		}
		public void switchingToChildWindow(WebDriver driver)
		{
			 String parentWindow = driver.getWindowHandle();

			    Set<String> allWindows = driver.getWindowHandles();

			    for (String window : allWindows) {

			        if (!window.equals(parentWindow)) {
			            driver.switchTo().window(window);
			            break;
			        }
			    }
		}
		public void switchtoTabonTitle(WebDriver driver,String partialtitle) {
			Set<String> set = driver.getWindowHandles();
			   Iterator<String> it = set.iterator();
			   
			   while(it.hasNext()) {
				  String windowID = it.next();
				  driver.switchTo().window(windowID);
				  
				String acturl = driver.getCurrentUrl();
				if(acturl.contains(partialtitle)) {
					break;
			
		         }
			 }   
	     }
			   
	 public void switchToFrame(WebDriver driver, int index) {
		 driver.switchTo().frame(index);
		 
	 }
	 public void switchToFrame(WebDriver driver, String nameId) {
		 driver.switchTo().frame(nameId);
		 
	 }
	 public void switchToFrame(WebDriver driver, WebElement element) {
		 driver.switchTo().frame(element);
		 
	 }
	public void switchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public void switchToAlertAndDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	public void select(WebElement element,String text) {
		Select sel= new Select(element);
		sel.selectByVisibleText(text);
	}

	public void select(WebElement element,int index) { 
		Select sel= new Select(element);
		sel.selectByIndex(index);
	}

	public void mouseMoveOnElement(WebDriver driver,WebElement element) {
		Actions act= new Actions(driver);
		act.moveToElement(element).perform();
		}

		public void scrollIntoViewUsingJavaScript(WebDriver driver, WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor) driver;

			js.executeScript("arguments[0].scrollIntoView({block:'center'});", element);
		}

	public void doubleClick(WebDriver driver,WebElement element) {
		Actions act= new Actions(driver);
		act.doubleClick(element).perform();

	}

}
