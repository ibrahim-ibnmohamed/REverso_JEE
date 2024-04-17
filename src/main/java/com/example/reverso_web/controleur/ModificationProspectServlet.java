package com.example.reverso_web.controleur;

import com.example.reverso_web.exception.ControleurExcpetion;
import com.example.reverso_web.exception.DaoException;
import com.example.reverso_web.model.dao.DaoClient;
import com.example.reverso_web.model.dao.DaoProspect;
import com.example.reverso_web.model.entite.Client;
import com.example.reverso_web.model.entite.Prospect;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "ModificationProspectServlet", value = "/modificationProspect")
public class ModificationProspectServlet extends HttpServlet {
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
            RequestDispatcher dispatcher = request.getRequestDispatcher("modificationProspect.jsp");
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
            String raisonSociale = request.getParameter("raisonSociale");
            String numeroDeRue = request.getParameter("numeroDeRue");
            String nomDeRue = request.getParameter("nomDeRue");
            String ville = request.getParameter("ville");
            String codePostal = request.getParameter("codePostal");
            String telephone = request.getParameter("telephone");
            String email = request.getParameter("email");
            String dateDeProspectionStr = request.getParameter("date");
            LocalDate dateDeProspection = LocalDate.parse(dateDeProspectionStr);
            String prospectInteresse = request.getParameter("interesse");
            String commentaire = request.getParameter("commentaire");

            if (raisonSociale == null || numeroDeRue == null /* || autres paramètres */) {
                throw new ServletException("Certains paramètres sont manquants pour la mise à jour du prospect.");
            }




            request.setAttribute("prospect", prospect);

            // Vérifier si le prospect existe
            if (prospect == null) {
                throw new ControleurExcpetion("Prospect non trouvé.");
            }

            // Mettre à jour les informations du prospect avec les nouvelles données
            prospect.setRaisonSociale(raisonSociale);
            prospect.setNumeroDeRue(numeroDeRue);
            prospect.setNomDeRue(nomDeRue);
            prospect.setVille(ville);
            prospect.setCodePostal(codePostal);
            prospect.setTelephone(telephone);
            prospect.setemail(email);
            prospect.setDateDeProspection(dateDeProspection);
            prospect.setProspectInteresse(prospectInteresse);
            prospect.setCommentaire(commentaire);


            // Mettre à jour d'autres attributs selon vos besoins...


            DaoProspect.update(prospect);


            // Rediriger vers une page de confirmation ou de succès
         response.sendRedirect("affichageProspect");
        } catch (NumberFormatException e) {
            throw new ServletException("Identifiant du prospect invalide.", e);
        } catch (DaoException e) {
            throw new ServletException("Échec de la mise à jour du prospect.", e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
