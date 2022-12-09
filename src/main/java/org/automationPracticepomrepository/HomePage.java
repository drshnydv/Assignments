package org.automationPracticepomrepository;

import org.genriclib.WebDriverUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public HomePage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//ul[@id='homefeatured']//div/a[@title='Faded Short Sleeve T-shirts']")
	private WebElement product1;
	
	@FindBy(xpath = "//ul[@id='homefeatured']//div/a[@title='Blouse']")
	private WebElement product2;
	
	@FindBy(xpath = "//ul[@id='homefeatured']//a[contains(.,'Faded Short')]/parent::h5/following-sibling::div/a/span[text()='Add to cart']")
	private WebElement addToCartPro1;
	
	@FindBy(xpath = "//ul[@id='homefeatured']//p[contains(.,'Short sleeved')]/following-sibling::div/a/span[text()='Add to cart']")
	private WebElement addToCartPro2;
	
	@FindBy(xpath = "//span[@title='Close window']")
	private WebElement closePopUp;
	
	@FindBy(xpath = "//a[@title='View my shopping cart']")
	private WebElement cartBtn;
	
	@FindBy(xpath = "//a[@id='button_order_cart']")
	private WebElement checkOutBtn;

	public WebElement getProduct1() {
		return product1;
	}

	public WebElement getProduct2() {
		return product2;
	}

	public WebElement getAddToCartPro1() {
		return addToCartPro1;
	}

	public WebElement getAddToCartPro2() {
		return addToCartPro2;
	}

	public WebElement getClosePopUp() {
		return closePopUp;
	}

	public WebElement getCartBtn() {
		return cartBtn;
	}

	public WebElement getCheckOutBtn() {
		return checkOutBtn;
	}
	
	WebDriverUtility wLib = new WebDriverUtility();
	
	public void moveToProduct1andAddToProduct1(WebDriver driver) {
		
		wLib.moveToElement(driver, getProduct1());
		
		getAddToCartPro1().click();
		
	}
	
	public void closePopUp() {
		
		getClosePopUp().click();
		
	}
	
	public void moveToProduct2AndAddToProduct2(WebDriver driver) {
		
		wLib.moveToElement(driver, getProduct2());
		
		getAddToCartPro2().click();
		
	}
	
	public void moveToMyCartAndClickOnCeckOutBtn(WebDriver driver) {
		
		wLib.moveToElement(driver, getCartBtn());
		
		getCheckOutBtn().click();
		
	}
	
}