package org.pomrepositorylib;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public LoginPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id = "login_id")
	private WebElement emailTb;
	
	@FindBy(xpath = "//button/span[text()='Next']")
	private WebElement nextBtn;
	
	@FindBy(id = "password")
	private WebElement passwordTb;
	
	@FindBy(xpath = "//button/span[text()='Sign in']")
	private WebElement signInBtn;

	public WebElement getSignInBtn() {
		return signInBtn;
	}

	public WebElement getPasswordTb() {
		return passwordTb;
	}

	public WebElement getNextBtn() {
		return nextBtn;
	}

	public WebElement getEmailTb() {
		return emailTb;
	}
	
	public void login() {
		
		getEmailTb().sendKeys("abcd987@yahoo.com");
		
		getNextBtn().click();
		
		getPasswordTb().sendKeys("Abcd@#123");
		
		getSignInBtn().click();
		
	}
	
}