package com.banking.models;

import com.banking.exception.BusinessException;

import java.util.ArrayList;
import java.util.List;

public class Account {
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    double balance = 0.0;
    List<Customer> customers = new ArrayList<Customer>();

    public static void transfer(Customer payee) throws BusinessException {

    }


}

