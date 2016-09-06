package com.tiy.ssa.week5.CustomerDB;

import java.math.BigDecimal;
import java.util.Objects;

import org.junit.Before;
import org.junit.Test;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.tiy.ssa.model.Account;
import com.tiy.ssa.model.Customer;

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
    
//    @Test
    public void insertAndLoaded()
    {
        Customer testCust1 = new Customer("Alexander", "Vernet");     
        testCust1 = custDao.insert(testCust1);
        
        Account testAcct1 = new Account(testCust1, "CH", new BigDecimal("100.00"));
   
        custDao.read(testCust1.getId());
        testAcct1 = accDao.insert(testAcct1);

        assertTrue(Objects.nonNull(custDao.read(testCust1.getId())));
        assertTrue(testCust1.isLoaded());
        
        assertTrue(Objects.nonNull(accDao.read(testAcct1.getId())));
        assertTrue(testAcct1.isLoaded());
 
    }
    
    @Test
    public void update()
    {
        Customer testCust1 = new Customer("Alexander", "Vernet");
        testCust1 = custDao.insert(testCust1);
        
        Account testAcct1 = new Account(testCust1, "CH", new BigDecimal("100.00"));
        custDao.read(testCust1.getId());
        
        testAcct1 = accDao.insert(testAcct1);

        
        Customer testUpdatedCust = new Customer(testCust1.getId(), "AlexUpdated", "VernetUpdated");
     
        custDao.update(testUpdatedCust);
        
        System.out.println(testUpdatedCust);
        System.out.println(custDao.read(testCust1.getId()));
        assertTrue(custDao.read(testCust1.getId()).deeplyEquals(testUpdatedCust));
        
        System.out.println(accDao.update(testAcct1.setBalance(new BigDecimal("500"))));
        System.out.println(accDao.read(testAcct1.getId()));
       
    }
    
//    @Test
    public void eagerReadTest()
    {
        Customer testCust1 = new Customer("Alexander", "Vernet");     
        testCust1 = custDao.insert(testCust1);
        
        Account testAcct1 = new Account(testCust1, "CH", new BigDecimal("100.00"));
   
        custDao.read(testCust1.getId());
        testAcct1 = accDao.insert(testAcct1);
        
        System.out.println(accDao.eagerRead());
      
    }
    
//    @Test
    public void userReadTest()
    {
        Customer testCust1 = new Customer("Alexander", "Vernet");     
        testCust1 = custDao.insert(testCust1);

        
        Account testAcct1 = new Account(testCust1, "CH", new BigDecimal("100.00"));
        Account testAcct2 = new Account(testCust1, "SA", new BigDecimal("100.00"));
        Account testAcct3 = new Account(testCust1, "CH", new BigDecimal("200.00"));
   
      
        testAcct1 = accDao.insert(testAcct1);
        testAcct2 = accDao.insert(testAcct2);
        testAcct3 = accDao.insert(testAcct3);
        
        System.out.println(accDao.eagerRead());
      //  System.out.println(accDao.readUser(user));
    //    System.out.println(accDao.readUser(testCust1.getId()));
    }

}
