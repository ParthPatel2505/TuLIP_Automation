package MentorPanel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.TestBase;
import utils.Testutils;

public class candidate_Management3 extends TestBase {
	candidate_Management cm = new candidate_Management();

	public candidate_Management3() {
		PageFactory.initElements(driver, this);
		PageFactory.initElements(driver, cm);
	}

	@FindBy(xpath = "(//button[normalize-space()='Go Back'])[1]")
	WebElement back_btn;
	@FindBy(xpath = "//div[@class=\"MuiPaper-root MuiPaper-outlined MuiPaper-rounded MuiCard-root css-1bixe1j\"]")
	WebElement personalDetail_tbl;
	@FindBy(xpath = "(//table[@class=\"MuiTable-root css-e26b41\"])[1]")
	WebElement edu_tbl;
	@FindBy(xpath = "(//table[@class=\"MuiTable-root css-e26b41\"])[2]")
	WebElement workExp_tbl;
	@FindBy(xpath = "//div[@class=\"MuiPaper-root MuiPaper-outlined MuiPaper-rounded MuiCard-root css-1x2c4jx\"]")
	WebElement skillAndInt_txt;
	@FindBy(xpath = "//a[normalize-space()='Resume/CV']")
	WebElement resume_txt;
	@FindBy(xpath = "(//button[normalize-space()='Cancel'])[1]")
	WebElement cancel_btn;
	@FindBy(xpath = "(//button[normalize-space()='Reset'])[1]")
	WebElement reset_btn;
	@FindBy(xpath = "(//button[normalize-space()='Update'])[1]")
	WebElement update_btn;
	@FindBy(xpath = "//input[@id='firstname']")
	WebElement firstName_txt;
	@FindBy(xpath = "//input[@id='lastname']")
	WebElement lastName_txt;
	@FindBy(xpath = "//input[@id='email']")
	WebElement email_txt;
	@FindBy(xpath = "//input[@id='country']")
	WebElement country_ddl;
	@FindBy(xpath = "//input[@id='state']")
	WebElement state_ddl;
	@FindBy(xpath = "//input[@class=\"MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedEnd css-3g8nu5\"]")
	WebElement dob_ddl;

	public void logoutToLogin() throws InterruptedException {
		Testutils.logout();
		Thread.sleep(500);
		Testutils.logindetails("Chand.Patel@tntra.io", "Brijesh@05042003");
		Thread.sleep(500);
	}

	public void redirectToViewPage() throws InterruptedException {
		Thread.sleep(1000);
		Testutils.scrollUsingAction(cm.searchbox_txt);
		cm.searchbox_txt.sendKeys(candidate_Management.randomEmail1);
		Thread.sleep(500);
		cm.view_icn.click();
		Thread.sleep(500);
		System.out.println("You have been successfully redirected to the View Page.");
		back_btn.click();
		System.out.println("Back button is functioning as expected.");
		Testutils.scrollUsingAction(cm.searchbox_txt);
		cm.searchbox_txt.sendKeys(candidate_Management.randomEmail1);
		Thread.sleep(500);
		cm.view_icn.click();
	}

	public void personalDetails() throws InterruptedException {
		Thread.sleep(1000);
		System.out.println("For Personal Details : ");
		Thread.sleep(500);
		System.out.println(personalDetail_tbl.isEnabled());
		List<String> fieldTexts = getAllElementTexts(
				"//div[@class=\"MuiGrid-root MuiGrid-item MuiGrid-grid-xs-3 css-4xkoi8\"]/span");
		for (int i = 0; i < fieldTexts.size(); i++) {
			System.out.println("Field" + (i + 1) + " : " + fieldTexts.get(i));
		}

		List<String> valueTexts = getAllElementTexts(
				"//div[@class=\"MuiGrid-root MuiGrid-item MuiGrid-grid-xs-3 css-4xkoi8\"]/p");
		for (int i = 0; i < valueTexts.size(); i++) {
			System.out.println("Value" + (i + 1) + " value : " + valueTexts.get(i));
		}
	}

