package model;

import java.time.LocalDate;

public class Abbonamento {
    private LocalDate dataInizio;
    private LocalDate dataFine;
    private TipoAbbonamento tipo;

    public Abbonamento(LocalDate dataInizio, LocalDate dataFine, TipoAbbonamento tipo) {
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.tipo = tipo;
    }

    public boolean isValido() {
        LocalDate oggi = LocalDate.now();
        return (!oggi.isBefore(dataInizio) && !oggi.isAfter(dataFine));
    }

    // Getter e Setter
    public LocalDate getDataInizio() { return dataInizio; }
    public void setDataInizio(LocalDate dataInizio) { this.dataInizio = dataInizio; }
    public LocalDate getDataFine() { return dataFine; }
    public void setDataFine(LocalDate dataFine) { this.dataFine = dataFine; }
    public TipoAbbonamento getTipo() { return tipo; }
    public void setTipo(TipoAbbonamento tipo) { this.tipo = tipo; }
}