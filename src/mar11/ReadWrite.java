package mar11;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadWrite {

	public static void main(String[] args) throws Throwable {
		//write a script to read all rows cell data and write status into new workbook
		// read path of file
				FileInputStream fi = new FileInputStream("D:\\Selenium\\selenium live project\\Sample Excel.xlsx");
				//get wb from file
				XSSFWorkbook wb = new XSSFWorkbook(fi);
				//get sheet from wb
				XSSFSheet ws = wb.getSheet("Employ");
				//count no of rows in Emp sheet
				int rc =ws.getLastRowNum();
				System.out.println("No of rows are::"+rc);
				//iterate all rows
				//rc means number of rows
				for(int i=1;i<=rc;i++)
				{
					//read all rpws cell data
					//getRow(i) means all rows
					String fname = ws.getRow(i).getCell(0).getStringCellValue();
					String mname = ws.getRow(i).getCell(1).getStringCellValue();
					String lname = ws.getRow(i).getCell(2).getStringCellValue();
					//HERE getNumericCellValue METHOD RETURN DOUBLE TYPE
					//IN EXCEL SHEET EMPLOY ID(eid) STORE A INT TYPE BECAUSE OF THAT I AM CHANGING DOUBLE TYPE TO INTEGER TYPE, THATS WHY I AM ADDING TYPECAST((int))
					int eid = (int)ws.getRow(i).getCell(3).getNumericCellValue();
					System.out.println(fname+"   "+mname+"    "+lname+"   "+eid);
					//write some text into status cell
					ws.getRow(i).createCell(4).setCellValue("pass");
							
				}
				fi.close();
				FileOutputStream fo = new FileOutputStream("D:\\\\Selenium\\\\selenium live project\\\\Results.xlsx");
				wb.write(fo);
				fo.close();
				wb.close();
	}

}
