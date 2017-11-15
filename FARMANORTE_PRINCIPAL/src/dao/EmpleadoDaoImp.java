package dao;

import Factory.ConnectionDb;
import Factory.FactoryConnectionDb;
import model.cEmpleados;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDaoImp implements EmpleadoDao{
    ConnectionDb conn;
    public EmpleadoDaoImp(){
         this.conn = FactoryConnectionDb.Open();
    }
    @Override
    public List<cEmpleados> list(String q) {
        List<cEmpleados> _list = new ArrayList<>();
        try
        {   StringBuilder query = new StringBuilder();
            query.append("select * from empleado where nomEmpleado like '%").
                    append(q).append("%' ORDER BY nomEmpleado DESC");
            ResultSet rs = conn.query(query.toString());
            while(rs.next()) {
                cEmpleados p = new cEmpleados("","","","","","","","","","","");
                p.setCod(rs.getString("idEmpleado"));
                p.setNombre(rs.getString("nomEmpleado"));
                p.setApe_paterno(rs.getString("apePaEmpleado"));
                p.setApe_materno(rs.getString("apeMaEmpleado"));
                p.setFechNacimiento(rs.getString("fecNacEmpleado"));
                p.setDNI(rs.getString("dniEmpleado"));
                p.setSexo(rs.getString("sexoEmpleado"));
                p.setDireccion(rs.getString("direccionEmpleado"));
                p.setTelefono(rs.getString("telfEmpleado"));
                p.setEmail(rs.getString("emailEmpleado"));
                p.setCargo(rs.getString("idCargo"));
                _list.add(p);
                
            }
        }
        catch(Exception ex){
            System.out.println("Error: "+ex.getMessage());
        }
        return _list;
    }

    @Override
    public boolean insertar(cEmpleados p) {        
        boolean grabado = false;
            try{
                StringBuilder sql = new StringBuilder();
                sql.append("insert into empleado (nomEmpleado,apePaEmpleado,apeMaEmpleado,"
                        + "fecNacEmpleado,dniEmpleado,sexoEmpleado,direccionEmpleado,telfEmpleado,"
                        + "emailEmpleado,idCargo) "
                        + "values (");
                sql.append("'"); sql.append(p.getNombre());sql.append("',");
                sql.append("'"); sql.append(p.getApe_paterno());sql.append("',");
                sql.append("'"); sql.append(p.getApe_materno());sql.append("',");
                sql.append("'"); sql.append(p.getFechNacimiento());sql.append("',");
                sql.append("'");sql.append(p.getDNI());sql.append("',");
                sql.append("'");sql.append(p.getSexo());sql.append("',");
                sql.append("'");sql.append(p.getDireccion());sql.append("',");
                sql.append("'");sql.append(p.getTelefono());sql.append("',");
                sql.append("'");sql.append(p.getEmail());sql.append("',");
                sql.append(p.getCargo());sql.append(")");                
                
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
    public boolean modificar(cEmpleados p) {        
        boolean grabado = false;
            try{
                StringBuilder sql = new StringBuilder();
                sql.append("update empleado set ").
                append("nomEmpleado='").append(p.getNombre()).append("',").
                append("apePaEmpleado='").append(p.getApe_paterno()).append("',").
                append("apeMaEmpleado='").append(p.getApe_materno()).append("',").
                append("fecNacEmpleado='").append(p.getFechNacimiento()).append("',").
                append("dniEmpleado='").append(p.getDNI()).append("',").
                append("sexoEmpleado='").append(p.getSexo()).append("',").
                append("direccionEmpleado='").append(p.getDireccion()).append("',").
                append("telfEmpleado='").append(p.getTelefono()).append("',").
                append("emailEmpleado='").append(p.getEmail()).append("',").
                append("idCargo=").append(p.getCargo()).
                append(" where idEmpleado=");sql.append(p.getCod());                 
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
            query.append("delete from empleado WHERE idEmpleado=").
                    append(idEmpleado);
            f = conn.execute(query.toString());
        }catch(Exception ex)
        {
            System.out.println("Error: "+ex.getMessage());
        }
        return f;
    }

    @Override
    public cEmpleados buscar(int idEmpleado) {        
        cEmpleados p = new cEmpleados("","","","","","","","","","","");
        StringBuilder sql = new StringBuilder();
        sql.append("select * from empleado where idEmpleado=");
        sql.append(idEmpleado);
        try{
             ResultSet rs = this.conn.query(sql.toString());
             while(rs.next()){
                p.setCod(rs.getString("idEmpleado"));
                p.setNombre(rs.getString("nomEmpleado"));
                p.setApe_paterno(rs.getString("apePaEmpleado"));
                p.setApe_materno(rs.getString("apeMaEmpleado"));
                p.setFechNacimiento(rs.getString("fecNacEmpleado"));
                p.setDNI(rs.getString("dniEmpleado"));
                p.setSexo(rs.getString("sexoEmpleado"));
                p.setDireccion(rs.getString("direccionEmpleado"));
                p.setTelefono(rs.getString("telfEmpleado"));
                p.setEmail(rs.getString("emailEmpleado"));
                p.setCargo(rs.getString("idCargo"));              
             }
         }catch(Exception e){
             e.printStackTrace();
         }finally{
             this.conn.close();
         }
        return p;
    }    

}