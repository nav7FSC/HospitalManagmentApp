package org.education.hospitalmanagmentapp.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DatabaseConnector handles the connection to the Azure SQL Database.
 */
public class DatabaseConnector {

    private String url = "jdbc:sqlserver://<your-server-name>.database.windows.net:1433;database=<your-database-name>;user=<your-username>@<your-server-name>;password=<your-password>;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";

    /**
     * Establishes a connection to the database.
     * @return Connection object.
     */
    public Connection connect() {
        try {
            return DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
