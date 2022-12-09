package com.instagramrepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {
	
	public ProfilePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[text()=' followers']/parent::a")
	private WebElement followersBtn;
	
	@FindBy(xpath = "//div[@class='_aano']")
	private WebElement followersPopUp;
	
	@FindBy(xpath = "//div[@class=' _ab8y  _ab94 _ab97 _ab9f _ab9k _ab9p _abcm']")
	private List<WebElement> totalNames;
	
	@FindBy(xpath = "(//div[@class='_aabd _aa8k _aanf']/a)[1]")
	private WebElement firstImage;
	
	@FindBy(xpath = "//*[local-name()='svg' and @aria-label='Next']")
	private WebElement nextBtn;
	
	@FindBy(xpath = "//div[@class='_aagu _aato']//img")
	private List<WebElement> img;
	
	@FindBy(xpath = "//button[@aria-label='Next' and @class=' _afxw']")
	private WebElement nextBtnInsideImage;
	
	@FindBy(xpath = "//div[@class='_aacl _aacm _aacu _aacy _aad6']/time")
	private WebElement postedDate;
	
	@FindBy(xpath = "//div[@class='_aacl _aaco _aacw _aacx _aada _aade']/span")
	private WebElement likes;
	
	@FindBy(xpath = "//span[@class='_aauw']/div[@class='_aacl _aaco _aacw _aacx _aad6 _aade']/span")
	private WebElement alternativeLikes;
	
	@FindBy(xpath = "//h3//span[@class='_aap6 _aap7 _aap8']/a")
	private List<WebElement> totalComents;

	public List<WebElement> getImg() {
		return img;
	}

	public WebElement getNextBtnInsideImage() {
		return nextBtnInsideImage;
	}

	public WebElement getPostedDate() {
		return postedDate;
	}

	public WebElement getLikes() {
		return likes;
	}

	public WebElement getAlternativeLikes() {
		return alternativeLikes;
	}

	public List<WebElement> getTotalComents() {
		return totalComents;
	}

	public WebElement getNextBtn() {
		return nextBtn;
	}

	public WebElement getFirstImage() {
		return firstImage;
	}

	public List<WebElement> getTotalNames() {
		return totalNames;
	}

	public WebElement getFollowersPopUp() {
		return followersPopUp;
	}

	public WebElement getFollowersBtn() {
		return followersBtn;
	}
	
	public void clickFollowersBtn(WebDriver driver) {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(getFollowersBtn()));
		
		getFollowersBtn().click();
	}
	
	public String getFullName(WebDriver driver, String userName) {
		return driver.findElement(By.xpath("//div[text()='"+userName+"']/ancestor::div[@class='_ab8w  _ab94 _ab99 _ab9f _ab9m _ab9p _abcm']/following-sibling::div/div")).getText();
	}
	
	public void clickOnImage(WebDriver driver) {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(getFirstImage()));
		
		getFirstImage().click();
	}
	
	public void clickOnNextBtn() {
		getNextBtn().click();
	}
	
	public void clickOnNextInsideImage() {
		getNextBtnInsideImage().click();
	}
	
	public String postedDate() {
		return getPostedDate().getText();
	}
	
	public String likes() {
		return getLikes().getText();
	}
	
	public String alternativeLikes() {
		return getAlternativeLikes().getText();
	}
	
	public String getComment(WebDriver driver, String name) {
		return driver.findElement(By.xpath("//a[text()='" + name + "']/ancestor::h3/following-sibling::div/span[@class='_aacl _aaco _aacu _aacx _aad7 _aade']")).getText();
	}
	
	public String getCaption(WebDriver driver, String name) {
		return driver.findElement(By.xpath("//a[text()='"+name+"']/ancestor::div[@class='_a9zr']//span[@class='_aacl _aaco _aacu _aacx _aad7 _aade']")).getText();
	}
}