package junit5;

import java.util.Objects;

public class Money {

	private final int amount;
	private final String currency;

	public Money(int amount, String currency) {
		if (amount < 0) {
			throw new IllegalArgumentException(
					"illegal amount: " + amount);
		}
		if (currency == null || currency.isEmpty()) {
			throw new IllegalArgumentException(
					"illegal currency " + currency);
		}
		this.amount = amount;
		this.currency = currency;
	}

	public int getAmount() {
		return amount;
	}

	public String getCurrency() {
		return currency;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, currency);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Money other = (Money) obj;
		return amount == other.amount && Objects.equals(currency, other.currency);
	}

}
