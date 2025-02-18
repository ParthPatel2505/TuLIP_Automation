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
	
	Testutils<Object> testutil = new Testutils<Object>();
	
	@FindBy(xpath = "//header[@class='top-header']/div/nav/div[@class='ant-flex css-7ynt2h ant-flex-align-center']//*[name()='svg'][1]")
	WebElement plusFromHeader;
	
	By plusHeaderIcon = By.xpath("//header[@class='top-header']/div/nav/div[@class='ant-flex css-7ynt2h ant-flex-align-center']//*[name()='svg'][1]");
	
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
	
	String plusIconList = "//*[@class='ant-dropdown css-7ynt2h ant-dropdown-show-arrow ant-dropdown-placement-bottomRight']/ul/li";

	public MenuOrHeaderPanel() {
		PageFactory.initElements(driver, this);
	}
	
	public void openPlusMenuFromHeader() throws Exception
	{
		//System.out.println("Entered in MenuHEaderClass.....");
		testutil.waitForElement(3);
		
		WebElement plusIcon = driver.findElement(plusHeaderIcon);
		Actions action = new Actions(driver);
		action.moveToElement(plusIcon).click().build().perform();
		
		//testutil.clickonElement(plusHeaderIcon);
		testutil.waitForElement(2);
		testutil.selectFromMenuList(plusIconList, prop.getProperty("automationAccelerationInn"));
		testutil.waitForElement(7);
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
