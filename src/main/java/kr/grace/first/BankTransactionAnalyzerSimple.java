package kr.grace.first;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
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
 *   - 파일이 비어 있다면?
 *   - 데이터에 문제가 있어서 금액을 파싱하지 못하면?
 *   - 행의 데이터가 완벽하지 않다면?
 * 2. 특정 달엔 몇 건의 입출금 내역이 발생했는가? []
 * 3. 지출이 가장 높은 상위 10건은 무엇인가? []
 * 4. 돈을 가장 많이 소비하는 항목은 무엇인가? []
 */
public class BankTransactionAnalyzerSimple {
    private static final String RESOURCES = "src/main/resources/";

    public static void main(String[] args) throws IOException {
        final Path path = Paths.get(RESOURCES + args[0]);
        final List<String> lines = Files.readAllLines(path);
        double total = 0d;
        final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        for (final String line : lines) {
            final String[] columns = line.split(",");
            final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
            if (date.getMonth() == Month.JANUARY) {
                final double amount = Double.parseDouble(columns[1]);
                total += amount;
            }
        }

        System.out.println("The total for all transactions in January is " + total);

    }
}
