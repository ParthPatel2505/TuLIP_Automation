package MentorPanel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.TestBase;
import utils.Testutils;

public class Career_Management extends TestBase{
	String Random_Name = Testutils.generateRandomName();
	String Random_Name2 = Testutils.generateRandomName();
	String Random_Name3 = Testutils.generateRandomName();
	
	@FindBy(xpath = "(//img[@alt='user-profile'])[1]")
	WebElement Profile;
	
	@FindBy(xpath = "//span[contains(text(),'Switch to')]")
	WebElement Mentorpanel;
	
	@FindBy(xpath = "//p[normalize-space()='Career Management']")
	WebElement career;
	
	@FindBy(xpath = "(//button[normalize-space()='Add'])[1]")
	WebElement Add_button;
	
	@FindBy(xpath = "(//button[normalize-space()='Add a Level Challenge'])[1]")
	WebElement Add_lavel_challange;
	
	@FindBy(xpath = "(//button[normalize-space()='Publish'])[1]")
	WebElement Publish_button;
	
	@FindBy(xpath = "//p[contains(text(), 'Please') or contains(text(), 'required') or contains(text(), 'Required')]")
	WebElement mandatory_fields;
	
	@FindBy(xpath = "(//button[@label=\"Add\"])[last()]")
	WebElement inner_add_icon;
	
	@FindBy(xpath = "(//button[@label=\"Delete\"])[last()]")
	WebElement inner_delete_icon;
	
	@FindBy(xpath = "//div[@class=\"MuiAccordionSummary-expandIconWrapper Mui-expanded css-pqp93u\"]")
	WebElement up_arrow;
	
	@FindBy(xpath = "//div[@class=\"MuiAccordionSummary-expandIconWrapper css-pqp93u\"]")
	WebElement down_arrow;
	
	@FindBy(xpath = "(//button[@label=\"Delete\"])[1]")
	WebElement outer_delete_icon;
	
	@FindBy(xpath = "(//button[normalize-space()='Go Back'])[1]")
	WebElement goback_button;
	
	@FindBy(xpath = "//div[@id='mui-component-select-departmentId']")
	WebElement department;
	
	@FindBy(xpath = "//input[@id='title']")
	WebElement Title;
	
	@FindBy(xpath = "//div[@id='mui-component-select-careerLevelDtos.0.jobTitleId']")
	WebElement Job_title;
	
	@FindBy(xpath = "//button[contains(@title,'Open')]")
	WebElement Job_sub_title;
	
	@FindBy(xpath = "//input[@id='challengeCount']")
	WebElement Challange_count;
	
	@FindBy(xpath = "//input[@id='beginner']")
	WebElement Beginner;
	
	@FindBy(xpath = "//input[@id='intermediate']")
	WebElement intermediate;
	
	@FindBy(xpath = "//input[@id='advance']")
	WebElement Advance;
	
	@FindBy(xpath = "//p[contains(text(), 'Challenge Count')]")
	WebElement Challange_validation;
	
	@FindBy(xpath = "//div[@role='status']")
	WebElement add_Success_message;
	
	@FindBy(xpath = "(//button[@class=\"MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-i9hf7q\"])[2]")
	WebElement viewicon;
	
	@FindBy(xpath = "//input[@disabled]")
	WebElement disabled_fields;
	
	@FindBy(xpath = "(//span[@class=\"MuiButtonBase-root MuiSwitch-switchBase MuiSwitch-colorPrimary Mui-checked PrivateSwitchBase-root MuiSwitch-switchBase MuiSwitch-colorPrimary Mui-checked Mui-checked css-1ndmc9y\"])[1]")
	WebElement active_toggle;
	
	@FindBy(xpath = "//div[contains(@role,'status')]")
	WebElement inactive_message;
	
	@FindBy(xpath = "(//span[@class=\"MuiButtonBase-root MuiSwitch-switchBase MuiSwitch-colorPrimary PrivateSwitchBase-root MuiSwitch-switchBase MuiSwitch-colorPrimary css-1ndmc9y\"])[1]")
	WebElement inactiv_toggle;
	
	@FindBy(xpath = "//div[contains(@role,'status')]")
	WebElement active_message;
	
	@FindBy(xpath = "//input[@id=\"search-career\"]")
	WebElement searchbar;
	
	@FindBy(xpath = "(//td[@class=\"MuiTableCell-root MuiTableCell-body MuiTableCell-sizeMedium css-u4mgp3\"])[2]")
	WebElement firsttd;
	
	@FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-h6 MuiTypography-paragraph css-1u3u3br']")
	WebElement nodata;
	
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
	
