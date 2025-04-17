package ProfileModuleTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ProfilePages.Personal_Information;
import base.TestBase;
import utils.Testutils;

public class Personal_Information_Test extends TestBase {

	Personal_Information PI;

	public Personal_Information_Test() {
		super();
	}

	@BeforeClass
	public void setup() {
		super.initialization();
		PI = new Personal_Information();
		Testutils.logindetails("chand.patel@tntra.io", "Brijesh@05042003");
	}

	@Test(priority = 1)
	public void navigatetoprofile() throws InterruptedException {
		PI.NavigatetoProfile();
	}

	@Test(priority = 2)
	public void verifydisabledfields() throws InterruptedException {
		PI.NavigatetoPersonalInformation();
		PI.verifyDisabledFields();
	}

	@Test(priority = 3)
	public void verifyrequiredfields() throws InterruptedException {
		PI.verifyRequiredFields();
	}

	@Test(priority = 4)
	public void verifyValidations() throws InterruptedException {
		PI.verifyValidations();
	}

	@Test(priority = 5)
	public void verifyPersonalInformation() throws InterruptedException {
		PI.fillPersonalInformation();
	}

	@Test(priority = 6)
	public void verifyUpdatedDetails() throws InterruptedException {
		PI.NavigatetoPersonalInformation();
		PI.updateDetails();
	}

}
