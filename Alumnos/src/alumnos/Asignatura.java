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
public class Asignatura {
     private String nrc;
     private String nombre;
     private String creditos;
     private String teoría;
     private String práctica;

     public Asignatura(String nrc, String nombre, String creditos, String teoría, String práctica) {
          this.nrc = nrc;
          this.nombre = nombre;
          this.creditos = creditos;
          this.teoría = teoría;
          this.práctica = práctica;
     }

     public Asignatura() {
     }

     public String getNrc() {
          return nrc;
     }

     public void setNrc(String nrc) {
          this.nrc = nrc;
     }

     public String getNombre() {
          return nombre;
     }

     public void setNombre(String nombre) {
          this.nombre = nombre;
     }

     public String getCreditos() {
          return creditos;
     }

     public void setCreditos(String creditos) {
          this.creditos = creditos;
     }

     public String getTeoría() {
          return teoría;
     }

     public void setTeoría(String teoría) {
          this.teoría = teoría;
     }

     public String getPráctica() {
          return práctica;
     }

     public void setPráctica(String práctica) {
          this.práctica = práctica;
     }
     
     
}
