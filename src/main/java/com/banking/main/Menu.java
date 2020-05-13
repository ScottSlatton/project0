package com.banking.main;

import com.banking.exception.BusinessException;
import com.banking.models.Account;
import com.banking.models.Customer;
import com.banking.models.Employee;
import com.banking.service.CustomerService;
import com.banking.service.EmployeeService;
import com.banking.service.impl.CustomerServiceImpl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.banking.service.impl.EmployeeServiceImpl;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Menu {

    boolean quit = false;

    private static void displayBalance(Customer customer){

        List<Account> accountList = customer.getAccounts();
        for (int i = 0; i < accountList.size();i++){
            Account account = accountList.get(i);
            System.out.println("\nYour balance for account: " + account.getId() + " is currently: $" + account.getBalance());
        }

    }

    private static void displayDeposit(Customer customer){
        System.out.println("------------");
        System.out.println("Deposit Menu");
        System.out.println("------------");
        System.out.println("How much would you like to deposit?");


    }

    private static void displayCustomerMenu(){
        System.out.println("--------------");
        System.out.println("Customer Menu");
        System.out.println("--------------");
        System.out.println("1) Check Balance");
        System.out.println("2) Deposit");
        System.out.println("3) Withdraw");
        System.out.println("4) Transfer funds to another Account");
        System.out.println("5) Transfer funds to another M & B Customer");
        System.out.println("0) Log out");
    }

    private static void displayEmployeeLogin() throws BusinessException {
        System.out.println("--------------");
        System.out.println("Employee Login");
        System.out.println("--------------\n");
        System.out.println("Please enter your username");
        Scanner kb = new Scanner(System.in);
        Employee employee = new Employee();

        employee.setUsername(kb.nextLine());

        System.out.println("Please enter your password");

        employee.setPassword(kb.nextLine());
        EmployeeService service = new EmployeeServiceImpl();
        employee = service.employeeLogin(employee);

        // if successful take them to displayCustomerMenu
        if(employee.getId() == null){
            throw new BusinessException("Log in credentials incorrect.");
        }
    }

    private static Customer displayCustomerLogin() throws BusinessException {
        System.out.println("--------------");
        System.out.println("Customer Login");
        System.out.println("--------------\n");
        System.out.println("Please enter your username");
        Scanner kb = new Scanner(System.in);
        Customer customer = new Customer();

        customer.setUsername(kb.nextLine());

        System.out.println("Please enter your password");
        customer.setPassword(kb.nextLine());

        CustomerService service = new CustomerServiceImpl();
        customer = service.customerLogin(customer);

        // if successful take them to displayCustomerMenu
        if(customer.getId() == null){
            throw new BusinessException("Log in credentials incorrect.");
        }
        return customer;
    }

    private static void displayWithdrawalMenu(){
        Scanner kb = new Scanner(System.in);
        System.out.println("How much would you like to withdraw?");
        double amount = Integer.parseInt(kb.nextLine());

        //TODO perform a withdrawal action
        System.out.println("How much would you like to withdraw?");

    }

    private static void displayCustomerSignUpMenu() throws ParseException, BusinessException {
        // Make a new pendingCustomer account with the customer's details

        Scanner kb = new Scanner(System.in);
        Customer customer = new Customer();
        CustomerService service = new CustomerServiceImpl();


        System.out.println("----------------------");
        System.out.println("New Customer Sign Up");
        System.out.println("----------------------");

        // Enter your personal details please.
        System.out.println("Please enter your desired username.");

        customer.setUsername(kb.nextLine());

        System.out.println("Please enter your desired password");
        customer.setPassword(kb.nextLine());

        List<Account> accounts = new ArrayList<>();
        Account account = new Account();
        account.setBalance(0.0);
        accounts.add(account);
        customer.setAccounts(accounts);

        //TODO Validate inputs
        System.out.println(customer);

        Customer pendingCustomer = service.createCustomer(customer);
        if(pendingCustomer.getId() != null){
            System.out.println("Thank you for your application. See a Monet & Bagges employee for more information on the approval process.");
        }

    }

    private static void displayEmployeeMenu(){
        System.out.println("--------------");
        System.out.println("Employee Menu");
        System.out.println("--------------");
        System.out.println("1) Look up customer account by account ID");
        System.out.println("2) Look up a customer account by username");
        System.out.println("3) View all transactions");
        System.out.println("4) Delete a customer's account");


    }

    private static void displayGreeting(){
        System.out.println("--------------------------------------");
        System.out.println("Welcome to Monet & Bagges LLC Inc ATM");
        System.out.println("--------------------------------------");
    }

    private static void displayLoginMain(){
        System.out.println("Please choose your login.");
        System.out.println("1) Customer Login");
        System.out.println("2) Employee Login");
        System.out.println("3) Sign up for a new customer account");
        System.out.println("0) To exit application at any time");
    }

    private static void displayLogout(){
        System.out.println("Would you like to log out?");
        System.out.println("1) Yes");
        System.out.println("2) No");

    }
    private static void displayHomeMenu(){
        displayGreeting();
        displayLoginMain();
    }

    private int getInput(int numOfChoices){
        int choice = -1;
        Scanner kb = new Scanner(System.in);
        while(choice < 0 || choice > numOfChoices ){
            try {
                System.out.print("\nPlease enter your selection: ");
                choice = Integer.parseInt(kb.nextLine());
            }
            catch (NumberFormatException e){
                System.out.println("Invalid selection. Please try again.");
            }
        }
        return choice;
    }
    public void runCustomerMenu(Customer customer){
        while(!quit){
            displayCustomerMenu();
            int choice = getInput(4);
            handleCustomerMenu(choice, customer);
        }
    }
    public void runEmployeeMenu(){
        while(!quit){
            displayEmployeeMenu();
            int choice = getInput(5);
            handleEmployeeMenu(choice);
        }
    }
    public void runHomeMenu(){
        while(!quit){
            displayHomeMenu();
            int choice = getInput(4);
            handleHomeMenu(choice);
        }
    }

    public void handleEmployeeMenu(int choice){
        //Logic for the Employee Sub-menu options

        switch(choice){
            case 0:
                //exit options
                logoutMenu();
                break;
            case 1:
                //Check customer account by user Id

                break;
            case 2:
                //Check customer account by username

                break;
            case 3:
                //View all transactions

                break;
            case 4:
                //delete a customer's account

                break;
            default:
                System.out.println("Invalid selection, please try again.");
                break;
        }


    }
    private void handleCustomerMenu(int choice, Customer customer){

        //Logic for the Customer Sub-menu options

        switch(choice){
            case 0:
                //exit options
                logoutMenu();
                break;
            case 1:
                //Check Balance
                displayBalance(customer);
                break;
            case 2:
                //Deposit
                displayDeposit(customer);
                break;
            case 3:
                //Withdraw

                break;
            default:
                System.out.println("Invalid selection, please try again.");
                break;
        }
    }
    private void handleHomeMenu(int choice){

        //Logic for the main menu options

        switch(choice){
            case 0:
                //exit options
                logoutMenu();
                break;
            case 1:
                // login customer login
                try {
                    Customer customer = displayCustomerLogin();
                    runCustomerMenu(customer);
                } catch (BusinessException e){
                    System.out.println(e.getMessage());
                }
                break;
            case 2:
                // employee login
                try {
                    displayEmployeeLogin();
                    runEmployeeMenu();
                } catch (BusinessException e){
                    System.out.println(e.getMessage());
                }
                break;
            case 3:
                // new customer sign up
                try {
                    displayCustomerSignUpMenu();
                } catch (ParseException | BusinessException e) {
                    System.out.println(e.getMessage());
                }
                break;
            default:
                System.out.println("Invalid selection, please try again.");
                break;
        }
    }
    private void handleLogout(int choice) {
        switch(choice){
            case 1:
                quit = true;
                break;
            case 2:
                break;
            default:
                System.out.println("Invalid selection, please try again.");
                break;

        }

    }

    public void logoutMenu(){
        displayLogout();
        int choice = getInput(2);
        handleLogout(choice);
    }





}
