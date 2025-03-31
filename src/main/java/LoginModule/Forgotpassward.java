package LoginModule;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.TestBase;
import utils.Testutils;

public class Forgotpassward extends TestBase{
	String Random_Name = Testutils.generateRandomName();

	@FindBy(xpath = "//span[normalize-space()='Login']")
	WebElement Loginbutton;
	
	@FindBy(xpath = "//a[normalize-space()='Forgot Password?']")
	WebElement Forgotpass;
	
	@FindBy(xpath = "(//input[@id='form.login.email'])[1]")
	WebElement Email;
	
	@FindBy(xpath = "(//button[@type='button'])[1]")
	WebElement Resetbutton;
	
	@FindBy(xpath = "//div[@role='status']")
	WebElement Successmessage;
	
	@FindBy(xpath = "//input[@id='login']")
	WebElement Emailinput;
	
	@FindBy(xpath = "//i[@class='material-icons-outlined f36']")
	WebElement Gotobutton;
	
	@FindBy(xpath = "//span[@id=\"recaptcha-anchor\"]")
	WebElement checkbox;
	
	@FindBy(xpath = "//iframe[@id='ifmail']")
	WebElement inmailFrame;
	
	@FindBy(xpath = "(//button[@class='lm'])[1]")
	WebElement Firstmail;
	
	@FindBy(xpath = "//a[text()='Reset Password']")
	WebElement Resetpassward;
	
	@FindBy(xpath = "(//input[@id='form.reset_password.new_pass'])[1]")
	WebElement Newpassward;
	
	@FindBy(xpath = "(//input[@id='form.reset_password.confirm_password'])[1]")
	WebElement Confirmpassward;
	
	@FindBy(xpath = "(//span[normalize-space()='Update Password'])[1]")
	WebElement Updatebutton;
	
	@FindBy(xpath = "//div[@role='status']")
	WebElement updatedmessage;
	
	public Forgotpassward() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickon_forgotlink() throws InterruptedException {
		Thread.sleep(1000);
		Loginbutton.click();Thread.sleep(1000);
		Forgotpass.click();Thread.sleep(1000);
		Email.sendKeys(prop.getProperty("ForgotEmail"));
		Resetbutton.click();Thread.sleep(2000);
		Assert.assertEquals(Successmessage.getText(), "Success! Link to Reset password sent.");
		System.out.println("Reset Passward Link Sent Successfully");		
		
	}
/*	
	public void clickon_resetpassward() throws InterruptedException {
		Thread.sleep(2000);
		driver.get("https://yopmail.com/en");Thread.sleep(1000);
		Emailinput.sendKeys(prop.getProperty("ForgotEmail"));Thread.sleep(1000);
		Gotobutton.click();Thread.sleep(2000);
		checkbox.click();
		Testutils.switchToFrameByElement(driver, inmailFrame);Thread.sleep(1000);
		Resetpassward.click();Thread.sleep(1000);
		System.out.println("Reset Passward Page Opened Successfully.");
		
	}
	
	public void change_passward() throws InterruptedException {
		
		Testutils.Window_handler();
		Thread.sleep(500);
		Newpassward.sendKeys(Random_Name+"@123");Thread.sleep(500);
		Confirmpassward.sendKeys(Random_Name+"@123");Thread.sleep(500);
		Updatebutton.click();Thread.sleep(1500);
		Assert.assertEquals(updatedmessage.getText(), "Success! Password reset.");
		System.out.println("Reset Passward Link Sent Successfully");
	}
*/	
	
}
