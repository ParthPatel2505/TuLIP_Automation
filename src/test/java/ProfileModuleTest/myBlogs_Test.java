package ProfileModuleTest;

import org.bouncycastle.pqc.jcajce.provider.qtesla.SignatureSpi.PI;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ProfilePages.MyBlogs;
import ProfilePages.Personal_Information;
import base.TestBase;
import utils.Testutils;

public class myBlogs_Test extends TestBase {

	MyBlogs MB;
	Personal_Information PI;

	public myBlogs_Test() {
		super();
	}

	@BeforeClass
	public void setup() {
		super.initialization();
		MB = new MyBlogs();
		PI = new Personal_Information();
		Testutils.logindetails("Chand.Patel@Tntra.io", "Brijesh@05042003");
	}

	@Test(priority = 1)
	public void navigatetoProfile() throws InterruptedException {
		PI.NavigatetoProfile();
		Thread.sleep(2000);

	}

	@Test(priority = 2)
	public void navigatetoMyBlogs() throws InterruptedException {

		Thread.sleep(2000);
		MB.navigateToMyBlogs();
	}

	@Test(priority = 3)
	public void verifyCloseAndCancel() throws InterruptedException {
		MB.closeAndCancel();
	}

	@Test(priority = 4)
	public void verifyValidations() throws InterruptedException {
		MB.verifyValidations();
	}

	@Test(priority = 5)
	public void verifyDisabledFields() throws InterruptedException {
		MB.disabledFields();
	}

	@Test(priority = 6)
	public void verifyRequiredFields() {
		MB.requiredFields();
	}

	@Test(priority = 7)
	public void verifyFillTheDetails() throws InterruptedException {
		MB.fillTheDetails();
	}

	@Test(priority = 8)
	public void verifyEditdetails() throws InterruptedException {
		MB.Editdetails();
	}

	@Test(priority = 9)
	public void verifyDeletedetails() throws InterruptedException {
		MB.deletedetails();
	}

}
