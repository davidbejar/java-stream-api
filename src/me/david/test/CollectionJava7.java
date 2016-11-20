package me.david.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import me.david.test.enumerates.TransactionType;

public class CollectionJava7 {

	public List<Integer> getOrderedGroceriesTransactions(List<Transaction> transactions) {
		List<Transaction> groceryTransactions = new ArrayList<>();
		for (Transaction t : transactions) {
			if (t.getType() == TransactionType.GROCERIES) {
				groceryTransactions.add(t);
			}
		}
		Collections.sort(groceryTransactions, new Comparator<Transaction>() {
			@Override
			public int compare(Transaction t1, Transaction t2) {
				return t2.getValue().compareTo(t1.getValue());
			};
		});
		List<Integer> transactionIds = new ArrayList<>();
		for (Transaction t : groceryTransactions) {
			transactionIds.add(t.getId());
		}
		return transactionIds;
	}
}
