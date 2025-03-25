package AutomationAccelerationTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import AutomationAcceleration.TrendingFiltersDetails;
import utils.Testutils;

public class TrendingFiltersDetailsTest extends TrendingFiltersDetails
{
	@BeforeClass
	public void setup() throws Exception {
		super.initialization();
		Testutils.ValidateUserLogin();
		movetoFromDashboard();
	}
	

	@Test(priority=1)
	public void openTypeFilters() throws Exception
	{
		typeFilters();
	}
	
	@Test(priority=2)
	public void openStateFilters() throws Exception
	{
		stateFilters();
	}

	@Test(priority=3)
	public void openViewAsFilters() throws Exception
	{
		viewAsFilters();
	}
	
	@Test(priority=4)
	public void openFavFilters() throws Exception
	{
		favFilters();
	}
	
	@Test(priority=5)
	public void openReviewStatusFilters() throws Exception
	{
		reviewStatusFilters();
	}
	
	@Test(priority=6)
	public void openDateRangeFilters() throws Exception
	{
		dateRangeFilters();
	}
	
	@Test(priority=7)
	public void openUseCaseFilters() throws Exception
	{
		useCaseFilters();
	}
	
	@Test(priority=8)
	public void openSorting() throws Exception
	{
		olderSorting();
		latestSorting();
	}
}
