package makeMyTrip;

import java.util.ArrayList;
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

import com.relevantcodes.extentreports.LogStatus;

@Listeners(org.genriclib.ListnerClass.class)
public class FilterAndGetTheFlightDetailsTest extends BaseClass {

	WebDriverUtility wLib = new WebDriverUtility();

	ExcelUtility eLib = new ExcelUtility();

	@Test
	public void getFligtDetails() throws Throwable {

		BaseClass.test = BaseClass.reports.startTest("getFligtDetails");

		driver.get(IConstants.filePath);

		wLib.waitForElementsInDOM(driver);

		HomePage hp = new HomePage(driver);

		//wLib.switchToFrame(driver, "webklipper-publisher-widget-container-notification-frame");

		//hp.closeFrame();

		//hp.clickonLoginOrCreateBtn();

		hp.clickOnSearchBtn();

		hp.clickOnClosePopUpBtn();


		try {
			hp.clickGetMore();
		} catch (Exception e) {

		}

		List<WebElement> list = hp.getAvailableFlights();

		for (WebElement wb : list) {
			String text = wb.getText();
			for (int i = 0; i < text.length(); i++) {
				for(int j = i+1; j < text.length(); j++) {
					if(text.charAt(i) == '(' && text.charAt(j) == ')') {
						int noOfFlights = Integer.parseInt(text.substring((i+1), j));
						if(noOfFlights > 5 && noOfFlights < 10) {
							wb.click();
						}
					}
				}
			}
		}

		List<WebElement> flightNames = hp.getFlightNames();
		List<WebElement> flightCodes = hp.getFlightCodes();
		List<WebElement> departTime = hp.getDepartTime();
		List<WebElement> departPlace = hp.getDepartPlace();
		List<WebElement> travelTime = hp.getTravelTime();
		List<WebElement> destTimes = hp.getDepartTime();
		List<WebElement> destPlaces = hp.getDepartPlace();
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

		eLib.writeDataToExcel(wb);
		
		int lastRow = eLib.getRowCount(wb, "FlightDetails");
		int lastCell = eLib.getCellCount(wb, "FlightDetails", lastRow);
		
		for (int i = 0; i < lastRow; i++) {	
			Row ro = eLib.getRow(wb, "FlightDetails", (i+1));	
			for (int k = 0; k < lastCell; k++) {		
				System.out.print(eLib.getCell(ro, k)+" ");		
			}	
			System.out.println();	
		}

		BaseClass.test.log(LogStatus.PASS, "Passed");

	}

}