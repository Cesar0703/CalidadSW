package dao;

import Factory.ConnectionDb;
import Factory.FactoryConnectionDb;
import model.cDetalle;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DetalleDaoImp implements DetalleDao{
    ConnectionDb conn;
    public DetalleDaoImp(){
         this.conn = FactoryConnectionDb.Open();
    }
    @Override
    public List<cDetalle> list(String q) {
        List<cDetalle> _list = new ArrayList<>();
        try
        {   StringBuilder query = new StringBuilder();
            query.append("select * from detalle_boleta where idBoleta like '").
                    append(q).append("' ORDER BY idBoleta DESC");
            ResultSet rs = conn.query(query.toString());
            while(rs.next()) {
                cDetalle p = new cDetalle();
                p.setIdDetalle(rs.getString("idDetalle"));
                p.setCantidad(rs.getInt("cantidad"));
                p.setPrecioUnitario(rs.getDouble("precioUnitario"));
                p.setPrecioTotal(rs.getDouble("precioTotal"));
                p.setIdBoleta(rs.getString("idBoleta"));
                p.setIdProducto(rs.getString("idProducto"));
                _list.add(p);
            }
        }
        catch(Exception ex){
            System.out.println("Error: "+ex.getMessage());
        }
        return _list;
    }

    @Override
    public boolean insertar(cDetalle p) {        
        boolean grabado = false;
            try{
                StringBuilder sql = new StringBuilder();
                sql.append("insert into detalle_boleta (idDetalle,cantidad,precioUnitario,precioTotal,"
                        + "idBoleta,idProducto) "
                        + "values (");
                sql.append(p.getIdDetalle());sql.append(",");
                sql.append(p.getCantidad());sql.append(",");
                sql.append(p.getPrecioUnitario());sql.append(",");
                sql.append(p.getPrecioTotal());sql.append(",");
                sql.append(p.getIdBoleta());sql.append(",");
                sql.append(p.getIdProducto());sql.append(")");                
                
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
    public boolean modificar(cDetalle p) {        
        boolean grabado = false;
            try{
                StringBuilder sql = new StringBuilder();
                sql.append("update detalle_boleta set ").
                append("cantidad=").append(p.getCantidad()).append(",").
                append("precioUnitario=").append(p.getPrecioUnitario()).append(",").
                append("precioTotal=").append(p.getPrecioTotal()).append(",").
                append("idBoleta=").append(p.getIdBoleta()).append(",").
                append("idProducto=").append(p.getIdBoleta()).append("").
                append(" where idDetalle=");sql.append(p.getIdDetalle());                 
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
    public boolean eliminar(int idDetalle) {        
        boolean f = false;
        try
        {
            StringBuilder query = new StringBuilder();
            query.append("delete from detalle_boleta WHERE idDetalle=").
                    append(idDetalle);
            f = conn.execute(query.toString());
        }catch(Exception ex)
        {
            System.out.println("Error: "+ex.getMessage());
        }
        return f;
    }

    @Override
    public cDetalle buscar(int idDetalle) {        
        cDetalle p = new cDetalle();
        StringBuilder sql = new StringBuilder();
        sql.append("select * from detalle_boleta where idDetalle=");
        sql.append(idDetalle);
        try{
             ResultSet rs = this.conn.query(sql.toString());
             while(rs.next()){
                p.setIdDetalle(rs.getString("idDetalle"));
                p.setCantidad(rs.getInt("cantidad"));
                p.setPrecioUnitario(rs.getDouble("precioUnitario"));
                p.setPrecioTotal(rs.getDouble("precioTotal"));
                p.setIdBoleta(rs.getString("idBoleta"));
                p.setIdProducto(rs.getString("idProducto"));             
             }
         }catch(Exception e){
             e.printStackTrace();
         }finally{
             this.conn.close();
         }
        return p;
    }    

}