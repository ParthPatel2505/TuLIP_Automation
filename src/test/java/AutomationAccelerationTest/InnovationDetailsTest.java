package AutomationAccelerationTest;


import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import AutomationAcceleration.InnovationDetails;
import LoginModule.Loginpage;

public class InnovationDetailsTest extends InnovationDetails
{
	InnovationDetails openPlusMenuFromHeader = new InnovationDetails();
	Loginpage lp = new Loginpage();
	
	
	
	//@BeforeClass
	public void takeLogin() throws Exception
	{
		Loginpage.logindetails(prop.getProperty("username"), prop.getProperty("passward"));
	}
	
	@Test(priority=1)
	public void openInnovationForm() throws Exception
	{
		openPlusMenuFromHeader.openInnovationForm();
	}
	
	//@Test(priority=2)
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
