package dao;

    import model.cClientes;
    import java.util.List;

public interface ClienteDao {
    public List<cClientes> list(String q);
    public boolean insertar(cClientes p);
    public boolean modificar(cClientes p);
    public boolean eliminar(int idCliente);
    public cClientes buscar(int idCliente);
}
