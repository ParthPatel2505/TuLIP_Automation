package MentorPanelTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import MentorPanel.candidate_Management;
import ProfilePages.Personal_Information;
import base.TestBase;
import utils.Testutils;

public class candidate_Management_Test extends TestBase {

	candidate_Management CM;
	Personal_Information PI;

	public candidate_Management_Test() {
		super();
	}

	@BeforeClass
	public void setup() {
		super.initialization();
		CM = new candidate_Management();
		PI = new Personal_Information();
		Testutils.logindetails("chand.patel@tntra.io", "Brijesh@05042003");
	}

	@Test(priority = 1)
	public void navigatetoMentorPanel() throws InterruptedException {
		CM.navigatetoMentorPanel();
		Thread.sleep(2000);
	}

	@Test(priority = 2)
	public void navigatetoCandidateManagement() throws InterruptedException {
		Thread.sleep(1000);
		CM.navigateToCandidateManagement();
	}

	@Test(priority = 3)
	public void verifyTitle() throws InterruptedException {
		Thread.sleep(1000);
		CM.verifyTitle();
	}

	@Test(priority = 4)
	public void verifyPagination() throws InterruptedException {
		Thread.sleep(1000);
		CM.verifyPagination();
	}

	@Test(priority = 5)
	public void closeAndCancel() throws InterruptedException {
		Thread.sleep(1000);
		CM.closeAndCancel();
	}

	@Test(priority = 6)
	public void verifyDisabledFields() throws InterruptedException {
		Thread.sleep(1000);
		CM.verifyDisabledFields();
	}

	@Test(priority = 7)
	public void verifyRequiredFields() throws InterruptedException {
		Thread.sleep(1000);
		CM.verifyRequiredFields();
	}

	@Test(priority = 8)
	public void verifyTotalRecords() throws InterruptedException {
		Thread.sleep(1000);
		CM.verifyTotalRecords();
	}

	@Test(priority = 9)
	public void verifyAllTheRcords() throws InterruptedException {
		Thread.sleep(1000);
		CM.viewAllTheRcords();
	}

	@Test(priority = 10)
	public void verifySearchFunctionality() throws InterruptedException {
		Thread.sleep(1000);
		CM.verifySearchFunctionality();
	}

	@Test(priority = 11)
	public void verifySendInvite() throws InterruptedException {
		Thread.sleep(1000);
		CM.sendInvite();
	}

	@Test(priority = 12)
	public void emailVerification() throws InterruptedException {
		Thread.sleep(1000);
		CM.emailVerification();
	}

	@Test(priority = 13)
	public void verifyFillSignupForm() throws InterruptedException {
		Thread.sleep(1000);
		CM.fillSignupForm();
	}

	@Test(priority = 14)
	public void emailVerify() throws InterruptedException {
		Thread.sleep(1000);
		CM.emailVerify();
	}

	@Test(priority = 15)
	public void verifyLogin() throws InterruptedException {
		Thread.sleep(1000);
		CM.login();
	}
}