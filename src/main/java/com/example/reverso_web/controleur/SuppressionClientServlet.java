package com.example.reverso_web.controleur;

import com.example.reverso_web.exception.ControleurExcpetion;
import com.example.reverso_web.exception.DaoException;
import com.example.reverso_web.model.dao.DaoClient;
import com.example.reverso_web.model.entite.Client;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "SuppressionClient", value = "/SuppressionClient")
public class SuppressionClientServlet extends HttpServlet {
    private static Client client;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Récupérer l'identifiant du client à modifier depuis les paramètres de la requête
            String raisonSociale = request.getParameter("raisonSociale");

            // Récupérer les informations du client à partir de l'identifiant
            client = DaoClient.findByName(raisonSociale);

            // Vérifier si le client existe
            if (client == null) {
                throw new ControleurExcpetion("Client non trouvé.");
            }

            // Envoyer les informations du client à la page JSP pour afficher le formulaire de modification
            request.setAttribute("client", client);
            RequestDispatcher dispatcher = request.getRequestDispatcher("suppressionClient.jsp");
            dispatcher.forward(request, response);





        } catch (NumberFormatException e) {
            throw new ServletException("Identifiant du client invalide.", e);
        } catch (DaoException e) {
            throw new ServletException("Échec de la récupération des informations du client.", e);
        } catch (ControleurExcpetion e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            DaoClient.delete(client.getRaisonSociale());
            response.sendRedirect("affichageClient");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}