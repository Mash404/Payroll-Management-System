package payrollmanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ConnectMSSQL {
    
    Connection conn=null;
            
    public static Connection connectDB() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=PayrollManagementSystem;selectMethod=cursor", "sa", "123456");
            
            //System.out.println("DATABASE NAME IS:" + connection.getMetaData().getDatabaseProductName());
            return conn;
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("Connect Error= "+ex);
        }
        return null;
    }
    
    public static void main(String[] args) {
        
    }
}