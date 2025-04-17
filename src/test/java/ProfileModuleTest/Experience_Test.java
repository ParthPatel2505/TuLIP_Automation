package ProfileModuleTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ProfilePages.Experience;
import ProfilePages.Personal_Information;
import base.TestBase;
import utils.Testutils;

public class Experience_Test extends TestBase {
	Experience ET;
	Personal_Information PI;

	public Experience_Test() {
		super();
	}

	@BeforeClass
	public void setup() {
		super.initialization();
		ET = new Experience();
		PI = new Personal_Information();
		Testutils.logindetails("Chand.patel@tntra.io", "Brijesh@05042003");
	}

	@Test(priority = 1)
	void verifyNavigateToExperience() throws InterruptedException {
		PI.NavigatetoProfile();
		Thread.sleep(2000);
		ET.navigateToExperience();
	}

	@Test(priority = 2)
	void verifycloseAndCancel() throws InterruptedException {
		ET.closeAndCancel();
	}

	@Test(priority = 3)
	void verifyDisabledFields() throws InterruptedException {
		ET.disabledFields();
	}

	@Test(priority = 4)
	void verifyRequiredFields() throws InterruptedException {
		ET.requiredFields();
	}

	@Test(priority = 5)
	void verifyFillTheDetails() throws InterruptedException {
		ET.fillTheDetails();
	}

	@Test(priority = 6)
	void verifyEditDetails() throws InterruptedException {
		ET.editDetails();
	}

	@Test(priority = 7)
	void verifyDeleteRecord() throws InterruptedException {
		ET.deleteRecord();
	}
}
