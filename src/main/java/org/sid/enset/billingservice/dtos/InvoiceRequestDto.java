package org.sid.enset.billingservice.dtos;

import java.math.BigDecimal;

public class InvoiceRequestDto {


    private BigDecimal amount;
    private String customerId;


    public InvoiceRequestDto(BigDecimal amount, String customerId) {
        this.amount = amount;
        this.customerId = customerId;
    }

    public InvoiceRequestDto() {
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
