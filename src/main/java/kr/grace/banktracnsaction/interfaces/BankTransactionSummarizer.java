package kr.grace.banktracnsaction.interfaces;

import kr.grace.banktracnsaction.BankTransaction;

/**
 * @author : Eunmo Hong
 * @since : 2020/06/24
 */

@FunctionalInterface
public interface BankTransactionSummarizer {
    double summarize(double accumulator, BankTransaction bankTransaction);
}
