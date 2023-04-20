/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author rindrarolando
 */
public class Table {
    public int id ;

    public Table(int id) {
        this.id = id;
    }

    public Table() {
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public ArrayList<Table> TousLesTables() throws Exception{
        Connection c = new Connect().getConnection();
        ArrayList<Table> list= new ArrayList<Table>();
        Statement stmt = null;

        try{
            String req="select * from latabatra;";
            stmt = c.createStatement();
            ResultSet res= stmt.executeQuery(req);
            while(res.next()){
                int id = res.getInt("id");
                
                Table lat = new Table(id);
                list.add(lat);
            }
            return list;
        }catch(Exception e){
            return null;
        }finally{
            if(c!=null){c.close();}
            if(stmt!=null){stmt.close();}
        }
    }
    
    public ArrayList<Table> TousLesTablesDisponibles() throws Exception{
        Connection c = new Connect().getConnection();
        ArrayList<Table> list= new ArrayList<Table>();
        Statement stmt = null;

        try{
            String req="select * from latabatra l join commande c on l.id=c.idtable where etat=0;";
            stmt = c.createStatement();
            ResultSet res= stmt.executeQuery(req);
            while(res.next()){
                int id = res.getInt("id");
                
                Table lat = new Table(id);
                list.add(lat);
            }
            return list;
        }catch(Exception e){
            return null;
        }finally{
            if(c!=null){c.close();}
            if(stmt!=null){stmt.close();}
        }
    }
    
}
