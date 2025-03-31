package ProfilePages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.TestBase;

public class Feedback extends TestBase {

	public Feedback() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//*[name()='svg'][@class='tabler-icon tabler-icon-message-plus pointer'])[1]")
	WebElement Feedback_icn;
	@FindBy(xpath = "//span[@aria-label='close']//*[name()='svg']")
	WebElement Close_icn;
	@FindBy(xpath = "//span[@aria-label='close-circle']//*[name()='svg']")
	WebElement Inclose_icn;
	@FindBy(xpath = "//span[normalize-space()='Cancel']")
	WebElement Cancel_btn;
	@FindBy(xpath = "//span[normalize-space()='Send Feedback']")
	WebElement Send_btn;
	@FindBy(xpath = "//span[@class='ant-select-selection-item']")
	WebElement Feedback_ddl;
	@FindBy(xpath = "//textarea[@id='Give_feedback.letus_know']")
	WebElement Adddetails_txt;
	@FindBy(xpath = "(//span[@class=\"ant-typography css-2jq066\"])[2]")
	WebElement Basicmsg_txt;
	@FindBy(xpath = "//span[@class=\"ant-typography ant-typography-danger css-2jq066\"]")
	List<WebElement> Required_fields;
	@FindBy(xpath = "//*[@disabled]")
	List<WebElement> Disabled_fields;
	@FindBy(xpath = "//div[@role='status']")
	WebElement Sucmsg_txt;

	public void disabledFields() throws InterruptedException {

		for (WebElement Element : Disabled_fields) {
			System.out.println("Tag: " + Element.getTagName() + ", Name: " + Element.getAttribute("name") + ", ID: "
					+ Element.getAttribute("id"));
		}
		System.out.println("Total disabled fields found : " + Disabled_fields.size());
		Assert.assertEquals(Disabled_fields.size(), 1);
	}

	public void requiredFields() {
		for (WebElement Element : Required_fields) {
			System.out.println("Tag: " + Element.getTagName() + ", Name: " + Element.getAttribute("name") + ", ID: "
					+ Element.getAttribute("id"));
		}
		System.out.println("Total required fields found : " + Required_fields.size());
		Assert.assertEquals(Required_fields.size(), 2);
	}

	public void hoverMessage() throws InterruptedException {
		Actions Action = new Actions(driver);
		Action.moveToElement(Feedback_icn).perform();
		Thread.sleep(2000);
	}

	public void closeAndCancel() throws InterruptedException {
		Thread.sleep(1000);
		Feedback_icn.click();
		Thread.sleep(1000);
		Cancel_btn.click();
		Thread.sleep(1000);
		Feedback_icn.click();
		Thread.sleep(1000);
		Close_icn.click();
		Thread.sleep(1000);
	}

	public void basicMsg() throws InterruptedException {
		Thread.sleep(1000);
		Feedback_icn.click();
		Thread.sleep(1000);
		String Actmsg = Basicmsg_txt.getText();
		String Expmsg = "No personal details are to be provided as part of the Feedback Description.";
		Assert.assertEquals(Expmsg, Actmsg);
		System.out.println("Expected Message for User : "
				+ "No personal details are to be provided as part of the Feedback Description.");
		System.out.println("Actual Message for User : " + Basicmsg_txt.getText());
		Cancel_btn.click();
		Thread.sleep(1000);
	}

	public void fillTheDetails() throws InterruptedException {
		Thread.sleep(2000);
		Feedback_icn.click();
		Thread.sleep(1000);
		Feedback_ddl.click();
		Thread.sleep(1000);
		selectFromStaticList("(//*[@class=\"ant-space-item\"]//span)", "Leave a Comment");
		Thread.sleep(1000);
		String randomFeedback = generateRandomString(50);
		Adddetails_txt.sendKeys(randomFeedback);
		Thread.sleep(1000);
		Inclose_icn.click();
		String randomFeedback1 = generateRandomString(100);
		Adddetails_txt.sendKeys(randomFeedback1);
		Send_btn.click();
		Thread.sleep(1000);
		Assert.assertEquals("Success! Feedback Submitted.", Sucmsg_txt.getText());
		Thread.sleep(1000);
		System.out.println("I'm glad your feedback was successfully submitted.");
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
