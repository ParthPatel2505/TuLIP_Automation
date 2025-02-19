package ProfilePages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
	@FindBy(xpath = "(//div[@class=\"react-select__input-container css-18w4uv4\"])[1]")
	WebElement University_ddl;
	@FindBy(xpath = "(//div[@class=\"react-select__input-container css-18w4uv4\"])[2]")
	WebElement Degree_ddl;
	@FindBy(xpath = "(//div[@class=\"react-select__input-container css-18w4uv4\"])[3]")
	WebElement Startmonth_ddl;
	@FindBy(xpath = "(//div[@class=\"react-select__input-container css-18w4uv4\"])[4]")
	WebElement Startyear_ddl;
	@FindBy(xpath = "(//div[@class=\"react-select__input-container css-18w4uv4\"])[5]")
	WebElement Endmonth_ddl;
	@FindBy(xpath = "(//div[@class=\"react-select__input-container css-18w4uv4\"])[6]")
	WebElement Endyear_ddl;
	@FindBy(xpath = "//input[@id='grade']")
	WebElement grade_txt;
	@FindBy(xpath = "//input[@id='specialSubject']")
	WebElement Specialsubject_txt;

	public void navigateToEducation() throws InterruptedException
	{
		Thread.sleep(2000);
		Education_txt.click();
		Thread.sleep(2000);
		Plus_icn.click();
	}
	public void disabledFields() throws InterruptedException {
		Thread.sleep(2000);
		List<WebElement> disabledfields = driver.findElements(By.xpath("//*[@disabled]\r\n"));
		for (WebElement Element : disabledfields) {
			System.out.println("Tag : " + Element.getTagName() + "ID : " + Element.getAttribute("id") + "Name : "
					+ Element.getAttribute("name"));
		}
		System.out.println("Total disabled fields found : " + disabledfields.size());
		Assert.assertEquals(disabledfields.size(), 0);
	}

	public void requiredFields() {
		List<WebElement> requiredFields = driver.findElements(By.xpath("//*[@required]"));
		for (WebElement Element : requiredFields) {
			System.out.println("Tag : " + Element.getTagName() + "ID : " + Element.getAttribute("id") + "Name : "
					+ Element.getAttribute("name"));
		}
		System.out.println("Total required fields found : " + requiredFields.size());
		Assert.assertEquals(requiredFields.size(), 1);
	}
}