	@FindBy(xpath = "(//button[normalize-space()='Save As Draft'])[1]")
	WebElement save_draft_button;
	
	@FindBy(xpath = "//div[@role='status']")
	WebElement draft_Success_message;
	
	@FindBy(xpath = "(//td[@class=\"MuiTableCell-root MuiTableCell-body MuiTableCell-sizeMedium css-u4mgp3\"])[5]")
	WebElement draft_status;
			
	@FindBy(xpath = "(//span[@aria-disabled=\"true\"])[1]")
	WebElement draft_inactive;
	
	@FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-i9hf7q'])[3]")
	WebElement editicon;
	
	@FindBy(xpath = "(//button[normalize-space()='Save As Template'])[1]")
	WebElement save_template_button;
	
	@FindBy(xpath = "(//button[@aria-label='close'])[1]")
	WebElement template_close_button;
	
	@FindBy(xpath = "(//button[normalize-space()='Reset'])[1]")
	WebElement template_reset_button;
	
	@FindBy(xpath = "(//button[normalize-space()='Cancel'])[1]")
	WebElement template_cancel_button;
	
	@FindBy(xpath = "(//input[@id='name'])[1]")
	WebElement template_name;
	
	@FindBy(xpath = "(//button[normalize-space()='Save'])[1]")
	WebElement template_save_button;
	
	@FindBy(xpath = "//div[@role='status']")
	WebElement template_Success_message;
	
	@FindBy(xpath = "(//button[normalize-space()='Use Template'])[1]")
	WebElement use_template_button;
	
	@FindBy(xpath = "(//input[@id='search-challenge'])[1]")
	WebElement template_search;
	
	@FindBy(xpath = "(//li[normalize-space()='100'])[1]")
	WebElement template_value;
	
	@FindBy(xpath = "(//td[@class=\\\"MuiTableCell-root MuiTableCell-body MuiTableCell-sizeMedium css-u4mgp3\\\"])[last()-1]")
	WebElement last_td;
	
	@FindBy(xpath = "(//td[@class=\"MuiTableCell-root MuiTableCell-body MuiTableCell-sizeMedium css-u4mgp3\"])[1]")
	WebElement temp_first_td;
	
	@FindBy(xpath = "//button[@aria-label=\"Edit\"]")
	WebElement temp_first_edit;
	
	public Career_Management() {
		PageFactory.initElements(driver, this);
	}
	
	public void navigate_to_career() throws InterruptedException {
		Thread.sleep(4000);
		Profile.click();Thread.sleep(500);
		Mentorpanel.click();
		Testutils.waitForElementAndClick(driver, career);	
	}
	
	public void buttons_mandatoryfields() throws InterruptedException {
		Testutils.waitForElementAndClick(driver, Add_button);
		Add_lavel_challange.click();Thread.sleep(500);
		Publish_button.click();Thread.sleep(500);
		List<WebElement> mandatory_fields = driver.findElements(By.xpath("//p[contains(text(), 'Please') or contains(text(), 'required') or contains(text(), 'Required')]"));
	    System.out.println("Total number of Mandatory fields on page: " + mandatory_fields.size());
	    Assert.assertEquals(mandatory_fields.size(), 4);
	    inner_add_icon.click();Thread.sleep(500);    
	    inner_delete_icon.click();Thread.sleep(500); up_arrow.click();Thread.sleep(500); down_arrow.click();Thread.sleep(500);
	    outer_delete_icon.click();Thread.sleep(500); goback_button.click();
	}
	
	public void add_details() throws Exception {
		Thread.sleep(800);
		Testutils.waitForElementAndClick(driver, Add_button);
		department.click();Testutils.PressEnter();
		Title.sendKeys(Random_Name);
		Add_lavel_challange.click();
		Job_title.click();Testutils.PressEnter();
		Job_sub_title.click();Thread.sleep(500);Testutils.PressDown();Testutils.PressDown();Testutils.PressEnter();
		Challange_count.sendKeys("3");
		Beginner.sendKeys("1");
		intermediate.sendKeys("1");
		Advance.sendKeys("1");Publish_button.click();Thread.sleep(500);
		//Assert.assertTrue(Challange_validation.isDisplayed());
		//Advance.clear();Thread.sleep(500);Advance.sendKeys("1");Thread.sleep(500);Assert.assertTrue(!Challange_validation.isDisplayed());
		//Publish_button.click();Thread.sleep(1000);
		//Assert.assertEquals(add_Success_message.getText(), "Success! Record saved.");
	}
	
