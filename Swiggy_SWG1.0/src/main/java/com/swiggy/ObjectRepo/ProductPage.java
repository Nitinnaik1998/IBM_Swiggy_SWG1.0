package com.swiggy.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	WebDriver driver;
	public ProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="(//div[contains(@class,'product')])[1]")
	private WebElement firstPrct;
	
	 public WebElement getFirstPrct() {
		return firstPrct;
	 }
		@FindBy(xpath=  "//div[@class='css-vp18r8']/descendant::span[.='Add to Bag']")
	private WebElement addToBag;
		public WebElement getaddToBag() {
			return addToBag; 
	 
}
		
}
