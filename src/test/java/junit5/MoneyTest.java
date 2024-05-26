package junit5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MoneyTest {

	@Test
	public void constructorShouldSetAmountAndCurrency() {
		int amount = 10;
		String currency = "USD";
		Money money = new Money(amount, currency);

		assertEquals(amount, money.getAmount());
		assertEquals(currency, money.getCurrency());

		/*
		amount = 20;
		currency = "EUR";
		money = new Money(amount, currency);

		assertEquals(amount, money.getAmount());
		assertEquals(currency, money.getCurrency());
		*/
	}

}
