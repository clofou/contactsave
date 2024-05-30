package Service;

import DAO.UtilisateurDAO;
import Models.Contacts;
import Models.Utilisateur;
import Utils.SessionManager;
import jakarta.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurService {
    private final UtilisateurDAO utilisateurDAO = new UtilisateurDAO();

    public String connexion(HttpServletRequest request, String email, String motDePasse) {
        String uid = utilisateurDAO.connexion(email, motDePasse);
        if (!uid.equals("-1") && !uid.equals("-2") && !uid.equals("-3")) {
            SessionManager.createSession(request, uid);
            return uid;
        }
        return uid;
    }

    public void deconnexion(HttpServletRequest request) {
        SessionManager.destroySession(request);
    }

    public Utilisateur getUserInfo(HttpServletRequest request) {
        String uid = SessionManager.getSessionUserUid(request);
        if (uid != null) {
            return utilisateurDAO.getUserByUid(uid);
        }
        return null;
    }

    public List<Contacts> getUserContacts(HttpServletRequest request) {
        String uid = SessionManager.getSessionUserUid(request);
        if (uid != null) {
            return utilisateurDAO.getContactsByUid(uid);
        }
        return new ArrayList<>();
    }
}
