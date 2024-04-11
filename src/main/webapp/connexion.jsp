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
  </head>

  <body>
    <header>
      <nav class="nav1 navbar">
        <div class="container-fluid">
         
          
         <a href="index.html"> <img class="logoCon" src="img/r.png" alt="Logo de mon entreprise" /></a>
     
        </div>
      </nav>

      <!-- As a heading -->
      <nav class="navbar nav2">
        <div class="container"></div>
      </nav>
      <hr class="dropdown-divider" />
    </header>
  <main>
      <div class="container">
          <div class="row justify-content-center">
              <div class="col-md-6">
                  <div class="card login-container">
                
                      <div class="card-body">
                          <form>
                              <div class="form-group">
                                  <label for="email">Email</label>
                                  <input type="email" class="form-control" id="email" placeholder="Entrer votre email">
                              </div>
                              <div class="form-group">
                                  <label for="password">Mot de passe</label>
                                  <input type="password" class="form-control" id="password" placeholder="Entrer votre mot de passe">
                              </div>
                              <button  id= "btn_conection" type="submit" class=" btn-login">Connexion</button Style pad>
                          </form>
                      </div>
                  </div>
              </div>
          </div>
      </div>
  </body>

    <div class="wrapper container">
      <div class="cards">
        
      </div>
      <div class="cards">
        
      </div>

      <hr class="dropdown-divider" />

      <!-- Contenu principal de la page -->
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
