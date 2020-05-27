package com.banking.models;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {

    public String id;
    private List<Account> accounts = new ArrayList<>();


    public Customer() {
        super();
    }

    public Customer(String id, String username){
        super(username);
        this.id = id;
    };

    public Customer(String id, String username, String password) {
        super(username, password);
        this.id = id;

    }

    public Customer(String username, String password, String id, List<Account> accounts) {
        super(username, password);
        this.id = id;
        this.accounts = accounts;
    }

    public Customer(String id, List<Account> accounts) {
        this.id = id;
        this.accounts = accounts;
    }

    public Customer(String username, String id, List<Account> accounts) {
        super(username);
        this.id = id;
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", accounts=" + accounts +
                ", username='" + username + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public void setAccount(Account account){
        this.accounts.add(account);
    }


}
