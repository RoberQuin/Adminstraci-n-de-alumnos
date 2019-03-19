/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alumnos;

import java.sql.Connection;
import java.sql.Statement;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Programa de adminstración de alumnos.
 *
 * @author Rober Quin
 */
public class Alumnos extends Application {

     static Connection conn = null;
     static Statement s = null;

     /**
      * Este método llama a la interfaz gráfica y la pone en ejecución.
      *
      * @param stage
      * @throws Exception
      */
     @Override
     public void start(Stage stage) throws Exception {
          Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

          Scene scene = new Scene(root);

          stage.setScene(scene);
          stage.show();
     }

     /**
      * @param args the command line arguments
      */
     public static void main(String[] args) {
          launch(args);
     }

}
