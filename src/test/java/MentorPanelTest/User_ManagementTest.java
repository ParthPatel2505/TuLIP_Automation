package MentorPanelTest;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import MentorPanel.User_Management;
import base.TestBase;
import utils.Testutils;

public class User_ManagementTest extends TestBase{
	User_Management user;

	public User_ManagementTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeClass
	public void setup() {
		super.initialization();
		user = new User_Management();
		Testutils.ValidateUserLogin();
	}

	@Test(priority = 1)
	public void Verify_navigatetouser_functionality() throws InterruptedException {
		user.navigate_to_usermanagement();;
	}
	
	@Test(priority = 2)
	public void Verify_pagination_functionality() throws InterruptedException {
		user.pagination();
	}
	
	@Test(priority = 3)
	public void Verify_edit_functionality() throws InterruptedException {
		user.update_record();
	}
	
	@Test(priority = 4)
	public void Verify_careerpath_functionality() throws InterruptedException {
		user.career_path();
	}
	
	@Test(priority = 5)
	public void Verify_toggle_functionality() throws InterruptedException {
		user.toggleactions();
	}
	
	@Test(priority = 6)
	public void Verify_search_functionality() throws InterruptedException {
		user.searchbar();
	}
}
