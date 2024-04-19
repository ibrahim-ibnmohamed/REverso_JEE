package com.example.reverso_web.controleur;

import com.example.reverso_web.model.dao.DaoConnection;
import com.example.reverso_web.model.dao.DaoUser;
import com.example.reverso_web.model.entite.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "login", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession() != null) {
            request.getSession().invalidate();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("connexion.jsp");
        dispatcher.forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {User user = DaoUser.findByEmail(email);

            if (user != null && user.getPassword().equals(password)) {
                // Utilisateur authentifié, rediriger vers une page de succès
                HttpSession session = request.getSession();
                session.setAttribute("user", user.getUsername());
                session.setAttribute("email",user.getEmail());

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
    }
}

