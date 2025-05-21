package Gestore_spese;

//TODO scaricare log4j e inserirlo nel progetto (src già in lib)

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter



// TODO: da inserire le librerie API (sarebbe da fare anche il database);
public class GestoreSpese{
    public static void main(String[] args) {
    String urlgestore="jdbc:postgresql://localhost:5432/gestore_spese";     
    String user="postgres";
    String password="Anuar1997";
    Connection conn = null;
    Statement stato = null;

    try {conn=DriverManager.getConnection(urlgestore,user,password);

    //TODO: metodo poco sicuro,usare il preparestatement(antisql injection)

     stato=conn.createStatement();

    System.out.println("Connessione al database riuscita");}
    catch(SQLException e)
    //TODO: gestire anche altre eccezioni, oppure mettere un exception piu generico
    {
            System.out.println("connessione fallita: "+e.getMessage());
        } 
        Scanner sc= new Scanner(System.in);
        boolean attivo= true; 
        while (attivo) {

        System.out.println("-----MENU-----");
        System.out.println("1.inserire Spesa");
        System.out.println("2.vedere il Totale");
        System.out.println("3.chiudi");
    //TODO: inserire le opzioni per eliminare le voci e per interrogare il DB;
        int scelta=sc.nextInt();
        sc.nextLine();

    //TODO: forse è meglio inserire una .nextLine() in var;

        switch (scelta) {
            case 1:
                System.out.println("Nome spesa: ");
                String nome=sc.nextLine();
                System.out.println("Valore spesa: ");
                double valore=sc.nextDouble();
                sc.nextLine();
                System.out.println("Tipologia spesa: ");
                String tipologia=sc.nextLine();
                LocalDateTime data=LocalDateTime.now();
                //TODO:inserire anche il String valuta=sc.nextLine();
                //inserire in un metodo, è più pulito
                Spese acquisto = new Spese(nome,valore,tipologia,data);

                System.out.println("Nome: " + acquisto.getNome());
                System.out.println("Valore: " + acquisto.getValore());
                System.out.println("Tipologia: " + acquisto.getTipologia());
                System.out.println("Data e ora: " + acquisto.getData());

        break;
    
            case 2:
             try {
            ResultSet rs = stato.executeQuery("SELECT SUM(valore) FROM spese");
            if (rs.next()) {
                double totale = rs.getDouble(1);
                System.out.println("Totale spese nel database: " + totale + " €");
            } else {
                System.out.println("Nessuna spesa trovata.");
        }
            } catch (SQLException e) {
            System.out.println("Errore durante il calcolo del totale: " + e.getMessage());
        }
            case 3:
            attivo = false;
            System.out.println("Chiusura del programma in corso...");

        try {
            if (stato != null) stato.close();
            if (conn != null) conn.close();
            System.out.println("Connessione chiusa.");
        } catch (SQLException e) {
            System.out.println("Errore nella chiusura della connessione: " + e.getMessage());
        }

        sc.close();
        break;
        
            default:
            System.out.println("scelta non valida");
        }
        }
        sc.close();

        }
        }

    
