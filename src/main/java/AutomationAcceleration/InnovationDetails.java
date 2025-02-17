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
import utils.Testutils;


public class InnovationDetails extends Loginpage
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
	public @FindBy(xpath = "//*[@class='ant-typography ant-typography-danger css-7ynt2h' and contains(text(),'Title')]")
	WebElement validationOnInnovationTitle;
	public @FindBy(xpath = "//*[@class='ant-typography ant-typography-danger css-7ynt2h' and contains(text(),'Domain')]")
	WebElement validationOnInnovationDomain;
	public @FindBy(xpath = "//*[@class='ant-typography ant-typography-danger css-7ynt2h' and contains(text(),'Country')]")
	WebElement validationOnInnovationCountry;
	public @FindBy(xpath = "//*[@class='ant-typography ant-typography-danger css-7ynt2h' and contains(text(),'Use Case')]")
	WebElement validationOnInnovationUseCase;
	public @FindBy(xpath = "//*[@class='ant-typography ant-typography-danger css-7ynt2h' and contains(text(),'radio')]")
	WebElement validationOnInnovationVisibility;
	public @FindBy(xpath = "//*[@class='ant-typography ant-typography-danger css-7ynt2h' and contains(text(),'Innovation')]")
	WebElement validationOnInnovationInnovation;
	public @FindBy(xpath = "//*[@class='ant-typography ant-typography-danger css-7ynt2h' and contains(text(),'Market')]")
	WebElement validationOnInnovationMarket;
	public @FindBy(xpath = "//*[@class='ant-typography ant-typography-danger css-7ynt2h' and contains(text(),'IP')]")
	WebElement validationOnInnovationIPPote;
	public @FindBy(xpath = "//*[@class='ant-typography ant-typography-danger css-7ynt2h' and contains(text(),'Technology')]")
	WebElement validationOnInnovationTechnology;
	public @FindBy(xpath = "//*[@class='ant-typography ant-typography-danger css-7ynt2h' and contains(text(),'Compliance')]")
	WebElement validationOnInnovationCompliance;
	public @FindBy(xpath = "//*[@class='ant-typography ant-typography-danger css-7ynt2h' and contains(text(),'Business')]")
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
	@FindBy(xpath = "//div[@class='ant-row css-7ynt2h']/div[1]//*[@class='form-field w-100']/div/div/div[2]/div[@contenteditable='true']")
	WebElement innovationInnovation;
	@FindBy(xpath = "//div[@class='ant-row css-7ynt2h']/div[2]//*[@class='form-field w-100']/div/div/div[2]/div[@contenteditable='true']")
	WebElement innovationMarket;
	@FindBy(xpath = "//div[@class='ant-row css-7ynt2h']/div[3]//*[@class='form-field w-100']/div/div/div[2]/div[@contenteditable='true']")
	WebElement innovationIPPote;
	@FindBy(xpath = "//div[@class='ant-row css-7ynt2h']/div[4]//*[@class='form-field w-100']/div/div/div[2]/div[@contenteditable='true']")
	WebElement innovationTech;
	@FindBy(xpath = "//div[@class='ant-row css-7ynt2h']/div[5]//*[@class='form-field w-100']/div/div/div[2]/div[@contenteditable='true']")
	WebElement innovationCom;
	@FindBy(xpath = "//div[@class='ant-row css-7ynt2h']/div[6]//*[@class='form-field w-100']/div/div/div[2]/div[@contenteditable='true']")
	WebElement innovationBus;
	@FindBy(xpath = "//div[@class='rc-virtual-list-holder']")
	WebElement dropdownList;
	@FindBy(xpath = "//div[@role='presentation']/input")
	WebElement uploadInput;
	@FindBy(xpath = "//*[@class='ant-flex css-7ynt2h ant-flex-justify-space-between']/button")
	WebElement deleteIconOfUploadFile;
	@FindBy(xpath = "//button[@type='button']/p[contains(text(),'Delete')]")
	WebElement deleteBtnFromDeletePopup;
	@FindBy(xpath = "//button[@type='button']/p[contains(text(),'Cancel')]")
	WebElement cancelBtnFromDeletePopup;
	
	
	String pathOfElement = "//div[contains(text(),'";
	
	
	public InnovationDetails() {
		PageFactory.initElements(driver, this);
	}
	
	public void openInnovationForm() throws Exception
	{
		clickOnPlus.openPlusMenuFromHeader();
	}

	public void checkValidation() throws Exception
	{
		testutil.waitForElement(5);
		ElementOnClick(saveBtn);
	
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
		waitForElement(3);
		scroll_bottom();
		waitForElement(1);
		checkValidation();
		waitForElement(1);
		scroll_top();
		waitForElement(3);
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
		
		waitForElement(3);
		scroll_bottom();
		waitForElement(1);
		ElementOnClick(resetBtn);
		waitForElement(1);
		scroll_top();
		waitForElement(3);
	}
	
	public void selectDropdownOption(String value)
	{
		WebElement element =  driver.findElement(By.xpath(pathOfElement+value+"')]"));
		element.click();
	}
	
	
	public void fillAllFieldsValue() throws Exception
	{
		PageFactory.initElements(driver, this);
		waitForElement(15);
		scroll_top();
		waitForElement(5);
		innovationTitle.sendKeys(prop.getProperty("InnovationTitle"));
		
		innovationTheme.click();
		waitForElement(3);
		selectDropdownOption(prop.getProperty("Theme"));
		waitForElement(3);
		
		innovationDomain.click();
		waitForElement(3);
		selectDropdownOption(prop.getProperty("Domain"));
		waitForElement(3);
		
		innovationRefLink.sendKeys(prop.getProperty("ReferenceLink"));
		
		innovationTagsField.sendKeys("a");
		waitForElement(3);
		innovationTagsField.sendKeys("r");
		waitForElement(3);
		selectDropdownOption(prop.getProperty("Tags"));
		waitForElement(3);
		
		innovationCountryField.sendKeys("i");
		waitForElement(3);
		innovationCountryField.sendKeys("n");
		waitForElement(3);
		innovationCountryField.sendKeys("d");
		waitForElement(3);
		selectDropdownOption(prop.getProperty("Country"));
		waitForElement(3);
		
		innovationUCField.sendKeys("m");
		waitForElement(3);
		innovationUCField.sendKeys("u");
		waitForElement(3);
		selectDropdownOption(prop.getProperty("SelectUseCode"));
		waitForElement(3);
		
		innovationVisibilityRadio.click();
		innovationInnovation.sendKeys(prop.getProperty("Description"));
		innovationMarket.sendKeys(prop.getProperty("Description"));
		innovationIPPote.sendKeys(prop.getProperty("Description"));
		innovationTech.sendKeys(prop.getProperty("Description"));
		innovationCom.sendKeys(prop.getProperty("Description"));
		innovationBus.sendKeys(prop.getProperty("Description"));
		
		
		uploadInput.sendKeys("C:/Users/Vatsal BT210 QA/Pictures/images.png");
		waitForElement(2);
		
		scroll_bottom();
		waitForElement(3);
		
		ElementOnClick(saveBtn);
		waitForElement(10);
		
		Assert.assertTrue(checkRedirection("ticket-viewall"), "User is redirected on wrong url after completion of the Innovation form");
		
	}
	
	public void uploadFile() throws Exception
	{
		PageFactory.initElements(driver, this);
		
		waitForElement(2);
		scroll_bottom();
		waitForElement(3);
		uploadInput.sendKeys("C:/Users/Vatsal BT210 QA/Pictures/images.png");
		waitForElement(2);
		
		ElementOnClick(deleteIconOfUploadFile);
		ElementOnClick(cancelBtnFromDeletePopup);
		waitForElement(2);
		ElementOnClick(deleteIconOfUploadFile);
		ElementOnClick(deleteBtnFromDeletePopup);
		//uploadInput.click();
		//PressTab();
		
		waitForElement(3);
		driver.navigate().refresh();
		
	}
	
}
