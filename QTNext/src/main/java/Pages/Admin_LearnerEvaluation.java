package Pages;

import org.openqa.selenium.By;

public class Admin_LearnerEvaluation extends Admin_Settings{
	public By AssessmentType=By.partialLinkText("Assessment Type");
	public By Assessmentcategory=By.xpath("//a[@href='/assess_catgoryyyy']//div[@class='card card-animate']//div[@class='card-body']//div[@class='d-flex align-items-center']");
	public By AssessmentSubCategory=By.xpath("//a[@href='/assess_sub_catgoryyyy']");
	public By AssessmentTestCategory=By.xpath("//a[@href='/assess_test_cat']");
	public By AssessmentTestSubCategory=By.xpath("//a[@href='/assess_test_sub_cat']");
	public By AssessmentMode=By.xpath("//a[@href='/assess_test_mode']");

}
