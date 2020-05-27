package com.banking.dao.impl;

import com.banking.dao.AccountDao;
import com.banking.dbutil.OracleConnection;
import com.banking.exception.BusinessException;
import com.banking.models.Account;
import com.banking.models.Customer;
import com.sun.xml.internal.rngom.ast.builder.BuildException;

import java.sql.*;
import java.util.List;

public class AccountDaoImpl implements AccountDao {

    public void createAccount(Account account) throws BusinessException{
        try(Connection connection = OracleConnection.getConnection()){
            String sql= "{call CREATEACCOUNT(?, ?, ?)}";

            //fill in the ?'s

            CallableStatement callableStatement = connection.prepareCall(sql);

            callableStatement.setDouble(2, account.getBalance());
            callableStatement.setString(3, account.getType());
            //register id because it is an OUT param
            callableStatement.registerOutParameter(1, Types.VARCHAR);

            callableStatement.execute();

            //callableStatement should have executed and now contains the ID param

//           customer.setId(callableStatement.getString(1));


        } catch (SQLException | ClassNotFoundException e) {
            throw new BusinessException("Internal error. Please don't panic.");
        };
    }
    public Account getAccountById(String accountId) throws BusinessException{
        return null;
    }
    public Account getAccountByUser(Customer customer) throws BusinessException{
        return null;
    }

    @Override
    public void updateAccountBalance(Account account) throws BusinessException {
        try(Connection connection= OracleConnection.getConnection()){
            String sql="UPDATE account SET balance = ? WHERE id = ?";
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setDouble(1, account.getBalance());
            ps.setString(2, account.getId());

            ResultSet resultSet=ps.executeQuery();
        } catch (ClassNotFoundException | SQLException e) {
            throw new BusinessException("Internal Error, please don't panic.");
        }
    }

}
