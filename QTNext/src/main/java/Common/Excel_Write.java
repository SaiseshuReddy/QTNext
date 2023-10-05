package Common;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Write 
{
	public void fileWriting(String path, String sheetname, int cellnum, String cellvalue) throws IOException
	{
		FileInputStream fs = new FileInputStream(path);
		XSSFWorkbook wb = new XSSFWorkbook(fs);
		XSSFSheet sheet = wb.getSheet(sheetname);
		
		int rownum = sheet.getLastRowNum();
		XSSFRow row = sheet.getRow(rownum);
		XSSFCell cell = row.getCell(cellnum);
		cell.setCellValue(cellvalue);
		
		
		FileOutputStream fos = new FileOutputStream(path);
		wb.write(fos);
		fos.close();
		
		
	}

}
