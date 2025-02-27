package AutomationAcceleration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import LoginModule.Loginpage;
import MenuOrHeaderPanel.MenuOrHeaderPanel;
import base.TestBase;
import utils.Testutils;


public class InnovationDetails extends TestBase
{
	Testutils<Object> testutil = new Testutils<Object>();
	Loginpage lp = new Loginpage();
	MenuOrHeaderPanel clickOnPlus = new MenuOrHeaderPanel();
	
	public @FindBy(xpath = "//*[@type='submit']")
	WebElement saveBtn;
	public @FindBy(xpath = "//*[@type='button']/span[text()='Reset']")
	WebElement resetBtn;
	public @FindBy(xpath = "//*[@type='button']/span[text()='Cancel']")
	WebElement cancelBtn;
	public @FindBy(xpath = "//*[contains(@class,'danger') and contains(text(),'Title')]")
	WebElement validationOnInnovationTitle;
	public @FindBy(xpath = "//*[contains(@class,'danger') and contains(text(),'Domain')]")
	WebElement validationOnInnovationDomain;
	public @FindBy(xpath = "//*[contains(@class,'danger') and contains(text(),'Country')]")
	WebElement validationOnInnovationCountry;
	public @FindBy(xpath = "//*[contains(@class,'danger') and contains(text(),'Use Case')]")
	WebElement validationOnInnovationUseCase;
	public @FindBy(xpath = "//*[contains(@class,'danger') and contains(text(),'radio')]")
	WebElement validationOnInnovationVisibility;
	public @FindBy(xpath = "//*[contains(@class,'danger') and contains(text(),'Innovation')]")
	WebElement validationOnInnovationInnovation;
	public @FindBy(xpath = "//*[contains(@class,'danger') and contains(text(),'Market')]")
	WebElement validationOnInnovationMarket;
	public @FindBy(xpath = "//*[contains(@class,'danger') and contains(text(),'IP')]")
	WebElement validationOnInnovationIPPote;
	public @FindBy(xpath = "//*[contains(@class,'danger') and contains(text(),'Technology')]")
	WebElement validationOnInnovationTechnology;
	public @FindBy(xpath = "//*[contains(@class,'danger') and contains(text(),'Compliance')]")
	WebElement validationOnInnovationCompliance;
	public @FindBy(xpath = "//*[contains(@class,'danger') and contains(text(),'Business')]")
	WebElement validationOnInnovationBusiness;
	
	@FindBy(xpath = "//*[@id='ideas.ideaTitle']")
	WebElement innovationTitle;
	@FindBy(xpath = "//div[@name='campaign']")
	WebElement innovationTheme;
	@FindBy(xpath = "//div[@name='domainDto']")
	WebElement innovationDomain;
	@FindBy(xpath = "//*[@id='ideas.referenceLink']")
	WebElement innovationRefLink;
	@FindBy(xpath = "//div[@name='tagMasterDtos']")
	WebElement innovationTags;
	@FindBy(xpath = "//div[@name='tagMasterDtos']//*/input[@role='combobox']")
	WebElement innovationTagsField;
	@FindBy(xpath = "//div[@name='countryDetails']")
	WebElement innovationCountry;
	@FindBy(xpath = "//div[@name='countryDetails']//*/input[@role='combobox']")
	WebElement innovationCountryField;
	@FindBy(xpath = "//div[@name='useCases']")
	WebElement innovationUseCase;
	@FindBy(xpath = "//div[@name='useCases']//*/input[@role='combobox']")
	WebElement innovationUCField;
	@FindBy(xpath = "//*[@type='radio' and @value='0']")
	WebElement innovationVisibilityRadio;
	@FindBy(xpath = "(//div[@contenteditable='true'])[1]")
	WebElement innovationInnovation;
	@FindBy(xpath = "(//div[@contenteditable='true'])[2]")
	WebElement innovationMarket;
	@FindBy(xpath = "(//div[@contenteditable='true'])[3]")
	WebElement innovationIPPote;
	@FindBy(xpath = "(//div[@contenteditable='true'])[4]")
	WebElement innovationTech;
	@FindBy(xpath = "(//div[@contenteditable='true'])[5]")
	WebElement innovationCom;
	@FindBy(xpath = "(//div[@contenteditable='true'])[6]")
	WebElement innovationBus;
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
	
	
	
	
	
	public InnovationDetails() {
		PageFactory.initElements(driver, this);
	}
	
