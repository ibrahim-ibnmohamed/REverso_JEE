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
import java.text.ParseException;
import java.time.LocalDate;

/**
 * Le contrôleur pour l'affichage des données dans l'application.
 */
@WebServlet(name = "formulairProspect", value = "/formulairProspect")

public class AjoutProspectServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/ajoutProspect.jsp");
        dispatcher.forward(request, response);
    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String raisonSociale = request.getParameter("raisonSociale");
            String numDeRue = request.getParameter("numeroDeRue");
            String nomDeRue = request.getParameter("nomDeRue");
            String codePostal = request.getParameter("codePostal");
            String telephone = request.getParameter("telephone");
            String ville = request.getParameter("ville");
            String email = request.getParameter("email");
            String commentaire = request.getParameter("commentaire");
            String dateDeProspectionStr = request.getParameter("date");
            LocalDate dateDeProspection = LocalDate.parse(dateDeProspectionStr);
            String prospectInteresse = request.getParameter("interesse");

            Prospect prospect = new Prospect(1, raisonSociale, numDeRue, nomDeRue, codePostal, telephone, ville, email, commentaire, dateDeProspection, prospectInteresse);
            DaoProspect.create(prospect);
            response.sendRedirect("affichageProspect");

        } catch (ParseException | NumberFormatException e) {
            throw new ServletException("Erreur lors du traitement de la requête.", e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



}
