package testng.data;

import static org.testng.Assert.assertThrows;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit5.Money;

public class MoneyIAETestNG {

	private static final int VALID_AMOUNT = 5;
	private static final String VALID_CURRENCY = "USD";

	@DataProvider(name = "getInvalidAmount")
	public Object[][] getInvalidAmount() {
		return new Object[][] { { -12387 }, { -5 }, { -1 } };
	}

	@DataProvider(name = "getInvalidCurrency")
	public Object[][] getInvalidCurrency() {
		return new Object[][] { { null }, { "" } };
	}

	/*@Test(dataProvider = "getInvalidAmount", expectedExceptions = IllegalArgumentException.class)
    public void constructorsShouldThrowIAEForInvalidAmount(int invalidAmount) {
        new Money(invalidAmount, VALID_CURRENCY);
    }

    @Test(dataProvider = "getInvalidCurrency", expectedExceptions = IllegalArgumentException.class)
    public void constructorShouldThrowIAEForInvalidCurrency(String invalidCurrency) {
        new Money(VALID_AMOUNT, invalidCurrency);
    }*/
	
	@Test(dataProvider = "getInvalidAmount")
    public void constructorsShouldThrowIAEForInvalidAmount(int invalidAmount) {
        assertThrows(IllegalArgumentException.class, () -> new Money(invalidAmount, VALID_CURRENCY));
    }

    @Test(dataProvider = "getInvalidCurrency")
    public void constructorShouldThrowIAEForInvalidCurrency(String invalidCurrency) {
        assertThrows(IllegalArgumentException.class, () -> new Money(VALID_AMOUNT, invalidCurrency));
    }

}
