/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicbanktransactionproject.controller;

import basicbanktransactionproject.model.BankAccount;
import basicbanktransactionproject.model.exception.InsufficientFundsException;
import basicbanktransactionproject.model.exception.NegativeZeroAmountException;
import basicbanktransactionproject.model.Transaction;
import basicbanktransactionproject.model.TransactionType;
import basicbanktransactionproject.model.User;
import basicbanktransactionproject.model.exception.InvalidAccountNumberException;
import basicbanktransactionproject.model.exception.LowerLimitExceedsUpperException;
import basicbanktransactionproject.model.repository.UserRepository;
import basicbanktransactionproject.view.BankAccountView;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Binh
 */
public class BankAccountController {

    User user;
    BankAccountView bankAccountView;
    private UserRepository users = new UserRepository();
    private List<Transaction> filteredTransactions;

    public BankAccountController(User user) {
        this.user = user;
        initView();
    }

    public void doSelected(int selectedOption) {

        switch (selectedOption) {
            case 1:
                bankAccountView.showDespositOption();
                break;
            case 2:
                bankAccountView.showWithdrawOption();
                break;
            case 3:
                bankAccountView.showTransferOption();
                break;
            case 4:
                bankAccountView.showHistoryOptions();
                break;
            case 5:
                WelcomePageController welcomePageController = WelcomePageController.getInstance();
                welcomePageController.initView();
                break;
            default:
                System.out.println("You have choosen an invalid command. Please try again");
                bankAccountView.showPage();
                break;
        }

    }

    public User getUser() {
        return user;
    }

    public void initView() {
        bankAccountView = new BankAccountView();
        bankAccountView.setController(this);
        bankAccountView.showPage();
    }

    public void depositMoney(double amount) {

        if (amount <= 0) {
            try {
                throw new NegativeZeroAmountException(BigDecimal.valueOf(amount));
            } catch (NegativeZeroAmountException ex) {
                ex.sendMessage();
            } finally {
                bankAccountView.showDespositOption();
            }
        }

        this.user.getAccount().setBalance(this.user.getAccount().getBalance().add(BigDecimal.valueOf(amount)));
        System.out.println("Successful deposit!. Your new balance is: " + this.user.getAccount().getBalance());
        this.user.getAccount().getListofTransactions().add(new Transaction(TransactionType.DEPOSIT, BigDecimal.valueOf(amount), null, this.user.getAccount()));
        initView();

    }

    public void withdrawMoney(double amount) {
        if (amount <= 0) {
            try {
                throw new NegativeZeroAmountException(BigDecimal.valueOf(amount));
            } catch (NegativeZeroAmountException ex) {
                ex.sendMessage();
            } finally {
                bankAccountView.showWithdrawOption();
            }
        }

        if (this.user.getAccount().getBalance().compareTo(BigDecimal.valueOf(amount)) <= 0) {

            try {
                throw new InsufficientFundsException(BigDecimal.valueOf(amount), user.getAccount().getBalance());
            } catch (InsufficientFundsException ex) {
                ex.sendMessage();
            } finally {
                bankAccountView.showWithdrawOption();
            }

        } else {
            this.user.getAccount().setBalance(this.user.getAccount().getBalance().subtract(BigDecimal.valueOf(amount)));
            System.out.println("Successful withdraw!. Your new balance is: " + this.user.getAccount().getBalance());
            this.user.getAccount().getListofTransactions().add(new Transaction(TransactionType.WITHDRAWAL, BigDecimal.valueOf(amount), this.user.getAccount(), null));
            bankAccountView.showPage();
        }
    }

    public void transferMoney(Long destinationAccountNumber, double amount) {

        if (amount <= 0) {
            try {
                throw new NegativeZeroAmountException(BigDecimal.valueOf(amount));
            } catch (NegativeZeroAmountException ex) {
                ex.sendMessage();
            } finally {
                bankAccountView.showTransferOption();
            }
        }

        if (this.user.getAccount().getBalance().compareTo(BigDecimal.valueOf(amount)) <= 0) {

            try {
                throw new InsufficientFundsException(BigDecimal.valueOf(amount), user.getAccount().getBalance());
            } catch (InsufficientFundsException ex) {
                ex.sendMessage();
            } finally {
                bankAccountView.showTransferOption();

            }
        } else {

            if (destinationAccountNumber.compareTo(this.user.getAccount().getAccountNumber()) == 0) {
                try {
                    throw new InvalidAccountNumberException(destinationAccountNumber);
                } catch (InvalidAccountNumberException ex) {
                    ex.sendMessageAccountNumberSameWithSender();
                } finally {
                    bankAccountView.showTransferOption();
                }

            } else {
                boolean foundBeneficiaryUser = false;
                for (User beneficiaryUser : users.getListOfUsers()) {

                    if (beneficiaryUser.getAccount().getAccountNumber().compareTo(destinationAccountNumber) == 0) {
                        this.user.getAccount().setBalance(this.user.getAccount().getBalance().subtract(BigDecimal.valueOf(amount)));
                        beneficiaryUser.getAccount().setBalance(beneficiaryUser.getAccount().getBalance().add(BigDecimal.valueOf(amount)));

                        foundBeneficiaryUser = true;
                        this.user.getAccount().getListofTransactions().add(new Transaction(TransactionType.TRANSFER, BigDecimal.valueOf(amount), this.user.getAccount(), beneficiaryUser.getAccount()));
                        beneficiaryUser.getAccount().getListofTransactions().add(new Transaction(TransactionType.TRANSFER, BigDecimal.valueOf(amount), this.user.getAccount(), beneficiaryUser.getAccount()));
                        System.out.println("Successful transfer!");
                        bankAccountView.showPage();
                    }
                }

                if (foundBeneficiaryUser == false) {
                    try {
                        throw new InvalidAccountNumberException(destinationAccountNumber);
                    } catch (InvalidAccountNumberException ex) {
                        ex.sendMessageAccountNumberCannotBeFound();
                    } finally {
                        bankAccountView.showTransferOption();
                    }
                }
            }
        }
    }

