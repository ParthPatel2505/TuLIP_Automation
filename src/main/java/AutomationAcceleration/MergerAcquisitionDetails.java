package AutomationAcceleration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import MenuOrHeaderPanel.MenuOrHeaderPanel;
import base.TestBase;
import utils.Testutils;

public class MergerAcquisitionDetails extends TestBase
{
	MenuOrHeaderPanel clickOnPlusIcon = new MenuOrHeaderPanel();
	
	public @FindBy(xpath = "//*[@type='submit']")
	WebElement saveBtn;
	public @FindBy(xpath = "//*[@type='button']/span[text()='Reset']")
	WebElement resetBtn;
	public @FindBy(xpath = "//*[@type='button']/span[text()='Cancel']")
	WebElement cancelBtn;
	@FindBy(xpath = "//*[@id='merger.title']")
	WebElement CompName;
	@FindBy(xpath = "//*[@id='Website']")
	WebElement webSite;
	@FindBy(xpath = "//div[@name='domainDto']")
	WebElement domain;
	@FindBy(xpath = "//div[@name='domainDto']//*/input[@role='combobox']")
	WebElement domainField;
	@FindBy(xpath = "//div[@name='countryDetails']")
	WebElement country;
	@FindBy(xpath = "//div[@name='countryDetails']//*/input[@role='combobox']")
	WebElement countryField;
	@FindBy(xpath = "//*[@id='merger.type']")
	WebElement type;
	@FindBy(xpath = "//*[@type='radio' and @value='0']")
	WebElement publicRadioBtn;
	@FindBy(xpath = "(//div[@contenteditable='true'])[1]")
	WebElement basicDetails;
	@FindBy(xpath = "(//div[@contenteditable='true'])[2]")
	WebElement marketPotential;
	@FindBy(xpath = "(//div[@contenteditable='true'])[3]")
	WebElement propPotential;
	@FindBy(xpath = "(//div[@contenteditable='true'])[4]")
	WebElement techRequirement;
	@FindBy(xpath = "(//div[@contenteditable='true'])[5]")
	WebElement compRegulatory;
	@FindBy(xpath = "(//div[@contenteditable='true'])[6]")
	WebElement businessModel;
	@FindBy(xpath = "//*[contains(@class,'upload')]/input")
	WebElement uploadInput;
	@FindBy(xpath = "//button[@aria-label='delete']")
	WebElement deleteIconOfUploadFile;
	@FindBy(xpath = "//button[@type='button']//*[contains(text(),'Delete')]")
	WebElement deleteBtnFromDeletePopup;
	@FindBy(xpath = "(//button[@type='button']//*[contains(text(),'Cancel')])[2]")
	WebElement cancelBtnFromDeletePopup;
	
	public @FindBy(xpath = "//span[contains(@class,'danger') and contains(text(),'Title')]")
	WebElement validationCompName;
	public @FindBy(xpath = "//span[contains(@class,'danger') and contains(text(),'Website')]")
	WebElement validationWebsite;
	public @FindBy(xpath = "//span[contains(@class,'danger') and contains(text(),'Domain')]")
	WebElement validationDomain;
	public @FindBy(xpath = "//span[contains(@class,'danger') and contains(text(),'Country')]")
	WebElement validationCountry;
	public @FindBy(xpath = "//span[contains(@class,'danger') and contains(text(),'radio button')]")
	WebElement validationVisibility;
	public @FindBy(xpath = "//span[contains(@class,'danger') and contains(text(),'Basic Details')]")
	WebElement validationBasicDetails;
	
	
	public MergerAcquisitionDetails() {
		PageFactory.initElements(driver, this);
	}
	
	public void openMergerAcqForm() throws Exception
	{
		PageFactory.initElements(driver, this);
		clickOnPlusIcon.openMergerAcqFromPlusMenuFromHeader();
	}
	
	public boolean validationMessageDisplay(WebElement element)
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
	
