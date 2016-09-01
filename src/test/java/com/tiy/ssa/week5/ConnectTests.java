package com.tiy.ssa.week5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mysql.cj.jdbc.MysqlDataSource;





public class ConnectTests 
{

    
    static String URL = "jdbc:mysql://localhost/ssa_bank?" + 
    "user=root&password=root";
    
    
    DataSource datasource;
    Connection connection;
    @Before
    public void setupDB() throws SQLException
    {
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setUrl(URL);
        Connection connection = mysqlDataSource.getConnection();
        this.datasource = mysqlDataSource;
        this.connection = connection;
    }
    
    @After
    public void tearDown() throws SQLException
    {
        this.connection.close();
    }
    
    //@Test
    public void datasource() throws Exception {
        

        Statement sql = this.connection.createStatement();
        ResultSet results = sql.executeQuery("SELECT * FROM customers WHERE id = 3");
        assertTrue("", results.next());
        
        assertEquals("", 2, results.getInt(1));
        assertEquals("","Jane", results.getString(2));
        assertEquals("", "Doe", results.getString(3));

    }
    
   // @Test
    public void prepare() throws SQLException
    {
        PreparedStatement prepareStatement = this.connection.prepareStatement("SELECT * FROM customers WHERE id = ?");
        prepareStatement.setInt(1,1);
        ResultSet results = prepareStatement.executeQuery();
        
        assertTrue("", results.next());
        
        assertEquals("", 1, results.getInt(1));
        assertEquals("","John", results.getString(2));
        assertEquals("", "Doe", results.getString(3));

    }
    
    //@Test
    public void create() throws SQLException
    {
        PreparedStatement prepareStatement = this.connection.prepareStatement("INSERT INTO customers (first, last) VALUES(?,?)", Statement.RETURN_GENERATED_KEYS);
        prepareStatement.setString(1,  "Jane");
        prepareStatement.setString(2, "Doe");
        assertEquals("", 1, prepareStatement.executeUpdate());
        ResultSet generatedKeys = prepareStatement.getGeneratedKeys();
        assertTrue(generatedKeys.next());
        System.err.println("inserted customer with id " + generatedKeys.getInt(1));
        
        
    }
    
   // @Test
    public void remove() throws SQLException
    {
        PreparedStatement prepareStatement = this.connection.prepareStatement("DELETE FROM customers WHERE id = ?");
        prepareStatement.setInt(1,2);
        assertEquals("", 1, prepareStatement.executeUpdate());
    }
    
    @Test
    public void addAndUpdate() throws SQLException
    {
//        PreparedStatement createStatement = this.connection.prepareStatement("INSERT INTO customers (first, last) VALUES(?,?)", Statement.RETURN_GENERATED_KEYS);
//        createStatement.setString(1, "Jane");
//        createStatement.setString(2, "Doe");
//        assertEquals(1, createStatement.executeUpdate());
//        ResultSet generatedKeys = createStatement.getGeneratedKeys();
//        assertTrue(generatedKeys.next());
//        System.err.println("inserted customer with id " + generatedKeys.getInt(1));
       
        System.err.println(connection.getCatalog());//etMetaData().getTables(null, null, tableNamePattern, null);
        
//       PreparedStatement updateStatement = this.connection.prepareStatement("UPDATE customers SET first = ?, last = ? WHERE id = ?");
//       updateStatement.setString(1, "Joe");
//       updateStatement.setString(2, "Bob");
//       updateStatement.setInt(3,  12);
//       updateStatement.executeUpdate();
        
    }
    
    

}
