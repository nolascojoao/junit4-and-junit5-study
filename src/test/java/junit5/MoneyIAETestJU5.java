package junit5;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class MoneyIAETestJU5 {
	
	private final static int VALID_AMOUNT = 5;
	private final static String VALID_CURRENCY = "USD";
	
	private static final Integer[][] getInvalidAmount() {
		return new Integer[][] {{-12387}, {-5}, {-1}};
	}
	
	private static final String[][] getInvalidCurrency() {
		return new String[][] {{null}, {""}};
	}
	
	@ParameterizedTest
	@MethodSource("getInvalidAmount")
	public void constructorShouldThrowIAEForInvalidAmount(int invalidAmount) {
		assertThrows(IllegalArgumentException.class, () -> new Money(invalidAmount, VALID_CURRENCY));
	}
	
	@ParameterizedTest
	@MethodSource("getInvalidCurrency")
	public void constructorShouldThrowIAEForInvalidCurrency(String invalidCurrency) {
		assertThrows(IllegalArgumentException.class, () -> new Money(VALID_AMOUNT, invalidCurrency));
	}

}
