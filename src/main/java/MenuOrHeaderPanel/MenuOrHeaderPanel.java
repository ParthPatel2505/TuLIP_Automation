package MenuOrHeaderPanel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import LoginModule.Loginpage;
import utils.Testutils;

public class MenuOrHeaderPanel extends Loginpage
{
	
	@FindBy(xpath = "//header[@class='top-header']/div/nav/div[@class='ant-flex css-7ynt2h ant-flex-align-center']//*[name()='svg'][1]")
	WebElement plusFromHeader;
	
	@FindBy(xpath = "(//*[contains(@class,'plus')])[2]")
	WebElement plusHeaderIcon;
	
	//By plusHeaderIcon = By.xpath("//header[@class='top-header']/div/nav/div[@class='ant-flex css-7ynt2h ant-flex-align-center']//*[name()='svg'][1]");
	
	@FindBy(xpath = "//*[@class='tabler-icon tabler-icon-message-plus pointer']") 
	WebElement languageFromHeader;
	
	@FindBy(xpath = "//*[@class='tabler-icon tabler-icon-user-star pointer']")
	WebElement feedbackFromHeader;
	
	@FindBy(xpath = "//*[@class='ant-avatar ant-avatar-circle ant-avatar-image ant-dropdown-trigger pointer profileImage css-7ynt2h']")
	WebElement profileFromHeader;
	
	@FindBy(xpath = "//*[@class='ant-dropdown css-7ynt2h ant-dropdown-show-arrow ant-dropdown-placement-bottomRight']/ul")
	WebElement openULMenuFromHeader;
	
	@FindBy(xpath = "//*[@class='ant-dropdown css-7ynt2h ant-dropdown-show-arrow ant-dropdown-placement-bottomRight']/ul/li")
	WebElement plusIconListing;
	
	@FindBy(xpath = "//span[contains(text(),'Innovation')]")
	WebElement innFromPlusIcon;
	@FindBy(xpath = "//span[contains(text(),'Engineering')]")
	WebElement engFromPlusIcon;
	@FindBy(xpath = "//span[contains(text(),'Ventures')]")
	WebElement venFromPlusIcon;
	@FindBy(xpath = "//span[contains(text(),'Merger and Acquisition')]")
	WebElement mergeAcqFromPlusIcon;
	
	String plusIconList = "//*[@class='ant-dropdown css-7ynt2h ant-dropdown-show-arrow ant-dropdown-placement-bottomRight']/ul/li";

	public MenuOrHeaderPanel() {
		PageFactory.initElements(driver, this);
	}
	
	public void openInnovationFromPlusMenuFromHeader() throws Exception
	{
		PageFactory.initElements(driver, this);
		Testutils.waitForElement(4);
		
		plusHeaderIcon.click();
		
		Testutils.waitForElement(2);
		innFromPlusIcon.click();
		Testutils.waitForElement(7);
	}

	public void openEngFromPlusMenuFromHeader() throws Exception
	{
		PageFactory.initElements(driver, this);
		Testutils.waitForElement(4);
		
		plusHeaderIcon.click();
		
		Testutils.waitForElement(2);
		engFromPlusIcon.click();
		Testutils.waitForElement(7);
	}
	
	public void openVenturesFromPlusMenuFromHeader() throws Exception
	{
		PageFactory.initElements(driver, this);
		Testutils.waitForElement(4);
		
		plusHeaderIcon.click();
		
		Testutils.waitForElement(2);
		venFromPlusIcon.click();
		Testutils.waitForElement(7);
	}
	
	public void openMergerAcqFromPlusMenuFromHeader() throws Exception
	{
		PageFactory.initElements(driver, this);
		Testutils.waitForElement(4);
		
		plusHeaderIcon.click();
		
		Testutils.waitForElement(2);
		mergeAcqFromPlusIcon.click();
		Testutils.waitForElement(7);
	}
	
	public void openLanMenuFromHeader()
	{
		languageFromHeader.click();
		
		//testutil.menuList(openULMenuFromHeader, prop.getProperty("languageEn"));
	}
	
	public void feedbackMenuFromHeader()
	{
		feedbackFromHeader.click();
	}
	
	public void profileMenuFromHeader()
	{
		profileFromHeader.click();
	}
}
