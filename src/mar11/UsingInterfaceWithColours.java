package mar11;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class UsingInterfaceWithColours {

	public static void main(String[] args) throws Throwable {
		
	
	FileInputStream fi = new FileInputStream("D:\\Selenium\\selenium live project\\Sample Excel.xlsx");
	//Workbook is a interface not class
			//WorkbookFactory is a access methods(create(fi)) for Workbook interface
	Workbook wb = WorkbookFactory.create(fi);
	//Sheet cntrl+ import only ss
	Sheet ws = wb.getSheet("Employ");
	int rc = ws.getLastRowNum();
	System.out.println(rc);
	for(int i=1;i<=rc;i++)
	{
//		ws.getRow(i).createCell(4).setCellValue("Pass");
//		ws.getRow(i).createCell(4).setCellValue("Fail");
		ws.getRow(i).createCell(4).setCellValue("Blocked");
		CellStyle style =wb.createCellStyle();
		//Font is a interface
		Font font =wb.createFont();
//		font.setColor(IndexedColors.GREEN.getIndex());
		font.setColor(IndexedColors.BLUE.getIndex());
		//font.setColor(IndexedColors.RED.getIndex());
		font.setBold(true);
		style.setFont(font);
		ws.getRow(i).getCell(4).setCellStyle(style);
	}
	fi.close();
	FileOutputStream fo = new FileOutputStream("D:\\Selenium\\selenium live project\\Results.xlsx");
	wb.write(fo);
	fo.close();
	wb.close();

}
}
