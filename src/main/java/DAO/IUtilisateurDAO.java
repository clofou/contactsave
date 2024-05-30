package DAO;

import Models.Contacts;

import java.util.ArrayList;

public interface IUtilisateurDAO {
    /**
     * Fonction qui inscrit l'utilisateur dans un Base de donnes, La fonction hashe le mot
     * de passe
     *
     * @param email String
     * @param motDePasse String
     * @return Boolean (Vrai Si l'inscription est un succes et faux Sinon)
     */
    boolean inscription(String email, String motDePasse);

    /**
     * Une fonction qui permet de faire du login avec un email et un mot de passe
     *
     * @param email String
     * @param motDePasse String
     * @return uid de l'utilisateur qui s'est connecté ou renvoi "-1"
     * si l'utilisateur n'existe pas, "-2" si le mot de passe est incorrect,
     * "-3 pour tout autre probleme"
     */
    String connexion(String email, String motDePasse);

    /**
     * Cette methode permet de tranferer les contacts à un autre utilisateur
     * les contacts seront transferer et enregistrer dans la base comme contact de
     * l'utilisateur cible
     *
     * @param contacts Liste de Contacts
     * @param uid id de l'utilisateur qui doit recevoir les contacts
     * @return boolean (Vrai si le contact a été partagé avec succees et faux sinon)
     */
    boolean partagerContact(ArrayList<Contacts> contacts, String uid);

    /**
     * Cette fonction exporte en format vcard les contacts et l'enregistre
     * localement sur le device qui execute la fonction
     *
     * @param contacts Liste de Contacts
     * @return boolean (Vrai si les contacts ont ete exporte avec succees, faux sinon)
     */
    boolean enregistrerContact(ArrayList<Contacts> contacts);
}
