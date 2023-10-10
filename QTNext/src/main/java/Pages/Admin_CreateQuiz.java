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
public class Admin_CreateQuiz extends Admin_Dashboard
{
	public By CreateQuiz=By.xpath("//button[contains(text(),'Create Quiz')]");
	public By SubjectCategory=By.xpath("//select[@name='subject_category']");
	public By Subject=By.xpath("//select[@name='subject']");
	public By Specialization =By.xpath("//select[@name='specialization']");
	public By Course=By.xpath("//select[@name='course']");
	public By Chapter=By.xpath("//select[@name='chapter']");
	public By Lesson=By.xpath("//select[@name='lesson']");
	public By Topic=By.xpath("//select[@name='topic']");
	public By QuizTitle=By.xpath("//input[@name='quiztitle']");
	public By NumberOfQuestions=By.xpath("//input[@name='questions']");
	public By Credit =By.xpath("//input[@name='credits']");
	public By ExaminationLevel=By.xpath("//select[@name='lvl']");
	public By QuizDescription=By.xpath("//textarea[@name='des']");
	public By Submit=By.xpath("//input[@type='submit']");
	public By Activate=By.xpath("//b[@class=\"text-danger\"]");
		public void add_Quiz(WebDriver d) throws IOException, InterruptedException
		{
			File src = new File(".//src//test//resources//Automation Test Sample.xlsx");
			FileInputStream fis=new FileInputStream(src);
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			XSSFSheet sheet=wb.getSheet("Create Quiz");
			int rowCount=sheet.getLastRowNum();
			for (int i=1; i<=rowCount; i++)
			{
				XSSFRow celldata=sheet.getRow(i);
					d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
					Click(d, CreateQuiz);
					Thread.sleep(1000);
					Select_by_Text(d, SubjectCategory, celldata.getCell(0).getStringCellValue());
					Select_by_Text(d, Subject, celldata.getCell(1).getStringCellValue());
					Select_by_Text(d, Specialization, celldata.getCell(2).getStringCellValue());	
					Select_by_Text(d, Course, celldata.getCell(3).getStringCellValue());	
					Select_by_Text(d, Chapter, celldata.getCell(4).getStringCellValue());	
					Select_by_Text(d, Lesson, celldata.getCell(5).getStringCellValue());	
					Select_by_Text(d, Topic, celldata.getCell(6).getStringCellValue());
					SendKeys(d, QuizTitle, celldata.getCell(7).getStringCellValue());	
					double mp_wa1=celldata.getCell(8).getNumericCellValue();
					int mp_wa2=(int) mp_wa1;
					String mp_wa=String.valueOf(mp_wa2);
					SendKeys(d, NumberOfQuestions, mp_wa);
					double mp_wa3=celldata.getCell(9).getNumericCellValue();
					int mp_wa4=(int) mp_wa1;
					String mp_wa5=String.valueOf(mp_wa4);
					SendKeys(d, Credit, mp_wa5);
					Select_by_Text(d, ExaminationLevel, celldata.getCell(10).getStringCellValue());
					SendKeys(d, QuizDescription, celldata.getCell(11).getStringCellValue());
					Click(d,Submit);
					//Thread.sleep(3000);
					Click(d,Activate);
			}
		}
}
