package dao;

    import model.cBoleta;
    import java.util.List;

public interface BoletaDao {
    public List<cBoleta> list(String q);
    public boolean insertar(cBoleta p);
    public boolean modificar(cBoleta p);
    public boolean eliminar(int idBoleta);
    public cBoleta buscar(int idBoleta);
}
