package Common;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.Browser;

public class Generic_Methods extends Browser 
{
	//excel write data class object
		Excel_Write ex = new Excel_Write();
		
		//loger class 
		  public static Logger log= LogManager.getLogger(Generic_Methods.class);
		
		
		//generic methods count- 15
		//Generic click method
		  /**
		   * this method is used for common clickable functionality in webapplication
		   * <p> 
		   * webdriver is interface
		   * <p>                                  
		   * elementtobeclicked parameter is a webelement locator path 
		   */
			public boolean Click(WebDriver driver, By elementToBeClicked)
			{
				WebElement ele=driver.findElement(elementToBeClicked);
				if(ele.isDisplayed() & ele.isEnabled())
				{
					try
					{
						ele.click();
						//delay(driver, elementToBeClicked,10);
						//Screen_Shot(driver);
						return true;
					}
					catch(Exception e)
					{
						e.printStackTrace();
						return false;	
					}
					
				}
				else
				{
					return false;
				}
				
			}
			
			//Generic Explicity Wait method
			public void delay(WebDriver dr, By element,long time)
			{	
				WebElement firstResult = new WebDriverWait(dr, Duration.ofSeconds(time))
				        .until(ExpectedConditions.elementToBeClickable((element)));	
				
			}
			
			//Generic Send key method
			public boolean SendKeys(WebDriver d, By elementToBeEntered, String text)
			{
				
				if(Enabled(d,elementToBeEntered) & display(d,elementToBeEntered))
				{
					try
					{
						d.findElement(elementToBeEntered).clear();
						d.findElement(elementToBeEntered).sendKeys(text);
						return true;
					}
					catch(Exception e)
					{
						return false;
					}
				}
				else
				{
					return false;
				}
				
			
			}
			
			
			//Generic isEnabled method
			public boolean Enabled(WebDriver d, By elementToBeEnable)
			{
				try
				{
					d.findElement(elementToBeEnable).isEnabled();
					return true;
				}
				catch(Exception e)
				{
					return false;
				}
			}
			
			//Generic idDisplayed method
			public boolean display(WebDriver d, By elementToBevisible)
			{
				try
				{
					d.findElement(elementToBevisible).isDisplayed();
					return true;
				}
				catch(Exception e)
				{
					return false;
				}
			}
			
			//Generic isSelected method
			public boolean Selected(WebDriver d, By elementToBeSelected)
			{
				try
				{
					d.findElement(elementToBeSelected).isSelected();
					return true;
				}
				catch(Exception e)
				{
					return false;
				}
			}
			
			//Generic method for Screen shot
			public boolean Screen_Shot(WebDriver driver, String screenshot) throws Exception
			{
				try
			{
				File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				// Now you can do whatever you need to do with it some delay.
				FileUtils.copyFile(scrFile, new File("./Screenshots/"+screenshot+".png"));
				return true;
			}
			catch (Exception e) {
				e.printStackTrace();
				return false;
			}
				
			}
		
			//Generic method for Select_By_Text functionality
			public boolean Select_by_Text(WebDriver d, By dropdon,String text)
			{
				if(Enabled(d,dropdon) & display(d,dropdon))
				{
					try 
					{
					Select drpCountry = new Select(d.findElement(dropdon));
					drpCountry.selectByVisibleText(text);
					return true;
					}
					catch(Exception e)
					{
						return false;
					}
				}
				else
				{
					return false;
				}
			}
			
			//Generic method for Select_By_Index functionality
			public boolean Select_by_Index(WebDriver d, By dropdon,int index)
			{
				if(Enabled(d,dropdon) & display(d,dropdon))
				{
					try 
					{
					Select drpCountry = new Select(d.findElement(dropdon));
					drpCountry.selectByIndex(index);
					return true;
					}
					catch(Exception e)
					{
						return false;
					}
				}
				else
				{
					return false;
				}
			}
			
