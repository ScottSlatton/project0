package com.banking.service;

import com.banking.exception.BusinessException;
import com.banking.models.Customer;

import java.util.List;

public interface CustomerService {

    public Customer createCustomer(Customer customer) throws BusinessException;
    public Customer customerLogin(Customer customer) throws BusinessException;
    public Customer getCustomerById(String id) throws BusinessException;
    public Customer getCustomerByUsername(String username) throws BusinessException;
    public Customer updateCustomerPassword(String id, String password) throws BusinessException;
    public void deleteCustomer(String id) throws BusinessException;

}
