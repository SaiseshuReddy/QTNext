package Pages;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class Admin_CreateQuizQuerstions extends Admin_Dashboard
{
	public By Quiz=By.xpath("//select[@name='topic']");
	public By EnterYourQuestion=By.xpath("//input[@name='question']");
	public By QuestionImage=By.xpath("//input[@name='question_attachment']");
	public By OptionA=By.xpath("//input[@name='five']");
	public By OptionAImage=By.xpath("//input[@name='six']");
	public By OptionB=By.xpath("//input[@name='eight']");
	public By OptionBImage=By.xpath("//input[@name='nine']");
	public By OptionC=By.xpath("//input[@name='ten']");
	public By OptionCImage=By.xpath("//input[@name='eleven']");
	public By OptionD=By.xpath("//input[@name='twelve']");
	public By OptionDImage=By.xpath("//input[@name='thirteen']");
	public By AnsExplination=By.xpath("//textarea[@name='ans_explanation']");
	public By Ans_Image=By.xpath("//input[@name='ans_img']");
	public By Currectoption=By.xpath("//select[@name='correct_ans']");
	public By QuizSubmit=By.xpath("//input[@type='submit']");
	public void add_QuizQuestions(WebDriver d) throws IOException, InterruptedException
	{
		File src = new File(".//src//test//resources//Automation Test Sample.xlsx");
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet("Quiz Questions");
		int rowCount=sheet.getLastRowNum();
		for (int i=1; i<=rowCount; i++)
		{
			XSSFRow celldata=sheet.getRow(i);
			d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				Thread.sleep(1000);
				Select_by_Text(d, Quiz, celldata.getCell(0).getStringCellValue());
				if(celldata.getCell(1).getRawValue().isEmpty())
				{
					SendKeys(d, QuestionImage, celldata.getCell(2).getStringCellValue());
				}
				else if(celldata.getCell(2).getStringCellValue().isEmpty())
				{
					if(celldata.getCell(1).getCellType()==CellType.STRING)
					{
					SendKeys(d, EnterYourQuestion, celldata.getCell(1).getStringCellValue());
					}
					else
					{
						double temp1=celldata.getCell(1).getNumericCellValue();
						int temp2=(int) temp1;
						String temp=String.valueOf(temp2);
						SendKeys(d, EnterYourQuestion, temp);
					}
				}
				else
				{
					if(celldata.getCell(1).getCellType()==CellType.STRING)
					{
					SendKeys(d, EnterYourQuestion, celldata.getCell(1).getStringCellValue());
					}
					else
					{
						double temp1=celldata.getCell(1).getNumericCellValue();
						int temp2=(int) temp1;
						String temp=String.valueOf(temp2);
						SendKeys(d, EnterYourQuestion, temp);
					}
					SendKeys(d, QuestionImage, celldata.getCell(2).getStringCellValue());
				}
//				//Option A
				if(celldata.getCell(3).getRawValue().isEmpty())
				{
					SendKeys(d, OptionAImage, celldata.getCell(4).getStringCellValue());
				}
				else if(celldata.getCell(4).getStringCellValue().isEmpty())
				{
					if(celldata.getCell(3).getCellType()==CellType.STRING)
					{
					SendKeys(d, OptionA, celldata.getCell(3).getStringCellValue());
					}
					else
					{
						double temp1=celldata.getCell(3).getNumericCellValue();
						int temp2=(int) temp1;
						String temp=String.valueOf(temp2);
						SendKeys(d, OptionA, temp);
					}
				}
				else
				{
					if(celldata.getCell(3).getCellType()==CellType.STRING)
					{
					SendKeys(d, OptionA, celldata.getCell(3).getStringCellValue());
					}
					else
					{
						double temp1=celldata.getCell(3).getNumericCellValue();
						int temp2=(int) temp1;
						String temp=String.valueOf(temp2);
						SendKeys(d, OptionA, temp);
					}
					SendKeys(d, OptionAImage, celldata.getCell(4).getStringCellValue());
				}
				//option B
				if(celldata.getCell(5).getRawValue().isEmpty())
				{
					SendKeys(d, OptionBImage, celldata.getCell(6).getStringCellValue());
				}
				else if(celldata.getCell(6).getStringCellValue().isEmpty())
				{
					if(celldata.getCell(5).getCellType()==CellType.STRING)
					{
					SendKeys(d, OptionB, celldata.getCell(5).getStringCellValue());
					}
					else
					{
						double temp1=celldata.getCell(5).getNumericCellValue();
						int temp2=(int) temp1;
						String temp=String.valueOf(temp2);
						SendKeys(d, OptionB, temp);
					}
				}
				else
				{
					if(celldata.getCell(5).getCellType()==CellType.STRING)
					{
					SendKeys(d, OptionB, celldata.getCell(5).getStringCellValue());
					}
					else
					{
						double temp1=celldata.getCell(5).getNumericCellValue();
						int temp2=(int) temp1;
						String temp=String.valueOf(temp2);
						SendKeys(d, OptionB, temp);
					}
					SendKeys(d, OptionBImage, celldata.getCell(6).getStringCellValue());
				}
				//Option C
				if(celldata.getCell(7).getRawValue().isEmpty())
				{
					SendKeys(d,OptionCImage, celldata.getCell(8).getStringCellValue());
				}
				else if(celldata.getCell(8).getStringCellValue().isEmpty())
				{
					if(celldata.getCell(7).getCellType()==CellType.STRING)
					{
					SendKeys(d, OptionC, celldata.getCell(7).getStringCellValue());
					}
					else
					{
						double temp1=celldata.getCell(7).getNumericCellValue();
						int temp2=(int) temp1;
						String temp=String.valueOf(temp2);
						SendKeys(d, OptionC, temp);
					}
				}
				else
				{
					if(celldata.getCell(7).getCellType()==CellType.STRING)
					{
					SendKeys(d, OptionC, celldata.getCell(7).getStringCellValue());
					}
					else
					{
						double temp1=celldata.getCell(7).getNumericCellValue();
						int temp2=(int) temp1;
						String temp=String.valueOf(temp2);
						SendKeys(d, OptionC, temp);
					}
					SendKeys(d, OptionCImage, celldata.getCell(8).getStringCellValue());
				}
				//Option D
				if(celldata.getCell(9).getRawValue().isEmpty())
				{
					SendKeys(d, OptionDImage, celldata.getCell(10).getStringCellValue());
				}
				else if(celldata.getCell(10).getStringCellValue().isEmpty())
				{
					if(celldata.getCell(9).getCellType()==CellType.STRING)
					{
					SendKeys(d, OptionD, celldata.getCell(9).getStringCellValue());
					}
					else
					{
						double temp1=celldata.getCell(9).getNumericCellValue();
						int temp2=(int) temp1;
						String temp=String.valueOf(temp2);
						SendKeys(d, OptionD, temp);
					}
				}
				else
				{
					if(celldata.getCell(9).getCellType()==CellType.STRING)
					{
					SendKeys(d, OptionD, celldata.getCell(9).getStringCellValue());
					}
					else
					{
						double temp1=celldata.getCell(9).getNumericCellValue();
						int temp2=(int) temp1;
						String temp=String.valueOf(temp2);
						SendKeys(d, OptionD, temp);
					}
					SendKeys(d, OptionDImage, celldata.getCell(10).getStringCellValue());
				}
				//Option ANS
				if(celldata.getCell(11).getStringCellValue().isEmpty())
				{
					SendKeys(d, Ans_Image, celldata.getCell(12).getStringCellValue());
				}
				else if(celldata.getCell(12).getStringCellValue().isEmpty())
				{
					SendKeys(d, AnsExplination, celldata.getCell(11).getStringCellValue());
				}
				else
				{
					SendKeys(d, AnsExplination, celldata.getCell(11).getStringCellValue());
					SendKeys(d, Ans_Image, celldata.getCell(12).getStringCellValue());
				}

				Select_by_Text(d, Currectoption, celldata.getCell(13).getStringCellValue());
				Thread.sleep(1000);
				Click(d,QuizSubmit);


		}
	}
}
