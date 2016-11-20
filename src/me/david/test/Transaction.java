package me.david.test;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Currency;

import me.david.test.enumerates.TransactionType;

public class Transaction implements Comparator<Transaction>, Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = -5370560053247758140L;
	private Integer id;
	private String key;
	private String description;
	private TransactionType type;
	private Double value;
	private Currency currency;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key
	 *            the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the type
	 */
	public TransactionType getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(TransactionType type) {
		this.type = type;
	}

	/**
	 * @return the value
	 */
	public Double getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(Double value) {
		this.value = value;
	}

	/**
	 * @return the currency
	 */
	public Currency getCurrency() {
		return currency;
	}

	/**
	 * @param currency
	 *            the currency to set
	 */
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	@Override
	public int compare(Transaction t1, Transaction t2) {
		if (t1.currency.getCurrencyCode().equals(t2.currency.getCurrencyCode())) {
			return t1.value.compareTo(t2.value);
		} else {
			throw new ClassCastException("Attempt to compare the value of two transaction in different currencies");
		}
	}

}
