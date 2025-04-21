package MentorPanel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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
	// div[@class="MuiGrid-root MuiGrid-item MuiGrid-grid-xs-3 css-4xkoi8"]/span

	public void logoutToLogin() throws InterruptedException {
		Testutils.logout();
		Thread.sleep(1000);
		Testutils.logindetails("Chand.Patel@tntra.io", "Brijesh@05042003");
		Thread.sleep(1000);
	}

	public void redirectToViewPage() throws InterruptedException {
		Testutils.scrollUsingAction(cm.searchbox_txt);
		cm.searchbox_txt.sendKeys(candidate_Management.randomEmail1);
		Thread.sleep(1000);
		cm.view_icn.click();
		Thread.sleep(1000);
		System.out.println("You have been successfully redirected to the View Page.");
		back_btn.click();
		System.out.println("Back button is functioning as expected.");
		Testutils.scrollUsingAction(cm.searchbox_txt);
		cm.searchbox_txt.sendKeys(candidate_Management.randomEmail1);
		Thread.sleep(1000);
		cm.view_icn.click();
	}

	public void personalDetails() throws InterruptedException {
		System.out.println("For Personal Details : ");
		Thread.sleep(1000);
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
		Thread.sleep(1000);
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

	public List<String> getAllElementTexts(String xpath) {
		List<WebElement> elements = driver.findElements(By.xpath(xpath));
		List<String> elementTexts = new ArrayList<>();

		for (WebElement element : elements) {
			elementTexts.add(element.getText().trim());
		}
		return elementTexts;
	}
}
