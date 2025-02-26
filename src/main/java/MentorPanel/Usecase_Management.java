package MentorPanel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.TestBase;
import utils.Testutils;

public class Usecase_Management extends TestBase{
	String Random_Name = Testutils.generateRandomName();
	
	@FindBy(xpath = "(//img[@alt='user-profile'])[1]")
	WebElement Profile;
	
	@FindBy(xpath = "//span[contains(text(),'Switch to')]")
	WebElement Mentorpanel;
	
	@FindBy(xpath = "//a[@href='/tntra/admin/usecase-management']//div[@role='button']")
	WebElement usecase;
	
	@FindBy(xpath = "(//button[normalize-space()='Add'])[1]")
	WebElement Addbutton;
	
	@FindBy(xpath = "(//button[normalize-space()='Publish'])[1]")
	WebElement Publish;
	
	@FindBy(xpath = "//p[contains(text(), 'Please Enter')]")
	WebElement usecasMandatorycount;
	
	@FindBy(xpath = "(//input[@id='title'])[1]")
	WebElement usecaseinput;
	
	@FindBy(xpath = "//div[@class='jodit-wysiwyg']")
	WebElement Description;
	
	@FindBy(xpath = "(//button[normalize-space()='RESET'])[1]")
	WebElement Reset;
	
	@FindBy(xpath = "(//button[normalize-space()='Cancel'])[1]")
	WebElement Cancel;
	
	@FindBy(xpath = "//div[@role='status']")
	WebElement Successmessage;
	
	@FindBy(xpath = "//tbody/tr[1]/td[4]/button[1]")
	WebElement viewicon;
	
	@FindBy(xpath = "//input[@disabled]")
	WebElement disabledfields;
	
	@FindBy(xpath = "(//button[normalize-space()='Go Back'])[1]")
	WebElement goback;
	
	@FindBy(xpath = "(//span[@class=\"MuiButtonBase-root MuiSwitch-switchBase MuiSwitch-colorPrimary Mui-checked PrivateSwitchBase-root MuiSwitch-switchBase MuiSwitch-colorPrimary Mui-checked Mui-checked css-1ndmc9y\"])[1]")
	WebElement activetoggle;
	
	@FindBy(xpath = "//div[contains(@role,'status')]")
	WebElement inactivemessage;
	
	@FindBy(xpath = "(//span[@class=\"MuiButtonBase-root MuiSwitch-switchBase MuiSwitch-colorPrimary PrivateSwitchBase-root MuiSwitch-switchBase MuiSwitch-colorPrimary css-1ndmc9y\"])[1]")
	WebElement inactivtoggle;
	
	@FindBy(xpath = "//div[contains(@role,'status')]")
	WebElement activemessage;
	
	@FindBy(xpath = "//input[@id='search-career']")
	WebElement searchbar;
	
	@FindBy(xpath = "(//td[@class=\"MuiTableCell-root MuiTableCell-body MuiTableCell-sizeMedium css-u4mgp3\"])[1]")
	WebElement firsttd;
	
	@FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-h6 MuiTypography-paragraph css-1u3u3br']")
	WebElement nodata;
	
	@FindBy(xpath = "//button[@tabindex=\"0\" and @aria-label=\"Go to next page\"]")
	WebElement checknextbuttonenabled;
	
	@FindBy(xpath = "(//button[@tabindex=\"0\"])[last()]")
	WebElement nextpage;
	
	@FindBy(xpath = "//button[@tabindex=\"0\" and @aria-label=\"Go to previous page\"]")
	WebElement checkprebuttonenabled;
	
	@FindBy(xpath = "(//button[@tabindex=\"0\"])[last()-1]")
	WebElement previous;
	
	@FindBy(xpath = "//div[@class='MuiInputBase-root MuiInputBase-colorPrimary MuiTablePagination-input css-l3z95e']")
	WebElement perpagerow;
	
	@FindBy(xpath = "//li[normalize-space()='25']")
	WebElement changevalue;
	
	@FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-i9hf7q'])[3]")
	WebElement editicon;
	
	@FindBy(xpath = "//div[contains(@role,'status')]")
	WebElement updatednessage;

	
	
	
	public Usecase_Management() {
		PageFactory.initElements(driver, this);
	}
	
	public void navigate_to_usecasemanagement() throws InterruptedException {
		Thread.sleep(4000);
		Profile.click();Thread.sleep(500);
		Mentorpanel.click();
		Testutils.waitForElementAndClick(driver, usecase);	
	}
	
	public void buttons_mandatoryfields() throws InterruptedException {
		Testutils.waitForElementAndClick(driver, Addbutton);
		Testutils.waitForElementAndClick(driver, Publish);Thread.sleep(500);
		List<WebElement> mandatory_fields = driver.findElements(By.xpath("//p[contains(text(), 'Please Enter')]"));
	    System.out.println("Total number of Mandatory fields on page: " + mandatory_fields.size());
	    usecaseinput.sendKeys(Random_Name);
	    Description.sendKeys(Random_Name);
	    Reset.click();
	    Cancel.click();
	    
	}
	
	public void adddetails() throws InterruptedException {
		Thread.sleep(800);
		Testutils.waitForElementAndClick(driver, Addbutton);
		usecaseinput.sendKeys(Random_Name);
	    Description.sendKeys(Random_Name);
	    Publish.click();Thread.sleep(1000);
	    Assert.assertEquals(Successmessage.getText(), "Success! Record saved.");
	    System.out.println("Use Case Details added successfully.");

	}
	
	public void viewpage() throws InterruptedException {
		Thread.sleep(800);
		viewicon.click();
		List<WebElement> disabled_fields = driver.findElements(By.xpath("//input[@disabled]"));
	    System.out.println("Total number of disabled fields on page: " + disabled_fields.size());
	    goback.click();
	}
	
	public void toggleactions() throws InterruptedException {
		Thread.sleep(800);
		activetoggle.click();Thread.sleep(1000);
		Assert.assertEquals(inactivemessage.getText(), "Success! Record updated.");
		inactivtoggle.click();Thread.sleep(1000);
		Assert.assertEquals(activemessage.getText(), "Success! Record updated.");
	    System.out.println("Toggle Actions working properly.");
	}
	
	public void searchbar() throws InterruptedException {
		Thread.sleep(1000);
		String s = firsttd.getText();
		searchbar.sendKeys(s);Thread.sleep(500);
		driver.navigate().refresh();
		Thread.sleep(1000);
		searchbar.sendKeys(s+"1");Thread.sleep(500);
		Assert.assertEquals(nodata.getText(), "No data found");Thread.sleep(500);
	}
	
	public void pagination() throws InterruptedException {
		Thread.sleep(500);
		if(checknextbuttonenabled.isDisplayed()) {
			nextpage.click();Thread.sleep(500);
			previous.click();Thread.sleep(500);
		}else {
			System.out.println("List Page has not more than 10 record");
		}
		perpagerow.click();Thread.sleep(500);
		changevalue.click();Thread.sleep(1000);
	}
	
	public void editpage() throws InterruptedException {
		Thread.sleep(800);
		editicon.click();Thread.sleep(800);
		usecaseinput.sendKeys(Random_Name+"tulip");
		Description.sendKeys(Random_Name+"tulip");
		Publish.click();Thread.sleep(1000);
	    Assert.assertEquals(Successmessage.getText(), "Success! Record updated.");
	    
	}
	
}
