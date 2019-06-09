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
public class NegativeAmountException extends Exception{
    
    private double amount;

    public NegativeAmountException(double amount) {
        
        this.amount = amount;
    }
    
    public void message (){
        System.out.println("You cannot enter negative amount: " + amount);
    }

    public double getAmount() {
        return amount;
    }
    
}
