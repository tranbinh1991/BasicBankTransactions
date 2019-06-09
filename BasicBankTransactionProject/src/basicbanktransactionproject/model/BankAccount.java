/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicbanktransactionproject.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Binh
 */
public class BankAccount {
    
    
    private static Long count = 100000L;
    private Long accountNumber;
    private BigDecimal balance;
    private List<Transaction> listofTransactions = new ArrayList<>();

    public BankAccount() {
        
        this.balance = BigDecimal.valueOf(0);
        this.accountNumber = this.count;
        this.count++; 
        
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" + "accountNumber=" + accountNumber + '}';
    }
    

    public Long getAccountNumber() {
        return accountNumber;
    }

    public List<Transaction> getListofTransactions() {
        return listofTransactions;
    }
    
    


    
    
    
    
    
    


    
    
    
    
    
    
    
}
