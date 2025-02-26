package MentorPanel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.TestBase;
import utils.Testutils;

public class Community_Management extends TestBase{
	String Random_Name = Testutils.generateRandomName();
	
	@FindBy(xpath = "//span[@class='ant-avatar ant-avatar-circle ant-avatar-image ant-dropdown-trigger pointer profileImage css-7ynt2h']")
	WebElement Profile;
	
	@FindBy(xpath = "//span[contains(text(),'Switch to')]")
	WebElement Mentorpanel;
	
	@FindBy(xpath = "//p[normalize-space()='Community Management']")
	WebElement community;
	
	@FindBy(xpath = "(//button[normalize-space()='Add'])[1]")
	WebElement Addbutton;
	
	@FindBy(xpath = "(//button[normalize-space()='Save'])[1]")
	WebElement savebutton;
	
	@FindBy(xpath = "//p[contains(text(), 'Please') or contains(text(), 'required')]")
	WebElement communityMandatorycount;
	
	@FindBy(xpath = "(//button[normalize-space()='Cancel'])[1]")
	WebElement cancelbutton;
	
	@FindBy(xpath = "(//input[@id='name'])[1]")
	WebElement communityinput;
	
	@FindBy(xpath = "//span[@class='MuiButton-icon MuiButton-startIcon MuiButton-iconSizeMedium css-1l6c7y9']")
	WebElement fileupload;
	
	@FindBy(xpath = "(//a[@role='button'])[1]")
	WebElement uploadedfile;
	
	@FindBy(xpath = "//div[@class='jodit-wysiwyg']")
	WebElement description;
	
	@FindBy(xpath = "//button[@title='Open']")
	WebElement communittags;
	
	@FindBy(xpath = "(//div[@class='MuiButtonBase-root MuiChip-root MuiChip-filled MuiChip-sizeMedium MuiChip-colorDefault MuiChip-deletable MuiChip-deletableColorDefault MuiChip-filledDefault MuiAutocomplete-tag MuiAutocomplete-tagSizeMedium css-1th7ptu'])[last()]")
	WebElement tagcancel;
	
	@FindBy(xpath = "//button[@title='Clear']")
	WebElement allclear;
	
	@FindBy(xpath = "//div[@role='status']")
	WebElement successaddedmsg;
	
	@FindBy(xpath = "(//button[@class=\"MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-i9hf7q\"])[2]")
	WebElement viewicon;
	
	@FindBy(xpath = "//input[@disabled]")
	WebElement disabledfields;
	
	@FindBy(xpath = "//button[text()='Go Back']")
	WebElement goback;
	
	@FindBy(xpath = "(//span[@class=\"MuiButtonBase-root MuiSwitch-switchBase MuiSwitch-colorPrimary Mui-checked PrivateSwitchBase-root MuiSwitch-switchBase MuiSwitch-colorPrimary Mui-checked Mui-checked css-1ndmc9y\"])[1]")
	WebElement activetoggle;
	
	@FindBy(xpath = "//div[contains(@role,'status')]")
	WebElement inactivemessage;
	
	@FindBy(xpath = "(//span[@class=\"MuiButtonBase-root MuiSwitch-switchBase MuiSwitch-colorPrimary PrivateSwitchBase-root MuiSwitch-switchBase MuiSwitch-colorPrimary css-1ndmc9y\"])[1]")
	WebElement inactivtoggle;
	
	@FindBy(xpath = "//div[contains(@role,'status')]")
	WebElement activemessage;
	
	@FindBy(xpath = "//input[@id=\"search-challenge\"]")
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
	
	@FindBy(xpath = "//button[@aria-label='Edit']")
	WebElement disablededit;
	
	@FindBy(xpath = "//div[contains(@role,'status')]")
	WebElement editupdatedmsg;
	
	
	public Community_Management() {
		PageFactory.initElements(driver, this);
	}
	
	public void navigate_to_community() throws InterruptedException {
		Thread.sleep(4000);
		Profile.click();Thread.sleep(500);
		Mentorpanel.click();
		Testutils.waitForElementAndClick(driver, community);	
	}
	
	public void buttons_mandatoryfields() throws InterruptedException {
		Testutils.waitForElementAndClick(driver, Addbutton);
		Testutils.waitForElementAndClick(driver, savebutton);Thread.sleep(500);
		List<WebElement> mandatory_fields = driver.findElements(By.xpath("//p[contains(text(), 'Please') or contains(text(), 'required')]"));
	    System.out.println("Total number of Mandatory fields on page: " + mandatory_fields.size());
	    cancelbutton.click();	    
	}
	
	public void adddetails() throws Exception {
		Thread.sleep(800);
		Testutils.waitForElementAndClick(driver, Addbutton);
		communityinput.sendKeys(Random_Name);
		String filePath = System.getProperty("user.dir") + "\\Files\\demo.png";
		Testutils.uploadFileUsingRobot(fileupload, filePath);
		Assert.assertTrue(uploadedfile.isDisplayed());
		description.sendKeys(Random_Name);
		communittags.click();
		Testutils.PressDown();Testutils.PressEnter();
		tagcancel.click();
		communittags.click();
		Testutils.PressDown();Testutils.PressEnter();
		allclear.click();
		communittags.click();
		Testutils.PressDown();Testutils.PressEnter();
		savebutton.click();Thread.sleep(1000);
	    Assert.assertEquals(successaddedmsg.getText(), "Success! Record saved.");
	    System.out.println("Community Details added successfully.");

	}
	
	public void viewpage() throws InterruptedException {
		Thread.sleep(800);
		viewicon.click();
		List<WebElement> disabled_fields = driver.findElements(By.xpath("//input[@disabled]"));
	    System.out.println("Total number of disabled fields on page: " + disabled_fields.size());Thread.sleep(500);
	    driver.navigate().back();    //goback.click();
	}
	
	public void toggleactions() throws InterruptedException {
		Thread.sleep(800);
		activetoggle.click();Thread.sleep(1000);
		Assert.assertEquals(inactivemessage.getText(), "Success! Community deactivated.");
		inactivtoggle.click();Thread.sleep(1000);
		Assert.assertEquals(activemessage.getText(), "Success! Community activated.");
	    System.out.println("Toggle Actions working properly.");
	}
	
	public void searchbar() throws InterruptedException {
		Thread.sleep(1000);
		String s = firsttd.getText();Thread.sleep(500);
		searchbar.sendKeys(s);Thread.sleep(1000);
		driver.navigate().refresh();
		Thread.sleep(1000);
		searchbar.sendKeys(s+"1");Thread.sleep(500);
		Assert.assertEquals(nodata.getText(), "No Data Found");Thread.sleep(500);
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
		Thread.sleep(1000);
		searchbar.sendKeys(Random_Name);Thread.sleep(1000);
		editicon.click();Thread.sleep(500);
		savebutton.click();Thread.sleep(1000);
		Assert.assertEquals(editupdatedmsg.getText(), "Success! Record updated.");	
	}
	
}
