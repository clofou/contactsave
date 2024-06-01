package com.bamappli.contactsave;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "InscriptionServlet", value = "/inscription-traitement")
public class InscriptionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String motDePasse = req.getParameter("motDePasse");
        String cMotDePasse = req.getParameter("cMotDePasse");
        String cgu = req.getParameter("terms");

        if (!Objects.equals(email, "") && !Objects.equals(motDePasse, "") && Objects.equals(cgu, "on")){

        } else {
            req.setAttribute("errorMessage", "Renseignez les champs !! Les conditions générales doivent être acceptées");
            req.getRequestDispatcher("jsps/inscription.jsp").forward(req, resp);
        }
        req.setAttribute("email", email);
        req.setAttribute("motDePasse", motDePasse);
        System.out.println(cgu);
        req.getRequestDispatcher("jsps/test.jsp").forward(req, resp);
    }
}
