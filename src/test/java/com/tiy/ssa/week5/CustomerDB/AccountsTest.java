package com.tiy.ssa.week5.CustomerDB;

import java.math.BigDecimal;
import java.util.Objects;

import org.junit.Before;
import org.junit.Test;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.tiy.ssa.week5.model.Account;

import static org.junit.Assert.*;

public class AccountsTest {

    static String URL = "jdbc:mysql://localhost/customer_DB?" + 
            "user=root&password=root" + 
        "&useServerPrepStmts=true";
    
    MysqlDataSource datasource;
    AccountORM accOrm = new AccountORM(){};
    CustomerORM custOrm = new CustomerORM(){};
    AccountDAO accDao;
    CustomerDAO custDao;
    
    
    
    @Before
    public void setup()
    {
        datasource = new MysqlDataSource();
        datasource.setUrl(URL);
        
        accDao = new AccountDAO(datasource, accOrm);
        //accDao.clear();
        
        custDao = new CustomerDAO(datasource, custOrm);
        custDao.clear();

    }
    
    @Test
    public void insert()
    {
        Customer testCust1 = new Customer("Alexander", "Vernet");
        testCust1 = testCust1.setId(custDao.insert(testCust1).getId());
        custDao.read(testCust1.getId());
        accDao.insert(new Account(testCust1, "CH", new BigDecimal("100.00")));
        assertTrue(Objects.nonNull(custDao.read(testCust1.getId())));
    }

}
