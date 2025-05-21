package Gestore_spese;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

public class Spese{

    private String nome;
    private double valore;
    private String tipologia;
    private LocalDateTime data;
    

    public Spese(String nome, double valore, String tipologia, LocalDateTime data)
    {
        this.nome=nome;
        this.valore=valore;
        this.tipologia=tipologia;
        this.data=data;
    }




}