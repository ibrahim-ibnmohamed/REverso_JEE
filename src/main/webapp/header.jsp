<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String nomBtn = "Connexion";
if (request.getSession().getAttribute("user") != null) {
    nomBtn="Déconnexion";
}
%>
<header>
    <nav class="nav1 navbar">
        <div class="container-fluid">
            <a href="index"><img class="logoCon" src="img/r.png" alt="Logo de mon entreprise" /></a>

            <button  class=" btn-login"  ><a href="login">
               <%=nomBtn%></a></button>

            <!-- Bouton de connexion -->
        </div>
    </nav>

    <!-- As a heading -->
    <nav class="navbar nav2">
        <div class="container-fluid"></div>
    </nav>
    <hr class="dropdown-divider" />
</header>
<% if (request.getSession().getAttribute("email") != null) {%>
<div class="container-fluid">
    <h1><%= request.getSession().getAttribute("user")%> </h1>
</div>
<% }%>