    public void filterHistory(int selectedFilter) {
        if (filteredTransactions == null) {
            filteredTransactions = this.user.getAccount().getListofTransactions();
        } else {
            System.out.println("You can set up additional filtering");
        }
        switch (selectedFilter) {

            case 1:
                System.out.println(filteredTransactions);
                bankAccountView.showHistoryOptions();
                break;
            case 2:
                bankAccountView.showFilterForTranscationType();
                break;

            case 3:
                bankAccountView.showFilterForAmount();
                break;

            case 4:
                bankAccountView.showFilterForDate();
                break;

            case 5:
                filteredTransactions = this.user.getAccount().getListofTransactions();
                System.out.println("Filtering reseted");
                bankAccountView.showHistoryOptions();
                break;

            case 6:
                filteredTransactions = this.user.getAccount().getListofTransactions();
                bankAccountView.showPage();
                break;

            default:
                System.out.println("You have choosen an invalid command. Please try again");
                bankAccountView.showPage();
                break;
        }
    }

    public List<Transaction> filterByType(List<Transaction> list, String transactionType) {
        List<Transaction> newFilteredTransactions = new ArrayList<>();
        for (Transaction transaction : list) {
            if (transactionType.equalsIgnoreCase(transaction.getTransactionType().toString())) {
                newFilteredTransactions.add(transaction);

            }

        }
        filteredTransactions = newFilteredTransactions;
        System.out.println("Filtered");
        System.out.println(filteredTransactions);
        bankAccountView.showHistoryOptions();
        return filteredTransactions;

    }

    public List<Transaction> filterByAmount(List<Transaction> list, double lowerLimit, double upperLimit) {
        if (lowerLimit > upperLimit) {
            try {
                throw new LowerLimitExceedsUpperException(BigDecimal.valueOf(lowerLimit), BigDecimal.valueOf(upperLimit));

            } catch (LowerLimitExceedsUpperException ex) {
                ex.sendMessageForAmount();
            } finally {
                bankAccountView.showFilterForAmount();
            }

        }

        List<Transaction> newFilteredTransactions = new ArrayList<>();
        for (Transaction transaction : list) {
            if (transaction.getValue().compareTo(BigDecimal.valueOf(lowerLimit)) >= 0 && transaction.getValue().compareTo(BigDecimal.valueOf(upperLimit)) <= 0) {
                newFilteredTransactions.add(transaction);

            }

        }
        filteredTransactions = newFilteredTransactions;
        System.out.println("Filtered");
        System.out.println(filteredTransactions);
        bankAccountView.showHistoryOptions();
        return filteredTransactions;

    }

    public List<Transaction> filterByDate(List<Transaction> list, LocalDate lowerLimit, LocalDate upperLimit) {
        if (lowerLimit.isAfter(upperLimit)) {
            try {
                throw new LowerLimitExceedsUpperException(lowerLimit, upperLimit);
            } catch (LowerLimitExceedsUpperException ex) {
                ex.sendMessageForDate();
            } finally {
                bankAccountView.showFilterForDate();
            }

        }

        List<Transaction> newFilteredTransactions = new ArrayList<>();
        for (Transaction transaction : list) {

            if (transaction.getTimeStamp().toLocalDate().compareTo(lowerLimit) >= 0 && transaction.getTimeStamp().toLocalDate().compareTo(upperLimit) <= 0) {
                newFilteredTransactions.add(transaction);
            }
        }
        filteredTransactions = newFilteredTransactions;
        System.out.println("Filtered");
        System.out.println(filteredTransactions);
        bankAccountView.showHistoryOptions();
        return filteredTransactions;

    }

    public List<Transaction> getFilteredTransactions() {
        return filteredTransactions;
    }

}
