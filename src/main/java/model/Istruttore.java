package model;

import java.util.ArrayList;
import java.util.List;

public class Istruttore extends Utente {
    private String specializzazione;
    private List<SchedaAllenamento> schedeCreate;

    public Istruttore(String nome, String cognome, String email, String codiceFiscale, String specializzazione) {
        super(nome, cognome, email, codiceFiscale);
        this.specializzazione = specializzazione;
        this.schedeCreate = new ArrayList<>();
    }

    public void creaScheda(Cliente cliente, SchedaAllenamento scheda) {
        this.schedeCreate.add(scheda);
        cliente.getSchedeAllenamento().add(scheda);
    }

    public List<SessioneAllenamento> monitoraProgressi(Cliente cliente) {
        // L'istruttore richiede lo storico al cliente
        return cliente.getSessioniAllenamento();
    }

    // Getter e Setter
    public String getSpecializzazione() { return specializzazione; }
    public void setSpecializzazione(String specializzazione) { this.specializzazione = specializzazione; }
    public List<SchedaAllenamento> getSchedeCreate() { return schedeCreate; }
}