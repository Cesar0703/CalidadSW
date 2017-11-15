package dao;

    import model.cDetalle;
    import java.util.List;

public interface DetalleDao {
    public List<cDetalle> list(String q);
    public boolean insertar(cDetalle p);
    public boolean modificar(cDetalle p);
    public boolean eliminar(int idDetalle);
    public cDetalle buscar(int idDetalle);
}
