package AutomationAcceleration;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.Assertion;

import LoginModule.Loginpage;
import MenuOrHeaderPanel.MenuOrHeaderPanel;
import base.TestBase;
import utils.Testutils;

public class EngineeringDetails extends TestBase
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
	@FindBy(xpath = "//*[contains(@class,'danger') and contains(text(),'Company Name')]")
	WebElement validationOnEngCompName;
	@FindBy(xpath = "(//*[contains(@class,'danger') and contains(text(),'given list')])[1]")
	WebElement validationOnEngDomain;
    @FindBy(xpath = "//*[contains(@class,'danger') and contains(text(),'Use Case')]")
	WebElement validationOnEngUseCase;
    @FindBy(xpath = "//*[contains(@class,'danger') and contains(text(),'Project Name')]")
	WebElement validationOnEngProjName;
    @FindBy(xpath = "//*[contains(@class,'danger') and contains(text(),'radio')]")
	WebElement validationOnEngVisibility;
    @FindBy(xpath = "//*[contains(@class,'danger') and contains(text(),'Full Name')]")
	WebElement validationOnEngFullName;
    @FindBy(xpath = "//*[contains(@class,'danger') and contains(text(),'Email')]")
	WebElement validationOnEngEmail;
	@FindBy(xpath = "//*[contains(@class,'danger') and contains(text(),'Country')]")
	WebElement validationOnEngCountry;
	@FindBy(xpath = "(//*[contains(@class,'danger') and contains(text(),'given list')])[2]")
	WebElement validationOnSource;
	@FindBy(xpath = "//*[contains(@class,'danger') and contains(text(),'Description')]")
	WebElement validationOnEngSerDesc;
	@FindBy(xpath = "//*[contains(@class,'danger') and contains(text(),'Scope')]")
	WebElement validationOnEngSerScope;
	
	//fields
	@FindBy(xpath = "//*[@data-testid='engineeringService.companyNameLabel']")
	WebElement engCompName;
	@FindBy(xpath = "//div[@name='domainDto']")
	WebElement engDomain;
    @FindBy(xpath = "//div[@name='useCases']")
	WebElement engUseCase;
	@FindBy(xpath = "//div[@name='useCases']//*/input[@role='combobox']")
	WebElement engUCField;
    @FindBy(xpath = "//*[@data-testid='engineeringService.projectNameLabel']")
	WebElement engProjName;
    @FindBy(xpath = "(//*[@type='radio' and @value='0'])[1]")
	WebElement engVisibilityRadio;
    @FindBy(xpath = "//*[@data-testid='engineeringService.fullNameLabel']")
	WebElement engFullName;
    @FindBy(xpath = "//*[@data-testid='engineeringService.emailLabel']")
	WebElement engEmail;
    @FindBy(xpath = "//*[@data-testid='engineeringService.phoneLabel']")
	WebElement engPhone;
    @FindBy(xpath = "//div[@name='countryDetails']")
	WebElement engCountry;
	@FindBy(xpath = "//div[@name='countryDetails']//*/input[@role='combobox']")
	WebElement engCountryField;
    @FindBy(xpath = "//div[@name='sourceDto']")
	WebElement engSource;
	@FindBy(xpath = "//div[@name='sourceDto']//*/input[@role='combobox']")
	WebElement engSourceField;
    @FindBy(xpath = "(//*[@type='radio' and @value='1'])[2]")
	WebElement engServiceRadio;
    @FindBy(xpath = "(//div[@contenteditable='true'])[1]")
	WebElement engSerDesc;
    @FindBy(xpath = "(//div[@contenteditable='true'])[2]")
	WebElement engSerScope;

    @FindBy(xpath = "//div[@class='rc-virtual-list-holder']")
	WebElement dropdownList;
	@FindBy(xpath = "//div[@role='presentation']/input")
	WebElement uploadInput;
	@FindBy(xpath = "//button[@aria-label='delete']")
	WebElement deleteIconOfUploadFile;
	@FindBy(xpath = "//button[@type='button']/p[contains(text(),'Delete')]")
	WebElement deleteBtnFromDeletePopup;
	@FindBy(xpath = "//button[@type='button']/p[contains(text(),'Cancel')]")
	WebElement cancelBtnFromDeletePopup;
    
	String pathOfElement = "//div[contains(text(),'";
	
	public EngineeringDetails() {
		PageFactory.initElements(driver, this);
	}
	
    public void openEngFormFromPlus() throws Exception
	{
		clickOnPlus.openEngFromPlusMenuFromHeader();
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
		Assert.assertTrue(validationMessage(validationOnEngCompName), "Validation is not get display on field");
		Assert.assertTrue(validationMessage(validationOnEngDomain), "Validation is not get display on field");
		Assert.assertTrue(validationMessage(validationOnEngUseCase), "Validation is not get display on field");
		Assert.assertTrue(validationMessage(validationOnEngProjName), "Validation is not get display on field");
		Assert.assertTrue(validationMessage(validationOnEngVisibility), "Validation is not get display on field");
		Assert.assertTrue(validationMessage(validationOnEngFullName), "Validation is not get display on field");
		Assert.assertTrue(validationMessage(validationOnEngEmail), "Validation is not get display on field");
		Assert.assertTrue(validationMessage(validationOnEngCountry), "Validation is not get display on field");
		Assert.assertTrue(validationMessage(validationOnSource), "Validation is not get display on field");
		Assert.assertTrue(validationMessage(validationOnEngSerDesc), "Validation is not get display on field");
		Assert.assertTrue(validationMessage(validationOnEngSerScope), "Validation is not get display on field");
		
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
		WebElement element =  driver.findElement(By.xpath(pathOfElement+value+"')]"));
		element.click();
	}
	
	
	public void fillAllFieldsValue() throws Exception
	{
		PageFactory.initElements(driver, this);
		Testutils.waitForElement(15);
		Testutils.scroll_top();
		Testutils.waitForElement(5);
		engCompName.sendKeys(prop.getProperty("Title"));
		
		engDomain.click();
		Testutils.waitForElement(3);
		//selectDropdownOption(prop.getProperty("Domain"));
		Testutils.PressDown();
		Testutils.PressEnter();
		Testutils.waitForElement(3);
		
		engUCField.sendKeys("m");
		Testutils.waitForElement(3);
		engUCField.sendKeys("u");
		Testutils.waitForElement(3);
		selectDropdownOption(prop.getProperty("SelectUseCode"));
		Testutils.waitForElement(3);
		
		/*innovationTagsField.sendKeys("a");
		Testutils.waitForElement(3);
		innovationTagsField.sendKeys("r");
		Testutils.waitForElement(3);
		selectDropdownOption(prop.getProperty("Tags"));
		Testutils.waitForElement(3);*/
		
		Testutils.waitForElement(5);
		engProjName.sendKeys(prop.getProperty("Title"));
		
		Testutils.waitForElement(2);
		engVisibilityRadio.click();
		
		Testutils.waitForElement(5);
		engFullName.sendKeys(prop.getProperty("FullName"));
		
		Testutils.waitForElement(5);
		engEmail.sendKeys(prop.getProperty("username"));
		
		Testutils.waitForElement(5);
		engPhone.sendKeys(prop.getProperty("Phone"));
		
		engCountryField.sendKeys("i");
		Testutils.waitForElement(3);
		engCountryField.sendKeys("n");
		Testutils.waitForElement(3);
		engCountryField.sendKeys("d");
		Testutils.waitForElement(3);
		selectDropdownOption(prop.getProperty("Country"));
		Testutils.waitForElement(3);
		
		engSourceField.sendKeys("O");
		Testutils.waitForElement(3);
		engSourceField.sendKeys("t");
		Testutils.waitForElement(3);
		engSourceField.sendKeys("h");
		Testutils.waitForElement(3);
		//selectDropdownOption(prop.getProperty("Source"));
		Testutils.PressDown();
		Testutils.PressEnter();
		Testutils.waitForElement(2);
		//Testutils.PressTab();
		Testutils.PressESC();
		//Testutils.Scroll_to_element(engServiceRadio);
		Testutils.waitForElement(3);
		
		//engServiceRadio.click();
		//Testutils.waitForElement(3);
		
		engSerDesc.sendKeys(prop.getProperty("Description"));
		engSerScope.sendKeys(prop.getProperty("Description"));
		
		uploadInput.sendKeys(System.getProperty("user.dir")+"\\Files\\dummy.pdf");
		Testutils.waitForElement(2);
		
		Testutils.scroll_bottom();
		Testutils.waitForElement(3);
		
		Testutils.clickOnElement(saveBtn);
		Testutils.waitForElement(15);
		
		Assert.assertTrue(Testutils.checkRedirection("engineering"), "User is redirected on wrong url after completion of the Innovation form");
		
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
		Testutils.clickOnElement(cancelBtnFromDeletePopup);
		Testutils.waitForElement(2);
		Testutils.clickOnElement(deleteIconOfUploadFile);
		Testutils.clickOnElement(deleteBtnFromDeletePopup);
		//uploadInput.click();
		//PressTab();
		
		Testutils.waitForElement(3);
		driver.navigate().refresh();
		
	}
}