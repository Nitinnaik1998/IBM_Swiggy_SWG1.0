package package_2;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.swiggy.BaseclassUtility.BaseClass;
import com.swiggy.ObjectRepo.HomePage_Nykaa;
import com.swiggy.ObjectRepo.SearchDetails_Nykaa;

public class TestScript1_Smoke extends BaseClass {
    @Test
	public void Verifyproductsearch() {
    	HomePage_Nykaa hpn=new HomePage_Nykaa(driver);
    	hpn.getSearchTextField().sendKeys("Pants"+Keys.ENTER);
    SearchDetails_Nykaa sdn=new SearchDetails_Nykaa(driver);
    String prodcount=sdn.getProductsCount().getText();
    System.out.println(prodcount);
    Assert.assertTrue(prodcount.contains("items"),
            "Product search validation failed");
	}

}
