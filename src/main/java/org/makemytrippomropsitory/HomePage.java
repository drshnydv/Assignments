package org.makemytrippomropsitory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public HomePage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//i[@class='wewidgeticon we_close']")
	private WebElement closeFrameBtn;	
	
	@FindBy(xpath = "//div[@class='loginModal displayBlock modalLogin dynHeight personal']")
	private WebElement loginOrCreateBtn;

	@FindBy(xpath = "//a[text()='Search']")
	private WebElement searchBtn;
	
	@FindBy(xpath = "//span[@class='bgProperties icon20 overlayCrossIcon']")
	private WebElement popUpCloseBtn;
	
	@FindBy(xpath = "//p[text()='Popular Filters']/following-sibling::div/p/span[@class='linkText pointer']")
	private WebElement getMoreBtn;
	
	@FindBy(xpath = "//p[text()='Popular Filters']/following-sibling::div/descendant::span[@class='filterName']")
	private List<WebElement> availableFlights;

	@FindBy(xpath = "//p[@class='boldFont blackText airlineName']")
	private List<WebElement> flightNames;
	
	@FindBy(xpath = "//p[@class='fliCode']")
	private List<WebElement> flightCodes;
	
	@FindBy(xpath = "//div[@class='flexOne timeInfoLeft']//span")
	private List<WebElement> departTime;
	
	@FindBy(xpath = "//div[@class='flexOne timeInfoLeft']//font")
	private List<WebElement> departPlace;
	
	@FindBy(xpath = "//div[@class='stop-info flexOne']/p")
	private List<WebElement> travelTime;
	
	@FindBy(xpath = "//div[@class='flexOne timeInfoRight']/p/span")
	private List<WebElement> destTime;
	
	@FindBy(xpath = "//div[@class='flexOne timeInfoRight']//font")
	private List<WebElement> destPlace;
	
	@FindBy(xpath = "//p[@class='blackText fontSize18 blackFont white-space-no-wrap']")
	private List<WebElement> flightPrice;

	public WebElement getCloseFrameBtn() {
		return closeFrameBtn;
	}

	public WebElement getLoginOrCreateBtn() {
		return loginOrCreateBtn;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getPopUpCloseBtn() {
		return popUpCloseBtn;
	}

	public WebElement getGetMoreBtn() {
		return getMoreBtn;
	}

	public List<WebElement> getAvailableFlights() {
		return availableFlights;
	}

	public List<WebElement> getFlightNames() {
		return flightNames;
	}

	public List<WebElement> getFlightCodes() {
		return flightCodes;
	}

	public List<WebElement> getDepartTime() {
		return departTime;
	}

	public List<WebElement> getDepartPlace() {
		return departPlace;
	}

	public List<WebElement> getTravelTime() {
		return travelTime;
	}

	public List<WebElement> getDestTime() {
		return destTime;
	}

	public List<WebElement> getDestPlace() {
		return destPlace;
	}

	public List<WebElement> getFlightPrice() {
		return flightPrice;
	}

	public void clickOnSearchBtn() {
		
		getSearchBtn().click();
		
	}
	
	public void clickOnClosePopUpBtn() {
		
		getPopUpCloseBtn().click();
		
	}
	
	public void closeFrame() {
		
		getCloseFrameBtn().click();
		
	}
	
	public void clickonLoginOrCreateBtn() {
		
		getLoginOrCreateBtn().click();
		
	}
	
	public void clickGetMore() {
		
		getGetMoreBtn().click();
		
	}
	
}