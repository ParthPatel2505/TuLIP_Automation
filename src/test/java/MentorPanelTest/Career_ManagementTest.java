package MentorPanelTest;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import MentorPanel.Career_Management;
import base.TestBase;
import utils.Testutils;

public class Career_ManagementTest extends TestBase {

	Career_Management career;

	public Career_ManagementTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeClass
	public void setup() {
		super.initialization();
		career = new Career_Management();
		Testutils.ValidateUserLogin();
	}

	@Test(priority = 1)
	public void Verify_navigatetocareer_functionality() throws InterruptedException {
		career.navigate_to_career();
	}

	@Test(priority = 2)
	public void Verify_buttons_mandatoryfields() throws InterruptedException {
		career.buttons_mandatoryfields();
	}

	@Test(priority = 3)
	public void Verify_add_career_functionality() throws Exception {
		career.add_details();
	}

	@Test(priority = 4)
	public void Verify_viewpage_functionality() throws InterruptedException {
		career.viewpage();
	}

	@Test(priority = 5)
	public void Verify_active_inactive_functionality() throws InterruptedException {
		career.toggleactions();
	}

	@Test(priority = 6)
	public void Verify_pagination_functionality() throws InterruptedException {
		career.pagination();
	}

	@Test(priority = 7)
	public void Verify_search_functionality() throws InterruptedException {
		career.searchbar();
	}

	@Test(priority = 8)
	public void Verify_addandedit_draft_functionality() throws InterruptedException {
		career.add_edit_draft();
	}

	@Test(priority = 9)
	public void Verify_addtemplate_functionality() throws InterruptedException {
		career.add_template();
	}

	@Test(priority = 10)
	public void Verify_edit_template_functionality() throws InterruptedException {
		career.edit_template();
	}

}
