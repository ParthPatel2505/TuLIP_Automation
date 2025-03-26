package CollaborationANDReviewFlows;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import utils.Testutils;

public class Engineering_Collaboration extends TestBase{
	String Random_Name = Testutils.generateRandomName();
	String Random_Name2 = Testutils.generateRandomName();
	String Random_Mail = Testutils.RandomEmailGenerator();
	
	public Engineering_Collaboration() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//a[normalize-space()='Engineering'])[1]")
	WebElement Engineering;
	
	public void navigate_to_engineering() throws InterruptedException {
		Thread.sleep(4000);
		Engineering.click();
		Thread.sleep(500);
	}

	@FindBy(xpath = "(//button[@class='ant-btn css-2jq066 ant-btn-primary ant-btn-color-primary ant-btn-variant-solid ant-btn-sm'])[1]")
	WebElement add_Engineering;

	@FindBy(xpath = "(//input[@id='standard-full-width'])[1]")
	WebElement company_name;
	
	@FindBy(xpath = "(//span[@class='ant-select-selection-wrap'])[1]")
	WebElement domain;
	
	@FindBy(xpath = "(//span[@class='ant-select-selection-wrap'])[2]")
	WebElement use_case;
	
	@FindBy(xpath = "(//input[@id='standard-full-width'])[2]")
	WebElement project_name;
	
	@FindBy(xpath = "(//input[@value='1'])[1]")
	WebElement radio_private;
	
	@FindBy(xpath = "(//input[@id='standard-full-width'])[3]")
	WebElement full_name;
	
	@FindBy(xpath = "(//input[@id='standard-full-width'])[4]")
	WebElement email;
	
	@FindBy(xpath = "(//input[@id='standard-full-width'])[5]")
	WebElement phone;
	
	@FindBy(xpath = "(//span[@class='ant-select-selection-wrap'])[4]")
	WebElement country;
	
	@FindBy(xpath = "(//span[@class='ant-select-selection-wrap'])[5]")
	WebElement source;
	
	@FindBy(xpath = "(//div[@contenteditable='true'])[1]")
	WebElement service_description;
	
	@FindBy(xpath = "(//div[@contenteditable='true'])[2]")
	WebElement service_scope ;
	
	@FindBy(xpath = "(//span[normalize-space()='Supporting Documents'])[1]")
	WebElement supporting_text;
	
	@FindBy(xpath = "(//span[normalize-space()='Save'])[1]")
	WebElement save_buttom;
	
	public void add_engineering() throws InterruptedException {
		Thread.sleep(2000);
		add_Engineering.click();Thread.sleep(500);
		company_name.sendKeys(Random_Name);
		domain.click();Thread.sleep(1000);Testutils.PressEnter();Testutils.PressALT();
		use_case.click();Thread.sleep(1000);Testutils.PressEnter();Testutils.PressALT();
		project_name.sendKeys(Random_Name);
		radio_private.click();
		full_name.sendKeys(Random_Name);Thread.sleep(500);
		email.sendKeys(Random_Mail);Thread.sleep(500);
		phone.sendKeys("5123648526");Thread.sleep(500);Testutils.scrollUsingAction(supporting_text);
		country.click();Thread.sleep(1500);Testutils.PressEnter();Testutils.PressALT();
		source.click();Thread.sleep(1000);Testutils.PressEnter();Testutils.PressALT();		
		service_description.sendKeys(Random_Name);Thread.sleep(500);
		service_scope.sendKeys(Random_Name);Thread.sleep(500);Testutils.scrollUsingAction(save_buttom);supporting_text.click();
		save_buttom.click();Thread.sleep(3000);	
	}
	public void add_engineering2() throws InterruptedException {
		Thread.sleep(2000);
		add_Engineering.click();Thread.sleep(500);
		company_name.sendKeys(Random_Name2);
		domain.click();Thread.sleep(1000);Testutils.PressEnter();Testutils.PressALT();
		use_case.click();Thread.sleep(1000);Testutils.PressEnter();Testutils.PressALT();
		project_name.sendKeys(Random_Name2);
		radio_private.click();
		full_name.sendKeys(Random_Name2);Thread.sleep(500);
		email.sendKeys(Random_Mail);Thread.sleep(500);
		phone.sendKeys("5123648526");Thread.sleep(500);Testutils.scrollUsingAction(supporting_text);
		country.click();Thread.sleep(1500);Testutils.PressEnter();Testutils.PressALT();
		source.click();Thread.sleep(1000);Testutils.PressEnter();Testutils.PressALT();		
		service_description.sendKeys(Random_Name2);Thread.sleep(500);
		service_scope.sendKeys(Random_Name2);Thread.sleep(500);Testutils.scrollUsingAction(save_buttom);supporting_text.click();
		save_buttom.click();Thread.sleep(3000);	
	}
	
	
}
