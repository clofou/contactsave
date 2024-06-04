package Models;

public class Contacts {
    private int id;
    private String nomContact;
    private String adresse;
    private String emailPersonnel;
    private String emailProfessionnel;
    private String competenceFavorite;
    private String photoUrl;

    public Contacts() {}

    public Contacts(int id, String nomContact, String adresse, String emailPersonnel, String emailProfessionnel, String competenceFavorite, String photoUrl) {
        this.id = id;
        this.nomContact = nomContact;
        this.adresse = adresse;
        this.emailPersonnel = emailPersonnel;
        this.emailProfessionnel = emailProfessionnel;
        this.competenceFavorite = competenceFavorite;
        this.photoUrl = photoUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomContact() {
        return nomContact;
    }

    public void setNomContact(String nomContact) {
        this.nomContact = nomContact;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmailPersonnel() {
        return emailPersonnel;
    }

    public void setEmailPersonnel(String emailPersonnel) {
        this.emailPersonnel = emailPersonnel;
    }

    public String getEmailProfessionnel() {
        return emailProfessionnel;
    }

    public void setEmailProfessionnel(String emailProfessionnel) {
        this.emailProfessionnel = emailProfessionnel;
    }

    public String getCompetenceFavorite() {
        return competenceFavorite;
    }

    public void setCompetenceFavorite(String competenceFavorite) {
        this.competenceFavorite = competenceFavorite;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
