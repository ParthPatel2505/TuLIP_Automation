package MentorPanel;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.TestBase;
import utils.Testutils;

public class Challenge_Management extends TestBase {

	String Random_Name = Testutils.generateRandomName();
	public String s;

	@FindBy(xpath = "(//img[@alt='user-profile'])[1]")
	WebElement Profile;

	@FindBy(xpath = "//span[contains(text(),'Switch to')]")
	WebElement Mentorpanel;

	@FindBy(xpath = "//p[normalize-space()='Challenge Management']")
	WebElement challenge_management;

	@FindBy(xpath = "//button[@tabindex=\"0\" and @aria-label=\"Go to next page\"]")
	WebElement checknext_button_enabled;

	@FindBy(xpath = "(//button[@tabindex=\"0\"])[last()]")
	WebElement nextpage;

	@FindBy(xpath = "//button[@tabindex=\"0\" and @aria-label=\"Go to previous page\"]")
	WebElement checkpre_button_enabled;

	@FindBy(xpath = "(//button[@tabindex=\"0\"])[last()-1]")
	WebElement previous;

	@FindBy(xpath = "//div[@class='MuiInputBase-root MuiInputBase-colorPrimary MuiTablePagination-input css-l3z95e']")
	WebElement perpagerow;

	@FindBy(xpath = "//li[normalize-space()='25']")
	WebElement changevalue;

	@FindBy(xpath = "(//button[normalize-space()='Add'])[1]")
	WebElement add_button;

	@FindBy(xpath = "//p[contains(text(), 'Please') or contains(text(), 'required') or contains(text(), 'Required')]")
	WebElement mandatory_fields;

	@FindBy(xpath = "(//button[normalize-space()='Cancel'])[1]")
	WebElement cancel_button;

	@FindBy(xpath = "(//h2[normalize-space()='Confirmation'])[1]")
	WebElement confirm_text;

	@FindBy(xpath = "//button[@data-testid=\"modal-cancel-btn\"]")
	WebElement popup_cancel_button;

	@FindBy(xpath = "//button[@loadingprops=\"[object Object]\"]")
	WebElement popup_ok_button;

	@FindBy(xpath = "(//input[@id='name'])[1]")
	WebElement primary_name;

	@FindBy(xpath = "(//input[@id='objective'])[1]")
	WebElement primary_objective;

	@FindBy(xpath = "(//div[@id='level'])[1]")
	WebElement challenge_dropdown;

	@FindBy(xpath = "(//div[contains(@contenteditable,'true')])[1]")
	WebElement primary_description;

	@FindBy(xpath = "//button[normalize-space()='Add MileStone']")
	WebElement milestone_button;

	@FindBy(xpath = "//button[@aria-label='Cancel']")
	WebElement milestone_cancel;

	@FindBy(xpath = "//input[@name=\"milestonename\"]")
	WebElement milestone_name;

	@FindBy(xpath = "//input[@name=\"percentage\"]")
	WebElement percentage_input;

	@FindBy(xpath = "//input[@name=\"score\"]")
	WebElement score_input;

	@FindBy(xpath = "//p[text()=\"Percentage and Score should not be filled together\"]")
	WebElement per_score_validation;

	@FindBy(xpath = "//button[@aria-label='Save']")
	WebElement milestone_save;

	@FindBy(xpath = "//p[text()=\"Percentage should not exceed 100\"]")
	WebElement percentage_validation;

	@FindBy(xpath = "//input[@aria-autocomplete=\"list\"]")
	WebElement skill_dropdown;

	@FindBy(xpath = "(//div[@contenteditable='true'])[2]")
	WebElement challenge_guideline;

	@FindBy(xpath = "//span[@role=\"button\" and @type=\"file\"]")
	WebElement file_upload;

	@FindBy(xpath = "(//div[@class='jodit-wysiwyg'])[3]")
	WebElement Prerequisite;

	@FindBy(xpath = "(//div[contains(@class,'jodit-wysiwyg')])[8]")
	WebElement Review_Process;

	@FindBy(xpath = "//input[@id='estimated-time']")
	WebElement estimatedtime;

	@FindBy(xpath = "(//button[normalize-space()='Save'])[1]")
	WebElement save_button;

	@FindBy(xpath = "(//button[normalize-space()='Draft'])[1]")
	WebElement draft_button;

	@FindBy(xpath = "//input[@id='estimated-time']")
	WebElement success_message;

	@FindBy(xpath = "(//*[@data-testid=\"EyeIcon\"])[1]")
	WebElement viewicon;

