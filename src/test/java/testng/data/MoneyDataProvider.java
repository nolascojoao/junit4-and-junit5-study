package testng.data;

import org.testng.annotations.DataProvider;

public class MoneyDataProvider {
	
	@DataProvider
	public static final Object[][] getMoney() {
		return new Object[][] {{10, "USD"}, {20, "EUR"}};
	}

}
