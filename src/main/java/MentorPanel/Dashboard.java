package MentorPanel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.TestBase;
import utils.Testutils;

public class Dashboard extends TestBase {
	String Random_Name = Testutils.generateRandomName();

	@FindBy(xpath = "(//img[@alt='user-profile'])[1]")
	WebElement Profile;

	@FindBy(xpath = "//span[contains(text(),'Switch to')]")
	WebElement Mentorpanel;

	@FindBy(xpath = "(//p[normalize-space()='Dashboard'])[1]")
	WebElement dashboard;

	@FindBy(xpath = "(//h5[normalize-space()='Dashboard'])[1]")
	WebElement dashboard_text;

	@FindBy(xpath = "(//div[contains(@role,'combobox')])[1]")
	WebElement dropdown_combobox1;

	@FindBy(xpath = "(//span[text()='T(u)LIP'])[2]")
	WebElement Tulip_text;

	@FindBy(xpath = "(//span[text()='Yntra'])[1]")
	WebElement Yantra_text;

	@FindBy(xpath = "(//span[text()='Gurukula'])[1]")
	WebElement Gurukula_text;

	@FindBy(xpath = "(//div[@id='mui-component-select-ticketCountFilter'])[1]")
	WebElement dropdown_combobox2;

	@FindBy(xpath = "(//span[text()='All'])[1]")
	WebElement All_text;

	@FindBy(xpath = "(//span[text()='Idea'])[1]")
	WebElement Idea_text;

	@FindBy(xpath = "(//span[text()='EngineeringService'])[1]")
	WebElement Engineering_text;

	@FindBy(xpath = "(//div[@id='mui-component-select-statusCountFilter'])[1]")
	WebElement dropdown_combobox3;

	@FindBy(xpath = "(//span[text()='Monthly'])[1]")
	WebElement Monthly_text;

	@FindBy(xpath = "(//span[text()='Quarterly'])[1]")
	WebElement Quarterly_text;

	@FindBy(xpath = "(//span[text()='Yearly'])[1]")
	WebElement Yearly_text;
	
	@FindBy(xpath = "(//div[@id='mui-component-select-menteeActivityFilter'])[1]")
	WebElement dropdown_combobox4;

	@FindBy(xpath = "(//span[text()='Accepted'])[1]")
	WebElement Accepted_text;

	@FindBy(xpath = "(//span[text()='Enrolled'])[1]")
	WebElement Enrolled_text;

	@FindBy(xpath = "(//span[text()='Completed'])[1]")
	WebElement Completed_text;

	@FindBy(xpath = "(//div[@id='mui-component-select-overAllTicketFilter'])[1]")
	WebElement dropdown_combobox5;

	@FindBy(xpath = "(//span[text()='Idea'])[1]")
	WebElement idea_text;

	@FindBy(xpath = "(//span[text()='EngineeringService'])[1]")
	WebElement EngineeringService_text;

	@FindBy(xpath = "(//span[text()='All'])[2]")
	WebElement all1_text;
	
	@FindBy(xpath = "(//div[@id='mui-component-select-stageOverViewFilter'])[1]")
	WebElement dropdown_combobox6;
	
	@FindBy(xpath = "(//span[text()='All'])[2]")
	WebElement all2_text;
	
	@FindBy(xpath = "(//div[@id='mui-component-select-courseFilter'])[1]")
	WebElement dropdown_combobox7;

	@FindBy(xpath = "(//span[text()='Active'])[1]")
	WebElement Active_text;

	@FindBy(xpath = "(//span[text()='Drafted'])[1]")
	WebElement Drafted_text;

	@FindBy(xpath = "(//span[text()='Inactive'])[1]")
	WebElement Inactive_text;
	
	@FindBy(xpath = "(//span[text()='Upcoming'])[1]")
	WebElement Upcoming_text;
	


	public Dashboard() {
		PageFactory.initElements(driver, this);
	}

	public void navigate_to_dashboard() throws InterruptedException {
		Thread.sleep(4000);
		Profile.click();
		Thread.sleep(500);
		Mentorpanel.click();
		Testutils.waitForElementAndClick(driver, dashboard);
		Thread.sleep(500);
		Assert.assertTrue(dashboard_text.isDisplayed());
	}

	public void ticketcount_dropdowns() throws InterruptedException {
		Thread.sleep(1000);
		dropdown_combobox1.click();
		Tulip_text.click();
		dropdown_combobox2.click();
		Idea_text.click();
		dropdown_combobox2.click();
		Engineering_text.click();
		dropdown_combobox2.click();
		All_text.click();
	}

	public void statuscount_dropdowns() throws InterruptedException {
		Thread.sleep(1000);
		dropdown_combobox3.click();
		Quarterly_text.click();
		dropdown_combobox3.click();
		Yearly_text.click();
		dropdown_combobox3.click();
		Monthly_text.click();
	}

	public void manetee_dropdowns() throws InterruptedException {
		Thread.sleep(1000);Testutils.scroll_bottom();
		dropdown_combobox4.click();
		Enrolled_text.click();Thread.sleep(800);
		dropdown_combobox4.click();
		Completed_text.click();Thread.sleep(800);
		dropdown_combobox4.click();
		Accepted_text.click();Testutils.scroll_top();
	}
	
	public void overallticket_dropdowns() throws InterruptedException {
		Thread.sleep(1000);
		dropdown_combobox1.click();
		Yantra_text.click();Thread.sleep(1000);
		dropdown_combobox5.click();
		idea_text.click();
		dropdown_combobox5.click();
		EngineeringService_text.click();
		dropdown_combobox5.click();
		all1_text.click();
	}
	
	public void stageoverview_dropdowns() throws InterruptedException {
		Thread.sleep(1000);
		dropdown_combobox6.click();
		idea_text.click();
		dropdown_combobox6.click();
		EngineeringService_text.click();
		dropdown_combobox6.click();
		all2_text.click();Thread.sleep(1000);
	}
	
	public void courses_dropdowns() throws InterruptedException {
		Thread.sleep(1000);
		dropdown_combobox1.click();
		Gurukula_text.click();Thread.sleep(1000);
		dropdown_combobox7.click();Thread.sleep(500);
		Drafted_text.click();Thread.sleep(500);
		dropdown_combobox7.click();Thread.sleep(500);
		Inactive_text.click();Thread.sleep(500);
		dropdown_combobox7.click();Thread.sleep(500);
		Upcoming_text.click();Thread.sleep(500);
		dropdown_combobox7.click();Thread.sleep(500);
		Active_text.click();Thread.sleep(500);
	}
}
