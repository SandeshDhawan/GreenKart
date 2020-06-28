package greenKartTestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import greenKartPages.HomePage;
import utilities.basepage;

public class TopDealsTest extends basepage {

	public WebDriver driver;

	@BeforeClass
	public void landOnHomePage() {
		driver = initializeDriver();
		verifyTitle("GrrenKart - veg and fruits Kart");

	}

	@Test(priority = 1)
	public void verify_user_is_able_to_navigate_to_Top_Deals_page() {
		HomePage hp = new HomePage(driver);
		String parent = get_parent_window_handle();
		hp.navigateToTopDeals();
		switch_to_new_window();
		switch_to_parent_window(parent);

	}

	@AfterClass
	public void CloseBrowser() {
		quit();
	}

}