	@FindBy(xpath = "//input[@disabled]")
	WebElement disabledfields;

	@FindBy(xpath = "(//button[normalize-space()='Go Back'])[1]")
	WebElement goback;

	@FindBy(xpath = "(//span[@data-testid=\"user-status-toggle\"])[1]")
	WebElement activetoggle;

	@FindBy(xpath = "//div[contains(@role,'status')]")
	WebElement inactivemessage;

	@FindBy(xpath = "(//span[@data-testid=\"user-status-toggle\"])[1]")
	WebElement inactivtoggle;

	@FindBy(xpath = "//div[contains(@role,'status')]")
	WebElement activemessage;

	@FindBy(xpath = "//input[@id=\"search-challenge\"]")
	WebElement searchbar;

	@FindBy(xpath = "(//td[@class=\"MuiTableCell-root MuiTableCell-body MuiTableCell-sizeMedium css-u4mgp3\"])[1]")
	WebElement firsttd;

	@FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-h6 MuiTypography-paragraph css-1u3u3br']")
	WebElement nodata;

	@FindBy(xpath = "(//button[normalize-space()='Filter'])[1]")
	WebElement filter_button;

	@FindBy(xpath = "(//button[normalize-space()='Cancel'])[1]")
	WebElement filter_cancel;

	@FindBy(xpath = "(//div[@id='status-filter'])[1]")
	WebElement filter_status;

	@FindBy(xpath = "//li[@data-value=\"drafted\"]")
	WebElement checkbox_drafted;

	@FindBy(xpath = "//li[@data-value=\"active\"]")
	WebElement checkbox_active;

	@FindBy(xpath = "//div[@class='MuiBackdrop-root MuiBackdrop-invisible MuiModal-backdrop css-1k3tqu']")
	WebElement sidepage_click;

	@FindBy(xpath = "(//button[normalize-space()='Apply'])[1]")
	WebElement filter_apply;

	@FindBy(xpath = "(//button[normalize-space()='RESET'])[1]")
	WebElement filter_reset;

	@FindBy(xpath = "(//span[contains(text(),'Active')])[2]")
	WebElement status_active;

	@FindBy(xpath = "//span[text()=\"Show Global\"]")
	WebElement show_global;

	@FindBy(xpath = "(//td[.//button[@class=\"MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-i9hf7q\"] and .//button[@aria-label=\"Delete\"]])[1]")
	WebElement delete_button;

	@FindBy(xpath = "(//h2[normalize-space()='Confirmation'])[1]")
	WebElement delete_confirmation;

	@FindBy(xpath = "(//button[normalize-space()='Cancel'])[1]")
	WebElement delete_cancel;

	@FindBy(xpath = "(//button[normalize-space()='Ok'])[1]")
	WebElement delete_ok;

	@FindBy(xpath = "//div[@role='status']")
	WebElement delete_message;

	@FindBy(xpath = "(//span[@class='ant-btn-icon'])[1]")
	WebElement side_panel;

	@FindBy(xpath = "//a[normalize-space()='Workstreams']")
	WebElement workstreams;

	@FindBy(xpath = "(//div[@id='rc-tabs-0-tab-1'])[1]")
	WebElement my_aspirations;

	@FindBy(xpath = "(//input[@name='view-all'])[1]")
	WebElement view_all;

	@FindBy(xpath = "(//input[@id='rc_select_0'])[1]")
	WebElement page_size;

	@FindBy(xpath = "(//div[contains(text(),'100 / page')])[1]")
	WebElement pagevalue_100;
	
	@FindBy(xpath = "(//a)[13]")
	WebElement first_challenge;
	
	@FindBy(xpath = "//div[@role='status']")
	WebElement accept_message;

	@FindBy(xpath = "//li[@class=\"ant-pagination-next ant-pagination-disabled\"]")
	WebElement next_button;

	@FindBy(xpath = "(//span[normalize-space()='Accept Aspiration'])[1]")
	WebElement accept_button;
	
	@FindBy(xpath = "(//span[normalize-space()='Submit'])[1]")
	WebElement challenge_submit;
	
	@FindBy(xpath = "//span[normalize-space()='Submit File']")
	WebElement submit_file;
	
	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement submission_checkbox;
	
	@FindBy(xpath = "(//button[@type='submit'])[1]")
	WebElement submission_submit;
	
	@FindBy(xpath = "//div[contains(@role,'status')]")
	WebElement submissionsuccess_message;
	
