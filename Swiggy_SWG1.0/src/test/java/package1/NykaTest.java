package package1;
import java.time.Duration;
import java.util.Set;

import org.jspecify.annotations.Nullable;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
    	
    	WebElement name = driver.findElement(By.xpath("//h1[@class='css-c0pzm0']"));
    	String ActualName=name.getText();
    	Assert.assertTrue(ActualName.contains("Lip Balm"));
    	System.out.println("Matched with expectation");
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
	@Test
	public void test4() {
		driver.findElement(By.xpath("//input[@class='css-13m99a4']")).sendKeys("sunscreen"+Keys.ENTER);
		Actions ac=new Actions(driver); 
		ac.scrollByAmount(0,250).perform();
		driver.findElement(By.id("65d375c1e74657358e1999ee")).click();
		ac.scrollByAmount(0, 200).perform();
		driver.findElement(By.xpath("//span[text()='Brand']/ancestor::div[@id=\"first-filter\"]/descendant::div[@class='css-xdicx1']")).click();
		driver.findElement(By.xpath("//span[text()='360 Block']/ancestor::div[@class='control-box css-1tsrqji']/label/div[@class='control-indicator checkbox ']")).click();
        WebElement move = driver.findElement(By.xpath("//h2[text()='360 Block Sunscreen Gel With SPF 50+']"));
		ac.moveToElement(move).perform();
		driver.findElement(By.xpath("//span[text()='Add to Bag']")).click();
	}
	@Test
	public void test5() {
		driver.findElement(By.xpath("//input[@class='css-13m99a4']")).sendKeys("sunscreen"+Keys.ENTER);
		Actions ac=new Actions(driver); 
		ac.scrollByAmount(0,250).perform();
		driver.findElement(By.id("65d375c1e74657358e1999ee")).click();
		ac.scrollByAmount(0, 200).perform();
		driver.findElement(By.xpath("//span[text()='Brand']/ancestor::div[@id=\"first-filter\"]/descendant::div[@class='css-xdicx1']")).click();
		driver.findElement(By.xpath("//span[text()='360 Block']/ancestor::div[@class='control-box css-1tsrqji']/label/div[@class='control-indicator checkbox ']")).click();
        WebElement move = driver.findElement(By.xpath("//h2[text()='360 Block Sunscreen Gel With SPF 50+']"));
		ac.moveToElement(move).perform();
		driver.findElement(By.xpath("//span[text()='Add to Bag']")).click();
		driver.findElement(By.xpath("//*[local-name()='svg']/following-sibling::span[@class='cart-count']")).click();
	}
	@Test
	public void test6() {
		driver.findElement(By.xpath("//*[local-name()='svg']/ancestor::button[@id='header-bag-icon']")).click();
		driver.findElement(By.xpath("//button[text()='Start Shopping']")).click();
		String partname="Sign in";
		WebElement signin = driver.findElement(By.xpath("//div[@class='css-jgrj0x euw1lbv2']/button"));
		String actname = signin.getText();
		Assert.assertEquals(partname, actname);
		System.out.println("correct");
		
	}
	@Test
	public void test7() {
		driver.findElement(By.xpath("//span[text()='Help']")).click();
		
		Set<String> allwindow = driver.getWindowHandles();
    	for( String id : allwindow) {
    		
    		@Nullable
			String title = driver.getTitle();
    		if(title.contains("Cosmetics"));
    		driver.switchTo().window(id);
    	}		
		Actions ac=new Actions(driver); 
		ac.scrollByAmount(0,500).perform();
		driver.findElement(By.xpath("//h2[text()='Chat with us']")).click();
		String partname="Help Center";
		WebElement name = driver.findElement(By.xpath("//p[@class='css-1tr5m7p e8pythv0']"));
	    String actname = name.getText();
	    Assert.assertEquals(partname, actname);
	    System.out.println("matching");
	}
}
