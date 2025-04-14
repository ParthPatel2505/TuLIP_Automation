package AutomationAcceleration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import LoginModule.Loginpage;
import MenuOrHeaderPanel.MenuOrHeaderPanel;
import base.TestBase;
import utils.Testutils;

public class VenturesDetails extends TestBase
{
    Loginpage lp = new Loginpage();
	MenuOrHeaderPanel clickOnPlus = new MenuOrHeaderPanel();
	
    //validation messages
	@FindBy(xpath = "//*[@type='submit']")
	WebElement saveBtn;
	@FindBy(xpath = "//*[@type='button']/span[text()='Reset']")
	WebElement resetBtn;
	@FindBy(xpath = "//*[@type='button']/span[text()='Cancel']")
	WebElement cancelBtn;
	@FindBy(xpath = "//*[contains(@class,'danger') and contains(text(),'First')]")
	WebElement validationOnVenFName;
	@FindBy(xpath = "//*[contains(@class,'danger') and contains(text(),'Last')]")
	WebElement validationOnVenLName;
	@FindBy(xpath = "//*[contains(@class,'danger') and contains(text(),'Email')]")
	WebElement validationOnVenEmail;
	@FindBy(xpath = "//*[contains(@class,'danger') and contains(text(),'Company')]")
	WebElement validationOnVenComp;
	@FindBy(xpath = "//*[contains(@class,'danger') and contains(text(),'radio')]")
	WebElement validationOnVenVisibility;
    @FindBy(xpath = "//*[contains(@class,'danger') and contains(text(),'Use Case')]")
	WebElement validationOnVenUseCase;
	
	//fields
	@FindBy(xpath = "//*[@id='ventures.firstName']")
	WebElement venFName;
	@FindBy(xpath = "//*[@id='ventures.lastName']")
	WebElement venLName;
	@FindBy(xpath = "//*[@id='ventures.email']")
	WebElement venEmail;
	@FindBy(xpath = "//*[@id='ventures.companyName']")
	WebElement venCompany;
	@FindBy(xpath = "//*[@id='ventures.programOfInterest']")
	WebElement venProgOfInterest;
	@FindBy(xpath = "//*[@id='ventures.profYear']")
	WebElement venProgOfExp;
	@FindBy(xpath = "(//*[@type='radio' and @value='0'])[1]")
	WebElement venVisibilityRadio;
	@FindBy(xpath = "(//div[@contenteditable='true'])[1]")
	WebElement venProgGoals;
	@FindBy(xpath = "//div[@name='useCases']")
	WebElement venUseCase;
	@FindBy(xpath = "//div[@name='useCases']//*/input[@role='combobox']")
	WebElement venUCField;
	@FindBy(xpath = "//div[@name='referralSource']")
	WebElement venReferral;
	@FindBy(xpath = "//div[@name='referralSource']//*/input[@role='combobox']")
	WebElement venRefField;
	
	//common dropdown field
    @FindBy(xpath = "//div[@class='rc-virtual-list-holder']")
	WebElement dropdownList;
    
    //upload and delete images
	@FindBy(xpath = "//*[contains(@class,'upload')]/input")
	WebElement uploadInput;
	@FindBy(xpath = "//button[@aria-label='delete']")
	WebElement deleteIconOfUploadFile;
	@FindBy(xpath = "//button[@type='button']//*[contains(text(),'Delete')]")
	WebElement deleteBtnFromDeletePopup;
	@FindBy(xpath = "(//button[@type='button']//*[contains(text(),'Cancel')])[2]")
	WebElement cancelBtnFromDeletePopup;
    
	String pathOfElement = "//div[contains(text(),'";
	
	public VenturesDetails() {
		PageFactory.initElements(driver, this);
	}
	
    public void openEngFormFromPlus() throws Exception
	{
		clickOnPlus.openVenturesFromPlusMenuFromHeader();
	}

	public void checkValidation() throws Exception
	{
		Testutils.waitForElement(5);
		Testutils.waitForElementAndClick(driver, saveBtn);
	
	}
	
