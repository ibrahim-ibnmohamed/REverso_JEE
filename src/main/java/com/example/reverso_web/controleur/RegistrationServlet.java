package com.example.reverso_web.controleur;

import com.example.reverso_web.model.dao.DaoConnection;
import com.example.reverso_web.model.dao.DaoUser;
import com.example.reverso_web.model.entite.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

@WebServlet(name = "register", urlPatterns = {"/register"})
public class RegistrationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String confirmPassword = request.getParameter("confirmPassword");
            if (username != null && email != null && password != null && password.equals(confirmPassword)) {
                // Créer un nouvel utilisateur avec les informations fournies
                User newUser = new User(username, email, password);
                DaoUser.addUser(newUser);

                // Rediriger vers une page de succès après l'inscription
                response.sendRedirect(request.getContextPath() + "/index");


            }else {
                response.sendRedirect(request.getContextPath() + "/login");
            }




        } catch (Exception e) {
            throw new ServletException("Problème lors de la connexion à la base de données.", e);
        }
    }
}