	public void validationCheckOnField()throws Exception
	{
		PageFactory.initElements(driver, this);
		Testutils.waitForElement(3);
		Testutils.scroll_bottom();
		Testutils.waitForElement(1);
	    saveBtn.click();
		Testutils.waitForElement(1);
		Testutils.scroll_top();
		Testutils.waitForElement(3);
		Assert.assertTrue(validationMessageDisplay(validationCompName), "Validation is not get display on field");
		Assert.assertTrue(validationMessageDisplay(validationWebsite), "Validation is not get display on field");
		Assert.assertTrue(validationMessageDisplay(validationDomain), "Validation is not get display on field");
		Assert.assertTrue(validationMessageDisplay(validationCountry), "Validation is not get display on field");
		Assert.assertTrue(validationMessageDisplay(validationVisibility), "Validation is not get display on field");
		Assert.assertTrue(validationMessageDisplay(validationBasicDetails), "Validation is not get display on field");
		
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
		String pathOfElement = "//div[contains(text(),'";
		WebElement element =  driver.findElement(By.xpath(pathOfElement+value+"')]"));
		element.click();
	}
	
	
	public void fillTheForm() throws Exception
	{
		PageFactory.initElements(driver, this);
		Testutils.waitForElement(10);
		Testutils.scroll_top();
		Testutils.waitForElement(5);
		CompName.sendKeys(prop.getProperty("Title"));
		
		webSite.sendKeys(prop.getProperty("ReferenceLink"));
		Testutils.waitForElement(3);
		
		domain.click();
		Testutils.waitForElement(3);
		domainField.sendKeys("A");
		Testutils.waitForElement(3);
		domainField.sendKeys("I");
		Testutils.waitForElement(3);
		//selectDropdownOption(prop.getProperty("MergeDomain"));
		Testutils.PressDown();
		Testutils.PressEnter();
		Testutils.waitForElement(3);
		
		countryField.sendKeys("i");
		Testutils.waitForElement(3);
		countryField.sendKeys("n");
		Testutils.waitForElement(3);
		countryField.sendKeys("d");
		Testutils.waitForElement(3);
		selectDropdownOption(prop.getProperty("Country"));
		Testutils.waitForElement(3);
		
		type.click();
		Testutils.PressDown();
		Testutils.PressEnter();
		Testutils.waitForElement(3);
		
		publicRadioBtn.click();
		
		basicDetails.sendKeys(prop.getProperty("Description"));
		marketPotential.sendKeys(prop.getProperty("Description"));
		propPotential.sendKeys(prop.getProperty("Description"));
		techRequirement.sendKeys(prop.getProperty("Description"));
		compRegulatory.sendKeys(prop.getProperty("Description"));
		businessModel.sendKeys(prop.getProperty("Description"));
		
		
		uploadInput.sendKeys(System.getProperty("user.dir")+"\\Files\\dummy.pdf");
		Testutils.waitForElement(2);
		
		Testutils.scroll_bottom();
		Testutils.waitForElement(3);
		
		Testutils.clickOnElement(saveBtn);
		Testutils.waitForElement(20);
		
		//Assert.assertTrue(Testutils.checkRedirection("innovation"), "User is redirected on wrong url after completion of the Innovation form");
		
	}
	
	public void uploadFileInForm() throws Exception
	{
		PageFactory.initElements(driver, this);
		
		Testutils.waitForElement(2);
		Testutils.scroll_bottom();
		Testutils.waitForElement(3);
		uploadInput.sendKeys(System.getProperty("user.dir")+"\\Files\\dummy.pdf");
		Testutils.waitForElement(2);
		
		Testutils.clickOnElement(deleteIconOfUploadFile);
		Testutils.waitForElement(3);
		Testutils.clickOnElement(cancelBtnFromDeletePopup);
		Testutils.waitForElement(3);
		Testutils.clickOnElement(deleteIconOfUploadFile);
		Testutils.waitForElement(3);
		Testutils.clickOnElement(deleteBtnFromDeletePopup);
		//uploadInput.click();
		//PressTab();
		
		Testutils.waitForElement(3);
		driver.navigate().refresh();
		
	}
}
