package com.banking.dao;

import com.banking.exception.BusinessException;
import com.banking.models.Customer;

import java.util.List;

public interface CustomerDao {

    Customer createCustomer(Customer customer) throws BusinessException;
    Customer getCustomerByUsername(String username) throws BusinessException;
    Customer getCustomerByLogin(Customer customer) throws BusinessException;
    Customer updateCustomerPhone(String id, long newPhone) throws BusinessException;
    void deleteCustomer(String id) throws BusinessException;
    List<Customer> getCustomersByCity(String city) throws BusinessException;
    List<Customer> getAllCustomers() throws BusinessException;
    Customer updateBalance(Customer customer) throws BusinessException;
}
