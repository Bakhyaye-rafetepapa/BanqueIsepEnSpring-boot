package sn.isep.bancaireIsep.DTOs;

import jakarta.validation.constraints.NotBlank;

public class CompteRequest {

    @NotBlank(message = "Numero de compte is required")
    private String numeroCompte;
    
    // Constructeurs
    public CompteRequest() {}
    
    public CompteRequest(String numeroCompte) {
        this.numeroCompte = numeroCompte;
    }
    
    // Getters et Setters
    public String getNumeroCompte() {
        return numeroCompte;
    }
    
    public void setNumeroCompte(String numeroCompte) {
        this.numeroCompte = numeroCompte;
    }
    
    }

