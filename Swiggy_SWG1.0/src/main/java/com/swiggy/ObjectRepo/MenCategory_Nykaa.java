package com.swiggy.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenCategory_Nykaa {
	WebDriver driver;

	public MenCategory_Nykaa(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='titles-wrap']/child::li[@class='title-text']")
	private WebElement firstProdInMen;

	public WebElement getFirstProdInMen() {
		return firstProdInMen;
	}

}
