package com.banking.main;

import com.banking.exception.BusinessException;
import com.banking.models.Customer;
import com.banking.service.CustomerService;
import com.banking.service.impl.CustomerServiceImpl;

import java.text.ParseException;
import java.util.Scanner;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Menu {


    boolean quit = false;

    private static void displayBalance(){
        System.out.println("Your balance is currently: $");
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

    private static void displayCustomerLogin(){
        System.out.println("--------------");
        System.out.println("Customer Login");
        System.out.println("--------------\n");
        System.out.println("Please enter your username");
        Scanner kb = new Scanner(System.in);
        Customer customer = new Customer();

        customer.setUsername(kb.nextLine());

        System.out.println("Please enter your password");

        customer.setPassword(kb.nextLine());
        // TODO query the database for the customer
        // if successful take them to displayCustomerMenu

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

        System.out.println("Please enter your First Name");
        customer.setFirstName(kb.nextLine());

        System.out.println("Please enter your Last Name");
        customer.setLastName(kb.nextLine());

        System.out.println("Please enter your Phone Number");
        customer.setPhone(Long.parseLong(kb.nextLine()));

        System.out.println("Please enter your age");
        customer.setAge(Integer.parseInt(kb.nextLine()));

        System.out.println("Please enter your email");
        customer.setEmail(kb.nextLine());

        System.out.println("Please enter the city in which you live");
        customer.setCity(kb.nextLine());

        //TODO Validate inputs

        Customer pendingCustomer = service.createCustomer(customer);
        if(pendingCustomer.getId() != null){
            System.out.println("Thank you for your application. See a Monet & Bagges employee for more information on the approval process.");
        }

    }

    private static void displayEmployeeMenu(){
        System.out.println("--------------");
        System.out.println("Employee Menu");
        System.out.println("--------------");
        System.out.println("1) Check pending customer accounts");
        System.out.println("2) Check a specific customer account");
        System.out.println("3) View all transactions");


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
        System.out.println("0) To exit");
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

    public void runCustomerMenu(){
        while(!quit){
            displayCustomerMenu();
            int choice = getInput(4);
            handleCustomerMenu(choice);
        }
    }

    public void logoutMenu(){
        displayLogout();
        int choice = getInput(2);
        handleLogout(choice);
    }

    private void handleCustomerMenu(int choice){

        //Logic for the Customer Sub-menu options

        switch(choice){
            case 0:
                //exit options
                logoutMenu();
                break;
            case 1:
                //Check Balance

                break;
            case 2:
                //Deposit

                break;
            case 3:
                //Withdraw

                break;
            default:
                System.out.println("Invalid selection, please try again.");
                break;
        }
    }



    public void runHomeMenu(){
        while(!quit){
            displayHomeMenu();
            int choice = getInput(4);
            handleHomeMenu(choice);
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
                displayCustomerLogin();
                runCustomerMenu();
                break;
            case 2:
                // employee login
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
}
