package dao;

import Factory.ConnectionDb;
import Factory.FactoryConnectionDb;
import model.cProductos;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductoDaoImp implements ProductoDao{
    ConnectionDb conn;
    public ProductoDaoImp(){
         this.conn = FactoryConnectionDb.Open();
    }
    @Override
    public List<cProductos> list(String q) {
        List<cProductos> _list = new ArrayList<>();
        try
        {   StringBuilder query = new StringBuilder();
            query.append("select * from producto where nomProducto like '%").
                    append(q).append("%' ORDER BY nomProducto DESC");
            ResultSet rs = conn.query(query.toString());
            while(rs.next()) {
                cProductos p = new cProductos();
                p.setIdProducto(rs.getString("idProducto"));
                p.setNomProducto(rs.getString("nomProducto"));
                p.setFechEmision(rs.getString("fechEmision"));
                p.setFechVencimiento(rs.getString("fechVencimiento"));
                p.setDescripcionProducto(rs.getString("descripcionProducto"));
                p.setStock(rs.getInt("stock"));
                p.setPrecOriginal(rs.getDouble("precOriginal"));
                p.setPrecVenta(rs.getDouble("precVenta"));
                p.setIdProveedor(rs.getString("idProveedor"));
                p.setIdLaboratorio(rs.getString("idLaboratorio"));
                p.setIdCategoria(rs.getString("idCategoria"));
                _list.add(p);
            }
        }
        catch(Exception ex){
            System.out.println("Error: "+ex.getMessage());
        }
        return _list;
    }

    @Override
    public boolean insertar(cProductos p) {        
        boolean grabado = false;
            try{
                StringBuilder sql = new StringBuilder();
                sql.append("insert into producto (nomProducto,fechEmision,fechVencimiento,"
                        + "descripcionProducto,stock,precOriginal,precVenta,idProveedor,"
                        + "idLaboratorio,idCategoria) "
                        + "values (");
                sql.append("'"); sql.append(p.getNomProducto());sql.append("',");
                sql.append("'"); sql.append(p.getFechEmision());sql.append("',");
                sql.append("'"); sql.append(p.getFechVencimiento());sql.append("',");
                sql.append("'"); sql.append(p.getDescripcionProducto());sql.append("',");
                sql.append(p.getStock());sql.append(",");
                sql.append(p.getPrecOriginal());sql.append(",");
                sql.append(p.getPrecVenta());sql.append(",");
                sql.append(p.getIdProveedor());sql.append(",");
                sql.append(p.getIdLaboratorio());sql.append(",");
                sql.append(p.getIdCategoria());sql.append(")");                
                
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
    public boolean modificar(cProductos p) {        
        boolean grabado = false;
            try{
                StringBuilder sql = new StringBuilder();
                sql.append("update producto set ").
                append("nomProducto='").append(p.getNomProducto()).append("',").
                append("fechEmision='").append(p.getFechEmision()).append("',").
                append("fechVencimiento='").append(p.getFechVencimiento()).append("',").
                append("descripcionProducto='").append(p.getDescripcionProducto()).append("',").
                append("stock=").append(p.getStock()).append(",").
                append("precOriginal=").append(p.getPrecOriginal()).append(",").
                append("precVenta=").append(p.getPrecVenta()).append(",").
                append("idProveedor=").append(p.getIdProveedor()).append(",").
                append("idLaboratorio=").append(p.getIdLaboratorio()).append(",").
                append("idCategoria=").append(p.getIdCategoria()).
                append(" where idProducto=");sql.append(p.getIdProducto());                 
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
    public boolean eliminar(int idProducto) {        
        boolean f = false;
        try
        {
            StringBuilder query = new StringBuilder();
            query.append("delete from producto WHERE idProducto=").
                    append(idProducto);
            f = conn.execute(query.toString());
        }catch(Exception ex)
        {
            System.out.println("Error: "+ex.getMessage());
        }
        return f;
    }

    @Override
    public cProductos buscar(int idProducto) {        
        cProductos p = new cProductos();
        StringBuilder sql = new StringBuilder();
        sql.append("select * from producto where idproducto=");
        sql.append(idProducto);
        try{
             ResultSet rs = this.conn.query(sql.toString());
             while(rs.next()){
                p.setIdProducto(rs.getString("idProducto"));
                p.setNomProducto(rs.getString("nomProducto"));
                p.setFechEmision(rs.getString("fechEmision"));
                p.setFechVencimiento(rs.getString("fechVencimiento"));
                p.setDescripcionProducto(rs.getString("descripcionProducto"));
                p.setStock(rs.getInt("stock"));
                p.setPrecOriginal(rs.getDouble("precOriginal"));
                p.setPrecVenta(rs.getDouble("precVenta"));
                p.setIdProveedor(rs.getString("idProveedor"));
                p.setIdLaboratorio(rs.getString("idLaboratorio"));
                p.setIdCategoria(rs.getString("idCategoria"));               
             }
         }catch(Exception e){
             e.printStackTrace();
         }
        return p;
    }    

    @Override
    public boolean restarStock(int Producto, int cantidad) {
        boolean grabado = false;
            try{
                StringBuilder sql = new StringBuilder();
                sql.append("update producto set ").
                append("stock=stock-").append(cantidad).
                append(" where idProducto=");sql.append(Producto);                 
                this.conn.execute(sql.toString()); 
            }catch(Exception e){
                 e.printStackTrace();
                 grabado = false;
            }
        return grabado;
    }

}