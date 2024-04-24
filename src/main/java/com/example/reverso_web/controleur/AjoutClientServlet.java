package com.example.reverso_web.controleur;

import com.example.reverso_web.model.dao.DaoClient;
import com.example.reverso_web.model.entite.Client;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Le contrôleur pour l'affichage des données dans l'application.
 */
@WebServlet(name = "formulairClient", value = "/formulairClient")

public class AjoutClientServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Rediriger vers la page JSP
        RequestDispatcher dispatcher = request.getRequestDispatcher("ajoutClient.jsp");
        dispatcher.forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            String tokenCSRF = request.getParameter("csrfTokken");  // recuperer valeur input
            HttpSession session = request.getSession(); //   recuperer le token de la session
            String csrf = (String) session.getAttribute("csrfToken");
            if (csrf != null && csrf.equals(tokenCSRF) ) {  // comparer les tokens

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

            }else {
                response.sendRedirect("index.jsp");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);

        }
    }


}
