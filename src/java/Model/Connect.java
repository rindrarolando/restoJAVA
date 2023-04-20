/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Shelby
 */
public class Connect {
       public Connection getConnection()throws Exception{
    Class.forName("org.postgresql.Driver");
      Connection conn = DriverManager.getConnection(
      "jdbc:postgresql://localhost:5432/resto","postgres","mdpprom13");
      return conn;
  }
      
      public ResultSet  getTableau(String req)throws Exception{
         Connection c= new Connect().getConnection();
         Statement st = c.createStatement();
         ResultSet res=  st.executeQuery(req);
         return res;
      }
      public void execution(String req)throws Exception{
         Connection c= new Connect().getConnection();
         Statement st = c.createStatement();
         st.execute(req);
      }
}
