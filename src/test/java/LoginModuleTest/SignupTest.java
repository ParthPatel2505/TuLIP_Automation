package LoginModuleTest;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;
import LoginModule.Signup;


public class SignupTest extends TestBase{

	Signup signup;
	
	public SignupTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeClass
	public void setup() {
		super.initialization();
		signup = new Signup();
	}
	
	@Test(priority = 1)
	public void Verify_signuppage_functionality() throws InterruptedException 
	{
		signup.signuppage_verify();
	}	
	
	@Test(priority = 2)
	public void Verify_signupfields_functionality() throws InterruptedException 
	{
		signup.signupfields_verify();;
	}	
	
	@Test(priority = 3)
	public void Verify_emailverification_functionality() throws InterruptedException 
	{
		signup.Email_verification();
	}	
	
	@Test(priority = 4)
	public void Verify_newemaillogin_functionality() throws InterruptedException 
	{
		signup.Login_verify();
	}
}