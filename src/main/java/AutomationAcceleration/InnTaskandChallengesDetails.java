package AutomationAcceleration;

public class InnTaskandChallengesDetails extends openInnEngVenCardDetails
{
	
	public void movetoFromDashboard() throws Exception
	{
		openFromDashboard();
		
	} 
	
	public void openInnCard() throws Exception
	{
		
		openCardDetails(prop.getProperty("automationAccelerationInn"));
		
	}
	
}
