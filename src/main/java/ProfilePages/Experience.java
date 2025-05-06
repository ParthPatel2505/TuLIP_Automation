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

	@FindBy(xpath = "//span[normalize-space()='Experience']")
	WebElement Experience_txt;
	@FindBy(xpath = "(//*[name()='svg'][@class='pointer'])[1]")
	WebElement Plus_icn;
	@FindBy(xpath = "//button[normalize-space()='Cancel']")
	WebElement Cancel_btn;
	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement Save_btn;
	@FindBy(xpath = "(//div[@class='react-select__input-container css-18w4uv4'])[1]")
	WebElement emyStatus_ddl;
	@FindBy(xpath = "(//input[@class=\"react-select__input\"])[2]")
	WebElement Jobtitle_ddl;
	@FindBy(xpath = "(//input[@class=\"react-select__input\"])[3]")
	WebElement Company_ddl;
	@FindBy(xpath = "(//input[@class=\"react-select__input\"])[4]")
	WebElement Location_ddl;
	@FindBy(xpath = "(//input[@class=\"react-select__input\"])[5]")
	WebElement Skills_ddl;
	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement Chk_box;
	@FindBy(xpath = "(//div[@class='react-select__value-container react-select__value-container--has-value css-f0ja12'])[4]")
	WebElement StartMonth_ddl;
	@FindBy(xpath = "(//div[@class='react-select__value-container css-f0ja12'])[2]")
	WebElement StartYear_ddl;
	@FindBy(xpath = "(//div[@class='react-select__value-container react-select__value-container--has-value css-f0ja12'])[6]")
	WebElement endMonth_ddl;
	@FindBy(xpath = "(//div[@class='react-select__value-container css-f0ja12'])[2]")
	WebElement endYear_ddl;
	@FindBy(xpath = "//span[@required or normalize-space()='End Date required']")
	List<WebElement> Required_fields;
	@FindBy(xpath = "//*[@Disabled]")
	List<WebElement> Disabled_fields;
	@FindBy(xpath = "//div[@class='react-select__indicator react-select__clear-indicator css-1xc3v61-indicatorContainer']//*[name()='svg']//*[name()='path' and contains(@d,'M14.348 14')]")
	WebElement SkillsClose_Icn;
	@FindBy(xpath = "//img[@alt='user-1']")
	WebElement image_img;
	@FindBy(xpath = "//div[@class='ant-card-head-title']")
	WebElement title_txt;
	@FindBy(xpath = "//input[@id='upload-certificate']")
	WebElement resume_btn;
	@FindBy(xpath = "//div[@class='uploadedFiles']//*[name()='svg']")
	WebElement closeInResume_icn;
	@FindBy(xpath = "//div[@role='status']")
	WebElement succMsg_txt;
	@FindBy(xpath = "(//*[name()='svg'][@class='pointer actionIcon undefined'])[1]")
	WebElement edit_icn;
	@FindBy(xpath = "(//*[name()='svg'][@class='css-8mmkcg'])[12]")
	WebElement closeInSkill_icn;
	@FindBy(xpath = "(//*[name()='svg'][@class='pointer actionIcon undefined'])[2]")
	WebElement delete_icn;

	public void navigateToExperience() throws InterruptedException {
		Thread.sleep(2000);
		Testutils.scrollUsingAction(Experience_txt);
		Thread.sleep(2000);
		Experience_txt.click();
	}

	public void closeAndCancel() throws InterruptedException {
		Thread.sleep(1000);
		Plus_icn.click();
		Thread.sleep(1000);
		Testutils.scrollUsingAction(Cancel_btn);
		Thread.sleep(1000);
		Cancel_btn.click();
		Thread.sleep(1000);
		System.out.println("Cancel Button Working as Expected");
		Thread.sleep(1000);
		title_txt.isDisplayed();
		System.out.println("Title is displayed for the Experience Page.");
		Testutils.scrollUsingAction(image_img);
		Thread.sleep(1000);
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

	public void requiredFields() throws InterruptedException {
		for (WebElement Element : Required_fields) {
			System.out.println("Tag: " + Element.getTagName() + ", Name: " + Element.getAttribute("name") + ", ID: "
					+ Element.getAttribute("id"));
		}
		System.out.println("Total required fields found : " + Required_fields.size());
		Assert.assertEquals(Required_fields.size(), 5);
		Thread.sleep(1000);
		Testutils.scrollUsingAction(Cancel_btn);
		Thread.sleep(1000);
		Cancel_btn.click();
	}

	public void fillTheDetails() throws InterruptedException {
		Thread.sleep(1000);
		Testutils.scrollUsingAction(image_img);
		Thread.sleep(1000);
		Plus_icn.click();
		Thread.sleep(1000);
		Testutils.scrollUsingAction(Chk_box);
		emyStatus_ddl.click();
		selectFromDdl("(//div[@class=\"react-select__menu-list css-qr46ko\"]/div)", "Employed");
		Thread.sleep(2000);
		Jobtitle_ddl.sendKeys("Automation Test Engineer");
		Thread.sleep(2000);
		Testutils.PressEnter();
		Company_ddl.sendKeys("Tntra");
		Testutils.PressEnter();
		Thread.sleep(2000);
		StartYear_ddl.click();
		Thread.sleep(2000);
		selectFromDdl("//div[@class=\"react-select__menu css-1nmdiq5-menu\"]/div/div", "2023");
		Thread.sleep(2000);
		StartMonth_ddl.click();
		Thread.sleep(2000);
		selectFromDdl("//div[@class=\"react-select__menu css-1nmdiq5-menu\"]/div/div", "February");
		Thread.sleep(2000);
		endYear_ddl.click();
		Thread.sleep(2000);
		selectFromDdl("//div[@class=\"react-select__menu css-1nmdiq5-menu\"]/div/div", "2024");
		Thread.sleep(2000);
		endMonth_ddl.click();
		Thread.sleep(2000);
		selectFromDdl("//div[@class=\"react-select__menu css-1nmdiq5-menu\"]/div/div", "February");
		//Chk_box.click();
		Location_ddl.sendKeys("Australia");
		Testutils.PressEnter();
		Skills_ddl.sendKeys("Selenium with Java");
		Testutils.PressEnter();
		Thread.sleep(1000);
		resume_btn.sendKeys("C:\\Users\\tntra\\Downloads\\ATS classic HR resume.docx");
		Thread.sleep(1000);
		closeInResume_icn.click();
		Thread.sleep(1000);
		resume_btn.sendKeys("C:\\Users\\tntra\\Downloads\\ATS classic HR resume.docx");
		Thread.sleep(1000);
		System.out.println("File uploaded successfully");
		Save_btn.click();
		Thread.sleep(1000);
		Assert.assertEquals(succMsg_txt.getText(), "Success! Record saved.");
		System.out.println("Experience has been filled successfully.");

	}

	public void editDetails() throws InterruptedException {
		Thread.sleep(2000);
		edit_icn.click();
		Location_ddl.sendKeys("Afghanistan");
		Testutils.PressEnter();
		Thread.sleep(2000);
		closeInSkill_icn.click();
		Thread.sleep(1000);
		Skills_ddl.sendKeys("DB Testing");
		Testutils.PressEnter();
		Thread.sleep(1000);
		closeInResume_icn.click();
		Thread.sleep(1000);
		resume_btn.sendKeys("C:\\Users\\tntra\\Downloads\\ATS classic HR resume.docx");
		Thread.sleep(1000);
		Save_btn.click();
		Thread.sleep(1000);
		Assert.assertEquals(succMsg_txt.getText(), "Success! Record updated.");

	}

	public void deleteRecord() throws InterruptedException {
		Thread.sleep(1000);
		delete_icn.click();
		Thread.sleep(1000);
		Assert.assertEquals(succMsg_txt.getText(), "Removed! Record deleted.");
	}

	public static void selectFromDdl(String xpath, String Value) {
		List<WebElement> list = driver.findElements(By.xpath(xpath));

		for (int i = 0; i < list.size();) {
			String fetchValue = list.get(i).getText();
			if (fetchValue.equals(Value)) {
				String makexpath = xpath + "[" + (i + 1) + "]";
				driver.findElement(By.xpath(makexpath)).click();
				break;
			} else {
				i++;
			}
		}
	}

}
