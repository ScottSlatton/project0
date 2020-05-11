package com.banking.models;

import com.banking.exception.BusinessException;

import java.util.ArrayList;
import java.util.List;

public class Account {
    double balance = 0.0;
    List<Customer> customers = new ArrayList<Customer>();

    public static void transfer(Customer payee) throws BusinessException {


    }


}

