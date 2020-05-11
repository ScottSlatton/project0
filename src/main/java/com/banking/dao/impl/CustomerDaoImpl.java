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
            String sql= "{call CREATECUSTOMER(?, ?, ?, ?, ?, ?, ?, ?, ?)}";

            //fill in the ?'s

            CallableStatement callableStatement = connection.prepareCall(sql);
            callableStatement.setString(2, customer.getUsername());
            callableStatement.setString(3, customer.getPassword());
            callableStatement.setString(4, customer.getFirstName());
            callableStatement.setString(5, customer.getLastName());
            callableStatement.setLong(6, customer.getPhone());
            callableStatement.setString(7, customer.getEmail());
            callableStatement.setInt(8, customer.getAge());
            callableStatement.setString(9, customer.getCity());

            //register id because it is an OUT param

            callableStatement.registerOutParameter(1, Types.VARCHAR);

            callableStatement.execute();

            //callableStatement should have executed and now contains the ID param

            customer.setId(callableStatement.getString(1));

            System.out.println("Customer account successfully created.");

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
    public Customer getCustomerByLogin(Customer customer) throws BusinessException {

        try (Connection connection = OracleConnection.getConnection()) {
            String sql = "{SELECT * FROM customer WHERE username = 'Sslatton';}";
            CallableStatement callableStatement = connection.prepareCall(sql);
//            callableStatement.setString(1, customer.getUsername());
//            callableStatement.setString(2, customer.getPassword());

            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                String id = rs.getString("ID");
                double balance = rs.getDouble("BALANCE");
                String username = rs.getString("USERNAME");

                customer = new Customer(id, username, balance);
            }


        } catch (SQLException | ClassNotFoundException e) {
            throw new BusinessException("Internal error. Please don't panic.");
        }
        return customer;
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

    @Override
    public Customer updateBalance(Customer customer) throws BusinessException {
        try (Connection connection = OracleConnection.getConnection()) {
            String sql = "{UPDATE CUSTOMER SET BALANCE = ? WHERE ID = ?}";
            CallableStatement callableStatement = connection.prepareCall(sql);
            callableStatement.setDouble(1, customer.getBalance());
            callableStatement.setString(2, customer.getId());

            callableStatement.execute();


        } catch (SQLException | ClassNotFoundException e) {
            throw new BusinessException("Internal error. Please don't panic.");
        }
        return customer;
    }
}
