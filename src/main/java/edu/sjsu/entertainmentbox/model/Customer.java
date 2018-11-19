package edu.sjsu.entertainmentbox.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Customer {

    private Integer customerId;
    private String emailAddress;
    private Set<CustomerSubscription> subscription = new HashSet<>();

    public Customer() {
    }

    public Customer(Integer customerId, String emailAddress, Set<CustomerSubscription> subscription) {
        this.customerId = customerId;
        this.emailAddress = emailAddress;
        this.subscription = subscription;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CUST_ID", unique = true, nullable = false)
    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Column(name = "EMAIL_ID", unique = true, nullable = false)
    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    public Set<CustomerSubscription> getSubscription() {
        return subscription;
    }

    public void setSubscription(Set<CustomerSubscription> subscription) {
        this.subscription = subscription;
    }
}
