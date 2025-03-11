package ProfilePages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.TestBase;
import utils.Testutils;

public class Skill extends TestBase {

	public Skill() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[normalize-space()='Skills']")
	WebElement Skill_txt;
	@FindBy(xpath = "//div[@class='d-flex justify-content-between cardHeader']//*[name()='svg']")
	WebElement Edit_icn;
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/main[1]/div[3]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/*[name()='svg'][1]/*[name()='path'][1]")
	WebElement Close_icn;
	@FindBy(xpath = "//input[@class=\"react-select__input\"]")
	WebElement Skill_ddl;
	@FindBy(xpath = "//button[normalize-space()='Cancel']")
	WebElement Cancel_btn;
	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement Save_btn;
	@FindBy(xpath = "//*[@Disabled]")
	List<WebElement> Disabledfields;
	@FindBy(xpath = "//*[@Required]")
	List<WebElement> Requiredfields;

	public void requiredFields() {
		for (WebElement Element : Requiredfields) {
			System.out.println("Tag :" + Element.getTagName() + "ID : " + Element.getAttribute("id") + "Name : "
					+ Element.getAttribute("name") + Element.getAttribute(null));
		}
		System.out.println("Total Requiredfields Found : " + Requiredfields.size());
		Assert.assertEquals(Requiredfields.size(), 1);
	}

	public void disabledFields() {
		for (WebElement Element : Disabledfields) {
			System.out.println("Tag :" + Element.getTagName() + "ID : " + Element.getAttribute("id") + "Name : "
					+ Element.getAttribute("name") + Element.getAttribute(null));
		}
		System.out.println("Total Disabledfields Found : " + Disabledfields.size());
		Assert.assertEquals(Disabledfields.size(), 0);
	}

	public void fillTheSkills() throws InterruptedException {
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		actions.moveToElement(Skill_ddl).click().perform();
		Thread.sleep(1000);
		Skill_ddl.sendKeys("Automation Testing");
		Testutils.PressEnter();
		Save_btn.click();

	}

	public void navigateToSkills() throws InterruptedException {
		Testutils.scrollUsingAction(Skill_txt);
		Skill_txt.click();
		Thread.sleep(1000);
		Edit_icn.click();
		Testutils.scrollUsingAction(Cancel_btn);
	}
	
	public void editSkills() throws InterruptedException {
		Thread.sleep(1000);
		Edit_icn.click();
		Thread.sleep(1000);
		Skill_ddl.click();
		Thread.sleep(2000);
		Close_icn.click();
		Skill_ddl.sendKeys("Database Testing");
		Save_btn.click();
	}
}
