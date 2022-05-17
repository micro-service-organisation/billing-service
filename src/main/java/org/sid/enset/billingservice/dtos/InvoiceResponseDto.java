package org.sid.enset.billingservice.dtos;

import org.sid.enset.billingservice.entities.Customer;

import javax.persistence.Entity;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;

public class InvoiceResponseDto {

    private String id;
    private BigDecimal amount;
    private Date date;
    private Customer customer;

    public InvoiceResponseDto() {
    }


    public InvoiceResponseDto(String id, BigDecimal amount, Date date, Customer customer) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.customer = customer;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
