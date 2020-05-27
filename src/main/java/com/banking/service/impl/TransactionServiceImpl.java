package com.banking.service.impl;

import com.banking.dao.TransactionDao;
import com.banking.dao.impl.TransactionDaoImpl;
import com.banking.exception.BusinessException;
import com.banking.models.Account;
import com.banking.models.Customer;
import com.banking.models.Transaction;
import com.banking.service.AccountService;
import com.banking.service.TransactionService;
import com.sun.org.apache.xml.internal.dtm.ref.sax2dtm.SAX2DTM2;

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
        if(transaction.getSender() == null ){
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
            return dao.getAllTransactions();
        } catch (BusinessException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void deleteTransaction(Transaction transaction) {

    }

    @Override
    public Transaction transfer(Account sender, Account receiver, double amount) throws BusinessException {

        Transaction transaction = new Transaction(sender, receiver, amount);

        //Validate the withdrawal
        if (amount <= sender.getBalance()){
            double updatedSenderBal = (sender.getBalance() - amount);
            sender.setBalance(updatedSenderBal);

            if(sender.getId() != receiver.getId()) {
                double updatedReceiverBal = (receiver.getBalance() + amount);
                receiver.setBalance(updatedReceiverBal);
            }

        } else {
            throw new BusinessException("Insufficient funds.");
        }
        //Create a transaction

        //Validate the accounts
        if(isValidTransaction(transaction)){
            try {
                dao.createTransaction(transaction);

                //Update account balances
                AccountService accountService = new AccountServiceImpl();
                accountService.updateBalance(sender);
                accountService.updateBalance(receiver);


            }catch (BusinessException e){
                System.out.println(e.getMessage());
            }
        }




        return transaction;
    }
}
