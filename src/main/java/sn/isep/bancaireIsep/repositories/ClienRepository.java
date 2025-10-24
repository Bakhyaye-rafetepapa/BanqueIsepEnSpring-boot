package sn.isep.bancaireIsep.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.qos.logback.core.net.server.Client;

public interface ClienRepository extends JpaRepository<Client, Long> {
    
}
