package org.flexbusrepositorylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "search-mask-trip-mode-oneway-toggle")
	private WebElement oneWayBtn;

	@FindBy(id = "search-mask-trip-mode-roundtrip-toggle")
	private WebElement roundTripBtn;

	@FindBy(id = "searchInput-from")
	private WebElement fromTb;

	@FindBy(xpath = "(//button[@class='ob_qZ'])[1]")
	private WebElement fromPlaceDrpDn;

	@FindBy(id = "searchInput-to")
	private WebElement toTb;

	@FindBy(xpath = "(//button[@class='ob_qZ'])[1]")
	private WebElement toPlaceDrpDn;

	@FindBy(id = "dateInput-from")
	private WebElement departureDrpDn;

	@FindBy(xpath = "//div[@class='hcr-clndr__month-4-5-2']/preceding-sibling::div//caption/h3")
	private WebElement monthtxt;

	@FindBy(xpath = "//table//h3[text()='November 2022']/parent::caption/following-sibling::tbody/tr[*]/td//span[text()='15']")
	private WebElement selectDepartureDate;

	@FindBy(xpath = "//button[@aria-label='Next month']")
	private WebElement nextMonthBtn;

	@FindBy(id = "dateInput-to")
	private WebElement returnDrpDn;

	@FindBy(xpath = "//table//h3[text()='November 2022']/parent::caption/following-sibling::tbody/tr[*]/td//span[text()='27']")
	private WebElement selectReturnDate;

	@FindBy(id = "productSummary")
	private WebElement detailsDrpDn;

	@FindBy(xpath = "//div[text()='Adults']/parent::div/following-sibling::div//input[@type='number']/following-sibling::button")
	private WebElement adultsIncBtn;

	@FindBy(xpath = "//div[text()='Children']/parent::div/following-sibling::div//input[@type='number']/following-sibling::button")
	private WebElement chlidrenIncBtn;

	@FindBy(xpath = "//div[text()='Bikes']/parent::div/following-sibling::div//input[@type='number']/following-sibling::button")
	private WebElement bikesIncBtn;

	@FindBy(xpath = "//button[text()='Search']")
	private WebElement searchBtn;

	public WebElement getOneWayBtn() {
		return oneWayBtn;
	}

	public WebElement getRoundTripBtn() {
		return roundTripBtn;
	}

	public WebElement getFromTb() {
		return fromTb;
	}

	public WebElement getFromPlaceDrpDn() {
		return fromPlaceDrpDn;
	}

	public WebElement getToTb() {
		return toTb;
	}

	public WebElement getToPlaceDrpDn() {
		return toPlaceDrpDn;
	}

	public WebElement getDepartureDrpDn() {
		return departureDrpDn;
	}

	public WebElement getMonthtxt() {
		return monthtxt;
	}

	public WebElement getSelectDepartureDate() {
		return selectDepartureDate;
	}

	public WebElement getNextMonthBtn() {
		return nextMonthBtn;
	}

	public WebElement getReturnDrpDn() {
		return returnDrpDn;
	}

	public WebElement getSelectReturnDate() {
		return selectReturnDate;
	}

	public WebElement getDetailsDrpDn() {
		return detailsDrpDn;
	}

	public WebElement getAdultsIncBtn() {
		return adultsIncBtn;
	}

	public WebElement getChlidrenIncBtn() {
		return chlidrenIncBtn;
	}

	public WebElement getBikesIncBtn() {
		return bikesIncBtn;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public void selectFromAndToPlaces(String scr, String dst) throws Throwable {
		getFromTb().sendKeys(scr);
		getFromPlaceDrpDn().click();
		getToTb().sendKeys(dst);
		getToPlaceDrpDn().click();
	}

	public void selectDepartureDate(WebDriver driver, String date) throws Throwable {
		getDepartureDrpDn().click();

		while(true) {
			String month = getMonthtxt().getText();
			String[] s = date.split("-");
			String[] t = month.split(" ");
			if(t[0].equalsIgnoreCase(s[0]) && t[1].equalsIgnoreCase(s[1])) {
				driver.findElement(By.xpath("//table//h3[text()='"+s[0]+" "+s[1]+"']/parent::caption/following-sibling::tbody/tr[*]/td//span[text()='"+s[2]+"']/parent::button")).click();
				break;
			}
			else {
				getNextMonthBtn().click();
			}
		}
	}

	public void selectReturnDate(WebDriver driver, String date) throws Throwable {
		getReturnDrpDn().click();

		while(true) {
			String month = getMonthtxt().getText();
			String[] s = date.split("-");
			String[] t = month.split(" ");
			if(t[0].equalsIgnoreCase(s[0]) && t[1].equalsIgnoreCase(s[1])) {
				driver.findElement(By.xpath("//table//h3[text()='"+s[0]+" "+s[1]+"']/parent::caption/following-sibling::tbody/tr[*]/td//span[text()='"+s[2]+"']/parent::button")).click();
				break;
			}
			else {
				getNextMonthBtn().click();
			}
		}
	}

	public void selectPassengerDetails() {
		getDetailsDrpDn().click();
		getAdultsIncBtn().click();
		getChlidrenIncBtn().click();
		getBikesIncBtn().click();
	}

	public void clickOnSearch() {
		getSearchBtn().click();
	}

}