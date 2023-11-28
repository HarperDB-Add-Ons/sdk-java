package expert.os.harperdb;

import java.util.function.Supplier;

public enum HttpStatus implements Supplier<Integer> {
    OK(200);

    private final int status;

    HttpStatus(int status) {
        this.status = status;
    }

    @Override
    public Integer get() {
        return status;
    }
}
