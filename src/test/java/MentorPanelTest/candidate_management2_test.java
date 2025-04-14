package MentorPanelTest;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import MentorPanel.candidate_management2;
import base.TestBase;
import utils.Testutils;

public class candidate_management2_test extends TestBase {

	candidate_management2 CM2;

	public candidate_management2_test() {
		super.initialization();
	}

	@BeforeTest
	public void setup() {
		CM2 = new candidate_management2();
		Testutils.logindetails("chand.patel@tntra.io", "Brijesh@05042003");
	}

	@Test(priority = 1)
	public void navigatetoMentorPanel() throws InterruptedException {
		CM2.navigatetoMentorPanel();
		Thread.sleep(2000);
	}

	@Test(priority = 2)
	public void navigatetoCandidateManagement() throws InterruptedException {
		Thread.sleep(1000);
		CM2.navigateToCandidateManagement();
	}
	@Test(priority = 3)
	public void verifyDownloadFiles() throws InterruptedException {
		Thread.sleep(1000);
		CM2.downloadFiles();
	}

	@Test(priority = 4)
	public void verifyvalidationOnDuplicateEmail() throws InterruptedException, IOException {
		Thread.sleep(1000);
		CM2.validationOnDuplicateEmail();
	}

	@Test(priority = 5)
	public void verifyValidationOnExistingEmail() throws InterruptedException, IOException {
		Thread.sleep(1000);
		CM2.validationOnExistingEmail();
	}

	@Test(priority = 6)
	public void verifyValidationonInvalidEmail() throws InterruptedException, IOException {
		Thread.sleep(1000);
		CM2.validationOnInvalidEmail();
	}

	@Test(priority = 7)
	public void verifyValidFileUploadFlow() throws InterruptedException, IOException {
		Thread.sleep(1000);
		CM2.validFileUploadFlow();
	}
	@Test(priority = 12)
	public void emailVerification() throws InterruptedException {
		Thread.sleep(1000);
		CM2.emailVerification();
	}

	@Test(priority = 13)
	public void verifyFillSignupForm() throws InterruptedException {
		Thread.sleep(1000);
		CM2.fillSignupForm();
	}

	@Test(priority = 14)
	public void emailVerify() throws InterruptedException {
		Thread.sleep(1000);
		CM2.emailVerify();
	}

	@Test(priority = 15)
	public void verifyLogin() throws InterruptedException {
		Thread.sleep(1000);
		CM2.login();
	}
}
