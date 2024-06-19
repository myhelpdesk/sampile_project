package mar11;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class RowCellCount {
	
	public static void main(String[] args) throws Throwable {
		
		//read path of excel file
				FileInputStream fi = new FileInputStream("D:\\Selenium\\selenium live project\\Sample Excel.xlsx");
				//get workbook from file
				XSSFWorkbook workBook = new XSSFWorkbook(fi);
				//get sheet from workbook
				XSSFSheet workSheet = workBook.getSheet("Employ");
				//get first row from Employ sheet
				XSSFRow row = workSheet.getRow(0);
				//count number of cells in first row
				int cc = row.getLastCellNum();
				//count number of rows in employ sheet
				int rc = workSheet.getLastRowNum();
				System.out.println("number of rows in sheet::"+rc+"  "+"numbr of cells in first row::"+cc);
				fi.close();
				workBook.close();
	}

}
