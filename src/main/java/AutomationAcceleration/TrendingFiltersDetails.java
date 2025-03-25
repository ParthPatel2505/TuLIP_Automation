package AutomationAcceleration;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import utils.Testutils;

public class TrendingFiltersDetails extends InnTaskandChallengesDetails
{
	@FindBy(xpath = "//button[.//*[contains(text(), 'Filters')]]")
	WebElement openFilter;
	@FindBy(xpath = "//li//*[text()='Type']")
	WebElement type;
	@FindBy(xpath = "//span[contains(text(),'Innovation')]")
	WebElement innType;
	@FindBy(xpath = "//span[contains(text(),'Engineering')]")
	WebElement engType;
	@FindBy(xpath = "//span[contains(text(),'Ventures')]")
	WebElement venType;
	@FindBy(xpath = "//button[.//*[contains(text(), 'Reset')]]")
	WebElement resetButton;
	@FindBy(xpath = "//button[.//*[contains(text(), 'Clear All')]]")
	WebElement clearAllButton;
	@FindBy(xpath = "//span[.//span[contains(text(),'Innovation')] and .//*[contains(@class,'close')]]")
	WebElement innFilterSelection;
	@FindBy(xpath = "//span[.//span[contains(text(),'Engine')] and .//*[contains(@class,'close')]]")
	WebElement engFilterSelection;
	@FindBy(xpath = "//span[.//span[contains(text(),'Ventures')] and .//*[contains(@class,'close')]]")
	WebElement venFilterSelection;
	
	@FindBy(xpath = "//li//*[text()='State']")
	WebElement state;
	@FindBy(xpath = "//li[.//span[contains(text(),'Collation')]]")
	WebElement colState;
	@FindBy(xpath = "//li[.//span[contains(text(),'Curation')]]")
	WebElement curState;
	@FindBy(xpath = "//li[.//span[contains(text(),'Orchestration')]]")
	WebElement orcState;
	@FindBy(xpath = "//span[.//span[contains(text(),'Collation')] and .//*[contains(@class,'close')]]")
	WebElement colFilterSelection;
	@FindBy(xpath = "//span[.//span[contains(text(),'Curation')] and .//*[contains(@class,'close')]]")
	WebElement curFilterSelection;
	@FindBy(xpath = "//span[.//span[contains(text(),'Orche')] and .//*[contains(@class,'close')]]")
	WebElement orcFilterSelection;
	
	@FindBy(xpath = "//li//*[text()='View As']")
	WebElement viewAs;
	@FindBy(xpath = "//li[.//span[contains(text(),'Trending')]]")
	WebElement treViewAs;
	@FindBy(xpath = "//span[.//span[contains(text(),'Trending')] and .//*[contains(@class,'close')]]")
	WebElement treFilterSelection;
	@FindBy(xpath = "//li[.//span[contains(text(),'Creator')]]")
	WebElement creViewAs;
	@FindBy(xpath = "//span[.//span[contains(text(),'Creator')] and .//*[contains(@class,'close')]]")
	WebElement creFilterSelection;
	@FindBy(xpath = "//li[.//span[contains(text(),'Collaborator')]]")
	WebElement collViewAs;
	@FindBy(xpath = "//span[.//span[contains(text(),'Collabo')] and .//*[contains(@class,'close')]]")
	WebElement collFilterSelection;
	@FindBy(xpath = "//li[.//span[contains(text(),'Manager')]]")
	WebElement mngViewAs;
	@FindBy(xpath = "//span[.//span[contains(text(),'Manager')] and .//*[contains(@class,'close')]]")
	WebElement mngFilterSelection;
	
	@FindBy(xpath = "//li//*[text()='Favorite']")
	WebElement fav;
	@FindBy(xpath = "//span[.//span[contains(text(),'Favorite')] and .//*[contains(@class,'close')]]")
	WebElement favFilterSelection;
	
	@FindBy(xpath = "//li//*[text()='Review Status']")
	WebElement reviewState;
	@FindBy(xpath = "//li[.//span[contains(text(),'Sent for Review')]]")
	WebElement sfrViewAs;
	@FindBy(xpath = "//span[.//span[contains(text(),'Sent for')] and .//*[contains(@class,'close')]]")
	WebElement sfrFilterSelection;
	@FindBy(xpath = "//li[.//span[contains(text(),'In Review')]]")
	WebElement inViewAs;
	@FindBy(xpath = "//span[.//span[contains(text(),'In Review')] and .//*[contains(@class,'close')]]")
	WebElement inFilterSelection;
	@FindBy(xpath = "//li[.//span[contains(text(),'Approved')]]")
	WebElement apvViewAs;
	@FindBy(xpath = "//span[.//span[contains(text(),'Approved')] and .//*[contains(@class,'close')]]")
	WebElement apvFilterSelection;
	
