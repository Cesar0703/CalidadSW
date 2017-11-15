package dao;

    import model.cEmpleados;
    import java.util.List;

public interface EmpleadoDao {
    public List<cEmpleados> list(String q);
    public boolean insertar(cEmpleados p);
    public boolean modificar(cEmpleados p);
    public boolean eliminar(int idEmpleado);
    public cEmpleados buscar(int idEmpleado);
}
