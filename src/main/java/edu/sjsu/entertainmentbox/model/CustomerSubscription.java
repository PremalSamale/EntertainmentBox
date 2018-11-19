package edu.sjsu.entertainmentbox.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class CustomerSubscription {

    private Integer subscriptionId;
    private Customer customer;
    private String subscriptionType;
    private Integer price;
    private Date subscriptionTS;
    private Date subscriptionStartDate;
    private Date subscriptionEndDate;

    public CustomerSubscription() {
    }

    public CustomerSubscription(Integer subscriptionId, Customer customer, String subscriptionType, Integer price, Date subscriptionTS, Date subscriptionStartDate, Date subscriptionEndDate) {
        this.subscriptionId = subscriptionId;
        this.customer = customer;
        this.subscriptionType = subscriptionType;
        this.price = price;
        this.subscriptionTS = subscriptionTS;
        this.subscriptionStartDate = subscriptionStartDate;
        this.subscriptionEndDate = subscriptionEndDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(Integer subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUST_ID", nullable = false)
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Column(name = "SUBSCRPTN_TYPE", nullable = false)
    public String getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(String subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    @Column(name = "PRICE")
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "SUBSCRPTN_TS", unique = true, nullable = false, length = 10)
    public Date getSubscriptionTS() {
        return subscriptionTS;
    }

    public void setSubscriptionTS(Date subscriptionTS) {
        this.subscriptionTS = subscriptionTS;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "SUBSCRPTN_START", unique = true, nullable = false, length = 10)
    public Date getSubscriptionStartDate() {
        return subscriptionStartDate;
    }

    public void setSubscriptionStartDate(Date subscriptionStartDate) {
        this.subscriptionStartDate = subscriptionStartDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "SUBSCRPTN_END", unique = true, nullable = false, length = 10)
    public Date getSubscriptionEndDate() {
        return subscriptionEndDate;
    }

    public void setSubscriptionEndDate(Date subscriptionEndDate) {
        this.subscriptionEndDate = subscriptionEndDate;
    }
}
