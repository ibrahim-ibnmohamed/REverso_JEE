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

    <div class="wrapper container">
      <!-- Tableau d'affichage des informations client -->
      <h2>Informations Client</h2>
      <div class="row">
        <div class="col">
          <table class="table info-table">
            <thead class="tableAffichage">
              <tr >
                <th id="raisonSociale">Raison Sociale</th>
                
                <th id="numeroDeRue">Numéro de Rue</th>
               
                <th id="nomDeRue">Nom de Rue</th>
              
                <th id="ville" >Ville</th>
                
                <th id="codePostal" >Code Postal</th>
              
                <th id="telephone">Téléphone</th>
            
                <th id="email" >Adresse Email</th>
             
                <th id="date" >Date</th>
               
                <th id="interesse" >Intéressé :</th>
                
               
                
              </tr>
              <tr>
                
                <td id="raisonSociale">IbraTeCH </td>
                
                <td id="numeroDeRue">5</td>
                
                <td id="nomDeRue">Rue de la pixe</td>
                
                <td id="ville">Nancy</td>
                
                <td id="codePostal">54000</td>
                
                <td id="telephone">0721458725</td>
                
                <td id="email">Ibrahi@gmail.com</td>
                
                <td id="date">21/02/2002</td>
                
                <td id="interesse">oui</td>
               
              </tr>
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
