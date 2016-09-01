package com.tiy.ssa.week5.CustomerDB;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public interface DAOHelper {

    default void closeAll(ResultSet results, Statement statement, Connection connection)
        {
            try {
                results.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
            // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    default void closeAll(Statement statement, Connection connection)
    {
        try{
            statement.close();
            connection.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}

