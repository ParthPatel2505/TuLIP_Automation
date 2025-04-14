package AutomationAccelerationTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import AutomationAcceleration.AllAccAutoPagesOpenDetails;
import utils.Testutils;

public class AllAccAutoPagesOpenDetailsTest extends AllAccAutoPagesOpenDetails 
{
	@BeforeClass
	public void setup() throws Exception {
		super.initialization();
		PageFactory.initElements(driver, this);
		Testutils.ValidateUserLogin();
	}
	
	@Test(priority=1)
	public void openInnovationPage() throws Exception
	{
		openInn();
	}

	@Test(priority=2)
	public void openEngineetingPage() throws Exception
	{
		openEng();
	}
	
	@Test(priority=3)
	public void openVenturesPage() throws Exception
	{
		openVen();
	}
	
	@Test(priority=4)
	public void openTrendingPage() throws Exception
	{
		openTre();
	} 
	
	@Test(priority=5)
	public void openMergerAcqPage() throws Exception
	{
		openMergeAcq();
	} 
}
