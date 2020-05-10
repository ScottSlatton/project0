package com.banking.models;

import com.banking.exception.BusinessException;

public class CheckingAccount implements Account{


    public CheckingAccount() {
        super();
    }


    @Override
    public void transfer(Customer payer, Customer payee) throws BusinessException {
//        payer.accounts[]
    }
}
