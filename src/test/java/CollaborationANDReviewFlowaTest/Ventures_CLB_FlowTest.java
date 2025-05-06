package CollaborationANDReviewFlowaTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import CollaborationANDReviewFlows.Innovation_Collaboration;
import CollaborationANDReviewFlows.Ventures_Collaboration;
import base.TestBase;
import utils.Testutils;

public class Ventures_CLB_FlowTest extends TestBase{
	Innovation_Collaboration  IC;
	Ventures_Collaboration VC;

		
		public Ventures_CLB_FlowTest() {
			super();
		}
		
		@BeforeClass
		public void setup() {
			super.initialization();
			IC = new Innovation_Collaboration();
			VC = new Ventures_Collaboration();
			Testutils.ValidateUserLogin();
		}
		
		@Test(priority = 1)
		public void Verify_navigatetoventures_functionality() throws InterruptedException {
			VC.navigate_to_ventures();
		}
		
		@Test(priority = 2)
		public void Verify_add_ventures_functionality() throws InterruptedException {
			VC.add_ventures();
			System.out.println("Ventures details added successfully.");
			Testutils.logout();
		}
		
		@Test(priority = 3)
		public void Verify_filter_and_sendrequest_functionality() throws InterruptedException {
			driver.manage().deleteAllCookies();
			driver.get("https://tulip-uat.tntra.io/tntra");
			Testutils.logindetails("nirmit@yopmail.com", "Tulip@123");
			VC.navigate_to_ventures();
			IC.filter();
			IC.send_request();
			Testutils.logout();
			System.out.println("Ventures request sent successfully by FIRST user.");
			driver.manage().deleteAllCookies();
			driver.get("https://tulip-uat.tntra.io/tntra");
			Testutils.logindetails("parthiv@yopmail.com", "Brijesh@05042003");
			VC.navigate_to_ventures();
			IC.filter();
			IC.send_request();
			Testutils.logout();
			System.out.println("Ventures request sent successfully by SECOND user.");
		}
		
		
		@Test(priority = 4)
		public void Verify_reject_request_functionality() throws InterruptedException {
			driver.manage().deleteAllCookies();
			driver.get("https://tulip-uat.tntra.io/tntra");
			Testutils.logindetails("parth.patel@tntra.io", "ParthPatel@2505");
			VC.navigate_to_ventures();
			IC.filter();
			IC.reject_request();
			Testutils.logout();
			System.out.println("Reject icon and button are working properly for Ventures collaboration.");
		}
		
		@Test(priority = 5)
		public void Verify_filter_and_sendrequest2_functionality() throws InterruptedException {
			driver.manage().deleteAllCookies();
			driver.get("https://tulip-uat.tntra.io/tntra");
			Testutils.logindetails("nirmit@yopmail.com", "Tulip@123");
			VC.navigate_to_ventures();
			IC.filter();
			IC.send_request();
			Testutils.logout();
			System.out.println("Second Ventures request sent successfully by FIRST user.");
			driver.manage().deleteAllCookies();
			driver.get("https://tulip-uat.tntra.io/tntra");
			Testutils.logindetails("parthiv@yopmail.com", "Brijesh@05042003");
			VC.navigate_to_ventures();
			IC.filter();
			IC.send_request();
			Testutils.logout();
			System.out.println("Second Ventures request sent successfully by SECOND user.");
		}
		
		@Test(priority = 6)
		public void Verify_accept_request_functionality() throws InterruptedException {
			driver.manage().deleteAllCookies();
			driver.get("https://tulip-uat.tntra.io/tntra");
			Testutils.logindetails("parth.patel@tntra.io", "ParthPatel@2505");
			VC.navigate_to_ventures();
			IC.filter();
			IC.accept_request();
			Testutils.logout();
			System.out.println("Approve icon and button are working properly for Ventures collaboration.");
		}
}
