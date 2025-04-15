package AutomationAccelerationTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import AutomationAcceleration.EngTaskandChallengesDetails;
import utils.Testutils;

public class EngTaskandChallengesTest extends EngTaskandChallengesDetails
{
	@BeforeClass
	public void setup() {
		super.initialization();
		Testutils.ValidateUserLogin();
	}
	

	public void openEngCardFromDashboard() throws Exception
	{
		movetoFromDashboard();
	}
	
	
	@Test(priority=1)
	public void openEngCardDetailsScreen() throws Exception
	{
		openEngCardFromDashboard();
		openEngCard();
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
