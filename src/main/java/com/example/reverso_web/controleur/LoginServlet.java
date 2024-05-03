package com.example.reverso_web.controleur;


import com.example.reverso_web.model.dao.DaoUser;
import com.example.reverso_web.model.entite.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;

import static javax.swing.JOptionPane.showConfirmDialog;

@WebServlet(name = "login", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    public static HttpSession session;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (session != null) {
            session=request.getSession();
            session.invalidate();
            session= null;
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("connexion.jsp");
        dispatcher.forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tokenCSRF = request.getParameter("csrfTokken");  // recuperer valeur input
        session = request.getSession(); //   recuperer le token de la session
        String csrf = (String) session.getAttribute("csrfToken");

        if (csrf != null && csrf.equals(tokenCSRF) ) {  // comparer les tokens
            String email = request.getParameter("email");
            String password = request.getParameter("password");



            try {
                User user = DaoUser.findByEmail(email);
                if (DaoUser.checkUser(email,password)) {
                    // Utilisateur authentifié, rediriger vers une page de succès
                    session = request.getSession();
                    session.setAttribute("user", user.getUsername());
                    session.setAttribute("email",user.getEmail());

                    if (request.getParameter("rememberMe") != null) {
                        session.setMaxInactiveInterval(-1);

                    }else {
                        session.setMaxInactiveInterval(30);
                    }



                    response.sendRedirect("index");
                } else {
                    // Mauvaises informations de connexion, rediriger vers une page d'erreur
                    response.sendRedirect(request.getContextPath() + "/login");
                }
        } catch (SQLException e) {
            throw new ServletException("Problème lors de la connexion à la base de données.", e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }else {
            JOptionPane.showMessageDialog(null,"probleme token");
            response.sendRedirect("index.jsp");
        }
    }


}

