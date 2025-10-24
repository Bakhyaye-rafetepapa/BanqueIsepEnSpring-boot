package sn.isep.bancaireIsep.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.validation.Valid;
import sn.isep.bancaireIsep.DTOs.ClientDTO;
import sn.isep.bancaireIsep.DTOs.CompteDTO;
import sn.isep.bancaireIsep.DTOs.CreateCompteRequest;
import sn.isep.bancaireIsep.DTOs.SoldeResponse;
import sn.isep.bancaireIsep.DTOs.TransfertRequest;
import sn.isep.bancaireIsep.entities.Client;
import sn.isep.bancaireIsep.entities.Compte;
import sn.isep.bancaireIsep.repositories.CompteRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class BankService {

    private final ClientRepository clientRepository;
    private final CompteRepository compteRepository;

    public BankService(ClientRepository clientRepository, CompteRepository compteRepository) {
        this.clientRepository = clientRepository;
        this.compteRepository = compteRepository;
    }

    // Récupérer tous les clients
    public List<ClientDTO> getAllClients() {
        return clientRepository.findAll().stream()
                .map(client -> new ClientDTO())
                .collect(Collectors.toList());
    }

   
  

   
    // Transfert entre 2 comptes
    public void transfert(TransfertRequest request) {
        Compte source = compteRepository.findByNumeroCompte(request.getCompteSource())
                .orElseThrow();

        Compte destination = compteRepository.findByNumeroCompte(request.getCompteDestination())
                .orElseThrow();

       

        source.setSolde(source.getSolde().subtract(request.getMontant()));
        destination.setSolde(destination.getSolde().add(request.getMontant()));

        compteRepository.save(source);
        compteRepository.save(destination);
    }

    // Générer un numéro de compte unique
    private String generateNumeroCompte() {
        return "CPT-" + UUID.randomUUID().toString().substring(0, 10).toUpperCase();
    
}

    public SoldeResponse getSolde(String numeroCompte) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSolde'");
    }

    public CompteDTO createCompte(CreateCompteRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createCompte'");
    }
}
