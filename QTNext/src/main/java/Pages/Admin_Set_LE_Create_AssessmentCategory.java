package Pages;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Admin_Set_LE_Create_AssessmentCategory extends Admin_LearnerEvaluation 
{
	public By AssCatSelectAssessmentType=By.xpath("//select[@name='assesstype']");
	public By AssessmentCategoryTitle=By.xpath("//input[@name='Assessment']");
	public By AssessmentCategoryImage=By.xpath("//input[@name='inputGroupFile03']");
	public By AssessmentCategoryShortCode=By.xpath("//input[@name='Short']");
	public By Submit=By.xpath("//form[@id='quickForm']//input[@type='submit']");
	public By AssessmentCategoryActive=By.xpath("//a[@class='text-danger']");
	public void add_AssessmentCategory(WebDriver d) throws IOException, InterruptedException
	{
		File src = new File(".//src//test//resources//Placement Readyness Assessment.xlsx");
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet("AssessmentCategory");
		int rowCount=sheet.getLastRowNum();
		for (int i=1; i<=rowCount; i++)
		{
			XSSFRow celldata=sheet.getRow(i);
			d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				Thread.sleep(1000);
				Select_by_Text(d, AssCatSelectAssessmentType, celldata.getCell(0).getStringCellValue());
				SendKeys(d, AssessmentCategoryTitle, celldata.getCell(1).getStringCellValue());
				SendKeys(d, AssessmentCategoryImage, celldata.getCell(3).getStringCellValue());
				SendKeys(d, AssessmentCategoryShortCode, celldata.getCell(2).getStringCellValue());
				Click(d,Submit);
				Click(d,AssessmentCategoryActive);
		}
	}
}
