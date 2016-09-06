package com.tiy.ssa.week5.CustomerDB;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.tiy.ssa.model.Account;
import com.tiy.ssa.model.Customer;

public interface EagerAccountORM extends AccountORM{
    @Override
    default String prepareRead()
    {
        return "SELECT * FROM " + table() + " INNER JOIN Customers ON "
                + table() + ".customer" + " = " + custORM.table() + ".id;";
    }
   
    @Override
    default Account map(ResultSet results)
    {
        System.out.println("reached");
        Account acct = new Account();
        
        try {
           acct = acct.setId(results.getInt(1));
           System.out.println(results.getInt(1));
        acct = acct.setCustomer(new Customer(results.getInt(2), results.getString(6), results.getString(7)));
        System.out.println(results.getInt(2) + results.getString(6) + results.getString(7));
        acct = acct.setAccountType(results.getString(3));
        acct = acct.setBalance(results.getBigDecimal(4));
    
        System.out.println(acct);
        return acct;
        
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return acct;
    }
}
