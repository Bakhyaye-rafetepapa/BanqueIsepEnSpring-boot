package sn.isep.bancaireIsep.DTOs;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;


    

public class CreateCompteRequest {
    
    @NotNull(message = "L'ID du client est requis")
    private Long clientId;
    
    @NotNull(message = "Le solde initial est requis")
    @Positive(message = "Le solde initial doit être positif")
    private BigDecimal soldeInitial;

    public Object getClientId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getClientId'");
    }

   
}

