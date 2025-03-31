package MentorPanelTest;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import MentorPanel.Challenge_Management;
import base.TestBase;
import utils.Testutils;

public class Challenge_ManagementTest extends TestBase {
	Challenge_Management challenge;

	public Challenge_ManagementTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeClass
	public void setup() {
		super.initialization();
		challenge = new Challenge_Management();
		Testutils.ValidateUserLogin();
	}

	@Test(priority = 1)
	public void Verify_navigatetochallange_functionality() throws InterruptedException {
		challenge.navigate_to_challengemanagement();
		;
	}

	@Test(priority = 2)
	public void Verify_pagination_functionality() throws InterruptedException {
		challenge.pagination();
	}

	@Test(priority = 3)
	public void Verify_mandatoryfields_functionality() throws InterruptedException {
		challenge.buttons_mandatoryfields();
	}

	@Test(priority = 4)
	public void Verify_primarysection_functionality() throws InterruptedException {
		challenge.primary_details();
	}

	@Test(priority = 5)
	public void Verify_milestone_functionality() throws Exception {
		challenge.milestone_details();
	}

	@Test(priority = 2)
	public void Verify_edit_challenge_functionality() throws Exception {
		challenge.edit_challenge();
	}

	@Test(priority = 7)
	public void Verify_view_functionality() throws Exception {
		challenge.viewpage();
	}

	@Test(priority = 8)
	public void Verify_toggle_functionality() throws Exception {
		challenge.toggleactions();
	}

	@Test(priority = 9)
	public void Verify_search_functionality() throws Exception {
		challenge.searchbar();
	}

	@Test(priority = 10)
	public void Verify_filter_functionality() throws Exception {
		challenge.filter();
	}

	@Test(priority = 11)
	public void Verify_delete_functionality() throws Exception {
		challenge.delete();
	}

	@Test(priority = 12)
	public void Verify_accept_challenge_functionality() throws Exception {
		challenge.accept_challenge();
	}

	@Test(priority = 13)
	public void Verify_submission_functionality() throws Exception {
		Testutils.ValidateUserLogin();
		challenge.navigate_to_challengemanagement();
		challenge.submission_marks();
	}

}
