package com.swiggy.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage_Nykaa {

	WebDriver driver;

	public HomePage_Nykaa(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	
	
	@FindBy(xpath="//input[@placeholder='Search on Nykaa']")
	private WebElement srchTxtBx;
	public WebElement getSrchTxtBx() {
		return srchTxtBx;
	}

	@FindBy(name="search-suggestions-nykaa")

	private WebElement searchTextField;

	public WebElement getSearchTextField() {
		return searchTextField;
	}

	@FindBy(xpath = "//a[text()='men']")
	private WebElement menCategory;
	
	  public WebElement getMenCategory() {
	        return menCategory;
	    }


}
