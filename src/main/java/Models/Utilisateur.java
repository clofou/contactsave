package Models;

public class Utilisateur {
    private String uid;
    private String prenom;
    private String nom;
    private String email;
    private String motDePasse;

    public Utilisateur(){}
    public Utilisateur(String uid, String prenom, String nom, String email, String motDePasse){
        this.uid = uid;
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.motDePasse = motDePasse;
    }

    public String getEmail() {
        return email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getUid() {
        return uid;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
