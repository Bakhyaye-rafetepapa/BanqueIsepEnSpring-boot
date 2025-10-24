package sn.isep.bancaireIsep.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.isep.bancaireIsep.entities.User;
import sn.isep.bancaireIsep.repositories.UserRepository;

import java.util.List;

@Service
public class AdminService {

    private final UserRepository userRepository;

    @Autowired
    public AdminService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Récupérer tous les utilisateurs
    public List<User> getTousLesUtilisateurs() {
        return userRepository.findAll();
    }

    // Supprimer un utilisateur par ID
    public void supprimerUtilisateur(Long id) {
        userRepository.deleteById(id);
    }

    public User createUser(String username, String password, String role) {
    User user = new User(username, password, role);
    return userRepository.save(user);
}

public User updateUser(Long id, String username, String password, String role) {
    User user = userRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
    user.setUsername(username);
    user.setPassword(password); // à chiffrer si nécessaire
    user.setRole(role);
    return userRepository.save(user);
}

public User getUserById(Long id) {
    return userRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
}

public void deleteUser(Long id) {
    userRepository.deleteById(id);
}

}