package org.sid.enset.billingservice.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Invoice {

    @Id
    private String id;
    private Date date;
    private BigDecimal amount;
    private String customerId;

    @Transient
    private Customer customer;


    public Invoice(String id, Date date, BigDecimal amount, String customerId, Customer customer) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.customerId = customerId;
        this.customer = customer;
    }

    public Invoice() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
