package ProfilePages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import base.TestBase;
import utils.Testutils;

public class MyBlogs extends TestBase {

	public MyBlogs() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement Save_btn;
	@FindBy(xpath = "//a[@href='/tntra/profile/my-blogs']//*[name()='svg']")
	WebElement MyBlogs_txt;
	@FindBy(xpath = "//button[normalize-space()='Cancel']")
	WebElement Cancel_btn;
	@FindBy(xpath = "//*[@disabled]")
	List<WebElement> Disabled_fields;
	@FindBy(xpath = "//*[@Required]")
	List<WebElement> Required_fields;
	@FindBy(xpath = "//input[@name='publicationDate']")
	WebElement PubDate_ddl;
	@FindBy(xpath = "//div[@class='react-select__input-container css-18w4uv4']")
	WebElement Topic_ddl;
	@FindBy(xpath = "//input[@id='url']")
	WebElement Url_txt;
	@FindBy(xpath = "//input[@id='title']")
	WebElement Title_txt;
	@FindBy(xpath = "//div[@class='ant-card-extra']//*[name()='svg']")
	WebElement Plus_icn;
	@FindBy(xpath = "(//*[name()='svg'][@class='pointer actionIcon undefined'])[1]")
	WebElement Edit_icn;
	@FindBy(xpath = "(//*[name()='svg'][@class='pointer actionIcon undefined'])[2]")
	WebElement Delete_icn;
	@FindBy(xpath = "//div[@role='status']")
	WebElement Succ_msg;
	@FindBy(xpath = "(//span[@class=\"error-msg\"and contains(text(), \"Please\")])[1]")
	WebElement TitleVal_msg;
	@FindBy(xpath = "(//span[@class=\"error-msg\"and contains(text(), \"Please\")])[2]")
	WebElement UrlVal_msg;
	@FindBy(xpath = "(//*[name()='svg'][@class='css-8mmkcg'])[1]")
	WebElement CloseTopic_icn;

	public void navigateToMyBlogs() throws InterruptedException {
		Testutils.scrollUsingAction(MyBlogs_txt);
		MyBlogs_txt.click();
		Thread.sleep(1000);
		Plus_icn.click();
		System.out.println("Plus Icon Working as Expected");

	}

	public void closeAndCancel() throws InterruptedException {

		Thread.sleep(1000);
		Cancel_btn.click();
		Thread.sleep(1000);
		System.out.println("Cancel Button Working as Expected");
		Plus_icn.click();
		Thread.sleep(1000);
	}

	public void verifyValidations() throws InterruptedException {

		Thread.sleep(1000);
		Save_btn.click();
		Thread.sleep(1000);

		String ExpValTitle = "Please enter Blog Title";
		String ActValTitle = TitleVal_msg.getText();
		Assert.assertEquals(ActValTitle, ExpValTitle);

		System.out.println("Expected Validation Message for Title Field : " + "Please enter Blog Title");
		System.out.println("Actual Validation Message for Title Field : " + TitleVal_msg.getText());

		String ExpValURL = "Please enter the Blog URL";
		String ActValURL = UrlVal_msg.getText();
		Assert.assertEquals(ActValURL, ExpValURL);

		System.out.println("Expected Validation Message for URL Field : " + "Please enter the Blog URL");
		System.out.println("Actual Validation Message for URL Field : " + UrlVal_msg.getText());

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
		Assert.assertEquals(Required_fields.size(), 2);
	}

	public void fillTheDetails() throws InterruptedException {

		Thread.sleep(1000);
		Title_txt.click();
		String RandomTitle = generateRandomString(10);
		System.out.println("Generated Random Title :" + RandomTitle);
		Title_txt.sendKeys(RandomTitle);
		Thread.sleep(1000);
		Url_txt.click();
		Thread.sleep(1000);
		String RandomUrl = generateRandomUrl();
		System.out.println("Generated Random URL :" + RandomUrl);
		Url_txt.sendKeys(RandomUrl);
		Thread.sleep(1000);
		PubDate_ddl.click();
		String Date = generateDate();
		PubDate_ddl.sendKeys(Date);
		Testutils.PressEnter();
		System.out.println("Today's Date :" + Date);
		Thread.sleep(1000);
		Title_txt.click();
		String RandomTopic = generateRandomString(6);
		System.out.println("Generated Random Topic :" + RandomTopic);
		Title_txt.sendKeys(RandomTopic);
		Testutils.PressEnter();
		Thread.sleep(1000);
		Save_btn.click();
		Thread.sleep(1000);
		Assert.assertEquals(Succ_msg.getText(), "Success! Record saved.");
		System.out.println("Record Created Successfully");
	}

	public void Editdetails() throws InterruptedException {

		Thread.sleep(1000);
		Edit_icn.click();
		Thread.sleep(1000);
		Title_txt.click();
		Testutils.selectAllValue(Title_txt);
		Testutils.removeAllValue(Title_txt);
		String RandomTitle = generateRandomString(10);
		System.out.println("Generated Random Title After Editing :" + RandomTitle);
		Title_txt.sendKeys(RandomTitle);
		Thread.sleep(1000);
		Url_txt.click();
		Testutils.selectAllValue(Url_txt);
		Testutils.removeAllValue(Url_txt);
		Thread.sleep(1000);
		String RandomUrl = generateRandomUrl();
		System.out.println("Generated Random URL After Editing :" + RandomUrl);
		Url_txt.sendKeys(RandomUrl);
		Thread.sleep(1000);
		Title_txt.click();
		CloseTopic_icn.click();
		String RandomTopic = generateRandomString(6);
		System.out.println("Generated Random Topic After Editing :" + RandomTopic);
		Title_txt.sendKeys(RandomTopic);
		Testutils.PressEnter();
		Thread.sleep(1000);
		Save_btn.click();
		Thread.sleep(1000);
		Assert.assertEquals(Succ_msg.getText(), "Success! Record updated.");
		Thread.sleep(1000);
		System.out.println("Record Edited Successfully");
		Thread.sleep(1000);
	}

	public void deletedetails() throws InterruptedException {
		Thread.sleep(1000);
		Delete_icn.click();
		Thread.sleep(1000);
		Assert.assertEquals(Succ_msg.getText(), "Removed! Record deleted.");
		Thread.sleep(1000);
		System.out.println("Record Deleted Successfully");
	}

	public String generateDate() {
		LocalDate today = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String formattedDate = today.format(formatter);
		return formattedDate;
	}

	public String generateRandomUrl() {
		String protocol = "https://";
		String domain = generateRandomString(5);
		String fullUrl = protocol + domain + ".com";
		return fullUrl;
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
