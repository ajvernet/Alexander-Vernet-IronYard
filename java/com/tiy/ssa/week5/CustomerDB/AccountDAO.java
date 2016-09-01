package com.tiy.ssa.week5.CustomerDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.sql.DataSource;

import com.tiy.ssa.week5.model.Account;


/**
 *
 * @author thurston
 */

public class AccountDAO extends AbstractDAO<Account>
{

    public AccountDAO(DataSource datasource, AccountORM orm)
    {
        super(datasource, orm);
    }

    @Override
    public Account insert(Account domain)
    {
        
        try {
        Connection connection = this.datasource.getConnection();
        PreparedStatement insertStatement = connection.prepareStatement(this.orm.prepareInsert(), Statement.RETURN_GENERATED_KEYS);
        
        insertStatement.setInt(1,  domain.getCustomerID());
        insertStatement.setString(2,  domain.getAccountTypeString());
        insertStatement.setBigDecimal(3,  domain.getBalance());
        
        if(insertStatement.executeUpdate() > 0){
        ResultSet keys = insertStatement.getGeneratedKeys();
        keys.next();
        

        domain = domain.setId(keys.getInt(1));
        
        closeAll(keys, insertStatement, connection);
        }
        
        closeAll(insertStatement, connection);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return new Account(domain.getId(), domain.getCustomer(), domain.getAccountTypeString(), domain.getBalance());
    }

//    @Override
//    public Account update(Account domain)
//    {
//        Connection connection = this.datasource.getConnection();
//        PreparedStatement updateStatement = connection.prepareStatement(this.orm.prepareUpdate(), )
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    /**
     *
     * @param user
     * @return all the accounts for given user
     */

    public List<Account> readUser(int user)
    {
        try {
            Connection connection = this.datasource.getConnection();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        throw new UnsupportedOperationException("not implemented yet");
    }

    /**
     *
     * @return those accounts that have a negative balance - never null
     */
    public List<Account> readUnderwater()
    {
        throw new UnsupportedOperationException("not implemented yet");
    }

    @Override
    public Account update(Account domain) {

            Connection connection = null;
            PreparedStatement updateStatement = null;
            ResultSet keys = null;
            try {
               connection = this.datasource.getConnection();
               updateStatement = connection.prepareStatement(this.orm.prepareUpdate(), Statement.RETURN_GENERATED_KEYS);
               updateStatement.setString(1, domain.getAccountTypeString());
               updateStatement.setBigDecimal(2, domain.getBalance());
               if(updateStatement.executeUpdate() > 0)
               keys = updateStatement.getGeneratedKeys();
               
               domain = this.orm.map(keys);
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

    /*
        Implement a method readType that returns a List<Account>
        and takes in an argument indicating whether interested in 
        checking or savings accounts
    */


}

