package sn.isep.bancaireIsep.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import sn.isep.bancaireIsep.DTOs.UpdateUserRequest;
import sn.isep.bancaireIsep.entities.User;
import sn.isep.bancaireIsep.entities.Compte;
import sn.isep.bancaireIsep.service.AdminService;
import sn.isep.bancaireIsep.service.CompteService;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*")
public class AdmineController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private CompteService compteService;

    // Lister tous les utilisateurs
    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers() {
        try {
            List<User> users = adminService.getTousLesUtilisateurs();
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Obtenir un utilisateur par ID
    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        try {
            User user = adminService.getUserById(id);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

   

    // Modifier un utilisateur
    @PutMapping("/users/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id,
                                        @RequestBody UpdateUserRequest request) {
        try {
            User user = adminService.updateUser(
                id,
                request.getUsername(),
                request.getPassword(),
                request.getRole()
            );
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Supprimer un utilisateur
    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        try {
            adminService.deleteUser(id);
            return ResponseEntity.ok("User deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Lister tous les comptes
    @GetMapping("/comptes")
    public ResponseEntity<?> getAllComptes() {
        try {
            List<Compte> comptes = compteService.getAllComptes();
            return ResponseEntity.ok(comptes);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
