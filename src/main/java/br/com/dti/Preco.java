package br.com.dti;

public class Preco {
    private double grandePorte;
    private double pequenoPorte;

    public Preco(double grandePorte, double pequenoPorte) {
        this.grandePorte = grandePorte;
        this.pequenoPorte = pequenoPorte;
    }

    public double getGrandePorte() {
        return grandePorte;
    }

    public void setGrandePorte(double grandePorte) {
        this.grandePorte = grandePorte;
    }

    public double getPequenoPorte() {
        return pequenoPorte;
    }

    public void setPequenoPorte(double pequenoPorte) {
        this.pequenoPorte = pequenoPorte;
    }

    public double getPrecoComAumento(double preco, int aumento) {
        return preco * 100 / aumento;
    }

}
