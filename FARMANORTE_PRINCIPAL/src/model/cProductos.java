package model;
public class cProductos {
    
    private String idProducto;
    private String nomProducto;
    private String fechEmision;
    private String fechVencimiento;
    private String descripcionProducto;
    private int stock;
    private double precOriginal;
    private double precVenta;
    private String idProveedor;
    private String idLaboratorio;
    private String idCategoria;

    public cProductos() {
        idProducto="0";
        fechEmision="";
        fechVencimiento="";
    }


    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getNomProducto() {
        return nomProducto;
    }

    public void setNomProducto(String nomProducto) {
        this.nomProducto = nomProducto;
    }

    public String getFechEmision() {
        return fechEmision;
    }

    public void setFechEmision(String fechEmision) {
        this.fechEmision = fechEmision;
    }

    public String getFechVencimiento() {
        return fechVencimiento;
    }

    public void setFechVencimiento(String fechVencimiento) {
        this.fechVencimiento = fechVencimiento;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecOriginal() {
        return precOriginal;
    }

    public void setPrecOriginal(double precOriginal) {
        this.precOriginal = precOriginal;
    }

    public double getPrecVenta() {
        return precVenta;
    }

    public void setPrecVenta(double precVenta) {
        this.precVenta = precVenta;
    }

    public String getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(String idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getIdLaboratorio() {
        return idLaboratorio;
    }

    public void setIdLaboratorio(String idLaboratorio) {
        this.idLaboratorio = idLaboratorio;
    }

    public String getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(String idCategoria) {
        this.idCategoria = idCategoria;
    }

   
    
            
}
