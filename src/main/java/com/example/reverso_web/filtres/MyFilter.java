package com.example.reverso_web.filtres;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(urlPatterns = {"/affichage.jsp","/prospectSelection.jsp","/clientSelection.jsp"}, description = "filtre_logg")
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialisation du filtre
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // Actions à effectuer avant que la requête n'atteigne le servlet ou la ressource cible

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);

        // Par exemple, vous pouvez logguer des informations sur la requête :
        System.out.println("Requête interceptée : " + request.getRemoteAddr() + ", " + request.getLocalPort());
        if(session!=null && session.getAttribute("user") != null) {
            chain.doFilter(request, response);

        }else {
            res.sendRedirect(req.getContextPath() + "/login");
        }
    }

    @Override
    public void destroy() {
        // Libération des ressources utilisées par le filtre
    }
}
