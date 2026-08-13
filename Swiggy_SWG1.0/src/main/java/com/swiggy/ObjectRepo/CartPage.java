package com.swiggy.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	WebDriver driver;
	public CartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//button[@id='header-bag-icon']")
	private WebElement cartIcon ;
	 public WebElement getcartIcon() {
			return cartIcon;
	 }
	public void clickCart() {

        cartIcon.click();
    }

    @FindBy(xpath="//*[local-name()='svg' and @width=\"24\"]/parent::button[@id=\"header-bag-icon\"]")
    private WebElement shpbag;
    public WebElement getshpbag() {
		return shpbag;
}
    @FindBy(xpath="//button[@data-test-id=\"product-quantity-dropdown\"]/*[local-name()='svg' ]")
    private WebElement dropdwnBtn;

    public WebElement getdropdwnBtn() {
        return dropdwnBtn;
    }
    @FindBy(xpath="//label[@label='2']")
private WebElement IncreaseQty;
    public WebElement getIncreaseQty() {
        return IncreaseQty;
    }
}