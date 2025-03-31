package AutomationAcceleration;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Testutils;

public class openInnEngVenCardDetails extends TaskandChallengesDetails
{
	@FindBy(xpath = "//p[text()='Innovation']")
	WebElement typeofInnFavTrending;
	public static String strTypeofInnFavTrending = "//p[text()='Innovation']";
	@FindBy(xpath = "//p[text()='Engineering']")
	WebElement typeofEngFavTrending;
	public static String strTypeofEngFavTrending = "//p[text()='Engineering']";
	@FindBy(xpath = "//p[text()='Ventures']")
	WebElement typeofVenFavTrending;
	public static String strTypeofVenFavTrending = "//p[text()='Ventures']";
	
	@FindBy(xpath = "//h5[text()='QA Automation']")
	WebElement favTrendingInnName;
	public static String strFavTrendingInnName = "//h5[text()='QA Automation']";
	@FindBy(xpath = "//h5[text()='QA Automation']")
	WebElement favTrendingEngName;
	public static String strFavTrendingEngName = "//h5[text()='QA Automation']";
	@FindBy(xpath = "//h5[text()='Tntra']")
	WebElement favTrendingVenName;
	public static String strFavTrendingVenName = "//h5[text()='Tntra']";
	
	
	public static String strFavTrendTile = "//div[@class='ant-row css-yg0chk']/div";
	@FindBy(xpath= "//div[@class='ant-row css-yg0chk']/div")
	WebElement favTrendTile;
	@FindBy(xpath = "//div[text()='Favourites']")
	static WebElement favTab;
	
	@FindBy(xpath = "//*[@class='topFront  fade-in pointer']")
	WebElement dashoardImage;
	@FindBy(xpath = "//*[@class='mt-5 mb-4']//*/a[text()='View All']")
	WebElement viewAll;
	@FindBy(xpath = "//button[@type='button' and contains(@class,'variant-link')]")
	static WebElement showMore;
	@FindBy(xpath = "//button[.//*[contains(text(), 'Filters')]]")
	WebElement filtersButton;
	@FindBy(xpath = "//li//*[text()='Type']")
	WebElement typeOption;
	@FindBy(xpath = "//span[contains(text(),'Innovation')]")
	WebElement selectInn;
	@FindBy(xpath = "//span[contains(text(),'Engineering')]")
	WebElement selectEng;
	@FindBy(xpath = "//span[contains(text(),'Ventures')]")
	WebElement selectVen;
	
	public static void selectTilefromList(WebElement xPath, WebElement typeOfInn, WebElement innName, String screen) throws Exception
	{
		List<WebElement> liList = xPath.findElements(By.xpath("//div[@class='ant-row css-yg0chk']/div/div"));
		System.out.println("No of Divs := "+liList.size());
		
		for(int i=0; i < liList.size();i++)
		{
			WebElement trendingName = null;
			WebElement trending = null;
			String makingTypeOfTrending;
			String makingTrendingName;
			String fetchValue;
			String fetchInnNameValue;
			String makingxPath;
			
			if(screen.equals("Ventures"))
			{
			makingTypeOfTrending = strFavTrendTile+ "/div[" + (i+1) + "]//*" + strTypeofVenFavTrending;
			System.out.println(makingTypeOfTrending);
			makingTrendingName = strFavTrendTile+ "/div[" + (i+1) + "]//*" + strFavTrendingVenName;
			System.out.println(makingTrendingName);
			
			try
			{
				trendingName = driver.findElement(By.xpath(makingTrendingName));
				trending = driver.findElement(By.xpath(makingTypeOfTrending));
			
				if(trending.isDisplayed() && trendingName.isDisplayed())
				{
					fetchValue = trending.getText().toString();
					fetchInnNameValue = trendingName.getText().toString();
					/*
					 * if(fetchValue.equals(prop.getProperty("automationAccelerationVen")) &&
					 * fetchInnNameValue.equals(prop.getProperty("Comp"))) { makingxPath =
					 * strFavTrendTile + "/div[" + (i+1) + "]/div";
					 * driver.findElement(By.xpath(makingxPath)).click();
					 * System.out.println("#####  "+screen+" Tile Open  #####"); break; }
					 */
					do {
						showMore.click();
					}while((fetchValue.equals(prop.getProperty("automationAccelerationVen")) && fetchInnNameValue.equals(prop.getProperty("Comp"))));
					
				}
				
						
			}
			catch(Exception e)
			{
				i++;
			}
			
			
			}
			else
			{
				showMore.click();
			}
		}
			
			
//			else if(screen.equals("Innovation"))
//			{
//			makingTypeOfTrending = strFavTrendTile+ "/div[" + (i+1) + "]//*" + strTypeofInnFavTrending;
//			System.out.println(makingTypeOfTrending);
//			makingTrendingName = strFavTrendTile+ "/div[" + (i+1) + "]//*" + strFavTrendingInnName;
//			System.out.println(makingTrendingName);
//			
//			try
//			{
//				trendingName = driver.findElement(By.xpath(makingTrendingName));
//				trending = driver.findElement(By.xpath(makingTypeOfTrending));
//			
//				if(trending.isDisplayed() && trendingName.isDisplayed())
//				{
//					fetchValue = trending.getText().toString();
//					fetchInnNameValue = trendingName.getText().toString();
//					if(fetchValue.equals(prop.getProperty("automationAccelerationInn")) && fetchInnNameValue.equals(prop.getProperty("Title")))
//					{
//						makingxPath = strFavTrendTile + "/div[" + (i+1) + "]/div";
//						driver.findElement(By.xpath(makingxPath)).click();
//						System.out.println("#####  "+screen+" Tile Open  #####");
//						break;
//					}
//					
//				}		
//			}
//			catch(Exception e)
//			{
//				i++;
//			}
//			
//			}
//			else if(screen.equals("Engineering"))
//			{
//			makingTypeOfTrending = strFavTrendTile+ "/div[" + (i+1) + "]//*" + strTypeofEngFavTrending;
//			System.out.println(makingTypeOfTrending);
//			makingTrendingName = strFavTrendTile+ "/div[" + (i+1) + "]//*" + strFavTrendingEngName;
//			System.out.println(makingTrendingName);
//			
//			try
//			{
//				trendingName = driver.findElement(By.xpath(makingTrendingName));
//				trending = driver.findElement(By.xpath(makingTypeOfTrending));
//			
//				if(trending.isDisplayed() && trendingName.isDisplayed())
//				{
//					fetchValue = trending.getText().toString();
//					fetchInnNameValue = trendingName.getText().toString();
//					if(fetchValue.equals(prop.getProperty("automationAccelerationEng")) && fetchInnNameValue.equals(prop.getProperty("Title")))
//					{
//						makingxPath = strFavTrendTile + "/div[" + (i+1) + "]/div";
//						driver.findElement(By.xpath(makingxPath)).click();
//						System.out.println("#####  "+screen+" Tile Open  #####");
//						break;
//					}
//				}
//			
//						
//			}
//			catch(Exception e)
//			{
//					i++;
//			}
//			
//			}
//		}
//		
	}
	
