<%@ page import="Service.UtilisateurService" %>
<%@ page import="Models.Utilisateur" %>
<%@ page import="Models.Contacts" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    UtilisateurService utilisateurService = new UtilisateurService();
    Utilisateur user = utilisateurService.getUserInfo();
    if(user == null){
        request.getRequestDispatcher("connexion.jsp").forward(request, response);
    }
    List<Contacts> contacts = utilisateurService.getUserContacts();
    assert user != null;%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Accueil</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/acceuil1.css">
</head>
<body id="white">
<div class="grid">
    <!-- Sidebar -->
    <div class="grid-item">
        <div class="head headp" id="head">
            <div class="profilAvatar">
                <img src="assets/images/Group 9.png" alt="Profil Avatar">
            </div>
            <div class="infoUser">
                <div class="nom">
                    <%= user.getPrenom() == null ? "" : user.getPrenom() %>
                    <%= user.getNom() == null ? "" : user.getNom() %>
                </div>
                <div class="email colorS"><%= user.getEmail() %></div>
            </div>
        </div>
        <div class="main">
            <div class="menu">
                <div class="menu-item">
                    <img src="assets/images/clarity_list-line.png" alt="Icône Liste">
                    <p>Liste De Contacts</p>
                </div>
                <div style="width: 100%">
                    <form action="deconnexion" method="post">
                        <button type="submit" class="logout-button menu-item">
                            <img src="assets/images/ant-design_disconnect-outlined.png" alt="Icône Déconnexion">
                            <p>Se déconnecter</p>
                        </button>
                    </form>
                </div>
            </div>
            <div class="logo">
                <img src="assets/images/Logo save (1).png" alt="Logo de l'appli">
            </div>
        </div>
    </div>

    <!-- Main Content -->
    <div class="grid-item">
        <div class="head" id="head1">
            <div id="flou"></div>
            <div class="menu-toggle" id="menu-toggle">
                <div class="bar"></div>
                <div class="bar"></div>
                <div class="bar"></div>
            </div>
            <div class="rr">
                <div class="actionButton">
                    <img src="assets/images/ic_baseline-share.png" alt="Icône d'envoi">
                    <img src="assets/images/ph_export-bold.png" alt="Button D'exportation">
                </div>
                <div class="searchBar">
                    <img src="assets/images/cil_search.png" alt="Icône de recherche">
                    <label>
                        <input type="text" placeholder="Rechercher un contact">
                    </label>
                </div>
            </div>
        </div>
        <div class="main">
            <div class="mainAction">
                <div class="selectAll">
                    <input type="checkbox" name="selectAll" id="selectAll">
                    <label for="selectAll">SELECTIONNER TOUT</label>
                </div>
                <div class="addContact">
                    <form action="ajouterContact.jsp" method="get">
                        <button type="submit" class="add-contact-button">
                            <img src="assets/images/icon-park-solid_add.png" alt="Ajouter un contact">
                            <label>Ajouter un nouveau Contact</label>
                        </button>
                    </form>
                </div>
            </div>
            <div class="mainContent">
                <% for (Contacts contact : contacts) { %>
                <div class="mainContent-item">
                    <label for="contact-card<%= contact.getId() %>"></label><input type="checkbox" name="contact-card<%= contact.getId() %>" id="contact-card<%= contact.getId() %>">
                    <div class="card">
                        <div class="cardRight">
                            <div class="profilContact">
                                <img src="<%= contact.getPhotoUrl() != null ? contact.getPhotoUrl() : "assets/images/Group 9.png" %>" alt="Photo de contact">
                            </div>
                            <div class="infoContact">
                                <div class="nom"><%= contact.getNomContact() %></div>
                                <div class="email colorS"><%= contact.getEmailPersonnel() %></div>
                            </div>
                        </div>
                        <div class="cardLeft"><%= contact.getCompetenceFavorite() %></div>
                    </div>
                    <div class="contact-action">
                        <form action="modifierContact.jsp" method="get">
                            <input type="hidden" name="contactId" value="<%= contact.getId() %>">
                            <button type="submit" class="edit">
                                <img src="assets/images/tabler_edit.png" alt="Icône Edit">
                            </button>
                        </form>
                        <form action="supprimerContact" method="post">
                            <input type="hidden" name="contactId" value="<%= contact.getId() %>">
                            <button type="submit" class="delete">
                                <img src="assets/images/uiw_delete.png" alt="Icône Suppression">
                            </button>
                        </form>
                    </div>
                </div>
                <% } %>
            </div>
        </div>
    </div>
</div>

<script>
    document.addEventListener('DOMContentLoaded', function () {
        const flou = document.getElementById('flou');
        const menuToggle = document.getElementById('menu-toggle');
        const navLinks = document.querySelector(".grid-item:nth-child(1)");

        menuToggle.addEventListener('click', function () {
            menuToggle.classList.toggle('active');
            navLinks.classList.toggle('active');
            flou.classList.toggle('active');
        });
    });
</script>
</body>
</html>
