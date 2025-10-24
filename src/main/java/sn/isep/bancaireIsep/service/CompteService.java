package sn.isep.bancaireIsep.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.isep.bancaireIsep.entities.Compte;
import sn.isep.bancaireIsep.entities.User;
import sn.isep.bancaireIsep.repositories.CompteRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CompteService {

    private final CompteRepository compteRepository;

    // Injection via constructeur
    @Autowired
    public CompteService(CompteRepository compteRepository) {
        this.compteRepository = compteRepository;
    }

    //  Créer un compte
    public Compte creerCompte(String user, String numeroCompte) {
        Compte compte = new Compte();
        return compteRepository.save(compte);
    }

    //  Récupérer les comptes d’un utilisateur
    public List<Compte> getComptesParUser(User user) {
    return compteRepository.findByUser((org.apache.catalina.User) user);
}



    // Effectuer un transfert
    public void transferer(String sourceNumero, String destinationNumero, BigDecimal montant) {
        Compte source = compteRepository.findByNumeroCompte(sourceNumero)
                .orElseThrow(() -> new RuntimeException("Compte source introuvable"));
        Compte destination = compteRepository.findByNumeroCompte(destinationNumero)
                .orElseThrow(() -> new RuntimeException("Compte destination introuvable"));

        if (source.getSolde().compareTo(montant) < 0) {
            throw new RuntimeException("Solde insuffisant");
        }

        source.setSolde(source.getSolde().subtract(montant));
        destination.setSolde(destination.getSolde().add(montant));

        compteRepository.save(source);
        compteRepository.save(destination);
    }

    public List<Compte> getAllComptes() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllComptes'");
    }

    public void transfert(String compteSource, String compteDestination, BigDecimal montant, String username) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'transfert'");
    }

    public List<Compte> getComptesByUsername(String username) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getComptesByUsername'");
    }

    public BigDecimal getSolde(String numeroCompte, String username) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSolde'");
    }
}
