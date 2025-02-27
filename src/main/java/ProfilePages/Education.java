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
		Thread.sleep(2000);
		University_ddl.sendKeys("Babaria Institute of Technology");
		Testutils.PressEnter();
		Thread.sleep(2000);
		Degree_ddl.sendKeys("BE");
		Testutils.PressEnter();
		Thread.sleep(2000);
		Startyear_ddl.click();
		Testutils.selectFromStaticList("//div[@class='react-select__menu css-1nmdiq5-menu']/div/div",
				prop.getProperty("StartYear"));
		Thread.sleep(2000);
		Startmonth_ddl.click();
		Testutils.selectFromStaticList("//div[@class='react-select__menu css-1nmdiq5-menu']/div/div",
				prop.getProperty("StartMonth"));
		Thread.sleep(2000);
		Endyear_ddl.click();
		Testutils.selectFromStaticList("//div[@class='react-select__menu css-1nmdiq5-menu']/div/div",
				prop.getProperty("EndYear"));
		Thread.sleep(2000);
		Endmonth_ddl.click();
		Testutils.selectFromStaticList("//div[@class='react-select__menu css-1nmdiq5-menu']/div/div",
				prop.getProperty("EndMonth"));
		Thread.sleep(1000);
		grade_txt.sendKeys("65");
		Thread.sleep(1000);
		Specialsubject_txt.sendKeys("Quality Assurance");
		Thread.sleep(1000);
		Save_btn.click();
		Thread.sleep(1000);
		Assert.assertEquals(SuccessonCreate_txt.getText(), "Success! Record saved.");
	}

}
