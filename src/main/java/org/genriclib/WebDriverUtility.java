package org.genriclib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	public void waitForElementsInDOM(WebDriver driver) {	
		driver.manage().timeouts().implicitlyWait(IConstants.implicitTime, TimeUnit.SECONDS);	
	}
	
	public void switchToFrame(WebDriver driver, String frameId) {	
		driver.switchTo().frame(frameId);	
	}
	
	public void waitForFrameAndSwitch(WebDriver driver, WebElement element) {	
		WebDriverWait wait = new WebDriverWait(driver, IConstants.explicitTime);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void moveToElement(WebDriver driver, WebElement element) {	
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();;	
	}
	
	public void scrolToElement(WebDriver driver,WebElement element) {	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);	
	}
	
	public Double convertStringToDobule(String string) {
		return Double.parseDouble(string);
	}
	
	public String replaceCharacterSequence(String value, String seqTobeReplaced, String seq) {	
		return value.replace(seqTobeReplaced, seq);
	}
	
}