package com.banking.dao;

import com.banking.exception.BusinessException;
import com.banking.models.Transaction;

import java.util.List;

public interface TransactionDao {

    void createTransaction(Transaction transaction);
    List<Transaction> getAllTransactions() throws BusinessException;
}
