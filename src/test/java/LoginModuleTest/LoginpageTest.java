package LoginModuleTest;

import java.io.IOException;

import org.testng.annotations.Test;

import LoginModule.Loginpage;


public class LoginpageTest extends Loginpage
{

	Loginpage loginpage;
	
	public LoginpageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	//@BeforeClass
	public void setup() {
		super.initialization();
		loginpage = new Loginpage();
	}
	
	@Test
	public void Verify_login_functionality() throws Exception 
	{
		logindetails(prop.getProperty("username"), prop.getProperty("passward"));
		//loginpage.Login_verify();
	}
	
	
	
	
}