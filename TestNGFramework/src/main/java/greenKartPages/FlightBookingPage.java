package greenKartPages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPath;

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

public class FlightBookingPage {
	public WebDriver driver;
	basepage basepage = new basepage();

	public FlightBookingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void explicitwait() {
		basepage.waitunilElementisPresent(flightlabel, 5, driver);
	}

	public void select_from_to_details() {
		basepage.clickElement(from_drop_down);
		basepage.clickElement(from_chennai);
		basepage.clickElement(to_mumbai);
	}

	public void select_passangers(int adult, int child, int infant) {
		basepage.clickElement(flightlabel);
		basepage.waitunilElementisPresent(passanger_dropdown, 5, driver);
		basepage.clickElement(passanger_dropdown);

		basepage.waitunilElementisPresent(adultinc, 5, driver);

		for (int i = 0; i < adult - 1; i++)
			basepage.clickElement(adultinc);

		for (int i = 0; i < child; i++)
			basepage.clickElement(childinc);

		for (int i = 0; i < infant; i++)
			basepage.clickElement(infantinc);

		if (!(adult + child + infant >= 10))
			basepage.clickElement(done);

	}

	public void verifyalertmessage() {
		System.out.println(basepage.getalerttext(driver));

		Assert.assertEquals(basepage.getalerttext(driver),
				"You are allowed a maximum of 9 passengers per booking online. If your party is larger than this, please call our reservation center.");
	}

	public void selectcurrency(String currency) {

		basepage.clickElement(currencydropdown);
		basepage.waitunilElementisPresent(currency_inr, 5, driver);

		if (currency.equalsIgnoreCase("INR"))
			basepage.clickElement(currency_inr);
		else if (currency.equalsIgnoreCase("AED"))
			basepage.clickElement(currency_aed);
		else if (currency.equalsIgnoreCase("USD"))
			basepage.clickElement(currency_usd);
	}

	public void select_checkbox(String value) {

		basepage.waitunilElementisPresent(family_and_friends_checkbox, 5, driver);

		if (value.equalsIgnoreCase("Family and Friends"))
			basepage.clickElement(family_and_friends_checkbox);
		else if (value.equalsIgnoreCase("Senior Citizen"))
			basepage.clickElement(senior_citizen_checkbox);
		else if (value.equalsIgnoreCase("Indian Armed Forces"))
			basepage.clickElement(indian_armed_forces_checkbox);
		else if (value.equalsIgnoreCase("Student"))
			basepage.clickElement(student_checkbox);
		else if (value.equalsIgnoreCase("Unaccompanied Minor"))
			basepage.clickElement(Unaccompanied_minor_checkbox);

	}

	public void special_assistance() {
		basepage.clickElement(special_assistance);
		basepage.waitunilElementisPresent(special_assistance_header, 10, driver);

		System.out.println(basepage.getTextValue(special_assistance_header));
		Assert.assertEquals(basepage.getTextValue(special_assistance_header), "SPECIAL ASSISTANCE");
		basepage.clickElement(close_special_assistance);
	}

	public void tooltip_for_student() {
		System.out.println(basepage.getTextValue(student_tool_tip));
		Assert.assertEquals(basepage.getTextValue(student_tool_tip),
				"Applicable for all students above the age of 12 years studying with a bonafide school/university. Limited inventory available. Valid photo ID and educational institute I-card need to be presented for verification at check-in. Bookings under this offer are refundable. Conditions apply.");
		
//		Assert.assertEquals(basepage.getTextValue(student_tool_tip),"Test");
	}

	public void multicity_popup() {
		basepage.sleep(5000);
		basepage.clickElement(multicity_radio_button);
		System.out.println(basepage.getTextValue(multicity_content));
		Assert.assertEquals(basepage.getTextValue(multicity_content),
				"Multicity booking does not mean connecting flight. Customers must ensure sufficient connecting time between flights. QAclickjet will not be responsible for missed connections due to any reason.");
		
//		Assert.assertEquals(basepage.getTextValue(multicity_content),"Test");
		basepage.clickElement(information_ok_button);
	}

	// Locators

	@FindBy(xpath = "//span[@class='text-label'][text()='Flights']")
	WebElement flightlabel;

	@FindBy(xpath = "//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")
	WebElement from_drop_down;

	@FindBy(xpath = "//a[text()=' Chennai (MAA)']")
	WebElement from_chennai;

	@FindBy(xpath = "//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[text()=' Mumbai (BOM)']")
	WebElement to_mumbai;

	@FindBy(xpath = "//div[text()='1 Adult']")
	WebElement passanger_dropdown;

	@FindBy(xpath = "//div[@id='divAdult']//span[@id='hrefIncAdt']")
	WebElement adultinc;

	@FindBy(xpath = "//div[@id='divChild']//span[@id='hrefIncChd']")
	WebElement childinc;

	@FindBy(xpath = "//div[@id='divInfant']//span[@id='hrefIncInf']")
	WebElement infantinc;

	@FindBy(xpath = "//input[@value='Done']")
	WebElement done;

	@FindBy(xpath = "//select[@id='ctl00_mainContent_DropDownListCurrency']")
	WebElement currencydropdown;

	@FindBy(xpath = " //option[text()='INR']")
	WebElement currency_inr;

	@FindBy(xpath = "//option[text()='AED']")
	WebElement currency_aed;

	@FindBy(xpath = "//option[text()='USD']")
	WebElement currency_usd;

	@FindBy(id = "ctl00_mainContent_chk_friendsandfamily")
	WebElement family_and_friends_checkbox;

	@FindBy(id = "ctl00_mainContent_chk_SeniorCitizenDiscount")
	WebElement senior_citizen_checkbox;

	@FindBy(id = "ctl00_mainContent_chk_IndArm")
	WebElement indian_armed_forces_checkbox;

	@FindBy(id = "ctl00_mainContent_chk_StudentDiscount")
	WebElement student_checkbox;

	@FindBy(id = "ctl00_mainContent_chk_Unmr")
	WebElement Unaccompanied_minor_checkbox;

	@FindBy(xpath = "//a[text()='Special Assistance']")
	WebElement special_assistance;

	@FindBy(xpath = "//div[@class='SpecialAssistanceModalHeader']")
	WebElement special_assistance_header;

	@FindBy(xpath = "//div[@id='StudentDiv']//span[@class='search-offer-tooltip mobile-tooltip-left']")
	WebElement student_tool_tip;

	@FindBy(xpath = "//input[@id='ctl00_mainContent_rbtnl_Trip_2']")
	WebElement multicity_radio_button;

	@FindBy(className = "popup-close2")
	WebElement close_special_assistance;

	@FindBy(xpath = "//div[@class='MultiCityContent']/p")
	WebElement multicity_content;

	@FindBy(id = "MultiCityModelAlert")
	WebElement information_ok_button;

}
