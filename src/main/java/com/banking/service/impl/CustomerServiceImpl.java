package com.banking.service.impl;

import com.banking.dao.CustomerDao;
import com.banking.dao.impl.CustomerDaoImpl;
import com.banking.exception.BusinessException;
import com.banking.models.Customer;
import com.banking.service.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    private CustomerDao dao = new CustomerDaoImpl();


    @Override
    public Customer createCustomer(Customer customer){

        try{
            validatesCustomer(customer);
            // Call the DAO
            dao.createCustomer(customer);
        } catch(BusinessException e){
            System.out.println(e.getMessage());
        }
        return customer;
    }

    @Override
    public Customer customerLogin(Customer customer) throws BusinessException {
        return null;
    }

    public void validatesCustomer(Customer customer) throws BusinessException {
        if(customer == null){
            throw new BusinessException("Customer Object was not found.");
        } else if (!isValidPhone(customer.getPhone())){
            throw new BusinessException("Customer phone number is invalid.");
        } else if (!isValidCity(customer.getCity())) {
            throw new BusinessException("Customer city is invalid.");
        } else if (!isValidName(customer.getFirstName())) {
            throw new BusinessException("Customer name is invalid.");
        } else if (!isValidName(customer.getLastName())) {
            throw new BusinessException("Customer Last Name is invalid.");
        } else if (!isValidEmail(customer.getEmail())) {
            throw new BusinessException("Customer Email is invalid.");
        }
    }

    private boolean isValidPhone(long phone){
        boolean b = false;
        if ((phone + "").matches("[0-9]{10}")){
            b = true;
        }
        return b;
    }
    private boolean isValidName(String name){
        boolean b = false;
        if (name.matches("[a-zA-Z]{2,10}")){
            b = true;
        }
        return b;
    }
    private boolean isValidId(String id){
        boolean b = false;
        if (id.matches("MB[A-Z]{2}[0-9]{12}")){
            b = true;
        }
        return b;
    }
    private boolean isValidCity(String city){
        boolean b = false;
        if (city.matches("[a-zA-Z]{2,11}")){
            b = true;
        }
        return b;
    }
    private boolean isValidEmail(String email){
        boolean b = false;
        if (email.matches("^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$")){
            b = true;
        }
        return b;
    }



    @Override
    public Customer getCustomerById(String id) throws BusinessException {
        return null;
    }

    @Override
    public Customer updateCustomerPhone(String id, long newPhone) throws BusinessException {
        return null;
    }

    @Override
    public void deleteCustomer(String id) throws BusinessException {

    }

    @Override
    public List<Customer> getCustomersByCity(String city) throws BusinessException {
        return null;
    }
}
