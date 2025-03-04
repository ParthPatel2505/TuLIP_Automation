package MentorPanel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.TestBase;
import utils.Testutils;

public class User_Management extends TestBase{
String Random_Name = Testutils.generateRandomName();
	
	@FindBy(xpath = "(//img[@alt='user-profile'])[1]")
	WebElement Profile;
	
	@FindBy(xpath = "//span[contains(text(),'Switch to')]")
	WebElement Mentorpanel;
	
	@FindBy(xpath = "//p[normalize-space()='User Management']")
	WebElement User_management;
	
	@FindBy(xpath = "//input[@id='search-user']")
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
	
	@FindBy(xpath = "(//button[@data-testid=\"user-edit-btn\"])[1]")
	WebElement edit_icon;
	
	@FindBy(xpath = "(//button[normalize-space()='Cancel'])[1]")
	WebElement cancel_icon;
	
	@FindBy(xpath = "(//div[@id='roles'])[1]")
	WebElement poup_dropdown;
	
	@FindBy(xpath = "(//div[.//*[@class=\"MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters MuiMenuItem-root MuiMenuItem-gutters css-iawcwn\"] and .//*[@data-testid=\"CheckBoxOutlineBlankIcon\"]])[3]")
	WebElement checkbox;
	
	@FindBy(xpath = "//div[@class='MuiBackdrop-root MuiBackdrop-invisible MuiModal-backdrop css-1k3tqu']")
	WebElement side_click;
	
	@FindBy(xpath = "(//button[normalize-space()='Update'])[1]")
	WebElement update_button;
	
	@FindBy(xpath = "//div[contains(@role,'status')]")
	WebElement update_message;
	
	@FindBy(xpath = "(//*[@data-testid=\"SchoolOutlinedIcon\"])[1]")
	WebElement careerpath_edit_icon;
	
	@FindBy(xpath = "(//button[normalize-space()='Cancel'])[1]")
	WebElement careerpath_cancle_button;
	
	@FindBy(xpath = "(//div[@id='status-filter'])[1]")
	WebElement department_dropdown;
	
	@FindBy(xpath = "//span[normalize-space()='Software tester 1']")
	WebElement department_value;
	
	@FindBy(xpath = "(//input[@name=\"radio-buttons\"])[1]")
	WebElement radio_button;
	
	@FindBy(xpath = "(//div[@id='status-filter'])[2]")
	WebElement job_title;
	
	@FindBy(xpath = "(//button[normalize-space()='RESET'])[1]")
	WebElement careerpath_resrt_button;
	
	@FindBy(xpath = "(//button[normalize-space()='Apply'])[1]")
	WebElement careerpath_apply_button;
	
	@FindBy(xpath = "//div[@role='status']")
	WebElement careerpath_update_messgae;
	
	@FindBy(xpath = "(//span[@class=\"MuiButtonBase-root MuiSwitch-switchBase MuiSwitch-colorPrimary Mui-checked PrivateSwitchBase-root MuiSwitch-switchBase MuiSwitch-colorPrimary Mui-checked Mui-checked css-1ndmc9y\"])[1]")
	WebElement active_toggle;
	
	@FindBy(xpath = "//div[contains(@role,'status')]")
	WebElement inactive_message;
	
	@FindBy(xpath = "(//span[@class=\"MuiButtonBase-root MuiSwitch-switchBase MuiSwitch-colorPrimary PrivateSwitchBase-root MuiSwitch-switchBase MuiSwitch-colorPrimary css-1ndmc9y\"])[1]")
	WebElement inactiv_toggle;
	
	@FindBy(xpath = "//div[contains(@role,'status')]")
	WebElement active_message;
	
	
	
	
	public User_Management() {
		PageFactory.initElements(driver, this);
	}
	
	public void navigate_to_usermanagement() throws InterruptedException {
		Thread.sleep(1000);
		Profile.click();Thread.sleep(500);
		Mentorpanel.click();
		Testutils.waitForElementAndClick(driver, User_management);	
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
	
	public void update_record() throws InterruptedException {
		Thread.sleep(1000);
		edit_icon.click();Thread.sleep(500);
		cancel_icon.click();
		edit_icon.click();Thread.sleep(800);
		poup_dropdown.click();Thread.sleep(800);
		checkbox.click();side_click.click();
		update_button.click();Thread.sleep(1000);
		Assert.assertEquals(update_message.getText(), "Success! Record updated.");
	}
	
	public void career_path() throws InterruptedException {
		Thread.sleep(1000);
		careerpath_edit_icon.click();careerpath_cancle_button.click();
		careerpath_edit_icon.click();Thread.sleep(800);
		department_dropdown.click();Thread.sleep(1300);Testutils.PressDown();Testutils.PressEnter();Thread.sleep(1500);
		//department_value.click();Thread.sleep(1000);
		radio_button.click();
		careerpath_resrt_button.click();Thread.sleep(1000);
		department_dropdown.click();Thread.sleep(1300);Testutils.PressDown();Testutils.PressEnter();Thread.sleep(1500);
		//department_value.click();Thread.sleep(1000);
		radio_button.click();
		job_title.click();Thread.sleep(1000);Testutils.PressEnter();
		careerpath_apply_button.click();Thread.sleep(1000);
		//Assert.assertEquals(careerpath_update_messgae.getText(), "Success! Record updated.");
	}
	
	public void toggleactions() throws InterruptedException {
		Thread.sleep(800);
		active_toggle.click();Thread.sleep(1000);
		Assert.assertEquals(inactive_message.getText(), "Success! User deactivated.");
		inactiv_toggle.click();Thread.sleep(1000);
		Assert.assertEquals(active_message.getText(), "Success! User activated.");
	    System.out.println("Toggle Actions working properly.");
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
	
}
