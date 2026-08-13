package package_2;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.swiggy.BaseclassUtility.BaseClass;
import com.swiggy.ObjectRepo.HomePage_Nykaa;
import com.swiggy.ObjectRepo.SearchDetails_Nykaa;
import com.swiggy.ObjectRepo.SimilarProductDetails_Nykaa;

public class TestScript2_Smoke extends BaseClass {
	  
    @Test
    public void VerifySimilarProducts() {
    	HomePage_Nykaa hpn=new HomePage_Nykaa(driver);
    	hpn.getSearchTextField().sendKeys("Pants"+Keys.ENTER);
    SearchDetails_Nykaa sdn=new SearchDetails_Nykaa(driver);
    JavascriptExecutor js = (JavascriptExecutor) driver;

    js.executeScript("arguments[0].click();",
            sdn.getGetFirstProduct());
            sdn.getFirstProduct());
    
    SimilarProductDetails_Nykaa pdn = new SimilarProductDetails_Nykaa(driver);

    // Verify similar products
    Assert.assertTrue(pdn.getSimilarProducts().isDisplayed(),
            "Similar products are not displayed");

    System.out.println("Similar products are displayed successfully");


}
}