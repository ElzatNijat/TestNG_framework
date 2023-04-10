package package1Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Utilities.Constants;

public class writeExcelTest {

	public static void main(String[] args) throws IOException {
		
		// open connection to the file
		FileInputStream fs = new FileInputStream(Constants.excelDocument_path);
		
		// get a workbook open
		  XSSFWorkbook workbook = new XSSFWorkbook(fs);
		  
		 // create sheet
		  XSSFSheet sheet2 = workbook.createSheet("Sheet2");
	      XSSFSheet sheet = workbook.createSheet("Sheet3");
	      
		 Object[][] data = {
	                {"Head First Java", "zzz", 79},
	                {"Effective Java", "fff", 36},
	                {"Clean Code", "bbb", 42},
	                {"Thinking in Java", "yyy", 35},
	        };
		
		for(int i = 0; i< data.length; i++) {
			Row row = sheet2.createRow(i);
			for (int j = 0; j < data[i].length; j++) {
			
			Cell cell = row.createCell(j);
	
			if (data[i][j] instanceof String) {
				cell.setCellValue((String) data[i][j]);
			} else if (data[i][j] instanceof Double) {
				cell.setCellValue((Double) data[i][j]);
			} else if (data[i][j] instanceof Boolean) {
				cell.setCellValue((Boolean) data[i][j]);
			} else if (data[i][j] instanceof Integer) {
				cell.setCellValue((Integer) data[i][j]);
			} else {
				cell.setCellValue((String) null);
			}
			

			}	
		}
		
		FileOutputStream fos = new FileOutputStream(Constants.excelDocument_path);
		
		workbook.write(fos);
		
		fos.close();
		
		
		
	}

}
