package AutomationAccelerationTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import AutomationAcceleration.EngineeringDetails;
import LoginModule.Loginpage;
import MentorPanel.Career_Management;
import utils.Testutils;

public class EngineeringDetailsTest extends EngineeringDetails
{
	Loginpage lp = new Loginpage();
	
	@BeforeClass
	public void setup() {
		super.initialization();
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