package ProfileModuleTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ProfilePages.Personal_Information;
import ProfilePages.commAndPre;
import ProfilePages.goalAndAsp;
import base.TestBase;
import utils.Testutils;

	public class goalAndAsp_Test extends TestBase {

		goalAndAsp GP;
		Personal_Information PI;

		public goalAndAsp_Test() {
			super.initialization();
		}

		@BeforeTest
		public void setup() {
			GP = new goalAndAsp();
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
			GP.navigateToGoalAndAspiration();
		}

		@Test(priority = 3)
		public void verifyCloseAndCancel() throws InterruptedException {
			GP.closeAndCancel();
		}

		@Test(priority = 4 )
		public void verifyDisabledFields() throws InterruptedException {
			GP.disabledFields();
		}

		@Test(priority = 5)
		public void verifyRequiredFields() {
			GP.requiredFields();
		}

		@Test(priority = 6)
		public void verifyFillTheDetails() throws InterruptedException {
			GP.fillTheDetails();
		}

		@Test(priority = 7)
		public void verifyEditdetails() throws InterruptedException {
			GP.editTheDetails();
		}

		//@Test(priority = 8)
		public void verifyDeletedDetails() throws InterruptedException {
			GP.deleteTheDetails();
		}
	}

