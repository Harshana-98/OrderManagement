package net.javaguides.ordermanagement.model;

public class OrderManagementException extends RuntimeException {

    public OrderManagementException(String message) {
        super(message);
    }

    public OrderManagementException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
