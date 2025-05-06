package MentorPanelTest;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import MentorPanel.candidate_Management;
import MentorPanel.candidate_Management3;
import ProfilePages.Education;
import ProfilePages.Experience;
import ProfilePages.Personal_Information;
import ProfilePages.Skill;
import base.TestBase;
import utils.Testutils;

public class candidate_Management3_Test extends TestBase {

	candidate_Management3 CM3;
	candidate_Management CM;
	Personal_Information PI;
	Education ET;
	Experience EP;
	Skill Sk;

	public candidate_Management3_Test() {
		super.initialization();
	}

	@BeforeClass
	public void setup() {

		CM3 = new candidate_Management3();
		CM = new candidate_Management();
		PI = new Personal_Information();
		ET = new Education();
		EP = new Experience();
		Sk = new Skill();
		Testutils.logindetails("Chand.Patel@tntra.io", "Brijesh@05042003");
	}

	@Test(priority = 1)
	public void navigatetoMentorPanel() throws InterruptedException {
			CM.navigatetoMentorPanel();	
	}

	@Test(priority = 2)
	public void navigatetoCandidateManagement() throws InterruptedException {
		CM.navigateToCandidateManagement();
	}

	@Test(priority = 3)
	public void verifySendInvite() throws InterruptedException {
		CM.sendInvite();
	}

	@Test(priority = 4)
	public void emailVerification() throws InterruptedException {
		CM.emailVerification();
	}

	@Test(priority = 5)
	public void verifyFillSignupForm() throws InterruptedException {
		CM.fillSignupForm();
	}

	@Test(priority = 6)
	public void emailVerify() throws InterruptedException {
		CM.emailVerify();
	}

	@Test(priority = 7)
	public void verifyLogin() throws InterruptedException {
		CM.login();
	}

	@Test(priority = 8)
	public void navigatetoprofile() throws InterruptedException {
		PI.NavigatetoProfile();
	}

	@Test(priority = 9)
	public void verifyPersonalInformation() throws InterruptedException {
		PI.fillPersonalInformation();
	}

	@Test(priority = 10)
	public void navigatetoEducation() throws InterruptedException {
		ET.navigateToEducation();
	}

	@Test(priority = 11)
	public void verifyFillTheDetails() throws Exception {
		ET.fillTheDetails();
	}

	@Test(priority = 12)
	void verifyNavigateToExperience() throws InterruptedException {
		EP.navigateToExperience();
	}

	@Test(priority = 13)
	void verifyFilledTheDetails() throws InterruptedException {
		EP.fillTheDetails();
	}

	@Test(priority = 14)
	public void navigatetoskill() throws InterruptedException {
		Sk.navigateToSkills();
	}

	@Test(priority = 15)
	public void fillSkillDetails() throws InterruptedException {
		Sk.fillTheSkills();
	}

	@Test(priority = 16)
	public void verifyLogoutToLogin() throws InterruptedException {
		CM3.logoutToLogin();
	}

	@Test(priority = 17)
	public void navigatetoMentorPanelSecond() throws InterruptedException {
		CM.navigatetoMentorPanel();
	}

	@Test(priority = 18)
	public void navigatetoCandidateManagementSecond() throws InterruptedException {
		CM.navigateToCandidateManagement();
	}

	@Test(priority = 19)
	public void verifyRedirection() throws InterruptedException {
		CM3.redirectToViewPage();
	}

	@Test(priority = 20)
	public void verifyPersonalDetails() throws InterruptedException {
		CM3.personalDetails();
	}

	@Test(priority = 21)
	public void verifyEducationBackground() throws InterruptedException {
		CM3.educationBackground();
	}

	@Test(priority = 22)
	public void verifyWorkExperience() throws InterruptedException, IOException {
		CM3.workExperience();
	}

	@Test(priority = 23)
	public void verifySkillAndInterest() throws InterruptedException {
		CM3.skillAndInterest();
	}
}
