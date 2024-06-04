package Service;

import DAO.UtilisateurDAO;
import Models.Contacts;
import Models.Utilisateur;
import Utils.SessionManager;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurService {
    private final UtilisateurDAO utilisateurDAO = new UtilisateurDAO();

    public String connexion(String email, String motDePasse) {
        String uid = utilisateurDAO.connexion(email, motDePasse);
        if (!uid.equals("-1") && !uid.equals("-2") && !uid.equals("-3")) {
            SessionManager.createSession(uid);
            return uid;
        }
        return uid;
    }

    public void deconnecter() {
        SessionManager.destroySession();
    }

    public Utilisateur getUserInfo() {
        String uid = SessionManager.getSessionUserUid();
        if (uid != null) {
            return utilisateurDAO.getUtilisateurByUid(uid);
        }
        return null;
    }

    public List<Contacts> getUserContacts() {
        String uid = SessionManager.getSessionUserUid();
        if (uid != null) {
            return utilisateurDAO.getContactsByUtilisateur(uid);
        }
        return new ArrayList<>();
    }

    public void supprimerContact(int contactId) {
        utilisateurDAO.supprimerContact(contactId);
    }
}
