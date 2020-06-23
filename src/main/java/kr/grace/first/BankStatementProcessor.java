package kr.grace.first;

import kr.grace.first.interfaces.BankTransactionFilter;
import kr.grace.first.interfaces.BankTransactionSummarizer;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by GraceLove
 * Github  : https://github.com/gracelove91
 * Blog    : https://gracelove91.tistory.com
 * Email   : govlmo91@gmail.com
 *
 * @author : Eunmo Hong
 * @since : 2020/06/18
 */

public class BankStatementProcessor {

    private final List<BankTransaction> bankTransactions;

    public BankStatementProcessor(List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    public double summarizeTransactions(final BankTransactionSummarizer bankTransactionSummarizer) {
        double result = 0d;
        for (BankTransaction bankTransaction : bankTransactions) {
            result = bankTransactionSummarizer.summarize(result, bankTransaction);
        }
        return result;
    }

    public double calculateTotalAmount() {
        return summarizeTransactions(((accumulator, bankTransaction) ->
                bankTransaction.getAmount() + accumulator
        ));
    }

    public double calculateTotalInMonth(final Month month) {
        return summarizeTransactions(((accumulator, bankTransaction) ->
                bankTransaction.getDate().getMonth() == month ?
                        accumulator + bankTransaction.getAmount() :
                        accumulator
        ));
    }

    public double calculateTotalForCategory(final String category) {
        return summarizeTransactions(((accumulator, bankTransaction) ->
                bankTransaction.getDescription().equals(category) ?
                        bankTransaction.getAmount() + accumulator :
                        accumulator
        ));
    }

    public List<BankTransaction> findTransactions(final BankTransactionFilter filter) {
        List<BankTransaction> result = new ArrayList<>();
        for (BankTransaction bankTransaction : bankTransactions) {
            if (filter.test(bankTransaction)) {
                result.add(bankTransaction);
            }
        }
        return result;
    }
}
