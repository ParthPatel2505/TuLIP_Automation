package ProfilePages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.TestBase;
import utils.Testutils;

public class Education extends TestBase {

	public Education() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='/tntra/profile/education']")
	WebElement Education_txt;
	@FindBy(xpath = "//div[@class='d-flex justify-content-between cardHeader']//*[name()='svg']")
	WebElement Plus_icn;
	@FindBy(xpath = "//input[@id='react-select-8-input']")
	WebElement University_ddl;
	@FindBy(xpath = "//input[@id=\"react-select-9-input\"]")
	WebElement Degree_ddl;
	@FindBy(xpath = "(//*[@class=\"react-select-container css-b62m3t-container\"])[3]")
	WebElement Startmonth_ddl;
	@FindBy(xpath = "(//*[@class=\"react-select-container css-b62m3t-container\"])[4]")
	WebElement Startyear_ddl;
	@FindBy(xpath = "(//*[@class=\"react-select-container css-b62m3t-container\"])[5]")
	WebElement Endmonth_ddl;
	@FindBy(xpath = "(//*[@class=\"react-select-container css-b62m3t-container\"])[6]")
	WebElement Endyear_ddl;
	@FindBy(xpath = "//input[@id='grade']")
	WebElement grade_txt;
	@FindBy(xpath = "//input[@id='specialSubject']")
	WebElement Specialsubject_txt;
	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement Save_btn;
	@FindBy(xpath = "//button[normalize-space()='Cancel']")
	WebElement Cancel_btn;
	@FindBy(xpath = "//div[@role='status']")
	WebElement SuccessonCreate_txt;
	@FindBy(xpath = "//div[@role='status']")
	WebElement SuccessonDelete_txt;
	@FindBy(xpath = "//div[@role='status']")
	WebElement SuccessonUpdate_txt;
	@FindBy(xpath = "(//*[name()='svg'][@class='pointer actionIcon undefined'])[1]")
	WebElement Edit_icn;
	@FindBy(xpath = "((//*[name()='svg'][@class='pointer actionIcon undefined'])[2]")
	WebElement Delete_icn;

	public void navigateToEducation() throws InterruptedException {
		Thread.sleep(2000);
		Education_txt.click();
		Thread.sleep(2000);
		Plus_icn.click();
	}

	public void disabledFields() throws InterruptedException {
		Thread.sleep(2000);
		Testutils.scrollUsingAction(Save_btn);
		List<WebElement> disabledfields = driver.findElements(By.xpath("//*[@disabled]\r\n"));
		for (WebElement Element : disabledfields) {
			System.out.println("Tag: " + Element.getTagName() + ", Name: " + Element.getAttribute("name") + ", ID: "
					+ Element.getAttribute("id"));
		}
		System.out.println("Total disabled fields found : " + disabledfields.size());
		Assert.assertEquals(disabledfields.size(), 0);
	}

	public void requiredFields() {
		List<WebElement> requiredFields = driver.findElements(By.xpath("//span[@class='error-msg']"));
		for (WebElement Element : requiredFields) {
			System.out.println("Tag: " + Element.getTagName() + ", Name: " + Element.getAttribute("name") + ", ID: "
					+ Element.getAttribute("id"));
		}
		System.out.println("Total required fields found : " + requiredFields.size());
		Assert.assertEquals(requiredFields.size(), 1);
	}

	public void fillTheDetails() throws Exception {
		University_ddl.sendKeys("Babaria Institute of Technology");
		Testutils.PressEnter();
		Degree_ddl.sendKeys("BE");
		Testutils.PressEnter();
		Startyear_ddl.click();
		Testutils.selectFromStaticList("//div[@class='react-select__menu css-1nmdiq5-menu']/div/div",
				prop.getProperty("StartYear"));
		Startmonth_ddl.click();
		Testutils.selectFromStaticList("//div[@class='react-select__menu css-1nmdiq5-menu']/div/div",
				prop.getProperty("StartMonth"));
		Endyear_ddl.click();
		Testutils.selectFromStaticList("//div[@class='react-select__menu css-1nmdiq5-menu']/div/div",
				prop.getProperty("EndYear"));
		Endmonth_ddl.click();
		Testutils.selectFromStaticList("//div[@class='react-select__menu css-1nmdiq5-menu']/div/div",
				prop.getProperty("EndMonth"));
		grade_txt.sendKeys("65");
		Specialsubject_txt.sendKeys("Quality Assurance");
		Save_btn.click();
		Assert.assertEquals(SuccessonCreate_txt.getText(), "Success! Record saved.");
	}
	
	public void editDetails() throws InterruptedException
	{
		Edit_icn.click();
		grade_txt.click();
		Testutils.selectAllValue(grade_txt);
		Testutils.removeAllValue(grade_txt);
		grade_txt.sendKeys("75");
		Save_btn.click();
		Assert.assertEquals(SuccessonUpdate_txt.getText(), "Success! Record updated.");
	}

}
