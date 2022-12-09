package felxbus;

import org.flexbusrepositorylib.HomePage;
import org.genriclib.BaseClass;
import org.genriclib.WebDriverUtility;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(org.genriclib.ListnerClass.class)
public class FlexbusFlightBookingTest extends BaseClass{

	@Test(dataProvider = "dataForFlexBus", dataProviderClass = DataProvider.class)
	public void bookFlightsTest(String trip, String scr, String dst, String depDate, String reDate) throws Throwable {

		driver.get("https://global.flixbus.com/");

		WebDriverUtility wLib = new WebDriverUtility();

		wLib.waitForElementsInDOM(driver);

		HomePage hp = new HomePage(driver);

		if(trip.equalsIgnoreCase("One Way")) {	
			hp.getOneWayBtn().click();
		}

		else if(trip.equalsIgnoreCase("Round Trip")) {
			hp.getRoundTripBtn().click();
		}

		hp.selectFromAndToPlaces(scr, dst);

		hp.selectDepartureDate(driver, depDate);

		try {
			hp.selectReturnDate(driver, reDate);
		} catch (Exception e) {

		}

		hp.selectPassengerDetails();

		hp.clickOnSearch();

	}

}