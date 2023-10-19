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
public class Admin_Set_LE_Create_AssessmentTestCategory extends Admin_LearnerEvaluation
{
	public By AssTestCatSelAssessmentType=By.xpath("//select[@class='form-select mb-3 id_assessment_type']");
	public By AssTestCatSelAssessmentCategory=By.xpath("//select[@class='form-select mb-3 id_assessment_cat']");
	public By AssTestCatSelAssessmentSubCategory=By.xpath("//select[@class='form-select mb-3 id_assessment_sub_cat']");
	public By AssessmentTestCategoryTitle=By.xpath("//input[@placeholder='Ex: Assessment']");
	public By AssessmentTestCategoryShortCode=By.xpath("//form[@id='quickForm']//input[@placeholder='Enter Assessment Test Category Short Code']");
	public By AssessmentTestCategoryImage=By.xpath("//input[@name='subjectLogo1']");
	public By AssessmentTestCategorySubmit=By.xpath("//form[@id='quickForm']//input[@value='Submit']");
	public By AssessmentTestCategoryActive=By.xpath("//a[@class='text-danger']");
	public void add_AssessmentTestCategory(WebDriver d) throws IOException, InterruptedException
	{
		File src = new File(".//src//test//resources//Placement Readyness Assessment.xlsx");
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet("AssessmentTestCategory");
		int rowCount=sheet.getLastRowNum();

 

		for (int i=1; i<=rowCount; i++)
		{
			XSSFRow celldata=sheet.getRow(i);
			d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				Thread.sleep(1000);
				Select_by_Text(d, AssTestCatSelAssessmentType, celldata.getCell(0).getStringCellValue());
				Select_by_Text(d, AssTestCatSelAssessmentCategory, celldata.getCell(1).getStringCellValue());
				Select_by_Text(d, AssTestCatSelAssessmentSubCategory, celldata.getCell(2).getStringCellValue());
				SendKeys(d, AssessmentTestCategoryTitle, celldata.getCell(3).getStringCellValue());
				SendKeys(d, AssessmentTestCategoryShortCode, celldata.getCell(4).getStringCellValue());
				SendKeys(d, AssessmentTestCategoryImage, celldata.getCell(5).getStringCellValue());
				Click(d,AssessmentTestCategorySubmit);
				Click(d,AssessmentTestCategoryActive);
	}
}	
}
