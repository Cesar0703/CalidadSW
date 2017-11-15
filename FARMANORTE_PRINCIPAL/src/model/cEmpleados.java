package model;

public class cEmpleados extends cPersona{
    
    private String cargo;

    public cEmpleados(String cargo, String cod, String DNI, String nombre, String ape_paterno, String ape_materno, String direccion, String telefono, String email, String sexo, String fechNacimiento) {
        super(cod, DNI, nombre, ape_paterno, ape_materno, direccion, telefono, email, sexo, fechNacimiento);
        this.cargo = cargo;
    }


    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    
}
