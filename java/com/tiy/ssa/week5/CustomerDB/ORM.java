package com.tiy.ssa.week5.CustomerDB;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ORM<T extends DomainObject>
{
    String projection();

    String table();

    T map (ResultSet results) throws SQLException;
    
    T eagerMap (ResultSet results) throws SQLException;

    String prepareInsert();

    String prepareUpdate();

    String prepareEagerRead();
    
    String prepareRead();

    String prepareDelete();


}
