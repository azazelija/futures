package investing.project.exc;

public class FutureException extends RuntimeException {
    public FutureException(String message, Throwable cause) {
        super(message, cause);
    }

    public FutureException(Throwable cause) {
        super(cause);
    }
}
