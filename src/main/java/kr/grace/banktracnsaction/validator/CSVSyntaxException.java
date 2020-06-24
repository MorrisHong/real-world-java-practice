package kr.grace.banktracnsaction.validator;

/**
 * @author : Eunmo Hong
 * @since : 2020/06/24
 */

public class CSVSyntaxException extends RuntimeException {
    public CSVSyntaxException(String message) {
        super(message);
    }
}
