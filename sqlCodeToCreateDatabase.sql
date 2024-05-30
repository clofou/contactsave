CREATE TABLE utilisateurs (
    uid VARCHAR(255) PRIMARY KEY,
    prenom VARCHAR(255) NULL,
    nom VARCHAR(255) NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    motDePasse VARCHAR(255) NOT NULL
);
CREATE TABLE Attribut(
	id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(45)
);
CREATE TABLE Contacts(
	id INT AUTO_INCREMENT PRIMARY KEY,
    nomContact VARCHAR(25) NULL,
    adresse VARCHAR(100) NULL,
    emailPersonnel VARCHAR(45) NULL,
    emailProfessionnel VARCHAR(45) NULL,
    competenceFavorite VARCHAR(65) NULL,
    uidUtilisateur VARCHAR(255),
    FOREIGN KEY (uidUtilisateur) REFERENCES utilisateurs(uid)
);
CREATE TABLE AttributContacts(
	id INT AUTO_INCREMENT PRIMARY KEY,
    idContact int,
    idAttribut int,
    FOREIGN KEY (idAttribut) REFERENCES Attribut(id),
    FOREIGN KEY (idContact) REFERENCES Contacts(id)
);
CREATE TABLE NumeroDeTelephone(
	id INT AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR(25) NULL,
    numero VARCHAR(100) NULL,
    idContact int,
    FOREIGN KEY (idContact) REFERENCES Contacts(id)
);
