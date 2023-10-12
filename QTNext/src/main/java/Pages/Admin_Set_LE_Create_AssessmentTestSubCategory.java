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
public class Admin_Set_LE_Create_AssessmentTestSubCategory extends Admin_LearnerEvaluation
{
	public By AssTestSubCatSelAssessmentType=By.xpath("//select[@class='form-select mb-3 id_assessment_type']");
	public By AssTestSubCatSelAssessmentcategory=By.xpath("//select[@class='form-select mb-3 id_assessment_cat']");
	public By AssTestSubCatSelAssessmentSubcategory=By.xpath("//select[@class='form-select mb-3 id_assessment_sub_cat']");
	public By AssTestSubCatSelAssessmentTestcategory=By.xpath("//select[@class='form-select mb-3 id_assessment_test_cat']");
	public By AssessmentTestSubCategoryTitle=By.xpath("//input[@placeholder='Ex:- Aptitude Topics Test']");
	public By AssessmentTestSubCategoryShortCode=By.xpath("//input[@placeholder='Ex:- ATT']");
	public By AssessmentTestSubCategoryImage=By.xpath("//input[@name='subjectLogo']");
	public By AssessmentTestSubCategorySubmit=By.xpath("//form[@id='quickForm']//input[@value='Submit']");
	public By AssessmentTestSubCategoryActive=By.xpath("//a[@class='text-danger']");
	public void add_AssessmentTestSubCategory(WebDriver d) throws IOException, InterruptedException
	{
		File src = new File(".//src//test//resources//Competitive Exam Assessment.xlsx");
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet("AssessmentTestSubCategory");
		int rowCount=sheet.getLastRowNum();
		for (int i=1; i<=rowCount; i++)
		{
			XSSFRow celldata=sheet.getRow(i);
			d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				Thread.sleep(1000);
				Select_by_Text(d, AssTestSubCatSelAssessmentType, celldata.getCell(0).getStringCellValue());
				Select_by_Text(d, AssTestSubCatSelAssessmentcategory, celldata.getCell(1).getStringCellValue());
				Select_by_Text(d, AssTestSubCatSelAssessmentSubcategory, celldata.getCell(2).getStringCellValue());
				Select_by_Text(d, AssTestSubCatSelAssessmentTestcategory, celldata.getCell(3).getStringCellValue());
				SendKeys(d, AssessmentTestSubCategoryTitle, celldata.getCell(4).getStringCellValue());
				SendKeys(d, AssessmentTestSubCategoryShortCode, celldata.getCell(5).getStringCellValue());
				SendKeys(d, AssessmentTestSubCategoryImage, celldata.getCell(6).getStringCellValue());
				Click(d,AssessmentTestSubCategorySubmit);
				Click(d,AssessmentTestSubCategoryActive);
		}
	}
}
