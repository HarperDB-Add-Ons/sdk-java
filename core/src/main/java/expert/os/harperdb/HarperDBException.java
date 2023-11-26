package expert.os.harperdb;

/**
 * Custom exception class for handling exceptions related to HarperDB operations.
 */
public class HarperDBException extends RuntimeException {

    /**
     * Constructs a new HarperDBException with no specified detail message.
     */
    public HarperDBException() {
    }

    /**
     * Constructs a new HarperDBException with the specified detail message.
     *
     * @param message the detail message (which is saved for later retrieval by the getMessage() method).
     */
    public HarperDBException(String message) {
        super(message);
    }

    /**
     * Constructs a new HarperDBException with the specified detail message and cause.
     *
     * @param message the detail message (which is saved for later retrieval by the getMessage() method).
     * @param cause   the cause (which is saved for later retrieval by the getCause() method).
     */
    public HarperDBException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new HarperDBException with the specified cause and a detail message of (cause==null ? null : cause.toString())
     * (which typically contains the class and detail message of cause).
     *
     * @param cause the cause (which is saved for later retrieval by the getCause() method).
     */
    public HarperDBException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new HarperDBException with the specified detail message, cause, suppression enabled or
     * disabled, and writable stack trace enabled or disabled.
     *
     * @param message            the detail message (which is saved for later retrieval by the getMessage() method).
     * @param cause              the cause (which is saved for later retrieval by the getCause() method).
     * @param enableSuppression whether or not suppression is enabled or disabled.
     * @param writableStackTrace whether or not the stack trace should be writable.
     */
    public HarperDBException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

