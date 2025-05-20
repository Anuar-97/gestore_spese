package Gestore_spese;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.postgresql.util.PSQLException;

public class ConnessioneDB{ 
    //connessione al dbpostgres
    public static void main (String[] args)throws SQLException{
    String urlpostgres="jdbc:postgresql://localhost:5432/postgres";     
    String user="postgres";
    String password="Anuar1997";

       
       try(
        Connection connpostgres=DriverManager.getConnection(urlpostgres,user,password);
        Statement stmtpostgres=connpostgres.createStatement()
        ){

        stmtpostgres.executeUpdate("CREATE DATABASE gestore_spese");
        System.out.println("database creato");

    }catch(PSQLException e) {
        if (e.getMessage().contains("esiste gia'")) {
            System.out.println("database gia esistente");
        }else{ 
            throw e;}} 

            
    String urlgestore="jdbc:postgresql://localhost:5432/gestore_spese";
    try(
    Connection conngestore=DriverManager.getConnection(urlgestore,user,password);
    Statement stmtgestore=conngestore.createStatement()
    ) {
        
    String query1= """
    CREATE TABLE IF NOT EXISTS spese (
        id SERIAL PRIMARY KEY,
        nome TEXT NOT NULL,
        valore REAL NOT NULL,
        valuta TEXT NOT NULL,
        tipologia TEXT NOT NULL,
        data DATE NOT NULL);
    """;
    stmtgestore.executeUpdate(query1);
    System.out.println("tabella pronta");
    }
}
}
   
   
   
