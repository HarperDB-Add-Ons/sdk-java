package expert.os.harperdb;

import java.util.function.Supplier;

/**
 * Enum representing HTTP status codes.
 * Each constant in this enum corresponds to a specific HTTP status code.
 */
enum HttpStatus implements Supplier<Integer> {
    /**
     * HTTP status code 200 OK.
     */
    OK(200);

    private final int status;

    /**
     * Constructs an HttpStatus enum constant with the specified status code.
     *
     * @param status The HTTP status code.
     */
    HttpStatus(int status) {
        this.status = status;
    }

    /**
     * Gets the integer representation of the HTTP status code.
     *
     * @return The HTTP status code.
     */
    @Override
    public Integer get() {
        return status;
    }
}
