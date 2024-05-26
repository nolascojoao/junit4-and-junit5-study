package junit4;

import static org.junit.Assert.assertThrows;

import org.junit.Test;
import org.junit.runner.RunWith;

import junit5.Money;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class MoneyIAETest {

	private static final  int VALID_AMOUNT = 5;
	private static final  String VALID_CURRENCY = "USD";

	private static final Object[] getInvalidAmount() {
        return new Object[] {
            new Object[] { -12387 },
            new Object[] { -5 },
            new Object[] { -1 }
        };
    }

	private static final Object[] getInvalidCurrency() {
        return new Object[] {
            new Object[] { null },
            new Object[] { "" }
        };
    }

	@Test
	@Parameters(method = "getInvalidAmount")
	public void constructorsShouldThrowIAEForInvalidAmount(int invalidAmount) {
		assertThrows(IllegalArgumentException.class, () -> new Money(invalidAmount, VALID_CURRENCY));
	}

	@Test
	@Parameters(method = "getInvalidCurrency")
	public void constructorShouldThrowIAEForInvalidCurrency(String invalidCurrency) {
		assertThrows(IllegalArgumentException.class, () -> new Money(VALID_AMOUNT, invalidCurrency));
	}

}
