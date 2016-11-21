package me.david.test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import me.david.test.enumerates.TransactionType;

/**
 * @author David Bejar
 *
 */
public class StreamJava8 {

	/**
	 *
	 * @param transactions
	 * @return list of ordered transaction IDs
	 */
	public List<Integer> getOrderedGroceriesTransactionIds(List<Transaction> transactions) {
		Comparator<Transaction> byValue = Comparator.comparing(Transaction::getValue);
		List<Integer> transactionsIds = transactions.parallelStream()
				.filter(t -> t.getType() == TransactionType.GROCERIES).sorted(byValue.reversed())
				.map(Transaction::getId).collect(Collectors.toList());
		return transactionsIds;
	}

}
