package sn.isep.bancaireIsep.controllers;

import java.math.BigDecimal;
import java.util.List;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import sn.isep.bancaireIsep.DTOs.CompteRequest;
import sn.isep.bancaireIsep.DTOs.TransfertRequest;
import sn.isep.bancaireIsep.entities.Compte;
import sn.isep.bancaireIsep.service.CompteService;


    
    

@RestController
@RequestMapping("/api/client")
@CrossOrigin(origins = "*")
public class ClientController {
    
    @Autowired
    private CompteService compteService;
    
    // Créer un compte bancaire
    @PostMapping("/compte")
    public ResponseEntity<?> createCompte(@Valid @RequestBody CompteRequest request, Authentication authentication) {
        try {
            String username = authentication.name();
            Compte compte = compteService.creerCompte(request.getNumeroCompte(), username);
            return ResponseEntity.ok(compte);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    // Afficher le solde d'un compte
    @GetMapping("/solde/{numeroCompte}")
    public ResponseEntity<?> getSolde(@PathVariable String numeroCompte, 
                                      Authentication authentication) {
        try {
            String username = authentication.name();
            BigDecimal solde = compteService.getSolde(numeroCompte, username);
            return ResponseEntity.ok(solde);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    // Afficher tous les comptes de l'utilisateur connecté
    @GetMapping("/comptes")
    public ResponseEntity<?> getMesComptes(Authentication authentication) {
        try {
            String username = authentication.name();
            List<Compte> comptes = compteService.getComptesByUsername(username);
            return ResponseEntity.ok(comptes);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    // Effectuer un transfert
    @PostMapping("/transfert")
    public ResponseEntity<?> transfert(@Valid @RequestBody TransfertRequest request, 
                                       Authentication authentication) {
        try {
            String username = authentication.name();
            compteService.transfert(
                request.getCompteSource(), 
                request.getCompteDestination(), 
                request.getMontant(), 
                username
            );
            return ResponseEntity.ok("Transfert effectué avec succès");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}


