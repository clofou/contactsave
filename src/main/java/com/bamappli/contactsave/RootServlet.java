package com.bamappli.contactsave;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "RootServlet", urlPatterns = {"/inscription", "/connexion"})
public class RootServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getServletPath().equals("/inscription")){
            req.getRequestDispatcher("jsps/inscription.jsp").forward(req, resp);
        }
        if (req.getServletPath().equals("/connexion")){
            req.getRequestDispatcher("jsps/connexion.jsp").forward(req, resp);
        }

    }
}
