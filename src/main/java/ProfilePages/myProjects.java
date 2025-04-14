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

public class myProjects extends TestBase {

	public myProjects() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//*[name()='svg'][@class='tabler-icon tabler-icon-clipboard-data '])[1]")
	WebElement myProject_txt;
	@FindBy(xpath = "(//*[name()='svg'][@class='pointer'])[1]")
	WebElement plus_icn;
	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement save_btn;
	@FindBy(xpath = "(//button[normalize-space()='Cancel'])[1]")
	WebElement cancel_btn;
	@FindBy(xpath = "//input[@id='projectName']")
	WebElement name_txt;
	@FindBy(xpath = "//textarea[@id='description']")
	WebElement description_txt;
	@FindBy(xpath = "//textarea[@id='challenges-solutions']")
	WebElement challAndSol_txt;
	@FindBy(xpath = "//input[@id='projectUrl']")
	WebElement projectUrl_txt;
	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement checkbox_chk;
	@FindBy(xpath = "//*[@Required]")
	List<WebElement> required_Fields;
	@FindBy(xpath = "//*[@Disabled]")
	List<WebElement> disabled_Fields;
	@FindBy(xpath = "(//div[@class=\"react-select__input-container css-18w4uv4\"])[1]")
	WebElement skill_ddl;
	@FindBy(xpath = "(//input[@class=\"react-select__input\"])[1]")
	WebElement skill_txt;
	@FindBy(xpath = "(//div[@class=\"react-select__input-container css-18w4uv4\"])[2]")
	WebElement projectTools_ddl;
	@FindBy(xpath = "(//input[@class=\"react-select__input\"])[2]")
	WebElement projectTools_txt;
	@FindBy(xpath = "//div[@class='col-md-6']//div[@class='col-md-6']//div[@class='react-select__indicator react-select__dropdown-indicator css-1xc3v61-indicatorContainer']//*[name()='svg']")
	WebElement startMonth_ddl;
	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[1]/main[1]/div[3]/div[2]/div[1]/div[2]/div[1]/form[1]/div[5]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/span[1]")
	WebElement startYear_ddl;
	@FindBy(xpath = "(//div[@class='react-select__control css-5bh7pi-control'])[5]")
	WebElement endMonth_ddl;
	@FindBy(xpath = "//div[@class='ant-card-body']//div[2]//div[1]//div[2]//div[1]//div[1]//div[2]//div[1]//*[name()='svg']")
	WebElement endYear_ddl;
	@FindBy(xpath = "//div[@class=\"ant-card-head-title\"]")
	WebElement title_txt;
	@FindBy(xpath = "(//span[@class=\"error-msg\"])[2]")
	WebElement nameVal_txt;
	@FindBy(xpath = "(//span[@class=\"error-msg d-block mt-2\"])[1]")
	WebElement startDateVal_txt;
	@FindBy(xpath = "(//span[@class=\"error-msg d-block mt-2\"])[2]")
	WebElement endDateVal_txt;
	@FindBy(xpath = "(//*[name()='svg'][@class='pointer actionIcon undefined'])[1]")
	WebElement edit_icn;
	@FindBy(xpath = "(//*[name()='svg'][@class='pointer actionIcon undefined'])[2]")
	WebElement delete_icn;
	@FindBy(xpath = "(//*[name()='svg'][@class='css-8mmkcg'])[2]")
	WebElement closeInSkills_icn;
	@FindBy(xpath = "(//*[name()='svg'][@class='css-8mmkcg'])[5]")
	WebElement closeInTools_icn;
	@FindBy(xpath = "//div[@role='status']")
	WebElement succ_msg;
	@FindBy(xpath = "(//div[@class='react-select__value-container react-select__value-container--has-value css-f0ja12'])[2]")
	WebElement startYearEdit_ddl;
	
	public void navigateToMyProjects() throws InterruptedException {
		Testutils.scrollUsingAction(myProject_txt);
		myProject_txt.click();
		Thread.sleep(1000);
		plus_icn.click();
		System.out.println("Plus icon Working as Expected");
		Assert.assertEquals(title_txt.isDisplayed(), true);
		System.out.println("Title is displayed for My Projects");
	}

