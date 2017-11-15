package dao;

import Factory.ConnectionDb;
import Factory.FactoryConnectionDb;
import model.cLaboratorio;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LaboratorioDaoImp implements LaboratorioDao{
    ConnectionDb conn;
    public LaboratorioDaoImp(){
         this.conn = FactoryConnectionDb.Open();
    }
    @Override
    public List<cLaboratorio> list(String q) {
        List<cLaboratorio> _list = new ArrayList<>();
        try
        {   StringBuilder query = new StringBuilder();
            query.append("select * from laboratorio where nomLaboratorio like '%").
                    append(q).append("%' ORDER BY nomLaboratorio DESC");
            ResultSet rs = conn.query(query.toString());
            while(rs.next()) {
                cLaboratorio p = new cLaboratorio();
                p.setIdLaboratorio(rs.getString("idLaboratorio"));
                p.setNomLaboratorio(rs.getString("nomLaboratorio"));
                p.setDescripcionLaboratorio(rs.getString("descripcionLaboratorio"));
                _list.add(p);
            }
        }
        catch(Exception ex){
            System.out.println("Error: "+ex.getMessage());
        }
        return _list;
    }

    @Override
    public boolean insertar(cLaboratorio p) {        
        boolean grabado = false;
            try{
                StringBuilder sql = new StringBuilder();
                sql.append("insert into laboratorio (nomLaboratorio,descripcionLaboratorio) "
                        + "values (");
                sql.append("'"); sql.append(p.getNomLaboratorio());sql.append("',");
                sql.append("'"); sql.append(p.getDescripcionLaboratorio());sql.append("')");                
                
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
    public boolean modificar(cLaboratorio p) {        
        boolean grabado = false;
            try{
                StringBuilder sql = new StringBuilder();
                sql.append("update laboratorio set ").
                append("nomLaboratorio='").append(p.getNomLaboratorio()).append("',").
                append("descripcionLaboratorio='").append(p.getDescripcionLaboratorio()).append("'").
                append(" where idLaboratorio=");sql.append(p.getIdLaboratorio());                 
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
    public boolean eliminar(int idLaboratorio) {        
        boolean f = false;
        try
        {
            StringBuilder query = new StringBuilder();
            query.append("delete from laboratorio WHERE idLaboratorio=").
                    append(idLaboratorio);
            f = conn.execute(query.toString());
        }catch(Exception ex)
        {
            System.out.println("Error: "+ex.getMessage());
        }
        return f;
    }

    @Override
    public cLaboratorio buscar(int idLaboratorio) {        
        cLaboratorio p = new cLaboratorio();
        StringBuilder sql = new StringBuilder();
        sql.append("select * from laboratorio where idLaboratorio=");
        sql.append(idLaboratorio);
        try{
             ResultSet rs = this.conn.query(sql.toString());
             while(rs.next()){
                p.setIdLaboratorio(rs.getString("idLaboratorio"));
                p.setNomLaboratorio(rs.getString("nomLaboratorio"));
                p.setDescripcionLaboratorio(rs.getString("descripcionLaboratorio"));           
             }
         }catch(Exception e){
             e.printStackTrace();
         }finally{
             this.conn.close();
         }
        return p;
    }    

}