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

public class HomePage extends basepage {
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void greenKartLogo() {
		Assert.assertTrue(verifyVisibilityOfElement(greenkartlogo));
	}

	public void topDealLink() {
		Assert.assertTrue(checkElementIsClickable(topdeals));
	}

	public void flightBookingLink() {
		Assert.assertTrue(checkElementIsClickable(flightbooking));
	}

	public void itemsAndPriceSection() {
		Assert.assertTrue(verifyVisibilityOfElement(items));
		Assert.assertTrue(verifyVisibilityOfElement(price));
	}

	public void cartIcon() {
		Assert.assertTrue(checkElementIsClickable(carticon));
	}

	public void searchvegetable(String vegetablename) {
		driver.navigate().refresh();
		enterData(search, vegetablename);
		sleep(2000);
		String vegname = getTextValue(searchvegname);
		String names[] = vegname.split(" ");
		Assert.assertEquals(names[0], vegetablename);
	}

	public void searchvegetableisnotpresent(String vegetablename) {
		driver.navigate().refresh();
		cleartextboxvalue(search);
		sleep(2000);
		enterData(search, vegetablename);
		sleep(2000);
		String msg = getTextValue(noresulterrormsg);
		System.out.println(msg);
		Assert.assertEquals(msg, "Sorry, no products matched your search!");

	}

	public void detailsPresentOnSearhVegetable(String vegetablename, String price) {
		driver.navigate().refresh();
		cleartextboxvalue(search);

		enterData(search, vegetablename);
		sleep(3000);
		String vegname = getTextValue(searchvegname);
		String actualprice = getTextValue(productprice);

		Assert.assertEquals(vegname, vegetablename);
		Assert.assertEquals(actualprice, price);
		checkElementIsClickable(addtocartbutton);

	}

	public void add_n_Kg_vegetable(String veg, int kg) {
		driver.navigate().refresh();
		cleartextboxvalue(search);
		enterData(search, veg);
		sleep(3000);

		for (int i = 1; i < kg; i++)
			clickElement(addquantity);

		String quantity = getAttributeValue(addedquantity, "value");
		System.out.println("Added Quantity = " + quantity);

		Assert.assertEquals(Integer.parseInt(quantity), kg);

	}

	// Locators

	@FindBy(xpath = "//div[@class='brand greenLogo']")
	WebElement greenkartlogo;

	@FindBy(xpath = "//a[text()='Top Deals']")
	WebElement topdeals;

	@FindBy(xpath = "//a[text()='Flight Booking']")
	WebElement flightbooking;

	@FindBy(xpath = "//td[text()='Items']")
	WebElement items;

	@FindBy(xpath = "//td[text()='Price']")
	WebElement price;

	@FindBy(className = "cart-icon")
	WebElement carticon;

	@FindBy(xpath = "//input[@type='search']")
	WebElement search;

	@FindBy(xpath = "//h4[@class='product-name']")
	WebElement searchvegname;

	@FindBy(xpath = "//div[@class='no-results']//h2")
	WebElement noresulterrormsg;

	@FindBy(xpath = "//p[@class='product-price']")
	WebElement productprice;

	@FindBy(xpath = "//div[@class='product-action']//button")
	WebElement addtocartbutton;

	@FindBy(xpath = "//a[@class='increment']")
	WebElement addquantity;

	@FindBy(xpath = "//input[@type='number']")
	WebElement addedquantity;
}
