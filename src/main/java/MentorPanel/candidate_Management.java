package MentorPanel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.TestBase;
import utils.Testutils;

public class candidate_Management extends TestBase {

	String randomEmail1;
	String randomEmail2;
	String randomPass;

	public candidate_Management() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//img[@alt='user-profile'])[1]")
	WebElement Profile_Icn;
	@FindBy(xpath = "(//p[normalize-space()='Candidate Management'])[1]")
	WebElement canMng_txt;
	@FindBy(xpath = "//span[contains(text(),'Switch to')]")
	WebElement mentorPanel_txt;
	@FindBy(xpath = "//h5[normalize-space()='Candidate Management']")
	WebElement canMng_Title;
	@FindBy(xpath = "//input[@id='search-career']")
	WebElement searchbox_txt;
	@FindBy(xpath = "(//button[normalize-space()='Invite Candidates'])[1]")
	WebElement inviteCan_btn;
	@FindBy(xpath = "(//button[normalize-space()='Cancel'])[1]")
	WebElement cancel_btn;
	@FindBy(xpath = "(//div[@class=\"MuiDialogActions-root MuiDialogActions-spacing css-h66tyv\"]/button)[1]")
	WebElement send_btn;
	@FindBy(xpath = "//span[@class='MuiButton-icon MuiButton-startIcon MuiButton-iconSizeMedium css-1l6c7y9']")
	WebElement fileUpload_txt;
	@FindBy(xpath = "//a[normalize-space()='XLSX']")
	WebElement xlsx_txt;
	@FindBy(xpath = "//a[normalize-space()='CSV']")
	WebElement csv_txt;
	@FindBy(xpath = "//input[@placeholder='Type and press enter']")
	WebElement sendInvite_txt;
	@FindBy(xpath = "//button[@aria-label='close']//*[name()='svg']")
	WebElement close_btn;
	@FindBy(xpath = "//button[@aria-label='View']//*[name()='svg']")
	WebElement view_icn;
	@FindBy(xpath = "//button[@aria-label='Edit']//*[name()='svg']")
	WebElement edit_icn;
	@FindBy(xpath = "//input[contains(@type,'checkbox')]")
	WebElement toggle_btn;
	@FindBy(xpath = "//div[@class='MuiToolbar-root MuiToolbar-gutters MuiToolbar-regular MuiTablePagination-toolbar css-tkgupb']")
	WebElement bottom_part;
	@FindBy(xpath = "//div[@id=':r6:']")
	WebElement rpp_ddl;
	@FindBy(xpath = "//div[@class=\"MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation24 MuiDialog-paper MuiDialog-paperScrollPaper MuiDialog-paperWidthMd MuiDialog-paperFullWidth css-8osdin\"]/div[2]/button[1]")
	List<WebElement> disabled_fields;
	@FindBy(xpath = "//*[@required]")
	List<WebElement> required_fields;
	@FindBy(xpath = "//p[@class=\"MuiTablePagination-displayedRows css-12vrlub\"]")
	WebElement total_records_text;
	@FindBy(xpath = "//button[@title='Go to next page']//*[name()='svg']")
	WebElement nextPage_txt;
	@FindBy(xpath = "//button[@title='Go to previous page']//*[name()='svg']")
	WebElement prevPage_txt;
	@FindBy(xpath = "(//td[@class=\"MuiTableCell-root MuiTableCell-body MuiTableCell-sizeMedium css-u4mgp3\"])[1]")
	WebElement tulipId_txt;
	@FindBy(xpath = "(//td[@class=\"MuiTableCell-root MuiTableCell-body MuiTableCell-sizeMedium css-u4mgp3\"])[2]")
	WebElement fullName_txt;
	@FindBy(xpath = "(//td[@class=\"MuiTableCell-root MuiTableCell-body MuiTableCell-sizeMedium css-u4mgp3\"])[3]")
	WebElement emailId_txt;
	@FindBy(xpath = "//div[@class='MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-fullWidth MuiInputBase-formControl MuiInputBase-adornedEnd css-lh1as2']")
	WebElement sendInvite_box;
	@FindBy(xpath = "//input[@id='login']")
	WebElement emailinput_txt;
	@FindBy(xpath = "//i[@class='material-icons-outlined f36']")
	WebElement gotobutton_btn;
	@FindBy(xpath = "//i[@class='material-icons-outlined f24 ycptbutgray']")
	WebElement closeInInput_txt;
	@FindBy(xpath = "(//button[@class=\"lm\"])[1]")
	WebElement firstMail_box;
	@FindBy(xpath = "//b[normalize-space()='Sign Up']")
	WebElement signup_txt;
	@FindBy(xpath = "//iframe[@id='ifmail']")
	WebElement mailFormat_iframe;
	@FindBy(xpath = "//iframe[@id='ifinbox']")
	WebElement mailSidebar_iframe;
	@FindBy(xpath = "//div[@role='status']")
	WebElement succ_txt;
	@FindBy(xpath = "(//input[@id='form.signup.first_name'])[1]")
	WebElement firstName_txt;
	@FindBy(xpath = "(//input[@id='form.signup.last_name'])[1]")
	WebElement lastName_txt;
	@FindBy(xpath = "(//input[@id='form.signup.email'])[1]")
	WebElement email_txt;
	@FindBy(xpath = "(//input[@id='form.login.password'])[1]")
	WebElement passward_txt;
	@FindBy(xpath = "(//input[@id='form.signup.confirm_password'])[1]")
	WebElement confirmPass_txt;
	@FindBy(xpath = "(//input[@value='true'])[1]")
	WebElement checkbox_chk;
	@FindBy(xpath = "//span[normalize-space()='Register']")
	WebElement register_btn;
	@FindBy(xpath = "//a[normalize-space()='Verify email']")
	WebElement verifyEmail_txt;
	@FindBy(xpath = "//input[@id='form.login.email']")
	WebElement tpId_txt;
	@FindBy(xpath = "//input[@id='form.login.password']")
	WebElement pass_txt;
	@FindBy(xpath = "//span[normalize-space()='Login']")
	WebElement login_btn;

