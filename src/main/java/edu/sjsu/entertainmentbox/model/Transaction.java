package edu.sjsu.entertainmentbox.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Transaction {

    private Integer transactionId;
    private Integer customerId;
    private String transType;
    private String transAmt;
    private Date transactionStartTS;
    private Date transactionEndTS;
    private String transactionStatus;

    public Transaction() {
    }

    public Transaction(Integer customerId, String transType, String transAmt, Date transactionStartTS, Date transactionEndTS, String transactionStatus) {
        this.customerId = customerId;
        this.transType = transType;
        this.transAmt = transAmt;
        this.transactionStartTS = transactionStartTS;
        this.transactionEndTS = transactionEndTS;
        this.transactionStatus = transactionStatus;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TRANS_ID", nullable = false, unique = true)
    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    @Column(name = "CUST_ID", nullable = false)
    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Column(name = "TRANS_TYPE")
    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    @Column(name = "TRANS_AMT")
    public String getTransAmt() {
        return transAmt;
    }

    public void setTransAmt(String transAmt) {
        this.transAmt = transAmt;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "TRANS_START_TS")
    public Date getTransactionStartTS() {
        return transactionStartTS;
    }

    public void setTransactionStartTS(Date transactionStartTS) {
        this.transactionStartTS = transactionStartTS;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "TRANS_END_TS")
    public Date getTransactionEndTS() {
        return transactionEndTS;
    }

    public void setTransactionEndTS(Date transactionEndTS) {
        this.transactionEndTS = transactionEndTS;
    }

    @Column(name = "TRANS_STATUS")
    public String getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }
}
