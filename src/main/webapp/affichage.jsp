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
          <a href="index.html">
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
              <tr>
                <td data-lable="Raison Sociale">IbraTeCH</td>
                <td data-lable="Num de Rue">5</td>
                <td data-lable="Nom de Rue">Rue de la pixe</td>
                <td data-lable="Ville">Nancy</td>
                <td data-lable="Code Postal">54000</td>
                <td data-lable="Téléphone">0721458725</td>
                <td data-lable="Adresse Email">Ibra@gmail.com</td>
                <td data-lable="CH">1000000</td>
                <td data-lable="N°Employer">1</td>
              </tr>
              <tr>
                <td data-lable="raisonSociale">IbraTeCH</td>
                <td data-lable="numDeRue">5</td>
                <td data-lable="nomDeRue">Rue de la republique </td>
                <td data-lable="ville">Nancy</td>
                <td data-lable="codePostal">54000</td>
                <td data-lable="telephone">0721458725</td>
                <td data-lable="adresseEmail">lai@gmail.com</td>
                <td data-lable="chiffreDAffaire">1000000</td>
                <td data-lable="nombreEmployer">1</td>
              </tr>
              <tr>
                <td data-lable="raisonSociale">IbraTeCH</td>
                <td data-lable="numDeRue">5</td>
                <td data-lable="nomDeRue">avenue de la liberté de je saiss pas qui </td>
                <td data-lable="ville">Nancy</td>
                <td data-lable="codePostal">54000</td>
                <td data-lable="telephone">0721458725</td>
                <td data-lable="adresseEmail">Ibrahi@gmail.com</td>
                <td data-lable="chiffreDAffaire">1000000</td>
                <td data-lable="nombreEmployer">1</td>
              </tr>
              <!-- Ajoutez ici les autres lignes de données -->
            </tbody>
          </table>
        </div>
      </div>
    </div>
</main>

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
