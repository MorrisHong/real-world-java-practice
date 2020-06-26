package kr.grace.documentManagement;

/**
 * @author : Eunmo Hong
 * @since : 2020/06/26
 */

public class UnknownFileTypeException extends RuntimeException {
    public UnknownFileTypeException(String message) {
        super(message);
    }
}
