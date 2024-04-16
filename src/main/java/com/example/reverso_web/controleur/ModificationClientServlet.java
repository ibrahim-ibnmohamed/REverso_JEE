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

@WebServlet(name = "ModificationClientServlet", value = "/modificationClient")
public class ModificationClientServlet extends HttpServlet {
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
            RequestDispatcher dispatcher = request.getRequestDispatcher("modificationClient.jsp");
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

            if (raisonSociale == null || numeroDeRue == null /* || autres paramètres */) {
                throw new ServletException("Certains paramètres sont manquants pour la mise à jour du client.");
            }




            request.setAttribute("client", client);

            // Vérifier si le client existe
            if (client == null) {
                throw new ControleurExcpetion("Client non trouvé.");
            }

            // Mettre à jour les informations du client avec les nouvelles données
            client.setRaisonSociale(raisonSociale);
            client.setNumeroDeRue(numeroDeRue);
            client.setNomDeRue(nomDeRue);
            client.setVille(ville);
            client.setCodePostal(codePostal);
            client.setTelephone(telephone);
            client.setemail(email);
            client.setChiffreDaffaire(chiffreDaffaire);
            client.setNombreEmployer(nombreEmployer);
            client.setCommentaire(commentaire);


            // Mettre à jour d'autres attributs selon vos besoins...


            DaoClient.update(client);


            // Rediriger vers une page de confirmation ou de succès
         response.sendRedirect("affichageClient");
        } catch (NumberFormatException e) {
            throw new ServletException("Identifiant du client invalide.", e);
        } catch (DaoException e) {
            throw new ServletException("Échec de la mise à jour du client.", e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
