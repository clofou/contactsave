package DAO;

import Models.Contacts;

import java.io.FileWriter;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

public class UtilisateurDAO implements IUtilisateurDAO{
    private final Connection connection;

    public UtilisateurDAO() {
        this.connection = Connexion.getConnection();
    }

    @Override
    public boolean inscription(String email, String motDePasse) {
        try {
            String hashedPassword = Utils.utils.hashPassword(motDePasse);
            String uid = UUID.randomUUID().toString();

            String query = "INSERT INTO utilisateurs (uid, email, motDePasse) VALUES (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, uid);
            stmt.setString(2, email);
            stmt.setString(3, hashedPassword);

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public String connexion(String email, String motDePasse) {
        try {
            String query = "SELECT uid, motDePasse FROM utilisateurs WHERE email = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String storedHashedPassword = rs.getString("motDePasse");
                String uid = rs.getString("uid");

                if (Utils.utils.verifyPassword(motDePasse, storedHashedPassword)) {
                    return uid;
                } else {
                    return "-2";
                }
            } else {
                return "-1";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "-3";
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean partagerContact(ArrayList<Contacts> contacts, String uid) {
        try {
            for (Contacts contact : contacts) {
                if (contactExists(contact, uid)) {
                    updateContact(contact, uid);
                } else {
                    insertContact(contact, uid);
                }
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean enregistrerContact(ArrayList<Contacts> contacts) {
        try (FileWriter writer = new FileWriter("contacts.vcf")) {
            for (Contacts contact : contacts) {
                writer.write("BEGIN:VCARD\n");
                writer.write("VERSION:3.0\n");
                writer.write("FN:" + contact.getNomContact() + "\n");
                writer.write("ADR:" + contact.getAdresse() + "\n");
                writer.write("EMAIL;TYPE=HOME,INTERNET:" + contact.getEmailPersonnel() + "\n");
                writer.write("EMAIL;TYPE=WORK,INTERNET:" + contact.getEmailProfessionnel() + "\n");
                writer.write("END:VCARD\n");
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean contactExists(Contacts contact, String uid) throws SQLException {
        String query = "SELECT id FROM Contacts WHERE emailPersonnel = ? AND uidUtilisateur = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, contact.getEmailPersonnel());
        stmt.setString(2, uid);
        ResultSet rs = stmt.executeQuery();
        return rs.next();
    }

    private void updateContact(Contacts contact, String uid) throws SQLException {
        String query = "UPDATE Contacts SET nomContact = ?, adresse = ?, emailProfessionnel = ?, competenceFavorite = ? WHERE emailPersonnel = ? AND uidUtilisateur = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, contact.getNomContact());
        stmt.setString(2, contact.getAdresse());
        stmt.setString(3, contact.getEmailProfessionnel());
        stmt.setString(4, contact.getCompetenceFavorite());
        stmt.setString(5, contact.getEmailPersonnel());
        stmt.setString(6, uid);
        stmt.executeUpdate();
    }

    private void insertContact(Contacts contact, String uid) throws SQLException {
        String query = "INSERT INTO Contacts (nomContact, adresse, emailPersonnel, emailProfessionnel, competenceFavorite, uidUtilisateur) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, contact.getNomContact());
        stmt.setString(2, contact.getAdresse());
        stmt.setString(3, contact.getEmailPersonnel());
        stmt.setString(4, contact.getEmailProfessionnel());
        stmt.setString(5, contact.getCompetenceFavorite());
        stmt.setString(6, uid);
        stmt.executeUpdate();
    }

}
