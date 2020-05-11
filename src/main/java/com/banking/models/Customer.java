package com.banking.models;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {

    private String id;
    private String firstName;
    private String lastName;
    private long phone;
    private String email;
    private int age;
    private String city;
    private double balance;
//    private List<Account> accounts = new ArrayList<Account>();





    //    public void transfer(Account payer, Account payee){
//        payer.accounts[0].withdraw(100.00);
//        payee.accounts[0].deposit(100.00);
//        //Update balance for both accounts
//    }

    public Customer() {
        super();
    }

    public Customer(String id, String username, double balance){};

    public Customer(String username, String password, String id, String firstName, String lastName, long phone, String email, int age, String city) {
        super(username, password);
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.age = age;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                ", balance=" + balance +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
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
//
//    public List<Account> getAccounts() {
//        return accounts;
//    }
//
//    public void setAccounts(List<Account> accounts) {
//        this.accounts = accounts;
//    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setId(String string) {
    }

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
        payee.deposit(amount);
        this.withdraw(amount);
        //Update both accounts in the db
    }
}
