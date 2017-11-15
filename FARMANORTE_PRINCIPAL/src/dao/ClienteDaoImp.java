package dao;

import Factory.ConnectionDb;
import Factory.FactoryConnectionDb;
import model.cClientes;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDaoImp implements ClienteDao{
    ConnectionDb conn;
    public ClienteDaoImp(){
         this.conn = FactoryConnectionDb.Open();
    }
    @Override
    public List<cClientes> list(String q) {
        List<cClientes> _list = new ArrayList<>();
        try
        {   StringBuilder query = new StringBuilder();
            query.append("select * from cliente where nomCliente like '%").
                    append(q).append("%' ORDER BY nomCliente DESC");
            ResultSet rs = conn.query(query.toString());
            while(rs.next()) {
                cClientes p = new cClientes("","","","","","","","","","");
                p.setCod(rs.getString("idCliente"));
                p.setNombre(rs.getString("nomCliente"));
                p.setApe_paterno(rs.getString("apePaCliente"));
                p.setApe_materno(rs.getString("apeMaCliente"));
                p.setFechNacimiento(rs.getString("fecNacCliente"));
                p.setDNI(rs.getString("dniCliente"));
                p.setSexo(rs.getString("sexoCliente"));
                p.setDireccion(rs.getString("direccionCliente"));
                p.setTelefono(rs.getString("telfCliente"));
                p.setEmail(rs.getString("emailCliente"));
                _list.add(p);
                
            }
        }
        catch(Exception ex){
            System.out.println("Error: "+ex.getMessage());
        }
        return _list;
    }

    @Override
    public boolean insertar(cClientes p) {        
        boolean grabado = false;
            try{
                StringBuilder sql = new StringBuilder();
                sql.append("insert into cliente (nomCliente,apePaCliente,apeMaCliente,"
                        + "fecNacCliente,dniCliente,sexoCliente,direccionCliente,telfCliente,"
                        + "emailCliente) "
                        + "values (");
                sql.append("'"); sql.append(p.getNombre());sql.append("',");
                sql.append("'"); sql.append(p.getApe_paterno());sql.append("',");
                sql.append("'"); sql.append(p.getApe_materno());sql.append("',");
                sql.append("'"); sql.append(p.getFechNacimiento());sql.append("',");
                sql.append("'");sql.append(p.getDNI());sql.append("',");
                sql.append("'");sql.append(p.getSexo());sql.append("',");
                sql.append("'");sql.append(p.getDireccion());sql.append("',");
                sql.append("'");sql.append(p.getTelefono());sql.append("',");
                sql.append("'");sql.append(p.getEmail());sql.append("')");                
                
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
    public boolean modificar(cClientes p) {        
        boolean grabado = false;
            try{
                StringBuilder sql = new StringBuilder();
                sql.append("update cliente set ").
                append("nomCliente='").append(p.getNombre()).append("',").
                append("apePaCliente='").append(p.getApe_paterno()).append("',").
                append("apeMaCliente='").append(p.getApe_materno()).append("',").
                append("fecNacCliente='").append(p.getFechNacimiento()).append("',").
                append("dniCliente='").append(p.getDNI()).append("',").
                append("sexoCliente='").append(p.getSexo()).append("',").
                append("direccionCliente='").append(p.getDireccion()).append("',").
                append("telfCliente='").append(p.getTelefono()).append("',").
                append("emailCliente='").append(p.getEmail()).append("'").
                append(" where idCliente=");sql.append(p.getCod());                 
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
    public boolean eliminar(int idCliente) {        
        boolean f = false;
        try
        {
            StringBuilder query = new StringBuilder();
            query.append("delete from cliente WHERE idCliente=").
                    append(idCliente);
            f = conn.execute(query.toString());
        }catch(Exception ex)
        {
            System.out.println("Error: "+ex.getMessage());
        }
        return f;
    }

    @Override
    public cClientes buscar(int idCliente) {        
        cClientes p = new cClientes("","","","","","","","","","");
        StringBuilder sql = new StringBuilder();
        sql.append("select * from cliente where idCliente=");
        sql.append(idCliente);
        try{
             ResultSet rs = this.conn.query(sql.toString());
             while(rs.next()){
                p.setCod(rs.getString("idCliente"));
                p.setNombre(rs.getString("nomCliente"));
                p.setApe_paterno(rs.getString("apePaCliente"));
                p.setApe_materno(rs.getString("apeMaCliente"));
                p.setFechNacimiento(rs.getString("fecNacCliente"));
                p.setDNI(rs.getString("dniCliente"));
                p.setSexo(rs.getString("sexoCliente"));
                p.setDireccion(rs.getString("direccionCliente"));
                p.setTelefono(rs.getString("telfCliente"));
                p.setEmail(rs.getString("emailCliente"));           
             }
         }catch(Exception e){
             e.printStackTrace();
         }
        return p;
    }    

}