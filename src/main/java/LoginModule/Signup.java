package LoginModule;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utils.Testutils;

import base.TestBase;

public class Signup extends TestBase{
	String Random_Name = Testutils.generateRandomName();
	
	@FindBy(xpath = "//span[normalize-space()='Sign Up']")
	WebElement Signup;
	
	@FindBy(xpath = "//img[@alt='Tulip Logo']")
	WebElement Tulipimg;
	
	@FindBy(xpath = "//a[normalize-space()='Back to Home']")
	WebElement Backtohome;
	
	@FindBy(xpath = "//input[@id='firstName']")
	WebElement Firstname;
	
	@FindBy(xpath = "//input[@id='lastName']")
	WebElement Lastname;
	
	@FindBy(xpath = "//input[@id='email']")
	WebElement Email;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement Passward;
	
	@FindBy(xpath = "//input[@id='confirm-password']")
	WebElement Confirmpass;
	
	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement Checkbox;
	
	@FindBy(xpath = "//button[normalize-space()='Register']")
	WebElement Register;
	
	@FindBy(xpath = "//div[@role='status']")
	WebElement Successmessage;
	
	@FindBy(xpath = "//input[@id='login']")
	WebElement Emailinput;
	
	@FindBy(xpath = "//i[@class='material-icons-outlined f36']")
	WebElement Gotobutton;
	
	@FindBy(xpath = "//iframe[@id='ifmail']")
	WebElement inmailFrame;
	
	@FindBy(xpath = "(//button[@class='lm'])[1]")
	WebElement Firstmail;
	
	@FindBy(xpath = "//a[text()='Verify email']")
	WebElement Verifyemail;
	
	@FindBy(xpath = "//input[@id='email']")
	WebElement Tulipid;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement Tulippass;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement Tuliplogin;
	
	
	
	public Signup() {
		PageFactory.initElements(driver, this);
	}
	
	public void signuppage_verify() throws InterruptedException {
		Thread.sleep(1000);
		Signup.click();Thread.sleep(1000);
		Backtohome.click();Thread.sleep(1000);
		Signup.click();Thread.sleep(1000);
		Assert.assertTrue(Tulipimg.isDisplayed());
		System.out.println("Signup Page is Opened");
	}
	
	public void signupfields_verify() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertTrue(!Register.isEnabled());
		Firstname.sendKeys(Random_Name);Thread.sleep(1000);
		Lastname.sendKeys(Random_Name+"xyz");
		Email.sendKeys(Random_Name+"@yopmail.com");
		Passward.sendKeys(Random_Name+"@123");
		Confirmpass.sendKeys(Random_Name+"@123");
		Checkbox.click();
		Register.click();Thread.sleep(2000);
		Assert.assertEquals(Successmessage.getText(), "Success! Record saved.");
		System.out.println("Email Verification sent Successfully.");
		
	}
	
	public void Email_verification() throws InterruptedException {
		
		Thread.sleep(2000);
		driver.get("https://yopmail.com/en");Thread.sleep(1000);
		Emailinput.sendKeys(Random_Name);Thread.sleep(1000);
		Gotobutton.click();Thread.sleep(2000);
		Testutils.switchToFrameByElement(driver, inmailFrame);Thread.sleep(1000);
		//Firstmail.click();Thread.sleep(1000);
		Verifyemail.click();Thread.sleep(1000);
		System.out.println("New Email Verification Successfully.");
	}
	
	public void Login_verify() throws InterruptedException {
		Testutils.Window_handler();
		Thread.sleep(200);
		Tulipid.sendKeys(Random_Name+"@yopmail.com");Thread.sleep(500);
		Tulippass.sendKeys(Random_Name+"@123");Thread.sleep(500);
		Tuliplogin.click();Thread.sleep(500);
		System.out.println("New Login Verification Successfully.");
	}
	
}
