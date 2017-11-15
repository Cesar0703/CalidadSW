package dao;

    import model.cUsuario;
    import java.util.List;

public interface UsuarioDao {
    public List<cUsuario> list();
    public boolean insertar(cUsuario _usuario);
    public boolean modificar(cUsuario _usuario);
    public boolean eliminar(int idUsuario);
    public cUsuario buscar(int idUsuario);
}
