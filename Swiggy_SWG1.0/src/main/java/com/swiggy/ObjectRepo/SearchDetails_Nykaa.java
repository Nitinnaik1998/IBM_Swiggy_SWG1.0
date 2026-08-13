package com.swiggy.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchDetails_Nykaa {

	WebDriver driver;

	public SearchDetails_Nykaa(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@data-at='plp-product-count']")
	private WebElement productsCount;

	public WebElement getProductsCount() {
		return productsCount;
	}

	@FindBy(xpath= "(//div[@data-at='product-title'])[1]")
	private WebElement FirstProduct;
    
	
	@FindBy(xpath="(//button[@aria-label='View similar products'])[1]")
	private WebElement getFirstProduct;
	
	public WebElement getGetFirstProduct() {
		return getFirstProduct;
	}
	
	public WebElement getFirstProduct() {
		return FirstProduct;
	}

	@FindBy(xpath = "//button[@class='css-bigugj']")
	private WebElement sortBy;

	public WebElement getSortBy() {
		return sortBy;
	}

	@FindBy(xpath = "//div[@title='Price: Low To High']")
	private WebElement lowtoHigh;

	public WebElement getLowtoHigh() {
		return lowtoHigh;
	}
    
	@FindBy(xpath="//div[text()='Size']")
	private WebElement size;

	public WebElement getSize() {
		return size;
	}
	
	@FindBy(xpath="//div[contains(text(),'Unfortunately')]")
	private WebElement noResults;

	public WebElement getNoResults() {
		return noResults;
	}
	
	
	
	
}
