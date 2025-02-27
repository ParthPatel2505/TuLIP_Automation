package MentorPanelTest;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import MentorPanel.Category_Management;
import base.TestBase;
import utils.Testutils;

public class Category_ManagementTest extends TestBase {

	Category_Management category;

	public Category_ManagementTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeClass
	public void setup() throws IOException {
		super.initialization();
		category = new Category_Management();
		Testutils.ValidateUserLogin();
	}

	@Test(priority = 1)
	public void Verify_navigatetodepartment_functionality() throws InterruptedException {
		category.navigate_to_category();
	}

	@Test(priority = 2)
	public void Verify_add_category_functionality() throws Exception {
		category.add_category();
	}

	@Test(priority = 3)
	public void Verify_delete_category_functionality() throws InterruptedException {
		category.delete_category();
	}
}
