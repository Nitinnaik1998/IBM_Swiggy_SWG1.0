package com.swiggy.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ParticularProductDetails_Nykaa {
	WebDriver driver;

	public ParticularProductDetails_Nykaa(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='css-pxj4mu']/ancestor::section[@class='css-1sr768a']/descendant::div[@class='css-xoezkq']")
	private WebElement ratingCount;

	public WebElement getRatingCount() {
		return ratingCount;
	}
	
	@FindBy(xpath="//div[contains(text(),'ratings')]")
	private WebElement ratingDetails;

	public WebElement getRatingDetails() {
		return ratingDetails;
	}
	
	

}
