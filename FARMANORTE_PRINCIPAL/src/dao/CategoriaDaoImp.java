package dao;

import Factory.ConnectionDb;
import Factory.FactoryConnectionDb;
import model.cCategoria;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDaoImp implements CategoriaDao{
    ConnectionDb conn;
    public CategoriaDaoImp(){
         this.conn = FactoryConnectionDb.Open();
    }
    @Override
    public List<cCategoria> list(String q) {
        List<cCategoria> _list = new ArrayList<>();
        try
        {   StringBuilder query = new StringBuilder();
            query.append("select * from categoria where nomCategoria like '%").
                    append(q).append("%' ORDER BY nomCategoria DESC");
            ResultSet rs = conn.query(query.toString());
            while(rs.next()) {
                cCategoria p = new cCategoria();
                p.setIdCategoria(rs.getString("idCategoria"));
                p.setNomCategoria(rs.getString("nomCategoria"));
                p.setDescripcionCategoria(rs.getString("descripcionCategoria"));
                _list.add(p);
            }
        }
        catch(Exception ex){
            System.out.println("Error: "+ex.getMessage());
        }
        return _list;
    }

    @Override
    public boolean insertar(cCategoria p) {        
        boolean grabado = false;
            try{
                StringBuilder sql = new StringBuilder();
                sql.append("insert into categoria (nomCategoria,descripcionCategoria) "
                        + "values (");
                sql.append("'"); sql.append(p.getNomCategoria());sql.append("',");
                sql.append("'"); sql.append(p.getDescripcionCategoria());sql.append("')");                
                
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
    public boolean modificar(cCategoria p) {        
        boolean grabado = false;
            try{
                StringBuilder sql = new StringBuilder();
                sql.append("update categoria set ").
                append("nomCategoria='").append(p.getNomCategoria()).append("',").
                append("descripcionCategoria='").append(p.getDescripcionCategoria()).append("'").
                append(" where idCategoria=");sql.append(p.getIdCategoria());                 
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
    public boolean eliminar(int idCategoria) {        
        boolean f = false;
        try
        {
            StringBuilder query = new StringBuilder();
            query.append("delete from categoria WHERE idCategoria=").
                    append(idCategoria);
            f = conn.execute(query.toString());
        }catch(Exception ex)
        {
            System.out.println("Error: "+ex.getMessage());
        }
        return f;
    }

    @Override
    public cCategoria buscar(int idCategoria) {        
        cCategoria p = new cCategoria();
        StringBuilder sql = new StringBuilder();
        sql.append("select * from categoria where idCategoria=");
        sql.append(idCategoria);
        try{
             ResultSet rs = this.conn.query(sql.toString());
             while(rs.next()){
                p.setIdCategoria(rs.getString("idCategoria"));
                p.setNomCategoria(rs.getString("nomCategoria"));
                p.setDescripcionCategoria(rs.getString("descripcionCategoria"));           
             }
         }catch(Exception e){
             e.printStackTrace();
         }finally{
             this.conn.close();
         }
        return p;
    }    

}