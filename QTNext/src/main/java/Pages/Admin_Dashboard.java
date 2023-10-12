package Pages;

import org.openqa.selenium.By;

public class Admin_Dashboard extends Admin_Login
{
	public By Learning_Path=By.xpath("//a[@href=\"#sidebarApps\"]");
	public By Create_Course=By.xpath("//a[text()=\" Create Course \"]");
	public By Create_Chapter=By.xpath("//a[text()=\" Create Chapter \"]");
	public By Create_Lesson=By.xpath("//a[text()=\" Create Lesson \"]");
	public By Create_Topic=By.xpath("//a[text()=\" Create Topic \"]");
	public By Assessment_Path=By.xpath("//span[text()=\"Assessment Path\"]");
	public By Create_Assessment=By.xpath("//a[contains(text(),\"Create Assessment\")]");
	public By Create_AssessmentQuestions=By.xpath("//a[@href='/create_question/']");
	public By QuestioningPath=By.xpath("//span[text()='Questioning Path']");
	public By Create_Quiz=By.xpath("//a[@href='/create_quiz/']");
	public By CreateQuizQuestions=By.xpath("//a[@href='/create_quiz_questions/']");
	public By Settings =By.xpath("//a[@href='/setting/']");
}
