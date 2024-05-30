package com.bamappli.contactsave;

import DAO.UtilisateurDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ConnexionServlet", value = "/connexion")
public class ConnexionServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("Bienvenue dans Connexion Servlet");
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Bienvenue dans Connexion Servlet");
        UtilisateurDAO a = new UtilisateurDAO();
        boolean b = a.inscription("fakoro88@gmail.com", "f23124568");
        System.out.println(b);

        req.getRequestDispatcher("index.jsp").forward(req, resp);

    }
}
