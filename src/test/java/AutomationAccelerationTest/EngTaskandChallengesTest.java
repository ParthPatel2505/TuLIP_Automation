package AutomationAccelerationTest;

import org.testng.annotations.Test;

import AutomationAcceleration.EngTaskandChallengesDetails;

public class EngTaskandChallengesTest extends EngTaskandChallengesDetails
{
	
	@Test
	public void openEngCardDetailsScreen() throws Exception
	{
		openEngCard();
	}
	
	public void openEngCardFromDashboard() throws Exception
	{
		movetoFromDashboard();
	}
}
