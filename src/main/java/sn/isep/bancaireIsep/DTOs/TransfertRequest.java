package sn.isep.bancaireIsep.DTOs;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class TransfertRequest {
    
    @NotBlank(message = "Compte source is required")
    private String compteSource;
    
    @NotBlank(message = "Compte destination is required")
    private String compteDestination;
    
    @NotNull(message = "Montant is required")
    @Positive(message = "Montant must be positive")
    private BigDecimal montant;
    
    // Constructeurs
    public TransfertRequest() {}
    
    public TransfertRequest(String compteSource, String compteDestination, BigDecimal montant) {
        this.compteSource = compteSource;
        this.compteDestination = compteDestination;
        this.montant = montant;
    }
    
    // Getters et Setters
    public String getCompteSource() {
        return compteSource;
    }
    
    public void setCompteSource(String compteSource) {
        this.compteSource = compteSource;
    }
    
    public String getCompteDestination() {
        return compteDestination;
    }
    
    public void setCompteDestination(String compteDestination) {
        this.compteDestination = compteDestination;
    }
    
    public BigDecimal getMontant() {
        return montant;
    }
    
    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }
}

