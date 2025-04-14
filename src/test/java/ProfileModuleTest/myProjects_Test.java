package ProfileModuleTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ProfilePages.Personal_Information;
import ProfilePages.myProjects;
import base.TestBase;
import utils.Testutils;

public class myProjects_Test extends TestBase {

	myProjects MP;
	Personal_Information PI;

	public myProjects_Test() {
		super.initialization();
	}

	@BeforeClass
	public void setup() {
		MP = new myProjects();
		PI = new Personal_Information();
		Testutils.logindetails("Chand.Patel@Tntra.io", "Brijesh@05042003");
	}

	@Test(priority = 1)
	public void navigatetoProfile() throws InterruptedException {
		PI.NavigatetoProfile();
		Thread.sleep(2000);

	}

	@Test(priority = 2)
	public void navigatetoMyProjects() throws InterruptedException {

		Thread.sleep(2000);
		MP.navigateToMyProjects();
	}

	@Test(priority = 3)
	public void verifyCloseAndCancel() throws InterruptedException {
		MP.closeAndCancel();
	}

	@Test(priority = 4)
	public void verifyValidations() throws InterruptedException {
		MP.verifyValidations();
	}

	@Test(priority = 5)
	public void verifyDisabledFields() throws InterruptedException {
		MP.disabledFields();
	}

	@Test(priority = 6)
	public void verifyRequiredFields() throws InterruptedException {
		MP.requiredFields();
	}

	@Test(priority = 7)
	public void verifyFillTheDetails() throws InterruptedException {
		MP.fillTheDetails();
	}

	@Test(priority = 8)
	public void verifyeditDetails() throws InterruptedException {
		MP.editDetails();
	}

	@Test(priority = 9)
	public void verifyDeleteRecord() throws InterruptedException {
		MP.deleteRecord();
	}

}
