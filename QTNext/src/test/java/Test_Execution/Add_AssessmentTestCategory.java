package Test_Execution;
import org.openqa.selenium.WebDriver;
import java.io.IOException;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import Pages.Admin_Set_LE_Create_AssessmentTestCategory;

public class Add_AssessmentTestCategory extends Admin_Set_LE_Create_AssessmentTestCategory
{
	WebDriver d;
	@BeforeClass
	public void l() throws Exception 
	{
		d = lunchUrl();
		login(d, "qtnext", "qtnext@123");
	}
	@Test(priority=1)
	public void createAssessmentTestCat()
	{
		Click(d,Settings);
		delay(d, LearnerEvaluation, 1);
		Click(d,LearnerEvaluation);
		delay(d, AssessmentTestCategory, 1);
		Click(d,AssessmentTestCategory);
	}
	@Test(priority=2)
	public void addAssessmentTestCat() throws IOException, InterruptedException
	{
		add_AssessmentTestCategory(d);
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
