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
	@FindBy(xpath = "//div[@class='ant-card-extra']//*[name()='svg']")
	WebElement Edit_icn;
	@FindBy(xpath = "//div[@class='react-select__indicator react-select__clear-indicator css-1xc3v61-indicatorContainer']//*[name()='svg']")
	WebElement Close_icn;
	@FindBy(xpath = "//input[@class=\"react-select__input\"]")
	WebElement Skill_ddl;
	@FindBy(xpath = "//button[normalize-space()='Cancel']")
	WebElement Cancel_btn;
	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement Save_btn;
	@FindBy(xpath = "//*[@Disabled]")
	List<WebElement> Disabledfields;
	@FindBy(xpath = "//span[@Required]")
	List<WebElement> Requiredfields;
	@FindBy(xpath = "//span[@class='error-msg']")
	WebElement skill_val;
	@FindBy(xpath = "//div[@role='status']")
	WebElement suc_msg;

	public void navigateToSkills() throws InterruptedException {
		Testutils.scrollUsingAction(Skill_txt);
		Skill_txt.click();
		Thread.sleep(1000);
		Edit_icn.click();
		Testutils.scrollUsingAction(Cancel_btn);
	}

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

	public void verifyValidations() throws InterruptedException {
		Thread.sleep(1000);
		Save_btn.click();

		String ExpValMySk = "Skill required";
		String ActValMySk = skill_val.getText();
		Assert.assertEquals(ActValMySk, ExpValMySk);

		System.out.println("Expected Validation Message for My Skills Field : " + "Skill required");
		System.out.println("Actual Validation Message for My Skills Field : " + skill_val.getText());
	}

	public void fillTheSkills() throws InterruptedException {
		Thread.sleep(2000);
		Edit_icn.click();
		Thread.sleep(3000);
		Close_icn.click();
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		actions.moveToElement(Skill_ddl).click().perform();
		Thread.sleep(1000);
		Skill_ddl.sendKeys("Automation Testing");
		Testutils.PressEnter();
		Thread.sleep(2000);
		Save_btn.click();
		Thread.sleep(1000);
		System.err.println(suc_msg.getText());
		Thread.sleep(2000);
		Assert.assertEquals("Success! Record saved.", suc_msg.getText());

	}

	public void editSkills() throws InterruptedException {
		Thread.sleep(1000);
		Edit_icn.click();
		Thread.sleep(1000);
		Close_icn.click();
		Thread.sleep(2000);
		Skill_ddl.sendKeys("Database Testing");
		Testutils.PressEnter();
		Thread.sleep(1000);
		Save_btn.click();
		Thread.sleep(1000);
		Assert.assertEquals("Success! Record updated.", suc_msg.getText());
	}
}
