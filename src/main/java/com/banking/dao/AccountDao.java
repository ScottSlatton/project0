package com.banking.dao;

import com.banking.exception.BusinessException;
import com.banking.models.Account;
import com.banking.models.Customer;
import com.sun.xml.internal.rngom.ast.builder.BuildException;

public interface AccountDao {

    Account createAccount(Customer customer) throws BusinessException;
    Account getAccountById(String accountId) throws BusinessException;
    Account getAccountByUser(Customer customer) throws BusinessException;
    Account updateAccountBalance(Account account) throws BusinessException;
}
