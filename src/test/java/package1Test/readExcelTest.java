package package1Test;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Utilities.Constants;

public class readExcelTest {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fs = new FileInputStream(Constants.excelDocument_path);
		
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        
//		Row row = sheet.getRow(1);
//		Cell cell = row.getCell(2);
//		
//		System.out.println(cell);
        
        for(Row row: sheet) {
        	
        	for(Cell cell: row) {
        		
        	switch(cell.getCellType()) {
        	
        	case BOOLEAN:
        		System.out.println(cell.getBooleanCellValue());
        		break;
        	case NUMERIC:
        		System.out.println(cell.getNumericCellValue());
        		break;
        	case STRING:
        		System.out.println(cell.getStringCellValue());
        		break;
        	case FORMULA:
        		System.out.println(cell.getCellFormula());
        		break;
        	}
        	System.out.println(" ");
        		
        	
        	}
        	
        	
        }
		
		workbook.close();

	}

}
