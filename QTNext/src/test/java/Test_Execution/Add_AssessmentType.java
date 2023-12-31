package Test_Execution;
import org.openqa.selenium.WebDriver;
import java.io.IOException;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import Pages.Admin_Set_LE_Create_AssessmentType;

public class Add_AssessmentType extends Admin_Set_LE_Create_AssessmentType
{
	WebDriver d;
	@BeforeClass
	public void l() throws Exception 
	{
		d = lunchUrl();
		login(d, "qtnext", "qtnext@123");
	}
	@Test(priority=1)
	public void createAssessmentType()
	{
		Click(d,Settings);
		delay(d, LearnerEvaluation, 1);
		Click(d,LearnerEvaluation);
		delay(d, AssessmentType, 1);
		Click(d,AssessmentType);
	}
	@Test(priority=2)
	public void addAssessmentType() throws IOException, InterruptedException
	{
		add_Assessmenttype(d);
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
