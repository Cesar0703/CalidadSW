package dao;

import Factory.ConnectionDb;
import Factory.FactoryConnectionDb;
import model.cCargo;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CargoDaoImp implements CargoDao{
    ConnectionDb conn;
    public CargoDaoImp(){
         this.conn = FactoryConnectionDb.Open();
    }
    @Override
    public List<cCargo> list(String q) {
        List<cCargo> _list = new ArrayList<>();
        try
        {   StringBuilder query = new StringBuilder();
            query.append("select * from cargo where nomCargo like '%").
                    append(q).append("%' ORDER BY nomCargo DESC");
            ResultSet rs = conn.query(query.toString());
            while(rs.next()) {
                cCargo p = new cCargo();
                p.setIdCargo(rs.getString("idCargo"));
                p.setNomCargo(rs.getString("nomCargo"));
                p.setSueldoCargo(rs.getDouble("sueldoCargo"));
                p.setDescripcionCargo(rs.getString("descripcionCargo"));
                _list.add(p);
            }
        }
        catch(Exception ex){
            System.out.println("Error: "+ex.getMessage());
        }
        return _list;
    }

    @Override
    public boolean insertar(cCargo p) {        
        boolean grabado = false;
            try{
                StringBuilder sql = new StringBuilder();
                sql.append("insert into cargo (nomCargo,sueldoCargo,descripcionCargo) "
                        + "values (");
                sql.append("'"); sql.append(p.getNomCargo());sql.append("',");
                sql.append(p.getSueldoCargo());
                sql.append(",'"); sql.append(p.getDescripcionCargo());sql.append("')");                
                
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
    public boolean modificar(cCargo p) {        
        boolean grabado = false;
            try{
                StringBuilder sql = new StringBuilder();
                sql.append("update cargo set ").
                append("nomCargo='").append(p.getNomCargo()).append("',").
                append("sueldoCargo=").append(p.getSueldoCargo()).append(",").
                append("descripcionCargo='").append(p.getDescripcionCargo()).append("'").
                append(" where idCargo=");sql.append(p.getIdCargo());  
                
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
    public boolean eliminar(int idCargo) {        
        boolean f = false;
        try
        {
            StringBuilder query = new StringBuilder();
            query.append("delete from cargo WHERE idCargo=").
                    append(idCargo);
            f = conn.execute(query.toString());
        }catch(Exception ex)
        {
            System.out.println("Error: "+ex.getMessage());
        }
        return f;
    }

    @Override
    public cCargo buscar(int idCargo) {        
        cCargo p = new cCargo();
        StringBuilder sql = new StringBuilder();
        sql.append("select * from cargo where idCargo=");
        sql.append(idCargo);
        try{
             ResultSet rs = this.conn.query(sql.toString());
             while(rs.next()){
                p.setIdCargo(rs.getString("idCargo"));
                p.setNomCargo(rs.getString("nomCargo"));
                p.setSueldoCargo(rs.getDouble("sueldoCargo"));
                p.setDescripcionCargo(rs.getString("descripcionCargo"));           
             }
         }catch(Exception e){
             e.printStackTrace();
         }finally{
             this.conn.close();
         }
        return p;
    }    

}