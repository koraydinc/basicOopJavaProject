package main.java.core.utilities.results;

public class Result implements IResult {
    private final boolean success;
    private final String message;

    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public Result(boolean success) {
        this.success = success;
        this.message = null;
    }

    @Override
    public boolean isSuccess() {
        return success;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
