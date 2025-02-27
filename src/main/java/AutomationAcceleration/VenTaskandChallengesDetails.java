package AutomationAcceleration;

public class VenTaskandChallengesDetails extends openInnEngVenCardDetails
{
	
	public void movetoFromDashboard() throws Exception
	{
		openFromDashboard();
		
	}
	
	
	public void openVenCard() throws Exception
	{
		openCardDetails(prop.getProperty("automationAccelerationVen"));
		
	}
}
