package br.com.dti;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class AppTest {

    @Test
    public void testeDescobrirOMelhorPetShopParaODiaDaSemana() {
        // Arranjo//
        Preco preco = new Preco(40, 20);
        Preco precoFinalDeSemana = new Preco(preco.getPrecoComAumento(preco.getGrandePorte(), 20),
                preco.getPrecoComAumento(preco.getPequenoPorte(), 20));
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

        String data = "03/08/2018";

        // Ação//
        App app = new App();
        Banho banho = app.descobrirOMelhorPetShopParaODiaDaSemana(petshops, data, 2, 2);

        // Asserção//
        assertEquals(petshop.getNome(), banho.getPetshop().getNome());
        assertEquals(120, banho.getTotal(), 0.0);
    }

    @Test
    public void testeDescobrirOMelhorPetShopParaODiaDaSemanaUtilConsiderandoADistanciaDoCanil() {
        // Arranjo//
        Preco preco = new Preco(40, 20);
        Preco precoFinalDeSemana = new Preco(preco.getPrecoComAumento(preco.getGrandePorte(), 20),
                preco.getPrecoComAumento(preco.getPequenoPorte(), 20));
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

        String data = "03/08/2018";

        // Ação//
        App app = new App();
        Banho banho = app.descobrirOMelhorPetShopParaODiaDaSemana(petshops, data, 1, 2);

        // Asserção//
        assertEquals(petshop2.getNome(), banho.getPetshop().getNome());
        assertEquals(80, banho.getTotal(), 0.0);
    }

    @Test

    public void testeDescobrirOMelhorPetShopParaOFinalDeSemanaConsiderandoADistanciaDoCanil() {
        // Arranjo//
        Preco preco = new Preco(40, 20);
        Preco precoFinalDeSemana = new Preco(preco.getPrecoComAumento(preco.getGrandePorte(), 20),
                preco.getPrecoComAumento(preco.getPequenoPorte(), 20));
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

        String data = "03/08/2018";

        // Ação//
        App app = new App();
        Banho banho = app.descobrirOMelhorPetShopParaODiaDaSemana(petshops, data, 1, 2);

        // Asserção//
        assertEquals(petshop2.getNome(), banho.getPetshop().getNome());
        assertEquals(80, banho.getTotal(), 0.0);

    }

    @Test (expected = DateTimeParseException.class) 
     public void testeSeADataInformadaForInvalida() {

        List<PetShop> petshops = new ArrayList<>();

        String data = "03-08-2018";

        // Ação//
        App app = new App();
        app.descobrirOMelhorPetShopParaODiaDaSemana(petshops, data, 1, 2);

    }

}
