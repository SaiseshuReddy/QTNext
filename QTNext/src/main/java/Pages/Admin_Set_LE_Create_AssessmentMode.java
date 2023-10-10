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
public class Admin_Set_LE_Create_AssessmentMode extends Admin_LearnerEvaluation
{
	public By AssModeSelAssessmentType=By.xpath("//select[@class='form-select mb-3 id_assessment_type']");
	public By AssModeSelAssessmentCategory=By.xpath("//select[@class='form-select mb-3 id_assessment_cat']");
	public By AssModeSelAssessmentSubCategory=By.xpath("//select[@class='form-select mb-3 id_assessment_sub_cat']");
	public By AssModeSelAssessmentTestCategory=By.xpath("//select[@class='form-select mb-3 id_assessment_test_cat']");
	public By AssModeSelAssessmentTestSubCategory=By.xpath("//select[@class='form-select mb-3 id_assessment_test_sub_cat']");
	public By AssessmentModeTitle=By.xpath("//div[@class='form-group']//input[@placeholder='Ex: Number System']");
	public By AssessmentModeShortCode=By.xpath("//div[@class='form-group']//input[@placeholder='Ex: NS']");
	public By AssessmentModeImage=By.xpath("//form[@id='mainform']//input[@name='subjectLogo']");
	public By AssessmentModeSubmit=By.xpath("//form[@id='mainform']//input[@value='Submit']");
	public By AssessmentModeActive=By.xpath("//a[@class='text-danger']");
	public void add_AssessmentMode(WebDriver d) throws IOException, InterruptedException
	{
		File src = new File(".//src//test//resources//AssessmentAuto.xlsx");
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet("AssessmentMode");
		int rowCount=sheet.getLastRowNum();
		for (int i=1; i<=rowCount; i++)
		{
			XSSFRow celldata=sheet.getRow(i);
			d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				Thread.sleep(1000);
				Select_by_Text(d, AssModeSelAssessmentType, celldata.getCell(0).getStringCellValue());
				Select_by_Text(d, AssModeSelAssessmentCategory, celldata.getCell(1).getStringCellValue());
				Select_by_Text(d, AssModeSelAssessmentSubCategory, celldata.getCell(2).getStringCellValue());
				Select_by_Text(d, AssModeSelAssessmentTestCategory, celldata.getCell(3).getStringCellValue());
				Select_by_Text(d, AssModeSelAssessmentTestSubCategory, celldata.getCell(4).getStringCellValue());
				SendKeys(d, AssessmentModeTitle, celldata.getCell(5).getStringCellValue());
				SendKeys(d, AssessmentModeShortCode, celldata.getCell(6).getStringCellValue());
				SendKeys(d, AssessmentModeImage, celldata.getCell(7).getStringCellValue());
				Click(d,AssessmentModeSubmit);
				//Click(d,AssessmentModeActive);
		}
	}
}
