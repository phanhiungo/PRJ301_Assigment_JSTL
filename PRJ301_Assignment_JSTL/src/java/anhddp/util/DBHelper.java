/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhddp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author moneymaker
 */
public class DBHelper {
    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName=UserManagement" ;
        Connection con = DriverManager.getConnection(url, "sa", "12345");
        return con;
    }
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException, NamingException {
        Connection con = getConnection();
        if(con != null){
            System.out.println("Connected");
        }
    }
    
}
