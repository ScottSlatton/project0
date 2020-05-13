package com.banking.dao.impl;

import com.banking.dao.CustomerDao;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerDaoImplTest {

    private static CustomerDao dao;

    @BeforeClass
    public static void createCustomerDao(){
        dao = new CustomerDaoImpl();
    }


    @Test
    void createCustomer() {

    }

    @Test
    void getCustomerByUsername() {

        assertThat()
    }

    @Test
    void getCustomerByLogin() {
    }

    @Test
    void getAllCustomers() {
    }

    @Test
    void getCustomerById() {
    }
    @AfterClass
    public static void destroyCustomerDao(){
        dao = null;
    }
}