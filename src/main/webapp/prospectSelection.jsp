<%@ page import="com.example.reverso_web.model.entite.Prospect" %>
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
        <h2>Informations Prospect</h2>
        <div>
            <div>
                <!-- Tableau pour les écrans de bureau (PC) -->
                <table>
                    <!-- Entête du tableau -->

                    <tr>


                             <button class="btn-login  mb-2 " ><a href="formulairProspect">Ajouter</a> </button>



                    </tr>
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
                        <% for (Prospect prospect: (List<Prospect>) request.getAttribute("prospect")){%>
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

                        <td>
                            <a href="modificationProspect?raisonSociale=<%=prospect.getRaisonSociale() %>">Modifier</a>
                        </td>
                        <td>
                            <a href="SuppressionProspect?raisonSociale=<%=prospect.getRaisonSociale()%>">supprimer </a>
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
