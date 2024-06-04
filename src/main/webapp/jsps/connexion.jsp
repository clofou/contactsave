<%@ page contentType="text/html;charset=UTF-8" %>
<%
    String errorMessage = (String) request.getAttribute("errorMessage");
    if (errorMessage == null){
        errorMessage="";
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ContactSave | Connexion</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/insConn.css">
</head>
<body>
    <div class="image"><img src="assets/images/connexion.png" alt=""></div>
    <form action="connexionI" method="post">
        <div>
            <div class="saisie">
                <div class="champ">
                    <label for="email">Email</label>
                    <img src="assets/images/entypo_email.png" alt="icône du mail">
                    <input type="email" name="email" id="email">
                </div>

                <div class="champ">
                    <label for="motDePasse">Mot de passe</label>
                    <img src="assets/images/mdi_password.png" alt="icône du mot de passe">
                    <input type="password" name="motDePasse" id="motDePasse">
                </div>
                <div class="compte">
                    Vous n'avez pas compte ? <a href="inscription">inscrivez-vous</a>
                </div>
            </div>
            <div class="error"><%=errorMessage%></div>
        </div>


        <button id="submitButton" disabled>SE CONNECTER</button>
    </form>

    <script>

        function x() {
            if(champMail.value!=="" && champPassword.value !==""){
                button.setAttribute("class", "button2")
                button.disabled = false;
            } else {
                button.removeAttribute("class");
            }
        }

        let button = document.getElementById('submitButton');
        let champMail = document.getElementById("email");
        let champPassword = document.getElementById("motDePasse");

        let errorMes = document.querySelector(".error")
        if (errorMes.innerText === ""){
            errorMes.setAttribute("display", "none")
        }

        champMail.addEventListener('change', x);
        champPassword.addEventListener('change',x)
    </script>
</body>
</html>