package CollaborationANDReviewFlows;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import utils.Testutils;

public class Ventures_Collaboration extends TestBase{
	String Random_Name = Testutils.generateRandomName();
	String Random_Name2 = Testutils.generateRandomName();
	String Random_Mail = Testutils.RandomEmailGenerator();

	public Ventures_Collaboration() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//a[normalize-space()='Ventures'])[1]")
	WebElement ventures;
	
	public void navigate_to_ventures() throws InterruptedException {
		Thread.sleep(4000);
		ventures.click();
		Thread.sleep(500);
	}
	
	@FindBy(xpath = "(//button[@class='ant-btn css-2jq066 ant-btn-primary ant-btn-color-primary ant-btn-variant-solid ant-btn-sm'])[1]")
	WebElement add_ventures;

	@FindBy(xpath = "(//input[@id='ventures.firstName'])[1]")
	WebElement first_name;
	
	@FindBy(xpath = "(//input[@id='ventures.lastName'])[1]")
	WebElement last_name;
	
	@FindBy(xpath = "(//input[@id='ventures.email'])[1]")
	WebElement email_address;
	
	@FindBy(xpath = "(//input[@id='ventures.companyName'])[1]")
	WebElement company_name;
	
	@FindBy(xpath = "(//input[@id='ventures.programOfInterest'])[1]")
	WebElement program_intrest;
	
	@FindBy(xpath = "(//input[@id='ventures.profYear'])[1]")
	WebElement years_exp;
	
	@FindBy(xpath = "(//input[@value='1'])[1]")
	WebElement radio_private;
	
	@FindBy(xpath = "(//div[@class='jodit-wysiwyg'])[1]")
	WebElement primary_program;
	
	@FindBy(xpath = "(//span[@class='ant-select-selection-wrap'])[2]")
	WebElement use_case;
	
	@FindBy(xpath = "(//span[@class='ant-select-selection-item'])[3]")
	WebElement refrral_source;
	
	@FindBy(xpath = "(//span[normalize-space()='Supporting Documents'])[1]")
	WebElement supporting_text;
	
	@FindBy(xpath = "(//span[normalize-space()='Save'])[1]")
	WebElement save_buttom;
	
	public void add_ventures() throws InterruptedException {
		Thread.sleep(2000);
		add_ventures.click();Thread.sleep(500);
		first_name.sendKeys(Random_Name);
		last_name.sendKeys(Random_Name);
		email_address.sendKeys(Random_Mail);
		company_name.sendKeys(Random_Name);
		program_intrest.sendKeys(Random_Name);
		years_exp.sendKeys("1");
		radio_private.click();
		primary_program.sendKeys(Random_Name);Testutils.scrollUsingAction(supporting_text);
		use_case.click();Thread.sleep(1000);Testutils.PressEnter();Testutils.PressALT();
		refrral_source.click();Thread.sleep(1000);Testutils.PressEnter();Testutils.PressALT();Testutils.scrollUsingAction(save_buttom);
		save_buttom.click();Thread.sleep(3000);
	}
	public void add_ventures2() throws InterruptedException {
		Thread.sleep(2000);
		add_ventures.click();Thread.sleep(500);
		first_name.sendKeys(Random_Name2);
		last_name.sendKeys(Random_Name2);
		email_address.sendKeys(Random_Mail);
		company_name.sendKeys(Random_Name2);
		program_intrest.sendKeys(Random_Name2);
		years_exp.sendKeys("1");
		radio_private.click();
		primary_program.sendKeys(Random_Name2);Testutils.scrollUsingAction(supporting_text);
		use_case.click();Thread.sleep(1000);Testutils.PressEnter();Testutils.PressALT();
		refrral_source.click();Thread.sleep(1000);Testutils.PressEnter();Testutils.PressALT();Testutils.scrollUsingAction(save_buttom);
		save_buttom.click();Thread.sleep(3000);
	}
}
