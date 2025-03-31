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
	
	@Test
	public void openEngCardDetailsScreen() throws Exception
	{
		openEngCardFromDashboard();
		openEngCard();
	}
	
	public void openEngCardFromDashboard() throws Exception
	{
		movetoFromDashboard();
	}
}
