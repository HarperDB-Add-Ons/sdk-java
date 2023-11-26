package expert.os.harperdb;

/**
 * Abstract class representing a generic operation in HarperDB.
 */
abstract class Operation {

    private final OperationType operation;

    /**
     * Constructs a new Operation with the specified operation type.
     *
     * @param operation The type of the operation.
     */
    Operation(OperationType operation) {
        this.operation = operation;
    }

    /**
     * Gets the type of the operation.
     *
     * @return The operation type.
     */
    public OperationType operation() {
        return operation;
    }
}
