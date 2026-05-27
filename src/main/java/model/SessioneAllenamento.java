package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SessioneAllenamento {
    private LocalDate dataEsecuzione;
    private int durataMinuti;
    private SchedaAllenamento schedaRiferimento;
    private List<RisultatoEsercizio> risultati;

    public SessioneAllenamento(LocalDate dataEsecuzione, int durataMinuti, SchedaAllenamento schedaRiferimento) {
        this.dataEsecuzione = dataEsecuzione;
        this.durataMinuti = durataMinuti;
        this.schedaRiferimento = schedaRiferimento;
        this.risultati = new ArrayList<>();
    }

    public void aggiungiRisultato(RisultatoEsercizio risultato) {
        this.risultati.add(risultato);
    }

    // Getter e Setter
    public LocalDate getDataEsecuzione() { return dataEsecuzione; }
    public void setDataEsecuzione(LocalDate dataEsecuzione) { this.dataEsecuzione = dataEsecuzione; }
    public int getDurataMinuti() { return durataMinuti; }
    public void setDurataMinuti(int durataMinuti) { this.durataMinuti = durataMinuti; }
    public SchedaAllenamento getSchedaRiferimento() { return schedaRiferimento; }
    public List<RisultatoEsercizio> getRisultati() { return risultati; }
}