package Models;


import Models.Enum.TypePortable;

public class NumeroDeTelephone {
    private int id;
    private TypePortable type;
    private String numero;

    public NumeroDeTelephone(){}
    public NumeroDeTelephone(int id, TypePortable type, String numero){
        this.id = id;
        this.type = type;
        this.numero = numero;
    }

    public int getId() {
        return id;
    }

    public TypePortable getType() {
        return type;
    }

    public String getNumero() {
        return numero;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setType(TypePortable type) {
        this.type = type;
    }
}
