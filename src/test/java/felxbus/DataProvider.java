package felxbus;

import org.genriclib.ExcelUtility;

public class DataProvider {
	
	ExcelUtility eLib = new ExcelUtility();
	
	@org.testng.annotations.DataProvider
	public Object[][] dataForFlexBus() throws Throwable {
		Object[][] ob = new Object[5][5];
		
		String trip1 = eLib.getExcelData("FlexBus", 1, 0);
		String f1Scr = eLib.getExcelData("FlexBus", 1, 1);
		String f1dst = eLib.getExcelData("FlexBus", 1, 2);
		String f1DpD = eLib.getExcelData("FlexBus", 1, 3);
		String f1ReD = eLib.getExcelData("FlexBus", 1, 4);
		String trip2 = eLib.getExcelData("FlexBus", 2, 0);
		String f2Scr = eLib.getExcelData("FlexBus", 2, 1);
		String f2dst = eLib.getExcelData("FlexBus", 2, 2);
		String f2DpD = eLib.getExcelData("FlexBus", 2, 3);
		String f2ReD = eLib.getExcelData("FlexBus", 2, 4);
		String trip3 = eLib.getExcelData("FlexBus", 3, 0);
		String f3Scr = eLib.getExcelData("FlexBus", 3, 1);
		String f3dst = eLib.getExcelData("FlexBus", 3, 2);
		String f3DpD = eLib.getExcelData("FlexBus", 3, 3);
		String f3ReD = eLib.getExcelData("FlexBus", 3, 4);
		String trip4 = eLib.getExcelData("FlexBus", 4, 0);
		String f4Scr = eLib.getExcelData("FlexBus", 4, 1);
		String f4dst = eLib.getExcelData("FlexBus", 4, 2);
		String f4DpD = eLib.getExcelData("FlexBus", 4, 3);
		String f4ReD = eLib.getExcelData("FlexBus", 4, 4);
		String trip5 = eLib.getExcelData("FlexBus", 5, 0);
		String f5Scr = eLib.getExcelData("FlexBus", 5, 1);
		String f5dst = eLib.getExcelData("FlexBus", 5, 2);
		String f5DpD = eLib.getExcelData("FlexBus", 5, 3);
		String f5ReD = eLib.getExcelData("FlexBus", 5, 4);
		
		ob[0][0] = trip1;
		ob[0][1] = f1Scr;
		ob[0][2] = f1dst;
		ob[0][3] = f1DpD;
		ob[0][4] = f1ReD;
		ob[1][0] = trip2;
		ob[1][1] = f2Scr;
		ob[1][2] = f2dst;
		ob[0][3] = f2DpD;
		ob[0][4] = f2ReD;
		ob[2][0] = trip3;
		ob[2][1] = f3Scr;
		ob[2][2] = f3dst;
		ob[0][3] = f3DpD;
		ob[0][4] = f3ReD;
		ob[3][0] = trip4;
		ob[3][1] = f4Scr;
		ob[3][2] = f4dst;
		ob[0][3] = f4DpD;
		ob[0][4] = f4ReD;
		ob[4][0] = trip5;
		ob[4][1] = f5Scr;
		ob[4][2] = f5dst;
		ob[0][3] = f5DpD;
		ob[0][4] = f5ReD;
		
		return ob;
	}

}