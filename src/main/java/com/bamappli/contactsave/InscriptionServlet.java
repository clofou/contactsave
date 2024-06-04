package com.bamappli.contactsave;

import DAO.UtilisateurDAO;
import Service.UtilisateurService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Objects;

import static Utils.utils.isValidEmail;

@WebServlet(name = "InscriptionServlet", value = "/inscription-traitement")
public class InscriptionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String motDePasse = req.getParameter("motDePasse");
        String cMotDePasse = req.getParameter("cMotDePasse");
        String cgu = req.getParameter("terms");

        if (!Objects.equals(email, "") && !Objects.equals(motDePasse, "") && Objects.equals(cgu, "on")){
            if(isValidEmail(email)){
                if(!UtilisateurDAO.isEmailExist(email)){
                    if (motDePasse.length() >= 6){

                        if (motDePasse.equals(cMotDePasse)){
                            UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
                            UtilisateurService utilisateurService = new UtilisateurService();

                            utilisateurDAO.inscription(email, motDePasse);
                            ConnexionServlet.connect(req, resp, email, motDePasse, utilisateurService);
                        } else {
                            req.setAttribute("errorMessage", "Les Mots de passe ne concordent pas !!");
                            req.getRequestDispatcher("jsps/inscription.jsp").forward(req, resp);
                        }



                    } else {
                        req.setAttribute("errorMessage", "La longueur du mot de passe doit être supérieur à 6 Caractères !!");
                        req.getRequestDispatcher("jsps/inscription.jsp").forward(req, resp);
                    }
                } else {
                    req.setAttribute("errorMessage", "Un compte est déjà créer avec ce mail !!");
                    req.getRequestDispatcher("jsps/inscription.jsp").forward(req, resp);
                }

            } else {
                req.setAttribute("errorMessage", "Email Invalide !!");
                req.getRequestDispatcher("jsps/inscription.jsp").forward(req, resp);
            }


        } else {
            req.setAttribute("errorMessage", "Renseignez les champs !! Les conditions générales doivent être acceptées");
            req.getRequestDispatcher("jsps/inscription.jsp").forward(req, resp);
        }
    }
}
