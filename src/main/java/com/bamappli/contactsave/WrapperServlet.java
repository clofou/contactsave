package com.bamappli.contactsave;

import Utils.SessionManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "WrapperServlet", value = "/connexion-inscription")
public class WrapperServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uid = SessionManager.getSessionUserUid(req);
        if (uid != null){
            req.getRequestDispatcher("jsps/acceuil1.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("jsps/acceuil1.jsp").forward(req, resp);
        }
    }
}
