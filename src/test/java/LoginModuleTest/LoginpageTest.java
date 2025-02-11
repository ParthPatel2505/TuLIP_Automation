package LoginModuleTest;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;
import utils.Testutils;
import LoginModule.Loginpage;


public class LoginpageTest extends TestBase{

	Loginpage loginpage;
	
	public LoginpageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeClass
	public void setup() {
		super.initialization();
		loginpage = new Loginpage();
	}
	
	@Test(priority = 1)
	public void Verify_login_functionality() throws InterruptedException 
	{
		Testutils.logindetails("maxwell@yopmail.com", "Test@123");
	}
	
	
	
	
}