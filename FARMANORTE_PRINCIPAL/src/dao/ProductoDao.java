package dao;

    import model.cProductos;
    import java.util.List;

public interface ProductoDao {
    public List<cProductos> list(String q);
    public boolean insertar(cProductos p);
    public boolean modificar(cProductos p);
    public boolean eliminar(int idProducto);
    public boolean restarStock(int Producto, int cantidad);
    public cProductos buscar(int idProducto);
}
