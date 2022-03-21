package login_register;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class DBconnection {
    //create function to connect mysql database
    public static Connection getConnection(){
        Connection connect = null;
        try{
            Class.forName("org.h2.Driver");
            connect = DriverManager.getConnection("jdbc:h2:~/happyauction;IFEXISTS=TRUE", "sa", "");
            
            
            System.out.println("Connected");
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Connection Failed " + e);
        }
        
        return connect;
    }
}