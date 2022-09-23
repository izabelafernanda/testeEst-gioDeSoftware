package br.com.dti;

public class Banho {
    private PetShop petshop;
    private double total;

    public Banho(PetShop petshop, double total) {
        this.petshop = petshop;
        this.total = total;
    }

    public PetShop getPetshop() {
        return petshop;
    }

    public void setPetshop(PetShop petshop) {
        this.petshop = petshop;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return getPetshop().getNome() + " " + getTotal();
    }

}