	public void closeAndCancel() throws InterruptedException {
		Thread.sleep(1000);
		Testutils.scrollUsingAction(save_btn);
		Thread.sleep(2000);
		cancel_btn.click();
		Thread.sleep(1000);
		System.out.println("Cancel Button Working as Expected");
		Thread.sleep(1000);
		Testutils.scrollUsingAction(plus_icn);
		Thread.sleep(1000);
		plus_icn.click();
		Thread.sleep(1000);
	}

	public void verifyValidations() throws InterruptedException {
		Testutils.scrollUsingAction(save_btn);
		Thread.sleep(1000);
		save_btn.click();
		String ExpValName = "Please enter Project Name";
		String ActValName = nameVal_txt.getText();
		Assert.assertEquals(ActValName, ExpValName);

		System.out.println("Expected Validation Message for Name Field : " + "Please enter Project Name");
		System.out.println("Actual Validation Message for Name Field : " + nameVal_txt.getText());

		String ExpValStartDate = "Please enter Start date";
		String ActValStartDate = startDateVal_txt.getText();
		Assert.assertEquals(ActValStartDate, ExpValStartDate);

		System.out.println("Expected Validation Message for StartDate Field : " + "Please enter Start date");
		System.out.println("Actual Validation Message for StartDate Field : " + startDateVal_txt.getText());

		String ExpValEndDate = "End date is a required field, if not currently working on the project.";
		String ActValEndDate = endDateVal_txt.getText();
		Assert.assertEquals(ActValEndDate, ExpValEndDate);

		System.out.println("Expected Validation Message for Skype  Field : "
				+ "End date is a required field, if not currently working on the project.");
		System.out.println("Actual Validation Message for Skype  Field : " + endDateVal_txt.getText());

	}

	public void disabledFields() throws InterruptedException {

		for (WebElement Element : disabled_Fields) {
			System.out.println("Tag: " + Element.getTagName() + ", Name: " + Element.getAttribute("name") + ", ID: "
					+ Element.getAttribute("id"));
		}
		System.out.println("Total disabled fields found : " + disabled_Fields.size());
		Assert.assertEquals(disabled_Fields.size(), 0);
	}

	public void requiredFields() throws InterruptedException {
		for (WebElement Element : required_Fields) {
			System.out.println("Tag: " + Element.getTagName() + ", Name: " + Element.getAttribute("name") + ", ID: "
					+ Element.getAttribute("id"));
		}
		System.out.println("Total required fields found : " + required_Fields.size());
		Assert.assertEquals(required_Fields.size(), 2);
		Testutils.scrollUsingAction(save_btn);
		Thread.sleep(1000);
		cancel_btn.click();
		
	}

	public void fillTheDetails() throws InterruptedException {
		Testutils.scrollUsingAction(plus_icn);
		Thread.sleep(1000);
		plus_icn.click();
		Thread.sleep(1000);
		Testutils.scrollUsingAction(name_txt);
		String randomName = generateRandomString(6);
		name_txt.sendKeys(randomName);
		Thread.sleep(1000);
		String randomDes = generateRandomString(26);
		description_txt.sendKeys(randomDes);
		Testutils.scrollUsingAction(challAndSol_txt);
		Thread.sleep(1000);
		String randomChallengesAndSolutions = generateRandomString(50);
		challAndSol_txt.sendKeys(randomChallengesAndSolutions);
		Testutils.scrollUsingAction(checkbox_chk);
		Thread.sleep(1000);
		skill_txt.sendKeys("Automation Testing");
		Testutils.PressEnter();
		Thread.sleep(1000);
		projectTools_txt.sendKeys("Selenium");
		Testutils.PressEnter();
		Thread.sleep(2000);
		startYear_ddl.click();
		selectFromDdl("(//div[@class=\"react-select__menu-list css-qr46ko\"]/div)", "2023");
		Thread.sleep(2000);
		startMonth_ddl.click();
		selectFromDdl("(//div[@class=\"react-select__menu-list css-qr46ko\"]/div)", "April");
		Thread.sleep(2000);
		endYear_ddl.click();
		selectFromDdl("(//div[@class=\"react-select__menu-list css-qr46ko\"]/div)", "2024");
		Thread.sleep(2000);
		endMonth_ddl.click();
		selectFromDdl("(//div[@class=\"react-select__menu-list css-qr46ko\"]/div)", "April");
		Testutils.scrollUsingAction(save_btn);
		Thread.sleep(1000);
		String randomURL = generateURL();
		projectUrl_txt.sendKeys(randomURL);
		Thread.sleep(1000);
		save_btn.click();
		Thread.sleep(1000);
		Assert.assertEquals(succ_msg.getText(), "Success! Record saved.");
		System.out.println("Your form was submitted successfully!");
	}