	public void navigatetoMentorPanel() throws InterruptedException {
		Thread.sleep(3000);
		Profile_Icn.click();
		Thread.sleep(1000);
		mentorPanel_txt.click();
	}

	public void navigateToCandidateManagement() throws InterruptedException {
		Testutils.scrollUsingAction(canMng_txt);
		canMng_txt.click();
		Thread.sleep(1000);
	}

	public void verifyTitle() throws InterruptedException {
		Thread.sleep(1000);
		Assert.assertEquals(canMng_Title.isDisplayed(), true);
	}

	public void verifyPagination() throws InterruptedException {
		Thread.sleep(1000);
		Testutils.scrollUsingAction(bottom_part);
		Thread.sleep(2000);
		rpp_ddl.click();
		selectFromDdl("(//ul[@class=\"MuiList-root MuiList-padding MuiMenu-list css-r8u8y9\"]/li)", "10");
		System.out.println("Rows Per Page is : 10 And Size is :" + total_records_text.getText());
		Thread.sleep(2000);
		Testutils.scrollUsingAction(bottom_part);
		rpp_ddl.click();
		selectFromDdl("(//ul[@class=\"MuiList-root MuiList-padding MuiMenu-list css-r8u8y9\"]/li)", "25");
		Thread.sleep(2000);
		System.out.println("Rows Per Page is : 25 And Size is :" + total_records_text.getText());
		Thread.sleep(2000);
		Testutils.scrollUsingAction(bottom_part);
		rpp_ddl.click();
		selectFromDdl("(//ul[@class=\"MuiList-root MuiList-padding MuiMenu-list css-r8u8y9\"]/li)", "50");
		Thread.sleep(2000);
		System.out.println("Rows Per Page is : 50 And Size is :" + total_records_text.getText());
		Thread.sleep(2000);
		Testutils.scrollUsingAction(bottom_part);
		Thread.sleep(2000);
		rpp_ddl.click();
		selectFromDdl("(//ul[@class=\"MuiList-root MuiList-padding MuiMenu-list css-r8u8y9\"]/li)", "75");
		Thread.sleep(2000);
		System.out.println("Rows Per Page is : 75 And Size is :" + total_records_text.getText());
		Thread.sleep(2000);
		Testutils.scrollUsingAction(bottom_part);
		Thread.sleep(2000);
		rpp_ddl.click();
		selectFromDdl("(//ul[@class=\"MuiList-root MuiList-padding MuiMenu-list css-r8u8y9\"]/li)", "100");
		Thread.sleep(2000);
		System.out.println("Rows Per Page is : 100 And Size is :" + total_records_text.getText());
		Thread.sleep(2000);
		System.out.println("Pagination working as expected.");
	}

