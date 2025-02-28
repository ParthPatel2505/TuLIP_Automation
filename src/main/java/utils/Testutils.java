package utils;

import java.awt.event.KeyEvent;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.awt.Robot;
import java.awt.Toolkit;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;
import com.github.javafaker.Faker;

import java.awt.datatransfer.StringSelection;


public class Testutils<switchToFrame> extends TestBase {

	// Here TestUtils class extends some properties from TestBase class;

	public static final Duration PAGE_LOAD_TIMEOUT = Duration.ofSeconds(30);
    public static final Duration IMPLICIT_WAIT = Duration.ofSeconds(30);
    public static final Duration EXPLICIT_WAIT = Duration.ofSeconds(30);
	public static String TESTDATA_SHEET_PATH = " write path of excel sheet";

	static Workbook book;
	static Sheet sheet;

	public Testutils() {
		PageFactory.initElements(driver, this);
	}

	public static void ValidateUserLogin() {
		driver.findElement(By.xpath("//span[normalize-space()='Login']")).click();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(prop.getProperty("passward"));
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
	}

	// It is used for dynamic user login

	public static void logindetails(String username, String passward) {
		driver.findElement(By.xpath("//span[normalize-space()='Login']")).click();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(passward);
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
	}


    // Method to wait for an element to be visible and then click it
    public static void waitForElementAndClick(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }
    
	// Method to perform mouse hover
	public static void mouseHover(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	// It is used for 1st level menu navigation

	public static void navigate_to_option1(WebElement menu, WebElement submenu) throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(menu).click().perform();
		Thread.sleep(3000);
		action.moveToElement(submenu).click().perform();
		Thread.sleep(2000);
	}

