package ProfilePages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import base.TestBase;
import utils.Testutils;

public class Personal_Information extends TestBase {

	public Personal_Information() {
		PageFactory.initElements(driver, this);
	}

//	@FindBy(xpath = "//span[@class=\"ant-avatar ant-avatar-circle ant-avatar-image ant-dropdown-trigger pointer profileImage css-7ynt2h\"]")
//	WebElement Profile_Icn;
	@FindBy(xpath = "(//img[@alt='user-profile'])[1]")
	WebElement Profile_Icn;
	@FindBy(xpath = "//span[normalize-space()='Profile']")
	WebElement Profile_txt;
	@FindBy(xpath = "//div[@class='ant-card-extra']//*[name()='svg']")
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
	@FindBy(xpath = "(//input[@class=\"react-select__input\"])[5]")
	WebElement Language_ddl;
	@FindBy(xpath = "//a[@href='/tntra/profile/personal-information']//*[name()='svg']")
	WebElement PersonalInformation_txt;
	@FindBy(xpath = "//textarea[@id=\"aboutMe\"]")
	WebElement AboutMe_txt;
	@FindBy(xpath = "//input[@name='dob']")
	WebElement dob_txt;
	@FindBy(xpath = "//header[@class='top-header']")
	WebElement header_txt;
	@FindBy(xpath = "(//div[@class='react-select__indicator react-select__clear-indicator css-1xc3v61-indicatorContainer']//*[name()='svg'])[1]")
	WebElement Close_icn1;
	@FindBy(xpath = "(//div[@class='react-select__indicator react-select__clear-indicator css-1xc3v61-indicatorContainer']//*[name()='svg'])[2]")
	WebElement Close_icn2;
	@FindBy(xpath = "(//div//select)[1]")
	WebElement year_ddl;
	@FindBy(xpath = "(//div//select)[2]")
	WebElement month_ddl;
	@FindBy(xpath = "//option[contains(text(),'2003')]")
	WebElement year_txt;
	@FindBy(xpath = "//option[contains(text(),'April')]")
	WebElement month_txt;
	@FindBy(xpath = "//div[@aria-label='Choose Saturday, April 5th, 2003']")
	WebElement date_txt;
	@FindBy(xpath = "//div[@role='status']")
	WebElement success_txt;
	@FindBy(xpath = "(//div[@class='react-select__input-container css-18w4uv4'])[4]")
	WebElement Gender_txt;
	@FindBy(xpath = "//span[@class=\"error-msg d-block mt-2\"]")
	WebElement dob_val;
	@FindBy(xpath = "(//span[@class=\"error-msg\"])[3]")
	WebElement AboutMe_val;

	public void NavigatetoProfile() throws InterruptedException {
		Thread.sleep(4000);
		Profile_Icn.click();
		Thread.sleep(2000);
		Profile_txt.click();
	}

	public void NavigatetoPersonalInformation() throws InterruptedException {
		Thread.sleep(1000);
		// PersonalInformation_txt.click();
		Testutils.scrollUsingAction(LastName_txt);
		Thread.sleep(2000);
		Edit_icn.click();
	}

	public void verifyDisabledFields() throws InterruptedException {

		List<WebElement> disabledElements = driver.findElements(By.xpath("//*[@disabled]"));
		for (WebElement element : disabledElements) {
			System.out.println("Tag: " + element.getTagName() + ", Name: " + element.getAttribute("name") + ", ID: "
					+ element.getAttribute("id"));
		}
		System.out.println("Total disabled fields found: " + disabledElements.size());
		Assert.assertEquals(disabledElements.size(), 4);
	}

	public void verifyRequiredFields() throws InterruptedException {

		List<WebElement> requiredElements = driver.findElements(By.xpath("//*[@Required]"));
		Thread.sleep(1000);
		for (WebElement element : requiredElements) {
			System.out.println("Tag: " + element.getTagName() + ", Name: " + element.getAttribute("name") + ", ID: "
					+ element.getAttribute("id"));
		}
		System.out.println("Total required fields found: " + requiredElements.size());
		Assert.assertEquals(requiredElements.size(), 2);
	}

