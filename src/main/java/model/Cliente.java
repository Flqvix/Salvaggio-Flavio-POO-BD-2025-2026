package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente extends Utente {
    private double altezza;
    private double peso;
    private LocalDate scadenzaCertificatoMedico;
    private List<Abbonamento> abbonamenti;
    private List<SchedaAllenamento> schedeAllenamento;
    private List<SessioneAllenamento> sessioniAllenamento;

    public Cliente(String nome, String cognome, String email, String codiceFiscale, double altezza, double peso, LocalDate scadenzaCertificatoMedico) {
        super(nome, cognome, email, codiceFiscale); // Chiama il costruttore di Utente
        this.altezza = altezza;
        this.peso = peso;
        this.scadenzaCertificatoMedico = scadenzaCertificatoMedico;
        this.abbonamenti = new ArrayList<>();
        this.schedeAllenamento = new ArrayList<>();
        this.sessioniAllenamento = new ArrayList<>();
    }

    public void acquistaAbbonamento(Abbonamento abbonamento) {
        this.abbonamenti.add(abbonamento);
    }

    public void registraSessione(SessioneAllenamento sessione) {
        this.sessioniAllenamento.add(sessione);
    }

    // Getter e Setter
    public double getAltezza() { return altezza; }
    public void setAltezza(double altezza) { this.altezza = altezza; }
    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }
    public LocalDate getScadenzaCertificatoMedico() { return scadenzaCertificatoMedico; }
    public void setScadenzaCertificatoMedico(LocalDate scadenzaCertificatoMedico) { this.scadenzaCertificatoMedico = scadenzaCertificatoMedico; }
    public List<Abbonamento> getAbbonamenti() { return abbonamenti; }
    public List<SchedaAllenamento> getSchedeAllenamento() { return schedeAllenamento; }
    public List<SessioneAllenamento> getSessioniAllenamento() { return sessioniAllenamento; }
}