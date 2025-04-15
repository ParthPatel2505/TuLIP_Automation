package ProfilePages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.TestBase;
import utils.Testutils;

public class commAndPre extends TestBase {

	public commAndPre() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//*[name()='svg'][contains(@class,'tabler-icon tabler-icon-message-code')])[1]")
	WebElement CommAndPre_txt;
	@FindBy(xpath = "//button[normalize-space()='Cancel']")
	WebElement Cancel_btn;
	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement Save_btn;
	@FindBy(xpath = "//input[@id='twitter']")
	WebElement Twitter_txt;
	@FindBy(xpath = "//input[@id='linkedIn']")
	WebElement Linkedin_txt;
	@FindBy(xpath = "//input[@id='skype']")
	WebElement skype_txt;
	@FindBy(xpath = "//div[@class='ant-card-head-title']")
	WebElement title_txt;
	@FindBy(xpath = "//*[@disabled]")
	List<WebElement> Disabled_fields;
	@FindBy(xpath = "//*[@Required]")
	List<WebElement> Required_fields;
	@FindBy(xpath = "(//span[@class=\"error-msg\"])[1]")
	WebElement TwitterVal_txt;
	@FindBy(xpath = "(//span[@class=\"error-msg\"])[2]")
	WebElement LinkedinVal_txt;
	@FindBy(xpath = "(//span[@class=\"error-msg\"])[3]")
	WebElement skypeVal_txt;
	@FindBy(xpath = "(//*[name()='svg'][@class='pointer'])[1]")
	WebElement Edit_icn;

	public void navigateToCommunicationAndPreferences() throws InterruptedException {
		Testutils.scrollUsingAction(CommAndPre_txt);
		CommAndPre_txt.click();
		Thread.sleep(1000);
		Edit_icn.click();
		System.out.println("Edit Icon Working as Expected");
		Assert.assertEquals(title_txt.isDisplayed(), true);
		System.out.println("Title is displayed for Communication & Preferences");
	}

	public void closeAndCancel() throws InterruptedException {

		Thread.sleep(1000);
		Cancel_btn.click();
		Thread.sleep(1000);
		System.out.println("Cancel Button Working as Expected");
		Edit_icn.click();
		Thread.sleep(1000);
	}

	public void verifyValidations() throws InterruptedException {

		Thread.sleep(1000);
		Twitter_txt.sendKeys("d");
		Linkedin_txt.sendKeys("d");
		skype_txt.sendKeys("d");
		Save_btn.click();
		String ExpValTwitter = "Please enter valid Twitter URL";
		String ActValTwitter = TwitterVal_txt.getText();
		Assert.assertEquals(ActValTwitter, ExpValTwitter);

		System.out.println("Expected Validation Message for Twitter Field : " + "Please enter valid Twitter URL");
		System.out.println("Actual Validation Message for Twitter Field : " + TwitterVal_txt.getText());

		String ExpValLinkedin = "Please enter valid URL";
		String ActValLinkedin = LinkedinVal_txt.getText();
		Assert.assertEquals(ActValLinkedin, ExpValLinkedin);

		System.out.println("Expected Validation Message for Linkedin Field : " + "Please enter valid URL");
		System.out.println("Actual Validation Message for Linkedin Field : " + LinkedinVal_txt.getText());

		String ExpValskype = "Please enter valid Skype id";
		String ActValskype = skypeVal_txt.getText();
		Assert.assertEquals(ActValskype, ExpValskype);

		System.out.println("Expected Validation Message for Skype  Field : " + "Please enter valid Skype id");
		System.out.println("Actual Validation Message for Skype  Field : " + skypeVal_txt.getText());

		Twitter_txt.click();
		Thread.sleep(1000);
		Testutils.selectAllValue(Twitter_txt);
		Thread.sleep(1000);
		Testutils.removeAllValue(Twitter_txt);
		Thread.sleep(1000);
		Linkedin_txt.click();
		Testutils.selectAllValue(Linkedin_txt);
		Testutils.removeAllValue(Linkedin_txt);
		Thread.sleep(1000);
		skype_txt.click();
		Testutils.selectAllValue(skype_txt);
		Testutils.removeAllValue(skype_txt);
		Thread.sleep(1000);
		Cancel_btn.click();
	}

