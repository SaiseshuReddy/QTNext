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
import org.apache.poi.ss.usermodel.CellType;

public class Admin_CreateAssessment extends Admin_Dashboard
{
	public By Create_AssessmentBtn=By.xpath("//button[contains(text(),\"Create Assessment\")]");
	public By Ass_Type=By.xpath("//select[@name=\"Type\"]");
	public By Ass_Cat=By.xpath("//select[@name=\"Asscat\"]");
	public By Ass_Subcat=By.xpath("//select[@name=\"Asssubcat\"]");
	public By Ass_Testcat=By.xpath("//select[@name=\"AssModType\"]");
	public By Ass_Testsubcat=By.xpath("//select[@name=\"subcptr\"]");
	public By Ass_Mode=By.xpath("//select[@name=\"lsn\"]");
	public By Ass_Title=By.xpath("//input[@name=\"xmtitle\"]");
	public By Dur=By.xpath("//input[@name=\"Tme\"]");
	public By Questions=By.xpath("//input[@name=\"Qns\"]");
	public By T_Marks=By.xpath("//input[@name=\"marks\"]");
	public By P_Marks=By.xpath("//input[@name=\"pass\"]");
	public By Mp_RA=By.xpath("//input[@name=\"right\"]");
	public By MP_WA=By.xpath("//input[@name=\"wrong\"]");
	public By Paper_Type=By.xpath("//select[@name=\"paper\"]");
	public By Options_Type=By.xpath("//select[@name=\"optp\"]");
	public By Ass_Desc=By.xpath("//textarea[@name=\"des\"]");
	public By Submit=By.xpath("//input[@value=\"Submit\"]");
	public By Reset=By.xpath("//input[@value=\"Reset\"]");
	public By Close=By.xpath("//button[@class=\"btn-close btn-close-white\"]");
	
	public void add_Assessment(WebDriver d) throws IOException, InterruptedException
	{
		File src = new File(".//src//test//resources//Adding PRA Assessments.xlsx");
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet("Adding Assessment");
		int rowCount=sheet.getLastRowNum();
		for (int i=1; i<=rowCount; i++)
		{
			XSSFRow celldata=sheet.getRow(i);
			double qp=celldata.getCell(6).getNumericCellValue();
			for(int j=1; j<=qp; j++)
			{
				d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				Click(d, Create_AssessmentBtn);
				Thread.sleep(1000);
				Select_by_Text(d, Ass_Type, celldata.getCell(0).getStringCellValue());
				Select_by_Text(d, Ass_Cat, celldata.getCell(1).getStringCellValue());
				Select_by_Text(d, Ass_Subcat, celldata.getCell(2).getStringCellValue());
				Select_by_Text(d, Ass_Testcat, celldata.getCell(3).getStringCellValue());
				Select_by_Text(d, Ass_Testsubcat, celldata.getCell(4).getStringCellValue());
				Select_by_Text(d, Ass_Mode, celldata.getCell(5).getStringCellValue());
				String qp_name=celldata.getCell(5).getStringCellValue();
				String qp_num=qp_name+"-QP "+j;
				SendKeys(d, Ass_Title, qp_num);
				double dur1=celldata.getCell(8).getNumericCellValue();
				int dur2=(int) dur1;
				String dur=String.valueOf(dur2);
				SendKeys(d, Dur, dur);
				double ques1=celldata.getCell(7).getNumericCellValue();
				int ques2=(int) ques1;
				String ques=String.valueOf(ques2);
				SendKeys(d, Questions, ques);
				double t_marks1=celldata.getCell(9).getNumericCellValue();
				int t_marks2=(int) t_marks1;
				String t_marks=String.valueOf(t_marks2);
				SendKeys(d, T_Marks, t_marks);
				if(celldata.getCell(10).getCellType()==CellType.STRING)
				{
				SendKeys(d, MP_WA, celldata.getCell(10).getStringCellValue());
				}
				else
				{
					double p_marks1=celldata.getCell(10).getNumericCellValue();
					int p_marks2=(int) p_marks1;
					String p_marks=String.valueOf(p_marks2);
					SendKeys(d, P_Marks, p_marks);
				}
				//double p_marks1=celldata.getCell(10).getNumericCellValue();
				//int p_marks2=(int) p_marks1;
				//String p_marks=String.valueOf(p_marks2);
				//SendKeys(d, P_Marks, p_marks);
				double mp_ra1=celldata.getCell(11).getNumericCellValue();
				int mp_ra2=(int) mp_ra1;
				String mp_ra=String.valueOf(mp_ra2);
				SendKeys(d, Mp_RA, mp_ra);
				if(celldata.getCell(12).getCellType()==CellType.STRING)
				{
				SendKeys(d, MP_WA, celldata.getCell(12).getStringCellValue());
				}
				else
				{
					double mp_wa1=celldata.getCell(12).getNumericCellValue();
					//int mp_wa2=(int) mp_wa1;
					String mp_wa=String.valueOf(mp_wa1);
					SendKeys(d, MP_WA, mp_wa);
				}
				//double mp_wa1=celldata.getCell(12).getNumericCellValue();
				//int mp_wa2=(int) mp_wa1;
				//String mp_wa=String.valueOf(mp_wa2);
				//SendKeys(d, MP_WA, mp_wa);
				Select_by_Text(d, Paper_Type, celldata.getCell(13).getStringCellValue());
				Select_by_Text(d, Options_Type, celldata.getCell(14).getStringCellValue());
				SendKeys(d, Ass_Desc, celldata.getCell(15).getStringCellValue());
				Click(d, Submit);
				
			}
			
			
		}
	}

}