	public void educationBackground() throws InterruptedException {
		Thread.sleep(1000);
		System.out.println("For Educational Background : ");
		Thread.sleep(1000);
		System.out.println(edu_tbl.isEnabled());
		List<String> fieldTexts = getAllElementTexts(
				"(//div[@class=\"MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation1 MuiTableContainer-root css-cfwks5\"])[1]/table/thead/tr/th");
		System.out.println(fieldTexts.size());
		for (int i = 0; i < fieldTexts.size(); i++) {
			System.out.println("Field" + (i + 1) + " : " + fieldTexts.get(i));
		}

		List<String> valueTexts = getAllElementTexts(
				"(//div[@class=\"MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation1 MuiTableContainer-root css-cfwks5\"])[1]/table/tbody/tr/td");
		System.out.println(valueTexts.size());
		for (int i = 0; i < valueTexts.size(); i++) {
			System.out.println("Value" + (i + 1) + " : " + valueTexts.get(i));
		}
	}

	public void workExperience() throws InterruptedException, IOException {
		Thread.sleep(1200);
		Testutils.cleanFolder();
		Thread.sleep(1000);
		System.out.println("For Work Experience : ");
		Testutils.scrollUsingAction(resume_txt);
		Thread.sleep(1000);
		resume_txt.click();
		Thread.sleep(1000);
		System.out.println(workExp_tbl.isEnabled());
		List<String> fieldTexts = getAllElementTexts(
				"(//div[@class=\"MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation1 MuiTableContainer-root css-cfwks5\"])[2]/table/thead/tr/th");
		System.out.println(fieldTexts.size());
		for (int i = 0; i < fieldTexts.size(); i++) {
			System.out.println("Field" + (i + 1) + " : " + fieldTexts.get(i));
		}

		List<String> valueTexts = getAllElementTexts(
				"(//div[@class=\"MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation1 MuiTableContainer-root css-cfwks5\"])[2]/table/tbody/tr/td");
		System.out.println(valueTexts.size());
		for (int i = 0; i < valueTexts.size(); i++) {
			System.out.println("Value" + (i + 1) + " : " + valueTexts.get(i));
		}
		Testutils.verifyDownloadedFile("Sample");
	}

	public void skillAndInterest() throws InterruptedException {
		Thread.sleep(1000);
		System.out.println("For Skills & Interests : ");
		Thread.sleep(1000);
		System.out.println(skillAndInt_txt.isEnabled());
		List<String> fieldTexts = getAllElementTexts("(//h6[normalize-space()='Skills & Interests'])[1]");
		System.out.println(fieldTexts.size());
		for (int i = 0; i < fieldTexts.size(); i++) {
			System.out.println("Field" + (i + 1) + " : " + fieldTexts.get(i));
		}

		List<String> valueTexts = getAllElementTexts(
				"//div[@class=\"MuiChip-root MuiChip-filled MuiChip-sizeMedium MuiChip-colorDefault MuiChip-filledDefault css-13a0vqh\"]/span");
		System.out.println(valueTexts.size());
		for (int i = 0; i < valueTexts.size(); i++) {
			System.out.println("Value" + (i + 1) + " : " + valueTexts.get(i));
		}

		Testutils.scrollUsingAction(back_btn);
		back_btn.click();
		System.out.println("The user was successfully redirected to the Candidate Management module.");
	}

	public void redirectToEditPage() throws InterruptedException {
		Testutils.scrollUsingAction(cm.searchbox_txt);
		cm.searchbox_txt.sendKeys(candidate_Management.randomEmail1);
		Thread.sleep(1000);
		cm.edit_icn.click();
		System.out.println("You have been successfully redirected to the Edit Page.");
		Thread.sleep(1000);
		cancel_btn.click();
		System.out.println("Cancel button is functioning as expected.");
		Thread.sleep(1000);
	}

