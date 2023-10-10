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

public class Admin_Set_LE_Create_AssessmentType extends Admin_LearnerEvaluation 
{
	public By AssessmentTypeTitle=By.xpath("//input[@name='institute_name']");
	public By AssessmentTypeShortCode=By.xpath("//input[@name='shortcode']");
	public By AssessmentTypeImage=By.xpath("//input[@name='inputGroupFile03']");
	public By AssessmentTypeShortDes=By.xpath("//textarea[@name='des']");
	public By AssessmentTypeSubmit=By.xpath("//input[@class='btn mr-2']");
	public By AssessmentTypeActive=By.xpath("//a[@class='text-danger']");
	public void add_Assessmenttype(WebDriver d) throws IOException, InterruptedException
	{
		File src = new File(".//src//test//resources//AssessmentAuto.xlsx");
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet("AssessmentType");
		int rowCount=sheet.getLastRowNum();
		System.out.println("Rowcount="+rowCount);
		for (int i=1; i<=rowCount; i++)
		{
			XSSFRow celldata=sheet.getRow(i);
			d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				SendKeys(d, AssessmentTypeTitle, celldata.getCell(0).getStringCellValue());
				SendKeys(d, AssessmentTypeShortCode, celldata.getCell(1).getStringCellValue());
				SendKeys(d, AssessmentTypeImage, celldata.getCell(2).getStringCellValue());
				SendKeys(d, AssessmentTypeShortDes, celldata.getCell(3).getStringCellValue());
				Click(d,AssessmentTypeSubmit);
				Thread.sleep(1000);
				Click(d, AssessmentTypeActive);
		}
	}
}
