/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicbanktransactionproject.model;

/**
 *
 * @author Binh
 */
public class InsufficientFundsException extends Exception {

    private double amount;

    public InsufficientFundsException(double amount) {
        this.amount = amount;
    }
    
    public void message(){
        System.out.println("You do not have enough money on your bank account");
    }

    public double getAmount() {
        return amount;
    }
}
