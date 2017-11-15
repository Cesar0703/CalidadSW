package model;

public class cLaboratorio {
    private String idLaboratorio;
    private String nomLaboratorio;
    private String descripcionLaboratorio;

    public cLaboratorio(String idLaboratorio, String nomLaboratorio, String descripcionLaboratorio) {
        this.idLaboratorio = idLaboratorio;
        this.nomLaboratorio = nomLaboratorio;
        this.descripcionLaboratorio = descripcionLaboratorio;
    }

    public cLaboratorio() {
        idLaboratorio="0";
    }


    public String getIdLaboratorio() {
        return idLaboratorio;
    }

    public void setIdLaboratorio(String idLaboratorio) {
        this.idLaboratorio = idLaboratorio;
    }

    public String getNomLaboratorio() {
        return nomLaboratorio;
    }

    public void setNomLaboratorio(String nomLaboratorio) {
        this.nomLaboratorio = nomLaboratorio;
    }

    public String getDescripcionLaboratorio() {
        return descripcionLaboratorio;
    }

    public void setDescripcionLaboratorio(String descripcionLaboratorio) {
        this.descripcionLaboratorio = descripcionLaboratorio;
    }
    
}
