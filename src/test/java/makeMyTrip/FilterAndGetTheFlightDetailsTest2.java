package makeMyTrip;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.genriclib.BaseClass;
import org.genriclib.ExcelUtility;
import org.genriclib.IConstants;
import org.genriclib.WebDriverUtility;
import org.makemytrippomropsitory.HomePage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(org.genriclib.ListnerClass.class)
public class FilterAndGetTheFlightDetailsTest2 extends BaseClass {

	WebDriverUtility wLib = new WebDriverUtility();
	ExcelUtility eLib = new ExcelUtility();

	@Test
	public void getFligtDetails() throws Throwable {

		driver.get(IConstants.filePath);

		wLib.waitForElementsInDOM(driver);

		HomePage hp = new HomePage(driver);

		wLib.switchToFrame(driver, "webklipper-publisher-widget-container-notification-frame");

		hp.closeFrame();

		hp.clickonLoginOrCreateBtn();

		hp.clickOnSearchBtn();

		hp.clickOnClosePopUpBtn();

		try {
			hp.clickGetMore();
		} catch (Exception e) {
		}

		List<WebElement> list = hp.getAvailableFlights();
		ArrayList<Integer> li = new ArrayList<Integer>();

		int e = 1;
		int h = 1;

		do{
			for (WebElement wb : list) {
				String text = wb.getText();
				for (int i = 0; i < text.length(); i++) {
					for(int j = i+1; j < text.length(); j++) {
						if(text.charAt(i) == '(' && text.charAt(j) == ')') {
							int noOfFlights = Integer.parseInt(text.substring((i+1), j));
							if(e == 1) {	
								li.add(noOfFlights);
							}
							else if(e == 0) {
								if(noOfFlights == li.get(h)) {
									wb.click();
									e--;
								}
							}
						}
					}
				}
			}
			if(e == 1) {
				Collections.sort(li);
				h = li.size()/4;
				e--;
			}
		} while(e == 0);

		List<WebElement> flightNames = hp.getFlightNames();
		List<WebElement> flightCodes = hp.getFlightCodes();
		List<WebElement> departTime = hp.getDepartTime();
		List<WebElement> departPlace = hp.getDepartPlace();
		List<WebElement> travelTime = hp.getTravelTime();
		List<WebElement> destTimes = hp.getDestTime();
		List<WebElement> destPlaces = hp.getDestPlace();
		List<WebElement> prices = hp.getFlightPrice();

		ArrayList<Object[]> ar = new ArrayList<Object[]>();

		for (int i = 0; i < flightNames.size(); i++) {
			String fn = flightNames.get(i).getText();
			String fc = flightCodes.get(i).getText();
			String dpt = departTime.get(i).getText();
			String dp = departPlace.get(i).getText();
			String tt = travelTime.get(i).getText();
			String dst = destTimes.get(i).getText();
			String dsp = destPlaces.get(i).getText();
			String pr = prices.get(i).getText();

			ar.add(new Object[] {fn, fc, dpt, dp, tt, dst, dsp, pr});
		}

		Workbook wb = eLib.getWorkbook();

		int j = 0;

		for (int i = 0; i < ar.size(); i++) {
			Object[] arr = ar.get(i);
			Row ro = eLib.createRow(wb, "FlightDetails", (i+1));
			for (Object ob : arr) {
				eLib.createCellAndSetCellValue(ro, j++, ob.toString());
			}
			j = 0;
		}
		
		Object[] ob = ar.get(0);
		
		int l = ob.length;

		eLib.writeDataToExcel(wb);
		
		for (int i = 0; i < flightNames.size(); i++) {	
			Row ro = eLib.getRow(wb, "FlightDetails", (i+1));	
			for (int k = 0; k < l; k++) {		
				System.out.print(eLib.getCell(ro, k)+" ");		
			}	
			System.out.println();	
		}
		
	}

}