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

public class Admin_CreateTopic extends Admin_Dashboard
{
	public By Create_TopicBtn=By.xpath("//button[contains(text(),\"Create Topic\")]");
	public By Subject_Category=By.xpath("//select[@name=\"subcat\"]");
	public By Subject=By.xpath("//select[@name=\"sub\"]");
	public By Specialization=By.xpath("//select[@name=\"specialization\"]");
	public By Course=By.xpath("//select[@name=\"course\"]");
	public By Chapter=By.xpath("//select[@name=\"chapter\"]");
	public By Lesson=By.xpath("//select[@name=\"lesson\"]");
	public By Topic_Title=By.xpath("//input[@name=\"topic\"]");
	public By Language=By.xpath("//select[@name=\"language\"]");
	public By Vid_Duration=By.xpath("//input[@name=\"duration\"]");
	public By Vid_URL=By.xpath("//input[@name=\"video\"]");
	public By Topic_SD=By.xpath("//textarea[@name=\"longdes\"]");
	public By Submit=By.xpath("//input[@value=\"Submit\"]");
	public By Reset=By.xpath("//input[@value=\"Reset\"]");
	public By Close=By.xpath("//button[@class=\"btn-close btn-close-white\"]");
	public By Activate=By.xpath("//b[@class=\"text-danger\"]");
	
	public void add_Topic(WebDriver d) throws IOException, InterruptedException
	{
		File src = new File(".//src//test//resources//Learning Path.xlsx");
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet("Create Topic");
		int rowCount=sheet.getLastRowNum();
		for(int i=1; i<=rowCount; i++)
		{
			d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			Click(d, Create_TopicBtn);
			Thread.sleep(1000);
			XSSFRow celldata=sheet.getRow(i);
			Select_by_Text(d, Subject_Category, celldata.getCell(0).getStringCellValue());
			Select_by_Text(d, Subject, celldata.getCell(1).getStringCellValue());
			Select_by_Text(d, Specialization, celldata.getCell(2).getStringCellValue());
			Select_by_Text(d, Course, celldata.getCell(3).getStringCellValue());
			Select_by_Text(d, Chapter, celldata.getCell(4).getStringCellValue());
			Select_by_Text(d, Lesson, celldata.getCell(5).getStringCellValue());
			SendKeys(d, Topic_Title, celldata.getCell(6).getStringCellValue());
			Select_by_Text(d, Language, celldata.getCell(7).getStringCellValue());
			SendKeys(d, Vid_Duration, celldata.getCell(8).getStringCellValue());
			SendKeys(d, Vid_URL, celldata.getCell(9).getStringCellValue());
			SendKeys(d, Topic_SD, celldata.getCell(10).getStringCellValue());
			Click(d, Submit);
			Click(d, Activate);
		}
		
	}

}
