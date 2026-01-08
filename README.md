# Application de Vente de Formations - Buy My Course!

## Description

Application Java de gestion et vente de formations en ligne et en présentiel. Ce projet est une évaluation qui implémente les fonctionnalités de base pour un système de vente de formations.

## État actuel du projet

### Fonctionnalités implémentées (Première partie) ✅

- **Affichage des formations** : 
  - Afficher toutes les formations disponibles
  - Recherche par type (Présentiel/Distanciel)
  - Recherche par mot clé

- **Modélisation des données** :
  - `Course` : Formation avec nom, description, durée, type, prix
  - `User` : Utilisateur avec authentification basique
  - `Customer` : Client pour les commandes
  - `Order` : Commande avec statut et montant
  - `Cart` : Panier d'achat

- **Architecture technique** :
  - Structure MVC (Models, Services, DAO, App)
  - Connexion à base de données MariaDB
  - DAO pour les opérations CRUD sur les formations
  - Interface console avec menu interactif

### Fonctionnalités modélisées mais non implémentées (Deuxième partie) 📝

Les modèles suivants existent mais ne sont pas encore intégrés dans l'interface utilisateur :

- **Gestion du panier** : 
  - Ajout/retrait de formations dans le panier
  - Calcul du montant total

- **Système de commande** :
  - Passage de commande avec gestion des clients
  - Association commande-utilisateur-client

- **Authentification** :
  - Connexion/déconnexion des utilisateurs
  - Création de compte utilisateur
  - Redirection vers création de compte si non connecté

## Structure du projet

```
src/
├── App/              # Logique applicative
│   └── CourseApp.java # Interface utilisateur console
├── DAO/              # Accès aux données
│   ├── CourseDAO.java # Opérations CRUD pour les formations
│   └── DAO.java       # Interface générique DAO
├── Enums/            # Types énumérés
│   └── CourseType.java
├── Exceptions/       # Gestion des exceptions
│   └── UnknownCourseException.java
├── JDBC/             # Connexion base de données
│   └── MariaDbConnection.java
├── Models/           # Modèles de données
│   ├── Cart.java
│   ├── Course.java
│   ├── Customer.java
│   ├── Order.java
│   └── User.java
├── Services/         # Logique métier
│   └── CourseService.java
└── Main.java         # Point d'entrée
```

## Prérequis

- Java 8 ou supérieur
- MariaDB ou MySQL
- Connexion à une base de données configurée

## Configuration de la base de données

Le projet utilise une base de données MariaDB. Voir le fichier `uml_db/full-script.sql` pour le script de création des tables et données de test.

## Utilisation

1. **Lancer l'application** :
   ```bash
   javac src/Main.java
   java src/Main
   ```

2. **Menu principal** :
   - Option 1 : Afficher toutes les formations
   - Option 2 : Rechercher par type (Présentiel/Distanciel)
   - Option 3 : Rechercher par mot clé
   - Option 4 : Quitter

## Auteur

Matthieu Couderc

## Statut du projet

✅ Première partie : Fonctionnalités de base implémentées
📝 Deuxième partie : Modèles créés, implémentation en cours

## Prochaines étapes

- Implémenter la gestion complète du panier
- Ajouter le système d'authentification
- Intégrer le processus de commande
- Connecter tous les modèles à la base de données
- Ajouter des tests unitaires
