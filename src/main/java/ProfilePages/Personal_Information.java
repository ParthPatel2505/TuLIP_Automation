package ProfilePages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.TestBase;
import utils.Testutils;

public class Personal_Information extends TestBase {

	public String storedEmail;

	public Personal_Information() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class=\"ant-avatar ant-avatar-circle ant-avatar-image ant-dropdown-trigger pointer profileImage css-7ynt2h\"]")
	WebElement Profile_Icn;
	@FindBy(xpath = "//span[normalize-space()='Profile']")
	WebElement Profile_txt;
	@FindBy(xpath = "//div[@class='d-flex justify-content-between cardHeader']//*[name()='svg']")
	WebElement Edit_icn;
	@FindBy(xpath = "//button[normalize-space()='Cancel']")
	WebElement Cancel_btn;
	@FindBy(xpath = "//div[@class='ant-row align-items-center css-7ynt2h']")
	WebElement footer_txt;
	@FindBy(xpath = "//button[@class=\"btn-primary btn-large\"]")
	WebElement Save_btn;
	@FindBy(xpath = "//input[@id='last-name']")
	WebElement LastName_txt;
	@FindBy(xpath = "//input[@id='email']")
	WebElement email_txt;
	@FindBy(xpath = "(//input[@class=\"react-select__input\"])[1]")
	WebElement Country_ddl;
	@FindBy(xpath = "(//input[@class=\"react-select__input\"])[2]")
	WebElement State_ddl;
	@FindBy(xpath = "(//input[@class=\"react-select__input\"])[3]")
	WebElement City_ddl;
	@FindBy(xpath = "(//input[@class=\"react-select__input\"])[4]")
	WebElement Language_ddl;
	@FindBy(xpath = "//a[@href='/tntra/profile/personal-information']//*[name()='svg']")
	WebElement PersonalInformation_txt;
	@FindBy(xpath = "//textarea[@id='aboutMe']")
	WebElement AboutMe_txt;
	@FindBy(xpath = "//input[@name='dob']")
	WebElement dob_txt;
	@FindBy(xpath = "//header[@class='top-header']")
	WebElement header_txt;
	@FindBy(xpath = "//div[@class='react-select__indicator react-select__clear-indicator css-1xc3v61-indicatorContainer']//*[name()='svg']")
	WebElement Close_icn;
	@FindBy(xpath = "//select[1]")
	WebElement year_ddl;
	@FindBy(xpath = "//select[2]")
	WebElement month_ddl;
	@FindBy(xpath = "//option[contains(text(),'2003')]")
	WebElement year_txt;
	@FindBy(xpath = "//option[contains(text(),'April')]")
	WebElement month_txt;
	@FindBy(xpath = "//div[@aria-label='Choose Saturday, April 5th, 2003']")
	WebElement date_txt;
	@FindBy(xpath = "//div[@role='status']")
	WebElement success_txt;

	public void NavigatetoProfile() throws InterruptedException {
		Thread.sleep(4000);
		Testutils.ElementOnClick(Profile_Icn);
		Thread.sleep(2000);
		Testutils.ElementOnClick(Profile_txt);
	}

	public void VerifyDisabledFields() throws InterruptedException {
		Thread.sleep(1000);
		// Testutils.ElementOnClick(PersonalInformation_txt);
		Thread.sleep(1000);
		Testutils.ElementOnClick(Edit_icn);

		List<WebElement> disabledElements = driver.findElements(By.xpath("//input[@disabled]"));
		for (WebElement element : disabledElements) {
			System.out.println("Tag: " + element.getTagName() + ", Name: " + element.getAttribute("name") + ", ID: "
					+ element.getAttribute("id"));
		}
		System.out.println("Total disabled fields found: " + disabledElements.size());
		Assert.assertEquals(disabledElements.size(), 2);
	}

	public void VerifyRequiredFields() throws InterruptedException {

		storedEmail = email_txt.getAttribute("value");
		Testutils.scrollUsingAction(Language_ddl);
		Thread.sleep(1000);
		Testutils.ElementOnClick(LastName_txt);
		Thread.sleep(1000);
		Testutils.selectAllValue(LastName_txt);
		Testutils.removeAllValue(LastName_txt);
		Thread.sleep(1000);
		Testutils.ElementOnClick(email_txt);
		Thread.sleep(1000);
		Testutils.selectAllValue(email_txt);
		Testutils.removeAllValue(email_txt);
		Thread.sleep(1000);
		Testutils.ElementOnClick(dob_txt);
		Thread.sleep(1000);
		Testutils.selectAllValue(dob_txt);
		Testutils.removeAllValue(dob_txt);
		Thread.sleep(1000);
		Testutils.ElementOnClick(header_txt);
		Testutils.scrollUsingAction(Cancel_btn);
		Testutils.ElementOnClick(AboutMe_txt);
		Thread.sleep(1000);
		Testutils.selectAllValue(AboutMe_txt);
		Testutils.removeAllValue(AboutMe_txt);
		Thread.sleep(3000);
		List<WebElement> requiredElements = driver.findElements(By.xpath("//span[contains(text(),'Please')]"));
		Thread.sleep(1000);
		for (WebElement element : requiredElements) {
			System.out.println("Tag: " + element.getTagName() + ", Name: " + element.getAttribute("name") + ", ID: "
					+ element.getAttribute("id"));
		}
		System.out.println("Total required fields found: " + requiredElements.size());
		Assert.assertEquals(requiredElements.size(), 2);
	}

	public void fillPersonalInformation() throws InterruptedException {
		Testutils.scrollUsingAction(dob_txt);
		LastName_txt.sendKeys("Patel");
//		email_txt.sendKeys("chand.patel@tntra.io");
		email_txt.sendKeys(storedEmail);
		Testutils.ElementOnClick(dob_txt);
		Thread.sleep(1000);
		Testutils.ElementOnClick(year_ddl);
		Thread.sleep(1000);
		Testutils.ElementOnClick(year_txt);
		Thread.sleep(1000);
		Testutils.ElementOnClick(month_ddl);
		Thread.sleep(1000);
		Testutils.ElementOnClick(month_txt);
		Thread.sleep(1000);
		Testutils.ElementOnClick(date_txt);
		Thread.sleep(1000);
		AboutMe_txt.sendKeys(
				"A dedicated software tester with hands-on experience in manual & automation testing, bug tracking, and regression testing. Passionate about ensuring software quality by identifying and resolving critical bugs. Skilled in working with Jira and collaborating with development teams to enhance product functionality. Always eager to learn new testing methodologies and improve software reliability.");
		Thread.sleep(2000);
		Country_ddl.sendKeys("Australia");
		Testutils.PressEnter();
		Thread.sleep(2000);
		State_ddl.sendKeys("Victoria");
		Testutils.PressEnter();
		Thread.sleep(2000);
		City_ddl.sendKeys("Ascot");
		Testutils.PressEnter();
		Thread.sleep(2000);
		Testutils.ElementOnClick(Close_icn);
		Thread.sleep(2000);
		Language_ddl.sendKeys("Basaa");
		Testutils.PressEnter();
		Thread.sleep(2000);
		Testutils.scrollUsingAction(Save_btn);
		Thread.sleep(2000);
		Testutils.ElementOnClick(Save_btn);
		Thread.sleep(1000);
		Assert.assertEquals(success_txt.getText(), "Success! Record updated.");

	}
}
