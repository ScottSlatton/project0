package com.banking.dao;

import com.banking.exception.BusinessException;
import com.banking.models.Account;
import com.banking.models.Customer;

public interface CustomerAccountDao {

    void createCustomerAccount(Customer customer, Account account) throws BusinessException;
    void deleteCustomerAccount(Customer customer, Account account) throws BusinessException;
}
