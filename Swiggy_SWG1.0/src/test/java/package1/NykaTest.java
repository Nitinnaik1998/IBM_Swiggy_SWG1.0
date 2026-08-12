package package1;
import java.time.Duration;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
	public void test2() {
		WebElement Luxe = driver.findElement(By.xpath("//a[text()='luxe']"));
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
    	Actions ac=new Actions(driver); 
    	ac.moveToElement(Luxe).perform();
    	driver.findElement(By.xpath("//a[contains(text(),'                       Lip Balm')]")).click();
    	Set<String> allwindow = driver.getWindowHandles();
    	for( String id : allwindow) {
    		driver.switchTo().window(id);
    		@Nullable
			String title = driver.getTitle();
    		if(title.contains("lip-balm"));
    		break;
    	}
	}
}
