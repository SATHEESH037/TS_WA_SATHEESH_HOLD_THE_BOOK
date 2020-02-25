package db;

import java.sql.Connection;
import java.sql.DriverManager;
public class UserDb {
      public static Connection getConnection() {
          try  {
              Class.forName("oracle.jdbc.driver.OracleDriver");
              Connection con = DriverManager.getConnection
                      ("jdbc:oracle:thin:@localhost:1521:xe","system","123");
              return con;
          }
          catch(Exception ex) {
              System.out.println("Database.getConnection() Error -->" + ex.getMessage());
              return null;
          }
      }
 
       public static void close(Connection con) {
          try  {
              con.close();
          }
          catch(Exception ex) {
          }
      }
}