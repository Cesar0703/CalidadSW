package model;

public class cProveedor {
    private String idProveedor;
    private String nomProveedor;
    private String direcProveedor;
    private String telfProveedor;
    private String descripcionProveedor;


    public cProveedor() {
        this.idProveedor = "0";
        this.nomProveedor = "";
        this.direcProveedor = "";
        this.telfProveedor = "";
        this.descripcionProveedor = "";
    }

    public String getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(String idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNomProveedor() {
        return nomProveedor;
    }

    public void setNomProveedor(String nomProveedor) {
        this.nomProveedor = nomProveedor;
    }

    public String getDirecProveedor() {
        return direcProveedor;
    }

    public void setDirecProveedor(String direcProveedor) {
        this.direcProveedor = direcProveedor;
    }

    public String getTelfProveedor() {
        return telfProveedor;
    }

    public void setTelfProveedor(String telfProveedor) {
        this.telfProveedor = telfProveedor;
    }

    public String getDescripcionProveedor() {
        return descripcionProveedor;
    }

    public void setDescripcionProveedor(String descripcionProveedor) {
        this.descripcionProveedor = descripcionProveedor;
    }
    
    
}
