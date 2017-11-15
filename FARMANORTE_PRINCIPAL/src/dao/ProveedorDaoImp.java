package dao;

import Factory.ConnectionDb;
import Factory.FactoryConnectionDb;
import model.cProveedor;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDaoImp implements ProveedorDao{
    ConnectionDb conn;
    public ProveedorDaoImp(){
         this.conn = FactoryConnectionDb.Open();
    }
    @Override
    public List<cProveedor> list(String q) {
        List<cProveedor> _list = new ArrayList<>();
        try
        {   StringBuilder query = new StringBuilder();
            query.append("select * from proveedor where nomProveedor like '%").
                    append(q).append("%' ORDER BY nomProveedor DESC");
            ResultSet rs = conn.query(query.toString());
            while(rs.next()) {
                cProveedor p = new cProveedor();
                p.setIdProveedor(rs.getString("idProveedor"));
                p.setNomProveedor(rs.getString("nomProveedor"));
                p.setDirecProveedor(rs.getString("direcProveedor"));
                p.setTelfProveedor(rs.getString("telfProveedor"));
                p.setDescripcionProveedor(rs.getString("descripcionProveedor"));
                _list.add(p);
            }
        }
        catch(Exception ex){
            System.out.println("Error: "+ex.getMessage());
        }
        return _list;
    }

    @Override
    public boolean insertar(cProveedor p) {        
        boolean grabado = false;
            try{
                StringBuilder sql = new StringBuilder();
                sql.append("insert into proveedor (nomProveedor,direcProveedor,telfProveedor,"
                        + "descripcionProveedor) "
                        + "values (");
                sql.append("'"); sql.append(p.getNomProveedor());sql.append("',");
                sql.append("'"); sql.append(p.getDirecProveedor());sql.append("',");
                sql.append("'"); sql.append(p.getTelfProveedor());sql.append("',");
                sql.append("'"); sql.append(p.getDescripcionProveedor());sql.append("')");                
                
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
    public boolean modificar(cProveedor p) {        
        boolean grabado = false;
            try{
                StringBuilder sql = new StringBuilder();
                sql.append("update proveedor set ").
                append("nomProveedor='").append(p.getNomProveedor()).append("',").
                append("direcProveedor='").append(p.getDirecProveedor()).append("',").
                append("telfProveedor='").append(p.getTelfProveedor()).append("',").
                append("descripcionProveedor='").append(p.getDescripcionProveedor()).append("'").
                append(" where idProveedor=");sql.append(p.getIdProveedor());                
                System.out.println(""+p.getIdProveedor());
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
    public boolean eliminar(int idProveedor) {        
        boolean f = false;
        try
        {
            StringBuilder query = new StringBuilder();
            query.append("delete from proveedor WHERE idProveedor=").
                    append(idProveedor);
            f = conn.execute(query.toString());
        }catch(Exception ex)
        {
            System.out.println("Error: "+ex.getMessage());
        }
        return f;
    }

    @Override
    public cProveedor buscar(int idProveedor) {        
        cProveedor p = new cProveedor();
        StringBuilder sql = new StringBuilder();
        sql.append("select * from proveedor where idProveedor=");
        sql.append(idProveedor);
        try{
             ResultSet rs = this.conn.query(sql.toString());
             while(rs.next()){
                p.setIdProveedor(rs.getString("idProveedor"));
                p.setNomProveedor(rs.getString("nomProveedor"));
                p.setDirecProveedor(rs.getString("direcProveedor"));
                p.setTelfProveedor(rs.getString("telfProveedor"));
                p.setDescripcionProveedor(rs.getString("descripcionProveedor"));           
             }
         }catch(Exception e){
             e.printStackTrace();
         }finally{
             this.conn.close();
         }
        return p;
    }    

}