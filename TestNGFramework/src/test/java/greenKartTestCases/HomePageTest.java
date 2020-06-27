package greenKartTestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import greenKartPages.HomePage;
import utilities.basepage;

public class HomePageTest extends basepage {

	public WebDriver driver;

	@BeforeClass
	public void landOnHomePage() {
		driver = initializeDriver();
		verifyTitle("GrrenKart - veg and fruits Kart");

	}

	@Test(priority = 1)
	public void verifyGreenKartLogo() {
		HomePage hp = new HomePage(driver);
		hp.greenKartLogo();
	}

	@Test(priority = 2)
	public void verifyTopDealsLink() {
		HomePage hp = new HomePage(driver);
		hp.topDealLink();
	}

	@Test(priority = 3)
	public void verifyflightBookingLink() {
		HomePage hp = new HomePage(driver);
		hp.flightBookingLink();
	}

	@Test(priority = 4)
	public void verifyitemsAndPriceSection() {
		HomePage hp = new HomePage(driver);
		hp.itemsAndPriceSection();
	}

	@Test(priority = 5)
	public void verifycartIcon() {
		HomePage hp = new HomePage(driver);
		hp.cartIcon();
	}

	@Test(priority = 6)
	public void verifySearhFunctionality() {
		HomePage hp = new HomePage(driver);
		hp.searchvegetable("Cucumber");
	}

	@Test(priority = 7)
	public void verifySearchVegetableIsNotPresent() {
		HomePage hp = new HomePage(driver);
		hp.searchvegetableisnotpresent("test");
	}

	@Test(priority = 8)
	public void verifyDetailsOnSearchvegetable() {
		HomePage hp = new HomePage(driver);
		hp.searchvegetable("Beans");
		hp.detailsPresentOnSearhVegetable("Beans - 1 Kg", "82");

	}

	@Test(priority = 9)
	public void verify_user_add_n_Kg_vegetable() {
		HomePage hp = new HomePage(driver);
		hp.add_n_Kg_vegetable("Walnuts", 5);

	}
	
	@Test(priority=10)
	public void verify_user_is_able_to_add_multilpe_vegetables(){
		
	}

	@AfterClass
	public void CloseBrowser() {
		quit();
	}

}
