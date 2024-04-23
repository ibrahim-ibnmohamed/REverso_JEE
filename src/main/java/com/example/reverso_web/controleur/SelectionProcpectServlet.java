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
import java.util.List;

@WebServlet(name = " SelectionProcpectServlet", value = "/prospectSelection")
public class SelectionProcpectServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

                if (LoginServlet.session == null || LoginServlet.session.getAttribute("user") == null){
                    response.sendRedirect("prospectSelection.jsp");
                }else {

                    List<Prospect> prospect =DaoProspect.findAll();
                    request.setAttribute("prospect", prospect);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/prospectSelection.jsp");
                    dispatcher.forward(request, response);

                }
            // Récupérer la liste des prospect

        } catch (DaoException e) {
            throw new ServletException("Échec de la récupération de la liste des prospect.", e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
