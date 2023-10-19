package Test_Execution;
import org.openqa.selenium.WebDriver;
import java.io.IOException;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Pages.Admin_CreateQuizQuerstions;
public class Add_QuizQuestions extends Admin_CreateQuizQuerstions
{
	WebDriver d;
	@BeforeClass
	public void l() throws Exception 
	{
		d = lunchUrl();
		login(d, "qtnext", "qtnext@123");
	}
	@Test(priority=1)
	public void createQuizQuestions()
	{
		Click(d,QuestioningPath);
		delay(d, CreateQuizQuestions, 1);
		Click(d,CreateQuizQuestions);
	}
	@Test(priority=2)
	public void addQuizQuestions() throws IOException, InterruptedException
	{
		add_QuizQuestions(d);
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
