package alumnos;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class FXMLDocumentController {

     @FXML
     private ResourceBundle resources;

     @FXML
     private URL location;

     @FXML
     private TableColumn<Alumno, String> ColumnNombre;

     @FXML
     private Button buttonAgregar;

     @FXML
     private Button buttonEditar;

     @FXML
     private Button buttonEliminar;

     @FXML
     private Button buttonGuardar;

     @FXML
     private Button buttonLimpiar;

     @FXML
     private TableColumn<Alumno, String> columnMaterno;

     @FXML
     private TableColumn<Alumno, String> columnMatricula;

     @FXML
     private TableColumn<Alumno, String> columnPaterno;

     @FXML
     private TextField fieldMaterno;

     @FXML
     private TextField fieldMatricula;

     @FXML
     private TextField fieldNombre;

     @FXML
     private TextField fieldPaterno;

     @FXML
     private Label labelMatero;

     @FXML
     private Label labelMatrícula;

     @FXML
     private Label labelNombre;

     @FXML
     private Label labelPaterno;

     @FXML
     private TableView<Alumno> tableAlumnos;

     @FXML
     private Button buttonTerminar;

     @FXML
     private Button buttonSi;

     @FXML
     private Button buttonNo;

     @FXML
     private TextArea textAreaConfirmacion;

     @FXML
     private ObservableList<Integer> alumno;

     @FXML
     private MenuBar menuVentanas;

     @FXML
     private Menu menuAsignaturas;

     @FXML
     private MenuItem abrirVentana;

     /**
      * Este metodo hace visible el fomulario de datos del alumno y los botones de opciones para el
      * agregado
      *
      * @param event Evento producido al hacer clic en el botón "Agregar"
      */
     @FXML
     void agregarAlumno(ActionEvent event) {
          labelMatrícula.setVisible(true);
          labelNombre.setVisible(true);
          labelPaterno.setVisible(true);
          labelMatero.setVisible(true);
          fieldMatricula.setVisible(true);
          fieldNombre.setVisible(true);
          fieldPaterno.setVisible(true);
          fieldMaterno.setVisible(true);
          buttonGuardar.setVisible(true);
          buttonLimpiar.setVisible(true);
     }

     /**
      * Borra los datos que hay en el formulario
      *
      * @param event Evento producido al hacer clic en el botón "Limpiar"
      */
     @FXML
     void limpiarCampos(ActionEvent event) {
          fieldMatricula.setText("");
          fieldNombre.setText("");
          fieldPaterno.setText("");
          fieldMaterno.setText("");
     }

     /**
      * Este método toma los datos puestos en los campos de registro y crea con ello un nuevo
      * alumno. Lo guarda en la base de datos y lo agrega a la tabla
      *
      * @param event Evento producido al hacer clic en el botón "Guardar"
      */
     @FXML
     void llenarDatosAlumno(ActionEvent event) {
          columnMatricula.setCellValueFactory(new PropertyValueFactory("matricula"));
          ColumnNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
          columnPaterno.setCellValueFactory(new PropertyValueFactory("paterno"));
          columnMaterno.setCellValueFactory(new PropertyValueFactory("materno"));
          Alumno nuevo = new Alumno(fieldMatricula.getText(), fieldNombre.getText(), fieldPaterno.getText(), fieldMaterno.getText());
          try {
               SQL.insertaCliente(fieldMatricula.getText(), fieldNombre.getText(), fieldPaterno.getText(), fieldMaterno.getText());
               tableAlumnos.getItems().addAll(nuevo);
               //llenarTablaClientes();
          } catch (SQLException ex) {
               Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
          }
          labelMatrícula.setVisible(false);
          labelNombre.setVisible(false);
          labelPaterno.setVisible(false);
          labelMatero.setVisible(false);
          fieldMatricula.setVisible(false);
          fieldNombre.setVisible(false);
          fieldPaterno.setVisible(false);
          fieldMaterno.setVisible(false);
          buttonGuardar.setVisible(false);
          buttonLimpiar.setVisible(false);
          fieldMatricula.setText("");
          fieldNombre.setText("");
          fieldPaterno.setText("");
          fieldMaterno.setText("");
     }

     /**
      * Este método extrae de la base de datos todos los datos de los alumnos guardados y los
      * ingresa a la tabla.
      */
     @FXML
     void cargarDatos() {

          List<String> listaAlumnos = null;
          List<Alumno> listaAgregar = null;
          try {
               listaAlumnos = SQL.llenarTabla();
          } catch (SQLException ex) {
               Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
          }
          columnMatricula.setCellValueFactory(new PropertyValueFactory("matricula"));
          ColumnNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
          columnPaterno.setCellValueFactory(new PropertyValueFactory("paterno"));
          columnMaterno.setCellValueFactory(new PropertyValueFactory("materno"));

          while (!listaAlumnos.isEmpty()) {
               Alumno datos = new Alumno();
               datos.setMatricula(listaAlumnos.remove(0));
               datos.setNombre(listaAlumnos.remove(0));
               datos.setPaterno(listaAlumnos.remove(0));
               datos.setMaterno(listaAlumnos.remove(0));
               tableAlumnos.getItems().addAll(datos);

          }
     }

     /**
      * Este método extrae los datos del registro de la tabla que se ha seleccionado y los pone en
      * un formulario para su edición
      *
      * @param evt Evento producido al hacer clic en el botón "Editar"
      */
     @FXML
     void editarDatos(ActionEvent evt) {
          Alumno editable = tableAlumnos.getSelectionModel().getSelectedItem();
          labelMatrícula.setVisible(true);
          labelNombre.setVisible(true);
          labelPaterno.setVisible(true);
          labelMatero.setVisible(true);
          fieldMatricula.setVisible(true);
          fieldMatricula.setText(editable.getMatricula());
          fieldNombre.setVisible(true);
          fieldNombre.setText(editable.getNombre());
          fieldPaterno.setVisible(true);
          fieldPaterno.setText(editable.getPaterno());
          fieldMaterno.setVisible(true);
          fieldMaterno.setText(editable.getMaterno());
          buttonTerminar.setVisible(true);
          //tableAlumnos.getSelectionModel().
          try {
               SQL.eliminarRegistro(fieldMatricula.getText());
          } catch (SQLException e) {
               System.err.println("Error: " + e.getMessage() + "\n" + e.getErrorCode());
          }
          tableAlumnos.getSelectionModel().getSelectedItem().setMaterno("");
          tableAlumnos.getSelectionModel().getSelectedItem().setMatricula("");
          tableAlumnos.getSelectionModel().getSelectedItem().setPaterno("");
          tableAlumnos.getSelectionModel().getSelectedItem().setNombre("");
          tableAlumnos.sort();
     }

     /**
      * Este método toma los datos del formulario y actualiza al estudiante seleccionado con dichos
      * datos.
      *
      * @param e Evento producido al hacer clic en el botón "Terminar"
      */
     @FXML
     void actualizarAlumno(ActionEvent e) {
          columnMatricula.setCellValueFactory(new PropertyValueFactory("matricula"));
          ColumnNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
          columnPaterno.setCellValueFactory(new PropertyValueFactory("paterno"));
          columnMaterno.setCellValueFactory(new PropertyValueFactory("materno"));
          Alumno actualizado = new Alumno(fieldMatricula.getText(), fieldNombre.getText(), fieldPaterno.getText(), fieldMaterno.getText());
          try {
               SQL.insertaCliente(fieldMatricula.getText(), fieldNombre.getText(), fieldPaterno.getText(), fieldMaterno.getText());
               tableAlumnos.getItems().addAll(actualizado);
               //llenarTablaClientes();
          } catch (SQLException ex) {
               Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
          }
          //cargarDatos();
          tableAlumnos.refresh();
          labelMatrícula.setVisible(false);
          labelNombre.setVisible(false);
          labelPaterno.setVisible(false);
          labelMatero.setVisible(false);
          fieldMatricula.setVisible(false);
          fieldNombre.setVisible(false);
          fieldPaterno.setVisible(false);
          fieldMaterno.setVisible(false);
          buttonTerminar.setVisible(false);
     }

     /**
      * Elimina la información del registro seleccionado de la tabla y de la base de datos.
      *
      * @param e Evento producido al hacer clic en el botón "Eliminar"
      * @throws SQLException Excepción de mala conexión a la base de datos.
      */
     @FXML
     void eliminarAlumno(ActionEvent e) throws SQLException {
          Alumno eliminable = tableAlumnos.getSelectionModel().getSelectedItem();
          /*alumno = tableAlumnos.getSelectionModel().getSelectedIndices();
          alumno.remove(tableAlumnos.getSelectionModel().getSelectedIndex());*/
          try {
               SQL.eliminarRegistro(eliminable.getMatricula());
          } catch (SQLException exp) {
               System.err.println("Error: " + exp.getMessage() + "\n" + exp.getErrorCode());
          }
          tableAlumnos.getSelectionModel().getSelectedItem().setMaterno("");
          tableAlumnos.getSelectionModel().getSelectedItem().setMatricula("");
          tableAlumnos.getSelectionModel().getSelectedItem().setPaterno("");
          tableAlumnos.getSelectionModel().getSelectedItem().setNombre("");
     }

     /**
      *
      * @param e
      */
     @FXML
     void abrirVentana(ActionEvent e) {
          try {
               FXMLLoader loader = new FXMLLoader(getClass().getResource("VentanaAsignaturas.fxml"));
               Parent root = (Parent) loader.load();
               Stage stage = new Stage();
               stage.setScene(new Scene(root));
               stage.show();
          } catch (IOException ex) {
               System.out.println("No se abrió ventana");
               System.err.println(ex);
          }

     }

     /**
      * Inicializa e invoca al método que llena la tabla.
      */
     @FXML
     void initialize() {
          assert ColumnNombre != null : "fx:id=\"ColumnNombre\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
          assert buttonAgregar != null : "fx:id=\"buttonAgregar\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
          assert buttonEditar != null : "fx:id=\"buttonEditar\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
          assert buttonEliminar != null : "fx:id=\"buttonEliminar\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
          assert buttonGuardar != null : "fx:id=\"buttonGuardar\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
          assert buttonLimpiar != null : "fx:id=\"buttonLimpiar\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
          assert columnMaterno != null : "fx:id=\"columnMaterno\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
          assert columnMatricula != null : "fx:id=\"columnMatricula\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
          assert columnPaterno != null : "fx:id=\"columnPaterno\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
          assert fieldMaterno != null : "fx:id=\"fieldMaterno\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
          assert fieldMatricula != null : "fx:id=\"fieldMatricula\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
          assert fieldNombre != null : "fx:id=\"fieldNombre\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
          assert fieldPaterno != null : "fx:id=\"fieldPaterno\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
          assert labelMatero != null : "fx:id=\"labelMatero\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
          assert labelMatrícula != null : "fx:id=\"labelMatrícula\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
          assert labelNombre != null : "fx:id=\"labelNombre\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
          assert labelPaterno != null : "fx:id=\"labelPaterno\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
          cargarDatos();

     }

     private void launch() {
          throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     }

}