	public void editDetails() throws InterruptedException {
		Thread.sleep(1000);
		edit_icn.click();
		Thread.sleep(1000);
		Testutils.scrollUsingAction(name_txt);
		Testutils.selectAllValue(name_txt);
		Testutils.removeAllValue(name_txt);
		String randomName = generateRandomString(6);
		name_txt.sendKeys(randomName);
		Thread.sleep(1000);
		Testutils.scrollUsingAction(description_txt);
		Testutils.selectAllValue(description_txt);
		Testutils.removeAllValue(description_txt);
		String randomDes = generateRandomString(26);
		description_txt.sendKeys(randomDes);
		Testutils.scrollUsingAction(challAndSol_txt);
		Testutils.selectAllValue(challAndSol_txt);
		Testutils.removeAllValue(challAndSol_txt);
		Thread.sleep(1000);
		String randomChallengesAndSolutions = generateRandomString(50);
		challAndSol_txt.sendKeys(randomChallengesAndSolutions);
		Testutils.scrollUsingAction(checkbox_chk);
		Thread.sleep(1000);
		closeInSkills_icn.click();
		skill_txt.sendKeys("DB Testing");
		Testutils.PressEnter();
		Thread.sleep(1000);
		closeInTools_icn.click();
		projectTools_txt.sendKeys("MYSQL");
		Testutils.PressEnter();
		Thread.sleep(2000);
		startYearEdit_ddl.click();
		selectFromDdl("(//div[@class=\"react-select__menu-list css-qr46ko\"]/div)", "2020");
		Thread.sleep(2000);
		startMonth_ddl.click();
		selectFromDdl("(//div[@class=\"react-select__menu-list css-qr46ko\"]/div)", "April");
		Thread.sleep(1000);
		Testutils.scrollUsingAction(save_btn);
		Thread.sleep(1000);
		checkbox_chk.click();
		Thread.sleep(1000);
		Testutils.scrollUsingAction(checkbox_chk);
		Thread.sleep(1000);
		Testutils.selectAllValue(projectUrl_txt);
		Testutils.removeAllValue(projectUrl_txt);
		String randomURL = generateURL();
		projectUrl_txt.sendKeys(randomURL);
		Thread.sleep(1000);
		save_btn.click();
		Thread.sleep(1000);
		Assert.assertEquals(succ_msg.getText(), "Success! Record updated.");
		System.out.println("Your changes have been saved successfully!");
	}
	
	public void deleteRecord() throws InterruptedException {
		Thread.sleep(1000);
		delete_icn.click();
		Thread.sleep(1000);
		Assert.assertEquals(succ_msg.getText(), "Removed! Record deleted.");
		Thread.sleep(1000);
		
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

	public void selectFromDdl(String xpath, String value) {
		List<WebElement> list = driver.findElements(By.xpath(xpath));

		for (int i = 0; i < list.size();) {
			String fetchValue = list.get(i).getText();

			if (fetchValue.equals(value)) {
				String makexpath = xpath + "[" + (i + 1) + "]";
				driver.findElement(By.xpath(makexpath)).click();
				break;
			} else {
				i++;
			}
		}
	}

	public String generateURL() {
		String protocol = "https://";
		String domain = ".com";
		String Url = protocol + generateRandomString(5) + domain;
		return Url;
	}
}
