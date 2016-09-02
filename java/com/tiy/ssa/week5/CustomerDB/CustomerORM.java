package com.tiy.ssa.week5.CustomerDB;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface CustomerORM extends ORM<Customer>{
    default String projection()
    {
        return "id, first, name";
    }
    
    default String table()
    {
        return "customers";
    }
    

    default Customer eagerMap(ResultSet results) throws SQLException
    {
        return null;
    }
    
    default Customer map(ResultSet results) throws SQLException
    {
        Customer cust = new Customer();
        
        
        cust = cust.setFirstName(results.getString("first"));
        cust = cust.setLastName(results.getString("last"));
        cust = cust.setId(results.getInt("id"));
        
        return cust;
        
    }
    

    
    default String prepareInsert()
    {
        return "INSERT INTO " + table() + " (first, last) VALUES(?, ?)";
    }
    
    default String prepareUpdate()
    {
        return "UPDATE customers SET first = ?, last = ? WHERE id = ?";
    }
    
    default String prepareDelete()
    {
        return "DELETE FROM customers WHERE id = ?";
    }
    
    default String prepareEagerRead()
    {
        return null;
    }
    default String prepareRead()
    {
        return "SELECT * FROM " + table() + " WHERE id = ?";
    }
    
    default String prepareClear()
    {
        return "DELETE * FROM customers";
    }
    
    
}
