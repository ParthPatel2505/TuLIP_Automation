package CollaborationANDReviewFlows;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.TestBase;
import utils.Testutils;

public class Innovation_Collaboration extends TestBase{
	String Random_Name = Testutils.generateRandomName();
	String Random_Name2 = Testutils.generateRandomName();

	public Innovation_Collaboration() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//a[normalize-space()='Innovation'])[1]")
	WebElement Innovation;
	
	public void navigate_to_innovation() throws InterruptedException {
		Thread.sleep(4000);
		Innovation.click();
		Thread.sleep(500);
	}

	@FindBy(xpath = "(//button[@class='ant-btn css-2jq066 ant-btn-primary ant-btn-color-primary ant-btn-variant-solid ant-btn-sm'])[1]")
	WebElement add_innovation;

	@FindBy(xpath = "(//input[@id='ideas.ideaTitle'])[1]")
	WebElement innovation_title;
	
	@FindBy(xpath = "(//span[@class='ant-select-selection-item'])[1]")
	WebElement initiative;
	
	@FindBy(xpath = "(//span[@class='ant-select-selection-wrap'])[2]")
	WebElement domain;
	
	@FindBy(xpath = "(//input[@id='ideas.referenceLink'])[1]")
	WebElement refrence_link;
	
	@FindBy(xpath = "(//div[@class='ant-select-selection-overflow'])[1]")
	WebElement tegs;
	
	@FindBy(xpath = "(//div[@class='ant-select-selector'])[4]")
	WebElement country;
	
	@FindBy(xpath = "(//div[@class='ant-select-selection-overflow'])[2]")
	WebElement use_case;
	
	@FindBy(xpath = "(//input[@value='1'])[1]")
	WebElement radio_private;
	
	@FindBy(xpath = "(//div[@class='jodit-wysiwyg'])[1]")
	WebElement d_innovation;
	
	@FindBy(xpath = "(//div[@class='jodit-wysiwyg'])[2]")
	WebElement d_Mpotential;
	
	@FindBy(xpath = "(//div[@class='jodit-wysiwyg'])[3]")
	WebElement d_Ppotential;
	
	@FindBy(xpath = "(//div[@class='jodit-wysiwyg'])[4]")
	WebElement d_availability ;
	
	@FindBy(xpath = "(//div[@class='jodit-wysiwyg'])[5]")
	WebElement d_compliance;
	
	@FindBy(xpath = "(//div[@class='jodit-wysiwyg'])[6]")
	WebElement d_model;
	
	@FindBy(xpath = "(//span[normalize-space()='Supporting Documents'])[1]")
	WebElement document;
	
	@FindBy(xpath = "(//span[normalize-space()='Save'])[1]")
	WebElement save_buttom;
	
	public void add_innovation() throws InterruptedException {
		Thread.sleep(2000);
		add_innovation.click();
		innovation_title.sendKeys(Random_Name);
		initiative.click();Thread.sleep(1500);Testutils.PressEnter();Testutils.PressALT();
		domain.click();Thread.sleep(1000);Testutils.PressEnter();Testutils.PressALT();
		refrence_link.sendKeys(Random_Name);
		tegs.click();Thread.sleep(1000);Testutils.PressEnter();Testutils.PressALT();
		country.click();Thread.sleep(1000);Testutils.PressEnter();Testutils.PressALT();
		use_case.click();Thread.sleep(1000);Testutils.PressEnter();Testutils.PressALT();
		radio_private.click();
		d_innovation.sendKeys(Random_Name);Thread.sleep(500);
		d_Mpotential.sendKeys(Random_Name);Thread.sleep(500);
		d_Ppotential.sendKeys(Random_Name);Thread.sleep(500);
		d_availability.sendKeys(Random_Name);Thread.sleep(500);
		d_compliance.sendKeys(Random_Name);Thread.sleep(500);
		d_model.sendKeys(Random_Name);Thread.sleep(500);Testutils.scrollUsingAction(save_buttom);document.click();
		save_buttom.click();Thread.sleep(3000);	
	}
	public void add_innovation2() throws InterruptedException {
		Thread.sleep(2000);
		add_innovation.click();
		innovation_title.sendKeys(Random_Name2);
		initiative.click();Thread.sleep(1500);Testutils.PressEnter();Testutils.PressALT();
		domain.click();Thread.sleep(1000);Testutils.PressEnter();Testutils.PressALT();
		refrence_link.sendKeys(Random_Name2);
		tegs.click();Thread.sleep(1000);Testutils.PressEnter();Testutils.PressALT();
		country.click();Thread.sleep(1000);Testutils.PressEnter();Testutils.PressALT();
		use_case.click();Thread.sleep(1000);Testutils.PressEnter();Testutils.PressALT();
		radio_private.click();
		d_innovation.sendKeys(Random_Name2);Thread.sleep(500);
		d_Mpotential.sendKeys(Random_Name2);Thread.sleep(500);
		d_Ppotential.sendKeys(Random_Name2);Thread.sleep(500);
		d_availability.sendKeys(Random_Name2);Thread.sleep(500);
		d_compliance.sendKeys(Random_Name2);Thread.sleep(500);
		d_model.sendKeys(Random_Name2);Thread.sleep(500);Testutils.scrollUsingAction(save_buttom);document.click();
		save_buttom.click();Thread.sleep(3000);	
	}
	
	@FindBy(xpath = "(//span[normalize-space()='Filters'])[1]")
	WebElement filter_button;
	
