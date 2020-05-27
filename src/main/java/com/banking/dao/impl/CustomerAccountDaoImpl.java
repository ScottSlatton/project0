package com.banking.dao.impl;

import com.banking.dao.CustomerAccountDao;
import com.banking.dbutil.OracleConnection;
import com.banking.exception.BusinessException;
import com.banking.models.Account;
import com.banking.models.Customer;

import java.sql.*;


public class CustomerAccountDaoImpl implements CustomerAccountDao {
    @Override
    public void createCustomerAccount(Customer customer, Account account) throws BusinessException {
        try(Connection connection = OracleConnection.getConnection()){
            String sql= "{call CREATECUSTOMERACCOUNT(?, ?, ?)}";

            //fill in the ?'s

            CallableStatement callableStatement = connection.prepareCall(sql);

            callableStatement.setString(2, customer.getId());
            callableStatement.setString(3, account.getId());
            //register id because it is an OUT param
            callableStatement.registerOutParameter(1, Types.VARCHAR);

            callableStatement.execute();

            //callableStatement should have executed and now contains the ID param

//           customer.setId(callableStatement.getString(1));

        } catch (SQLException | ClassNotFoundException e) {
            throw new BusinessException("Internal error. Please don't panic.");
        };
    }

    @Override
    public void deleteCustomerAccount(Customer customer, Account account) throws BusinessException {

    }
}
