<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ajouter un client</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="assert/CSS/style.css" rel="stylesheet" />
</head>
<body>

<jsp:include page="header.jsp"/>

    <h2 class="text-center mb-4">Ajouter un prospect</h2>


        <form class="form" id="addProspectForm" method="post" action="formulairProspect">
        <div class="mb-3">
            <label for="raisonSociale" class="form-label">Raison Sociale :</label>
            <input type="text" id="raisonSociale" name="raisonSociale" class="form-control" required />
        </div>

        <div class="mb-3">
            <label for="numeroDeRue" class="form-label">Numéro de Rue :</label>
            <input type="text" id="numeroDeRue" name="numeroDeRue" class="form-control" required />
        </div>

        <div class="mb-3">
            <label for="nomDeRue" class="form-label">Nom de Rue :</label>
            <input type="text" id="nomDeRue" name="nomDeRue" class="form-control" required />
        </div>

        <div class="mb-3">
            <label for="ville" class="form-label">Ville :</label>
            <input type="text" id="ville" name="ville" class="form-control" required />
        </div>

        <div class="mb-3">
            <label for="codePostal" class="form-label">Code Postal :</label>
            <input type="text" id="codePostal" name="codePostal" class="form-control" required />
        </div>

        <div class="mb-3">
            <label for="telephone" class="form-label">Téléphone :</label>
            <input type="text" id="telephone" name="telephone" class="form-control" required />
        </div>

        <div class="mb-3">
            <label for="email" class="form-label">Adresse Email :</label>
            <input type="email" id="email" name="email" class="form-control" required />
        </div>

        <div class="mb-3">
            <label for="date" class="form-label">Date :</label>
            <input type="date" id="date" name="date" class="form-control" required />
        </div>

        <div class="mb-3">
            <label for="interesse" class="form-label">Intéressé :</label>
            <select id="interesse" name="interesse" class="form-select" required>
                <option value="" disabled selected>Sélectionnez</option>
                <option value="oui">Oui</option>
                <option value="non">Non</option>
            </select>
        </div>

            <input type="hidden" name="csrfTokken" value="<%= session.getAttribute("csrfToken") %>">

        <div class="mb-3 text-center">
            <button type="submit" class="btn-login">Ajouter</button>
        </div>
    </form>

<jsp:include page="footer.jsp" />

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

    <script>
        function validateForm() {
            var raisonSociale = document.getElementById("raisonSociale").value;
            // Vérification de la raison sociale
            if (raisonSociale.trim() == "") {
                alert("Veuillez saisir la raison sociale.");
                return false;
            }

            // Ajoutez ici d'autres vérifications pour les autres champs si nécessaire

            return true; // Soumission du formulaire si toutes les vérifications sont réussies
        }
    </script>
</body>
</html>