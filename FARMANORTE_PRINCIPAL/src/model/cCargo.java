package model;

public class cCargo {
    private String idCargo;
    private String nomCargo;
    private double sueldoCargo;
    private String descripcionCargo;

    public cCargo() {
        this.idCargo = "0";
        this.nomCargo = "";
        this.sueldoCargo = 0.00;
        this.descripcionCargo = "";
    }

    public String getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(String idCargo) {
        this.idCargo = idCargo;
    }

    public String getNomCargo() {
        return nomCargo;
    }

    public void setNomCargo(String nomCargo) {
        this.nomCargo = nomCargo;
    }

    public double getSueldoCargo() {
        return sueldoCargo;
    }

    public void setSueldoCargo(double sueldoCargo) {
        this.sueldoCargo = sueldoCargo;
    }

    public String getDescripcionCargo() {
        return descripcionCargo;
    }

    public void setDescripcionCargo(String descripcionCargo) {
        this.descripcionCargo = descripcionCargo;
    }
    
    
}
