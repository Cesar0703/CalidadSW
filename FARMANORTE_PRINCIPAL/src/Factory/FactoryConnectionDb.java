package Factory;

public class FactoryConnectionDb {
 public static String[] configMSsql={"farmacia2","Cesar","12345"};
 public static String Mensaje = "Control de Ventas";
 public static String usuario = "";
 public static String idUsuario = "";
 public static String contrasenia = "";
 public static String idEmpleado = "";
 public static int idioma = 0;
 public static ConnectionDb Open(){
     return new MSsqlConnectionFactory(configMSsql);
 }
}