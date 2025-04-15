package MentorPanel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.TestBase;
import utils.Testutils;

public class Department_Management extends TestBase {
	String Random_Name = Testutils.generateRandomName();

	@FindBy(xpath = "(//img[@alt='user-profile'])[1]")
	WebElement Profile;

	@FindBy(xpath = "//span[contains(text(),'Switch to')]")
	WebElement Mentorpanel;

	@FindBy(xpath = "//p[contains(text(),'Department Management')]")
	WebElement deparement;

	@FindBy(xpath = "//button[text()=\"Add Department\"]")
	WebElement Addnew;

	@FindBy(xpath = "//input[@placeholder=\"Department Name\"]")
	WebElement departmentname;

	@FindBy(xpath = "//div[@role='status']")
	WebElement Successmessage;

	@FindBy(xpath = "(//button[@class=\"MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-i9hf7q\"])[last()]")
	WebElement editicon;

	@FindBy(xpath = "(//button[@class=\"MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-xk6knv\"])[last()]")
	WebElement cancelicon;

	@FindBy(xpath = "//div[@role='status']")
	WebElement updatedmessage;

	@FindBy(xpath = "(//button[@class=\"MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-xk6knv\"])[last()]")
	WebElement deleteicon;

	@FindBy(xpath = "//div[@role='status']")
	WebElement deletemessage;

	public Department_Management() {
		PageFactory.initElements(driver, this);
	}

	public void navigate_to_department() throws InterruptedException {
		Thread.sleep(4000);
		Profile.click();
		Thread.sleep(500);
		Mentorpanel.click();
		Testutils.waitForElementAndClick(driver, deparement);
	}

	public void adddepartment() throws Exception {
		Thread.sleep(1000);
		Addnew.click();
		Testutils.Scroll_to_element(departmentname);
		departmentname.sendKeys(Random_Name);
		Testutils.PressrobotEnter();Thread.sleep(2000);
		Assert.assertEquals(Successmessage.getText(), "Success! Record saved.");
	}

	public void edit_department() throws Exception {
		Thread.sleep(1000);
		editicon.click();Thread.sleep(500);
		cancelicon.click();Thread.sleep(500);
		editicon.click();Thread.sleep(500);
		departmentname.sendKeys(Random_Name+"1");
		Testutils.PressrobotEnter();Thread.sleep(2000);
	}

	public void delete_department() throws Exception {
		Thread.sleep(1000);
		deleteicon.click();Thread.sleep(1000);
		Assert.assertEquals(deletemessage.getText(), "Success! Record deleted.");
	}
}
