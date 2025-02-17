package utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.Select;
import base.TestBase;
import com.github.javafaker.Faker;

public class Testutils<switchToFrame> extends TestBase {
	
	//Here TestUtils class extends some properties from TestBase class;
	
	static Testutils<Object> testutil = new Testutils<Object>();
	
	public static final long PAGE_LOAD_TIMEOUT = 30;
	public static final long IMPLICIT_WAIT = 30;
	public static String TESTDATA_SHEET_PATH = " write path of excel sheet";

	static Workbook book;
	static Sheet sheet;
	
	
	public Testutils()
	{
		PageFactory.initElements(driver,this);
	}
	

	public static void ValidateUserLogin() {
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
	}
	
	//It is used for dynamic user login
	
	
	
	// Method to perform mouse hover
    public static void mouseHover(WebElement element) 
    {
    	Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }
		
	//press enter with element
		public static void PressEnter(WebElement menu) throws InterruptedException
		{
			Actions action = new Actions(driver);
			action.moveToElement(menu).sendKeys(Keys.ENTER).perform();
			Thread.sleep(3000);
		}
	
	//press enter 
		public static void PressEnter() throws InterruptedException
		{
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ENTER).perform();
			Thread.sleep(3000);
		}
		
		//press DOWN 
				public static void PressDown() throws InterruptedException
				{
					Actions action = new Actions(driver);
					action.sendKeys(Keys.ARROW_DOWN).perform();
					Thread.sleep(2000);
				}	
				
		//press UP 
				public static void PressUP() throws InterruptedException
				{
					Actions action = new Actions(driver);
					action.sendKeys(Keys.ARROW_UP).perform();
					Thread.sleep(2000);
				}	
	
	//Press Tab Key
		public static void PressTab() throws InterruptedException
		{
			Actions action = new Actions(driver);
			action.sendKeys(Keys.TAB).perform();
			Thread.sleep(2000);
		}
		// It is used forhorizontal scroll
		public static void horizontalbar(WebElement E1) throws InterruptedException
		{
			Actions action = new Actions(driver);
			Actions moveToElement = action.moveToElement(E1);
			for (int i = 0; i < 5; i++) {
			    moveToElement.sendKeys(Keys.RIGHT).build().perform();
			}
		}

		// It is used for dropdown selection
		
		public static void Dropdown_select(WebElement dropdown_element,String dropdown_text)
		{
			Select dropdown_option = new Select(dropdown_element);
			dropdown_option.selectByVisibleText(dropdown_text); 
			//You can change it to index if required
		}
		
		
		//Fetching the list from menu which is open as dropdown using ul or li tag
		public void selectFromMenuList(String xPath, String value)
		{
			List<WebElement> liList = driver.findElements(By.xpath(xPath));
			//liList.add(plusIconListinUL);
			
			for(int i=0; i < liList.size();)
			{
				String fetchValue = liList.get(i).getText();
				//System.out.println(fetchValue);
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
		
		
		// It is used for click on element
		public void ElementOnClick(WebElement click_element)
		{
			click_element.click();
		}
		
		
		// It is used for checking is element present
		public static boolean IsElementPresent(WebElement present_element)
		{
			return present_element.isDisplayed();
		}
		
		// It is used for handling window tabs
		public static void Window_handler() 
		{
			String mainWindowHandle = driver.getWindowHandle();
	        Set<String> allWindowHandles = driver.getWindowHandles();
	        Iterator<String> iterator = allWindowHandles.iterator();

	        // Here we will check if child window has other child windows and will fetch the heading of the child window
	        while (iterator.hasNext()) 
	        {
	            String ChildWindow = iterator.next();
	                if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) 
	                {
	                driver.switchTo().window(ChildWindow);
		               }
	        }
		}		
		//Scrolling to specific x & y coordinates
		public static void scroll_until() 
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,600)");
		}
		
		//Alert handling 
		public static void alert_handle()
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 driver.switchTo().alert().accept();
		     
		}
		
		//Double Click on element
		public static void  double_click(WebElement element)
		{
			Actions act = new Actions(driver);
			act.doubleClick(element).perform();
		}
		
		//scrolling top section of page
		public static void scroll_top() {
	        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	        jsExecutor.executeScript("window.scrollTo(0, 0);");

	    }
		
		//Scrolling bottom of the page
		 public static void scroll_bottom() {
		        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		    }
		
		
		//Scrolling to particular element
		public void Scroll_to_element(WebElement element)
		{
			((JavascriptExecutor) driver)
			.executeScript("arguments[0].scrollIntoView();", element);
		}

		
		// It is used for uploading file only when type = "file"
		public static void upload_file(WebElement upload_element,String file_path) 
		{
			upload_element.sendKeys(file_path);
		}
		
		// It is used for Horizontal scroll clicking on count of click
		public static void Horizontal_Scroll(WebElement element,int ClickCount) {

			for (int i = 1; i <= ClickCount; i++) {
				element.click();
			}
		}
	
		
		// It is used for switching to iframe
		public void switchToFrame() 
		{
			driver.switchTo().frame("mainpanel");
		}
		
		
		public static String RandomEmailGenerator()
		{
			Faker faker = new Faker();
			String random_email =  faker.internet().emailAddress(); 
			return random_email;
		}
		
		public static String RandomNameGenerator()
		{
			Faker faker = new Faker();
			String random_name =  faker.name().fullName(); 
			return random_name;
		}
		
		public static String RandomWebsiteGenerator()
		{
			Faker faker = new Faker();
			String random_website =  "https://www."+faker.internet().domainName();  
			return random_website;
		}
		
		public static String RandomMobileNumberGenerator()
		{
			Faker faker = new Faker();
			String random_number =  faker.phoneNumber().cellPhone(); 
			return random_number;
		}
		
		//wait until element or screen loading
		public void waitForElement(long l) throws Exception
		{
			Thread.sleep(TimeUnit.SECONDS.toMillis(l));
			//System.out.println(TimeUnit.MILLISECONDS.toMillis(l));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(l));
		}
		
		//check redirection properly
		public boolean checkRedirection(String word)
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
		
		
}

