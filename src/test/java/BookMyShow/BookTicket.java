package BookMyShow;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.genriclib.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class BookTicket extends BaseClass{

	@Test
	public void bookTicket() throws Throwable {

		driver.get("https://in.bookmyshow.com/explore/home/bengaluru");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[text()='Search for Movies, Events, Plays, Sports and Activities']")).click();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(""); //==> movie name
		driver.findElement(By.xpath("//div[@class='sc-dXfzlN iPwaRU']/span[text()='']")).click();
		driver.findElement(By.xpath("//div[@class='styles__CtaWrapper-sc-qswwm9-8 JInhj']//button")).click();
		driver.findElement(By.xpath("//div[@class='slick-track']/li[@data-slick-index='1']")).click();

		Workbook wb = eLib.getWorkbook();

		//getting total theaters
		List<WebElement> theaters = driver.findElements(By.xpath("//div[@class='__title']/a"));

		//giving total theaters size for form loop
		for(int i = 0; i < theaters.size(); i++) {
			String theater = theaters.get(i).getText();
			Row ro = eLib.createRow(wb, "BookMyShow", i);
			eLib.createCellAndSetCellValue(ro, 0, theater);

			//getting available timings form one theater
			List<WebElement> timings = driver.findElements(By.xpath("//a[text()='"+theater+"']/ancestor::div[@class='listing-info']/following-sibling::div//div[@class='showtime-pill-container _available']/a/div/div[@class='__text']"));
			
			//giving total number of timings 
			for (int j = 0; j < timings.size(); j++) {
				String time = timings.get(j).getText();
				eLib.createCellAndSetCellValue(ro, (j+2), time);
			}
		}
		eLib.writeDataToExcel(wb);
	}
}