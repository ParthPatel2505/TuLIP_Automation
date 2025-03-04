package AutomationAccelerationTest;

import org.testng.annotations.Test;

import AutomationAcceleration.InnTaskandChallengesDetails;

public class InnTaskandChallengesTest extends InnTaskandChallengesDetails
{
	
	@Test
	public void openInnCardDetailsScreen() throws Exception
	{
		openInnCard();
	}
	
	public void openInnCardFromDashboard() throws Exception
	{
		movetoFromDashboard();
	}
}
