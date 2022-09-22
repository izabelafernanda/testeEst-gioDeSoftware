package br.com.dti;

public class PetShop {
    private String nome;  
    private Preco preco;
    private Preco precoFinalDeSemana;

    public PetShop(String nome, Preco preco, Preco precoFinalDeSemana) {
        this.nome = nome;
        this.preco = preco;
        this.precoFinalDeSemana = precoFinalDeSemana;
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

    public Preco getPrecoDoDia(String dia) {
        if (dia.equals("util")) {
            return preco; 
        }else {
            return precoFinalDeSemana;
        }
    }
}
