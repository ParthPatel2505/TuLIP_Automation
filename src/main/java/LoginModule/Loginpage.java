package LoginModule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utils.Testutils;

public class Loginpage extends Testutils<Object>
{
	
	static Testutils<Object> testutil = new Testutils<Object>();

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
	
	
/*	public void Login_verify() throws Exception {
		Myaccount.click(); 
		Login.click(); 
		Email.sendKeys(prop.getProperty("username")); 
		Passward.sendKeys(prop.getProperty("passward")); 
		Button.click(); 
		
		testutil.waitForElement(3);
		
		Assert.assertEquals(Element.getText(), "My Account");
		//Assert.assertTrue(testutil.checkRedirection("Dashboard"), "User is redirected on wrong URL after logged in.");
		//System.out.println("Login Successfully");
		
	}*/
	
	public static void logindetails(String username, String passward) throws Exception 
	{
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(passward);
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		testutil.waitForElement(5);
		Assert.assertTrue(testutil.checkRedirection("dashboard"), "User is redirected on wrong URL after logged in.");
		System.out.println("Login Successfully");
		
	}

}
