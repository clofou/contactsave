package com.bamappli.contactsave;

import DAO.UtilisateurDAO;
import Service.UtilisateurService;
import Utils.SessionManager;
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String email = req.getParameter("email");
        String motDePasse = req.getParameter("motDePasse");
        String uid = utilisateurService.connexion(email, motDePasse);

        if (!uid.equals("-1") && !uid.equals("-2") && !uid.equals("-3")) {
            UtilisateurService utilisateurService = new UtilisateurService();
            connect(req, resp, email, motDePasse, utilisateurService);
        } else {
            req.setAttribute("errorMessage", "Email ou Mot de passe Incorrect !!");
            req.getRequestDispatcher("jsps/connexion.jsp").forward(req, resp);
        }

    }

    static void connect(HttpServletRequest req, HttpServletResponse resp, String email, String motDePasse, UtilisateurService utilisateurService) throws ServletException, IOException {
        utilisateurService.connexion(email, motDePasse);


        req.getRequestDispatcher("jsps/acceuil1.jsp").forward(req, resp);
    }

}
