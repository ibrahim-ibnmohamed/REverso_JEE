package com.example.reverso_web.controleur;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "index", value = "/index")
public class IndexServlet extends HttpServlet {
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       String csrfToken = UUID.randomUUID().toString();    // generer un token
       HttpSession session = request.getSession();
       session.setAttribute("csrfToken", csrfToken);

       RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
       dispatcher.forward(request, response);
   }
}
