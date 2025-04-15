package ProfilePages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.TestBase;
import utils.Testutils;

public class goalAndAsp extends TestBase {

	public goalAndAsp() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='/tntra/profile/goals-aspiration']//*[name()='svg']")
	WebElement goalAndAsp_txt;
	@FindBy(xpath = "(//div[@class='ant-card-head-title'])[1]")
	WebElement goalAndAspTitle_txt;
	@FindBy(xpath = "//div[@class='ant-card-extra']//*[name()='svg']")
	WebElement edit_icn;
	@FindBy(xpath = "//button[normalize-space()='Cancel']")
	WebElement Cancel_btn;
	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement Save_btn;
	@FindBy(xpath = "(//*[name()='svg'][@class='css-8mmkcg'])[1]")
	WebElement areaOfInt_ddl;
	@FindBy(xpath = "//input[@class=\"react-select__input\"]")
	WebElement areaOfInt_txt;
	@FindBy(xpath = "//textarea[@id='short-term-goal']")
	WebElement sortTermLearnGoals_txt;
	@FindBy(xpath = "//textarea[@id='long-term-goal']")
	WebElement longTermLearnGoals_txt;
	@FindBy(xpath = "//textarea[@id='preferredJobLocation']")
	WebElement preferredJobLocation_txt;
	@FindBy(xpath = "//textarea[@id='preferredJobRoles']")
	WebElement preferredJobRoles_txt;
	@FindBy(xpath = "//div[@class='react-select__indicator react-select__clear-indicator css-1xc3v61-indicatorContainer']//*[name()='svg']//*[name()='path' and contains(@d,'M14.348 14')]")
	WebElement close_icn;
	@FindBy(xpath = "//*[@disabled]")
	List<WebElement> Disabled_fields;
	@FindBy(xpath = "//*[@Required]")
	List<WebElement> Required_fields;

	public void navigateToGoalAndAspiration() throws InterruptedException {
		Testutils.scrollUsingAction(goalAndAsp_txt);
		goalAndAsp_txt.click();
		Thread.sleep(1000);
		edit_icn.click();
		System.out.println("Edit Icon Working as Expected");
		Assert.assertEquals(goalAndAspTitle_txt.isDisplayed(), true);
		System.out.println("Title is displayed for Communication & Preferences");
	}

	public void closeAndCancel() throws InterruptedException {
		Testutils.scrollUsingAction(Cancel_btn);
		Thread.sleep(1000);
		Cancel_btn.click();
		Thread.sleep(1000);
		System.out.println("Cancel Button Working as Expected");
		Testutils.scrollUsingAction(edit_icn);
		edit_icn.click();
		Thread.sleep(1000);
	}

	public void disabledFields() throws InterruptedException {

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
		Assert.assertEquals(Required_fields.size(), 0);
	}

	public void fillTheDetails() throws InterruptedException {
		Thread.sleep(1000);
		Testutils.scrollUsingAction(sortTermLearnGoals_txt);
		selectFromStaticList("(//div[@class=\"form-check form-check-inline\"]/label)", "Fast");
		String randomShortTermGoal = generateRandomString(10);
		System.out.println("Generated Random Short-Term Learning Goal : " + randomShortTermGoal);
		sortTermLearnGoals_txt.sendKeys(randomShortTermGoal);
		Thread.sleep(1000);
		Testutils.scrollUsingAction(longTermLearnGoals_txt);
		String randomLongTermGoal = generateRandomString(10);
		System.out.println("Generated Random Long-Term Learning Goal : " + randomLongTermGoal);
		longTermLearnGoals_txt.sendKeys(randomLongTermGoal);
		Testutils.scrollUsingAction(preferredJobLocation_txt);
		Thread.sleep(2000);
		areaOfInt_ddl.click();
		Thread.sleep(2000);
		areaOfInt_txt.sendKeys("Automation Testing");
		Testutils.PressEnter();
		Thread.sleep(1000);
		Testutils.scrollUsingAction(preferredJobLocation_txt);
		String randomPreferredJobLocation = generateRandomString(10);
		System.out.println("Generated Random Preferred Job Location : " + randomPreferredJobLocation);
		preferredJobLocation_txt.sendKeys(randomPreferredJobLocation);
		Thread.sleep(1000);
		Testutils.scrollUsingAction(preferredJobRoles_txt);
		String randomPreferredJobRoles = generateRandomString(10);
		System.out.println("Generated Random Preferred Job Roles : " + randomPreferredJobRoles);
		preferredJobRoles_txt.sendKeys(randomPreferredJobRoles);
		Testutils.scrollUsingAction(Save_btn);
		Thread.sleep(1000);
		Save_btn.click();
	}
	
	public void editTheDetails() throws InterruptedException {
		Testutils.scrollUsingAction(edit_icn);
		Thread.sleep(1000);
		edit_icn.click();
		Testutils.scrollUsingAction(sortTermLearnGoals_txt);
		Thread.sleep(1000);
		selectFromStaticList("(//div[@class=\"form-check form-check-inline\"]/label)", "Slow");
		Thread.sleep(1000);
		sortTermLearnGoals_txt.click();
		Testutils.selectAllValue(sortTermLearnGoals_txt);
		Testutils.removeAllValue(sortTermLearnGoals_txt);
		Thread.sleep(1000);
		String randomShortTermGoal = generateRandomString(10);
		System.out.println("Generated Random Short-Term Learning Goal After Editing : " + randomShortTermGoal);
		sortTermLearnGoals_txt.sendKeys(randomShortTermGoal);
		Thread.sleep(1000);
		Testutils.scrollUsingAction(longTermLearnGoals_txt);
		longTermLearnGoals_txt.click();
		Testutils.selectAllValue(longTermLearnGoals_txt);
		Testutils.removeAllValue(longTermLearnGoals_txt);
		Thread.sleep(1000);
		String randomLongTermGoal = generateRandomString(10);
		System.out.println("Generated Random Long-Term Learning Goal After Editing : " + randomLongTermGoal);
		longTermLearnGoals_txt.sendKeys(randomLongTermGoal);
		Testutils.scrollUsingAction(preferredJobLocation_txt);
		Thread.sleep(1000);
		close_icn.click();
		areaOfInt_ddl.click();
		areaOfInt_txt.sendKeys("Database Testing");
		Testutils.PressEnter();
		Thread.sleep(1000);
		preferredJobLocation_txt.click();
		Testutils.selectAllValue(preferredJobLocation_txt);
		Testutils.removeAllValue(preferredJobLocation_txt);
		Thread.sleep(1000);
		String randomPreferredJobLocation = generateRandomString(10);
		System.out.println("Generated Random Preferred Job Location After Editing : " + randomPreferredJobLocation);
		preferredJobLocation_txt.sendKeys(randomPreferredJobLocation);
		Thread.sleep(1000);
		Testutils.scrollUsingAction(preferredJobRoles_txt);
		preferredJobRoles_txt.click();
		Testutils.selectAllValue(preferredJobRoles_txt);
		Testutils.removeAllValue(preferredJobRoles_txt);
		Thread.sleep(1000);
		String randomPreferredJobRoles = generateRandomString(10);
		System.out.println("Generated Random Preferred Job Roles After Editing : " + randomPreferredJobRoles);
		preferredJobRoles_txt.sendKeys(randomPreferredJobRoles);
		Testutils.scrollUsingAction(Save_btn);
		Thread.sleep(1000);
		Save_btn.click();
	}

	public void deleteTheDetails() {
		
	}
	public void selectFromStaticList(String xPath, String value) {
		List<WebElement> liList = driver.findElements(By.xpath(xPath));

		for (int i = 0; i < liList.size();) {
			String fetchValue = liList.get(i).getText();
			if (fetchValue.equals(value)) {
				String makingxPath = xPath + "[" + (i + 1) + "]";
				driver.findElement(By.xpath(makingxPath)).click();
				break;
			} else {
				i++;
			}
		}
	}

	public String generateRandomString(int length) {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		StringBuilder randomString = new StringBuilder();
		Random random = new Random();

		for (int i = 0; i < length; i++) {
			int randomIndex = random.nextInt(characters.length());
			randomString.append(characters.charAt(randomIndex));
		}

		return randomString.toString();
	}

}
