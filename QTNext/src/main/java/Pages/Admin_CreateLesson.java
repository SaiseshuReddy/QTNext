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

public class Admin_CreateLesson extends Admin_Dashboard
{
	public By Create_LessonBtn=By.xpath("//button[contains(text(),\"Create Lesson\")]");
	public By Subject_Category=By.xpath("//select[@name=\"subcat\"]");
	public By Subject=By.xpath("//select[@name=\"sub\"]");
	public By Specialization=By.xpath("//select[@name=\"specialization\"]");
	public By Course=By.xpath("//select[@name=\"course\"]");
	public By Chapter=By.xpath("//select[@name=\"chapter\"]");
	public By Lesson_Title=By.xpath("//input[@name=\"lesson\"]");
	public By Lesson_Image=By.xpath("//input[@name=\"inputGroupFile03\"]");
	public By Lesson_Logo=By.xpath("//input[@name=\"logo\"]");
	public By Lesson_SD=By.xpath("//textarea[@name=\"longdes\"]");
	public By Submit=By.xpath("//input[@value=\"Submit\"]");
	public By Reset=By.xpath("//input[@value=\"Reset\"]");
	public By Close=By.xpath("//button[@class=\"btn-close btn-close-white\"]");
	public By Activate=By.xpath("//b[@class=\"text-danger\"]");
	
	public void add_Lesson(WebDriver d) throws IOException, InterruptedException
	{
		File src = new File(".//src//test//resources//Learning Path.xlsx");
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet("Create Lesson");
		int rowCount=sheet.getLastRowNum();
		for(int i=1; i<=rowCount; i++)
		{
			d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			Click(d, Create_LessonBtn);
			Thread.sleep(1000);
			XSSFRow celldata=sheet.getRow(i);
			Select_by_Text(d, Subject_Category, celldata.getCell(0).getStringCellValue());
			Select_by_Text(d, Subject, celldata.getCell(1).getStringCellValue());
			Select_by_Text(d, Specialization, celldata.getCell(2).getStringCellValue());
			Select_by_Text(d, Course, celldata.getCell(3).getStringCellValue());
			Select_by_Text(d, Chapter, celldata.getCell(4).getStringCellValue());
			SendKeys(d, Lesson_Title, celldata.getCell(5).getStringCellValue());
			SendKeys(d, Lesson_Image, celldata.getCell(6).getStringCellValue());
			SendKeys(d, Lesson_Logo, celldata.getCell(7).getStringCellValue());
			SendKeys(d, Lesson_SD, celldata.getCell(8).getStringCellValue());
			Click(d, Submit);
			Click(d, Activate);
		}
		
	}

}
