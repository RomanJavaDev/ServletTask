
package com.myproject.connectionmanager;

import javax.ejb.EJB;
import java.sql.Connection;

@EJB
@Altertconnect
public class ConnectionManagerJdbcImplAlter implements ConnectionManager {

    @Override
    public Connection getConnection() {
        throw new IllegalStateException("Wrong dependencies");
    }
}