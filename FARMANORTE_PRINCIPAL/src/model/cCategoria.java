package model;

public class cCategoria {
    private String idCategoria;
    private String nomCategoria;
    private String descripcionCategoria;

    public cCategoria(String idCategoria, String nomCategoria, String descripcionCategoria) {
        this.idCategoria = idCategoria;
        this.nomCategoria = nomCategoria;
        this.descripcionCategoria = descripcionCategoria;
    }

    public cCategoria() {
        this.idCategoria = "0";
    }

    public String getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(String idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNomCategoria() {
        return nomCategoria;
    }

    public void setNomCategoria(String nomCategoria) {
        this.nomCategoria = nomCategoria;
    }

    public String getDescripcionCategoria() {
        return descripcionCategoria;
    }

    public void setDescripcionCategoria(String descripcionCategoria) {
        this.descripcionCategoria = descripcionCategoria;
    }
    
    
}
