/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alumnos;

/**
 *
 * @author Rober Quin
 */
public class Alumno {

     private String matricula;
     private String nombre;
     private String paterno;
     private String materno;

     /**
      * Constructor de la clase Alumno
      *
      * @param matricula Número de identidad del alumno
      * @param nombre Nombre del alumno
      * @param paterno Apellido paterno del alumno
      * @param materno Apellido materno del alumno
      */
     public Alumno(String matricula, String nombre, String paterno, String materno) {
          this.matricula = matricula;
          this.nombre = nombre;
          this.paterno = paterno;
          this.materno = materno;
     }

     public Alumno() {

     }

     public String getMatricula() {
          return matricula;
     }

     public void setMatricula(String matricula) {
          this.matricula = matricula;
     }

     public String getNombre() {
          return nombre;
     }

     public void setNombre(String nombre) {
          this.nombre = nombre;
     }

     public String getPaterno() {
          return paterno;
     }

     public void setPaterno(String paterno) {
          this.paterno = paterno;
     }

     public String getMaterno() {
          return materno;
     }

     public void setMaterno(String materno) {
          this.materno = materno;
     }

}
