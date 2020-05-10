package com.banking.models;

import com.banking.exception.BusinessException;

import java.util.ArrayList;
import java.util.List;

public interface Account {



    double balance = 0.0;
    String accountType = null;
    List<Customer> customers = new ArrayList<Customer>();
    void transfer(Customer payer, Customer payee) throws BusinessException;



}

