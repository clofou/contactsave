package Models;

public class Contacts {
    private int id;
    private String nomContact;
    private String adresse;
    private String emailPersonnel;
    private String emailProfessionnel;
    private String CompetenceFavorite;

    public Contacts(){}
    public Contacts(int id, String nomContact, String adresse, String emailPersonnel, String emailProfessionnel, String competenceFavorite){
        this.adresse = adresse;
        this.CompetenceFavorite = competenceFavorite;
        this.nomContact = nomContact;
        this.id = id;
        this.emailPersonnel = emailPersonnel;
        this.emailProfessionnel = emailProfessionnel;
    }

    public String getNomContact() {
        return nomContact;
    }

    public String getAdresse() {
        return adresse;
    }

    public int getId() {
        return id;
    }

    public String getCompetenceFavorite() {
        return CompetenceFavorite;
    }

    public String getEmailPersonnel() {
        return emailPersonnel;
    }

    public String getEmailProfessionnel() {
        return emailProfessionnel;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setCompetenceFavorite(String competenceFavorite) {
        CompetenceFavorite = competenceFavorite;
    }

    public void setEmailPersonnel(String emailPersonnel) {
        this.emailPersonnel = emailPersonnel;
    }

    public void setEmailProfessionnel(String emailProfessionnel) {
        this.emailProfessionnel = emailProfessionnel;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNomContact(String nomContact) {
        this.nomContact = nomContact;
    }
}
