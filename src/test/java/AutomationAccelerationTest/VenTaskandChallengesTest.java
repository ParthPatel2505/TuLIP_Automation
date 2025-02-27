package AutomationAccelerationTest;

import org.testng.annotations.Test;

import AutomationAcceleration.VenTaskandChallengesDetails;

public class VenTaskandChallengesTest extends VenTaskandChallengesDetails
{
	@Test
	public void openVenCardDetailsScreen() throws Exception
	{
		openVenCard();
	}
	
	public void openVenCardFromDashboard() throws Exception
	{
		movetoFromDashboard();
	}
}
