package Utils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class SessionManager {
    private static final int SESSION_TIMEOUT = 30 * 60; // Timeout en secondes (30 minutes)

    public static void createSession(HttpServletRequest request, String uid) {
        HttpSession session = request.getSession(true); // Crée une nouvelle session si elle n'existe pas
        session.setMaxInactiveInterval(SESSION_TIMEOUT); // Définit le timeout de la session
        session.setAttribute("userUid", uid);
    }

    public static void destroySession(HttpServletRequest request) {
        HttpSession session = request.getSession(false); // Récupère la session existante, ne crée pas une nouvelle
        if (session != null) {
            session.invalidate();
        }
    }

    public static String getSessionUserUid(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            return (String) session.getAttribute("userUid");
        }
        return null;
    }
}
