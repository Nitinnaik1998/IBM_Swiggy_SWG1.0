package package1;
import java.time.Duration;
import java.util.Set;

import org.jspecify.annotations.Nullable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.swiggy.BaseclassUtility.BaseClass;

public class NykaTest extends BaseClass{
	@Test
    public void test1() {
    	WebElement Luxe = driver.findElement(By.xpath("//a[text()='luxe']"));
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
    	Actions ac=new Actions(driver); 
    	ac.moveToElement(Luxe).perform();
    	driver.findElement(By.xpath("//a[contains(text(),'                       Lip Balm')]")).click();
    	System.out.println("done sucessfully");  	
    }
	@Test
    public void test3() {
		WebElement Luxe = driver.findElement(By.xpath("//a[text()='luxe']"));
    	Actions ac=new Actions(driver); 
    	ac.moveToElement(Luxe).perform();
    	driver.findElement(By.xpath("//a[contains(text(),'                       Lip Balm')]")).click();
    	Set<String> allwindow = driver.getWindowHandles();
    	for( String id : allwindow) {
    		
    		@Nullable
			String title = driver.getTitle();
    		if(title.contains("Lip Balm"));
    		driver.switchTo().window(id);
    	}	
    	String ActualName = "Lip Balm";
    	WebElement name = driver.findElement(By.xpath("//h1[@class='css-c0pzm0']"));
    	name.getText();
    	Assert.assertEquals(ActualName,name);
    }
	@Test
	public void test2() {
		WebElement Luxe = driver.findElement(By.xpath("//a[text()='luxe']"));
    	Actions ac=new Actions(driver); 
    	ac.moveToElement(Luxe).perform();
    	driver.findElement(By.xpath("//a[contains(text(),'                       Lip Balm')]")).click();
    	Set<String> allwindow = driver.getWindowHandles();
    	for( String id : allwindow) {
    		
    		@Nullable
			String title = driver.getTitle();
    		if(title.contains("Lip Balm"));
    		driver.switchTo().window(id);
    	}
    	ac.scrollByAmount(0, 250).perform();
    	WebElement CLICK = driver.findElement(By.xpath("//h2[text()='LANEIGE Lip Glowy Balm']"));
    	ac.moveToElement(CLICK).perform();
    	
    	driver.findElement(By.xpath("//h2[text()='LANEIGE Lip Glowy Balm']/ancestor::div[@class='productWrapper css-17nge1h']/descendant::button[@class='css-iyqsry']")).click();
	    System.out.println("added");
	}
	
}
