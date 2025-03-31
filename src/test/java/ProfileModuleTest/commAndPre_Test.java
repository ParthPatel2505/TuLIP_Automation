package ProfileModuleTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ProfilePages.Personal_Information;
import ProfilePages.commAndPre;
import base.TestBase;
import utils.Testutils;

public class commAndPre_Test extends TestBase {

	commAndPre CP;
	Personal_Information PI;

	public commAndPre_Test() {
		super.initialization();
	}

	@BeforeTest
	public void setup() {
		CP = new commAndPre();
		PI = new Personal_Information();
		Testutils.logindetails("Chand.Patel@Tntra.io", "Brijesh@05042003");
	}

	@Test(priority = 1)
	public void navigatetoProfile() throws InterruptedException {
		PI.NavigatetoProfile();
		Thread.sleep(2000);

	}

	@Test(priority = 2)
	public void navigatetoCommAndPre() throws InterruptedException {

		Thread.sleep(2000);
		CP.navigateToCommunicationAndPreferences();
	}

	@Test(priority = 3)
	public void verifyCloseAndCancel() throws InterruptedException {
		CP.closeAndCancel();
	}

	@Test(priority = 4)
	public void verifyValidations() throws InterruptedException {
		CP.verifyValidations();
	}

	@Test(priority = 5)
	public void verifyDisabledFields() throws InterruptedException {
		CP.disabledFields();
	}

	@Test(priority = 6)
	public void verifyRequiredFields() {
		CP.requiredFields();
	}

	@Test(priority = 7)
	public void verifyFillTheDetails() throws InterruptedException {
		CP.fillTheDetails();
	}

	@Test(priority = 8)
	public void verifyEditdetails() throws InterruptedException {
		CP.editTheDetails();
	}

	@Test(priority = 9)
	public void verifyDeletedDetails() throws InterruptedException {
		CP.deleteTheDetails();
	}
}
