
package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbCon{
    private static DbCon  instance=new DbCon();
    private DbCon(){}
    public static DbCon getInstance(){
          return instance;
    }
    public Connection getConnection(){
        Connection dbConn=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
	    dbConn = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/cafe?useUnicode=yes&characterEncoding=UTF-8","root","");
		
        }catch(ClassNotFoundException e){
            System.err.println(e.getMessage());
        }
        catch(SQLException e){
            System.err.println(e.getMessage());
        }
        return dbConn;
    }
    
    
}


