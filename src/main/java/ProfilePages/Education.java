package ProfilePages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.TestBase;
import utils.Testutils;

public class Education extends TestBase {

	public Education() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='/tntra/profile/education']")
	WebElement Education_txt;
	@FindBy(xpath = "(//*[name()='svg'][@class='pointer'])[1]")
	WebElement Plus_icn;
	@FindBy(xpath = "(//div[@class='react-select__value-container css-f0ja12'])[1]")
	WebElement HigQual_ddl;
	@FindBy(xpath = "(//div[@class='react-select__input-container css-18w4uv4'])[1]")
	WebElement Institute_ddl1;
	@FindBy(xpath = "(//input[@class=\"react-select__input\"])[1]")
	WebElement Institute_ddl;
	@FindBy(xpath = "(//input[@class=\"react-select__input\"])[2]")
	WebElement fos_ddl;
	@FindBy(xpath = "//input[@id=\"react-select-4-input\"]")
	WebElement fos_ddl1;
	@FindBy(xpath = "(//*[@class=\"react-select-container css-b62m3t-container\"])[4]")
	WebElement Startmonth_ddl;
	@FindBy(xpath = "(//*[@class=\"react-select-container css-b62m3t-container\"])[5]")
	WebElement Startyear_ddl;
	@FindBy(xpath = "(//*[@class=\"react-select-container css-b62m3t-container\"])[6]")
	WebElement Endmonth_ddl;
	@FindBy(xpath = "(//*[@class=\"react-select-container css-b62m3t-container\"])[7]")
	WebElement Endyear_ddl;
	@FindBy(xpath = "//input[@id='grade']")
	WebElement grade_txt;
	@FindBy(xpath = "//input[@id='academicAchievements']")
	WebElement AcdAch_txt;
	@FindBy(xpath = "//input[@id='specialSubject']")
	WebElement Specialsubject_txt;
	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement Save_btn;
	@FindBy(xpath = "//button[normalize-space()='Cancel']")
	WebElement Cancel_btn;
	@FindBy(xpath = "//div[@role='status']")
	WebElement SuccessonCreate_txt;
	@FindBy(xpath = "//div[@role='status']")
	WebElement SuccessonDelete_txt;
	@FindBy(xpath = "//div[@role='status']")
	WebElement SuccessonUpdate_txt;
	@FindBy(xpath = "(//*[name()='svg'][@class='pointer actionIcon undefined'])[1]")
	WebElement Edit_icn;
	@FindBy(xpath = "(//*[name()='svg'][@class='pointer actionIcon undefined'])[2]")
	WebElement Delete_icn;
	@FindBy(xpath = "(//span[@class=\"error-msg d-block mt-2\"])[1]")
	WebElement HigQualVal_txt;
	@FindBy(xpath = "(//span[@class=\"error-msg d-block mt-2\"])[2]")
	WebElement InsVal_txt;
	@FindBy(xpath = "//span[normalize-space()='Please select Field Of Study']")
	WebElement fosVal_txt;
	@FindBy(xpath = "//span[normalize-space()='Please select Start Date']")
	WebElement stVal_txt;
	@FindBy(xpath = "//span[normalize-space()='Please select End Date']")
	WebElement etVal_txt;
	@FindBy(xpath = "//span[normalize-space()='Please enter Grade']")
	WebElement gdVal_txt;
	@FindBy(xpath = "//div[@class='ant-card-head-title']")
	WebElement education_ttl;
	@FindBy(xpath = "//img[@alt='user-1']")
	WebElement image_img;

	public void navigateToEducation() throws InterruptedException {
		Thread.sleep(2000);
		Education_txt.click();
		
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
		Testutils.scrollUsingAction(image_img);
		Thread.sleep(1000);
		Plus_icn.click();
		Thread.sleep(1000);
		Testutils.scrollUsingAction(Save_btn);
	}
	
	public void disabledFields() throws InterruptedException {
		
		List<WebElement> disabledfields = driver.findElements(By.xpath("//*[@disabled]"));
		for (WebElement Element : disabledfields) {
			System.out.println("Tag: " + Element.getTagName() + ", Name: " + Element.getAttribute("name") + ", ID: "
					+ Element.getAttribute("id"));
		}
		System.out.println("Total disabled fields found : " + disabledfields.size());
		Assert.assertEquals(disabledfields.size(), 0);
	}

	public void requiredFields() {
		List<WebElement> requiredFields = driver.findElements(By.xpath("//span[@class='error-msg']"));
		for (WebElement Element : requiredFields) {
			System.out.println("Tag: " + Element.getTagName() + ", Name: " + Element.getAttribute("name") + ", ID: "
					+ Element.getAttribute("id"));
		}
		System.out.println("Total required fields found : " + requiredFields.size());
		Assert.assertEquals(requiredFields.size(), 6);
	}

	public void verifyValidations() throws InterruptedException {

		Thread.sleep(1000);
		Save_btn.click();
		Thread.sleep(1000);
		String ExpvalHigQual = "Please enter Highest Qualification";
		String ActvalHigQual = HigQualVal_txt.getText();
		Assert.assertEquals(ActvalHigQual, ExpvalHigQual);

		System.out.println("Expected Validation Message for Highest Qualification Field : "
				+ "Please enter Highest Qualification");
		System.out.println("Actual Validation Message for Highest Qualification Field : " + HigQualVal_txt.getText());

		String ExpvalIns = "Please select Institution Name";
		String ActvalIns = InsVal_txt.getText();
		Assert.assertEquals(ActvalIns, ExpvalIns);

		System.out.println(
				"Expected Validation Message for Institution Name Field : " + "Please select Institution Name");
		System.out.println("Actual Validation Message for Institution Name Field : " + InsVal_txt.getText());
		
		String ExpvalFos = "Please select Field Of Study";
		String ActvalFos = fosVal_txt.getText();
		Assert.assertEquals(ActvalFos, ExpvalFos);

		System.out.println(
				"Expected Validation Message for Field Of Study Field : " + "Please select Field Of Study");
		System.out.println("Actual Validation Message for Field Of Study Field : " + fosVal_txt.getText());
		
		String ExpvalST = "Please select Start Date";
		String ActvalST = stVal_txt.getText();
		Assert.assertEquals(ActvalST, ExpvalST);

		System.out.println(
				"Expected Validation Message for Start Date Field : " + "Please select Start Date");
		System.out.println("Actual Validation Message for Start Date Field : " + stVal_txt.getText());
		
		String ExpvalET = "Please select End Date";
		String ActvalET = etVal_txt.getText();
		Assert.assertEquals(ActvalET, ExpvalET);

		System.out.println(
				"Expected Validation Message for End Date Field : " + "Please select End Date");
		System.out.println("Actual Validation Message for End Date Field : " + etVal_txt.getText());
		
		String Expvalgd = "Please enter Grade";
		String Actvalgd = gdVal_txt.getText();
		Assert.assertEquals(Actvalgd, Expvalgd);

		System.out.println(
				"Expected Validation Message for Grade Field : " + "Please enter Grade");
		System.out.println("Actual Validation Message for Grade Field : " + gdVal_txt.getText());

	}

	public void fillTheDetails() throws Exception {
		Thread.sleep(2000);
		HigQual_ddl.click();
		Thread.sleep(1000);
		selectFromStaticList("//div[@class=\"react-select__menu-list css-qr46ko\"]//div", "Graduation");
		Thread.sleep(2000);
		Institute_ddl.sendKeys("Babaria Institute of Technology");
		Testutils.PressEnter();
		Thread.sleep(2000);
		fos_ddl.sendKeys("BE");
		Testutils.PressEnter();
		Thread.sleep(2000);
		Startyear_ddl.click();
		Thread.sleep(1000);
		Testutils.selectFromStaticList("//div[@class='react-select__menu css-1nmdiq5-menu']/div/div", "2020");
		Thread.sleep(2000);
		Startmonth_ddl.click();
		Thread.sleep(1000);
		Testutils.selectFromStaticList("//div[@class='react-select__menu css-1nmdiq5-menu']/div/div", "June");
		Thread.sleep(2000);
		Endyear_ddl.click();
		Testutils.selectFromStaticList("//div[@class='react-select__menu css-1nmdiq5-menu']/div/div", "2024");
		Thread.sleep(2000);
		Endmonth_ddl.click();
		Testutils.selectFromStaticList("//div[@class='react-select__menu css-1nmdiq5-menu']/div/div", "April");
		Thread.sleep(1000);
		grade_txt.sendKeys("65");
		Thread.sleep(1000);
		AcdAch_txt.sendKeys("I have successfully completed my education with strong academic performance.");
		Thread.sleep(1000);
		Specialsubject_txt.sendKeys("Quality Assurance");
		Thread.sleep(1000);
		Save_btn.click();
		Assert.assertEquals(SuccessonCreate_txt.getText(), "Success! Record saved.");
	}

	public void editDetails() throws InterruptedException {
		Thread.sleep(2000);
		Edit_icn.click();
		grade_txt.click();
		Testutils.selectAllValue(grade_txt);
		Testutils.removeAllValue(grade_txt);
		grade_txt.sendKeys("75");
		Thread.sleep(2000);
		Specialsubject_txt.click();
		Testutils.selectAllValue(Specialsubject_txt);
		Testutils.removeAllValue(Specialsubject_txt);
		Specialsubject_txt.sendKeys("Automation Testing");
		Save_btn.click();
		Thread.sleep(1000);
		Assert.assertEquals(SuccessonUpdate_txt.getText(), "Success! Record updated.");
		Thread.sleep(1000);
	}

	public void deleteRecord() throws InterruptedException {
		Thread.sleep(2000);
		Delete_icn.click();
		Thread.sleep(1000);
		Assert.assertEquals(SuccessonUpdate_txt.getText(), "Removed! Record deleted.");
	}

	public static void selectFromStaticList(String xPath, String value) {
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

}