	@FindBy(xpath = "(//button[@aria-label=\"Edit\"])[1]")
	WebElement edit_challange;
	
	@FindBy(xpath = "//div[contains(@role,'status')]")
	WebElement edit_message;

	@FindBy(xpath = "(//a[@class=\"MuiTypography-root MuiTypography-inherit MuiLink-root MuiLink-underlineAlways css-1wxg3au\"])[1]")
	WebElement first_submission;
	
	@FindBy(xpath = "(//span[@class='eval-pending'])[1]")
	WebElement status_evalpending;
	
	@FindBy(xpath = "//button[@data-testid=\"submission-detail-view-btn\"]")
	WebElement submmission_view;
	

	public Challenge_Management() {
		PageFactory.initElements(driver, this);
	}

	public void navigate_to_challengemanagement() throws InterruptedException {
		Thread.sleep(1500);
		Profile.click();
		Thread.sleep(500);
		Mentorpanel.click();
		Testutils.waitForElementAndClick(driver, challenge_management);
	}

	public void pagination() throws InterruptedException {
		Thread.sleep(1000);
		if (checknext_button_enabled.isDisplayed()) {
			nextpage.click();
			Thread.sleep(1500);
			previous.click();
			Thread.sleep(500);
		} else {
			System.out.println("List Page has not more than 10 record");
		}
		perpagerow.click();
		Thread.sleep(500);
		changevalue.click();
		Thread.sleep(1000);
	}

	public void buttons_mandatoryfields() throws InterruptedException {
		Testutils.waitForElementAndClick(driver, add_button);
		save_button.click();
		Thread.sleep(500);
		Assert.assertTrue(!draft_button.isEnabled());
		List<WebElement> mandatory_fields = driver.findElements(By.xpath(
				"//p[contains(text(), 'Please') or contains(text(), 'required') or contains(text(), 'Required')]"));
		System.out.println("Total number of Mandatory fields on page: " + mandatory_fields.size());
		Assert.assertEquals(mandatory_fields.size(), 6);
		cancel_button.click();
		Thread.sleep(1000);
		popup_cancel_button.click();
		Thread.sleep(500);
		cancel_button.click();
		Thread.sleep(1000);
		popup_ok_button.click();
		Thread.sleep(1000);
	}

	public void primary_details() throws InterruptedException {
		Thread.sleep(800);
		Testutils.waitForElementAndClick(driver, add_button);
		primary_name.sendKeys(Random_Name);
		Thread.sleep(800);
		Assert.assertTrue(draft_button.isEnabled());
		primary_objective.sendKeys(Random_Name);
		Thread.sleep(800);
		challenge_dropdown.click();
		Testutils.PressDown();
		Testutils.PressEnter();
		primary_description.sendKeys(Random_Name);
	}

	public void milestone_details() throws Exception {

		milestone_button.click();
		milestone_cancel.click();
		milestone_button.click();
		milestone_name.sendKeys(Random_Name);
		percentage_input.sendKeys("60");
		score_input.sendKeys("40");
		Thread.sleep(1000);
		milestone_save.click();
		Thread.sleep(800);
		Assert.assertTrue(per_score_validation.isDisplayed());
		Testutils.selectAllValue(score_input);
		Testutils.removeAllValue(score_input);
		milestone_save.click();
		Thread.sleep(800);
		milestone_button.click();
		Thread.sleep(800);
		milestone_name.sendKeys(Random_Name);
		percentage_input.sendKeys("60");
		milestone_save.click();
		Thread.sleep(800);
		Assert.assertTrue(percentage_validation.isDisplayed());
		Testutils.selectAllValue(percentage_input);
		Testutils.removeAllValue(percentage_input);
		percentage_input.sendKeys("40");
		Thread.sleep(800);
		milestone_save.click();
		Thread.sleep(800);
		skill_dropdown.click();
		Testutils.PressDown();
		Testutils.PressEnter();
		challenge_guideline.sendKeys(Random_Name);
		String filePath = System.getProperty("user.dir") + "\\Files\\dummy.pdf";
		Testutils.uploadFileUsingRobot(file_upload, filePath);
		Prerequisite.sendKeys(Random_Name);
		Review_Process.sendKeys(Random_Name);
		estimatedtime.sendKeys("2d");
		save_button.click();
	}
	
	public void edit_challenge() throws InterruptedException {
		Thread.sleep(800);
		edit_challange.click();Thread.sleep(1000);
		challenge_dropdown.click();
		Testutils.PressDown();
		Testutils.PressEnter();
		save_button.click();Thread.sleep(1500);
		Assert.assertEquals(activemessage.getText(), "Success! Record updated.");
	}

