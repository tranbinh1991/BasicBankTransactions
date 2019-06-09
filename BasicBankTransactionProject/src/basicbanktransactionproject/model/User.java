/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicbanktransactionproject.model;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author Binh
 */
public class User {
    
    private static Long count = 1L;
    private Long id;
    private String name;
    private String password;
    private BankAccount account;

    public User(String name, String password) {
        this.id = count;
        this.count++; 
        this.name = name;
        this.password = password;
        account = new BankAccount();
    }
    
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BankAccount getAccount() {
        return account;
    }

    public void setAccount(BankAccount account) {
        this.account = account;
    }
    
    
    
    







    
    
    
    
    
    
    
    
    
}
