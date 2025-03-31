package AutomationAccelerationTest;


import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import AutomationAcceleration.InnovationDetails;
import LoginModule.Loginpage;
import utils.Testutils;

public class InnovationDetailsTest extends InnovationDetails
{
	InnovationDetails openPlusMenuFromHeader = new InnovationDetails();
	Loginpage lp = new Loginpage();
	
	public InnovationDetailsTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeClass
	public void setup() {
		super.initialization();
		Testutils.ValidateUserLogin();
	}
	
	@Test(priority=1)
	public void openInnovationForm() throws Exception
	{
		openPlusMenuFromHeader.openInnovationForm();
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
