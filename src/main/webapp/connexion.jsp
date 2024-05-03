<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Connexion</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link href="assert/CSS/style.css" rel="stylesheet">
</head>
<body>

<jsp:include page="header.jsp" />

<main>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card login-container">
                    <div class="card-body">
                        <h2>Connexion</h2>
                        <form action="login" method="post">
                            <div class="form-group">
                                <label for="email">Email</label>
                                <input type="email" class="form-control" id="email" name="email" placeholder="Entrez votre email" required>
                            </div>
                            <div class="form-group">
                                <label for="password">Mot de passe</label>
                                <input type="password" class="form-control" id="password" name="password" placeholder="Entrez votre mot de passe" required>
                            </div>

                            <input type="hidden" name="csrfTokken" value="<%= session.getAttribute("csrfToken") %>">

                            <button type="submit" class="btn-login  mt-3 ">Connexion</button>

                            <div>
                                <label>Rester Connecté
                                    <input type="checkbox" name="rememberMe" id="rememberMe">
                                </label>
                            </div>

                        </form>
                    </div>

                    <div class="card-footer">
                        <p class="mb-0">Si vous n'avez pas de compte, <a href="register.jsp">créez-en un ici</a>.</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>

<jsp:include page="footer.jsp" />

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
