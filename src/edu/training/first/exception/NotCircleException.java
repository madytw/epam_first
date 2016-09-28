package edu.training.first.exception;


/**
 * Created by Roman on 24.09.2016.
 */
public class NotCircleException extends Exception {
    public NotCircleException() {
    }

    public NotCircleException(String message) {
        super(message);
    }

    public NotCircleException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotCircleException(Throwable cause) {
        super(cause);
    }

    public NotCircleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
