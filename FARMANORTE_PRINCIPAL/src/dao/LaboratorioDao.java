package dao;

    import model.cLaboratorio;
    import java.util.List;

public interface LaboratorioDao {
    public List<cLaboratorio> list(String q);
    public boolean insertar(cLaboratorio p);
    public boolean modificar(cLaboratorio p);
    public boolean eliminar(int idLaboratorio);
    public cLaboratorio buscar(int idLaboratorio);
}
