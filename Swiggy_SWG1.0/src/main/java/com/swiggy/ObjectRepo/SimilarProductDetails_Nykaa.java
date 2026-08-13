package com.swiggy.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SimilarProductDetails_Nykaa {
	WebDriver driver;

	public SimilarProductDetails_Nykaa(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='css-gymb3s']")
	private WebElement similarProducts;

	public WebElement getSimilarProducts() {
		return similarProducts;
	}
}
