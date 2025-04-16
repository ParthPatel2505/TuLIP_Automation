package AutomationAccelerationTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import AutomationAcceleration.InnTaskandChallengesDetails;
import utils.Testutils;

public class InnTaskandChallengesTest extends InnTaskandChallengesDetails
{
	@BeforeClass
	public void setup() {
		super.initialization();
		Testutils.ValidateUserLogin();
	}
	
	public void openInnCardFromDashboard() throws Exception
	{
		movetoFromDashboard();
	}
	
	
	@Test(priority=1)
	public void openInnCardDetailsScreen() throws Exception
	{
		openInnCardFromDashboard();
		openInnCard();
	}
	
	@Test(priority=2)
	public void openAddTaskandChalScreen() throws Exception
	{
		tasks();
		challenges();
	}
	
	@Test(priority=3)
	public void checkEditFunctionality() throws Exception
	{
		openDetailsTabandClickOnEdit();
	}
	
	
}
