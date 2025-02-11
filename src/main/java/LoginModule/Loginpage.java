package LoginModule;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.TestBase;

public class Loginpage extends TestBase{

	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement Myaccount;
	
	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")
	WebElement Login;
	
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement Email;
	
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement Passward;
	
	@FindBy(xpath = "//input[@value='Login']")
	WebElement Button;
	
	@FindBy(xpath = "//h2[normalize-space()='My Account']")
	WebElement Element;
	
	public Loginpage() {
		PageFactory.initElements(driver, this);
	}
	
	public void Login_verify() throws InterruptedException {
		Myaccount.click(); Thread.sleep(500);
		Login.click(); Thread.sleep(500);
		Email.sendKeys(prop.getProperty("Emailadress")); Thread.sleep(500);
		Passward.sendKeys(prop.getProperty("Pass")); Thread.sleep(500);
		Button.click(); Thread.sleep(500);
		
		Assert.assertEquals(Element.getText(), "My Account");
		System.out.println("Login Successfully");
		
	}

}
