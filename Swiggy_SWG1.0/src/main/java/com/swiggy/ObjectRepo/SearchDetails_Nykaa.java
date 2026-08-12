package com.swiggy.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchDetails_Nykaa {
	
	WebDriver driver;
	public SearchDetails_Nykaa(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//span[@data-at='plp-product-count']")
	private WebElement productsCount;
	
	
	public WebElement getProductsCount() {
		return productsCount;
	}
	
	@FindBy(xpath="(//button[@aria-label='View similar products'])[1]")
	private WebElement getFirstProduct;
	
	public WebElement getGetFirstProduct() {
		return getFirstProduct;
	}
	

}
