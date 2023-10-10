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
public class Admin_Set_Specialization extends Admin_Settings
{
	public By Subjectcategorydropdown = By.xpath("//Select[@name='subcat']");
	public By Subject = By.xpath("//Select[@name='sub']");
	public By Specialization = By.xpath("//input[@name='institute_name']");
	public By TaughtBy = By.xpath("//textarea[@name='des']");
	public By Specializationimage = By.xpath("//input[@name='inputGroupFile03']");
	public By Specializationlogo = By.xpath("//input[@name='pic']");
	public By SpecializationLongDescription =By.xpath("//textarea[@name='longdes']");
	public By Specializationsubmit =By.xpath("//form[@id='speform']//input[@value='Submit']");
	public By Activate=By.xpath("//b[@class=\"text-danger\"]");
	public void add_Specialization(WebDriver d) throws IOException, InterruptedException
	{
		File src = new File(".//src//test//resources//Automation Test Sample.xlsx");
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet("Specialization");
		int rowCount=sheet.getLastRowNum();
		for (int i=1; i<=rowCount; i++)
		{
			XSSFRow celldata=sheet.getRow(i);
			d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				Select_by_Text(d, Subjectcategorydropdown, celldata.getCell(0).getStringCellValue());
				Select_by_Text(d, Subject, celldata.getCell(1).getStringCellValue());
				SendKeys(d, Specialization, celldata.getCell(2).getStringCellValue());
				SendKeys(d, TaughtBy, celldata.getCell(3).getStringCellValue());
				SendKeys(d, Specializationimage, celldata.getCell(4).getStringCellValue());
				SendKeys(d, Specializationlogo, celldata.getCell(5).getStringCellValue());
				SendKeys(d, SpecializationLongDescription, celldata.getCell(6).getStringCellValue());
				Click(d,Specializationsubmit);
				Thread.sleep(1000);
				Click(d, Activate);
		}
	}
}
