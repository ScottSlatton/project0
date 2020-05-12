package com.banking.models;

import com.banking.exception.BusinessException;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private String id;
    private double balance;
//    List<Customer> customers = new ArrayList<Customer>();


    public Account() {
    }

    public Account(String id, double balance) {
        this.id = id;
        this.balance = balance;
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
//
//    public List<Customer> getCustomers() {
//        return customers;
//    }
//
//    public void setCustomers(List<Customer> customers) {
//        this.customers = customers;
//    }



    public void deposit(double amount){

        this.balance += amount;
    }
    public void withdraw(double amount){
        if (amount <= this.balance){
            this.balance -= amount;
        } else {
            System.out.println("You don't have enough funds!");
        }
    }


    public void transfer(Customer payee, double amount){
        // Try to withdraw from payer's account
        this.withdraw(amount);

        // If successful, find the receiver's bank account and deposit the money
        List<Account> payeeAccounts = payee.getAccounts();
        Account payeeAccount = payeeAccounts.get(0);
        payeeAccount.deposit(amount);

        //Update both accounts in the db
    }



}

