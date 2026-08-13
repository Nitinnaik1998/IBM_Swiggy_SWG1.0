package com.swiggy.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetails_Nykaa {
	WebDriver driver;
	public ProductDetails_Nykaa(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//div[@class='css-gymb3s' ]")
	private WebElement productName;

	@FindBy(xpath = "//div[@class='css-wpqtsf']")
	private WebElement similarProducts;

	@FindBy(xpath = "//div[@class='css-wpqtsf']/ancestor::div[@class='css-178nkgo']/descendant::div[@data-at='product-title']")
	private WebElement firstSimilarProduct;
    
	@FindBy(xpath="//div[text()='Similar Products']/ancestor::div[@class='css-178nkgo']/descendant::span[@class='css-1ijk06y']")
	private WebElement productPrice;
	
	

	public WebElement getProductPrice() {
		return productPrice;
	}

	public WebElement getProductName() {
	    return productName;
	}

	public WebElement getSimilarProducts() {
	    return similarProducts;
	}

	public WebElement getFirstSimilarProduct() {
	    return firstSimilarProduct;
	}

}
