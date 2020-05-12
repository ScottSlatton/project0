package com.banking.models;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {

    private String id;

    private List<Account> accounts = new ArrayList<>();





    //    public void transfer(Account payer, Account payee){
//        payer.accounts[0].withdraw(100.00);
//        payee.accounts[0].deposit(100.00);
//        //Update balance for both accounts
//    }

    public Customer() {
        super();
    }

    public Customer(String id, String username, double balance){
    };

    public Customer(String id, String username, String password) {
        super(username, password);
        this.id = id;

    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


    public String getId() {
        return id;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }



    public void setId(String string) {
    }


}
