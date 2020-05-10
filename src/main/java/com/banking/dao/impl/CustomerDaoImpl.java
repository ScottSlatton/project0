package com.banking.dao.impl;

import com.banking.dao.CustomerDao;
import com.banking.dbutil.OracleConnection;
import com.banking.exception.BusinessException;
import com.banking.models.Customer;

import java.sql.*;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {

    @Override
    public Customer createCustomer(Customer customer) throws BusinessException {

        try(Connection connection = OracleConnection.getConnection()){
            String sql= "{call CREATECUSTOMER(?, ?, ?, ?, ?, ?, ?, ?)}";

            //fill in the ?'s

            CallableStatement callableStatement = connection.prepareCall(sql);
            callableStatement.setString(1, customer.getUsername());
            callableStatement.setString(2, customer.getPassword());
            callableStatement.setString(3, customer.getFirstName());
            callableStatement.setString(4, customer.getLastName());
            callableStatement.setLong(5, customer.getPhone());
            callableStatement.setString(6, customer.getEmail());
            callableStatement.setInt(7, customer.getAge());
            callableStatement.setString(8, customer.getCity());

            //register id because it is an OUT param

//            callableStatement.registerOutParameter(1, Types.NUMERIC);

            callableStatement.execute();
            //callableStatement should have executed and now contains the ID param

//            customer.setId(callableStatement.getInt(1));

            System.out.println("Customer successfully made.");

        } catch (SQLException | ClassNotFoundException e) {
            throw new BusinessException("Internal error. Please don't panic.");
        }
        return customer;
    }

    @Override
    public Customer getCustomerByUsername(String Username) throws BusinessException {
        return null;
    }

    @Override
    public Customer getCustomerByLogin(String username, String password) {
        return null;
    }

    @Override
    public Customer updateCustomerPhone(String Username, long newPhone) throws BusinessException {
        return null;
    }

    @Override
    public void deleteCustomer(String Username) throws BusinessException {

    }

    @Override
    public List<Customer> getCustomersByCity(String city) throws BusinessException {
        return null;
    }

    @Override
    public List<Customer> getAllCustomers() throws BusinessException {
        return null;
    }
}
