/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicbanktransactionproject.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *
 * @author Binh
 */
public class Transaction {
    private static Long count = 1L;
    private final Long id;
    private LocalDateTime timeStamp;
    private final TransactionType transactionType;
    private final BigDecimal value;
    private final BankAccount sourceAccount;
    private final BankAccount destinationAccount;

    public Transaction(TransactionType transactionType, BigDecimal value, BankAccount sourceAccount, BankAccount destinationAccount) {
        this.id = count++;
        this.timeStamp = LocalDateTime.now();
        this.transactionType = transactionType;
        this.value = value;
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
    }

    public Long getId() {
        return id;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
    
    
    


    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }



    public BigDecimal getValue() {
        return value;
    }

    public BankAccount getSourceAccount() {
        return sourceAccount;
    }

    public BankAccount getDestinationAccount() {
        return destinationAccount;
    }

    @Override
    public String toString() {
        return "Transaction{" + "id=" + id + ", timeStamp=" + timeStamp + ", transactionType=" + transactionType + ", value=" + value + ", sourceAccount=" + sourceAccount + ", destinationAccount=" + destinationAccount + '}';
    }
    
    


}
