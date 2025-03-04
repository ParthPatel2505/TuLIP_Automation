package ProfilePages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.TestBase;
import utils.Testutils;

public class Experience extends TestBase {

	public Experience() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[normalize-space()='Experience']")
	WebElement Experience_txt;
	@FindBy(xpath="//div[@class='d-flex justify-content-between cardHeader']//*[name()='svg']")
	WebElement Plus_icn;
	@FindBy(xpath="//button[normalize-space()='Cancel']")
	WebElement Cancel_btn;
	@FindBy(xpath="//button[normalize-space()='Save']")
	WebElement Save_btn;
	@FindBy(xpath="(//input[@class=\"react-select__input\"])[1]")
	WebElement Jobtitle_ddl;
	@FindBy(xpath="(//input[@class=\"react-select__input\"])[2]")
	WebElement Company_ddl;
	@FindBy(xpath="(//input[@class=\"react-select__input\"])[3]")
	WebElement Location_ddl;
	@FindBy(xpath="(//input[@class=\"react-select__input\"])[4]")
	WebElement Skills_ddl;
	@FindBy(xpath="//input[@type='checkbox']")
	WebElement Chk_box;
	@FindBy(xpath="//div[@class='card']//div[1]//div[1]//div[1]//div[1]//div[1]//div[2]//div[1]//*[name()='svg']")
	WebElement StartMonth_ddl;
	@FindBy(xpath="//div[@class='card']//div[1]//div[1]//div[2]//div[1]//div[1]//div[2]//div[1]//*[name()='svg']")
	WebElement StartYear_ddl;
	@FindBy(xpath="//span[@required or normalize-space()='End Date required']")
	List<WebElement> Required_fields;
	@FindBy(xpath="//*[@Disabled]")
	List<WebElement> Disabled_fields;
	@FindBy(xpath="//div[@class='react-select__indicator react-select__clear-indicator css-1xc3v61-indicatorContainer']//*[name()='svg']//*[name()='path' and contains(@d,'M14.348 14')]")
	WebElement SkillsClose_Icn;
	
	public void navigateToExperience() throws InterruptedException {
		Testutils.scrollUsingAction(Experience_txt);
		Thread.sleep(2000);
		Experience_txt.click();
		Thread.sleep(2000);
		Plus_icn.click();
	}

	public void disabledFields() throws InterruptedException {
		Testutils.scrollUsingAction(Save_btn);
		Thread.sleep(1000);
		Save_btn.click();
		for (WebElement Element : Disabled_fields) {
			System.out.println("Tag: " + Element.getTagName() + ", Name: " + Element.getAttribute("name") + ", ID: "
					+ Element.getAttribute("id"));
		}
		System.out.println("Total disabled fields found : " + Disabled_fields.size());
		Assert.assertEquals(Disabled_fields.size(), 0);
	}

	public void requiredFields() {
		for (WebElement Element : Required_fields) {
			System.out.println("Tag: " + Element.getTagName() + ", Name: " + Element.getAttribute("name") + ", ID: "
					+ Element.getAttribute("id"));
		}
		System.out.println("Total required fields found : " + Required_fields.size());
		Assert.assertEquals(Required_fields.size(), 4);
	}
	
	public void fillTheDetails() throws InterruptedException {
	
		Thread.sleep(2000);
		Jobtitle_ddl.sendKeys("Automation Test Engineer");
		Thread.sleep(2000);
		Testutils.PressEnter();
		Company_ddl.sendKeys("Tntra");
		Testutils.PressEnter();
		Thread.sleep(2000);
		StartYear_ddl.click();
		Thread.sleep(2000);
		selectFromDdl("//div[@class=\"react-select__menu css-1nmdiq5-menu\"]/div/div","2024");
		Thread.sleep(2000);
		StartMonth_ddl.click();
		Thread.sleep(2000);
		selectFromDdl("//div[@class=\"react-select__menu css-1nmdiq5-menu\"]/div/div","February");
		Chk_box.click();
		Location_ddl.sendKeys("Australia");
		Testutils.PressEnter();
		Skills_ddl.sendKeys("Selenium with Java");
		Testutils.PressEnter();
		Thread.sleep(1000);
		Save_btn.click();
		
	}

	public static void selectFromDdl(String xpath, String Value)
	{
		List<WebElement> list = driver.findElements(By.xpath(xpath));
		
		for(int i=0;i< list.size();)
		{
			String fetchValue = list.get(i).getText();
		if(fetchValue.equals(Value)) {
			String makexpath = xpath + "[" + (i+1) + "]";
			driver.findElement(By.xpath(makexpath)).click();
			break;
		}
		else
		{
			i++;
		}
	}
	}
	
}
