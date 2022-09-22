package br.com.dti;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public Banho descobrirOMelhorPetShopParaODiaDaSemana(List<PetShop> petshops, String dia, int quantidadeGrandePorte,
            int quantidadePequenoPorte) {

        Banho banho = null;
        double menorPreco = 0;

        for (PetShop petShop : petshops) {
            Preco preco = petShop.getPrecoDoDia(dia);
            double totalGrandePorte = preco.getGrandePorte() * quantidadeGrandePorte;
            double totalPequenoPorte = preco.getPequenoPorte() * quantidadePequenoPorte;
            double total = totalGrandePorte + totalPequenoPorte;
            if (menorPreco > total || menorPreco == 0) {
                menorPreco = total;
                banho = new Banho(petShop, total);
            }

            if (total == menorPreco && banho.getPetshop().getDistancia() > petShop.getDistancia()) {
                banho = new Banho(petShop, total);
            }
        }

        return banho;
    }
}
