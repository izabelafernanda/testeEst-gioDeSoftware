package br.com.dti;

public class PetShop {
    private String nome;  
    private Preco preco;
    private Preco precoFinalDeSemana;
    private double distancia; 

    public PetShop(String nome, Preco preco, Preco precoFinalDeSemana, double distancia) {
        this.nome = nome;
        this.preco = preco;
        this.precoFinalDeSemana = precoFinalDeSemana;
        this.distancia = distancia;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Preco getPreco() {
        return preco;
    }

    public void setPreco(Preco preco) {
        this.preco = preco;
    }

    public Preco getPrecoFinalDeSemana() {
        return precoFinalDeSemana;
    }

    public void setPrecoFinalDeSemana(Preco precoFinalDeSemana) {
        this.precoFinalDeSemana = precoFinalDeSemana;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public Preco getPrecoDoDia(String dia) {
        if (dia.equals("util")) {
            return preco; 
        }else {
            return precoFinalDeSemana;
        }
    }
}
