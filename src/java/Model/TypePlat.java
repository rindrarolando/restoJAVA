/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author rindrarolando
 */
public class TypePlat {
    public int id;
    public String type;

    public TypePlat() {
    }

    public TypePlat(int id, String type) {
        this.id = id;
        this.type = type;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public String getType(int id) throws Exception{
        Connection c = new Connect().getConnection();
        Statement stmt = null;
        String resultat = null;
        try{
            String req="select * from typeplat where id="+id+";";
            stmt = c.createStatement();
            ResultSet res= stmt.executeQuery(req);
            while(res.next()){
                String type = res.getString("type");
                resultat = type;
            }
            return resultat;
        }catch(Exception e){
            return null;
        }finally{
            if(c!=null){c.close();}
            if(stmt!=null){stmt.close();}
        }
    }

}