	// press enter with element
	public static void PressEnter(WebElement menu) throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(menu).sendKeys(Keys.ENTER).perform();
		Thread.sleep(3000);
	}

	// press enter
	public static void PressEnter() throws InterruptedException {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
		Thread.sleep(3000);
	}

	// press DOWN
	public static void PressDown() throws InterruptedException {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ARROW_DOWN).perform();
		Thread.sleep(2000);
	}

	// press UP
	public static void PressUP() throws InterruptedException {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ARROW_UP).perform();
		Thread.sleep(2000);
	}

	// Press Tab Key
	public static void PressTab() throws InterruptedException {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.TAB).perform();
		Thread.sleep(2000);
	}

	// It is used forhorizontal scroll
	public static void horizontalbar(WebElement E1) throws InterruptedException {

		Actions action = new Actions(driver);
		Actions moveToElement = action.moveToElement(E1);
		for (int i = 0; i < 5; i++) {
			moveToElement.sendKeys(Keys.RIGHT).build().perform();
		}
	}

	// It is used for dropdown selection

	public static void Dropdown_select(WebElement dropdown_element, String dropdown_text) {
		Select dropdown_option = new Select(dropdown_element);
		dropdown_option.selectByVisibleText(dropdown_text);
		// You can change it to index if required
	}

	// It is used for click on element
	public static void clickOnElement(WebElement click_element) {
		click_element.click();
	}

	// It is used for checking is element present
	public static boolean IsElementPresent(WebElement present_element) {
		return present_element.isDisplayed();
	}

	// It is used for handling window tabs
	public static void Window_handler() {
		String mainWindowHandle = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		Iterator<String> iterator = allWindowHandles.iterator();

		// Here we will check if child window has other child windows and will fetch the
		// heading of the child window
		while (iterator.hasNext()) {
			String ChildWindow = iterator.next();
			if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);
			}
		}
	}

	// Scrolling to specific x & y coordinates
	public static void scroll_until() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");
	}

	// Alert handling
	public static void alert_handle() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().alert().accept();

	}

	// Double Click on element
	public static void double_click(WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}

	// scrolling top section of page
	public static void scroll_top() {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, 0);");

	}

	// Scrolling bottom of the page
	public static void scroll_bottom() {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}

	// Scrolling to particular element
	public static void Scroll_to_element(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
	}

	// It is used for uploading file only when type = "file"
	public static void upload_file(WebDriver driver, WebElement upload_element, String file_path) {
		upload_element.sendKeys(file_path);
	}

	// It is used for Horizontal scroll clicking on count of click
	public static void Horizontal_Scroll(WebElement element, int ClickCount) {

		for (int i = 1; i <= ClickCount; i++) {
			element.click();
		}
	}

	// It is used for switching to iframe
	public static void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}

	public static void switchToFrameByElement(WebDriver driver, WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}

	public static String RandomEmailGenerator() {
		Faker faker = new Faker();
		String random_email = faker.internet().emailAddress();
		return random_email;
	}

	public static String RandomNameGenerator() {
		Faker faker = new Faker();
		String random_name = faker.name().fullName();
		return random_name;
	}

	public static String RandomWebsiteGenerator() {
		Faker faker = new Faker();
		String random_website = "https://www." + faker.internet().domainName();
		return random_website;
	}

	public static String RandomMobileNumberGenerator() {
		Faker faker = new Faker();
		String random_number = faker.phoneNumber().cellPhone();
		return random_number;
	}

	public static String generateRandomName() {
		Random random = new Random();
		String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

		// Generate the 5-character random name with at least one lowercase and one
		// uppercase letter
		StringBuilder name = new StringBuilder();
		name.append("abcdefghijklmnopqrstuvwxyz".charAt(random.nextInt(26))); // Lowercase
		name.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(random.nextInt(26))); // Uppercase
		for (int i = 2; i < 5; i++) {
			name.append(characters.charAt(random.nextInt(characters.length()))); // Random char
		}

		// Shuffle the name to randomize character positions
		return shuffleString(name.toString());
	}

	private static String shuffleString(String str) {
		Random random = new Random();
		char[] chars = str.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			int j = random.nextInt(chars.length);
			char temp = chars[i];
			chars[i] = chars[j];
			chars[j] = temp;
		}
		return new String(chars);
	}
	
	public static String fillCurrentDateTime(WebDriver driver, String formate , WebElement Element) {
        // Get current date and time and format it in the required format
        String currentDateTime = new SimpleDateFormat(formate).format(new Date()); // Format: "DD/MM/YYYY hh:mm aa"
        
        // Locate the input field by its placeholder
        WebElement inputField = Element;

        // Clear any existing value in the input field (if necessary)
        inputField.clear();

        // Enter the current date and time into the input field
        inputField.sendKeys(currentDateTime);
		return currentDateTime;
    }

			//Fetching the list from menu which is open as dropdown using ul or li tag
		public static void selectFromMenuList(String xPath, String value)
		{
			List<WebElement> liList = driver.findElements(By.xpath(xPath));
			//liList.add(plusIconListinUL);
			
			for(int i=0; i < liList.size();)
			{
				String fetchValue = liList.get(i).getText();
				System.out.println(fetchValue);
				if(fetchValue.equals(value))
				{
					String makingxPath = xPath + "[" + (i+1) + "]/span";
					driver.findElement(By.xpath(makingxPath)).click();
					break;
				}
				else
				{
					i++;
				}
			}
		}
		
		//check redirection properly
		public static boolean checkRedirection(String word)
		{
			String url = driver.getCurrentUrl().toString();
			String fetchURL = url.toLowerCase();
			//System.out.println(fetchURL);
			if(fetchURL.contains(word))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		
		//wait until element or screen loading
        public static void waitForElement(long l) throws Exception
        {
            Thread.sleep(TimeUnit.SECONDS.toMillis(l));
            //System.out.println(TimeUnit.MILLISECONDS.toMillis(l));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(l));
        }

		public static void PressrobotEnter() throws Exception {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER); // Press Enter key
			robot.keyRelease(KeyEvent.VK_ENTER); // Release Enter key
			Thread.sleep(2000); // Wait for 2 seconds
		}
		// press All with element
	public static void selectAllValue(WebElement menu) throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(menu).keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).build().perform();
		Thread.sleep(3000);
	}

	// press All with element
	public static void removeAllValue(WebElement menu) throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(menu).sendKeys(Keys.BACK_SPACE).build().perform();
		Thread.sleep(3000);
	}

	public static void bottomScrollUsingJS() {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollTo(200, document.body.scrollHeight);");
	}

	public static void topScrollUsingJS() {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollTo(-100, document.body.scrollHeight);");
	}
	
	public static void scrollUsingAction(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }
	
	// Method file upload with Robot class
	public static void uploadFileUsingRobot(WebElement uploadbutton ,String filePath) throws Exception {
        Thread.sleep(500);
		uploadbutton.click();
		Thread.sleep(1000);
		// Create Robot instance
        Robot robot = new Robot();

        // Simulate typing the file path in the file chooser dialog
        StringSelection stringSelection = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

        // Press Ctrl + V to paste the file path
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        // Press Enter to confirm the file upload
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

	public static void selectUsingAction(WebElement element, int n) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().perform();
		for (int i = 0; i < n; i++) {
			actions.sendKeys(Keys.ARROW_DOWN).perform();
		}
		actions.sendKeys(Keys.ENTER).perform();
	}
	public static void selectFromStaticList(String xPath, String value)
	{
		List<WebElement> liList = driver.findElements(By.xpath(xPath));
		
		for(int i=0; i < liList.size();)
		{
			String fetchValue = liList.get(i).getText();
			if(fetchValue.equals(value))
			{
				String makingxPath = xPath + "[" + (i+1) + "]";
				driver.findElement(By.xpath(makingxPath)).click();
				break;
			}
			else
			{
				i++;
			}
		}
	}
}
