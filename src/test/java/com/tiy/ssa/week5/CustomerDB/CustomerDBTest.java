package com.tiy.ssa.week5.CustomerDB;

import static org.junit.Assert.*;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.tiy.ssa.model.Customer;




public class CustomerDBTest {

static String URL = "jdbc:mysql://localhost/customer_DB?" + 
            "user=root&password=root" + 
        "&useServerPrepStmts=true";
DataSource datasource;
CustomerDAO testDB;
CustomerORM testORM = new CustomerORM(){};

@Before
public void setupDB() throws SQLException
{
    
    MysqlDataSource myDS = new MysqlDataSource();
    myDS.setUrl(URL);
    datasource = myDS;

    testDB = new CustomerDAO(datasource, testORM);
    
} 
   
    @Test
    public void insertTest() throws SQLException {
        
        Customer testCust = new Customer("Joe", "Johnson");
        testDB.insert(testCust);
        
       testCust = testCust.setId(testDB.insert(testCust).getId());
      
       System.out.println(testCust.getId());
       System.out.println(testDB.read(testCust.getId()));
        assertEquals(testDB.read(testCust.getId()), testCust);
            
    }
    
//    @Test
    public void readTest(){
        Customer readCust = testDB.read(20);      
        assertEquals(readCust, new Customer(20,"Joe","Johnson"));
        
        Customer readCust2 = testDB.read(50);
        assertTrue(readCust2 == null);       
    }
  //  @Test
    public void updateTest(){
        
    }
    
//    @Test
    public void deleteTest(){
        Customer testCust = new Customer("Billy", "Bob");
        testDB.insert(testCust);
        testDB.delete(testCust.getId());
        assertTrue(testDB.read(testCust.getId()) == null);
        
    }

}
