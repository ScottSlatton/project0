package com.banking.service.impl;

import com.banking.dao.TransactionDao;
import com.banking.dao.impl.TransactionDaoImpl;
import com.banking.exception.BusinessException;
import com.banking.models.Customer;
import com.banking.models.Transaction;
import com.banking.service.TransactionService;

import java.util.List;

public class TransactionServiceImpl implements TransactionService {

    private TransactionDao dao = new TransactionDaoImpl();
    @Override
    public void createTransaction(Transaction transaction) {
        try{
            isValidTransaction(transaction);
            // Call the DAO
            dao.createTransaction(transaction);
        } catch(BusinessException e){
            System.out.println(e.getMessage());
        }
    }

    private Boolean isValidTransaction(Transaction transaction) throws BusinessException {
        boolean b = false;
        if(transaction.getSender() == null){
            throw new BusinessException("Invalid Transaction. Sender not found.");
        } else if (transaction.getReceiver() == null) {
            throw new BusinessException("Invalid Transaction. Receiver not found.");
        } else {
            b = true;
        }
        return b;
    }

    @Override
    public List<Transaction> getAllTransactions() throws BusinessException{
        try{
            List<Transaction> transactionList = dao.getAllTransactions();
            return transactionList;
        } catch (BusinessException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void deleteTransaction(Transaction transaction) {

    }
}
