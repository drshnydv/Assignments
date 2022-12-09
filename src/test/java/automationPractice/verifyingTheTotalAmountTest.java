package automationPractice;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.automationPracticepomrepository.HomePage;
import org.automationPracticepomrepository.MyCartPage;
import org.genriclib.BaseClass;
import org.genriclib.ExcelUtility;
import org.genriclib.WebDriverUtility;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(org.genriclib.ListnerClass.class)
public class verifyingTheTotalAmountTest extends BaseClass{

	@Test
	public void verifyTotalCostTest() throws Throwable {

		WebDriverUtility wLib = new WebDriverUtility();
		
		ExcelUtility eLib = new ExcelUtility();
		
		Workbook wb = eLib.getWorkbook();
		
		//getting prices from excel to verify
		Row ro = eLib.getRow(wb, "AutomationPractice", 1);
		
		double pp = wLib.convertStringToDobule(eLib.getCell(ro, 0));
		double sp = wLib.convertStringToDobule(eLib.getCell(ro, 1));
		double tp = wLib.convertStringToDobule(eLib.getCell(ro, 2));

		//url
		driver.get("http://automationpractice.com/");

		wLib.waitForElementsInDOM(driver);

		HomePage hp = new HomePage(driver);

		//mouse over product1 and adding to cart
		hp.moveToProduct1andAddToProduct1(driver);

		hp.closePopUp();

		//mouse over product1 and adding to cart
		hp.moveToProduct2AndAddToProduct2(driver);

		hp.closePopUp();

		//click on check out
		hp.moveToMyCartAndClickOnCeckOutBtn(driver);

		MyCartPage mp = new MyCartPage(driver);

		WebElement ele = mp.getProceedToCheckOutBtn();

		wLib.moveToElement(driver, ele);
		
		//getting prices from GUI
		String pprice = mp.getProductPrice().getText();
		String sprice = mp.getShippingPrice().getText();
		String tprice = mp.getTotalPrice().getText();
		
		//removing '$' symbol from the string for parsing
		String p = wLib.replaceCharacterSequence(pprice, "$", "");
		String s = wLib.replaceCharacterSequence(sprice, "$", "");
		String t = wLib.replaceCharacterSequence(tprice, "$", "");

		//convert prices from string formate to double format
		double pPrice = wLib.convertStringToDobule(p);
		double sPrice = wLib.convertStringToDobule(s);
		double tPrice=wLib.convertStringToDobule(t);
		
		//adding the prices to get total price
		double totalPrice = pPrice + sPrice;
		
		Assert.assertEquals(pPrice, pp);
		System.out.println("Product Price "+pp+" ==> verified");
		
		Assert.assertEquals(sPrice, sp);
		System.out.println("Shipping Price "+sp+" ==> verified");
		
		Assert.assertEquals(tPrice, totalPrice);
		System.out.println("Sum of Product price ==> "+totalPrice+" is same as in the Excel");
		
		Assert.assertEquals(totalPrice, tp);
		System.out.println("Product Price "+tp+" ==> verified");
		
	}

}