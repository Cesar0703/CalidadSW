package model;
public class cBoleta {    
    private String idBoleta;
    private String fecha;
    private String idCliente;
    private String idEmpleado;
    private double total;

    public cBoleta(String idBoleta, String fecha, String idCliente, String idEmpleado, double total) {
        this.idBoleta = idBoleta;
        this.fecha = fecha;
        this.idCliente = idCliente;
        this.idEmpleado = idEmpleado;
        this.total = total;
    }

    public cBoleta() {
        this.idBoleta = "0";
        total=0.00;
    }
    
    public String getIdBoleta() {
        return idBoleta;
    }

    public void setIdBoleta(String idBoleta) {
        this.idBoleta = idBoleta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
  }
