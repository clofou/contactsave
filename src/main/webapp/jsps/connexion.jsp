<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ContactSave | Connexion</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/inscription.css">
</head>
<body>
    <div class="image"><img src="assets/images/connexion.png" alt=""></div>
    <form action="connexion">
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
    
        </div>

        <input type="submit" class="button2" value="SE CONNECTER">
    </form>
</body>
</html>