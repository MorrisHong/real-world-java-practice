package kr.grace.first.interfaces;

import kr.grace.first.BankTransaction;

/**
 * @author : Eunmo Hong
 * @since : 2020/06/24
 */

@FunctionalInterface
public interface BankTransactionSummarizer {
    double summarize(double accumulator, BankTransaction bankTransaction);
}
