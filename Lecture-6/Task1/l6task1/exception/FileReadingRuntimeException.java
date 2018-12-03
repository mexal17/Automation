package l6task1.exception;

public class FileReadingRuntimeException extends RuntimeException {
    public FileReadingRuntimeException(String message) {
        super(message);
    }
}