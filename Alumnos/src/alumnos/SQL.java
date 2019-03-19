/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alumnos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import static alumnos.Alumnos.conn;

/**
 *
 * @author Rober Quin
 */
public class SQL {

     /**
      * Recibe todos los datos que requieren del alumno y lo inserta en la tabla y guarda en la base
      * de datos
      *
      * @param matricula Número de identificación del alumno.
      * @param nombre Nombre propio del alumno.
      * @param paterno Apellido paterno del alumno
      * @param materno Apellido materno del alumno
      * @return >= 0 si el proceso es exitoso, -1 si falla
      * @throws SQLException Excepción que lanza si no se conecta correctamente con la base de datos
      */
     public static int insertaCliente(String matricula, String nombre, String paterno, String materno) throws SQLException {
          String sentencia;
          //el id es autoincremental
          sentencia = "insert into matriculado (Matricula,Nombre,Paterno,Materno) values('"
                  + matricula + "','" + nombre + "','" + paterno + "','" + materno + "');";
          System.out.println(sentencia);
          try {
               conn = new Conexion().getConnection();
               Statement s = conn.createStatement();
               //updtae para sentencias INSERT, UPDATE O DELETE, que no regresan un conjunto de resultados 	       
               return s.executeUpdate(sentencia); //regresa 0 o el número de filas afectadas  si todo ok
          } catch (SQLException e) {
               System.err.println("Error: " + e.getMessage() + "\n" + e.getErrorCode());
          } finally {
               conn.close();
          }
          //si llegó a este punto quiere decir que lanzó una excepción
          return -1;  //regresar -1 si hay error
     }

     /**
      * Crea una lista con los datos que se necesitan para llenar la tabla
      *
      * @return Lista con datos
      * @throws SQLException Excepción que lanza si la base de datos no se conecta correctamente
      */
     public static List<String> llenarTabla() throws SQLException {//(4) este metodo es el que devuelve la lista
          List<String> listaAlumnos = new ArrayList<>();
          Statement s;
          Connection conn = null;
          conn = new Conexion().getConnection();//(5) este metodo conecta a la bd
          ResultSet rs = null;
          String sQuery = "select * from matriculado;";
          try {
               s = conn.createStatement();
               //s1 = conn.createStatement (ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
               rs = s.executeQuery(sQuery);
               System.out.println("Ejecutó la consulta");
               //llenamos la lista
               while (rs != null && rs.next()) {
                    listaAlumnos.add(rs.getString("Matricula"));
                    listaAlumnos.add(rs.getString("Nombre"));
                    listaAlumnos.add(rs.getString("Paterno"));
                    listaAlumnos.add(rs.getString("Materno"));
               }
          } catch (SQLException e) {
               System.err.println("Error: " + e.getMessage() + "\n" + e.getErrorCode());
          } finally {
               conn.close();
          }
          return listaAlumnos;
     }

     /**
      * Elimina un registro de la base de datos según la matrícula que reciba
      *
      * @param matricula Número de identificación del alumno
      * @return 0 si el proceso es exitoso, -1 si el proceso falla
      * @throws SQLException Excepción que lanza si la base de datos no se conecta correctamente
      */
     public static int eliminarRegistro(String matricula) throws SQLException {
          Statement s;
          Connection conn = null;
          conn = new Conexion().getConnection();
          String sentencia = "delete from matriculado where Matricula = '" + matricula + "'";
          try {
               s = conn.createStatement();
               s.executeUpdate(sentencia);
               return 0;
          } catch (SQLException e) {
               System.err.println("Error: " + e.getMessage() + "\n" + e.getErrorCode());
          } finally {
               conn.close();
          }
          return -1;
     }
     
     public static int insertaAsignatura(String nrc, String nombre, String creditos, String teoria, String practica) throws SQLException{
          String sentencia;
          //el id es autoincremental
          sentencia = "insert into Asignatura (nrc,nombre,creditos,teoria,practica) values('"
                  + nrc + "','" + nombre + "','" + creditos + "','" + teoria + "','" + practica + "');";
          System.out.println(sentencia);
          try {
               conn = new Conexion().getConnection();
               Statement s = conn.createStatement();
               //updtae para sentencias INSERT, UPDATE O DELETE, que no regresan un conjunto de resultados 	       
               return s.executeUpdate(sentencia); //regresa 0 o el número de filas afectadas  si todo ok
          } catch (SQLException e) {
               System.err.println("Error: " + e.getMessage() + "\n" + e.getErrorCode());
          } finally {
               conn.close();
          }
          //si llegó a este punto quiere decir que lanzó una excepción
          return -1;
     }
     
     public static int eliminarAsignatura(String nrc) throws SQLException {
          Statement s;
          Connection conn = null;
          conn = new Conexion().getConnection();
          String sentencia = "delete from matriculado where nrc = '" + nrc + "'";
          try {
               s = conn.createStatement();
               s.executeUpdate(sentencia);
               return 0;
          } catch (SQLException e) {
               System.err.println("Error: " + e.getMessage() + "\n" + e.getErrorCode());
          } finally {
               conn.close();
          }
          return -1;
     }
}

