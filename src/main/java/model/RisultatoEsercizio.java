package model;

public class RisultatoEsercizio {
    private double caricoEffettivo;
    private int serieEffettive;
    private int ripetizioniEffettive;
    private Esercizio esercizioRiferimento;

    public RisultatoEsercizio(double caricoEffettivo, int serieEffettive, int ripetizioniEffettive, Esercizio esercizioRiferimento) {
        this.caricoEffettivo = caricoEffettivo;
        this.serieEffettive = serieEffettive;
        this.ripetizioniEffettive = ripetizioniEffettive;
        this.esercizioRiferimento = esercizioRiferimento;
    }

    // Getter e Setter
    public double getCaricoEffettivo() { return caricoEffettivo; }
    public void setCaricoEffettivo(double caricoEffettivo) { this.caricoEffettivo = caricoEffettivo; }
    public int getSerieEffettive() { return serieEffettive; }
    public void setSerieEffettive(int serieEffettive) { this.serieEffettive = serieEffettive; }
    public int getRipetizioniEffettive() { return ripetizioniEffettive; }
    public void setRipetizioniEffettive(int ripetizioniEffettive) { this.ripetizioniEffettive = ripetizioniEffettive; }
    public Esercizio getEsercizioRiferimento() { return esercizioRiferimento; }
}