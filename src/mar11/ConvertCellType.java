package mar11;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ConvertCellType {

	public static void main(String[] args) throws Throwable {

		//write a script to convert integer type cell to string type cell
		FileInputStream fi = new FileInputStream("D:\\Selenium\\selenium live project\\Sample Excel.xlsx");
				XSSFWorkbook wb= new XSSFWorkbook(fi);
				XSSFSheet ws = wb.getSheet("Employ");
				int rowCount = ws.getLastRowNum();
				for(int i=1;i<=rowCount;i++)
				{
					//Employ sheet,all rows,get 4th cell, contains cell type is NUMERIC
					if(wb.getSheet("Employ").getRow(i).getCell(3).getCellType()==CellType.NUMERIC)
					{
						//HERE getNumericCellValue METHOD RETURN DOUBLE TYPE
						//IN EXCEL SHEET EMPLOY ID(eid) STORE A INT TYPE BECAUSE OF THAT I AM CHANGING DOUBLE TYPE TO INTEGER TYPE, THATS WHY I AM ADDING TYPECAST((int))
						int celldata =(int)wb.getSheet("Employ").getRow(i).getCell(3).getNumericCellValue();
						//convert integer type to string
						//valueOf means java string conversion function
						String eid =String.valueOf(celldata);
						System.out.println(eid);
						ws.getRow(i).createCell(4).setCellValue("Fail");
					}
				}
				fi.close();
				FileOutputStream fo = new FileOutputStream("D:\\Selenium\\selenium live project\\Results.xlsx");
				//fo results file copy to wb sample file
				wb.write(fo);
				fo.close();
				wb.close();
	}

}
