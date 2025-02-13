package LoginModuleTest;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import LoginModule.Forgotpassward;
import base.TestBase;

public class ForgotpasswardTest extends TestBase{

	Forgotpassward forgotpassward;
	
	public ForgotpasswardTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeClass
	public void setup() {
		super.initialization();
		forgotpassward = new Forgotpassward();
	}
	
	@Test(priority = 1)
	public void Verify_clickon_forgotlink_functionality() throws InterruptedException 
	{
		forgotpassward.clickon_forgotlink();
	}
/*	
	@Test(priority = 2)
	public void Verify_clickon_resetpassward_functionality() throws InterruptedException
	{
		forgotpassward.clickon_resetpassward();
	}
	
	@Test(priority = 3)
	public void Verify_change_passward_functionality() throws InterruptedException
	{
		forgotpassward.change_passward();
	}
*/
}
