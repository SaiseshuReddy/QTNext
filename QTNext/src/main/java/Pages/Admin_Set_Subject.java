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
public class Admin_Set_Subject extends Admin_Settings
{
	public By SubjectCategorydropdwon = By.xpath("//select[@name='subcat']");
	public By Subjecttitle = By.xpath("//input[@name='subject_name']");
	public By Subjectlogo = By.xpath("//input[@name='subject_Logo']");
	public By Submitsubject = By.xpath("//div[@class='row'] //input[@value='Submit']");
	public By Activate=By.xpath("//a[@class=\"text-danger\"]");
	public void add_Subject(WebDriver d) throws IOException, InterruptedException
	{
		File src = new File(".//src//test//resources//Settings.xlsx");
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet("Subject");
		int rowCount=sheet.getLastRowNum();
		for (int i=1; i<=rowCount; i++)
		{
			XSSFRow celldata=sheet.getRow(i);
			d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				Thread.sleep(1000);
				Select_by_Text(d, SubjectCategorydropdwon, celldata.getCell(0).getStringCellValue());
				SendKeys(d, Subjecttitle, celldata.getCell(1).getStringCellValue());
				SendKeys(d, Subjectlogo, celldata.getCell(2).getStringCellValue());
				Click(d,Submitsubject);
				Click(d, Activate);
		}
	}
}