	public void verifyValidations() throws InterruptedException {
		Thread.sleep(1000);
		Testutils.scrollUsingAction(Gender_txt);
		dob_txt.click();
		Testutils.selectAllValue(dob_txt);
		Testutils.removeAllValue(dob_txt);
		Thread.sleep(1000);
		Testutils.scrollUsingAction(AboutMe_txt);
		Thread.sleep(2000);
		AboutMe_txt.click();
		Testutils.selectAllValue(AboutMe_txt);
		Testutils.removeAllValue(AboutMe_txt);
		Thread.sleep(1000);
		Testutils.scrollUsingAction(Save_btn);
		Thread.sleep(1000);
		Save_btn.click();
		Testutils.scrollUsingAction(dob_txt);
		String Expvaldob = "Please enter Date of Birth.";
		String Actvaldob = dob_val.getText();
		Assert.assertEquals(Actvaldob, Expvaldob);

		System.out.println("Expected Validation Message for Dob Field : " + "Please enter Date of Birth.");
		System.out.println("Actual Validation Message for Dob Field : " + dob_val.getText());

		String ExpvalAboutMe = "Please enter About Me.";
		String ActvalAboutMe = AboutMe_val.getText();
		Assert.assertEquals(ActvalAboutMe, ExpvalAboutMe);

		System.out.println("Expected Validation Message for About Me Field : " + "Please enter About Me.");
		System.out.println("Actual Validation Message for About Me Field : " + AboutMe_val.getText());

	}

	public void fillPersonalInformation() throws InterruptedException {
		Thread.sleep(2000);
		Testutils.scrollUsingAction(dob_txt);
		Thread.sleep(2000);
		dob_txt.click();
		year_ddl.click();
		selectFromStaticList(
				"//div[@class=\"react-datepicker__header react-datepicker__header--custom\"]//select[1]//option",
				"2003");
		Thread.sleep(1000);
		month_ddl.click();
		Thread.sleep(1000);
		selectFromStaticList(
				"//div[@class=\"react-datepicker__header react-datepicker__header--custom\"]//select[2]//option",
				"April");
		date_txt.click();
		Thread.sleep(1000);
		selectFromStaticList("//div[@class=\"react-datepicker__month\"]", "5");
		Testutils.scrollUsingAction(AboutMe_txt);
		Country_ddl.sendKeys("Australia");
		Testutils.PressEnter();
		State_ddl.sendKeys("Victoria");
		Testutils.PressEnter();
		City_ddl.sendKeys("Ascot");
		Testutils.PressEnter();
		Thread.sleep(2000);
		Gender_txt.click();
		selectFromStaticList("//div[@class=\"react-select__menu-list css-qr46ko\"]//div", "Male");
		Thread.sleep(2000);
		Language_ddl.sendKeys("Basaa");
		Testutils.PressEnter();
		AboutMe_txt.click();
		Testutils.selectAllValue(AboutMe_txt);
		Testutils.removeAllValue(AboutMe_txt);
		AboutMe_txt.sendKeys(
				"A dedicated software Qa with hands-on experience in manual & automation testing, bug tracking, and regression testing. Passionate about ensuring software quality by identifying and resolving critical bugs. Skilled in working with Jira and collaborating with development teams to enhance product functionality. Always eager to learn new testing methodologies and improve software reliability.");
		Testutils.scrollUsingAction(Save_btn);
		Save_btn.click();
		Assert.assertEquals(success_txt.getText(), "Success! Record updated.");

	}

	public static void selectFromStaticList(String xPath, String value) {
		List<WebElement> liList = driver.findElements(By.xpath(xPath));

		for (int i = 0; i < liList.size();) {
			String fetchValue = liList.get(i).getText();
			if (fetchValue.equals(value)) {
				String makingxPath = xPath + "[" + (i + 1) + "]";
				driver.findElement(By.xpath(makingxPath)).click();
				break;
			} else {
				i++;
			}
		}
	}

	public void updateDetails() throws InterruptedException {
		Testutils.scrollUsingAction(AboutMe_txt);
		Thread.sleep(1000);
		Close_icn2.click();
		Thread.sleep(3000);
		Language_ddl.sendKeys("Acoli");
		Testutils.PressEnter();
		AboutMe_txt.click();
		Thread.sleep(1000);
		Testutils.selectAllValue(AboutMe_txt);
		Testutils.removeAllValue(AboutMe_txt);
		AboutMe_txt.sendKeys(
				"A results-driven Software QA specialist with extensive experience in manual and automation testing, bug tracking, and regression analysis. Passionate about ensuring software excellence by identifying and resolving key issues. Adept at using Jira for issue management and working closely with development teams to optimize product features and functionality. Continuously motivated to explore new testing approaches to improve software reliability and performance.");
		Thread.sleep(1000);
		Testutils.scrollUsingAction(Save_btn);
		Save_btn.click();
		Assert.assertEquals(success_txt.getText(), "Success! Record updated.");

	}

}
