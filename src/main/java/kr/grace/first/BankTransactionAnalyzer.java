package kr.grace.first;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
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

/**
 * 요구사항
 * 1. 은행 입출금 내역의 총 수입과 총 지출은 각각 얼마인가? [O]
 * - 파일이 비어 있다면?
 * - 데이터에 문제가 있어서 금액을 파싱하지 못하면?
 * - 행의 데이터가 완벽하지 않다면?
 * 2. 특정 달엔 몇 건의 입출금 내역이 발생했는가? [O]
 * 3. 지출이 가장 높은 상위 10건은 무엇인가? []
 * 4. 돈을 가장 많이 소비하는 항목은 무엇인가? []
 */
public class BankTransactionAnalyzer {
    private static final String RESOURCES = "src/main/resources/";

    public void analyze(String filename, BankStatementParser bankStatementParser) throws IOException {

        final Path path = Paths.get(RESOURCES + filename);
        final List<String> lines = Files.readAllLines(path);

        List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);
        BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

        collectSummary(bankStatementProcessor);
    }

    private void collectSummary(final BankStatementProcessor bankStatementProcessor) {
        System.out.println("The total for all transactions is " + bankStatementProcessor.calculateTotalAmount());
        System.out.println("The total for transactions in January is " + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
        System.out.println("The total for transactions in February is " + bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY));
        System.out.println("The total salary received is " + bankStatementProcessor.calculateTotalForCategory("Salary"));

        System.out.println("The total for transactions in February and greater than 1_000 is " +bankStatementProcessor.findTransactions(
                bankTransaction ->
                        bankTransaction.getDate().getMonth() == Month.FEBRUARY
                                && bankTransaction.getAmount() >= 1_000));
    }
}
