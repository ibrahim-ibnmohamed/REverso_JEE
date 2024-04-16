<%@ page import="com.example.reverso_web.model.entite.Client" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>modifier un client</title>
  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" />
  <link href="assert/CSS/style.css" rel="stylesheet" />
</head>
<body>
<header>
  <nav class="nav1 navbar">
    <div class="container-fluid">
      <a href="index.jsp">
        <img class="logoCon" src="img/r.png" alt="Logo de mon entreprise" />
      </a>
    </div>
  </nav>
  <!-- As a heading -->
  <nav class="navbar nav2">
    <div class="container-fluid"></div>
  </nav>
  <hr class="dropdown-divider" />
</header>
<h2 class="text-center mb-4">Modifier</h2>
<form method="post" action="modificationClient" >
  <div class="mb-3">
    <label for="raisonSociale" class="form-label">Raison Sociale :</label>
    <input type="text" id="raisonSociale" name="raisonSociale" class="form-control" value="<%= ((Client)request.getAttribute("client")).getRaisonSociale() %>" required/>
  </div>
  <div class="mb-3">
    <label for="numeroDeRue" class="form-label">Numéro de Rue :</label>
    <input type="text" id="numeroDeRue" name="numeroDeRue" class="form-control" value="<%= ((Client)request.getAttribute("client")).getNumeroDeRue() %>" required/>
  </div>
  <div class="mb-3">
    <label for="nomDeRue" class="form-label">Nom de Rue :</label>
    <input type="text" id="nomDeRue" name="nomDeRue" class="form-control" value="<%= ((Client)request.getAttribute("client")).getNomDeRue() %>"  required/>
  </div>
  <div class="mb-3">
    <label for="ville" class="form-label">Ville :</label>
    <input type="text" id="ville" name="ville" class="form-control" value="<%= ((Client)request.getAttribute("client")).getVille() %>"  required/>
  </div>
  <div class="mb-3">
    <label for="codePostal" class="form-label">Code Postal :</label>
    <input type="text" id="codePostal" name="codePostal" class="form-control" value="<%= ((Client)request.getAttribute("client")).getCodePostal()%>"  required/>
  </div>
  <div class="mb-3">
    <label for="telephone" class="form-label">Téléphone :</label>
    <input type="text" id="telephone" name="telephone" class="form-control"  value="<%= ((Client)request.getAttribute("client")).getTelephone() %>" required/>
  </div>
  <div class="mb-3">
    <label for="email" class="form-label">Adresse Email :</label>
    <input type="email" id="email" name="email" class="form-control" value="<%= ((Client)request.getAttribute("client")).getemail() %>"  required/>
  </div>
  <div class="mb-3">
    <label for="chiffreDaffaire" class="form-label">Chiffre d'Affaires :</label>
    <input type="number" id="chiffreDaffaire" name="chiffreDaffaire" class="form-control" value="<%= ((Client)request.getAttribute("client")).getChiffreDaffaire()%>"  required/>
  </div>
  <div class="mb-3">
    <label for="nombreEmployer" class="form-label">Nombre d'Employés :</label>
    <input type="number" id="nombreEmployer" name="nombreEmployer" class="form-control" value="<%= ((Client)request.getAttribute("client")).getNombreEmployer() %>" required/>
  </div>
  <div class="mb-3">
    <label for="commentaire" class="form-label">Commentaire :</label>
    <textarea id="commentaire" name="commentaire" class="form-control"><%= ((Client) request.getAttribute("client")).getCommentaire() %></textarea>
  </div>

  <div class="mb-3 text-center">
    <button type="submit" class="btn-login">Modifier</button>
  </div>
</form>
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
