package LoginModule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.TestBase;

public class Loginpage extends TestBase{

	@FindBy(xpath = "//input[@id='form.login.email']")
	WebElement Tulipid;
	
	@FindBy(xpath = "//input[@id='form.login.password']")
	WebElement Tulippass;
	
	@FindBy(xpath = "//span[normalize-space()='Login']")
	WebElement Tuliplogin;
	
	@FindBy(xpath = "//div[@role='status']")
	WebElement Successmessage;
	
	public Loginpage() {
		PageFactory.initElements(driver, this);
	}
	
	public void Login_verify() throws InterruptedException {
		driver.findElement(By.xpath("//span[normalize-space()='Login']")).click();
		Tulipid.sendKeys(prop.getProperty("username"));
		Tulippass.sendKeys(prop.getProperty("passward"));
		Tuliplogin.click();Thread.sleep(2000);
		//Assert.assertEquals(Successmessage.getText(), "Success! You have Logged-In.");
		System.out.println("Login Successfully");
		
	}

}
