package reporte;

import Factory.ConnectionDb;
import Factory.FactoryConnectionDb;
import java.sql.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.*;
import java.util.HashMap;
import java.util.Map;
public class CReporte{
    ConnectionDb cnn;
    public CReporte(){
        cnn = FactoryConnectionDb.Open();
        
    }
    private void ReporteTodo(String NombreReporte)
    {   
    try {
            String[] params = FactoryConnectionDb.configMSsql;
            Connection cn =(DriverManager.getConnection("jdbc:sqlserver://localhost;database="+params[0]
                                                +";user="+params[1]+";password="+params[2]+";"));
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");    
            
//            Connection cn =(DriverManager.getConnection("jdbc:mysql://localhost/"+params[0],params[1],params[2]));
//            Class.forName("com.mysql.jdbc.Driver");
            
            
            try
            {            
             String master = System.getProperty("user.dir") +"/src/reporte/" + NombreReporte;
            
            if (master == null) 
            {                
                System.out.println("No encuentro el archivo del reporte maestro.");
                System.exit(2);
            } 

            JasperReport masterReport = null;
            try 
            {
                masterReport = (JasperReport) JRLoader.loadObject(master);
            } 
            catch (JRException e) 
            {
                System.out.println("Error cargando el reporte maestro: " + e.getMessage());
                System.exit(3);
            }              
//            Map parametro = new HashMap();
//            parametro.put("id",id_contact);           
            JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport,null,cn);
            JasperViewer jviewer = new JasperViewer(jasperPrint,false);
            jviewer.setTitle(NombreReporte);
            jviewer.setVisible(true);
            cnn.close();
        }
        catch (Exception j)
        {
            System.out.println("Mensaje de Error:"+j.getMessage());
        }
         cnn.close();    
        }
        catch(SQLException ex) {
           System.out.println ("\n*** SQLException caught ***\n");
            while (ex != null) {
		System.out.println ("SQLState: " +
				ex.getSQLState ());
		System.out.println ("Message:  " + ex.getMessage ());
		System.out.println ("Vendor:   " +
				ex.getErrorCode ());
		ex = ex.getNextException ();
		}
        }
        catch (java.lang.Exception ex) {
		ex.printStackTrace ();
	}
    }
    private void ReporteCon1Parametro(String NombreReporte,String par1)
    {        
    try {
            String[] params = FactoryConnectionDb.configMSsql;
            Connection cn =(DriverManager.getConnection("jdbc:sqlserver://localhost;database="+params[0]
                                                +";user="+params[1]+";password="+params[2]+";"));
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");    
            
//            Connection cn =(DriverManager.getConnection("jdbc:mysql://localhost/"+params[0],params[1],params[2]));
//            Class.forName("com.mysql.jdbc.Driver");
            
            
            try
            {            
             String master = System.getProperty("user.dir") +"/src/reporte/" + NombreReporte;
            
            if (master == null) 
            {                
                System.out.println("No encuentro el archivo del reporte maestro.");
                System.exit(2);
            } 

            JasperReport masterReport = null;
            try 
            {
                masterReport = (JasperReport) JRLoader.loadObject(master);
            } 
            catch (JRException e) 
            {
                System.out.println("Error cargando el reporte maestro: " + e.getMessage());
                System.exit(3);
            }              
            Map parametro = new HashMap();
            parametro.put("idBoleta",par1);           
            JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport,parametro,cn);
            JasperViewer jviewer = new JasperViewer(jasperPrint,false);
            jviewer.setTitle(NombreReporte);
            jviewer.setVisible(true);
            cnn.close();
        }
        catch (Exception j)
        {
            System.out.println("Mensaje de Error:"+j.getMessage());
        }
         cnn.close();    
        }
        catch(SQLException ex) {
           System.out.println ("\n*** SQLException caught ***\n");
            while (ex != null) {
		System.out.println ("SQLState: " +
				ex.getSQLState ());
		System.out.println ("Message:  " + ex.getMessage ());
		System.out.println ("Vendor:   " +
				ex.getErrorCode ());
		ex = ex.getNextException ();
		}
        }
        catch (java.lang.Exception ex) {
		ex.printStackTrace ();
	}
    }
    private void ReporteCon3Parametro(String NombreReporte,String dato1,String dato2,String dato3)
    {try {
            String[] params = FactoryConnectionDb.configMSsql;
            Connection cn =(DriverManager.getConnection("jdbc:sqlserver://localhost;database="+params[0]
                                                +";user="+params[1]+";password="+params[2]+";"));
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");    
            
//            Connection cn =(DriverManager.getConnection("jdbc:mysql://localhost/"+params[0],params[1],params[2]));
//            Class.forName("com.mysql.jdbc.Driver");
            
            
            try
            {            
             String master = System.getProperty("user.dir") +"/src/reporte/" + NombreReporte;
            
            if (master == null) 
            {                
                System.out.println("No encuentro el archivo del reporte maestro.");
                System.exit(2);
            } 

            JasperReport masterReport = null;
            try 
            {
                masterReport = (JasperReport) JRLoader.loadObject(master);
            } 
            catch (JRException e) 
            {
                System.out.println("Error cargando el reporte maestro: " + e.getMessage());
                System.exit(3);
            }              
            Map parametro = new HashMap();
            parametro.put("dato1",dato1);
            parametro.put("dato2",dato2);
            parametro.put("dato3",dato3);            
            JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport,parametro,cn);
            JasperViewer jviewer = new JasperViewer(jasperPrint,false);
            jviewer.setTitle(NombreReporte);
            jviewer.setVisible(true);
            cnn.close();
        }
        catch (Exception j)
        {
            System.out.println("Mensaje de Error:"+j.getMessage());
        }
         cnn.close();    
        }
        catch(SQLException ex) {
           System.out.println ("\n*** SQLException caught ***\n");
            while (ex != null) {
		System.out.println ("SQLState: " +
				ex.getSQLState ());
		System.out.println ("Message:  " + ex.getMessage ());
		System.out.println ("Vendor:   " +
				ex.getErrorCode ());
		ex = ex.getNextException ();
		}
        }
        catch (java.lang.Exception ex) {
		ex.printStackTrace ();
	}
    }
    private void ReporteCon2Parametro(String NombreReporte,String dato1,String dato2)
    {try {
            String[] params = FactoryConnectionDb.configMSsql;
            Connection cn =(DriverManager.getConnection("jdbc:sqlserver://localhost;database="+params[0]
                                                +";user="+params[1]+";password="+params[2]+";"));
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");    
            
//            Connection cn =(DriverManager.getConnection("jdbc:mysql://localhost/"+params[0],params[1],params[2]));
//            Class.forName("com.mysql.jdbc.Driver");
            
            
            try
            {            
             String master = System.getProperty("user.dir") +"/src/reporte/" + NombreReporte;
            
            if (master == null) 
            {                
                System.out.println("No encuentro el archivo del reporte maestro.");
                System.exit(2);
            } 

            JasperReport masterReport = null;
            try 
            {
                masterReport = (JasperReport) JRLoader.loadObject(master);
            } 
            catch (JRException e) 
            {
                System.out.println("Error cargando el reporte maestro: " + e.getMessage());
                System.exit(3);
            }              
            Map parametro = new HashMap();
            parametro.put("dato1",dato1);
            parametro.put("dato2",dato2);          
            JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport,parametro,cn);
            JasperViewer jviewer = new JasperViewer(jasperPrint,false);
            jviewer.setTitle(NombreReporte);
            jviewer.setVisible(true);
            cnn.close();
        }
        catch (Exception j)
        {
            System.out.println("Mensaje de Error:"+j.getMessage());
        }
         cnn.close();    
        }
        catch(SQLException ex) {
           System.out.println ("\n*** SQLException caught ***\n");
            while (ex != null) {
		System.out.println ("SQLState: " +
				ex.getSQLState ());
		System.out.println ("Message:  " + ex.getMessage ());
		System.out.println ("Vendor:   " +
				ex.getErrorCode ());
		ex = ex.getNextException ();
		}
        }
        catch (java.lang.Exception ex) {
		ex.printStackTrace ();
	}
    }

    public void imprimirBoleta(String idBoleta)
    {
         ReporteCon1Parametro("boleta.jasper",idBoleta);
    }
    public void imprimirBoletaPorFecha(String idCliente,String desde,String hasta)
    {
         ReporteCon3Parametro("boletaClienteFech.jasper",idCliente,desde,hasta);
    }

    public void imprimirBoletaPorIntervaloFecha(String fechaE, String fechaV) {

        ReporteCon2Parametro("reporteBoletaIntervaloFecha.jasper",fechaE,fechaV);
    }
    public void imprimirEmpleado(){
        ReporteTodo("reporteTrabajador.jasper");
    }

    public void reporteCargo() {
        ReporteTodo("reporteCargo.jasper");
    }
    public void reporteProveedor() {
        ReporteTodo("reporteProveedor.jasper");
    }
    public void reporteCategoria() {
        ReporteTodo("reporteCategoria.jasper");
    }

    public void reporteLaboratorio() {
        ReporteTodo("reporteLaboratorio.jasper");
    }

    public void reporteClientePorMayorCompra() {
        ReporteTodo("reporteClienteMonto.jasper");
    }

    public void reporteCliente() {
        ReporteTodo("reporteCliente.jasper");
    }

    public void reporteClienteCumpleanios() {
        ReporteTodo("reporteClienteCumpleanios.jasper");
    }

}
