package br.com.dti;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

        String data = args[0];
        int quantidadeCaesPequenos = Integer.parseInt(args[1]);
        int quantidadeCaesGrandes = Integer.parseInt(args[2]);

        Preco preco = new Preco(40, 20);
        Preco precoFinalDeSemana = new Preco(preco.getPrecoComAumento(preco.getGrandePorte(), 20),
                preco.getPrecoComAumento(preco.getPequenoPorte(), 20));
        PetShop petshop = new PetShop("Meu Canino Feliz", preco, precoFinalDeSemana, 2);

        Preco preco2 = new Preco(50, 15);
        Preco precoFinalDeSemana2 = new Preco(55, 20);
        PetShop petshop2 = new PetShop("Vai Rex", preco2, precoFinalDeSemana2, 1.7);

        Preco preco3 = new Preco(45, 30);
        PetShop petshop3 = new PetShop("ChowChawgas", preco3, preco3, 0.8);

        List<PetShop> petshops = new ArrayList<>();
        petshops.add(petshop);
        petshops.add(petshop2);
        petshops.add(petshop3);

        App app = new App();
        Banho banho = app.descobrirOMelhorPetShopParaODiaDaSemana(petshops, data, quantidadeCaesGrandes,
                quantidadeCaesPequenos);
        System.out.println(banho);

    }

    public Banho descobrirOMelhorPetShopParaODiaDaSemana(List<PetShop> petshops, String data,
            int quantidadeGrandePorte,
            int quantidadePequenoPorte) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(data, formatter);

        Banho banho = null;
        double menorPreco = 0;

        for (PetShop petShop : petshops) {
            Preco preco = petShop.getPrecoDoDia(localDate);
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
