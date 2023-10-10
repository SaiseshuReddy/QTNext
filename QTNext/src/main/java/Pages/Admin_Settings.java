package Pages;
import org.openqa.selenium.By;
public class Admin_Settings extends Admin_Dashboard
{
	public By SubjectCategory=By.xpath("//a[@href='/subject_category/']");
	public By Subject=By.xpath("//a[@href='/subject/']");
	public By SpecializationBtn=By.xpath("//a[@href='/specialization/']");
	public By Languages=By.xpath("//a[@href='/language/']");
	public By LearnerEvaluation=By.xpath("//a[@href='/learningevaluation/']");	
}
