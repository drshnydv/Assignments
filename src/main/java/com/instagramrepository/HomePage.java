package com.instagramrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[text()='Not Now']")
	private WebElement notNowBtn;
	
	@FindBy(xpath = "//div[text()='Profile']")
	private WebElement profileBtn;
	
	@FindBy(xpath = "//*[local-name()='svg' and @aria-label='Search']/ancestor::a")
	private WebElement searchBtn;
	
	@FindBy(xpath = "//input[@aria-label='Search input']")
	private WebElement searchTb;
	
	public WebElement getSearchTb() {
		return searchTb;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getNotNowBtn() {
		return notNowBtn;
	}

	public WebElement getProfileBtn() {
		return profileBtn;
	}
	
	public void clickNotNow(WebDriver driver) {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(getNotNowBtn()));
		getNotNowBtn().click();
	}
	
	public void clickProfile() {
		getProfileBtn().click();
	}
	
	public void enterValueSearch(String value) {
		getSearchTb().sendKeys(value);
	}
	
	public void clickOnIdFromSearch(WebDriver driver, String id) {
		driver.findElement(By.xpath("//div[text()='"+id+"']")).click();
	}
	
}