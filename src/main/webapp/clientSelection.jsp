<%@ page import="com.example.reverso_web.model.entite.Client" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="fr">
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

<jsp:include page="header.jsp" />

<main>
    <div class="text-center">
        <!-- Tableau d'affichage des informations client -->
        <h2>Informations Client</h2>
        <div>
            <div>
                <!-- Tableau pour les écrans de bureau (PC) -->
                <table>
                    <!-- Entête du tableau -->
                    <thead>
                    <tr>
                             <button class="btn-login  mb-2 " ><a href="formulairClient">Ajouter</a> </button>

                    </tr>
                    <tr>
                        <th>Raison Sociale</th>
                        <th>Numéro de Rue</th>
                        <th>Nom de Rue</th>
                        <th>Ville</th>
                        <th>Code Postal</th>
                        <th>Téléphone</th>
                        <th>Adresse Email</th>
                        <th>Chiffre d'Affaires</th>
                        <th>Nombre d'Employés</th>
                    </tr>
                    </thead>
                    <!-- Contenu du tableau -->
                    <tbody>
                    <% for (Client client: (List<Client>) request.getAttribute("clients")){%>
                    <tr>
                        <td data-lable="Raison Sociale"><%=client.getRaisonSociale() %></td>
                        <td data-lable="Num de Rue"><%=client.getNumeroDeRue() %></td>
                        <td data-lable="Nom de Rue"><%=client.getNomDeRue() %></td>
                        <td data-lable="Ville"><%=client.getVille() %></td>
                        <td data-lable="Code Postal"><%=client.getCodePostal() %></td>
                        <td data-lable="Téléphone"><%=client.getTelephone()%></td>
                        <td data-lable="Adresse Email"><%=client.getemail() %></td>
                        <td data-lable="CH"><%=client.getChiffreDaffaire() %></td>
                        <td data-lable="N°Employer"><%=client.getNombreEmployer() %></td>
                        <td>
                            <a href="modificationClient?raisonSociale=<%=client.getRaisonSociale() %>">Modifier</a>
                        </td>
                        <td>
                            <a href="SuppressionClient?raisonSociale=<%=client.getRaisonSociale()%>">supprimer </a>
                        </td>


                    </tr>


                    <%} %>

                    <!-- Ajoutez ici les autres lignes de données -->
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</main>

<jsp:include page="footer.jsp" />


<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"
></script>
</body>
</html>
