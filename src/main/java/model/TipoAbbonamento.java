package model;

public class TipoAbbonamento {
    private String nome;
    private double prezzo;
    private int durataGiorni;

    public TipoAbbonamento(String nome, double prezzo, int durataGiorni) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.durataGiorni = durataGiorni;
    }

    // Getter e Setter
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public double getPrezzo() { return prezzo; }
    public void setPrezzo(double prezzo) { this.prezzo = prezzo; }
    public int getDurataGiorni() { return durataGiorni; }
    public void setDurataGiorni(int durataGiorni) { this.durataGiorni = durataGiorni; }
}