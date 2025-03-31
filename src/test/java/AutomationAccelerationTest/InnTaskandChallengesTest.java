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
	
	@Test
	public void openInnCardDetailsScreen() throws Exception
	{
		openInnCardFromDashboard();
		openInnCard();
	}
	
	public void openInnCardFromDashboard() throws Exception
	{
		movetoFromDashboard();
	}
}
