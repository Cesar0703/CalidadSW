package dao;

    import model.cCargo;
    import java.util.List;

public interface CargoDao {
    public List<cCargo> list(String q);
    public boolean insertar(cCargo p);
    public boolean modificar(cCargo p);
    public boolean eliminar(int idCargo);
    public cCargo buscar(int idCargo);
}
