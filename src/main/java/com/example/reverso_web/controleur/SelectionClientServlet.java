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
import java.util.List;

@WebServlet(name = "ClientSelectionServlet", value = "/clientSelection")
public class SelectionClientServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            if (LoginServlet.session == null || LoginServlet.session.getAttribute("user") == null){
                response.sendRedirect("clientSelection.jsp");
            }else {

                List<Client> clients =DaoClient.findAll();
                request.setAttribute("clients", clients);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/clientSelection.jsp");
                dispatcher.forward(request, response);

            }

        } catch (DaoException e) {
            throw new ServletException("Échec de la récupération de la liste des clients.", e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
