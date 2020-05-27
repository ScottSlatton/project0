package com.banking.models;

import com.banking.exception.BusinessException;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private String id;
    private double balance;
    private String type;
    private List<Customer> customers = new ArrayList<>();
    private List<Transaction> transactions = new ArrayList<>();


    public Account() {
    }

    public Account(String id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public Account(String id, double balance, String type, List<Customer> customers, List<Transaction> transactions) {
        this.id = id;
        this.balance = balance;
        this.type = type;
        this.customers = customers;
        this.transactions = transactions;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public void setTransactions(List<Transaction> transactions){
        this.transactions = transactions;
    }

//    public void setTransaction(Transaction transaction){
//        this.transactions.add(transaction);
//    }

    public List<Transaction> getTransactions() {
        return transactions;
    }




    public void deposit(double amount) throws BusinessException{
        if(amount < 0){
            throw new BusinessException("Invalid amount entered.");
        }
        this.balance += amount;
    }


//    public Transaction transfer(Customer receiver, double amount) throws BusinessException {
//        // Try to withdraw from payer's account
//        try {
//            this.withdraw(amount);
//            List<Account> payeeAccounts = receiver.getAccounts();
//            // If successful, find the receiver's bank account and deposit the money
//            Account receiverAccount = payeeAccounts.get(0);
//            receiverAccount.deposit(amount);
//
//            //Update both accounts in the db and store the transaction object in the Transaction table
//            Transaction transaction = new Transaction(this, receiverAccount,amount );
//            return transaction;
//        } catch(BusinessException e){
//            System.out.println(e.getMessage());
//        }
//        throw new BusinessException("Transfer could not be completed.");
//    }



}

