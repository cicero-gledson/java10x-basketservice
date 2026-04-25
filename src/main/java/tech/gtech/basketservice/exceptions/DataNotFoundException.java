package tech.gtech.basketservice.exceptions;

public class DataNotFoundException extends RuntimeException {
    public DataNotFoundException(String badRequest) {
        super(badRequest);
    }
}
