package sn.isep.bancaireIsep.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sn.isep.bancaireIsep.entities.User;
import sn.isep.bancaireIsep.repositories.UserRepository;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Inscription
    public User inscrire(User user) {
        // Vérifie si le nom d'utilisateur est déjà pris
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new RuntimeException("Nom d'utilisateur déjà utilisé !");
        }

        // Chiffrement du mot de passe avant l’enregistrement
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    // Connexion
    public User connecter(String username, String motDePasse) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
        if (!passwordEncoder.matches(motDePasse, user.getPassword())) {
            throw new RuntimeException("Mot de passe incorrect");
        }

        return user;
    }
}
