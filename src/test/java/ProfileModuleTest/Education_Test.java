package ProfileModuleTest;

import ProfilePages.Personal_Information;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ProfilePages.Education;
import base.TestBase;
import utils.Testutils;

public class Education_Test extends TestBase {
	Education ET;
	Personal_Information PI;

	public Education_Test() {
		super();
	}

	@BeforeClass
	public void setup() {
		super.initialization();
		ET = new Education();
		PI = new Personal_Information();
		Testutils.logindetails("chand.patel@tntra.io", "Brijesh@05042003");
	}

	@Test(priority = 1)
	public void navigatetoEducationthroughProfile() throws InterruptedException {
		PI.NavigatetoProfile();
		Thread.sleep(2000);
		ET.navigateToEducation();
	}

	@Test(priority = 2)
	public void verifyDisabledFields() throws InterruptedException {
		ET.disabledFields();
	}

	@Test(priority = 3)
	public void verifyrequiredFields() throws InterruptedException {
		ET.requiredFields();
	}

	@Test(priority = 4)
	public void verifyFillTheDetails() throws Exception {
		ET.fillTheDetails();
	}
	
	@Test(priority = 5)
	public void verifyEditTheDetails() throws Exception {
		ET.editDetails();
	}
}
