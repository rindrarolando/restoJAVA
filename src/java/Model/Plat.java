
package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Plat {
    public int id ;
    public String designation;
    public int idType ;
    public double prix;

    public Plat() {
    }

    public Plat(int id, String designation, int idType, double prix) {
        this.id = id;
        this.designation = designation;
        this.idType = idType;
        this.prix = prix;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
    
    public ArrayList<Plat> TousLesPlats()throws Exception{
      Connection c = new Connect().getConnection();
      ArrayList<Plat> list= new ArrayList<Plat>();
      Statement stmt = null;
      
      try{
          String req="select * from plat;";
          stmt = c.createStatement();
          ResultSet res= stmt.executeQuery(req);
          while(res.next()){
              int id = res.getInt("id");
              String designation = res.getString("designation");
              int idType = res.getInt("idtype");
              double prix = res.getDouble("prix");
              Plat plat = new Plat(id,designation,idType,prix);
              list.add(plat);
          }
          return list;
      }catch(Exception e){
          return null;
      }finally{
          if(c!=null){c.close();}
          if(stmt!=null){stmt.close();}
      }
    }
    
    public ArrayList<Plat> PlatsParType(int idtype)throws Exception{
      Connection c = new Connect().getConnection();
      ArrayList<Plat> list= new ArrayList<Plat>();
      Statement stmt = null;
      
      try{
          String req="select * from plat where idtype="+idtype+";";
          stmt = c.createStatement();
          ResultSet res= stmt.executeQuery(req);
          while(res.next()){
              int id = res.getInt("id");
              String designation = res.getString("designation");
              int idType = res.getInt("idtype");
              double prix = res.getDouble("prix");
              Plat plat = new Plat(id,designation,idType,prix);
              list.add(plat);
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
