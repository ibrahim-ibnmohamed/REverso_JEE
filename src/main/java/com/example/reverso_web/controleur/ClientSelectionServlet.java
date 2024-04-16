package com.example.reverso_web.controleur;

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
import java.util.ArrayList;

@WebServlet(name = "ClientSelectionServlet", value = "/clientSelection")
public class ClientSelectionServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Récupérer la liste des clients
            ArrayList<Client> clients = DaoClient.findAll();

            // Envoyer la liste des clients à la vue (page JSP)
            request.setAttribute("clients", clients);
            RequestDispatcher dispatcher = request.getRequestDispatcher("clientUpdateSelection.jsp");
            dispatcher.forward(request, response);
        } catch (DaoException e) {
            throw new ServletException("Échec de la récupération de la liste des clients.", e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
