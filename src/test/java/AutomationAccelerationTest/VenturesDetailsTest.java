package AutomationAccelerationTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import AutomationAcceleration.VenturesDetails;
import LoginModule.Loginpage;
import utils.Testutils;

public class VenturesDetailsTest extends VenturesDetails
{
	Loginpage lp = new Loginpage();
	
	@BeforeClass
	public void setup() {
		super.initialization();
		Testutils.ValidateUserLogin();
	}
	
	
	//@BeforeClass
	public void takeLogin() throws Exception
	{
		Testutils.ValidateUserLogin();
	}
	
	@Test(priority=1)
	public void openEngForm() throws Exception
	{
		openEngFormFromPlus();
	}
	
	@Test(priority=2)
	public void validationOfForm() throws Exception
	{
		validationCheck();
	}
	
	@Test(priority=3)
	public void uploadFileinForm() throws Exception
	{
		uploadFile();
	}
	
	@Test(priority=4)
	public void fillForm() throws Exception
	{
		fillAllFieldsValue();
	}

}
