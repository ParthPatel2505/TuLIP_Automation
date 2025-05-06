package MentorPanel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import base.TestBase;
import utils.Testutils;

public class candidate_management2 extends TestBase {
	String randomMail;
	StringBuilder randomstring;
	FileOutputStream file;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	String fieldValue;
	String finalEmail;
	String randomPass;
	
	public candidate_management2() {
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
	@FindBy(xpath = "//input[@id='contained-button-file']")
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
	@FindBy(xpath = "//div[@role='status']")
	WebElement succ_txt;
	@FindBy(xpath = "//div[@class='MuiTypography-root MuiTypography-body1 MuiTypography-gutterBottom MuiAlertTitle-root css-9496yh']")
	WebElement errorMsg_txt;
	@FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-nlc0qc']")
	WebElement errorMsg1_txt;
	@FindBy(xpath = "//input[@class=\"MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedEnd css-3g8nu5\"]")
	WebElement valueAtt_txt;
	@FindBy(xpath = "//div[@class=\\\"MuiButtonBase-root MuiChip-root MuiChip-filled MuiChip-sizeMedium MuiChip-colorDefault MuiChip-deletable MuiChip-deletableColorDefault MuiChip-filledDefault MuiChipsInput-Chip   css-33dw0o\\\"]/span")
	WebElement valueAtt1_txt;
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
	@FindBy(xpath = "//input[@id='login']")
	WebElement emailinput_txt;
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
	@FindBy(xpath = "//input[@id='firstname']")
	WebElement firstNameInEdit_txt;
	@FindBy(xpath = "//input[@id='lastname']")
	WebElement lastNameInEdit_txt;
	@FindBy(xpath = "//input[@id='email']")
	WebElement emailInEdit_txt;
	@FindBy(xpath = "(//button[normalize-space()='Cancel'])[1]")
	WebElement cancelInEdit_btn;
	@FindBy(xpath = "(//button[normalize-space()='Reset'])[1]")
	WebElement resetInEdit_btn;
	@FindBy(xpath = "(//button[normalize-space()='Update'])[1]")
	WebElement updateInEdit_btn;

	public void navigatetoMentorPanel() throws InterruptedException {
		Thread.sleep(3000);
		Profile_Icn.click();
		Thread.sleep(800);
		mentorPanel_txt.click();
	}

	public void navigateToCandidateManagement() throws InterruptedException {
		Testutils.scrollUsingAction(canMng_txt);
		canMng_txt.click();
		Thread.sleep(1000);
	}


	public void openFile() throws InterruptedException, FileNotFoundException {
		Thread.sleep(2000);
		inviteCan_btn.click();
		Thread.sleep(1000);
		file = new FileOutputStream(System.getProperty("user.dir") + "\\Testdata\\CandidateValidEmails.xlsx");
		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet("Data");
		XSSFRow row0 = sheet.createRow(0);
		row0.createCell(0).setCellValue("Email");
	}

	public void closeFile() throws IOException, InterruptedException {
		workbook.write(file);
		workbook.close();
		file.close();
		Thread.sleep(1000);
		fileUpload_txt
				.sendKeys("C:\\Users\\tntra\\eclipse-workspace\\TuLIP_Automation\\Testdata\\CandidateValidEmails.xlsx");
		Thread.sleep(1000);
		Assert.assertEquals("File uploaded successfully.", succ_txt.getText());
	}

	public void addDetailsInFile(String randomEmail, int length, int i) throws IOException, InterruptedException {

		while (i <= length) {
			sheet.createRow(i).createCell(0).setCellValue(randomEmail);
			System.out.println("Generated Email is " + randomEmail);
			i++;
		}

	}

	public void validationOnDuplicateEmail() throws IOException, InterruptedException {
		Thread.sleep(800);
		openFile();
		addDetailsInFile(generatedRandomMail(), 3, 1);
		closeFile();
		Thread.sleep(800);
		Assert.assertEquals("Invalid Data", errorMsg_txt.getText());
		System.out.println(errorMsg_txt.getText());
		Thread.sleep(800);
		String expectedError = randomMail + " is duplicated on lines 2, 3, 4 Please correct it.";
		Thread.sleep(800);
		Assert.assertEquals(errorMsg1_txt.getText(), expectedError);
		System.out.println(errorMsg1_txt.getText());
		Thread.sleep(800);
		verifyFieldValue();
		cancel_btn.click();
	}

	public void validationOnExistingEmail() throws IOException, InterruptedException {
		Thread.sleep(1000);
		openFile();
		addDetailsInFile("chand.patel@tntra.io", 1, 1);
		closeFile();
		Thread.sleep(800);
		Assert.assertEquals("Invalid Data", errorMsg_txt.getText());
		System.out.println(errorMsg_txt.getText());
		Thread.sleep(800);
		String expectedError = "The email ID present on Row 2 already exists in the Candidate list: [chand.patel@tntra.io].";
		Thread.sleep(800);
		Assert.assertEquals(errorMsg1_txt.getText(), expectedError);
		System.out.println(errorMsg1_txt.getText());
		Thread.sleep(800);
		verifyFieldValue();
		cancel_btn.click();

	}

	public void validationOnInvalidEmail() throws InterruptedException, IOException {
		Thread.sleep(800);
		openFile();
		addDetailsInFile(generateRandomString(10), 1, 1);
		closeFile();
		Thread.sleep(800);
		Assert.assertEquals("Invalid Data", errorMsg_txt.getText());
		System.out.println(errorMsg_txt.getText());
		Thread.sleep(800);
		String expectedError = "The email ID present on Row 2 is invalid: [" + randomstring + "]. Please check.";
		Thread.sleep(800);
		Assert.assertEquals(errorMsg1_txt.getText(), expectedError);
		System.out.println(errorMsg1_txt.getText());
		Thread.sleep(800);
		verifyFieldValue();
		Thread.sleep(800);
		cancel_btn.click();
	}

	public void validFileUploadFlow() throws IOException, InterruptedException {
		Thread.sleep(800);
		openFile();
		Thread.sleep(800);
		addDetailsInFile(generatedRandomMail(), 1, 1);
		addDetailsInFile(generatedRandomMail(), 2, 2);
		addDetailsInFile(generatedRandomMail(), 3, 3);
		addDetailsInFile(generatedRandomMail(), 4, 4);
		addDetailsInFile(generatedRandomMail(), 5, 5);
		Thread.sleep(800);
		closeFile();
		Thread.sleep(800);
		verifyFieldValues(
				"(//div[@class=\"MuiButtonBase-root MuiChip-root MuiChip-filled MuiChip-sizeMedium MuiChip-colorDefault MuiChip-deletable MuiChip-deletableColorDefault MuiChip-filledDefault MuiChipsInput-Chip   css-33dw0o\"]/span)");
		Thread.sleep(800);
		send_btn.click();
		Thread.sleep(1200);
		Assert.assertEquals(succ_txt.getText(), "Email sent successfully.");

	}

	public void emailVerification() throws InterruptedException {

		Thread.sleep(2000);
		driver.get("https://yopmail.com");
		Thread.sleep(100);
		String usernameOnly = finalEmail.split("@")[0];
		System.out.println("Username : " + usernameOnly);
		emailinput_txt.sendKeys(usernameOnly);
		Thread.sleep(1000);
		gotobutton_btn.click();
		Thread.sleep(1500);
		driver.switchTo().frame(mailSidebar_iframe);
		Thread.sleep(1000);
		firstMail_box.click();
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		driver.switchTo().frame(mailFormat_iframe);
		Thread.sleep(800);
		signup_txt.click();
		Thread.sleep(800);
		driver.switchTo().defaultContent();
		System.out.println("New Email Verification Successfully.");
		List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(windowHandles.get(1));

	}

	public void fillSignupForm() throws InterruptedException {

		Testutils.scrollUsingAction(register_btn);
		Thread.sleep(1500);
		Assert.assertEquals(false, !register_btn.isEnabled());
		String randomname = generateRandomString(5);
		firstName_txt.sendKeys(randomname);
		Thread.sleep(800);
		lastName_txt.sendKeys(randomname);
		Thread.sleep(800);
		email_txt.sendKeys(finalEmail);
		Thread.sleep(800);
		randomPass = generateRandomString(10);
		Thread.sleep(800);
		passward_txt.sendKeys(randomPass + "@Aa123");
		Thread.sleep(800);
		confirmPass_txt.sendKeys(randomPass + "@Aa123");
		Thread.sleep(800);
		checkbox_chk.click();
		Thread.sleep(500);
		register_btn.click();
		Thread.sleep(1500);
		Assert.assertEquals(succ_txt.getText(), "Success! Record saved.");
		Thread.sleep(500);
		System.out.println("Email Verification sent Successfully.");

	}

	public void emailVerify() throws InterruptedException {

		Thread.sleep(2000);
		driver.get("https://yopmail.com");
		Thread.sleep(800);
		closeInInput_txt.click();
		Thread.sleep(800);
		String usernameOnly = finalEmail.split("@")[0];
		System.out.println("Username : " + usernameOnly);
		emailinput_txt.sendKeys(usernameOnly);
		Thread.sleep(800);
		gotobutton_btn.click();
		Thread.sleep(1000);
		driver.switchTo().frame(mailSidebar_iframe);
		Thread.sleep(500);
		firstMail_box.click();
		Thread.sleep(800);
		driver.switchTo().defaultContent();
		Thread.sleep(800);
		driver.switchTo().frame(mailFormat_iframe);
		Thread.sleep(800);
		verifyEmail_txt.click();
		Thread.sleep(800);
		List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(windowHandles.get(2));
		Thread.sleep(1500);
		Assert.assertEquals(succ_txt.getText(), "Success! Email verified.");
		Thread.sleep(1000);
		System.out.println("New Email Verification Successfully.");
	}

	public void login() throws InterruptedException {
		Thread.sleep(800);
		tpId_txt.sendKeys(finalEmail);
		Thread.sleep(500);
		pass_txt.sendKeys(randomPass + "@Aa123");
		Thread.sleep(500);
		login_btn.click();
		Thread.sleep(1000);
		Assert.assertEquals(succ_txt.getText(), "Success! You have Logged-In.");
	}

	public void verifyFieldValue() {
		fieldValue = "value";
		if (fieldValue.isEmpty()) {
			System.out.println("This field is empty");
		} else {
			System.out.println("The field is not empty. Value : " + fieldValue);
		}
	}

	public void verifyFieldValues(String xpath) {
		for (int i = 1; i <= 5; i++) {
			String makeXpath = xpath + "[" + i + "]";
			WebElement element = driver.findElement(By.xpath(makeXpath));
			String fetchValue = element.getText();
			System.out.println("Value at index " + i + ": " + fetchValue);

			if (i == 1) {
				finalEmail = fetchValue;
			}
		}
	}

	public String generatedRandomMail() {
		randomMail = generateRandomString(5) + "@Yopmail.com";
		return randomMail;
	}

	public String generateRandomString(int length) {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		randomstring = new StringBuilder();
		Random random = new Random();

		for (int i = 0; i < length; i++) {
			int randomIndex = random.nextInt(characters.length());
			randomstring.append(characters.charAt(randomIndex));
		}
		return randomstring.toString();
	}

	public void downloadFiles() throws InterruptedException {
		inviteCan_btn.click();
		Thread.sleep(1000);
		xlsx_txt.click();
		Thread.sleep(500);
		csv_txt.click();
		Thread.sleep(500);
		cancel_btn.click();
		Thread.sleep(1000);
	}
}
