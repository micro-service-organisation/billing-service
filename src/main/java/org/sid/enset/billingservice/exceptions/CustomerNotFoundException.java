package org.sid.enset.billingservice.exceptions;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(String messages, Exception e) {

        super(messages,e);
    }
}
