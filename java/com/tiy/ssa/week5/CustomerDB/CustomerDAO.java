package com.tiy.ssa.week5.CustomerDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mysql.cj.api.jdbc.Statement;

public class CustomerDAO extends AbstractDAO<Customer>{


   // String DBName;
    
    protected CustomerDAO(DataSource datasource, CustomerORM orm) {
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
   
            customer = customer.setId(keys.getInt(1));

            return new Customer(customer.getId(), customer.getFirstName(), customer.getLastName());

            

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
           updateStatement.setString(2, customer.getFirstName());
           updateStatement.setString(3,  customer.getLastName());
           if(updateStatement.executeUpdate() > 0)
           keys = updateStatement.getGeneratedKeys();
           
           customer = this.orm.map(keys);
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
