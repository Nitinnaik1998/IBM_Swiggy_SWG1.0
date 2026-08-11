package com.swiggy.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//*[name()='svg' and @width=\"40\"]")
	private WebElement profile;
	
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement lgout;
	
	
	@FindBy(xpath="//div[text()='Search for restaurant, item or more']")
	private WebElement searchrest;
	
	
	public WebElement getSearchrest() {
		return searchrest;
	}

	public WebElement getProfile() {
		return profile;
	}

	public WebElement getLgout() {
		return lgout;
	}
	
	public void logout() {
		Actions ac=new Actions(driver);
		ac.moveToElement(profile).perform();
		lgout.click();
		
	}

}
