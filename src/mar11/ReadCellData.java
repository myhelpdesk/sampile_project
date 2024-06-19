package mar11;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadCellData {

	public static void main(String[] args) throws Throwable {

		//Read path of excel file
		FileInputStream fi = new FileInputStream("D:\\Selenium\\selenium live project\\Sample Excel.xlsx");
		//get workbook from file
		XSSFWorkbook workBook = new XSSFWorkbook(fi);
		//get sheet from workbook
		XSSFSheet workSheet = workBook.getSheet("Employ");
		//get fifth row from sheet
		XSSFRow row = workSheet.getRow(5);
		//count number of rows in employ sheet
		int rc = workSheet.getLastRowNum();
		System.out.println("number of rows are::"+rc);
		//get each cell from row
		XSSFCell c1 = row.getCell(0);
		XSSFCell c2 = row.getCell(1);
		XSSFCell c3 = row.getCell(2);
		XSSFCell c4 = row.getCell(3);
		//read each cell data
		//fname means 5th row first cell data
		String fname = c1.getStringCellValue();
		String mname = c2.getStringCellValue();
		String lname = c3.getStringCellValue();
		//HERE getNumericCellValue METHOD RETURN DOUBLE TYPE
		//IN EXCEL SHEET EMPLOY ID(eid) STORE A INT TYPE BECAUSE OF THAT I AM CHANGING DOUBLE TYPE TO INTEGER TYPE, THATS WHY I AM ADDING TYPECAST((int))
		int eid = (int) c4.getNumericCellValue();
		System.out.println(fname+" "+mname+" "+lname+" "+eid);
		fi.close();
		workBook.close();
		
		
		
		
		
		
		
		
		
		
		
	}

}
