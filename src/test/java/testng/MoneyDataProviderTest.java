package testng;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit5.Money;

public class MoneyDataProviderTest {
	
	@DataProvider
	private static final Object[][] getMoney() {
		return new Object[][] {{10, "USD"}, {20, "EUR"}};
	}
	
	@Test(dataProvider = "getMoney")
	public void testConstructorWithDataProvider(int amount, String currency) {
		Money money = new Money(amount, currency);
		
		assertEquals(money.getAmount(), amount);
		assertEquals(money.getCurrency(), currency);
	}

}
