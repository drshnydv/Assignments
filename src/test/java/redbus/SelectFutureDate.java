package redbus;

import java.util.ArrayList;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import org.genriclib.BaseClass;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SelectFutureDate extends BaseClass{

	@Test
	public void selectDate() throws Throwable {

		int a = 39;

		driver.get("https://www.redbus.com/");

		driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//button[text()='Accept All']")).click();

		driver.findElement(By.xpath("//input[@id='onward_cal']")).click();

		//		driver.findElement(By.xpath("//*[local-name()='svg']")).click();
		//		
		//		driver.findElement(By.xpath("(//*[local-name()='svg'])[2]")).click();

		int k = 1;

		TreeSet<Integer> ts = new TreeSet<Integer>();
		ArrayList<Integer> arr = new ArrayList<Integer>();

		int firstMonth = 0;

		for (int i = 1; i <= 7; i++) {

			String date = driver.findElement(By.xpath("((//div[@class='DatePicker__MainBlock-sc-1x9sb82-1 gTgSRP'])["+k+"]//div[@class='DayTiles__CalendarDaysBlock-sc-14em0t0-0 eUrtce'])["+i+"]")).getText();
			int intDate = Integer.parseInt(date);

			if(intDate == 1) {
				for (int j = i; j <= (i+31); j++) {
					String date1 = driver.findElement(By.xpath("((//div[@class='DatePicker__MainBlock-sc-1x9sb82-1 gTgSRP'])["+k+"]//div[@class='DayTiles__CalendarDaysBlock-sc-14em0t0-0 eUrtce'])["+j+"]")).getText();
					int intDate1 = Integer.parseInt(date1);
					ts.add(intDate1);
				}
				arr.addAll(ts);
				if(k == 1) {
					firstMonth = arr.size();
				}
				ts.removeAll(ts);
				k++;
				i = 1;
			}
			if(k == 3) {
				break;
			}
		}

		String currentDate = driver.findElement(By.xpath("//span[@class='DayTiles__CalendarDaysSpan-sc-14em0t0-1 fxWHuy']")).getText();
		int curDate = Integer.parseInt(currentDate);

		for (int i = 0; i < arr.size(); i++) {
			int dateInArray = arr.get(i);
			if(curDate == dateInArray) {
				int futureDate = arr.get((i+(a-1)));
				System.out.println(futureDate);
				if((i+a) < firstMonth) {
					try {
						driver.findElement(By.xpath("//div[contains(.,'December')]/ancestor::div[@class='DatePicker__MainBlock-sc-1x9sb82-1 gTgSRP']//span[@class='DayTiles__CalendarDaysSpan-sc-14em0t0-1 xaHaF' and text()='"+futureDate+"']")).click();
					}catch(Exception e) {
						driver.findElement(By.xpath("//div[contains(.,'December')]/ancestor::div[@class='DatePicker__MainBlock-sc-1x9sb82-1 gTgSRP']//span[@class='DayTiles__CalendarDaysSpan-sc-14em0t0-1 kseSaZ' and text()='"+futureDate+"']")).click();
					}
				}
				else {
					try {
						driver.findElement(By.xpath("//div[contains(.,'January')]/ancestor::div[@class='DatePicker__MainBlock-sc-1x9sb82-1 gTgSRP']//span[@class='DayTiles__CalendarDaysSpan-sc-14em0t0-1 xaHaF' and text()='"+futureDate+"']")).click();
					}catch(Exception e) {
						driver.findElement(By.xpath("//div[contains(.,'January')]/ancestor::div[@class='DatePicker__MainBlock-sc-1x9sb82-1 gTgSRP']//span[@class='DayTiles__CalendarDaysSpan-sc-14em0t0-1 kseSaZ' and text()='"+futureDate+"']")).click();
					}
				}
				break;
			}
		}
	}
}