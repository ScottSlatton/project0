package com.banking.service;

import com.banking.exception.BusinessException;
import com.banking.models.Customer;

import java.util.List;

public interface CustomerService {

    public Customer createCustomer(Customer customer) throws BusinessException;
    public Customer customerLogin(Customer customer) throws BusinessException;
    public Customer getCustomerById(String id) throws BusinessException;
    public Customer updateCustomerPhone(String id, long newPhone) throws BusinessException;
    public void deleteCustomer(String id) throws BusinessException;
    public List<Customer> getCustomersByCity(String city) throws BusinessException;



}
