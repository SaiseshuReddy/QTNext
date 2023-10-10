package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.io.IOException;
import java.time.Duration;
import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Admin_Set_SubCat extends Admin_Settings
{
	public By SubjectCategoryTextBox = By.xpath("//input[@name='category']");
	public By Submitsubjectcategory= By.xpath("//form[@id='myForm']//input[@value='Submit']");
	public By Activate=By.xpath("//a[@class=\"text-danger\"]");
	public void add_SubjectCategory(WebDriver d) throws IOException, InterruptedException
	{
		File src = new File(".//src//test//resources//Automation Test Sample.xlsx");
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet("Subject Category");
		int rowCount=sheet.getLastRowNum();
		for (int i=1; i<=rowCount; i++)
		{
			XSSFRow celldata=sheet.getRow(i);
			d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				Thread.sleep(1000);
				SendKeys(d, SubjectCategoryTextBox, celldata.getCell(0).getStringCellValue());
				Click(d,Submitsubjectcategory);
				Click(d, Activate);
		}
	}

}