	@FindBy(xpath = "//li//*[text()='Date Range']")
	WebElement dateRange;
	@FindBy(xpath = "//input[@date-range='start']")
	WebElement dateField;
	@FindBy(xpath = "//button[.//*[text()='Apply']]")
	WebElement dateRangeApply;
	
	
	@FindBy(xpath = "//li//*[text()='Use Cases']")
	WebElement useCase;
	@FindBy(xpath = "//input[@type='search']")
	WebElement useCaseSearch;
	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement useCaseOptionSelect;
	@FindBy(xpath = "//button[contains(@class,'clear') and @type='button']")
	WebElement ucSearchClear;
	@FindBy(xpath = "//button[.//*[text()='OK']]")
	WebElement ucOKBtn;
	@FindBy(xpath = "//div[contains(@class,'custom-dropdown')]//button[span[text()='Reset']]")
	WebElement ucResetBtn;
	
	@FindBy(xpath = "//*[text()='Clear All']")
	WebElement clearAllBtn;
	
	@FindBy(xpath = "//button[.//*[text()='Sort']]")
	WebElement openSort;
	@FindBy(xpath = "//li[.//*[text()='Oldest First']]")
	WebElement olderSortOption;
	@FindBy(xpath = "//li[.//*[text()='Latest First']]")
	WebElement latestSortOption;
	@FindBy(xpath = "//span[.//span[contains(text(),'Oldest')] and .//*[contains(@class,'close')]]")
	WebElement oldSortSelection;
	@FindBy(xpath = "//span[.//span[contains(text(),'Latest')] and .//*[contains(@class,'close')]]")
	WebElement latestSortSelection;
	

	//common methods
	public void resetFilter() throws Exception
	{
		Testutils.waitForElement(3);
		openFilter();
		resetButton.click();
		Testutils.waitForElement(2);
	}
	
	//common methods
	public void openFilter() throws Exception
	{
		openFilter.click();
		Testutils.waitForElement(3);
	}
	
	//common methods
	public void openSort() throws Exception
	{
		openSort.click();
		Testutils.waitForElement(3);
	}
	
	//common methods
	public void clearAll() throws Exception
	{
		Testutils.waitForElement(3);
		clearAllBtn.click();
		Testutils.waitForElement(3);
	}
	
	//common methods
	public void sendStringintoField(WebElement element, String word) throws Exception
	{
		Testutils.waitForElement(2);
		for(int i=0;i<word.length();i++)
		{
			char charValue = word.charAt(i);
			String value = String.valueOf(charValue);
			element.sendKeys(value);
			Testutils.waitForElement(1);
		}
		
	}
	
	public void typeFilters() throws Exception
	{
		resetFilter();
		//Select Innovation option
		Testutils.waitForElement(2);
		openFilter();
		type.click();
		Testutils.waitForElement(2);
		innType.click();
		Testutils.waitForElement(2);
		Assert.assertTrue(validationMessage(innFilterSelection), "Wrong filter selected.");
		
		//Select Engineering option
		openFilter();
		type.click();
		Testutils.waitForElement(2);
		engType.click();
		Testutils.waitForElement(2);
		Assert.assertTrue(validationMessage(engFilterSelection), "Wrong filter selected.");
		Testutils.waitForElement(2);
		
		//Select Ventures option
		openFilter();
		type.click();
		Testutils.waitForElement(2);
		venType.click();
		Testutils.waitForElement(2);
		Assert.assertTrue(validationMessage(venFilterSelection), "Wrong filter selected.");
		Testutils.waitForElement(2);
		
	}
	
	public void stateFilters() throws Exception
	{
		resetFilter();
		
		//Select Collation option
		Testutils.waitForElement(2);
		openFilter();
		state.click();
		Testutils.waitForElement(2);
		colState.click();
		Testutils.waitForElement(2);
		Assert.assertTrue(validationMessage(colFilterSelection), "Wrong filter selected.");
		
		//Select Curation option
		Testutils.waitForElement(2);
		openFilter();
		state.click();
		Testutils.waitForElement(2);
		curState.click();
		Testutils.waitForElement(2);
		Assert.assertTrue(validationMessage(curFilterSelection), "Wrong filter selected.");
				
		//Select Orchestration option
		Testutils.waitForElement(2);
		openFilter();
		state.click();
		Testutils.waitForElement(2);
		orcState.click();
		Testutils.waitForElement(2);
		Assert.assertTrue(validationMessage(orcFilterSelection), "Wrong filter selected.");

	}
	
