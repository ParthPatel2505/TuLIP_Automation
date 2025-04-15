package AutomationAcceleration;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import base.TestBase;
import utils.Testutils;

public class TaskandChallengesDetails extends TestBase
{
	//validations of the fields
	@FindBy(xpath = "//span[contains(@class,'danger') and contains(text(),'Title')]")
	WebElement validationTitle;
	@FindBy(xpath = "//span[contains(@class,'danger') and contains(text(),'Use Case')]")
	WebElement validationUseCase;
	@FindBy(xpath = "//span[contains(@class,'danger') and contains(text(),'Description')]")
	WebElement validationDesc;
	@FindBy(xpath = "//span[contains(@class,'danger') and contains(text(),'Priority')]")
	WebElement validationPriority;
	@FindBy(xpath = "//span[contains(@class,'danger') and contains(text(),'Difficulty')]")
	WebElement validationDiffLevel;
	@FindBy(xpath = "//span[contains(@class,'danger') and contains(text(),'Skills')]")
	WebElement validationSkills;
	@FindBy(xpath = "//span[contains(@class,'danger') and contains(text(),'Manager')]")
	WebElement validationManager;
	
	//Fields
	@FindBy (xpath = "//*[@data-node-key='task']")
	WebElement openTaskTab;
	@FindBy (xpath = "//*[@id='dashboard.orchestration.taskTab.titleLabel']")
	WebElement titleForTasks;
	@FindBy (xpath = "(//*[@id='dashboard.orchestration.taskTab.titleLabel'])[2]")
	WebElement titleForChal;
	@FindBy (xpath = "//div[@name='useCase']//*[@class='ant-select-selection-search-input']")
	WebElement useCaseForTasks;
	@FindBy (xpath = "(//div[@name='useCase'])[2]")
	WebElement useCaseForChal;
	@FindBy (xpath = "//div[@contenteditable='true']")
	WebElement descriptionForTasks;
	@FindBy (xpath = "(//div[@contenteditable='true'])[2]")
	WebElement descriptionForChal;
	@FindBy (xpath = "//*[@id='dashboard.orchestration.taskTab.difficultyLabel']")
	WebElement priority;
	@FindBy (xpath = "//*[@id='dashboard.orchestration.taskTab.level']")
	WebElement diffLevel;
	@FindBy (xpath = "//div[@name='mappedSkillDtos']//*[@class='ant-select-selection-search-input']")
	WebElement skillsForTasks;
	@FindBy (xpath = "(//div[@name='mappedSkillDtos']//*[@class='ant-select-selection-search-input'])[2]")
	WebElement skillsForChal;
	@FindBy (xpath = "//div[@name='assignLabel']//*[@class='ant-select-selection-search-input']")
	WebElement assignUserForTasks;
	@FindBy (xpath = "(//div[@name='assignLabel']//*[@class='ant-select-selection-search-input'])[2]")
	WebElement assignUserForChal;
	@FindBy (xpath = "//div[@name='managerInfo']//*[@class='ant-select-selection-search-input']")
	WebElement managerForTask;
	@FindBy (xpath = "//div[@name='managerUserInfo']//*[@class='ant-select-selection-search-input']")
	WebElement managerForChal;
	@FindBy (xpath = "//*[@id='dashboard.orchestration.taskTab.startDateLabel']")
	WebElement startDateForTasks;
	@FindBy (xpath = "(//*[@id='dashboard.orchestration.taskTab.startDateLabel'])[2]")
	WebElement startDateForChal;
	@FindBy (xpath = "//*[@id='dashboard.orchestration.taskTab.endDateLabel']")
	WebElement endDateForTasks;
	@FindBy (xpath = "(//*[@id='dashboard.orchestration.taskTab.endDateLabel'])[2]")
	WebElement endDateForChal;
	@FindBy (xpath = "//*[@id='dashboard.orchestration.taskTab.timeZoneLabel']")
	WebElement timeZoneForTasks;
	@FindBy (xpath = "(//*[@id='dashboard.orchestration.taskTab.timeZoneLabel'])[2]")
	WebElement timeZoneForChal;
	@FindBy (xpath = "//button[@type='button' and .//span[text()='Cancel']]")
	WebElement cancelBtnForTasks;
	@FindBy (xpath = "(//button[@type='button' and .//span[text()='Cancel']])[2]")
	WebElement cancelBtnForChal;
	@FindBy (xpath = "//button[@type='button' and .//span[text()='Save']]")
	WebElement saveBtnForTasks;
	@FindBy (xpath = "(//button[@type='button' and .//span[text()='Save']])[2]")
	WebElement saveBtnForChal;
	@FindBy (xpath = "//*[@type='button' and @aria-label='Close']")
	WebElement cancelIconForTasks;
	@FindBy (xpath = "(//*[@type='button' and @aria-label='Close'])[2]")
	WebElement cancelIconForChal;
	@FindBy (xpath = "//button[@type='button' and .//*[contains(@class,'pencil')]]")
	WebElement editIcon;
	@FindBy (xpath = "//button[@type='submit']")
	WebElement saveBtn;
	@FindBy (xpath = "//span[text()='Details']")
	WebElement detailsTab;
	@FindBy (xpath = "//span[text()='Tasks']")
	WebElement taskTab;
	@FindBy (xpath = "//span[text()='Challenges']")
	WebElement challengesTab;
	@FindBy (xpath = "(//*[@class='ant-select-selection-item' and contains(@title,'page')])[1]")
	WebElement tableTitleforTasks;
	@FindBy (xpath = "(//*[@class='ant-select-selection-item' and contains(@title,'page')])[2]")
	WebElement tableTitleforChal;
	@FindBy (xpath = "//button[@type='button' and contains(@class,'ant-btn-circle ant-btn-default')]")
	WebElement openAddMenu; 
	@FindBy (xpath = "//li[@role='menuitem' and contains(@data-menu-id,'add')]")
	WebElement addBtn;
	@FindBy (xpath = "//span/*[contains(text(),'Challenges')]")
	WebElement chalOption;
	
