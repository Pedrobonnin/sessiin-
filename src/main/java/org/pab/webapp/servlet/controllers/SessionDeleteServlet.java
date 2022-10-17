package org.pab.webapp.servlet.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;



@WebServlet({"/logout"})

public class SessionDeleteServlet extends HttpServlet{


    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession(); //Obtenemos la sesión

        session.invalidate(); //mata la sesion
        resp.sendRedirect(req.getContextPath() + "/login.html"); //redirige al Login
    }
}
