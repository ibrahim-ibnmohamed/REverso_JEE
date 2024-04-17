package com.example.reverso_web.controleur;

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
import java.util.ArrayList;

@WebServlet(name = " SelectionProcpectServlet", value = "/prospectSelection")
public class SelectionProcpectServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Récupérer la liste des prospect
            ArrayList<Prospect> prospect = DaoProspect.findAll();

            // Envoyer la liste des prospect à la première vue (page JSP)
            request.setAttribute("prospect", prospect);
            RequestDispatcher dispatcher1 = request.getRequestDispatcher("prospectSelection.jsp");
            dispatcher1.forward(request, response);
        } catch (DaoException e) {
            throw new ServletException("Échec de la récupération de la liste des prospect.", e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
