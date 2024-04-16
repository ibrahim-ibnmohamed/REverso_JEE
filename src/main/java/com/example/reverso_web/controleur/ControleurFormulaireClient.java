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
@WebServlet(name = "formulairClient", value = "/formulairClient")

public class ControleurFormulaireClient extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
           String raisonSociale = request.getParameter("raisonSociale");
           String numeroDeRue = request.getParameter("numeroDeRue");
            String nomDeRue = request.getParameter("nomDeRue");
            String ville = request.getParameter("ville");
            String codePostal = request.getParameter("codePostal");
            String telephone = request.getParameter("telephone");
            String email = request.getParameter("email");
            double chiffreDaffaire = Double.parseDouble(request.getParameter("chiffreDaffaire"));
            int nombreEmployer = Integer.parseInt(request.getParameter("nombreEmployer"));
            String commentaire = request.getParameter("commentaire");

            Client client=new Client(1, raisonSociale,numeroDeRue,nomDeRue,codePostal,telephone,ville,email,commentaire,chiffreDaffaire,nombreEmployer);
            DaoClient.create(client);
            response.sendRedirect("affichageClient");

        } catch (Exception e) {
            throw new RuntimeException(e);

        }
    }


}