	public void openInnovationForm() throws Exception
	{
		PageFactory.initElements(driver, this);
		clickOnPlus.openInnovationFromPlusMenuFromHeader();
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
		Assert.assertTrue(validationMessage(validationOnInnovationTitle), "Validation is not get display on field");
		Assert.assertTrue(validationMessage(validationOnInnovationDomain), "Validation is not get display on field");
		Assert.assertTrue(validationMessage(validationOnInnovationCountry), "Validation is not get display on field");
		Assert.assertTrue(validationMessage(validationOnInnovationUseCase), "Validation is not get display on field");
		Assert.assertTrue(validationMessage(validationOnInnovationVisibility), "Validation is not get display on field");
		Assert.assertTrue(validationMessage(validationOnInnovationInnovation), "Validation is not get display on field");
		Assert.assertTrue(validationMessage(validationOnInnovationMarket), "Validation is not get display on field");
		Assert.assertTrue(validationMessage(validationOnInnovationIPPote), "Validation is not get display on field");
		Assert.assertTrue(validationMessage(validationOnInnovationTechnology), "Validation is not get display on field");
		Assert.assertTrue(validationMessage(validationOnInnovationCompliance), "Validation is not get display on field");
		Assert.assertTrue(validationMessage(validationOnInnovationBusiness), "Validation is not get display on field");
		
		Testutils.waitForElement(3);
		Testutils.scroll_bottom();
		Testutils.waitForElement(1);
		Testutils.ElementOnClick(resetBtn);
		Testutils.waitForElement(1);
		Testutils.scroll_top();
		Testutils.waitForElement(3);
	}
	
	public void selectDropdownOption(String value)
	{
		String pathOfElement = "//div[contains(text(),'";
		WebElement element =  driver.findElement(By.xpath(pathOfElement+value+"')]"));
		element.click();
	}
	
	
	public void fillAllFieldsValue() throws Exception
	{
		PageFactory.initElements(driver, this);
		Testutils.waitForElement(10);
		Testutils.scroll_top();
		Testutils.waitForElement(5);
		innovationTitle.sendKeys(prop.getProperty("Title"));
		
		innovationTheme.click();
		Testutils.waitForElement(3);
		selectDropdownOption(prop.getProperty("Theme"));
		Testutils.waitForElement(3);
		
		innovationDomain.click();
		Testutils.waitForElement(3);
		selectDropdownOption(prop.getProperty("Domain"));
		Testutils.waitForElement(3);
		
		innovationRefLink.sendKeys(prop.getProperty("ReferenceLink"));
		
		innovationTagsField.sendKeys("a");
		Testutils.waitForElement(3);
		innovationTagsField.sendKeys("r");
		Testutils.waitForElement(3);
		selectDropdownOption(prop.getProperty("Tags"));
		Testutils.waitForElement(3);
		
		innovationCountryField.sendKeys("i");
		Testutils.waitForElement(3);
		innovationCountryField.sendKeys("n");
		Testutils.waitForElement(3);
		innovationCountryField.sendKeys("d");
		Testutils.waitForElement(3);
		selectDropdownOption(prop.getProperty("Country"));
		Testutils.waitForElement(3);
		
		innovationUCField.sendKeys("m");
		Testutils.waitForElement(3);
		innovationUCField.sendKeys("u");
		Testutils.waitForElement(3);
		selectDropdownOption(prop.getProperty("SelectUseCode"));
		Testutils.waitForElement(3);
		
		innovationVisibilityRadio.click();
		innovationInnovation.sendKeys(prop.getProperty("Description"));
		innovationMarket.sendKeys(prop.getProperty("Description"));
		innovationIPPote.sendKeys(prop.getProperty("Description"));
		innovationTech.sendKeys(prop.getProperty("Description"));
		innovationCom.sendKeys(prop.getProperty("Description"));
		innovationBus.sendKeys(prop.getProperty("Description"));
		
		
		uploadInput.sendKeys("C:\\Vatsal\\Extra\\dummy.pdf");
		Testutils.waitForElement(2);
		
		Testutils.scroll_bottom();
		Testutils.waitForElement(3);
		
		Testutils.ElementOnClick(saveBtn);
		Testutils.waitForElement(20);
		
		Assert.assertTrue(Testutils.checkRedirection("innovation"), "User is redirected on wrong url after completion of the Innovation form");
		
	}
	
	public void uploadFile() throws Exception
	{
		PageFactory.initElements(driver, this);
		
		Testutils.waitForElement(2);
		Testutils.scroll_bottom();
		Testutils.waitForElement(3);
		uploadInput.sendKeys("C:\\Vatsal\\Extra\\dummy.pdf");
		Testutils.waitForElement(2);
		
		Testutils.ElementOnClick(deleteIconOfUploadFile);
		Testutils.ElementOnClick(cancelBtnFromDeletePopup);
		Testutils.waitForElement(2);
		Testutils.ElementOnClick(deleteIconOfUploadFile);
		Testutils.ElementOnClick(deleteBtnFromDeletePopup);
		//uploadInput.click();
		//PressTab();
		
		Testutils.waitForElement(3);
		driver.navigate().refresh();
		
	}
	
}
