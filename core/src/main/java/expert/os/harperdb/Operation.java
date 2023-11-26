package expert.os.harperdb;

abstract class Operation {

    private final OperationType operation;

    Operation(OperationType operation) {
        this.operation = operation;
    }

    public OperationType getOperation() {
        return operation;
    }
}
