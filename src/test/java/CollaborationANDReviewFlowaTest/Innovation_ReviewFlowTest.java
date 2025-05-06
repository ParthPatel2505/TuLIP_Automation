package CollaborationANDReviewFlowaTest;

import java.awt.AWTException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import CollaborationANDReviewFlows.Innovation_Collaboration;
import CollaborationANDReviewFlows.Innovation_Review;
import base.TestBase;
import utils.Testutils;

public class Innovation_ReviewFlowTest extends TestBase{
	Innovation_Review IR;
	Innovation_Collaboration IC;
	
	public Innovation_ReviewFlowTest() {
		super();
	}
	
	@BeforeClass
	public void setup() {
		super.initialization();
		IC = new Innovation_Collaboration();
		IR = new Innovation_Review();
		Testutils.ValidateUserLogin();
	}
	
	@Test(priority = 1)
	public void Verify_navigatetoinnovation_functionality() throws InterruptedException {
		IC.navigate_to_innovation();
	}
	
	@Test(priority = 2)
	public void Verify_add_innovation_functionality() throws InterruptedException, AWTException {
		IC.add_innovation();
		System.out.println("First Innovation details added successfully.");
		IC.add_innovation2();
		System.out.println("Second Innovation details added successfully.");
	}
	
	@Test(priority = 3)
	public void Verify_sendforreview_functionality() throws InterruptedException {
		IR.sort();
		IR.review_request();
		System.out.println("Both added Innovation review request sent successfully.");
		Testutils.logout();
	}
	
	@Test(priority = 4)
	public void Verify_navigate_to_review_pool_functionality() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.get("https://tulip-uat.tntra.io/tntra");
		Testutils.logindetails("parthiv@yopmail.com", "Brijesh@05042003");
		IR.navigate_to_review_pool();
	}
	
	@Test(priority = 5)
	public void Verify_assign_unassign_functionality() throws InterruptedException {
		IR.assign_unassign();
	}
	
	@Test(priority = 6)
	public void Verify_feedback_functionality() throws InterruptedException {
		IR.feedback();
		System.out.println("Innovation feedback working properly");
	}
	
	@Test(priority = 7)
	public void Verify_reject_request_functionality() throws InterruptedException {
		IR.reject_request();
		System.out.println("Innovation review rejection is working properly");
	}
	
	@Test(priority = 8)
	public void Verify_approve_request_functionality() throws InterruptedException {
		IR.approve_request();
		System.out.println("Innovation review accept is working properly");
		Testutils.logout();
	}
	
	@Test(priority = 9)
	public void Verify_approved_rejected_functionality() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.get("https://tulip-uat.tntra.io/tntra");
		Testutils.logindetails("parth.patel@tntra.io", "ParthPatel@2505");
		IC.navigate_to_innovation();
		IR.sort();
		IR.verify_approved_request();
		IR.verify_rejected_request();
		System.out.println("Innovation approved and rejection verify properly.");
	}
}
