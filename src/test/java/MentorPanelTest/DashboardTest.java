package MentorPanelTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import MentorPanel.Dashboard;
import base.TestBase;
import utils.Testutils;

public class DashboardTest extends TestBase{

	Dashboard db;
	public DashboardTest() {
		super();
	}
	
	@BeforeClass
	public void setup() {
		super.initialization();
		db = new Dashboard();
		Testutils.ValidateUserLogin();
	}
	
	@Test(priority = 1)
	public void Verify_navigatetodashboard_functionality() throws InterruptedException {
		db.navigate_to_dashboard();
	}
	
	@Test(priority = 2)
	public void Verify_ticketcountdropdown_functionality() throws InterruptedException {
		db.ticketcount_dropdowns();
	}
	
	@Test(priority = 3)
	public void Verify_statuscountdropdown_functionality() throws InterruptedException {
		db.statuscount_dropdowns();
	}
	
	@Test(priority = 4)
	public void Verify_meneteedropdown_functionality() throws InterruptedException {
		db.manetee_dropdowns();
	}
	
	@Test(priority = 5)
	public void Verify_overallticketdropdown_functionality() throws InterruptedException {
		db.overallticket_dropdowns();
	}
	
	@Test(priority = 6)
	public void Verify_stageoverviewdropdown_functionality() throws InterruptedException {
		db.stageoverview_dropdowns();
	}
	
	@Test(priority = 7)
	public void Verify_coursesdropdown_functionality() throws InterruptedException {
		db.courses_dropdowns();
	}
}
