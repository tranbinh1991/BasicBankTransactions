/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicbanktransactionproject.model.exeption;

import java.math.BigDecimal;

/**
 *
 * @author Binh
 */
public class NegativeAmountException extends Exception{
    
   private BigDecimal amount;

    public NegativeAmountException(BigDecimal amount) {
        
        this.amount = amount;
    }
    
    public void sendMessage (){
        System.out.println("You cannot enter negative amount: " + amount);
    }

    public BigDecimal getAmount() {
        return amount;
    }
    
}
