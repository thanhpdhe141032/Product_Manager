/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thanh Dang
 */
public class DBContext {
  

    public Connection getConnection() throws Exception {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + "\\" + instance + ";databaseName=" + dbName;
        if (instance == null || instance.trim().isEmpty()) {
            url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
        }
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, userID, password);
    }
// chạy phát nữa xem 
    //
    private final String serverName = "localhost";
    private final String dbName = "DemoSE1510";
    private final String portNumber = "1433"; // nó mặc định mà 1433
    private final String instance = "";
    private final String userID = "sa";
    private final String password = "123";

   

    public static void main(String[] args) {
        try {
            System.out.println(new DBContext().getConnection());
            System.out.println("sucess");
        } catch (Exception e) {
        }
    }

}

