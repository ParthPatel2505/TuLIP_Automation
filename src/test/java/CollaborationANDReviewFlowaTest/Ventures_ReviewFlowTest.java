package CollaborationANDReviewFlowaTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import CollaborationANDReviewFlows.Engineering_Collaboration;
import CollaborationANDReviewFlows.Innovation_Review;
import CollaborationANDReviewFlows.Ventures_Collaboration;
import base.TestBase;
import utils.Testutils;

public class Ventures_ReviewFlowTest extends TestBase{
	Innovation_Review IR;
	Ventures_Collaboration VC;
	
	public Ventures_ReviewFlowTest() {
		super();
	}
	
	@BeforeClass
	public void setup() {
		super.initialization();
		VC = new Ventures_Collaboration();
		IR = new Innovation_Review();
		Testutils.ValidateUserLogin();
	}
	
	@Test(priority = 1)
	public void Verify_navigatetoengineering_functionality() throws InterruptedException {
		VC.navigate_to_ventures();
	}
	
	@Test(priority = 2)
	public void Verify_add_innovation_functionality() throws InterruptedException {
		VC.add_ventures();
		System.out.println("First Ventures details added successfully.");
		VC.add_ventures2();
		System.out.println("Second Ventures details added successfully.");
	}
	
	@Test(priority = 3)
	public void Verify_sendforreview_functionality() throws InterruptedException {
		IR.sort();
		IR.review_request();
		System.out.println("Both added Ventures review request sent successfully.");
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
		System.out.println("Ventures feedback working properly");
	}
	
	@Test(priority = 7)
	public void Verify_reject_request_functionality() throws InterruptedException {
		IR.reject_request();
		System.out.println("Ventures review rejection is working properly");
	}
	
	@Test(priority = 8)
	public void Verify_approve_request_functionality() throws InterruptedException {
		IR.approve_request();
		System.out.println("Ventures review accept is working properly");
		Testutils.logout();
	}
	
	@Test(priority = 9)
	public void Verify_approved_rejected_functionality() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.get("https://tulip-uat.tntra.io/tntra");
		Testutils.logindetails("parth.patel@tntra.io", "ParthPatel@2505");
		VC.navigate_to_ventures();
		IR.sort();
		IR.verify_approved_request();
		IR.verify_rejected_request();
		System.out.println("Ventures approved and rejection verify properly.");
	}
}