	public void resetButton() throws InterruptedException {
		Testutils.scrollUsingAction(cm.searchbox_txt);
		cm.searchbox_txt.sendKeys(candidate_Management.randomEmail1);
		Thread.sleep(1000);
		cm.edit_icn.click();
		System.out.println("You have been successfully redirected to the Edit Page.");
		Thread.sleep(1000);
		System.out.println("Before resetting Data : ");
		System.out.println("First Name : " + firstName_txt.getAttribute("value") + "\nLast Name : "
				+ lastName_txt.getAttribute("value") + "\nEmail : " + email_txt.getAttribute("value") + "\nState : "
				+ state_ddl.getAttribute("value") + "\nCountry : " + country_ddl.getAttribute("value") + "\nDOB : "
				+ dob_ddl.getAttribute("value"));
		Thread.sleep(1000);
		String firstName, lastName, email, state, country, dob;
		firstName = firstName_txt.getAttribute("value");
		lastName = lastName_txt.getAttribute("value");
		email = email_txt.getAttribute("value");
		state = state_ddl.getAttribute("value");
		country = country_ddl.getAttribute("value");
		dob = dob_ddl.getAttribute("value");
		Thread.sleep(1000);
		reset_btn.click();
		Thread.sleep(1000);
		System.out.println("First Name : " + firstName_txt.getAttribute("value") + "\nLast Name : "
				+ lastName_txt.getAttribute("value") + "\nEmail : " + email_txt.getAttribute("value") + "\nState : "
				+ state_ddl.getAttribute("value") + "\nCountry : " + country_ddl.getAttribute("value") + "\nDOB : "
				+ dob_ddl.getAttribute("value"));

		if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || state.isEmpty() || country.isEmpty()
				|| dob.isEmpty()) {
			System.out.println("Reset button is functionaning as expected");
		} else {
			System.out.println("Reset button did not clear all the fields.");

		}

		Thread.sleep(1000);
		cancel_btn.click();
	}

	public void editpage() throws InterruptedException {
		Testutils.scrollUsingAction(cm.searchbox_txt);
		cm.searchbox_txt.sendKeys(candidate_Management.randomEmail1);
		Thread.sleep(1000);
		cm.edit_icn.click();
		System.out.println("You have been successfully redirected to the Edit Page.");
		Thread.sleep(1000);
		Testutils.selectAllValue(firstName_txt);
		Testutils.removeAllValue(firstName_txt);
		String randomFirstName = cm.randomString(6);
		firstName_txt.sendKeys(randomFirstName);
		System.out.println("Updated First Name : " + randomFirstName);
		Thread.sleep(1000);
		Testutils.selectAllValue(lastName_txt);
		Testutils.removeAllValue(lastName_txt);
		String randomLastName = cm.randomString(6);
		lastName_txt.sendKeys(randomLastName);
		System.out.println("Updated Last Name : " + randomFirstName);
		Thread.sleep(1000);
		Testutils.selectAllValue(email_txt);
		Testutils.removeAllValue(email_txt);
		String randomEmail = cm.generateRandomemail();
		email_txt.sendKeys(randomLastName);
		System.out.println("Updated Email : " + randomEmail);
		Thread.sleep(1000);
		Testutils.selectAllValue(country_ddl);
		Testutils.removeAllValue(country_ddl);
		country_ddl.sendKeys("India");
		Testutils.PressDown();
		Testutils.PressEnter();
		System.out.println("Updated Country : " + country_ddl.getAttribute("value"));
		Thread.sleep(1000);
		Testutils.selectAllValue(state_ddl);
		Testutils.removeAllValue(state_ddl);
		state_ddl.sendKeys("Gujarat");
		Testutils.PressDown();
		Testutils.PressEnter();
		System.out.println("Updated State : " + state_ddl.getAttribute("value"));
		Thread.sleep(1000);
		Testutils.selectAllValue(dob_ddl);
		Testutils.removeAllValue(dob_ddl);
		dob_ddl.sendKeys("05042003");
		Testutils.PressEnter();
		System.out.println("Updated State : " + dob_ddl.getAttribute("value"));
		Thread.sleep(1000);
		Assert.assertEquals(cm.succ_txt.getText(), "Success! Record updated.");
		System.out.println("The user was successfully redirected to the Candidate Management module.");
	}

	public List<String> getAllElementTexts(String xpath) {
		List<WebElement> elements = driver.findElements(By.xpath(xpath));
		List<String> elementTexts = new ArrayList<>();

		for (WebElement element : elements) {
			elementTexts.add(element.getText().trim());
		}
		return elementTexts;
	}
}
