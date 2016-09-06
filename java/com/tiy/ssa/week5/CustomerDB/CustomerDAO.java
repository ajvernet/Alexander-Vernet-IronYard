package com.tiy.ssa.week5.CustomerDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mysql.cj.api.jdbc.Statement;
import com.tiy.ssa.model.Customer;

public class CustomerDAO extends AbstractDAO<Customer>{


   // String DBName;
    
    public CustomerDAO(DataSource datasource, CustomerORM orm) {
        super(datasource, orm);
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public Customer insert(Customer customer) {
        Connection connection = null;
        ResultSet keys = null;
        PreparedStatement insertStatement = null;
        
        
        try {
            connection = this.datasource.getConnection();
            insertStatement = connection.prepareStatement
                    (this.orm.prepareInsert(), Statement.RETURN_GENERATED_KEYS);
            
            insertStatement.setString(1, customer.getFirstName());
            insertStatement.setString(2, customer.getLastName());
            insertStatement.executeUpdate();
            
            keys = insertStatement.getGeneratedKeys();
            keys.next();
   
            return customer.setId(keys.getInt(1)).setLoaded();
      

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally { closeAll(keys, insertStatement, connection);}
        
        return customer;
    }



    @Override
    public Customer update(Customer customer) {
        Connection connection = null;
        PreparedStatement updateStatement = null;
        ResultSet keys = null;
        try {
           connection = this.datasource.getConnection();
           updateStatement = connection.prepareStatement(this.orm.prepareUpdate(), Statement.RETURN_GENERATED_KEYS);
           updateStatement.setString(1, customer.getFirstName());
           updateStatement.setString(2,  customer.getLastName());
           updateStatement.setInt(3,  customer.getId());
           
           if(updateStatement.executeUpdate() > 0)
           keys = updateStatement.getGeneratedKeys();
           if(keys.next())
           return customer = this.orm.map(keys);
     
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally { closeAll(keys, updateStatement, connection);}
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public void close() throws Exception {
        // TODO Auto-generated method stub
        
    }


}
