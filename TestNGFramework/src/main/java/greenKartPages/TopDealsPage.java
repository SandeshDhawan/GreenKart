package greenKartPages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utilities.basepage;

public class TopDealsPage {
	public WebDriver driver;
	basepage basepage = new basepage();

	public TopDealsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void greenKartLogo() {
		Assert.assertTrue(basepage.verifyVisibilityOfElement(greenkartlogo));
	}

	// Locators

	@FindBy(xpath = "//div[@class='brand greenLogo']")
	WebElement greenkartlogo;

}
