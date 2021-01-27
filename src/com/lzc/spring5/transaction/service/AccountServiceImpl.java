package com.lzc.spring5.transaction.service;

import com.lzc.spring5.transaction.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService{
    @Autowired
    private AccountDao accountDaoImpl;

    @Override
    public void changeForAccount() {
        accountDaoImpl.addMoney();
        accountDaoImpl.reduceMoney();
    }
}
