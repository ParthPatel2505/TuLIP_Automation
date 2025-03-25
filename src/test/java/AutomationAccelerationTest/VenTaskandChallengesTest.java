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
	
	@Test
	public void openVenCardDetailsScreen() throws Exception
	{
		openVenCardFromDashboard();
		openVenCard();
	}
	
	public void openVenCardFromDashboard() throws Exception
	{
		movetoFromDashboard();
	}
}
