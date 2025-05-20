package Gestore_spese;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.postgresql.util.PSQLException;
import java.util.Scanner;
import java.time.LocalDate;


public class GestoreSpese {
    public static void main(String[] args) {
    String urlgestore="jdbc:postgresql://localhost:5432/gestore_spese";     
    String user="postgres";
    String password="Anuar1997";

    try(Connection conn=DriverManager.getConnection(urlgestore,user,password);
    Statement stmt=conn.createStatement()){

    System.out.println("Connessione al database riuscita");
    }catch(SQLException e) {
            System.out.println("connessione fallita: "+e.getMessage());
        } 
        Scanner sc= new Scanner(System.in);
        boolean attivo=true;

        while (attivo) {

        System.out.println("-----MENU-----");
        System.out.println("1.inserire Spesa");
        System.out.println("2.vedere il Totale");
        System.out.println("3.chiudi");
        int scelta=sc.nextInt();

        switch (scelta) {
            case 1:
                





            case 2:





            case 3:

                break;
        
            default:

            system.out.println("scelta non valida");

                break;
        }


    }
    }
    
