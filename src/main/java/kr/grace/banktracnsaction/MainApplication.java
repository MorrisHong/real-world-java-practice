package kr.grace.banktracnsaction;

import kr.grace.banktracnsaction.interfaces.BankStatementParser;
import kr.grace.banktracnsaction.parsers.BankStatementCSVParser;

import java.io.IOException;

/**
 * Created by GraceLove
 * Github  : https://github.com/gracelove91
 * Blog    : https://gracelove91.tistory.com
 * Email   : govlmo91@gmail.com
 *
 * @author : Eunmo Hong
 * @since : 2020/06/18
 */

public class MainApplication {
    public static void main(String[] args) throws IOException {

        final BankTransactionAnalyzer bankTransactionAnalyzer = new BankTransactionAnalyzer();

        final BankStatementParser bankStatementParser = new BankStatementCSVParser();

        bankTransactionAnalyzer.analyze(args[0], bankStatementParser);
    }
}
