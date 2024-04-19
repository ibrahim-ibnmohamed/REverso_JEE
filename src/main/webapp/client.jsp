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
  </head>

  <body>

  <jsp:include page="header.jsp" />

    <main>

    <div class="container">
      <div class="row">
        <div class="col-md-6">
          <div class="card bg-transparent-bisque mb-2">

            <div class="card-body">
              <article class="card">
                <a class="text-center" href="affichageClient"
                  ><img
                    class="iconAccueil"
                    src="img/afficher.png"
                    alt=" icon client"
                /></a>

                <div class="content">
                  <p>Afficher</p>
                </div>
              </article>
            </div>
          </div>
        </div>
        <div class="col-md-6">
          <div class="card bg-transparent-bisque mb-2">
            <div class="card-body">
              <article class="card">
                <a class="text-center" href="clientSelection"
                  ><img
                    class="iconAccueil"
                    src="img/modif.png"
                    alt=" icon prospect"
                /></a>

                <div class="content">
                  <p>Gérer </p>
                </div>
              </article>
            </div>

          </div>
        </div>
      </div>

      <hr class="dropdown-divider" />

      <!-- Contenu principal de la page -->
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
