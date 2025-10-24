package sn.isep.bancaireIsep.DTOs;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CompteDTO {
        private Long id;
    private String numeroCompte;
    private BigDecimal solde;
    private Long clientId;
    private String clientNom;
    private String clientPrenom;
    private LocalDateTime dateCreation;
    private Boolean actif;
}