	public void viewpage() throws InterruptedException {
		Thread.sleep(800);
		viewicon.click();
		List<WebElement> disabled_fields = driver.findElements(By.xpath("//input[@disabled]"));
		System.out.println("Total number of disabled fields on page: " + disabled_fields.size());
		Assert.assertEquals(disabled_fields.size(), 10);
		goback.click();
	}

	public void toggleactions() throws InterruptedException {
		Thread.sleep(800);
		activetoggle.click();
		Thread.sleep(1000);
		Assert.assertEquals(inactivemessage.getText(), "Success! Challenge deactivated.");
		inactivtoggle.click();
		Thread.sleep(1000);
		Assert.assertEquals(activemessage.getText(), "Success! Challenge activated.");
		System.out.println("Toggle Actions working properly.");
	}

	public void searchbar() throws InterruptedException {
		Thread.sleep(4000);
		s = firsttd.getText();
		searchbar.sendKeys(s);
		Thread.sleep(500);
		driver.navigate().refresh();
		Thread.sleep(1000);
		searchbar.sendKeys(s + "1");
		Thread.sleep(500);
		Assert.assertEquals(nodata.getText(), "No Data Found");
		Thread.sleep(500);
	}

	public void filter() throws InterruptedException {
		Thread.sleep(1000);
		filter_button.click();
		filter_cancel.click();
		filter_button.click();
		filter_status.click();
		checkbox_drafted.click();
		sidepage_click.click();
		filter_reset.click();
		Thread.sleep(800);
		filter_status.click();
		Thread.sleep(1000);
		checkbox_active.click();
		sidepage_click.click();
		Thread.sleep(1000);
		filter_apply.click();
		Thread.sleep(2000);
		Assert.assertTrue(status_active.isDisplayed());
		show_global.click();
		Thread.sleep(2000);
		show_global.click();
		driver.navigate().refresh();
		Thread.sleep(2500);
	}

	public void delete() throws InterruptedException {

		Thread.sleep(800);
		delete_button.click();
		Thread.sleep(1000);
		Assert.assertTrue(delete_confirmation.isDisplayed());
		delete_cancel.click();
		delete_button.click();
		delete_ok.click();
		Thread.sleep(1500);
		Assert.assertEquals(delete_message.getText(), "Success! Record deleted.");

	}

	public void accept_challenge() throws Exception {
		Thread.sleep(800);
		driver.get("https://tulip-uat.tntra.io/tntra/login");
		Testutils.logindetails("chand.patel@tntra.io", "Brijesh@05042003");Thread.sleep(1000);
		side_panel.click();Thread.sleep(1000);
		workstreams.click();Thread.sleep(1000);
		my_aspirations.click();Thread.sleep(1000);
		view_all.click();Thread.sleep(1000);
		page_size.sendKeys("100");Thread.sleep(800);Testutils.PressEnter();
		Thread.sleep(1000);
		first_challenge.click();Thread.sleep(3000);
		accept_button.click();	Thread.sleep(1500);
		Assert.assertEquals(accept_message.getText(), "Success! Aspiration accepted.");
		challenge_submit.click();
		String filePath = System.getProperty("user.dir") + "\\Files\\dummy.pdf";
		Testutils.uploadFileUsingRobot(submit_file, filePath);
		submission_checkbox.click();Thread.sleep(800);
		submission_submit.click();Thread.sleep(1500);
		Assert.assertEquals(submissionsuccess_message.getText(), "Success! Aspiration submitted.");
				
		/*this for when pagination with random location of added challenge
		 * do { List<WebElement> liList =
		 * driver.findElements(By.xpath("//td[@class='ant-table-cell']"));
		 * 
		 * for(int i=0; i < liList.size();) { String fetchValue =
		 * liList.get(i).getText(); if(fetchValue.equals(s)) { String makingxPath =
		 * liList + "[" + (i+1) + "]";
		 * driver.findElement(By.xpath(makingxPath)).click(); break; } else { i++; } }
		 * next_button.click(); Thread.sleep(3000);
		 * }while(!accept_button.isDisplayed());
		 */		
	}
	
	public void submission_marks() throws InterruptedException {
		Thread.sleep(800);
		first_submission.click();Thread.sleep(2000);
		Assert.assertEquals(status_evalpending.getText(), "Eval.Pending");
		submmission_view.click();
	}
	

}
