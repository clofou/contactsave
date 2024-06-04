package com.bamappli.contactsave;

import Service.UtilisateurService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class SupprimerContactServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final UtilisateurService utilisateurService;

    public SupprimerContactServlet() {
        super();
        this.utilisateurService = new UtilisateurService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        String contactId = request.getParameter("contactId");
        if (contactId != null) {
            utilisateurService.supprimerContact(Integer.parseInt(contactId));
        }
        response.sendRedirect("accueil1.jsp");
    }
}
