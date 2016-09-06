package com.tiy.ssa.week5.CustomerDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import com.tiy.ssa.model.Account;


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
        
        Connection connection = null;
        PreparedStatement insertStatement = null;
        ResultSet keys = null;
        try {
        connection = this.datasource.getConnection();
        insertStatement = connection.prepareStatement(this.orm.prepareInsert(), Statement.RETURN_GENERATED_KEYS);
        
        insertStatement.setInt(1,  domain.getCustomerID());
        insertStatement.setString(2,  domain.getAccountTypeString());
        insertStatement.setBigDecimal(3,  domain.getBalance());
        
        if(insertStatement.executeUpdate() > 0){
            keys = insertStatement.getGeneratedKeys();
            if(keys.next())
                
                return domain.setId(keys.getInt(1)).setLoaded();    

        }
        

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally { closeAll(insertStatement, connection);}
        
        return null;//new Account(domain.getId(), domain.getCustomer(), domain.getAccountTypeString(), domain.getBalance());
    }

    
    /**
     *
     * @param user
     * @return all the accounts for given user
     */

  
    public List<Account> eagerRead(){
    
    List<Account> accList = new ArrayList<>();
    {
        CustomerORM custORM = new CustomerORM(){};
        Connection connection = null;
        PreparedStatement read = null;
        ResultSet query = null;
            try
            {

                connection = this.datasource.getConnection();

                read = connection.prepareStatement(this.orm.prepareEagerRead() + this.orm.table() + 
                        ".customer" + " = " + custORM.table() + ".id");

                query = read.executeQuery();
                while (query.next()){
                    System.out.println(this.orm.eagerMap(query));
                    accList.add(this.orm.eagerMap(query));
                }
                
                return accList;
            }
            catch (Exception ex)
            {

            }
            return null;
        }
    }
    
    public List<Account> readUser(int user)
    {
        List<Account> accountList = new ArrayList<>();
        CustomerORM custORM = new CustomerORM(){};
        Connection connection = null;
        PreparedStatement read = null;
        ResultSet query = null;
            try
            {

                connection = this.datasource.getConnection();

                read = connection.prepareStatement(this.orm.prepareEagerRead() + this.orm.table() + 
                        ".customer" + " = " + custORM.table() + ".id WHERE id = ?");
                read.setInt(1, user);
                query = read.executeQuery();
                while (query.next()){

                    accountList.add(this.orm.eagerMap(query));
                }
                
                return accountList;

            }
            catch (Exception ex)
            {

            }
            return null;
    }

    /**
     *
     * @return those accounts that have a negative balance - never null
     */
//    public List<Account> readUnderwater()
//    {
//        Connection connection = null;
//        PreparedStatement read = null;
//        ResultSet query = null;
//            try
//            {
//
//                connection = this.datasource.getConnection();
//
//                read = connection.prepareStatement("SELECT * FROM accounts WHERE balance = ?");
//                read.setBigDecimal(1, x);
//
//                query = read.executeQuery();
//                if (query.next())
//
//                    return this.orm.eagerMap(query);
//
//            }
//            catch (Exception ex)
//            {
//
//            }
//            return null;
//        
//    
//    
//    }

    @Override
    public Account update(Account domain) {

            Connection connection = null;
            PreparedStatement updateStatement = null;
            ResultSet keys = null;
            try {
               connection = this.datasource.getConnection();
               updateStatement = connection.prepareStatement(this.orm.prepareUpdate());
               updateStatement.setString(1, domain.getAccountTypeString());
               updateStatement.setBigDecimal(2, domain.getBalance());
               updateStatement.setInt(3, domain.getId());
               
               updateStatement.executeUpdate();
   
                   return domain.setLoaded();
               
               
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

