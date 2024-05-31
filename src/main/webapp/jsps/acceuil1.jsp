<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Acceuil</title>
    <link rel="stylesheet" href="css/acceuil1.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="grid">
        <div class="grid-item">
            <div class="head" id="head">
                <div class="profilAvatar"><img src="assets/images/Group 9.png" alt=""></div>
                <div class="infoUser">
                    <div class="nom">Prenom Nom</div>
                    <div class="email colorS">email@example.com</div>
                </div>
            </div>
            <div class="main">
                <div class="menu">
                    <div class="menu-item">
                        <img src="assets/images/clarity_list-line.png" alt="icône Liste">
                        <p>Liste De Contacts</p>
                    </div>
                    <div class="menu-item">
                        <img src="assets/images/ant-design_disconnect-outlined.png" alt="icône Liste">
                        <p>Se deconnecter</p>
                    </div>
                </div>
                <div class="logo">
                    <img src="assets/images/Logo save (1).png" alt="Logo de l'appli">
                </div>
            </div>
        </div>
        <div class="grid-item">
            <div class="head" id="head1">
                <div class="actionButton">
                    <img src="assets/images/ic_baseline-share.png" alt="Icône d'envoi">
                    <img src="assets/images/ph_export-bold.png" alt="Button D'exportation">
                </div>
                <div class="searchBar">
                    <img src="assets/images/cil_search.png" alt="Icône de recherche">
                    <input type="email" value="Rechercher un contact"  onfocus="if (this.value==='Rechercher un contact') this.value=''">
                </div>
            </div>
            <div class="main">
                <div class="mainAction">
                    <div class="selectAll">
                        <input type="checkbox" name="selectAll" id="selectAll">
                        <label for="selectAll">SELECTIONNER TOUT</label>
                    </div>
                    <div class="addContact">
                        <img src="assets/images/icon-park-solid_add.png" alt="">
                        <label for="selectAll">Ajouter un nouveau Contact</label>
                    </div>
                </div>
                <div class="mainContent">
                    <div class="mainContent-item">
                        <label for="contact-card1"></label><input type="checkbox" name="contact-card1" id="contact-card1">
                        <div class="card">
                            <div class="cardRight">
                                <div class="profilContact"><img src="assets/images/Group 9.png" alt=""></div>
                                <div class="infoContact">
                                    <div class="nom">Prenom Nom</div>
                                    <div class="email colorS">email@example.com</div>
                                </div>
                            </div>
                            <div class="cardLeft">Competence</div>
                        </div>
                        <div class="contact-action">
                            <div class="edit"><img src="assets/images/tabler_edit.png" alt="Icône Edit"></div>
                            <div class="delete"><img src="assets/images/uiw_delete.png" alt="Icône Suppression"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>