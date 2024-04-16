<%@ page import="com.example.reverso_web.model.entite.Prospect" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Bootstrap demo</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
      crossorigin="anonymous"
    />
    <link href="assert/CSS/style.css" rel="stylesheet" />
    <style>
      .info-table th,
      .info-table td {
        text-align: left;
      }
    </style>
  </head>
  <body>
    <header>
      <nav class="nav1 navbar">
        <div class="container-fluid">
          <a href="index.jsp">
            <img class="logoCon" src="img/r.png" alt="Logo de mon entreprise"
          /></a>
        </div>
      </nav>
      <!-- As a heading -->
      <nav class="navAffich">
        <div class="navAffich container"></div>
      </nav>
      <hr class="dropdown-divider" />
    </header>

    <div class="wrapper container">
      <!-- Tableau d'affichage des informations client -->
      <h2>Informations Client</h2>
      <div class="row">
        <div class="col">
          <table class="table info-table">
            <thead class="tableAffichage">
              <tr >
                <th >Raison Sociale</th>
                
                <th >Numéro de Rue</th>
               
                <th>Nom de Rue</th>
              
                <th>Ville</th>
                
                <th >Code Postal</th>
              
                <th>Téléphone</th>
            
                <th>Adresse Email</th>
             
                <th>Date</th>
               
                <th>Intéressé :</th>
                
               
                
              </tr>
              <% for (Prospect prospect: (List<Prospect>) request.getAttribute("prospects")){%>
              <tr>
                
                <td  data-lable="raisonSociale"><%=prospect.getRaisonSociale() %> </td>
                
                <td  data-lable="numeroDeRue"><%=prospect.getNumeroDeRue() %> </td>
                
                <td  data-lable="nomDeRue"><%=prospect.getNomDeRue() %></td>
                
                <td  data-lable="ville"><%=prospect.getVille() %></td>
                
                <td  data-lable="codePostal"><%=prospect.getCodePostal() %></td>

                <td data-lable="telephone"><%=prospect.getTelephone() %></td>

                <td  data-lable="email"><%=prospect.getemail() %></td>
                
                <td  data-lable="date"><%=prospect.getDateDeProspection() %></td>
                
                <td  data-lable="interesse"><%=prospect.getProspectInteresse()%></td>
               
              </tr>
              <%} %>
            </thead>
          </table>
        </div>
      </div>
      <!-- Fin du tableau -->

      <div class="cards"></div>
      <div class="cards"></div>
      <hr class="dropdown-divider" />

      <!-- Contenu principal de la page -->
    </div>

    <footer class="footer mt-auto py-3 foot">
      <div class="container text-center text-white">
        <span>© 2024 Mon Entreprise</span><br />
        <span>123 Rue de l'Exemple, Ville, Pays</span><br />
        <span>Téléphone: +123456789</span><br />
        <span>Email: info@monentreprise.com</span><br />
        <span>Suivez-nous sur:</span><br />
        <a href="#" class="text-white me-2">Facebook</a>
        <a href="#" class="text-white me-2">Twitter</a>
        <a href="#" class="text-white">Instagram</a>
      </div>
    </footer>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
      crossorigin="anonymous"
    ></script>
  </body>
</html>