	public void disabledFields() throws InterruptedException {

		Thread.sleep(1000);
		Edit_icn.click();
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
		String generateLinkedinUrl = generateLinkedinUrl();
		System.out.println("Generated Random LinkedinUrl :" + generateLinkedinUrl);
		Linkedin_txt.sendKeys(generateLinkedinUrl);
		Thread.sleep(1000);
		String generateTwitterUrl = generateTwitterUrl();
		System.out.println("Generated Random TwitterUrl :" + generateTwitterUrl);
		Twitter_txt.sendKeys(generateTwitterUrl);
		Thread.sleep(1000);
		String generateSkypeUrl = generateSkypeUrl();
		System.out.println("Generated Random skypeUrl :" + generateSkypeUrl);
		skype_txt.sendKeys(generateSkypeUrl);
		Thread.sleep(1000);
		Save_btn.click();
	}

	public void editTheDetails() throws InterruptedException {
		Edit_icn.click();
		Twitter_txt.click();
		Thread.sleep(1000);
		Testutils.selectAllValue(Twitter_txt);
		Thread.sleep(1000);
		Testutils.removeAllValue(Twitter_txt);
		String generateTwitterUrl = generateTwitterUrl();
		System.out.println("Generated Random LinkedinUrl After Edit :" + generateTwitterUrl);
		Twitter_txt.sendKeys(generateTwitterUrl);
		Thread.sleep(1000);
		Linkedin_txt.click();
		Testutils.selectAllValue(Linkedin_txt);
		Testutils.removeAllValue(Linkedin_txt);
		String generateLinkedinUrl = generateLinkedinUrl();
		System.out.println("Generated Random TwitterUrl After Edit :" + generateLinkedinUrl);
		Linkedin_txt.sendKeys(generateLinkedinUrl);
		Thread.sleep(1000);
		skype_txt.click();
		Testutils.selectAllValue(skype_txt);
		Testutils.removeAllValue(skype_txt);
		String generateSkypeUrl = generateSkypeUrl();
		System.out.println("Generated Random skypeUrl After Edit :" + generateSkypeUrl);
		skype_txt.sendKeys(generateSkypeUrl);
		Thread.sleep(1000);
		Save_btn.click();
	}

	public void deleteTheDetails() throws InterruptedException {
		Edit_icn.click();
		Twitter_txt.click();
		Thread.sleep(1000);
		Testutils.selectAllValue(Twitter_txt);
		Thread.sleep(1000);
		Testutils.removeAllValue(Twitter_txt);
		Thread.sleep(1000);
		Linkedin_txt.click();
		Testutils.selectAllValue(Linkedin_txt);
		Testutils.removeAllValue(Linkedin_txt);
		Thread.sleep(1000);
		skype_txt.click();
		Testutils.selectAllValue(skype_txt);
		Testutils.removeAllValue(skype_txt);
		Thread.sleep(1000);
		Save_btn.click();

	}

	public String generateLinkedinUrl() {
		String protocol = "https://";
		String domain = "www.linkedin.com";
		String path = "/in/";
		String randomLinkedinUrl = protocol + domain + path + generateRandomString(6);
		return randomLinkedinUrl;
	}

	public String generateTwitterUrl() {
		String protocol = "https://";
		String domain = "twitter.com/";
		String randomTwitterUrl = protocol + domain + generateRandomString(6);
		return randomTwitterUrl;
	}

	public String generateSkypeUrl() {
		String protocol = "skype:";
		String type = "live:";
		String parameter = "?chat";
		String randomSkypeUrl = protocol + type + generateRandomString(6) + parameter;
		return randomSkypeUrl;
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
