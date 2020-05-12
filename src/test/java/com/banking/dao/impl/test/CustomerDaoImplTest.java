package com.banking.dao.impl.test;

import com.banking.dao.CustomerDao;
import com.banking.dao.impl.CustomerDaoImpl;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public class CustomerDaoImplTest {

    private static CustomerDao dao;

    @BeforeClass
    public static void createCustomerDao(){
        dao = new CustomerDaoImpl();
    }

    @AfterClass
    public static void destroyCustomerDao(){
        dao = null;
    }
}
