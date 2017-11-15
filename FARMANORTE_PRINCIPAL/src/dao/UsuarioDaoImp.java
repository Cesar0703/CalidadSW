package dao;

import Factory.ConnectionDb;
import Factory.FactoryConnectionDb;
import model.cUsuario;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class UsuarioDaoImp implements UsuarioDao{
    ConnectionDb conn;
    public UsuarioDaoImp(){
         this.conn = FactoryConnectionDb.Open();
    }
    
    @Override
    public List<cUsuario> list() {
        List<cUsuario> _list = new ArrayList<>();
        try
        {   
            StringBuilder query = new StringBuilder();
            query.append("SELECT * FROM usuario ORDER BY idUsuario DESC");
            ResultSet rs = conn.query(query.toString());
            while(rs.next()) {
                cUsuario p = new cUsuario();
                p.setIdUsuario(rs.getInt("idUsuario"));
                p.setContrasenia(rs.getString("contrasenia"));
                p.setUsuario(rs.getString("usuario"));
                p.setIdEmpleado(rs.getString("idEmpleado"));
                _list.add(p);
            }
        }
        catch(Exception ex){
            System.out.println("Error: "+ex.getMessage());
        }
        return _list;
    }

    @Override
    public boolean insertar(cUsuario p) {        
        boolean grabado = false;
            try{
                StringBuilder sql = new StringBuilder();
                sql.append("insert into usuario (contrasenia,usuario,idEmpleado)"
                        + "values (");
                sql.append("'"); sql.append(p.getContrasenia());sql.append("',");
                sql.append("'"); sql.append(p.getUsuario());sql.append("',");
                sql.append(p.getIdEmpleado());sql.append(")");                
                
                this.conn.execute(sql.toString()); 
            }catch(Exception e){
                 e.printStackTrace();
                 grabado = false;
            }
            finally{
                this.conn.close();
            }
        return grabado;
    }

    @Override
    public boolean modificar(cUsuario p) {        
        boolean grabado = false;
            try{
                StringBuilder sql = new StringBuilder();
                sql.append("update usuario set ").
                append("usuario='").append(p.getUsuario()).append("',").
                append("contrasenia='").append(p.getContrasenia()).append("'").
                append(" where idUsuario=");sql.append(p.getIdUsuario());                 
                this.conn.execute(sql.toString()); 
            }catch(Exception e){
                 e.printStackTrace();
                 grabado = false;
            }
            finally{
                this.conn.close();
            }
        return grabado;
    }

    @Override
    public boolean eliminar(int idEmpleado) {        
        boolean f = false;
        try
        {
            StringBuilder query = new StringBuilder();
            query.append("delete from usuario WHERE idEmpleado=").
                    append(idEmpleado);
            f = conn.execute(query.toString());
        }catch(Exception ex)
        {
            System.out.println("Error: "+ex.getMessage());
        }
        return f;
    }

    @Override
    public cUsuario buscar(int idEmpleado) {        
        cUsuario p = new cUsuario();
        StringBuilder sql = new StringBuilder();
        sql.append("select * from usuario where idEmpleado=").append(idEmpleado);
        try{
             ResultSet rs = this.conn.query(sql.toString());
             while(rs.next()){
                p.setIdUsuario(rs.getInt("idUsuario"));
                p.setContrasenia(rs.getString("contrasenia"));
                p.setUsuario(rs.getString("usuario"));
                p.setIdEmpleado(rs.getString("idEmpleado"));              
             }
         }catch(Exception e){
             e.printStackTrace();
         }
        return p;
    }    

}