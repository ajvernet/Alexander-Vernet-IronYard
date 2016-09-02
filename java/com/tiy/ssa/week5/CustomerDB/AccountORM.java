package com.tiy.ssa.week5.CustomerDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.tiy.ssa.week5.model.Account;

public interface AccountORM extends ORM<Account>{
    
    CustomerORM custORM = new CustomerORM(){};
    default String projection()
    {
        return "id, customer, type, balance";
    }

    default String table()
    {
        return "accounts";
    }

    default Account eagerMap(ResultSet results) throws SQLException
    {
        
        
        Account acct = new Account();
        
   
        acct = acct.setId(results.getInt(1));

        acct = acct.setCustomer(new Customer(results.getInt(2), results.getString(6), results.getString(7)));
       
        acct = acct.setAccountType(results.getString(3));
        acct = acct.setBalance(results.getBigDecimal(4));
 
        return acct;
    }
    
    default Account map (ResultSet results) throws SQLException
    {

        Account acct = new Account();
        
   
        acct = acct.setId(results.getInt(1));

        acct = acct.setCustomer(new Customer(results.getInt(2)));
       
        acct = acct.setAccountType(results.getString(3));
        acct = acct.setBalance(results.getBigDecimal(4));
 
        return acct;
    }


    default String prepareInsert()
    {
        return "INSERT INTO " + table() + " (customer, type, balance) VALUES(?, ?, ?) ";
    }

    default String prepareBalanceUpdate(){
        
        return "UPDATE " + table() +  " SET balance = ? WHERE id = ?";
    }
    
    default String prepareTypeUpdate()
    {
        return "UPDATE " + table() + " SET type = ? WHERE id = ?";
    }

    default String prepareUpdate()
    {
        return "UPDATE " + table() + " Set type = ?, balance = ? WHERE id = ?";
    }
    
   

    default String prepareEagerRead()
    {
        return "SELECT * FROM " + table() + " INNER JOIN Customers ON ";
                
    }
    
    default String prepareRead()
    {
        return "SELECT * FROM " + table() + " WHERE id = ?";
    }
    
    default String prepareDelete()
    {
        return "DELETE FROM " + table() + " WHERE id = ?";
    }
    
    default String prepareClear()
    {
        return "DELETE * FROM " + table() + " WHERE id = ?";
    }
    

}
