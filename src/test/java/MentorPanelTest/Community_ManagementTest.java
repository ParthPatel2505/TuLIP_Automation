package MentorPanelTest;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import MentorPanel.Community_Management;
import base.TestBase;
import utils.Testutils;

public class Community_ManagementTest extends TestBase{

	Community_Management community;

	public Community_ManagementTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeClass
	public void setup() {
		super.initialization();
		community = new Community_Management();
		Testutils.ValidateUserLogin();
	}

	@Test(priority = 1)
	public void Verify_navigatetousecase_functionality() throws InterruptedException {
		community.navigate_to_community();
	}

	@Test(priority = 2)
	public void Verify_buttons_mandatoryfields() throws InterruptedException {
		community.buttons_mandatoryfields();
	}

	@Test(priority = 3)
	public void verify_addcommunity_functionality() throws InterruptedException {
		community.adddetails();

	}

	@Test(priority = 4)
	public void verify_view_functionality() throws InterruptedException {
		community.viewpage();

	}

	@Test(priority = 5)
	public void verify_toggle_functionality() throws InterruptedException {
		community.toggleactions();

	}

	@Test(priority = 6)
	public void verify_pagination_functionality() throws InterruptedException {
		community.pagination();
	}

	@Test(priority = 7)
	public void verify_edit_functionality() throws InterruptedException {
		community.editpage();

	}

	@Test(priority = 8)
	public void verify_search_functionality() throws InterruptedException {
		community.searchbar();

	}
}
