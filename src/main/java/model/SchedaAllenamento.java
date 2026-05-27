package model;

import java.time.LocalDate;

public class SchedaAllenamento {
    private LocalDate dataCreazione;
    private String obiettivo;
    private String faseAlimentare; // Bulk, Cut, ecc...

    public SchedaAllenamento(LocalDate dataCreazione, String obiettivo, String faseAlimentare) {
        this.dataCreazione = dataCreazione;
        this.obiettivo = obiettivo;
        this.faseAlimentare = faseAlimentare;
    }

    // Getter e Setter
    public LocalDate getDataCreazione() { return dataCreazione; }
    public void setDataCreazione(LocalDate dataCreazione) { this.dataCreazione = dataCreazione; }
    public String getObiettivo() { return obiettivo; }
    public void setObiettivo(String obiettivo) { this.obiettivo = obiettivo; }
    public String getFaseAlimentare() { return faseAlimentare; }
    public void setFaseAlimentare(String faseAlimentare) { this.faseAlimentare = faseAlimentare; }
}