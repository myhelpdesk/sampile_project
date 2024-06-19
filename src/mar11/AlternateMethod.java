package mar11;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class AlternateMethod {

	public static void main(String[] args) throws Throwable {
		        //read path of excel
				FileInputStream fi = new FileInputStream("D:\\Selenium\\selenium live project\\Sample Excel.xlsx");
				//get wb
				XSSFWorkbook workBook = new XSSFWorkbook(fi);
				//get sheet from wb
				XSSFSheet workSheet = workBook.getSheet("Employ");
				//count no of rows in sheet
				int rc =workSheet.getLastRowNum();
				System.out.println("No of rows are::"+rc);
				//print any row first cell data
				String fname =workSheet.getRow(6).getCell(0).getStringCellValue();
				//print any row second cell data
				String mname = workSheet.getRow(10).getCell(1).getStringCellValue();
				//print any row third cell data
				String lname = workSheet.getRow(8).getCell(2).getStringCellValue();
				//print any row fourth cell data
				int eid =(int)workSheet.getRow(2).getCell(3).getNumericCellValue();
				System.out.println(fname+"   "+mname+"    "+lname+"   "+eid);
				fi.close();
				workBook.close();
	}

}
