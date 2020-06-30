
package com.myproject.connectionmanager;

import java.sql.Connection;

public interface ConnectionManager {
    Connection getConnection();
}