package sn.isep.bancaireIsep.entities;


import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import ch.qos.logback.core.net.server.Client;

@Entity
@Table(name = "comptes")
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true, nullable = false)
    private String numeroCompte;
    
    @Column(nullable = false)
    private BigDecimal solde;
    
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    private LocalDateTime createdAt;
    
    // Constructeurs
    public Compte() {
        this.solde = BigDecimal.ZERO;
        this.createdAt = LocalDateTime.now();
    }
    
    public Compte(String numeroCompte, User user) {
        this.numeroCompte = numeroCompte;
        this.user = user;
        this.solde = BigDecimal.ZERO;
        this.createdAt = LocalDateTime.now();
    }
    
    // Getters et Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNumeroCompte() {
        return numeroCompte;
    }
    
    public void setNumeroCompte(String numeroCompte) {
        this.numeroCompte = numeroCompte;
    }
    
    public BigDecimal getSolde() {
        return solde;
    }
    
    public void setSolde(BigDecimal solde) {
        this.solde = solde;
    }
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setClient(Client client) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setClient'");
    }

    public void setActif(boolean b) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setActif'");
    }
}

    
