<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<footer class="footer mt-auto py-3 foot">

    <div id="cookie-banner" style="display: none; background-color: #f0f0f0; padding: 10px;">
        Ce site utilise des cookies pour améliorer l'expérience utilisateur. <a href="/cookies-policy">En savoir plus</a>
        <button id="accept-cookies">Accepter</button>
        <button id="refuse-cookies">Refuser</button>
    </div>


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
    <script>
        // Fonction pour enregistrer les préférences de l'utilisateur
        function saveCookiePreferences(acceptCookies) {
            // Enregistrer les préférences dans la session
            sessionStorage.setItem('cookiesAccepted', acceptCookies ? 'true' : 'false');

            // Si les cookies sont acceptés, stocker cette préférence dans un cookie
            if (acceptCookies) {
                document.cookie = 'cookiesAccepted=true; path=/; max-age=31536000'; // Max-age en secondes (1 an)
            }
        }

        // Afficher la boîte de dialogue de cookies lorsque la page est chargée
        window.onload = function() {
            var cookiesAccepted = sessionStorage.getItem('cookiesAccepted');

            if (!cookiesAccepted) {
                document.getElementById("cookie-banner").style.display = "block";
            }
        };

        // Gérer les clics sur les boutons d'acceptation et de refus de cookies
        document.getElementById("accept-cookies").onclick = function() {
            saveCookiePreferences(true);
            window.location.reload(); // Recharger la page pour refléter les préférences acceptées
        };

        document.getElementById("refuse-cookies").onclick = function() {
            saveCookiePreferences(false);
            window.location.reload(); // Recharger la page pour refléter les préférences refusées
        };
    </script>

</footer>