package CollaborationANDReviewFlowaTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import CollaborationANDReviewFlows.Engineering_Collaboration;
import CollaborationANDReviewFlows.Innovation_Collaboration;
import base.TestBase;
import utils.Testutils;

public class Engineering_CLB_FlowTest extends TestBase{
	
Innovation_Collaboration  IC;
Engineering_Collaboration EC;

	
	public Engineering_CLB_FlowTest() {
		super();
	}
	
	@BeforeClass
	public void setup() {
		super.initialization();
		IC = new Innovation_Collaboration();
		EC = new Engineering_Collaboration();
		Testutils.ValidateUserLogin();
	}
	
	@Test(priority = 1)
	public void Verify_navigatetoengineering_functionality() throws InterruptedException {
		EC.navigate_to_engineering();
	}
	
	@Test(priority = 2)
	public void Verify_add_engineering_functionality() throws InterruptedException {
		EC.add_engineering();
		System.out.println("Engineering details added successfully.");
		Testutils.logout();
	}
	
	@Test(priority = 3)
	public void Verify_filter_and_sendrequest_functionality() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.get("https://tulip-uat.tntra.io/tntra");
		Testutils.logindetails("nirmit@yopmail.com", "Tulip@123");
		EC.navigate_to_engineering();
		IC.filter();
		IC.send_request();
		Testutils.logout();
		System.out.println("Engineering request sent successfully by FIRST user.");
		driver.manage().deleteAllCookies();
		driver.get("https://tulip-uat.tntra.io/tntra");
		Testutils.logindetails("parthiv@yopmail.com", "Brijesh@05042003");
		EC.navigate_to_engineering();
		IC.filter();
		IC.send_request();
		Testutils.logout();
		System.out.println("Engineering request sent successfully by SECOND user.");
	}
	
	
	@Test(priority = 4)
	public void Verify_reject_request_functionality() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.get("https://tulip-uat.tntra.io/tntra");
		Testutils.logindetails("parth.patel@tntra.io", "Parth@123");
		EC.navigate_to_engineering();
		IC.filter();
		IC.reject_request();
		Testutils.logout();
		System.out.println("Reject icon and button are working properly for Engineering collaboration.");
	}
	
	@Test(priority = 5)
	public void Verify_filter_and_sendrequest2_functionality() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.get("https://tulip-uat.tntra.io/tntra");
		Testutils.logindetails("nirmit@yopmail.com", "Tulip@123");
		EC.navigate_to_engineering();
		IC.filter();
		IC.send_request();
		Testutils.logout();
		System.out.println("Second Engineering request sent successfully by FIRST user.");
		driver.manage().deleteAllCookies();
		driver.get("https://tulip-uat.tntra.io/tntra");
		Testutils.logindetails("parthiv@yopmail.com", "Brijesh@05042003");
		EC.navigate_to_engineering();
		IC.filter();
		IC.send_request();
		Testutils.logout();
		System.out.println("Second Engineering request sent successfully by SECOND user.");
	}
	
	@Test(priority = 6)
	public void Verify_accept_request_functionality() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.get("https://tulip-uat.tntra.io/tntra");
		Testutils.logindetails("parth.patel@tntra.io", "Parth@123");
		EC.navigate_to_engineering();
		IC.filter();
		IC.accept_request();
		Testutils.logout();
		System.out.println("Approve icon and button are working properly for Engineering collaboration.");
	}

}
