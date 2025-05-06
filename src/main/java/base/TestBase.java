package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Testutils;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	// Constructor - Load Properties File
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\java\\configs\\qa.properties");
			prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to load properties file.");
		}
	}
	

	// Browser Initialization
	public static void initialization() {
		if (prop == null) {
			new TestBase(); // Ensure properties are loaded
		}

		String browserName = prop.getProperty("browser");

//        if (browserName.equalsIgnoreCase("Chrome")) {
//            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver();
		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();

			String enableDownload = prop.getProperty("enableDownload");

			if ("true".equalsIgnoreCase(enableDownload)) {
				String downloadPath = prop.getProperty("downloadPath");
				ChromeOptions options = new ChromeOptions();

				HashMap<String, Object> chromePrefs = new HashMap<>();
				chromePrefs.put("download.default_directory", downloadPath);
				options.setExperimentalOption("prefs", chromePrefs);

				driver = new ChromeDriver(options);
				System.out.println("Download path: " + downloadPath);
			} else {
				driver = new ChromeDriver(); // normal Chrome
			}

		} else if (browserName.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			throw new RuntimeException("Invalid browser specified in properties file.");
		}

		// Browser Settings
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Testutils.PAGE_LOAD_TIMEOUT);
		driver.manage().timeouts().implicitlyWait(Testutils.IMPLICIT_WAIT);

		// Open the test URL
		String testUrl = prop.getProperty("testurl");
		if (testUrl != null) {
			driver.get(testUrl);
		} else {
			throw new RuntimeException("Test URL is missing in properties file.");
		}
	}

	// Close Browser
	@AfterClass
	public static void browserclose() {
		if (driver != null) {
			driver.quit();
		}
	}
}
