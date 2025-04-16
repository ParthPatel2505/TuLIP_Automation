package AutomationAccelerationTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import AutomationAcceleration.VenTaskandChallengesDetails;
import utils.Testutils;

public class VenTaskandChallengesTest extends VenTaskandChallengesDetails
{
	@BeforeClass
	public void setup() {
		super.initialization();
		Testutils.ValidateUserLogin();
	}
	
	public void openVenCardFromDashboard() throws Exception
	{
		movetoFromDashboard();
	}
	
	
	@Test(priority=1)
	public void openVenCardDetailsScreen() throws Exception
	{
		openVenCardFromDashboard();
		openVenCard();
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
