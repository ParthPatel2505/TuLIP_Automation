package ProfileModuleTest;
import ProfilePages.Feedback;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;
import utils.Testutils;

public class Feedback_Test extends TestBase{

	Feedback FT;
	public Feedback_Test()
	{
		super();
	}
	@BeforeClass
	public void setup()  
	{
		super.initialization();
		FT = new Feedback();
		Testutils.logindetails("Chand.Patel@tntra.io","Brijesh@05042003");
	}
	@Test(priority=1)
	void verifyDisabledFields() throws InterruptedException
	{
		FT.disabledFields();
	}
	
	@Test(priority=3)
	void verifyRequiredFields() throws InterruptedException
	{
		FT.requiredFields();
	}
	
	@Test(priority=4)
	void verifyHoverMessage() throws InterruptedException
	{
		FT.hoverMessage();
	}
	
	@Test(priority=5)
	void verifyCloseAndCancel() throws InterruptedException
	{
		FT.closeAndCancel();
	}
	
	@Test(priority=6)
	void verifybasicMsg() throws InterruptedException
	{
		FT.basicMsg();
	}
	
	@Test(priority=7)
	void verifyFillTheDetails() throws InterruptedException
	{
		FT.fillTheDetails();
}
	
	
}
