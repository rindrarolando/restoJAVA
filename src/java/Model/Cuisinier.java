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
 * @author Shelby
 */
public class Cuisinier {
    public int id;
    public String login;
    public String password;
    public String nom;

    public Cuisinier(int id, String login, String password, String nom) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.nom = nom;
    }

    public Cuisinier() {
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    
    public Cuisinier treatlogin(String log,String pass) throws Exception{
        Connection c = new Connect().getConnection();
        Statement stmt = null ;
        Cuisinier cuisinier = new Cuisinier();
        try{
            String query= "SELECT * FROM cuisinier WHERE login='"+log+"' AND password = md5('"+pass+"');";
            stmt = c.createStatement();
            ResultSet res = stmt.executeQuery(query);
            while(res.next()){
                int id = res.getInt("id");
                String login = res.getString("login");
                String password = res.getString("password");
                String nom = res.getString("nom");
                
                cuisinier = new Cuisinier(id,login,password,nom);
            }
                return cuisinier;
        }catch(Exception e){
            return null;
        }finally{
            if(c!=null){
                c.close();
            }
            if(stmt!=null){
                stmt .close();
            }
        }
            
    }
    
}
