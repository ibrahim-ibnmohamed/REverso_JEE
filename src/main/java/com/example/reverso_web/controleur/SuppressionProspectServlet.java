package com.example.reverso_web.controleur;

import com.example.reverso_web.exception.ControleurExcpetion;
import com.example.reverso_web.exception.DaoException;
import com.example.reverso_web.model.dao.DaoProspect;
import com.example.reverso_web.model.dao.DaoProspect;
import com.example.reverso_web.model.dao.DaoProspect;
import com.example.reverso_web.model.entite.Prospect;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "SuppressionProspect", value = "/SuppressionProspect")
public class SuppressionProspectServlet extends HttpServlet {
    private static Prospect prospect;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Récupérer l'identifiant du prospect à modifier depuis les paramètres de la requête
            String raisonSociale = request.getParameter("raisonSociale");

            // Récupérer les informations du prospect à partir de l'identifiant
            prospect = DaoProspect.findByName(raisonSociale);

            // Vérifier si le prospect existe
            if (prospect == null) {
                throw new ControleurExcpetion("Prospect non trouvé.");
            }

            // Envoyer les informations du prospect à la page JSP pour afficher le formulaire de modification
            request.setAttribute("prospect", prospect);
            RequestDispatcher dispatcher = request.getRequestDispatcher("suppressionProspect.jsp");
            dispatcher.forward(request, response);





        } catch (NumberFormatException e) {
            throw new ServletException("Identifiant du prospect invalide.", e);
        } catch (DaoException e) {
            throw new ServletException("Échec de la récupération des informations du prospect.", e);
        } catch (ControleurExcpetion e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            DaoProspect.delete(prospect.getRaisonSociale());
            response.sendRedirect("affichageProspect");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}