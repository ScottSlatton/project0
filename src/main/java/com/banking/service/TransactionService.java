package com.banking.service;

import com.banking.models.Transaction;

import java.util.List;

public interface TransactionService {
    void createTransaction(Transaction transaction);
    List<Transaction> getAllTransactions();
    void deleteTransaction(Transaction transaction);
}