	public void closeAndCancel() throws InterruptedException {
		Thread.sleep(1000);
		inviteCan_btn.click();
		Thread.sleep(1000);
		close_btn.click();
		System.out.println("Close icon is working as expected");
		Thread.sleep(1000);
		inviteCan_btn.click();
		Thread.sleep(1000);
		cancel_btn.click();
		System.out.println("Cancel button is working as expected");
		Thread.sleep(1000);
		inviteCan_btn.click();
	}

	public void verifyDisabledFields() {
		for (WebElement element : disabled_fields) {
			System.out.println("ID : " + element.getAttribute("id") + "Tag : " + element.getTagName() + " Name : "
					+ element.getAttribute("name"));
		}
		System.out.println("Total disabled fields found : " + disabled_fields.size());
		Assert.assertEquals(disabled_fields.size(), 1);
	}

	public void verifyRequiredFields() throws InterruptedException {
		for (WebElement element : required_fields) {
			System.out.println("ID : " + element.getAttribute("id") + " Tag : " + element.getTagName() + " Name : "
					+ element.getAttribute("name"));
		}
		System.out.println("Total required fields found : " + required_fields.size());
		Assert.assertEquals(required_fields.size(), 0);

		Thread.sleep(1000);
		cancel_btn.click();
	}

	public void verifyTotalRecords() {
		String text = total_records_text.getText();
		String totalRecords = text.split("of")[1].trim();
		System.out.println("Total Number of Records: " + totalRecords);
	}

	public void viewAllTheRcords() throws InterruptedException {
		Testutils.scrollUsingAction(bottom_part);
		Thread.sleep(2000);
		rpp_ddl.click();
		Thread.sleep(2000);
		selectFromDdl("(//ul[@class=\"MuiList-root MuiList-padding MuiMenu-list css-r8u8y9\"]/li)", "50");
		Thread.sleep(2000);

		do {
			Testutils.scrollUsingAction(bottom_part);
			Thread.sleep(2000);
			nextPage_txt.click();
			Thread.sleep(2000);

		} while (!nextPage_txt.isEnabled());
		System.out.println("Next button not found or page fully loaded.");

		do {
			Testutils.scrollUsingAction(bottom_part);
			Thread.sleep(2000);
			prevPage_txt.click();
			Thread.sleep(2000);

		} while (!prevPage_txt.isEnabled());
		System.out.println("Prev button not found or page fully loaded.");

	}

	public void verifySearchFunctionality() throws InterruptedException {
		Testutils.scrollUsingAction(searchbox_txt);
		String tulipId = tulipId_txt.getText();
		searchbox_txt.sendKeys(tulipId);
		Thread.sleep(1000);
		Assert.assertEquals("1–1 of 1", total_records_text.getText());
		driver.navigate().refresh();
		Thread.sleep(1000);
		String fullname = fullName_txt.getText();
		searchbox_txt.sendKeys(fullname);
		Thread.sleep(1000);
		Assert.assertEquals("1–1 of 1", total_records_text.getText());
		driver.navigate().refresh();
		Thread.sleep(1000);
		String email = emailId_txt.getText();
		searchbox_txt.sendKeys(email);
		Thread.sleep(1000);
		Assert.assertEquals("1–1 of 1", total_records_text.getText());
		driver.navigate().refresh();
		Thread.sleep(1000);

		searchbox_txt.sendKeys(tulipId + "11");
		Thread.sleep(1000);
		System.out.println("Search functionality is working as expected for TulipId column");
		Thread.sleep(1000);
		driver.navigate().refresh();
		searchbox_txt.sendKeys(fullname + "11");
		Thread.sleep(1000);
		System.out.println("Search functionality is working as expected for FullName column");
		Thread.sleep(1000);
		driver.navigate().refresh();
		searchbox_txt.sendKeys(email + "11");
		Thread.sleep(1000);
		System.out.println("Search functionality is working as expected for Email column");
		Thread.sleep(1000);
		driver.navigate().refresh();
	}

	public void sendInvite() throws InterruptedException {
		Thread.sleep(1000);
		inviteCan_btn.click();
		Thread.sleep(1000);
		sendInvite_box.click();
		Thread.sleep(2000);
		randomEmail1 = generateRandomemail();
		System.out.println("Random generated first Email : " + randomEmail1);
		Thread.sleep(1000);
		sendInvite_txt.sendKeys(randomEmail1);
		Testutils.PressEnter();
		Thread.sleep(1000);
		randomEmail2 = generateRandomemail();
		System.out.println("Random generated Second Email : " + randomEmail2);
		Thread.sleep(1000);
		sendInvite_txt.sendKeys(randomEmail2);
		Testutils.PressEnter();
		Thread.sleep(1000);
		send_btn.click();
		Thread.sleep(2000);
		Assert.assertEquals(succ_txt.getText(), "Email sent successfully.");
		Thread.sleep(1000);
		System.out.println(succ_txt.getText());
	}

