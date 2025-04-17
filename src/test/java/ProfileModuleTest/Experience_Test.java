package ProfileModuleTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ProfilePages.Experience;
import ProfilePages.Personal_Information;
import base.TestBase;
import utils.Testutils;

public class Experience_Test extends TestBase {
	Experience EP;
	Personal_Information PI;

	public Experience_Test() {
		super();
	}

	@BeforeClass
	public void setup() {
		super.initialization();
		EP = new Experience();
		PI = new Personal_Information();
		Testutils.logindetails("Chand.patel@tntra.io", "Brijesh@05042003");
	}

	@Test(priority = 1)
	void verifyNavigateToExperience() throws InterruptedException {
		PI.NavigatetoProfile();
		Thread.sleep(2000);
		EP.navigateToExperience();
	}

	@Test(priority = 2)
	void verifycloseAndCancel() throws InterruptedException {
		EP.closeAndCancel();
	}

	@Test(priority = 3)
	void verifyDisabledFields() throws InterruptedException {
		EP.disabledFields();
	}

	@Test(priority = 4)
	void verifyRequiredFields() throws InterruptedException {
		EP.requiredFields();
	}

	@Test(priority = 5)
	void verifyFilledTheDetails() throws InterruptedException {
		EP.fillTheDetails();
	}

	@Test(priority = 6)
	void verifyEditDetails() throws InterruptedException {
		EP.editDetails();
	}

	@Test(priority = 7)
	void verifyDeleteRecord() throws InterruptedException {
		EP.deleteRecord();
	}
}