			//generic method for drop_down_click function
			public boolean Dropdown_Click(WebDriver d, By dropdon)
			{
				if(Enabled(d,dropdon) & display(d,dropdon))
				{
					try 
					{
					  Click(d, dropdon);
					return true;
					}
					catch(Exception e)
					{
						return false;
					}
				}
				else
				{
					return false;
				}
			}
			
			
			//generic for check box
			public boolean Checkbox(WebDriver d, By check)
			{
				if(Enabled(d,check) & display(d,check))
				{
					try 
					{
					  Click(d, check);
					return true;
					}
					catch(Exception e)
					{
						return false;
					}
				}
				else
				{
					return false;
				}
			}
			

			//generic for radio button
			public boolean Radiobutton(WebDriver d, By radiobtn)
					{
						if(Enabled(d,radiobtn) & display(d,radiobtn))
						{
							try 
							{
							  Click(d, radiobtn);
							return true;
							}
							catch(Exception e)
							{
								return false;
							}
						}
						else
						{
							return false;
						}
					}
			
			//generic for clear text data
			public boolean Clear(WebDriver d, By clearpath)
					{
						if(Enabled(d,clearpath) & display(d,clearpath))
						{
							try 
							{
							  d.findElement(clearpath).clear();
							return true;
							}
							catch(Exception e)
							{
								return false;
							}
						}
						else
						{
							return false;
						}
					}
			
			//generic method for  scroll down
			public void Scroll_dwn(WebDriver d, int num)
			{
				JavascriptExecutor js = (JavascriptExecutor) d;
				js.executeScript("window.scrollBy(0,"+num+")", "");
			}
			
			
			//generic method for size of the tables
			public void Web_tables_size(WebDriver driver, By colmpath, By rowpath)
			{
				//Finding number of Rows
				List<WebElement> col = driver.findElements(colmpath);
				int colCount = col.size();
				System.out.println("No of columns in this table : " + colCount);

				//Finding number of Columns
				List<WebElement> row = driver.findElements(rowpath);
				int rowCount = row.size();
				System.out.println("No of rows in this table : " + rowCount);
			}
			/*
			 * 
			 */
			//generic method for get text of the tables
			public int   Web_tables_text(WebDriver driver, By tablename, String  Excellvalue , String ExcolName ) {
				//boolean result = false;
			int row =-1;
					WebElement table = driver.findElement(tablename);
				List<WebElement> cells = table.findElements(By.xpath(("tbody/tr/th")));
				int colCount = cells.size();
				int colnum=1 ;
				for(int i = 1 ; i<=colCount; i++) {
					String colname = table.findElement(By.xpath(("tbody/tr/th["+i+"]"))).getText();
					if(colname.equalsIgnoreCase(ExcolName)) {
						colnum=i;
						log.info(colname);
					//System.out.println(colname);
					break;
					}
				}
				int rows = table.findElements(By.xpath(("tbody/tr"))).size();
				int rownum = 0;
				for(int j =2; j<=rows;j++) {
					String cellvalue=table.findElement(By.xpath(("tbody/tr["+j +"]/td["+colnum+"]"))).getText();
					
					if(cellvalue.equalsIgnoreCase(Excellvalue)) {
						rownum =j;
						log.info(cellvalue);
						//System.out.println(cellvalue);
						break;
					}
	           
			}
			
				if(rownum>=2) {
					row= rownum;
				}
				return row;
			}
			
			//generic method for particular row and column get text of the table
			public void Tables_Row_Text(WebDriver driver, By tablename, By rowpath)
			{
				// locate the table element
				WebElement table = driver.findElement(tablename);
				
				 //To find third row of table
				 WebElement tableRow = table.findElement(rowpath);
		         String rowtext = tableRow.getText();
				 System.out.println("particular row of the table : "+rowtext);
			}
			
			//generic method for log4j
			
			/*
			 * public boolean loger(WebDriver driver, String text) { log.info(text);
			 * 
			 * }
			 */
			
}
