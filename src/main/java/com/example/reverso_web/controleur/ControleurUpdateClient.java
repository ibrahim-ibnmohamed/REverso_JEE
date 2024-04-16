package com.example.reverso_web.controleur;

import com.example.reverso_web.model.dao.DaoClient;
import com.example.reverso_web.model.entite.Client;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "formulairClient", value = "/formulairClient")
public class ControleurUpdateClient extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int clientId = Integer.parseInt(request.getParameter("clientId")); // Récupérer l'identifiant unique du client à mettre à jour
            String raisonSociale = request.getParameter("raisonSociale");
            String numeroDeRue = request.getParameter("numeroDeRue");
            String nomDeRue = request.getParameter("nomDeRue");
            String ville = request.getParameter("ville");
            String codePostal = request.getParameter("codePostal");
            String telephone = request.getParameter("telephone");
            String email = request.getParameter("email");
            String commentaire = request.getParameter("commentaire");
            double chiffreDaffaire = Double.parseDouble(request.getParameter("chiffreDaffaire"));
            int nombreEmployer = Integer.parseInt(request.getParameter("nombreEmployer"));

            // Créer un nouvel objet Client avec les nouvelles valeurs
            Client client = new Client(clientId, raisonSociale, numeroDeRue, nomDeRue, codePostal, telephone, ville, email, commentaire, chiffreDaffaire, nombreEmployer);

            // Appeler la méthode de mise à jour dans DaoClient
            DaoClient.update(client);

            // Rediriger vers la page d'affichage des clients
            response.sendRedirect("affichageClient");

        } catch (IOException | NumberFormatException e) {
            throw new ServletException("Erreur lors de la mise à jour du client.", e);
        } catch (Exception e) {
            throw new ServletException("Erreur lors de la mise à jour du client.", e);
        }
    }
}
