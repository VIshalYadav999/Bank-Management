package atm.simulator.machine;

import java.sql.*;

public class Conn{
    
    Connection c;
    Statement s;
    public Conn(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///atmsimulatormachine", "root", "0123456");
            s = c.createStatement();
         }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}



