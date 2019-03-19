package alumnos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion implements DAO{

     private Connection conn;
     private String host;
     private String db;
     private String username;
     private String password;

     private static Conexion conexion;

     /**
      * Constructor de la clase conexión. Establece la conección.
      */
     public Conexion() {
          host = "localhost";
          db = "alumnos";
          username = "root"; //LO MEJOR ES INCLUIR OTRO USUARIO
          password = "123456";
          //regresa un objeto del tipo especificado, com.mysql.jdbc.Driver es la clase que implementa java.sql.Driver
          try {
               Class.forName("com.mysql.jdbc.Driver").newInstance();
               //Intentamos conectarnos a la base de Datos 
               System.out.println("Conectando a la base...");
               String url = "jdbc:mysql://" + host + "/" + db + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
               //jdbc:mysql://localhost/tintoreria                
               conn = DriverManager.getConnection(url, username, password);
               System.out.println("Conexion a BD establecida");
          } catch (SQLException ex) {
               System.out.println("Error de mysql" + ex);
          } catch (ClassNotFoundException e) {
               e.printStackTrace();
          } catch (Exception e) {
               System.out.println("Se produjo un error inesperado: " + e.getMessage());

          }
          conexion = this;
     }

     /**
      * Constructor de la clase Conexión. Establece la conexión con los parámetros que reciba
      *
      * @param host ubicación
      * @param db Nombre de la base de datos
      * @param username Nombre de usuario
      * @param password Contraseña de la base de datos
      * @throws ClassNotFoundException Excepción lanzada si no encuantra el usuario
      * @throws SQLException Excepción que lanza si la base de datos no se conecta correctamente
      */
     public Conexion(String host, String db, String username, String password) throws ClassNotFoundException, SQLException {
          Class.forName("com.mysql.jdbc.Driver");
          this.host = host;
          this.db = db;
          this.username = username;
          this.password = password;
          conn = DriverManager.getConnection("jdbc:mysql://" + host + "/" + db, username, password);
          conexion = this;
     }

     public String getHost() {
          return host;
     }

     public void setHost(String host) {
          this.host = host;
     }

     public String getDb() {
          return db;
     }

     public void setDb(String db) {
          this.db = db;
     }

     public String getUsername() {
          return username;
     }

     public void setUsername(String username) {
          this.username = username;
     }

     public String getPassword() {
          return password;
     }

     public void setPassword(String password) {
          this.password = password;
     }

     public Connection getConnection() {
          return conn;
     }

     /**
      * Cierra la conexión con la base de datos.
      */
     @Override
     public void close() {
          try {
               conn.close();
          } catch (SQLException e) {
               System.err.println("Error: " + e.getMessage() + "\n" + e.getErrorCode());
          }
     }

     public static Conexion getConexion() {
          return conexion;
     }

     public static void setConexion(Conexion conexion) {
          Conexion.conexion = conexion;
     }
}
