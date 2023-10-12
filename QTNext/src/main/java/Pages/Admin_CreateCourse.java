package Pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Admin_CreateCourse extends Admin_Dashboard
{
	public By Create_CourseBtn=By.xpath("//button[contains(text(),\"Create Course\")]");
	public By Subject_Category=By.xpath("//select[@name=\"sub_cat\"]");
	public By Subject=By.xpath("//select[@name=\"subject\"]");
	public By Specialization=By.xpath("//select[@name=\"specialization\"]");
	public By Course_Title=By.xpath("//input[@name=\"course_title\"]");
	public By Course_Image=By.xpath("//input[@name=\"course_image\"]");
	public By Course_Logo=By.xpath("//input[@name=\"course_logo\"]");
	public By Taught_By=By.xpath("//textarea[@name=\"taught\"]");
	public By Course_SD=By.xpath("//textarea[@name=\"short_description\"]");
	public By Submit=By.xpath("//input[@value=\"Submit\"]");
	public By Reset=By.xpath("//input[@value=\"Reset\"]");
	public By Close=By.xpath("//button[@class=\"btn-close btn-close-white\"]");
	public By Activate=By.xpath("//a[@class=\"text-danger\"]");
	
	public void add_Course(WebDriver d) throws IOException, InterruptedException
	{
		File src = new File(".//src//test//resources//Learning Path.xlsx");
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet("Create Course");
		int rowCount=sheet.getLastRowNum();
		for(int i=1; i<=rowCount; i++)
		{
			d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			Click(d, Create_CourseBtn);
			Thread.sleep(1000);
			XSSFRow celldata=sheet.getRow(i);
			Select_by_Text(d, Subject_Category, celldata.getCell(0).getStringCellValue());
			Select_by_Text(d, Subject, celldata.getCell(1).getStringCellValue());
			Select_by_Text(d, Specialization, celldata.getCell(2).getStringCellValue());
			SendKeys(d, Course_Title, celldata.getCell(3).getStringCellValue());
			SendKeys(d, Course_Image, celldata.getCell(4).getStringCellValue());
			SendKeys(d, Course_Logo, celldata.getCell(5).getStringCellValue());
			SendKeys(d, Taught_By, celldata.getCell(6).getStringCellValue());
			SendKeys(d, Course_SD, celldata.getCell(7).getStringCellValue());
			Click(d, Submit);
			Click(d, Activate);
			WebElement test=d.findElement(By.xpath("//table/tbody/tr[1]/td[4]"));
			String str=test.getText();
			Assert.assertEquals(celldata.getCell(3).getStringCellValue(), str);
		}
		
	}
}
