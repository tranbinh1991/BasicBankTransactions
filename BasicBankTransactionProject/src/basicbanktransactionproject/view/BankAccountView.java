/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicbanktransactionproject.view;


import basicbanktransactionproject.controller.BankAccountController;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.InputMismatchException;

import java.util.Scanner;

/**
 *
 * @author Binh
 */
public class BankAccountView implements IView {

    BankAccountController bankAccountController;

    public void setController(BankAccountController controller) {
        this.bankAccountController = controller;
    }

    @Override
    public void showInitialPage() {

        System.out.println("------------");
        System.out.println("Welcome " + bankAccountController.getUser().getName());
        System.out.println("Account number: " + bankAccountController.getUser().getAccount().getAccountNumber());
        System.out.println("Account balance: " + bankAccountController.getUser().getAccount().getBalance());
        System.out.println("------------");
        System.out.println("What would you like to do?");
        System.out.println("1. Deposit money");
        System.out.println("2. Withdraw money");
        System.out.println("3. Transfer money");
        System.out.println("4. Show transactions");
        System.out.println("5. Log out");
        System.out.println("------------");
        System.out.println("Please choose an option: ");

        try {
            Scanner sc = new Scanner(System.in);
            int selected = sc.nextInt();
            this.bankAccountController.doSelected(selected);

        } catch (InputMismatchException e) {
            showErrorMessage("Invalid Input. Please try again");
            showInitialPage();
        }
    }

    @Override
    public void showErrorMessage(String message) {
        System.out.println("------------");
        System.out.println(message);
        System.out.println("------------");
    }

    public void showDespositOption() {
        System.out.println("------------");
        System.out.println("How much money would you like to deposit?");

        try {
            Scanner sc = new Scanner(System.in);
            double selected = sc.nextDouble();
            this.bankAccountController.depositMoney(selected);

        } catch (InputMismatchException e) {
            showErrorMessage("Invalid Input. Please try again");
            showDespositOption();
        }

    }

    public void showWithdrawOption() {
        System.out.println("------------");
        System.out.println("How much money would you like to withdraw?");

        try {
            Scanner sc = new Scanner(System.in);
            double selected = sc.nextDouble();
            this.bankAccountController.withdrawMoney(selected);

        } catch (InputMismatchException e) {
            showErrorMessage("Invalid Input. Please try again");
            showWithdrawOption();
        }

    }

    public void showTransferOption() {
        System.out.println("------------");

        try {
            System.out.println("Please type beneficiary account number");
            Scanner sc = new Scanner(System.in);
            Long destinationAccount = sc.nextLong();
            System.out.println("How much money would you like to transfer?");
            double selected = sc.nextDouble();
            this.bankAccountController.transferMoney(destinationAccount, selected);

        } catch (InputMismatchException e) {
            showErrorMessage("Invalid Input. Please try again");
            showTransferOption();
        }

    }

    public void showHistoryOptions() {
        System.out.println("------------");

        System.out.println("Please select filter option");
        System.out.println("1. View all my transaction");
        System.out.println("2. Filter by transaction type");
        System.out.println("3. Filter by amount (range)");
        System.out.println("4. Filter by date");
        System.out.println("5. Reset filter");
        System.out.println("6. Back");
        System.out.println("------------");

        try {
            Scanner sc = new Scanner(System.in);
            int selected = sc.nextInt();
            this.bankAccountController.filterHistory(selected);

        } catch (InputMismatchException e) {
            showErrorMessage("Invalid Input. Please try again");
            showHistoryOptions();
        }

    }

    public void showFilterForTranscationType() {
        System.out.println("------------");
        System.out.println("Pleas type in which type you want to filter for?");
        System.out.println("------------");
        try {
            Scanner sc = new Scanner(System.in);
            String transactionType = sc.nextLine();
            this.bankAccountController.filterByType(this.bankAccountController.getFilteredTransactions(), transactionType);

        } catch (InputMismatchException e) {
            showErrorMessage("Invalid Input. Please try again");
            showFilterForTranscationType();
        }

    }

    public void showFilterForAmount() {
        System.out.println("------------");
        System.out.println("Pleas type in the lower limit and the upper limit");
        System.out.println("------------");
        try {
            System.out.println("Lower limit");
            Scanner sc = new Scanner(System.in);
            double lowerLimit = sc.nextDouble();
            System.out.println("Upper limit");
            double upperLimit = sc.nextDouble();
            this.bankAccountController.filterByAmount(this.bankAccountController.getFilteredTransactions(), lowerLimit, upperLimit);

        } catch (InputMismatchException e) {
            showErrorMessage("Invalid Input. Please try again");
            showFilterForAmount();
        }

    }

    public void showFilterForDate() {
        System.out.println("------------");
        System.out.println("Pleas type in the lower limit and the upper limit");
        System.out.println("------------");
        try {
            System.out.println("Lower limit");
            System.out.println("Year");
            Scanner sc = new Scanner(System.in);
            int lowerLimitYear = sc.nextInt();
            System.out.println("Month");
            int lowerLimitMonth = sc.nextInt();
            System.out.println("Day");
            int lowerLimitDay = sc.nextInt();
            System.out.println("Upper limit");
            System.out.println("Year");
            int upperLimitYear = sc.nextInt();
            System.out.println("Month");
            int upperLimitMonth = sc.nextInt();
            System.out.println("Day");
            int upperLimitDay = sc.nextInt();
            this.bankAccountController.filterByDate(this.bankAccountController.getFilteredTransactions(), LocalDate.of(lowerLimitYear, lowerLimitMonth, lowerLimitDay), LocalDate.of(upperLimitYear, upperLimitMonth, upperLimitDay));

        } catch (InputMismatchException e) {
            showErrorMessage("Invalid Input. Please try again");
            showFilterForDate();
        } catch (DateTimeException e) {
            showErrorMessage("Invalid input for date. Please try again");
            showFilterForDate();
        }

    }

}
