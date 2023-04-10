package package1Test;

import java.io.IOException;

import Utilities.Constants;
import Utilities.ExcelUtility;

public class testingExcelUtility {

	public static void main(String[] args) throws IOException {
		
				
		Object[][] data =ExcelUtility.readExcelFile(Constants.excelDocument_path, "Sheet1");
		
		
		for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
		
		
        Object[][] data1 = {{"John", 25, true}, {"Mary", 30, false}, {"Bob", 40, true}};
		
		ExcelUtility.writeExcelFile(Constants.excelDocument_path, "Sheet1", data1);
		

	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
