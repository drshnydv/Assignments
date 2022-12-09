package Instagram;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.genriclib.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.instagramrepository.HomePage;
import com.instagramrepository.LoginPage;
import com.instagramrepository.ProfilePage;

public class FollowersList extends BaseClass{

	@Test
	public void getFollowersList() throws Throwable {

		driver.get("https://www.instagram.com/");

		String username = eLib.getExcelData("Instagram", 1, 0);
		String password = eLib.getExcelData("Instagram", 1, 1);

		LoginPage lp = new LoginPage(driver);
		lp.Login(driver, username, password);

		HomePage hp = new HomePage(driver);
		hp.clickNotNow(driver);
		hp.clickNotNow(driver);
		hp.getSearchBtn().click();
		hp.enterValueSearch("mysorefood");
		Thread.sleep(3000);
		hp.clickOnIdFromSearch(driver, "mysoreblogger");

		ProfilePage pp = new ProfilePage(driver);
		pp.clickFollowersBtn(driver);
		WebElement popUp = pp.getFollowersPopUp();
		Thread.sleep(3000);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		ArrayList<Integer> wb = new ArrayList<Integer>();

		wb.add(1);

		Workbook wrkBk = eLib.getWorkbook();
		
		int j = 1;
		
		while(true) {
			js.executeScript("arguments[0].scrollTop = arguments[0].scrollTop + arguments[0].scrollHeight;", popUp);
			
			System.out.println(j++);

			List<WebElement> userName = pp.getTotalNames();
			
			int size = userName.size();
			wb.add(size);

			int lastButOne = wb.get(wb.size()-2);
			int last = wb.get(wb.size()-1);
			if(lastButOne == last) {
				for (int i = 0; i < userName.size(); i++) {
					Row ro = eLib.createRow(wrkBk, "InstagramFollowersNameLengthy", i+1);	
					String usrNm = userName.get(i).getText();
					try {
						String fulNm = pp.getFullName(driver, usrNm);
						eLib.createCellAndSetCellValue(ro, 0, usrNm);
						eLib.createCellAndSetCellValue(ro, 1, fulNm);
					}
					catch(Exception e) {
						eLib.createCellAndSetCellValue(ro, 0, usrNm);
						System.out.println("catch "+usrNm);
					}				
				}
				break;
			}
			Thread.sleep(7000);
		}
		eLib.writeDataToExcel(wrkBk);
	}
}