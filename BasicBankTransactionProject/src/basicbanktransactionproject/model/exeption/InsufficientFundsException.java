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
public class InsufficientFundsException extends Exception {

    private BigDecimal transferAmount;
    private BigDecimal accountBalance;

    public InsufficientFundsException(BigDecimal transferAmount, BigDecimal accountBalance) {
        this.transferAmount = transferAmount;
        this.accountBalance = accountBalance;
    }
    


    
    public void sendMessage(){
        System.out.println("You do not have enough money on your bank account"+"you wanted to tranfer:" + transferAmount+"while you have:" + accountBalance);
    }

    public BigDecimal getTransferAmount() {
        return transferAmount;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }


}
