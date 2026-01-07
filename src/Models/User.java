package Models;

import java.util.ArrayList;

/**
 * Classe représentant un utilisateur authentifié
 * @author Matthieu Couderc
 * @version 2.0
 */
public class User {
    private int id;
    private String name;
    private String email;
    private String password;

    public static ArrayList<User> usersList = new ArrayList<>();

    /**
     * Constructeur complet pour un utilisateur
     * @param id: identifiant unique
     * @param name: nom complet de l'utilisateur
     * @param email: email de l'utilisateur
     * @param password: mot de passe (stocké hashé en production)
     */
    public User(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        usersList.add(this);
    }

    /**
     * Constructeur pour création d'utilisateur (sans id)
     */
    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    /**
     * Méthode d'authentification
     * @param email: email de connexion
     * @param password: mot de passe
     * @return User si authentification réussie, null sinon
     */
    public static User authenticate(String email, String password) {
        for (User user : usersList) {
            if (user.email.equals(email) && user.password.equals(password)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Méthode d'inscription
     * @param name: nom complet
     * @param email: email
     * @param password: mot de passe
     * @return Nouveau User créé
     */
    public static User register(String name, String email, String password) {
        User newUser = new User(name, email, password);
        usersList.add(newUser);
        return newUser;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    /* GETTERS AND SETTERS */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}