	@FindBy(xpath = "(//span[normalize-space()='Date Range'])[1]")
	WebElement date_range;
	
	@FindBy(xpath = "(//input[@placeholder='Start Date'])[1]")
	WebElement datepicker;
	
	@FindBy(xpath = "(//td[@class=\"ant-picker-cell ant-picker-cell-in-view ant-picker-cell-today\"])[last()]")
	WebElement start_date;
	
	@FindBy(xpath = "(//td[@class=\"ant-picker-cell ant-picker-cell-range-start ant-picker-cell-range-end ant-picker-cell-in-view ant-picker-cell-today\"])[last()]")
	WebElement end_date;
	
	@FindBy(xpath = "(//span[contains(text(),'Apply')])[1]")
	WebElement apply_button;
	
	@FindBy(xpath = "(//span[normalize-space()='Sort'])[1]")
	WebElement sort_button;
	
	@FindBy(xpath = "(//span[normalize-space()='Latest First'])[1]")
	WebElement latest_first;
	
	public void filter() throws InterruptedException {
		Thread.sleep(1500);
		filter_button.click();
		date_range.click();Thread.sleep(400);
		datepicker.click();Thread.sleep(400);
		start_date.click();Thread.sleep(400);
		end_date.click();Thread.sleep(300);
		apply_button.click();
		sort_button.click();
		latest_first.click();
	}
	
	@FindBy(xpath = "(//div[@class='ant-card-body'])[1]")
	WebElement first_iteam;
	
	@FindBy(xpath = "(//div[@class='ant-card-body'])[2]")
	WebElement second_iteam;
	
	@FindBy(xpath = "(//button[@class='ant-btn css-2jq066 ant-btn-primary ant-btn-color-primary ant-btn-variant-solid'])[1]")
	WebElement request_button;
	
	@FindBy(xpath = "(//textarea[@id='Remark'])[1]")
	WebElement remark;
	
	@FindBy(xpath = "(//span[normalize-space()='Submit'])[1]")
	WebElement submit_button;
	
	public void send_request() throws InterruptedException {
		Thread.sleep(1500);
		first_iteam.click();Thread.sleep(3500);Testutils.scrollUsingAction(request_button);
		request_button.click();
		remark.sendKeys(Random_Name);
		submit_button.click();
		
	}
	
	@FindBy(xpath = "(//span[@class='ant-avatar ant-avatar-sm ant-avatar-circle slate-bg-3 pointer css-2jq066'] | //span[@class='ant-avatar ant-avatar-circle slate-bg-3 pointer css-2jq066'])[1]")
	WebElement collaboration_request;	
	                 
	@FindBy(xpath = "//button[@disabled]")
	WebElement disabled_button;	
	
	@FindBy(xpath = "(//span[normalize-space()='Back'])[1]")
	WebElement back_button;	
	
	@FindBy(xpath = "(//input[@type='checkbox'])[2]")
	WebElement checkbox;
	
	@FindBy(xpath = "//span[normalize-space()='Reject']")
	WebElement reject_button;
	
	@FindBy(xpath = "(//span[@class='ant-btn-icon'])[3]")
	WebElement reject_icon;
	
	@FindBy(xpath = "(//span[normalize-space()='Cancel'])[1]")
	WebElement cancel_button;
	
	@FindBy(xpath = "(//textarea[@id='Remark'])[1]")
	WebElement remark2;
	
	@FindBy(xpath = "(//span[normalize-space()='Submit'])[1]")
	WebElement submit_button2;
			
	@FindBy(xpath = "(//div[@role='status'])[1]")
	WebElement success_message;	
	
	public void reject_request() throws InterruptedException {
		Thread.sleep(1500);
		first_iteam.click();Thread.sleep(2000);
		collaboration_request.click();Thread.sleep(1500);
		Assert.assertTrue(!disabled_button.isEnabled());
		back_button.click();Thread.sleep(800);
		collaboration_request.click();Thread.sleep(1500);
		checkbox.click();Thread.sleep(800);
		
		reject_button.click();Thread.sleep(800);
		cancel_button.click();
		checkbox.click();Thread.sleep(800);
		reject_button.click();Thread.sleep(800);
		remark2.sendKeys(Random_Name);
		submit_button2.click();Thread.sleep(1500);
		Assert.assertEquals(success_message.getText(), "Success! Request Response has been submitted.");Thread.sleep(800);
		
		reject_icon.click();Thread.sleep(800);
		remark2.sendKeys(Random_Name);
		submit_button2.click();Thread.sleep(1500);
		Assert.assertEquals(success_message.getText(), "Success! Request Response has been submitted.");
		
	}
	
	@FindBy(xpath = "(//span[normalize-space()='Approve'])[1]")
	WebElement approve_button;
	
	@FindBy(xpath = "(//span[@class='ant-btn-icon'])[4]")
	WebElement approve_icon;
	
	public void accept_request() throws InterruptedException {
		Thread.sleep(1500);
		first_iteam.click();Thread.sleep(2000);
		collaboration_request.click();Thread.sleep(1500);
		Assert.assertTrue(!disabled_button.isEnabled());
		checkbox.click();Thread.sleep(800);
		
		approve_button.click();Thread.sleep(1500);
		Assert.assertEquals(success_message.getText(), "Success! Request Response has been submitted.");Thread.sleep(800);
		
		approve_icon.click();Thread.sleep(1500);
		Assert.assertEquals(success_message.getText(), "Success! Request Response has been submitted.");
		
	}
}
