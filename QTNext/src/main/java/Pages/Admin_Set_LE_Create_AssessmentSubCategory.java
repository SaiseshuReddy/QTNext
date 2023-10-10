package Pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Admin_Set_LE_Create_AssessmentSubCategory extends Admin_LearnerEvaluation
{
	public By AssSubCatSelAssessmentType=By.xpath("//select[@class='form-select mb-3 id_assessment_type']");
	public By AssSubCatSelAssessmentCategory=By.xpath("//select[@class='form-select mb-3 id_assessment_cat']");
	public By AssessmentSubCategoryTitle=By.xpath("//input[@name='institute_name']");
	public By AssessmentSubCategoryShortCode=By.xpath("//input[@name='asees']");
	public By AssessmentSubCategoryImage=By.xpath("//input[@name='sub_cat_img']");
	public By AssessmentSubCategorySubmit=By.xpath("//form[@id='quickForm']//input[@type='submit']");
	public By AssessmentSubCategoryActive=By.xpath("//a[@class='text-danger']");
	public void add_AssessmentSubCategory(WebDriver d) throws IOException, InterruptedException
	{
		File src = new File(".//src//test//resources//AssessmentAuto.xlsx");
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet("AssessmentSubCategory");
		int rowCount=sheet.getLastRowNum();
		for (int i=1; i<=rowCount; i++)
		{
			XSSFRow celldata=sheet.getRow(i);
			d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				Thread.sleep(1000);
				Select_by_Text(d, AssSubCatSelAssessmentType, celldata.getCell(0).getStringCellValue());
				Select_by_Text(d, AssSubCatSelAssessmentCategory, celldata.getCell(1).getStringCellValue());
				SendKeys(d, AssessmentSubCategoryTitle, celldata.getCell(2).getStringCellValue());
				SendKeys(d, AssessmentSubCategoryShortCode, celldata.getCell(3).getStringCellValue());
				SendKeys(d, AssessmentSubCategoryImage, celldata.getCell(4).getStringCellValue());
				Click(d,AssessmentSubCategorySubmit);
				Click(d,AssessmentSubCategoryActive);
		}
	}
}
