package com.tiy.ssa.week6.BankProject;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.tiy.ssa.model.Account;
import com.tiy.ssa.week5.CustomerDB.AccountDAO;

@Component
public class BankServiceImpl implements BankService{

    AccountDAO accDAO;
    
    public BankServiceImpl(AccountDAO accDAO)
    {
        this.accDAO = accDAO;
    }
    
    @Override
    public Account withdraw(int account, BigDecimal amount) throws IllegalArgumentException {
        if(accDAO.read(account) == null) return null;
        
        Account currentAcct = accDAO.read(account);
        return currentAcct = accDAO.update(currentAcct.setBalance(currentAcct.getBalance().subtract(amount)));     
    }


    @Override
    public Account deposit(int account, BigDecimal amount) {
        if(accDAO.read(account) == null) return null;
        
        Account currentAcct = accDAO.read(account);
        return currentAcct = accDAO.update(currentAcct.setBalance(currentAcct.getBalance().add(amount)));
    }

    @Override
    public boolean transfer(int from, int to, BigDecimal amount) throws IllegalArgumentException {
    
        if(accDAO.read(from) == null || accDAO.read(to) == null) return false;

        withdraw(from, amount);
        deposit(to, amount);
        
        return true;
    }

}
