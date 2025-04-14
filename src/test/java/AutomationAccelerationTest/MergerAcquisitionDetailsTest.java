package AutomationAccelerationTest;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import AutomationAcceleration.MergerAcquisitionDetails;
import LoginModule.Loginpage;
import utils.Testutils;

public class MergerAcquisitionDetailsTest extends MergerAcquisitionDetails
{
	MergerAcquisitionDetails openPlusMenuFromHeader = new MergerAcquisitionDetails();
	Loginpage lp = new Loginpage();
	
	public MergerAcquisitionDetailsTest() throws IOException {
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
		openPlusMenuFromHeader.openMergerAcqForm();
	}
	
	@Test(priority=2)
	public void validationOfForm() throws Exception
	{
		validationCheckOnField();
	}
	
	@Test(priority=3)
	public void uploadFileinForm() throws Exception
	{
		uploadFileInForm();
	}
	
	@Test(priority=4)
	public void fillForm() throws Exception
	{
		fillTheForm();
	}

}
