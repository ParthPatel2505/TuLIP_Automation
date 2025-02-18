package MentorPanel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.TestBase;
import utils.Testutils;

public class Category_Management extends TestBase{
	String Random_Name = Testutils.generateRandomName();
	
	@FindBy(xpath = "//span[@class='ant-avatar ant-avatar-circle ant-avatar-image ant-dropdown-trigger pointer profileImage css-7ynt2h']")
	WebElement Profile;
	
	@FindBy(xpath = "//span[contains(text(),'Switch to')]")
	WebElement Mentorpanel;
	
	@FindBy(xpath = "//p[normalize-space()='Category Management']")
	WebElement category;
	
	@FindBy(xpath = "//span[normalize-space()='Add New Category']")
	WebElement Addnew;
	
	@FindBy(xpath = "//div[contains(@class,'collapse-icon')]//input")
	WebElement newtext;
	
	@FindBy(xpath = "(//*[@class=\"MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-vubbuv\"])[last()]")
	WebElement crossicon;
	
	@FindBy(xpath = "(//*[@class=\"collapse-icon\"])[last()-2]")
	WebElement newlasttext;
	
	@FindBy(xpath = "(//*[@class=\"MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-vubbuv\"])[last()]")
	WebElement deleteicon;
	
	@FindBy(xpath = "(//button[normalize-space()='Cancel'])[1]")
	WebElement popupcancelicon;
	
	@FindBy(xpath = "//span[@class='MuiTypography-root MuiTypography-body1 css-nlc0qc']")
	WebElement confirmationtext;
	
	@FindBy(xpath = "(//button[normalize-space()='Ok'])[1]")
	WebElement okbutton;
	
	public Category_Management() {
		PageFactory.initElements(driver, this);
	}
	
	public void navigate_to_category() throws InterruptedException {
		Thread.sleep(4000);
		Profile.click();Thread.sleep(500);
		Mentorpanel.click();
		Testutils.waitForElementAndClick(driver, category);	
	}
	
	public void add_category() throws Exception {
		Thread.sleep(1000);Testutils.Scroll_to_element(Addnew);Thread.sleep(1000);
		Testutils.double_click(Addnew);
		newtext.sendKeys(Random_Name);Thread.sleep(500);
		Testutils.PressrobotEnter();Thread.sleep(1000);crossicon.click();
		Assert.assertEquals(newlasttext.getText(), Random_Name);
	}
	
	public void delete_category() throws InterruptedException {
		Thread.sleep(1000);
		deleteicon.click();Thread.sleep(500);
		Assert.assertEquals(confirmationtext.getText(), "Are you sure you want to delete this Category");
		popupcancelicon.click();Thread.sleep(500);
		deleteicon.click();Thread.sleep(500);
		okbutton.click();
		
	}
}
