# Gestion de Contacts des Apprenants

Une application de gestion de contacts qui permet aux utilisateurs de s'inscrire, de se connecter, de partager des contacts avec d'autres utilisateurs, et d'exporter les contacts en format vCard,
de visualiser la liste de ses contacts, chaque apprenants à plusieurs Attributs(Compétences) et une Competence favorite.

## Table des Matières

- [Description](#description)
- [Fonctionnalités](#fonctionnalités)
- [Installation](#installation)
- [Configuration de la Base de Données](#configuration-de-la-base-de-données)
- [Technologies Utilisées](#technologies-utilisées)

## Description

Cette application permet aux utilisateurs de gérer leurs contacts, de partager des contacts avec d'autres utilisateurs et d'exporter des contacts en format vCard. Les utilisateurs peuvent s'inscrire et se connecter à l'application pour accéder à leurs contacts.

## Fonctionnalités

- Inscription et connexion des utilisateurs
- Partage de contacts entre utilisateurs
- Exportation des contacts en format vCard
- Gestion des contacts avec informations détaillées (adresse, emails, compétences, numéros de téléphone)

## Installation
C'est mieux d'utiliser IntelliJ

### Prérequis

- Java 11 ou supérieur
- Maven
- MySQL

### Étapes

1. Clonez le dépôt :

   ```sh
   git clone https://github.com/clofou/contactsave.git
   cd contactsave

2. Configurez la base de données (voir sqlCodeToCreateDatabase.sql dans les dossiers du projet).
3. Installez les dépendances Maven :
   ```sh
   mvn clean install
   
5. Configurez les informations de connexion dans le fichier Connexion.java :
   
   ```sh
   private static final String URL = "jdbc:mysql://localhost:3306/contactsave";
   private static final String USER = "utilisateur";
   private static final String PASSWORD = "mot_de_passe";
   
### Technologies-utilisées
- Java
- JDBC
- MySQL
- Maven
