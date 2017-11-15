package dao;

import Factory.ConnectionDb;
import Factory.FactoryConnectionDb;
import model.cBoleta;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BoletaDaoImp implements BoletaDao{
    ConnectionDb conn;
    public BoletaDaoImp(){
         this.conn = FactoryConnectionDb.Open();
    }
    @Override
    public List<cBoleta> list(String q) {
        List<cBoleta> _list = new ArrayList<>();
        try
        {   StringBuilder query = new StringBuilder();
            query.append("select * from boleta where idCliente like '%").
                    append(q).append("%' ORDER BY idCliente DESC");
            ResultSet rs = conn.query(query.toString());
            while(rs.next()) {
                cBoleta p = new cBoleta();
                p.setIdBoleta(rs.getString("idBoleta"));
                p.setFecha(rs.getString("fecha"));
                p.setIdCliente(rs.getString("idCliente"));
                p.setIdEmpleado(rs.getString("idEmpleado"));
                p.setTotal(rs.getDouble("total"));
                _list.add(p);
            }
        }
        catch(Exception ex){
            System.out.println("Error: "+ex.getMessage());
        }
        return _list;
    }

    @Override
    public boolean insertar(cBoleta p) {        
        boolean grabado = false;
            try{
                StringBuilder sql = new StringBuilder();
                sql.append("insert into boleta (fecha,idCliente,idEmpleado,total)"
                        + "values (");
                sql.append("'"); sql.append(p.getFecha());sql.append("',");
                sql.append(p.getIdCliente());sql.append(",");
                sql.append(p.getIdEmpleado());sql.append(",");
                sql.append(p.getTotal());sql.append(")");                
                
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
    public boolean modificar(cBoleta p) {        
        boolean grabado = false;
            try{
                StringBuilder sql = new StringBuilder();
                sql.append("update boleta set ").
                append("fecha='").append(p.getFecha()).append("',").
                append("idCliente=").append(p.getIdCliente()).append(",").
                append("idEmpleado=").append(p.getIdEmpleado()).append(",").
                append("total=").append(p.getTotal()).append("").
                append(" where idBoleta=");sql.append(p.getIdBoleta());                 
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
    public boolean eliminar(int idBoleta) {        
        boolean f = false;
        try
        {
            StringBuilder query = new StringBuilder();
            query.append("delete from boleta WHERE idBoleta=").
                    append(idBoleta);
            f = conn.execute(query.toString());
        }catch(Exception ex)
        {
            System.out.println("Error: "+ex.getMessage());
        }
        return f;
    }

    @Override
    public cBoleta buscar(int idBoleta) {        
        cBoleta p = new cBoleta();
        StringBuilder sql = new StringBuilder();
        sql.append("select * from boleta where idBoleta=");
        sql.append(idBoleta);
        try{
             ResultSet rs = this.conn.query(sql.toString());
             while(rs.next()){
                p.setIdBoleta(rs.getString("idBoleta"));
                p.setFecha(rs.getString("fecha"));
                p.setIdCliente(rs.getString("idCliente"));
                p.setIdEmpleado(rs.getString("idEmpleado"));             
                p.setTotal(rs.getDouble("total"));  
             }
         }catch(Exception e){
             e.printStackTrace();
         }finally{
             this.conn.close();
         }
        return p;
    }    

}