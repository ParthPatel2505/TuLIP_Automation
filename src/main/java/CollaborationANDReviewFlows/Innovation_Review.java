package CollaborationANDReviewFlows;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.TestBase;
import utils.Testutils;

public class Innovation_Review extends TestBase{
	String Random_Name = Testutils.generateRandomName();
	
	public Innovation_Review() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//span[normalize-space()='Sort'])[1]")
	WebElement sort_button;
	
	@FindBy(xpath = "(//span[normalize-space()='Latest First'])[1]")
	WebElement latest_first;
	
	public void sort() throws InterruptedException {
		Thread.sleep(1500);
		sort_button.click();
		latest_first.click();
		
	}
	
	@FindBy(xpath = "(//div[@class='ant-card-body'])[1]")
	WebElement first_iteam;
	
	@FindBy(xpath = "(//div[@class='ant-card-body'])[2]")
	WebElement second_iteam;
	
	@FindBy(xpath = "(//span[normalize-space()='Submit for review'])[1]")
	WebElement submit_review;
	
	@FindBy(xpath = "(//div[@id='_rht_toaster'])[1]")
	WebElement success_message;	
	
	public void review_request() throws InterruptedException {
		Thread.sleep(1500);
		first_iteam.click();Thread.sleep(1500);
		Testutils.scrollUsingAction(submit_review);Thread.sleep(900);
		submit_review.click();Thread.sleep(1500);
		Assert.assertEquals(success_message.getText(), "Ticket successfully sent for Review.");Thread.sleep(800);	
		driver.navigate().back();Thread.sleep(2500);
		second_iteam.click();Thread.sleep(1500);
		Testutils.scrollUsingAction(submit_review);Thread.sleep(900);
		submit_review.click();Thread.sleep(1500);
		Assert.assertEquals(success_message.getText(), "Ticket successfully sent for Review.");Thread.sleep(800);
	}
	
	@FindBy(xpath = "(//a[normalize-space()='Review Pool'])[1]")
	WebElement review_pool;
	
	public void navigate_to_review_pool() throws InterruptedException {
		Thread.sleep(4000);
		review_pool.click();
		Thread.sleep(500);
	}
	
	@FindBy(xpath = "(//span[contains(text(),'To Review')])[1]")
	WebElement review_status;
	
	@FindBy(xpath = "(//*[@class=\"tabler-icon tabler-icon-user-check \"])[1]")
	WebElement assign_icon;
	
	@FindBy(xpath = "(//span[contains(text(),'In Review')])[1]")
	WebElement review2_status;
	
	@FindBy(xpath = "(//*[@class=\"tabler-icon tabler-icon-user-cancel \"])[1]")
	WebElement unassign_icon;
	
	@FindBy(xpath = "(//span[normalize-space()='Cancel'])[1]")
	WebElement unassign_cancel;
	
	@FindBy(xpath = "(//span[normalize-space()='OK'])[1]")
	WebElement unassign_ok;
	
