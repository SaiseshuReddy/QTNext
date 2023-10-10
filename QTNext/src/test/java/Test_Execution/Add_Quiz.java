package Test_Execution;
import org.openqa.selenium.WebDriver;
import java.io.IOException;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Pages.Admin_CreateQuiz;
public class Add_Quiz extends Admin_CreateQuiz
{
	WebDriver d;
	@BeforeClass
	public void l() throws Exception 
	{
		d = lunchUrl();
		login(d, "qtnext", "qtnext@123");
	}
	@Test(priority=1)
	public void createAssessment()
	{
		Click(d,QuestioningPath);
		delay(d, CreateQuiz, 1);
		Click(d,CreateQuiz);
	}
	@Test(priority=2)
	public void addAssessment() throws IOException, InterruptedException
	{
		add_Quiz(d);
	}
	@AfterClass
	public void quit()
	{
		d.quit();
	}
	@AfterMethod
	public void BugScreen(ITestResult result) throws Exception
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			Screen_Shot(d, result.getName());
		}
	}
}