	public void selectTile(String typeOfTrend, String projectName) throws Exception
	{
		WebElement element = driver.findElement(By.xpath("(//div[.//h5[contains(text(), '"+projectName+"')]])[9]"));
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			try {
			    // Wait until the element is visible
			    wait.until(ExpectedConditions.visibilityOf(element));
			    
			    // Check if the element is displayed and clickable
			    if (element.isDisplayed()) {
			        element.click();
			        Testutils.waitForElement(10);
			    } else {
			        // Scroll down and then click "Show More"
			        Testutils.bottomScrollUsingJS();
			        wait.until(ExpectedConditions.elementToBeClickable(showMore)); // Wait until showMore is clickable
			        showMore.click();
			        Testutils.waitForElement(10);
			    }
			} catch (TimeoutException e) {
			    // Handle cases where the element wasn't found in the expected time
			    System.out.println("Element not found or timed out");
			}
	}
		catch(Exception e)
		{
			Testutils.bottomScrollUsingJS();
			showMore.click();
			Testutils.waitForElement(10);
		}
	}
	
	
	public void openFromDashboard() throws Exception
	{
		PageFactory.initElements(driver, this);
		//driver.navigate().to("https://tulip-uat.tntra.io/tntra/dashboard");
		Testutils.waitForElement(10);
		//System.out.println("Clicked on Image");
		try
		{
			if(dashoardImage.isDisplayed())
			{
				dashoardImage.click();
			}
		}
		catch(Exception e)
		{
			
		}
		//dashoardImage.click();
		Testutils.waitForElement(4);
		viewAll.click();
		System.out.println("Clicked on View All.");
		Testutils.waitForElement(5);
		//favTab.click();
		//Testutils.waitForElement(5);
		
	}
	
	public void openCardDetails(String screenName) throws Exception
	{
		PageFactory.initElements(driver, this);
		Testutils.waitForElement(10);
		if(screenName.equals(prop.getProperty("automationAccelerationInn")))
		{
			Testutils.waitForElement(3);
			filtersButton.click();
			Testutils.waitForElement(2);
			typeOption.click();
			Testutils.waitForElement(2);
			selectInn.click();
			selectTile(prop.getProperty("automationAccelerationInn"), prop.getProperty("Title"));
			tasks();
			challenges();
			//favTab.click();
			Testutils.waitForElement(3);
		}
		else if(screenName.equals(prop.getProperty("automationAccelerationEng")))
		{
			Testutils.waitForElement(3);
			filtersButton.click();
			Testutils.waitForElement(2);
			typeOption.click();
			Testutils.waitForElement(2);
			selectEng.click();
			selectTile(prop.getProperty("automationAccelerationEng"), prop.getProperty("Title"));
			tasks();
			challenges();
			//favTab.click();
			Testutils.waitForElement(3);
			
		}else if(screenName.equals(prop.getProperty("automationAccelerationVen")))
		{
			Testutils.waitForElement(3);
			filtersButton.click();
			Testutils.waitForElement(2);
			typeOption.click();
			Testutils.waitForElement(2);
			selectVen.click();
			selectTile(prop.getProperty("automationAccelerationVen"), prop.getProperty("VenComp"));
			tasks();
			challenges();
			//favTab.click();
			Testutils.waitForElement(3);
		} 
	}	
}