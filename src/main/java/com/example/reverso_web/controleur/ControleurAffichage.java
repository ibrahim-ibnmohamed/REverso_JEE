package com.example.reverso_web.controleur;

import com.example.reverso_web.model.dao.DaoClient;
import com.example.reverso_web.model.entite.Client;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

/**
 * Le contrôleur pour l'affichage des données dans l'application.
 */
@WebServlet(name = "affichageClient", value = "/affichageClient")

public class ControleurAffichage extends HttpServlet {

    /**
     * Initialise l'affichage avec le choix spécifié.
     *
     * @param choix le choix spécifié pour l'affichage.
     */
    public static void init(String choix) {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            List<Client> clients =DaoClient.findAll();
            request.setAttribute("clients", clients);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/affichage.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
