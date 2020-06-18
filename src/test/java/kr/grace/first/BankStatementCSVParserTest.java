package kr.grace.first;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by GraceLove
 * Github  : https://github.com/gracelove91
 * Blog    : https://gracelove91.tistory.com
 * Email   : govlmo91@gmail.com
 *
 * @author : Eunmo Hong
 * @since : 2020/06/18
 */

class BankStatementCSVParserTest {
    private final BankStatementParser parser = new BankStatementCSVParser();

    @Test
    void shouldParseOneCorrectLine() {
        final String line = "30-01-2017,-50,Tesco";

        final BankTransaction result = parser.parseFrom(line);

        BankTransaction expected = new BankTransaction(LocalDate.of(2017, Month.JANUARY, 30), -50, "Tesco");
        final double tolerance = 0.0d;

        assertEquals(expected.getDate(), result.getDate());
        assertEquals(expected.getAmount(), result.getAmount());
        assertEquals(expected.getDescription(), result.getDescription());

    }
}