	public void viewpage() throws InterruptedException {
		Thread.sleep(800);
		viewicon.click();Thread.sleep(1000);
		List<WebElement> disabled_fields = driver.findElements(By.xpath("//*[@disabled]"));
	    System.out.println("Total number of disabled fields on page: " + disabled_fields.size());
	    Assert.assertEquals(disabled_fields.size(), 12);
	    goback_button.click();Thread.sleep(500);
	}
	
	public void toggleactions() throws InterruptedException {
		Thread.sleep(800);
		active_toggle.click();Thread.sleep(1000);
		Assert.assertEquals(inactive_message.getText(), "Success! Career deactivated.");
		inactiv_toggle.click();Thread.sleep(1000);
		Assert.assertEquals(active_message.getText(), "Success! Career activated.");
	    System.out.println("Toggle Actions working properly.");
	}
	
	public void pagination() throws InterruptedException {
		Thread.sleep(1000);
		if(checknext_button_enabled.isDisplayed()) {
			nextpage.click();Thread.sleep(1500);
			previous.click();Thread.sleep(500);
		}else {
			System.out.println("List Page has not more than 10 record");
		}
		perpagerow.click();Thread.sleep(500);
		changevalue.click();Thread.sleep(1000);
	}
	
	public void searchbar() throws InterruptedException {
		Thread.sleep(1000);
		String s = firsttd.getText();Thread.sleep(500);
		searchbar.sendKeys(s);Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(1000);
		searchbar.sendKeys(s+"1");Thread.sleep(500);
		Assert.assertEquals(nodata.getText(), "No data found");Thread.sleep(500);
	}
	
	public void add_edit_draft() throws InterruptedException {
		Thread.sleep(800);
		Testutils.waitForElementAndClick(driver, Add_button);Thread.sleep(800);
		department.click();Thread.sleep(2000);Testutils.PressEnter();
		Title.sendKeys(Random_Name2);
		save_draft_button.click();Thread.sleep(3000);
		//Assert.assertEquals(draft_Success_message.getText(), "Success! Record saved.");Thread.sleep(500);
		Assert.assertEquals(draft_status.getText(), "Drafted");Thread.sleep(2000);
		Assert.assertTrue(draft_inactive.isDisplayed());
		Thread.sleep(1000);
		editicon.click();
		List<WebElement> disabled_fields = driver.findElements(By.xpath("//input[@disabled or @aria-disabled=\"true\"]"));
	    System.out.println("Total number of disabled fields on page: " + disabled_fields.size());Thread.sleep(500);
	    Assert.assertEquals(disabled_fields.size(), 4);
	    Add_lavel_challange.click();
		Job_title.click();Testutils.PressEnter();
		Job_sub_title.click();Thread.sleep(500);Testutils.PressDown();Testutils.PressDown();Testutils.PressEnter();
		Challange_count.sendKeys("3");
		Beginner.sendKeys("1");
		intermediate.sendKeys("1");
		Advance.sendKeys("1");Publish_button.click();Thread.sleep(3000);
		//Assert.assertEquals(draft_Success_message.getText(), "Success! Record updated.");
		Assert.assertEquals(draft_status.getText(), "Active");

	}
	
	public void add_template() throws InterruptedException {
		Thread.sleep(800);
		Testutils.waitForElementAndClick(driver, Add_button);
		department.click();Thread.sleep(1000);Testutils.PressEnter();
		Title.sendKeys(Random_Name3);Thread.sleep(800);
		save_template_button.click();Thread.sleep(800);
		template_close_button.click();Thread.sleep(800);
		save_template_button.click();Thread.sleep(800);
		template_cancel_button.click();Thread.sleep(800);
		save_template_button.click();Thread.sleep(800);
		template_name.sendKeys(Random_Name3);Thread.sleep(800);
		template_reset_button.click();Thread.sleep(800);template_name.sendKeys(Random_Name3);
		template_save_button.click();Thread.sleep(800);
		//Assert.assertEquals(template_Success_message.getText(), "Success! Record saved.");		
	}
	
	public void edit_template() throws InterruptedException {
		Thread.sleep(800);
		driver.navigate().refresh();
		career.click();
		use_template_button.click();Thread.sleep(2500);
		temp_first_edit.click();Thread.sleep(500);
		Title.sendKeys(Random_Name3+"demo");Thread.sleep(800);		
		Job_sub_title.click();Thread.sleep(500);Testutils.PressDown();Testutils.PressDown();Testutils.PressEnter();
		Challange_count.sendKeys("3");
		Beginner.sendKeys("1");
		intermediate.sendKeys("1");
		Advance.sendKeys("1");Publish_button.click();Thread.sleep(3000);
	}
	
}
