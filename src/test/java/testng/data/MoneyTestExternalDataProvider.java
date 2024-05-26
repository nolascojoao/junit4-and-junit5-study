package testng.data;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import junit5.Money;

public class MoneyTestExternalDataProvider {
	
	@Test(dataProvider = "getMoney", dataProviderClass = MoneyDataProvider.class)
	public void testConstructorWithDataProvider(int amount, String currency) {
		Money money = new Money(amount, currency);
		assertEquals(money.getAmount(), amount);
		assertEquals(money.getCurrency(), currency);
	}

}
