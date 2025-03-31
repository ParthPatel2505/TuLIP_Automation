package AutomationAcceleration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import utils.Testutils;

public class AllAccAutoPagesOpenDetails extends InnTaskandChallengesDetails 
{
	@FindBy(xpath = "//div[contains(@class,'logo')]/button[@type='button']")
	WebElement sideMenuIcon;
	@FindBy(xpath = "(//*[contains(@class,'collapsed')])[1]")
	WebElement menuCollapsed;
	
	@FindBy(xpath = "//*[contains(@class,'menu')]/a[text()='Innovation']")
	WebElement innMenu;
	@FindBy(xpath = "//*[contains(@class,'menu')]/a[text()='Engineering']")
	WebElement engMenu;
	@FindBy(xpath = "//*[contains(@class,'menu')]/a[text()='Ventures']")
	WebElement venMenu;
	@FindBy(xpath = "//*[contains(@class,'menu')]/a[text()='Trending']")
	WebElement treMenu;
	
	@FindBy(xpath = "//h4[text()='Innovation']")
	WebElement innHeaderPage;
	@FindBy(xpath = "//h4[text()='Engineering']")
	WebElement engHeaderPage;
	@FindBy(xpath = "//h4[text()='Ventures']")
	WebElement venHeaderPage;
	@FindBy(xpath = "//h4[text()='Trending']")
	WebElement treHeaderPage;
	
	@FindBy(xpath = "//*[contains(text(),'Show More')]")
	WebElement loadMoreBtn;
	@FindBy(xpath = "//*[text()='All items has been loaded']")
	WebElement allLoadedText;
	@FindBy(xpath = "(//sup[contains(@class,'')])[1]")
	WebElement getCountofTiles;
	
	//common Method
	public void openMenu() throws Exception
	{
		Testutils.waitForElement(2);
		sideMenuIcon.click();
		Testutils.waitForElement(2);
	}
	
	//common Method
	public void checkOpenMenu() throws Exception
	{
		Testutils.waitForElement(3);
		//System.out.println(menuCollapsed.isDisplayed());
		sideMenuIcon.click();
		Testutils.waitForElement(2);
	}
	
	//common Method
	public void LoadMoreDate() throws Exception
	{
		Testutils.waitForElement(3);
		
		@SuppressWarnings("deprecation")
		String fetchCount = getCountofTiles.getAttribute("title");
		
		int fetchCountintoInt = Integer.parseInt(fetchCount);
		int makingCount = fetchCountintoInt/12;
		int loopCount = 0;
		if(fetchCountintoInt % 12 == 0)
		{
			loopCount = makingCount - 1;
			//System.out.println(loopCount);
		}
		else
		{
			loopCount = makingCount;
			//System.out.println(loopCount);
		}
		
		//checking total tiles is less than 12
		if(loopCount==0)
		{
			Assert.assertTrue(allLoadedText.isDisplayed(), "Still we have more data.");
		}
		else
		{
			for(int loop=0; loop<loopCount;loop++)
			{
				Testutils.bottomScrollUsingJS();
				Testutils.waitForElement(3);
				if(loadMoreBtn.isDisplayed())
				{
					loadMoreBtn.click();
					Testutils.waitForElement(3);
					Testutils.bottomScrollUsingJS();
				}
				else
				{
					Assert.assertTrue(allLoadedText.isDisplayed(), "Still we have more data.");
				}
			}
		}
		
	}
	
	public void openInn() throws Exception
	{
		Testutils.waitForElement(2);
		checkOpenMenu();
		innMenu.click();
		Testutils.waitForElement(3);
		Assert.assertTrue(innHeaderPage.isDisplayed(), "Use is on wrong page instead of Innovation.");
		Assert.assertTrue(Testutils.checkRedirection("Innovation"), "User is redirect on wrong URL instead of Innovation.");
		LoadMoreDate();
		Testutils.waitForElement(3);
	}
	
	public void openEng() throws Exception
	{
		Testutils.waitForElement(2);
		//checkOpenMenu();
		engMenu.click();
		Testutils.waitForElement(3);
		Assert.assertTrue(engHeaderPage.isDisplayed(), "Use is on wrong page instead of Engineering.");
		Assert.assertTrue(Testutils.checkRedirection("Engineering"), "User is redirect on wrong URL instead of Engineering.");
		LoadMoreDate();
		Testutils.waitForElement(3);
	}
	
	public void openVen() throws Exception
	{
		Testutils.waitForElement(2);
		//checkOpenMenu();
		venMenu.click();
		Testutils.waitForElement(3);
		Assert.assertTrue(venHeaderPage.isDisplayed(), "Use is on wrong page instead of Ventures.");
		Assert.assertTrue(Testutils.checkRedirection("Venture"), "User is redirect on wrong URL instead of Ventures.");
		LoadMoreDate();
		Testutils.waitForElement(3);
	}
	
	public void openTre() throws Exception
	{
		Testutils.waitForElement(2);
		//checkOpenMenu();
		treMenu.click();
		Testutils.waitForElement(3);
		Assert.assertTrue(treHeaderPage.isDisplayed(), "Use is on wrong page instead of Trending.");
		Assert.assertTrue(Testutils.checkRedirection("ticket-viewall"), "User is redirect on wrong URL instead of Trending.");
		LoadMoreDate();
		Testutils.waitForElement(3);
	}
	
}