	public void viewAsFilters() throws Exception
	{
		resetFilter();
		
		//Select Trending option
		Testutils.waitForElement(2);
		openFilter();
		viewAs.click();
		Testutils.waitForElement(2);
		treViewAs.click();
		Testutils.waitForElement(2);
		Assert.assertTrue(validationMessage(treFilterSelection), "Wrong filter selected.");
		
		//Select Creator option
		Testutils.waitForElement(2);
		openFilter();
		viewAs.click();
		Testutils.waitForElement(2);
		creViewAs.click();
		Testutils.waitForElement(2);
		Assert.assertTrue(validationMessage(creFilterSelection), "Wrong filter selected.");
				
		//Select Collaboration option
		Testutils.waitForElement(2);
		openFilter();
		viewAs.click();
		Testutils.waitForElement(2);
		collViewAs.click();
		Testutils.waitForElement(2);
		Assert.assertTrue(validationMessage(collFilterSelection), "Wrong filter selected.");
				
		//Select Manager option
		Testutils.waitForElement(2);
		openFilter();
		viewAs.click();
		Testutils.waitForElement(2);
		mngViewAs.click();
		Testutils.waitForElement(2);
		Assert.assertTrue(validationMessage(mngFilterSelection), "Wrong filter selected.");
	}
	
	public void favFilters() throws Exception
	{
		resetFilter();
		
		//Select Favorite option
		Testutils.waitForElement(2);
		openFilter();
		fav.click();
		Testutils.waitForElement(2);
		Assert.assertTrue(validationMessage(favFilterSelection), "Wrong filter selected.");
	}
	
	public void reviewStatusFilters() throws Exception
	{
		resetFilter();
		
		//Select Sent for Review option
		Testutils.waitForElement(2);
		openFilter();
		reviewState.click();
		Testutils.waitForElement(2);
		sfrViewAs.click();
		Testutils.waitForElement(2);
		Assert.assertTrue(validationMessage(sfrFilterSelection), "Wrong filter selected.");
		
		//Select In Review option
		Testutils.waitForElement(2);
		openFilter();
		reviewState.click();
		Testutils.waitForElement(2);
		inViewAs.click();
		Testutils.waitForElement(2);
		Assert.assertTrue(validationMessage(inFilterSelection), "Wrong filter selected.");
		
		//Select Approved option
		Testutils.waitForElement(2);
		openFilter();
		reviewState.click();
		Testutils.waitForElement(2);
		apvViewAs.click();
		Testutils.waitForElement(2);
		Assert.assertTrue(validationMessage(apvFilterSelection), "Wrong filter selected.");
	}
	
	public void dateRangeFilters() throws Exception
	{
		resetFilter();
		
		//Select Collation option
		Testutils.waitForElement(2);
		openFilter();
		dateRange.click();
		
		Date today = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(today);
		int i = c.get(Calendar.DAY_OF_WEEK) - c.getFirstDayOfWeek();
		c.add(Calendar.DATE, -i-7);
		Date start = c.getTime();
		c.add(Calendar.DATE, 6);
		Date end = c.getTime();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String startformattedDate = dateFormat.format(start);
		String endformattedDate = dateFormat.format(end);
		
		System.out.println("Start Date :- "+startformattedDate+" && End Date :- "+endformattedDate);
		
		dateField.click();
		Testutils.waitForElement(2);
		WebElement startDate = driver.findElement(By.xpath("//*[@title='"+startformattedDate+"']"));
		startDate.click();
		Testutils.waitForElement(2);
		WebElement endDate = driver.findElement(By.xpath("//*[@title='"+endformattedDate+"']"));
		endDate.click();
		Testutils.waitForElement(2);
		dateRangeApply.click();
		
	}
	
	public void useCaseFilters() throws Exception
	{
		resetFilter();
		
		//Select Collation option
		Testutils.waitForElement(2);
		openFilter();
		useCase.click();
		sendStringintoField(useCaseSearch, "Inventory");
		Testutils.waitForElement(2);
		useCaseOptionSelect.click();
		Testutils.waitForElement(3);
		ucResetBtn.click();
		sendStringintoField(useCaseSearch, "Music");
		Testutils.waitForElement(2);
		useCaseOptionSelect.click();
		Testutils.waitForElement(2);
		ucSearchClear.click();
		sendStringintoField(useCaseSearch, "Accounting");
		Testutils.waitForElement(2);
		useCaseOptionSelect.click();
		Testutils.waitForElement(2);
		ucOKBtn.click();	
		clearAll();
	}
	
	public void olderSorting() throws Exception
	{
		Testutils.waitForElement(2);
		openSort();
		olderSortOption.click();
		Testutils.waitForElement(2);
		Assert.assertTrue(validationMessage(oldSortSelection), "Wrong filter selected.");
	}
	
	public void latestSorting() throws Exception
	{
		clearAll();
		Testutils.waitForElement(2);
		openSort();
		latestSortOption.click();
		Testutils.waitForElement(2);
		Assert.assertTrue(validationMessage(latestSortSelection), "Wrong filter selected.");
	}

}
