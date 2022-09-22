package br.com.dti;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class AppTest {

    @Test
    public void testeDescobrirOMelhorPetShopParaODiaDaSemana() {
        // Arranjo//
        Preco preco = new Preco(40, 20);
        Preco precoFinalDeSemana = new Preco(preco.getPrecoComDesconto(preco.getGrandePorte(), 20),
                preco.getPrecoComDesconto(preco.getPequenoPorte(), 20));
        PetShop petshop = new PetShop("meuCaninoFeliz", preco, precoFinalDeSemana, 2);

        Preco preco2 = new Preco(50, 15);
        Preco precoFinalDeSemana2 = new Preco(55, 20);
        PetShop petshop2 = new PetShop("vaiRex", preco2, precoFinalDeSemana2, 1.7);

        Preco preco3 = new Preco(45, 30);
        PetShop petshop3 = new PetShop("ChowChawgas", preco3, preco3, 0.8);

        List<PetShop> petshops = new ArrayList<>();
        petshops.add(petshop);
        petshops.add(petshop2);
        petshops.add(petshop3);

        // Ação//
        App app = new App();
        Banho banho = app.descobrirOMelhorPetShopParaODiaDaSemana(petshops, "util", 2, 2);

        // Asserção//
        assertEquals(petshop.getNome(), banho.getPetshop().getNome());
        assertEquals(120, banho.getTotal(), 0.0);
    }

    @Test

    public void testeDescobrirOMelhorPetShopParaODiaDaSemanaConsiderandoADistanciaDoCanil() {
        // Arranjo//
        Preco preco = new Preco(40, 20);
        Preco precoFinalDeSemana = new Preco(preco.getPrecoComDesconto(preco.getGrandePorte(), 20),
                preco.getPrecoComDesconto(preco.getPequenoPorte(), 20));
        PetShop petshop = new PetShop("meuCaninoFeliz", preco, precoFinalDeSemana, 2);

        Preco preco2 = new Preco(50, 15);
        Preco precoFinalDeSemana2 = new Preco(55, 20);
        PetShop petshop2 = new PetShop("vaiRex", preco2, precoFinalDeSemana2, 1.7);

        Preco preco3 = new Preco(45, 30);
        PetShop petshop3 = new PetShop("ChowChawgas", preco3, preco3, 0.8);

        List<PetShop> petshops = new ArrayList<>();
        petshops.add(petshop);
        petshops.add(petshop2);
        petshops.add(petshop3);

        // Ação//
        App app = new App();
        Banho banho = app.descobrirOMelhorPetShopParaODiaDaSemana(petshops, "util", 1, 2);

        // Asserção//
        assertEquals(petshop2.getNome(), banho.getPetshop().getNome());
        assertEquals(80, banho.getTotal(), 0.0);
    }


}
