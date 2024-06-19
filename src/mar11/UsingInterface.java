package mar11;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class UsingInterface {

	public static void main(String[] args) throws Throwable {

		FileInputStream fi = new FileInputStream("D:\\Selenium\\selenium live project\\Sample Excel.xlsx");
		//Workbook is a interface not class
		//WorkbookFactory is a access methods(create(fi)) for Workbook interface
		Workbook wb = WorkbookFactory.create(fi);
		//Sheet cntrl+ import only ss
		Sheet ws = wb.getSheet("Employ");
		int rc = ws.getLastRowNum();
		for(int i=1;i<=rc;i++)
		{
			String fname = ws.getRow(i).getCell(0).getStringCellValue();
			String mname = ws.getRow(i).getCell(1).getStringCellValue();
			String lname = ws.getRow(i).getCell(2).getStringCellValue();
			//HERE getNumericCellValue METHOD RETURN DOUBLE TYPE
			//IN EXCEL SHEET EMPLOY ID(eid) STORE A INT TYPE BECAUSE OF THAT I AM CHANGING DOUBLE TYPE TO INTEGER TYPE, THATS WHY I AM ADDING TYPECAST((int))
			int eid=(int) ws.getRow(i).getCell(3).getNumericCellValue();
			System.out.println(fname+"   "+mname+"    "+lname+"   "+eid);
			ws.getRow(i).createCell(4).setCellValue("I want job with 25l package");
			
		}
		fi.close();
		FileOutputStream fo = new FileOutputStream("D:\\\\Selenium\\\\selenium live project\\\\Results.xlsx");
		//fo results file copy to wb sample file
		wb.write(fo);
		fo.close();
		wb.close();
	}

}