	String plusIconList = "//*[@class='ant-dropdown css-7ynt2h ant-dropdown-show-arrow ant-dropdown-placement-bottom']/ul/li";
	

	
	public String currentDate()
	{
		Date today = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String formattedDate = dateFormat.format(today);
		//System.out.println(formattedDate);
		return formattedDate;
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
	
	public void selectDropdownOption(String value)
	{
		String pathOfElement = "//div[contains(text(),'";
		WebElement element =  driver.findElement(By.xpath(pathOfElement+value+"')]"));
		element.click();
	}
	
	public static void selectFromTasksDropdownList(String xPath, String value)
	{
		List<WebElement> liList = driver.findElements(By.xpath(xPath));
		//liList.add(plusIconListinUL);
		
		for(int i=0; i < liList.size();)
		{
			String fetchValue = liList.get(i).getText();
			//System.out.println(fetchValue);
			if(fetchValue.equals(value))
			{
				String makingxPath = xPath + "[" + (i) + "]";
				driver.findElement(By.xpath(makingxPath)).click();
				break;
			}
			else
			{
				i++;
			}
		}
	}
	
	public static void selectFromChallengesDropdownList(String xPath, String value)
	{
		List<WebElement> liList = driver.findElements(By.xpath(xPath));
		//liList.add(plusIconListinUL);
		
		for(int i=0; i < liList.size();)
		{
			String fetchValue = liList.get(i).getText();
			//System.out.println(fetchValue);
			if(fetchValue.equals(value))
			{
				String makingxPath = xPath + "//*[text()='" + value + "']";
				driver.findElement(By.xpath(makingxPath)).click();
				break;
			}
			else
			{
				i++;
			}
		}
	}
	
	public void tasks() throws Exception
	{
		//openTaskTab.click();
		//Testutils.waitForElement(2);
		//Testutils.selectFromMenuList(plusIconList, prop.getProperty("Tasks"));
		taskTab.click();
		Testutils.waitForElement(2);
		openAddMenu.click();
		Testutils.waitForElement(2);
		addBtn.click();
		Testutils.waitForElement(5);
		
		popupforTask();
		
		taskTab.click();
		Testutils.waitForElement(3);
		Assert.assertTrue(validationMessage(tableTitleforTasks), "Tasks is not added.");
		
		
	}

	public void challenges() throws Exception
	{
		Testutils.waitForElement(3);
		challengesTab.click();
		//Testutils.selectFromMenuList(plusIconList, prop.getProperty("Challenges"));
		openAddMenu.click();
		Testutils.waitForElement(2);
		addBtn.click();
		Testutils.waitForElement(5);
		
		popupforChal();
		
		challengesTab.click();
		Testutils.waitForElement(3);
		Assert.assertTrue(validationMessage(tableTitleforChal), "Challenges is not added.");
	}
	
	public void openDetailsTabandClickOnEdit() throws Exception
	{
		//openTaskTab.click();
		//Testutils.waitForElement(2);
		//Testutils.selectFromMenuList(plusIconList, prop.getProperty("Tasks"));
		detailsTab.click();
		Testutils.waitForElement(2);
		editIcon.click();
		Testutils.waitForElement(7);
		Testutils.waitForElement(3);
		Testutils.scroll_bottom();
		Testutils.waitForElement(1);
		Testutils.clickOnElement(saveBtn);
		//saveBtn.click();
		Testutils.waitForElement(5);
	}
	
	public void popupforTask() throws Exception
	{
		Testutils.waitForElement(5);
		cancelIconForTasks.click();
			
		Testutils.waitForElement(3);
		taskTab.click();
		Testutils.waitForElement(2);
		openAddMenu.click();
		Testutils.waitForElement(2);
		addBtn.click();
		
		Testutils.waitForElement(3);
		saveBtnForTasks.click();
		
		Assert.assertTrue(validationMessage(validationTitle), "Validation message is not get appear on field.");
		Assert.assertTrue(validationMessage(validationUseCase), "Validation message is not get appear on field.");
		Assert.assertTrue(validationMessage(validationDesc), "Validation message is not get appear on field.");
		Assert.assertTrue(validationMessage(validationPriority), "Validation message is not get appear on field.");		
		Assert.assertTrue(validationMessage(validationSkills), "Validation message is not get appear on field.");
		Assert.assertTrue(validationMessage(validationManager), "Validation message is not get appear on field.");
		
		Testutils.waitForElement(3);
		cancelBtnForTasks.click();
		Testutils.waitForElement(3);
		
		//openTaskTab.click();
		//Testutils.waitForElement(2);
		//Testutils.selectFromMenuList(plusIconList, prop.getProperty("Tasks"));
		taskTab.click();
		Testutils.waitForElement(2);
		openAddMenu.click();
		Testutils.waitForElement(2);
		addBtn.click();
		Testutils.waitForElement(5);
		
		titleForTasks.sendKeys(prop.getProperty("Title"));
		
		useCaseForTasks.sendKeys("m");
		Testutils.waitForElement(3);
		useCaseForTasks.sendKeys("u");
		Testutils.waitForElement(3);
		selectDropdownOption(prop.getProperty("SelectUseCode"));
		Testutils.waitForElement(3);
		
		descriptionForTasks.sendKeys(prop.getProperty("Description"));
		
		priority.click();
		Testutils.waitForElement(3);
		selectFromTasksDropdownList("//*[@class='rc-virtual-list-holder-inner']/div", prop.getProperty("Priority"));
		Testutils.waitForElement(3);
		
		skillsForTasks.sendKeys("T");
		Testutils.waitForElement(3);
		skillsForTasks.sendKeys("e");
		Testutils.waitForElement(3);
		skillsForTasks.sendKeys("c");
		Testutils.waitForElement(3);
		skillsForTasks.sendKeys("h");
		Testutils.waitForElement(3);
		skillsForTasks.sendKeys("n");
		Testutils.waitForElement(3);
		skillsForTasks.sendKeys("i");
		Testutils.waitForElement(3);
		skillsForTasks.sendKeys("c");
		Testutils.waitForElement(3);
		skillsForTasks.sendKeys("a");
		//selectDropdownOption(prop.getProperty("Skills"));
		Testutils.PressDown();
		Testutils.PressEnter();
		Testutils.waitForElement(3);
		
		assignUserForTasks.sendKeys("z");
		Testutils.waitForElement(3);
		assignUserForTasks.sendKeys("e");
		Testutils.waitForElement(3);
		//selectDropdownOption(prop.getProperty("AssiManUser"));
		Testutils.PressEnter();
		Testutils.waitForElement(4);
		
		//managerForTask.click();
		managerForTask.sendKeys("z");
		Testutils.waitForElement(3);
		managerForTask.sendKeys("e");
		Testutils.waitForElement(3);
		//selectDropdownOption(prop.getProperty("ManUser"));
		Testutils.PressEnter();
		Testutils.waitForElement(3);
			
		startDateForTasks.sendKeys(currentDate());
		Testutils.waitForElement(3);
		
		endDateForTasks.sendKeys(currentDate());
		Testutils.waitForElement(3);
		
		timeZoneForTasks.sendKeys(prop.getProperty("TimeZoneforTaskChallenge"));
		Testutils.waitForElement(3);
		//selectDropdownOption(prop.getProperty("TimeZoneforTaskChallenge"));
		Testutils.PressDown();
		Testutils.waitForElement(3);
		Testutils.PressEnter();
		Testutils.waitForElement(3);
		
		saveBtnForTasks.click();
		Testutils.waitForElement(8);
	}
	
	public void popupforChal() throws Exception
	{
		Testutils.waitForElement(5);
		cancelIconForChal.click();
				
		Testutils.waitForElement(3);
		openAddMenu.click();
		Testutils.waitForElement(2);
		addBtn.click();
		//Testutils.selectFromMenuList(plusIconList, prop.getProperty("Challenges"));
		
		Testutils.waitForElement(3);
		saveBtnForChal.click();
		
		Assert.assertTrue(validationMessage(validationTitle), "Validation message is not get appear on field.");
		Assert.assertTrue(validationMessage(validationUseCase), "Validation message is not get appear on field.");
		Assert.assertTrue(validationMessage(validationDesc), "Validation message is not get appear on field.");
		Assert.assertTrue(validationMessage(validationDiffLevel), "Validation message is not get appear on field.");
		Assert.assertTrue(validationMessage(validationSkills), "Validation message is not get appear on field.");
		Assert.assertTrue(validationMessage(validationManager), "Validation message is not get appear on field.");
		
		Testutils.waitForElement(3);
		cancelBtnForChal.click();
		Testutils.waitForElement(3);
		openAddMenu.click();
		Testutils.waitForElement(2);
		addBtn.click();
		//Testutils.selectFromMenuList(plusIconList, prop.getProperty("Challenges"));
		Testutils.waitForElement(3);
		titleForChal.sendKeys(prop.getProperty("Title"));
		
		useCaseForChal.click();
		Testutils.waitForElement(3);
		Testutils.PressDown();
		Testutils.PressEnter();
		Testutils.waitForElement(3);
		//selectDropdownOption(prop.getProperty("SelectUseCode"));
		
		descriptionForChal.sendKeys(prop.getProperty("Description"));
		
		diffLevel.click();
		Testutils.waitForElement(3);
		selectFromChallengesDropdownList("//*[@class='rc-virtual-list-holder-inner']/div", prop.getProperty("DiffLevel"));
		Testutils.waitForElement(3);
		
		skillsForChal.sendKeys("T");
		Testutils.waitForElement(3);
		skillsForChal.sendKeys("e");
		Testutils.waitForElement(4);
		//selectDropdownOption(prop.getProperty("Skills"));
		Testutils.PressDown();
		Testutils.PressEnter();
		Testutils.waitForElement(3);
		
		assignUserForChal.sendKeys("z");
		Testutils.waitForElement(3);
		assignUserForChal.sendKeys("e");
		Testutils.waitForElement(3);
		//selectDropdownOption(prop.getProperty("AssiManUser"));
		Testutils.PressEnter();
		Testutils.waitForElement(4);
		
		//driver.findElement(By.xpath("(//div[@class='ant-modal-content'])[2]")).click();
		managerForChal.sendKeys("z");
		Testutils.waitForElement(3);
		managerForChal.sendKeys("e");
		Testutils.waitForElement(3);
		//selectDropdownOption(prop.getProperty("ManUser"));
		Testutils.PressEnter();
		Testutils.waitForElement(3);
				
		startDateForChal.sendKeys(currentDate());
		Testutils.waitForElement(3);
		
		endDateForChal.sendKeys(currentDate());
		Testutils.waitForElement(3);
		
		
		timeZoneForChal.sendKeys(prop.getProperty("TimeZoneforTaskChallenge"));
		Testutils.waitForElement(3);
		//selectDropdownOption(prop.getProperty("TimeZoneforTaskChallenge"));
		Testutils.PressDown();
		Testutils.waitForElement(3);
		Testutils.PressEnter();
		Testutils.waitForElement(3);
		
		saveBtnForChal.click();
		Testutils.waitForElement(8);
	}
}
