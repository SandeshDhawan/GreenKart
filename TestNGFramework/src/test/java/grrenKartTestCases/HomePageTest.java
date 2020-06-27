package grrenKartTestCases;

import org.testng.annotations.Test;

import utilities.basepage;

public class HomePageTest extends basepage {

	@Test
	public void landOnHomePage() {
		initializeDriver();
		verifyTitle("GrrenKart - veg and fruits Kart");
	}

}
