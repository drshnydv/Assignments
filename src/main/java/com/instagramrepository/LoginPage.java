package com.instagramrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "username")
	private WebElement userTb;

	@FindBy(name = "password")
	private WebElement passwordTb;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submitBtn;

	public WebElement getUserTb() {
		return userTb;
	}

	public WebElement getPasswordTb() {
		return passwordTb;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public void Login(WebDriver driver, String username, String password) {
		getUserTb().sendKeys(username);
		getPasswordTb().sendKeys(password);
		
		WebDriverWait wb = new WebDriverWait(driver, 10);
		wb.until(ExpectedConditions.elementToBeClickable(getSubmitBtn()));
		
		getSubmitBtn().click();
	}

}