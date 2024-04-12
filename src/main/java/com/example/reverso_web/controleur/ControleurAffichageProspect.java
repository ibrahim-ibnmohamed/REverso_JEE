package com.example.reverso_web.controleur;


import com.example.reverso_web.model.dao.DaoProspect;

import com.example.reverso_web.model.entite.Prospect;
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
@WebServlet(name = "affichageProspect", value = "/affichageProspect")

public class ControleurAffichageProspect extends HttpServlet {

    /**
     * Initialise l'affichage avec le choix spécifié.
     *
     * @param choix le choix spécifié pour l'affichage.
     */
    public static void init(String choix) {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Prospect> prospects = DaoProspect.findAll();
            if (prospects != null) {
                request.setAttribute("prospects", prospects);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/affichageP.jsp");
                dispatcher.forward(request, response);
            } else {
                // Gérer le cas où la liste de prospects est null
                // Peut-être afficher un message d'erreur ou rediriger vers une autre page
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