	public boolean validationMessage(WebElement element)
	{
		if(element.isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public void validationCheck()throws Exception
	{
		PageFactory.initElements(driver, this);
		Testutils.waitForElement(3);
		Testutils.scroll_bottom();
		Testutils.waitForElement(1);
		checkValidation();
		Testutils.waitForElement(1);
		Testutils.scroll_top();
		Testutils.waitForElement(3);
		Assert.assertTrue(validationMessage(validationOnVenFName), "Validation is not get display on field");
		Assert.assertTrue(validationMessage(validationOnVenLName), "Validation is not get display on field");
		Assert.assertTrue(validationMessage(validationOnVenEmail), "Validation is not get display on field");
		Assert.assertTrue(validationMessage(validationOnVenComp), "Validation is not get display on field");
		Assert.assertTrue(validationMessage(validationOnVenVisibility), "Validation is not get display on field");
		Assert.assertTrue(validationMessage(validationOnVenUseCase), "Validation is not get display on field");
		
		Testutils.waitForElement(3);
		Testutils.scroll_bottom();
		Testutils.waitForElement(1);
		Testutils.clickOnElement(resetBtn);
		Testutils.waitForElement(1);
		Testutils.scroll_top();
		Testutils.waitForElement(3);
	}
	
	public void selectDropdownOption(String value)
	{
		WebElement element = driver.findElement(By.xpath(pathOfElement+value+"')]"));
		element.click();
	}
	
	
	public void fillAllFieldsValue() throws Exception
	{
		PageFactory.initElements(driver, this);
		Testutils.waitForElement(15);
		Testutils.scroll_top();
		Testutils.waitForElement(5);
		venFName.sendKeys(prop.getProperty("FName"));
		venLName.sendKeys(prop.getProperty("LName"));
		venEmail.sendKeys(prop.getProperty("username"));
		venCompany.sendKeys(prop.getProperty("VenComp"));
		venProgOfInterest.sendKeys(prop.getProperty("ProgramInterest"));
		venProgOfExp.sendKeys(prop.getProperty("YearOfExp"));
		
		Testutils.waitForElement(2);
		venVisibilityRadio.click();
		
		venProgGoals.sendKeys(prop.getProperty("Description"));
		
		venUCField.sendKeys("m");
		Testutils.waitForElement(3);
		venUCField.sendKeys("u");
		Testutils.waitForElement(3);
		selectDropdownOption(prop.getProperty("SelectUseCode"));
		Testutils.waitForElement(3);
		
		venRefField.sendKeys("R");
		Testutils.waitForElement(3);
		venRefField.sendKeys("e");
		Testutils.waitForElement(3);
		selectDropdownOption(prop.getProperty("Referral"));
		Testutils.waitForElement(3);
		
		uploadInput.sendKeys(System.getProperty("user.dir")+"\\Files\\dummy.pdf");
		Testutils.waitForElement(2);
		
		Testutils.scroll_bottom();
		Testutils.waitForElement(3);
		
		Testutils.clickOnElement(saveBtn);
		Testutils.waitForElement(15);
		
		Assert.assertTrue(Testutils.checkRedirection("ventures"), "User is redirected on wrong url after completion of the Innovation form");
		
	}
	
	public void uploadFile() throws Exception
	{
		PageFactory.initElements(driver, this);
		
		Testutils.waitForElement(5);
		Testutils.scroll_bottom();
		Testutils.waitForElement(3);
		uploadInput.sendKeys(System.getProperty("user.dir")+"\\Files\\dummy.pdf");
		Testutils.waitForElement(2);
		
		Testutils.clickOnElement(deleteIconOfUploadFile);
		Testutils.waitForElement(3);
		Testutils.clickOnElement(cancelBtnFromDeletePopup);
		Testutils.waitForElement(2);
		Testutils.clickOnElement(deleteIconOfUploadFile);
		Testutils.waitForElement(3);
		Testutils.clickOnElement(deleteBtnFromDeletePopup);
		//uploadInput.click();
		//PressTab();
		
		Testutils.waitForElement(3);
		driver.navigate().refresh();
		
	}

}
