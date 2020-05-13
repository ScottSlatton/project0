package com.banking.dao.impl;

import com.banking.dao.TransactionDao;
import com.banking.dbutil.OracleConnection;
import com.banking.exception.BusinessException;
import com.banking.models.Account;
import com.banking.models.Employee;
import com.banking.models.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionDaoImpl implements TransactionDao {
    @Override
    public void createTransaction(Transaction transaction) {

    }

    @Override
    public List<Transaction> getAllTransactions() throws BusinessException {
        List<Transaction> transactionList = new ArrayList<>();
        try (Connection connection = OracleConnection.getConnection()) {
            String sql = "Select * from transaction";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();

            while(resultSet.next()) {
                Transaction t=new Transaction();
                Account sender = new Account();
                Account receiver = new Account();

                sender.setId(resultSet.getString("sender"));
                receiver.setId(resultSet.getString("receiver"));
                t.setId(resultSet.getString("id"));
                t.setSender(sender);
                t.setReceiver(receiver);
                t.setAmount(resultSet.getDouble("amount"));

                transactionList.add(t);
            }
            return transactionList;
        } catch (ClassNotFoundException | SQLException e) {
            throw new BusinessException("Internal Error, please don't panic.");
        }
    }
}
