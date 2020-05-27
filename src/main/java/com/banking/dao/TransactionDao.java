package com.banking.dao;

import com.banking.exception.BusinessException;
import com.banking.models.Account;
import com.banking.models.Transaction;

import java.util.List;

public interface TransactionDao {

    void createTransaction(Transaction transaction) throws BusinessException;
    Transaction getTransaction(String id) throws BusinessException;
    List<Transaction> getAllTransactions() throws BusinessException;
    List<Transaction> getTransactions(Account account) throws BusinessException;
    void deleteTransaction(Transaction transaction) throws BusinessException;
}
