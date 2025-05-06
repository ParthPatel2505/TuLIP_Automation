package CollaborationANDReviewFlowaTest;

import java.awt.AWTException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import CollaborationANDReviewFlows.Innovation_Collaboration;
import base.TestBase;
import utils.Testutils;

public class Innovation_CLB_FlowTest extends TestBase{
	
	Innovation_Collaboration  IC;
	
	public Innovation_CLB_FlowTest() {
		super();
	}
	
	@BeforeClass
	public void setup() {
		super.initialization();
		IC = new Innovation_Collaboration();
		Testutils.ValidateUserLogin();
	}
	
	@Test(priority = 1)
	public void Verify_navigatetoinnovation_functionality() throws InterruptedException {
		IC.navigate_to_innovation();
	}
	
	@Test(priority = 2)
	public void Verify_add_innovation_functionality() throws InterruptedException, AWTException {
		IC.add_innovation();
		System.out.println("Innovation details added successfully.");
		Testutils.logout();
	}
	
	@Test(priority = 3)
	public void Verify_filter_and_sendrequest_functionality() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.get("https://tulip-uat.tntra.io/tntra");
		Testutils.logindetails("nirmit@yopmail.com", "Tulip@123");
		IC.navigate_to_innovation();
		IC.filter();
		IC.send_request();
		Testutils.logout();
		System.out.println("Collaboration request sent successfully by FIRST user.");
		driver.manage().deleteAllCookies();
		driver.get("https://tulip-uat.tntra.io/tntra");
		Testutils.logindetails("parthiv@yopmail.com", "Brijesh@05042003");
		IC.navigate_to_innovation();
		IC.filter();
		IC.send_request();
		Testutils.logout();
		System.out.println("Collaboration request sent successfully by SECOND user.");
	}
	
	
	@Test(priority = 4)
	public void Verify_reject_request_functionality() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.get("https://tulip-uat.tntra.io/tntra");
		Testutils.logindetails("parth.patel@tntra.io", "ParthPatel@2505");
		IC.navigate_to_innovation();
		IC.filter();
		IC.reject_request();
		Testutils.logout();
		System.out.println("Reject icon and button are working properly for innovation collaboration.");
	}
	
	@Test(priority = 5)
	public void Verify_filter_and_sendrequest2_functionality() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.get("https://tulip-uat.tntra.io/tntra");
		Testutils.logindetails("nirmit@yopmail.com", "Tulip@123");
		IC.navigate_to_innovation();
		IC.filter();
		IC.send_request();
		Testutils.logout();
		System.out.println("Second Collaboration request sent successfully by FIRST user.");
		driver.manage().deleteAllCookies();
		driver.get("https://tulip-uat.tntra.io/tntra");
		Testutils.logindetails("parthiv@yopmail.com", "Brijesh@05042003");
		IC.navigate_to_innovation();
		IC.filter();
		IC.send_request();
		Testutils.logout();
		System.out.println("Second Collaboration request sent successfully by SECOND user.");
	}
	
	@Test(priority = 6)
	public void Verify_accept_request_functionality() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.get("https://tulip-uat.tntra.io/tntra");
		Testutils.logindetails("parth.patel@tntra.io", "ParthPatel@2505");
		IC.navigate_to_innovation();
		IC.filter();
		IC.accept_request();
		Testutils.logout();
		System.out.println("Approve icon and button are working properly for innovation collaboration.");
	}
	
}
