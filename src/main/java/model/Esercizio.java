package model;

public class Esercizio {
    private String nome;
    private String gruppoMuscolare;

    public Esercizio(String nome, String gruppoMuscolare) {
        this.nome = nome;
        this.gruppoMuscolare = gruppoMuscolare;
    }

    // Getter e Setter
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getGruppoMuscolare() { return gruppoMuscolare; }
    public void setGruppoMuscolare(String gruppoMuscolare) { this.gruppoMuscolare = gruppoMuscolare; }
}