package org.genriclib;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnerClass implements ITestListener{
	
	public void onTestFailure(ITestResult result) {
		
		String testName = result.getMethod().getMethodName();
		
		TakesScreenshot ts = (TakesScreenshot) BaseClass.sDriver;
		
		File scr = ts.getScreenshotAs(OutputType.FILE);
		
		File dst = new File("./screenshots/"+testName+"abc.png");
		
		try {
			
			FileUtils.copyFile(scr, dst);
			
		} catch (IOException e) {
			
		}
		
	}

}