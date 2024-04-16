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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Récupérer l'identifiant du client à modifier depuis les paramètres de la requête
            String raisonSociale = request.getParameter("raisonSociale");

            // Récupérer les informations du client à partir de l'identifiant
            DaoClient.delete(raisonSociale);

            response.sendRedirect("affichageClient");
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

}