package AutomationAcceleration;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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
	
	
	public void openInn() throws Exception
	{
		Testutils.waitForElement(2);
		checkOpenMenu();
		innMenu.click();
		Testutils.waitForElement(3);
		Assert.assertTrue(innHeaderPage.isDisplayed(), "Use is on wrong page instead of Innovation.");
		Assert.assertTrue(Testutils.checkRedirection("Innovation"), "User is redirect on wrong URL instead of Innovation.");
	}
	
	public void openEng() throws Exception
	{
		Testutils.waitForElement(2);
		//checkOpenMenu();
		engMenu.click();
		Testutils.waitForElement(3);
		Assert.assertTrue(engHeaderPage.isDisplayed(), "Use is on wrong page instead of Engineering.");
		Assert.assertTrue(Testutils.checkRedirection("Engineering"), "User is redirect on wrong URL instead of Engineering.");
	}
	
	public void openVen() throws Exception
	{
		Testutils.waitForElement(2);
		//checkOpenMenu();
		venMenu.click();
		Testutils.waitForElement(3);
		Assert.assertTrue(venHeaderPage.isDisplayed(), "Use is on wrong page instead of Ventures.");
		Assert.assertTrue(Testutils.checkRedirection("Venture"), "User is redirect on wrong URL instead of Ventures.");
	}
	
	public void openTre() throws Exception
	{
		Testutils.waitForElement(2);
		//checkOpenMenu();
		treMenu.click();
		Testutils.waitForElement(3);
		Assert.assertTrue(treHeaderPage.isDisplayed(), "Use is on wrong page instead of Trending.");
		Assert.assertTrue(Testutils.checkRedirection("ticket-viewall"), "User is redirect on wrong URL instead of Trending.");
	}
	
}
