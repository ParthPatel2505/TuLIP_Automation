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

//	@FindBy(xpath = "//span[@class=\"ant-avatar ant-avatar-circle ant-avatar-image ant-dropdown-trigger pointer profileImage css-7ynt2h\"]")
//	WebElement Profile_Icn;
	@FindBy(xpath = "(//img[@alt='user-profile'])[1]")
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
		Testutils.clickOnElement(Profile_Icn);
		Thread.sleep(2000);
		Testutils.clickOnElement(Profile_txt);
	}

	public void VerifyDisabledFields() throws InterruptedException {
		Thread.sleep(1000);
		// Testutils.ElementOnClick(PersonalInformation_txt);
		Thread.sleep(1000);
		Testutils.clickOnElement(Edit_icn);

		List<WebElement> disabledElements = driver.findElements(By.xpath("//input[@disabled]"));
		for (WebElement element : disabledElements) {
			System.out.println("Tag: " + element.getTagName() + ", Name: " + element.getAttribute("name") + ", ID: "
					+ element.getAttribute("id"));
		}
		System.out.println("Total disabled fields found: " + disabledElements.size());
		Assert.assertEquals(disabledElements.size(), 2);
	}

	public void VerifyRequiredFields() throws InterruptedException {


		//Testutils.scrollUsingAction(Language_ddl);
		storedEmail = email_txt.getAttribute("value");
		Testutils.scrollUsingAction(Language_ddl);
		Testutils.ElementOnClick(LastName_txt);
		Testutils.selectAllValue(LastName_txt);
		Testutils.removeAllValue(LastName_txt);
		Testutils.ElementOnClick(email_txt);
		Testutils.selectAllValue(email_txt);
		Testutils.removeAllValue(email_txt);
		Testutils.ElementOnClick(dob_txt);
		Testutils.selectAllValue(dob_txt);
		Testutils.removeAllValue(dob_txt);
		Testutils.ElementOnClick(header_txt);
		Testutils.scrollUsingAction(Cancel_btn);
		Testutils.ElementOnClick(AboutMe_txt);
		Testutils.selectAllValue(AboutMe_txt);
		Testutils.removeAllValue(AboutMe_txt);
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
		//Testutils.scrollUsingAction(dob_txt);
		LastName_txt.sendKeys("Patel");
		email_txt.sendKeys(storedEmail);
		Testutils.ElementOnClick(dob_txt);
		Testutils.ElementOnClick(year_ddl);
		Testutils.ElementOnClick(year_txt);
		Testutils.ElementOnClick(month_ddl);
		Testutils.ElementOnClick(month_txt);
		Testutils.ElementOnClick(date_txt);
		AboutMe_txt.sendKeys(
				"A dedicated software tester with hands-on experience in manual & automation testing, bug tracking, and regression testing. Passionate about ensuring software quality by identifying and resolving critical bugs. Skilled in working with Jira and collaborating with development teams to enhance product functionality. Always eager to learn new testing methodologies and improve software reliability.");
		Country_ddl.sendKeys("Australia");
		Testutils.PressEnter();
		State_ddl.sendKeys("Victoria");
		Testutils.PressEnter();
		City_ddl.sendKeys("Ascot");
		Testutils.PressEnter();
		Thread.sleep(2000);
		Testutils.clickOnElement(Close_icn);
		Thread.sleep(2000);
		Language_ddl.sendKeys("Basaa");
		Testutils.PressEnter();
		Testutils.scrollUsingAction(Save_btn);
		Testutils.ElementOnClick(Save_btn);
		Assert.assertEquals(success_txt.getText(), "Success! Record updated.");

	}
}
