<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <title>ContactSave | Inscription</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/inscription.css">
</head>
<body>
    <div class="image"><img src="assets/images/inscription.png" alt=""></div>
    <form action="inscription-traitement" method="post">
        <div class="saisie">
            <div class="champ">
                <label for="email">Email</label>
                <img src="assets/images/entypo_email.png" alt="icône du mail">
                <input type="text" name="email" id="email">
            </div>
    
            <div class="champ">
                <label for="motDePasse">Mot de passe</label>
                <img src="assets/images/mdi_password.png" alt="icône du mot de passe">
                <input type="password" name="motDePasse" id="motDePasse">
            </div>
    
            <div class="champ">
                <img src="assets/images/mdi_password.png" alt="icône du mot de passe">
                <label for="cMotDePasse">Confirmez le Mot de passe</label>
                <input type="password" name="cMotDePasse" id="cMotDePasse">
            </div>

            <div class="term-compte">
                <div class="term">
                    <input type="checkbox" name="terms" id="terms">
                    <label for="terms">Acceptez les <a href="cgu.html">Les Termes et Conditions d'utilisations.</a></label>
                </div>
                <div>
                    Vous avez déjà un compte ? <a href="connexion">Connectez-vous</a>
                </div>
                <br>
            </div>
            <div class="error"><%=errorMessage%></div>
        </div>

        <input type="submit" class="button1" value="S'INSCRIRE">
    </form>
</body>
</html>