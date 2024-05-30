package Models;

public class Attribut {
    private int id;
    private String nomAttribut;

    public Attribut(){}
    public Attribut(int id, String nomAttribut){
        this.id = id;
        this.nomAttribut = nomAttribut;
    }

    public int getId() {
        return id;
    }

    public String getNomAttribut() {
        return nomAttribut;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNomAttribut(String nomAttribut) {
        this.nomAttribut = nomAttribut;
    }
}
