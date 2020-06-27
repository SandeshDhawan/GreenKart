package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class basepage {

	public WebDriver driver;
	Properties prop = new Properties();
	String browserName = null;
	String url;
	String propertyFileName = "C:\\Users\\sdhawan\\TestNGFramework\\TestNGFramework\\src\\main\\java\\Utilities\\data.properties";
	FileInputStream file;

	public WebDriver initializeDriver() {

		try {
			file = new FileInputStream(propertyFileName);
			try {
				prop.load(file);
				browserName = prop.getProperty("browser");
			} catch (IOException e) {
				e.printStackTrace();
			}

			if (browserName.equalsIgnoreCase("Chrome")) {
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("Firefox")) {
				System.out.println("Firefox driver is Opening");
				driver = new FirefoxDriver();
			} else if (browserName.equalsIgnoreCase("IE")) {
				driver = new InternetExplorerDriver();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		maximizeBrowser();
		openURL();
		return driver;
	}

	public boolean verifyTitle(String Title) {
		boolean status;

		if (driver.getTitle().equals(Title)) {
			System.out.println("Title Matches");
			status = true;
		} else {
			System.out.println("Title Present:-" + driver.getTitle());
			status = false;
		}
		return status;
	}

	public void openURL() {
		try {
			file = new FileInputStream(propertyFileName);
			try {
				prop.load(file);
				url = prop.getProperty("url");
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		driver.get(url);

	}

	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}
}
