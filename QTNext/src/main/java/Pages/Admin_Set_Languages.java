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
public class Admin_Set_Languages extends Admin_Settings
{
	public By language = By.xpath("//input[@name='institute_name']");
	public By submit = By.xpath("//form[@id='lanform']//input[@type='submit']");
	public By Activate=By.xpath("//a[@class=\"text-danger\"]");
	public void add_Language(WebDriver d) throws IOException, InterruptedException
	{
		File src = new File(".//src//test//resources//Settings.xlsx");
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet("Language");
		int rowCount=sheet.getLastRowNum();
		for (int i=1; i<=rowCount; i++)
		{
			XSSFRow celldata=sheet.getRow(i);
			d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			SendKeys(d, language, celldata.getCell(0).getStringCellValue());
			Click(d, submit);
			Click(d, Activate);
		}
	}
}
