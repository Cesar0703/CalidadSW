package dao;

    import model.cCategoria;
    import java.util.List;

public interface CategoriaDao {
    public List<cCategoria> list(String q);
    public boolean insertar(cCategoria p);
    public boolean modificar(cCategoria p);
    public boolean eliminar(int idCategoria);
    public cCategoria buscar(int idCategoria);
}
