package dao;

    import model.cProveedor;
    import java.util.List;

public interface ProveedorDao {
    public List<cProveedor> list(String q);
    public boolean insertar(cProveedor p);
    public boolean modificar(cProveedor p);
    public boolean eliminar(int idProveedor);
    public cProveedor buscar(int idProveedor);
}
