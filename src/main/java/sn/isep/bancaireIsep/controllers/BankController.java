package sn.isep.bancaireIsep.controllers;

import sn.isep.bancaireIsep.DTOs.ClientDTO;
import sn.isep.bancaireIsep.DTOs.CompteDTO;
import sn.isep.bancaireIsep.DTOs.CreateCompteRequest;
import sn.isep.bancaireIsep.DTOs.SoldeResponse;
import sn.isep.bancaireIsep.DTOs.TransfertRequest;
import sn.isep.bancaireIsep.entities.*;
import sn.isep.bancaireIsep.service.BankService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
public class BankController {
    
    private final BankService bankService = null;
    
    @GetMapping("/clients")
    public ResponseEntity<List<ClientDTO>> getAllClients() {
        List<ClientDTO> clients = bankService.getAllClients();
        return ResponseEntity.ok(clients);
    }
    
    @GetMapping("/solde")
    public ResponseEntity<SoldeResponse> getSolde(
            @RequestParam String numeroCompte) {
        SoldeResponse solde = bankService.getSolde(numeroCompte);
        return ResponseEntity.ok(solde);
    }
    
    @PostMapping("/create")
    public ResponseEntity<CompteDTO> createCompte(
            @Valid @RequestBody CreateCompteRequest request) {
        CompteDTO compte = bankService.createCompte(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(compte);
    }
    
    @PostMapping("/transfert")
    public ResponseEntity<String> transfert(
            @Valid @RequestBody TransfertRequest request) {
        bankService.transfert(request);
        return ResponseEntity.ok("Transfert effectué avec succès");
    }
}