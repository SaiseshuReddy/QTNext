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
public class Admin_CreateAssessmentQuestions extends Admin_Dashboard
{
	public By SelectyourAssessment=By.xpath("//select[@name='assessment']");
	public By SelectTest=By.xpath("//select[@name='one']");
	public By SelectSets=By.xpath("//select[@name='two']");
	public By EnterYourQuestion=By.xpath("//input[@name='three']");
	public By EnterYourQuestionImage=By.xpath("//input[@name='four']");
	public By EnterOptionA=By.xpath("//input[@name='five']");
	public By EnterOptionAImage=By.xpath("//input[@name='six']");
	public By EnterOptionB=By.xpath("//input[@name='eight']");
	public By EnterOptionBImage=By.xpath("//input[@name='nine']");
	public By EnterOptionC=By.xpath("//input[@name='ten']");
	public By EnterOptionCImage=By.xpath("//input[@name='eleven']");
	public By EnterOptionD=By.xpath("//input[@name='twelve']");
	public By EnterOptionDImage=By.xpath("//input[@name='thirteen']");
	public By AnsExplination=By.xpath("//textarea[@name='ans_explanation']");
	public By AnsExplinationImage=By.xpath("//input[@name='ans_img']");
	public By SelectCurrectAns=By.xpath("//select[@name='correct_ans']");
	public By Submit=By.xpath("//div[@class='col-lg-12']//input[@value='Submit']");

 

