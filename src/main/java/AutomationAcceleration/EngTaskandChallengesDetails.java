package AutomationAcceleration;

public class EngTaskandChallengesDetails extends openInnEngVenCardDetails
{
	
	public void movetoFromDashboard() throws Exception
	{
		openFromDashboard();
		
	}
	
	public void openEngCard() throws Exception
	{
		openCardDetails(prop.getProperty("automationAccelerationEng"));
		
	}
}
