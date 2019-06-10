/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicbanktransactionproject.model.exeption;

/**
 *
 * @author Binh
 */
public class InvalidAccountNumberException extends Exception {

    private Long accountnumber;

    public InvalidAccountNumberException(Long accountnumber) {
        this.accountnumber = accountnumber;
    }

    public void sendMessageAccountNumberCannotBeFound() {
        System.out.println("The account number you want to transfer does not exists"+ accountnumber);
    }

    public void sendMessageAccountNumberSameWithSender() {
        System.out.println("The account number you want to transfer it your own"+ accountnumber);
    }

    public double getAccountNumber() {
        return accountnumber;
    }
}
