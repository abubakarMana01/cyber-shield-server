package com.project.cybershield.exception;

public class SecurityAnswerMismatchException extends Exception {
    public SecurityAnswerMismatchException() {
    }

    public SecurityAnswerMismatchException(String message) {
        super(message);
    }

    public SecurityAnswerMismatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public SecurityAnswerMismatchException(Throwable cause) {
        super(cause);
    }

    public SecurityAnswerMismatchException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