	public void assign_unassign() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertEquals(review_status.getText(), "To Review");
		assign_icon.click();Thread.sleep(1500);
		//Assert.assertEquals(success_message.getText(), "Successfully Assigned to self.");
		Assert.assertEquals(review2_status.getText(), "In Review");
		unassign_icon.click();Thread.sleep(800);
		unassign_cancel.click();Thread.sleep(800);
		unassign_icon.click();Thread.sleep(800);
		unassign_ok.click();Thread.sleep(1500);
		//Assert.assertEquals(success_message.getText(), "Successfully Unassigned.");
		Assert.assertEquals(review_status.getText(), "To Review");
	}
	
	@FindBy(xpath = "(//*[@class=\"tabler-icon tabler-icon-messages pointer\"])[1]")
	WebElement feedback_icon;
	
	@FindBy(xpath = "(//span[contains(text(),'Cancel')])")
	WebElement feedback_cancel_button;
	
	@FindBy(xpath = "//div[@class='ant-drawer-content-wrapper']//textarea[@id='dashboard.curation.stageGateProcessTab.noteLabel']")
	WebElement feedback_text;
	
	@FindBy(xpath = "(//span[normalize-space()='Submit'])[1]")
	WebElement feedback_submit_button;
	
	public void feedback() throws InterruptedException {
		Thread.sleep(2000);
		assign_icon.click();Thread.sleep(2000);
		feedback_icon.click();Thread.sleep(1000);
		//Assert.assertTrue(!feedback_submit_button.isEnabled());Thread.sleep(1000);
		feedback_text.sendKeys(Random_Name);Thread.sleep(500);
		feedback_submit_button.click();Thread.sleep(1500);
		Assert.assertEquals(success_message.getText(), "Review Comment added successfully.");
	}
	
	@FindBy(xpath = "(//*[@class=\"tabler-icon tabler-icon-x \"])[1]")
	WebElement reject_icon;
	
	@FindBy(xpath = "(//span[contains(text(),'Cancel')])[1]")
	WebElement reject_cancel_button;
	
	@FindBy(xpath = "(//textarea[@id='dashboard.curation.stageGateProcessTab.noteLabel'])[last()]")
	WebElement reject_text;
	
	@FindBy(xpath = "//button[@class='ant-btn css-1c1xt6l ant-btn-default-fill']")
	WebElement reject_button;
	
	@FindBy(xpath = "(//button[@type='button'])[9]")
	WebElement approve_button;
	
	public void reject_request() throws InterruptedException {
		Thread.sleep(2000);
		reject_icon.click();Thread.sleep(1500);
		//Assert.assertTrue(!reject_button.isEnabled());
		//Assert.assertTrue(!approve_button.isEnabled());Thread.sleep(500);
		reject_text.sendKeys(Random_Name);Thread.sleep(800);
		reject_button.click();Thread.sleep(1000);
	}
	
	@FindBy(xpath = "(//*[@class=\"tabler-icon tabler-icon-check \"])[1]")
	WebElement approve_icon;
	
	@FindBy(xpath = "(//span[contains(text(),'Cancel')])[3]")
	WebElement approve_cancel_button;
	
	@FindBy(xpath = "(//textarea[@id='dashboard.curation.stageGateProcessTab.noteLabel'])[last()]")
	WebElement approve_text;
	
	@FindBy(xpath = "(//span[normalize-space()='Approve'])[1]")
	WebElement submit_button;
	
	@FindBy(xpath = "(//span[contains(text(),'Approved')])[1]")
	WebElement review3_status;
	
	
	public void approve_request() throws InterruptedException {
		Thread.sleep(2000);
		assign_icon.click();Thread.sleep(2000);
		approve_icon.click();Thread.sleep(800);
		//Assert.assertTrue(!reject_button.isEnabled());
		//Assert.assertTrue(!approve_button.isEnabled());Thread.sleep(800);
		approve_text.sendKeys(Random_Name);Thread.sleep(500);
		submit_button.click();Thread.sleep(2000);
		Assert.assertEquals(review3_status.getText(), "Approved");
	}
	
	@FindBy(xpath = "(//span[contains(text(),'Approved')])[1]")
	WebElement approve_tag;
	
	@FindBy(xpath = "(//a[normalize-space()='Archive List'])[1]")
	WebElement archive_list;
	
	@FindBy(xpath = "(//span[contains(text(),'Rejected')])[1]")
	WebElement rejected_status;
	
	@FindBy(xpath = "(//td[@class='ant-table-cell'])[6]")
	WebElement rejected_reason;
	
	public void verify_approved_request() throws InterruptedException {
		Thread.sleep(1000);
		first_iteam.click();Thread.sleep(1500);
		Assert.assertTrue(approve_tag.isDisplayed());
	}
	
	public void verify_rejected_request() throws InterruptedException {
		Thread.sleep(1000);
		archive_list.click();Thread.sleep(3000);
		Assert.assertEquals(rejected_status.getText(), "Rejected");
		Assert.assertEquals(rejected_reason.getText(), Random_Name);
	}
	
}
