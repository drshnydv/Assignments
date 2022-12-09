package org.automationPracticepomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyCartPage {
	
	public MyCartPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//p/a[@title='Proceed to checkout']")
	private WebElement proceedToCheckOutBtn;
	
	@FindBy(xpath = "//table/tfoot/tr/td[3]")
	private WebElement productPrice;
	
	@FindBy(xpath = "//table/tfoot/tr[3]/td[2]")
	private WebElement shippingPrice;
	
	@FindBy(xpath = "//table/tfoot/tr[7]/td[2]")
	private WebElement totalPrice;

	public WebElement getProceedToCheckOutBtn() {
		return proceedToCheckOutBtn;
	}

	public WebElement getProductPrice() {
		return productPrice;
	}

	public WebElement getShippingPrice() {
		return shippingPrice;
	}

	public WebElement getTotalPrice() {
		return totalPrice;
	}

}