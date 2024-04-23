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
@WebServlet(name = "affichageClient", value = "/affichageClient")

public class AffichageClientServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            if (LoginServlet.session == null || LoginServlet.session.getAttribute("user") == null){
                response.sendRedirect("affichage.jsp");
            }else {
                List<Client> clients =DaoClient.findAll();
                request.setAttribute("clients", clients);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/affichage.jsp");
                dispatcher.forward(request, response);

            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
