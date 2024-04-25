package com.example.reverso_web.controleur;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CookieServlet", value = "/cookie-servlet")
public class CookieServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Créer un nouveau cookie
        Cookie cookie = new Cookie("username", "john_doe");

        // Définir la durée de vie du cookie (en secondes) - 24 heures dans cet exemple
        cookie.setMaxAge(24 * 60 * 60);

        // Ajouter le cookie à la réponse
        response.addCookie(cookie);

        // Répondre à la requête
        response.getWriter().println("Cookie créé avec succès !");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer les cookies envoyés par le client
        Cookie[] cookies = request.getCookies();

        // Vérifier si le cookie "username" existe
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    String username = cookie.getValue();
                    response.getWriter().println("Bienvenue, " + username + " !");
                    return;
                }
            }
        }

        // Si le cookie "username" n'existe pas, afficher un message d'erreur
        response.getWriter().println("Aucun cookie 'username' trouvé !");
    }
}