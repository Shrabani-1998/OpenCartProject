package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException{
		
		String path=".\\testData\\Opencart_LoginData.xlsx";
		ExcelUtility excel=new ExcelUtility(path);
		
		int rowCount=excel.getRowCount("Sheet1");
		int cellCount=excel.getCellCount("Sheet1", 1);
		
		String[][] data=new String[rowCount][cellCount];
		for(int r=1;r<=rowCount;r++) {
			for(int c=0;c<cellCount;c++) {
				data[r-1][c]=excel.getCellData("Sheet1", r, c);
			}
		}
		return data;
	}

}