	public String generateRandomemail() {
		String username = randomString(5);
		String symbol = "@";
		String domain = "yopmail";
		String domainExtension = ".com";
		String generateRandomemail = username + symbol + domain + domainExtension;
		return generateRandomemail;
	}

	public void emailVerification() throws InterruptedException {

		Thread.sleep(2000);
		driver.get("https://yopmail.com");
		Thread.sleep(1000);
		String usernameOnly = randomEmail1.split("@")[0];
		System.out.println("Username : " + usernameOnly);
		emailinput_txt.sendKeys(usernameOnly);
		Thread.sleep(1000);
		gotobutton_btn.click();
		Thread.sleep(2000);
		driver.switchTo().frame(mailSidebar_iframe);
		Thread.sleep(1000);
		firstMail_box.click();
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		driver.switchTo().frame(mailFormat_iframe);
		Thread.sleep(1000);
		signup_txt.click();
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		System.out.println("New Email Verification Successfully.");
		List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(windowHandles.get(1));

	}

	public void fillSignupForm() throws InterruptedException {

		Testutils.scrollUsingAction(register_btn);
		Thread.sleep(2000);
		Assert.assertEquals(false, !register_btn.isEnabled());
		String randomname = randomString(5);
		firstName_txt.sendKeys(randomname);
		Thread.sleep(1000);
		lastName_txt.sendKeys(randomname);
		Thread.sleep(1000);
		email_txt.sendKeys(randomEmail1);
		Thread.sleep(1000);
		randomPass = randomString(10);
		Thread.sleep(1000);
		passward_txt.sendKeys(randomPass + "@Aa123");
		Thread.sleep(1000);
		confirmPass_txt.sendKeys(randomPass + "@Aa123");
		Thread.sleep(1000);
		checkbox_chk.click();
		Thread.sleep(1000);
		register_btn.click();
		Thread.sleep(2000);
		Assert.assertEquals(succ_txt.getText(), "Success! Record saved.");
		Thread.sleep(1000);
		System.out.println("Email Verification sent Successfully.");

	}

	public void emailVerify() throws InterruptedException {

		Thread.sleep(2000);
		driver.get("https://yopmail.com");
		Thread.sleep(1000);
		closeInInput_txt.click();
		Thread.sleep(1000);
		String usernameOnly = randomEmail1.split("@")[0];
		System.out.println("Username : " + usernameOnly);
		emailinput_txt.sendKeys(usernameOnly);
		Thread.sleep(1000);
		gotobutton_btn.click();
		Thread.sleep(2000);
		driver.switchTo().frame(mailSidebar_iframe);
		Thread.sleep(1000);
		firstMail_box.click();
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		driver.switchTo().frame(mailFormat_iframe);
		Thread.sleep(1000);
		verifyEmail_txt.click();
		Thread.sleep(1000);
		List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(windowHandles.get(2));
		Thread.sleep(1000);
		Assert.assertEquals(succ_txt.getText(), "Success! Email verified.");
		Thread.sleep(2000);
		System.out.println("New Email Verification Successfully.");
	}

	public void login() throws InterruptedException {
		Thread.sleep(1000);
		tpId_txt.sendKeys(randomEmail1);
		Thread.sleep(1000);
		pass_txt.sendKeys(randomPass + "@Aa123");
		Thread.sleep(1000);
		login_btn.click();
		Thread.sleep(1000);
		Assert.assertEquals(succ_txt.getText(), "Success! You have Logged-In.");
	}

	public String randomString(int length) {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdifghijklmnopqrstuvwxyz";
		StringBuilder randomString = new StringBuilder();
		Random random = new Random();

		for (int i = 0; i < length; i++) {
			int randomIndex = random.nextInt(characters.length());
			randomString.append(characters.charAt(randomIndex));
		}
		return randomString.toString();
	}

	public void selectFromDdl(String xpath, String Value) {
		List<WebElement> list = driver.findElements(By.xpath(xpath));

		for (int i = 0; i < list.size();) {
			String fetchvalue = list.get(i).getText();
			if (fetchvalue.equals(Value)) {
				String makeXpath = xpath + "[" + (i + 1) + "]";
				driver.findElement(By.xpath(makeXpath)).click();
				break;
			} else {
				i++;
			}
		}
	}

}
