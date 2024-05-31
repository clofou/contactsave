package com.bamappli.contactsave;

import DAO.UtilisateurDAO;
import Service.UtilisateurService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ConnexionServlet", value = "/connexionI")
public class ConnexionServlet extends HttpServlet {
    private UtilisateurService utilisateurService = new UtilisateurService();

    @Override
    public void init() throws ServletException {
        System.out.println("Bienvenue dans Connexion Servlet");
        super.init();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String action = req.getParameter("action");
        if ("login".equals(action)) {
            String email = req.getParameter("email");
            String motDePasse = req.getParameter("motDePasse");
            String uid = utilisateurService.connexion(req, email, motDePasse);
            if (!uid.equals("-1") && !uid.equals("-2") && !uid.equals("-3")) {
                resp.getWriter().write("Connexion réussie, UID : " + uid);
            } else {
                resp.getWriter().write("Échec de la connexion");
            }
        } else if ("logout".equals(action)) {
            utilisateurService.deconnexion(req);
            resp.getWriter().write("Déconnexion réussie");
        }
    }

}
