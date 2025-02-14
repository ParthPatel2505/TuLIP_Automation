package MentorPanelTest;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import MentorPanel.Usecase_Management;
import base.TestBase;
import utils.Testutils;

public class Usecase_ManagementTest extends TestBase {

	Usecase_Management usecase;

	public Usecase_ManagementTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeClass
	public void setup() {
		super.initialization();
		usecase = new Usecase_Management();
		Testutils.ValidateUserLogin();
	}

	@Test(priority = 1)
	public void Verify_navigatetousecase_functionality() throws InterruptedException {
		usecase.navigate_to_usecasemanagement();
	}

	@Test(priority = 2)
	public void Verify_buttons_mandatoryfields() throws InterruptedException {
		usecase.buttons_mandatoryfields();
	}

	@Test(priority = 3)
	public void verify_addusecase_functionality() throws InterruptedException {
		usecase.adddetails();

	}

	@Test(priority = 4)
	public void verify_view_functionality() throws InterruptedException {
		usecase.viewpage();

	}

	@Test(priority = 5)
	public void verify_toggle_functionality() throws InterruptedException {
		usecase.toggleactions();

	}

	@Test(priority = 6)
	public void verify_pagination_functionality() throws InterruptedException {
		usecase.pagination();
	}

	@Test(priority = 7)
	public void verify_edit_functionality() throws InterruptedException {
		usecase.editpage();

	}

	@Test(priority = 8)
	public void verify_search_functionality() throws InterruptedException {
		usecase.searchbar();

	}

}