	public void add_AssessmentQuestions(WebDriver d) throws IOException, InterruptedException
	{
		File src = new File(".//src//test//resources//Automation Test Sample.xlsx");
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet("Assessment Questions");
		int rowCount=sheet.getLastRowNum();
		for (int i=1; i<=rowCount; i++)
		{
			XSSFRow celldata=sheet.getRow(i);
			d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				Thread.sleep(1000);
				Select_by_Text(d, SelectyourAssessment, celldata.getCell(0).getStringCellValue());
				Select_by_Text(d, SelectTest, celldata.getCell(1).getStringCellValue());
				Select_by_Text(d, SelectSets, celldata.getCell(2).getStringCellValue());
				if(celldata.getCell(3).getRawValue().isEmpty())
				{
					SendKeys(d, EnterYourQuestionImage, celldata.getCell(4).getStringCellValue());
				}
				else if(celldata.getCell(4).getStringCellValue().isEmpty())
				{
					if(celldata.getCell(3).getCellType()==CellType.STRING)
					{
					SendKeys(d, EnterYourQuestion, celldata.getCell(3).getStringCellValue());
					}
					else
					{
						double temp1=celldata.getCell(3).getNumericCellValue();
						int temp2=(int) temp1;
						String temp=String.valueOf(temp2);
						SendKeys(d, EnterYourQuestion, temp);
					}
				}
				else
				{
					if(celldata.getCell(3).getCellType()==CellType.STRING)
					{
					SendKeys(d, EnterYourQuestion, celldata.getCell(3).getStringCellValue());
					}
					else
					{
						double temp1=celldata.getCell(3).getNumericCellValue();
						int temp2=(int) temp1;
						String temp=String.valueOf(temp2);
						SendKeys(d, EnterYourQuestion, temp);
					}
					SendKeys(d, EnterYourQuestionImage, celldata.getCell(4).getStringCellValue());
				}
				//Option A
				if(celldata.getCell(5).getRawValue().isEmpty())
				{
					SendKeys(d, EnterOptionAImage, celldata.getCell(6).getStringCellValue());
				}
				else if(celldata.getCell(6).getStringCellValue().isEmpty())
				{
					if(celldata.getCell(5).getCellType()==CellType.STRING)
					{
					SendKeys(d, EnterOptionA, celldata.getCell(5).getStringCellValue());
					}
					else
					{
						double temp1=celldata.getCell(5).getNumericCellValue();
						int temp2=(int) temp1;
						String temp=String.valueOf(temp2);
						SendKeys(d, EnterOptionA, temp);
					}
				}
				else
				{
					if(celldata.getCell(5).getCellType()==CellType.STRING)
					{
					SendKeys(d, EnterOptionA, celldata.getCell(5).getStringCellValue());
					}
					else
					{
						double temp1=celldata.getCell(5).getNumericCellValue();
						int temp2=(int) temp1;
						String temp=String.valueOf(temp2);
						SendKeys(d, EnterOptionA, temp);
					}
					SendKeys(d, EnterOptionAImage, celldata.getCell(6).getStringCellValue());
				}
				//option B
				if(celldata.getCell(7).getRawValue().isEmpty())
				{
					SendKeys(d, EnterOptionBImage, celldata.getCell(8).getStringCellValue());
				}
				else if(celldata.getCell(8).getStringCellValue().isEmpty())
				{
					if(celldata.getCell(7).getCellType()==CellType.STRING)
					{
					SendKeys(d, EnterOptionB, celldata.getCell(7).getStringCellValue());
					}
					else
					{
						double temp1=celldata.getCell(7).getNumericCellValue();
						int temp2=(int) temp1;
						String temp=String.valueOf(temp2);
						SendKeys(d, EnterOptionB, temp);
					}
				}
				else
				{
					if(celldata.getCell(7).getCellType()==CellType.STRING)
					{
					SendKeys(d, EnterOptionB, celldata.getCell(7).getStringCellValue());
					}
					else
					{
						double temp1=celldata.getCell(7).getNumericCellValue();
						int temp2=(int) temp1;
						String temp=String.valueOf(temp2);
						SendKeys(d, EnterOptionB, temp);
					}
					SendKeys(d, EnterOptionBImage, celldata.getCell(8).getStringCellValue());
				}
				//Option C
				if(celldata.getCell(9).getRawValue().isEmpty())
				{
					SendKeys(d, EnterOptionCImage, celldata.getCell(10).getStringCellValue());
				}
				else if(celldata.getCell(10).getStringCellValue().isEmpty())
				{
					if(celldata.getCell(9).getCellType()==CellType.STRING)
					{
					SendKeys(d, EnterOptionC, celldata.getCell(9).getStringCellValue());
					}
					else
					{
						double temp1=celldata.getCell(9).getNumericCellValue();
						int temp2=(int) temp1;
						String temp=String.valueOf(temp2);
						SendKeys(d, EnterOptionC, temp);
					}
				}
				else
				{
					if(celldata.getCell(9).getCellType()==CellType.STRING)
					{
					SendKeys(d, EnterOptionC, celldata.getCell(9).getStringCellValue());
					}
					else
					{
						double temp1=celldata.getCell(9).getNumericCellValue();
						int temp2=(int) temp1;
						String temp=String.valueOf(temp2);
						SendKeys(d, EnterOptionC, temp);
					}
					SendKeys(d, EnterOptionCImage, celldata.getCell(10).getStringCellValue());
				}
				//Option D
				if(celldata.getCell(11).getRawValue().isEmpty())
				{
					SendKeys(d, EnterOptionDImage, celldata.getCell(12).getStringCellValue());
				}
				else if(celldata.getCell(12).getStringCellValue().isEmpty())
				{
					if(celldata.getCell(11).getCellType()==CellType.STRING)
					{
					SendKeys(d, EnterOptionD, celldata.getCell(11).getStringCellValue());
					}
					else
					{
						double temp1=celldata.getCell(11).getNumericCellValue();
						int temp2=(int) temp1;
						String temp=String.valueOf(temp2);
						SendKeys(d, EnterOptionD, temp);
					}
				}
				else
				{
					if(celldata.getCell(11).getCellType()==CellType.STRING)
					{
					SendKeys(d, EnterOptionD, celldata.getCell(11).getStringCellValue());
					}
					else
					{
						double temp1=celldata.getCell(11).getNumericCellValue();
						int temp2=(int) temp1;
						String temp=String.valueOf(temp2);
						SendKeys(d, EnterOptionD, temp);
					}
					SendKeys(d, EnterOptionDImage, celldata.getCell(12).getStringCellValue());
				}
				//Option ANS
				if(celldata.getCell(13).getStringCellValue().isEmpty())
				{
					SendKeys(d, AnsExplinationImage, celldata.getCell(14).getStringCellValue());
				}
				else if(celldata.getCell(14).getStringCellValue().isEmpty())
				{
					SendKeys(d, AnsExplination, celldata.getCell(13).getStringCellValue());
				}
				else
				{
					SendKeys(d, AnsExplination, celldata.getCell(13).getStringCellValue());
					SendKeys(d, AnsExplinationImage, celldata.getCell(14).getStringCellValue());
				}

				Select_by_Text(d, SelectCurrectAns, celldata.getCell(15).getStringCellValue());
				Click(d,Submit);
			}
		}
}
