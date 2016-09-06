package com.tiy.ssa.week6.BankProject;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.tiy.ssa.model.Account;
import com.tiy.ssa.model.Customer;
import com.tiy.ssa.week5.CustomerDB.AccountDAO;
import com.tiy.ssa.week5.CustomerDB.AccountORM;
import com.tiy.ssa.week5.CustomerDB.CustomerDAO;
import com.tiy.ssa.week5.CustomerDB.CustomerORM;

public class BankServiceImplTest {

    static String URL = "jdbc:mysql://localhost/customer_DB?" + 
            "user=root&password=root" + 
        "&useServerPrepStmts=true";
    
    MysqlDataSource datasource;
    CustomerDAO custDao;
    AccountDAO accDao;
    AccountORM accOrm = new AccountORM(){};
    CustomerORM custOrm = new CustomerORM(){};
    BankServiceImpl impl;
    
    @Before
    public void setup()
    {
        datasource = new MysqlDataSource();
        datasource.setUrl(URL);        
        accDao = new AccountDAO(datasource, accOrm);
        custDao = new CustomerDAO(datasource, custOrm);
        custDao.clear();
        impl = new BankServiceImpl(accDao);
    }
    
    @Test
    public void withdrawal() 
    {
        //insert acct, withdraw amount, check that balance = old - new.
        Customer testCust1 = new Customer("Alexander", "Vernet");     
        testCust1 = custDao.insert(testCust1);
  
        Account testAcct1 = new Account(testCust1, "CH", new BigDecimal("100.00"));
        testAcct1 = accDao.insert(testAcct1);
          
        testAcct1 = impl.withdraw(testAcct1.getId(), new BigDecimal("20.00"));
        
        assertTrue(accDao.read(testAcct1.getId()).getBalance().compareTo(new BigDecimal("80.00")) == 0);
        
    }
    
    @Test
    public void deposit()
    {
      //insert acct, withdraw amount, check that balance = old + new.
        Customer testCust1 = new Customer("Alexander", "Vernet");     
        testCust1 = custDao.insert(testCust1);
  
        Account testAcct1 = new Account(testCust1, "CH", new BigDecimal("100.00"));
        testAcct1 = accDao.insert(testAcct1);
         
        testAcct1 = impl.deposit(testAcct1.getId(), new BigDecimal("20.00"));

        assertTrue(accDao.read(testAcct1.getId()).getBalance().compareTo(new BigDecimal("120.00")) == 0);
         
    }
    
    @Test
    public void transfer()
    {
      //insert accts, transfer funds, check that balances reflect transfer.
        Customer testCust1 = new Customer("Alexander", "Vernet");     
        testCust1 = custDao.insert(testCust1);
  
        Account testAcct1 = new Account(testCust1, "CH", new BigDecimal("100.00"));
        testAcct1 = accDao.insert(testAcct1);
        
        Account testAcct2 = new Account(testCust1, "CH", new BigDecimal("100.00"));
        testAcct2 = accDao.insert(testAcct2); 
        
        impl.transfer(testAcct1.getId(), testAcct2.getId(), new BigDecimal("50.00"));
        
        System.out.println(accDao.read(testAcct1.getId()).getBalance());
        assertTrue(accDao.read(testAcct1.getId()).getBalance().compareTo(new BigDecimal("50.00")) == 0);
        assertTrue(accDao.read(testAcct2.getId()).getBalance().compareTo(new BigDecimal("150.00")) == 0); 
    }
    

}
