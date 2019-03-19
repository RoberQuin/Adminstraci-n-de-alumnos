package alumnos;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
import javafx.scene.shape.Rectangle;


public class VentanaAsignaturasController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Asignatura, String> ColumnCreditos;

    @FXML
    private MenuItem abrirVentana;

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
    private Button buttonNo;

    @FXML
    private Button buttonSi;

    @FXML
    private Button buttonTerminar;

    @FXML
    private TableColumn<Asignatura, String> columnHorasPractica;

    @FXML
    private TableColumn<Asignatura, String> columnHorasTeoria;

    @FXML
    private TableColumn<Asignatura, String> columnNombreMateria;

    @FXML
    private TableColumn<Asignatura, String> columnNrc;

    @FXML
    private TextField fieldCreditos;

    @FXML
    private TextField fieldNombre;

    @FXML
    private TextField fieldNrc;

    @FXML
    private TextField fieldPractica;

    @FXML
    private TextField fieldTeoria;

    @FXML
    private Rectangle fondo;

    @FXML
    private Label labelCreditos;

    @FXML
    private Label labelNombre;

    @FXML
    private Label labelNrc;

    @FXML
    private Label labelPractica;

    @FXML
    private Label labelTeoria;

    @FXML
    private MenuBar menu;

    @FXML
    private TableView<Asignatura> tableAsignaturas;

    @FXML
    private TextArea textConfirmacion;

    @FXML
    private Menu ventanaAlumno;


    @FXML
    void actualizarAsignatura(ActionEvent event) {
         columnNrc.setCellValueFactory(new PropertyValueFactory("nrc"));
          columnNombreMateria.setCellValueFactory(new PropertyValueFactory("nombre"));
          columnHorasTeoria.setCellValueFactory(new PropertyValueFactory("teoria"));
          columnHorasPractica.setCellValueFactory(new PropertyValueFactory("practica"));
          ColumnCreditos.setCellValueFactory(new PropertyValueFactory("creditos"));
          Asignatura actualizado = new Asignatura(fieldNrc.getText(), fieldNombre.getText(), fieldCreditos.getText(), fieldPractica.getText(), fieldTeoria.getText());
          try {
               SQL.insertaAsignatura(fieldNrc.getText(), fieldNombre.getText(), fieldCreditos.getText(), fieldTeoria.getText(), fieldPractica.getText());
               tableAsignaturas.getItems().addAll(actualizado);
               //llenarTablaClientes();
          } catch (SQLException ex) {
               Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
          }
          //cargarDatos();
          tableAsignaturas.refresh();
          labelNrc.setVisible(false);
          labelNombre.setVisible(false);
          labelCreditos.setVisible(false);
          labelTeoria.setVisible(false);
          labelPractica.setVisible(false);
          fieldNrc.setVisible(false);
          fieldNombre.setVisible(false);
          fieldCreditos.setVisible(false);
          fieldTeoria.setVisible(false);
          fieldPractica.setVisible(false);
          buttonTerminar.setVisible(false);
    }

    @FXML
    void agregarAlumno(ActionEvent event) {
         labelNrc.setVisible(true);
          labelNombre.setVisible(true);
          labelCreditos.setVisible(true);
          labelTeoria.setVisible(true);
          labelPractica.setVisible(true);
          fieldNrc.setVisible(true);
          fieldNombre.setVisible(true);
          fieldCreditos.setVisible(true);
          fieldTeoria.setVisible(true);
          fieldPractica.setVisible(true);
          buttonGuardar.setVisible(true);
          buttonLimpiar.setVisible(true);
    }

    @FXML
    void editarDatos(ActionEvent event) {
         Asignatura editable = tableAsignaturas.getSelectionModel().getSelectedItem();
          labelNrc.setVisible(true);
          labelNombre.setVisible(true);
          labelCreditos.setVisible(true);
          labelTeoria.setVisible(true);
          labelPractica.setVisible(true);
          fieldNrc.setVisible(true);
          fieldNrc.setText(editable.getNrc());
          fieldNombre.setVisible(true);
          fieldNombre.setText(editable.getNombre());
          fieldCreditos.setVisible(true);
          fieldCreditos.setText(editable.getCreditos());
          fieldTeoria.setVisible(true);
          fieldTeoria.setText(editable.getTeoría());
          fieldPractica.setVisible(true);
          fieldPractica.setText(editable.getPráctica());
          buttonTerminar.setVisible(true);
          //tableAlumnos.getSelectionModel().
          try {
               SQL.eliminarAsignatura(fieldNrc.getText());
          } catch (SQLException e) {
               System.err.println("Error: " + e.getMessage() + "\n" + e.getErrorCode());
          }
          tableAsignaturas.getSelectionModel().getSelectedItem().setNrc("");
          tableAsignaturas.getSelectionModel().getSelectedItem().setCreditos("");
          tableAsignaturas.getSelectionModel().getSelectedItem().setTeoría("");
          tableAsignaturas.getSelectionModel().getSelectedItem().setNombre("");
          tableAsignaturas.getSelectionModel().getSelectedItem().setPráctica("");
          tableAsignaturas.sort();
    }

    @FXML
    void eliminarAlumno(ActionEvent event) {
         Asignatura eliminable = tableAsignaturas.getSelectionModel().getSelectedItem();
          /*alumno = tableAlumnos.getSelectionModel().getSelectedIndices();
          alumno.remove(tableAlumnos.getSelectionModel().getSelectedIndex());*/
          try {
               SQL.eliminarAsignatura(eliminable.getNrc());
          } catch (SQLException exp) {
               System.err.println("Error: " + exp.getMessage() + "\n" + exp.getErrorCode());
          }
          tableAsignaturas.getSelectionModel().getSelectedItem().setNrc("");
          tableAsignaturas.getSelectionModel().getSelectedItem().setCreditos("");
          tableAsignaturas.getSelectionModel().getSelectedItem().setTeoría("");
          tableAsignaturas.getSelectionModel().getSelectedItem().setNombre("");
          tableAsignaturas.getSelectionModel().getSelectedItem().setPráctica("");
    }

    @FXML
    void limpiarCampos(ActionEvent event) {
         fieldNrc.setText("");
          fieldNombre.setText("");
          fieldCreditos.setText("");
          fieldTeoria.setText("");
          fieldPractica.setText("");
    }

    @FXML
    void llenarDatosAlumno(ActionEvent event) {
         columnNrc.setCellValueFactory(new PropertyValueFactory("nrc"));
          columnNombreMateria.setCellValueFactory(new PropertyValueFactory("nombre"));
          ColumnCreditos.setCellValueFactory(new PropertyValueFactory("creditos"));
          columnHorasTeoria.setCellValueFactory(new PropertyValueFactory("teoría"));
          columnHorasPractica.setCellValueFactory(new PropertyValueFactory("práctica"));
          Asignatura nuevo = new Asignatura(fieldNrc.getText(), fieldNombre.getText(), fieldCreditos.getText(), fieldTeoria.getText(), fieldPractica.getText());
          try {
               SQL.insertaAsignatura(fieldNrc.getText(), fieldNombre.getText(), fieldCreditos.getText(), fieldTeoria.getText(), fieldPractica.getText());
               tableAsignaturas.getItems().addAll(nuevo);
               //llenarTablaClientes();
          } catch (SQLException ex) {
               Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
          }
          labelNrc.setVisible(false);
          labelNombre.setVisible(false);
          labelCreditos.setVisible(false);
          labelTeoria.setVisible(false);
          labelPractica.setVisible(false);
          fieldNrc.setVisible(false);
          fieldNombre.setVisible(false);
          fieldCreditos.setVisible(false);
          fieldTeoria.setVisible(false);
          fieldPractica.setVisible(false);
          buttonGuardar.setVisible(false);
          buttonLimpiar.setVisible(false);
          fieldNrc.setText("");
          fieldNombre.setText("");
          fieldCreditos.setText("");
          fieldTeoria.setText("");
          fieldPractica.setText("");
    }

    @FXML
    void initialize() {
        assert ColumnCreditos != null : "fx:id=\"ColumnCreditos\" was not injected: check your FXML file 'VentanaAsignaturas.fxml'.";
        assert abrirVentana != null : "fx:id=\"abrirVentana\" was not injected: check your FXML file 'VentanaAsignaturas.fxml'.";
        assert buttonAgregar != null : "fx:id=\"buttonAgregar\" was not injected: check your FXML file 'VentanaAsignaturas.fxml'.";
        assert buttonEditar != null : "fx:id=\"buttonEditar\" was not injected: check your FXML file 'VentanaAsignaturas.fxml'.";
        assert buttonEliminar != null : "fx:id=\"buttonEliminar\" was not injected: check your FXML file 'VentanaAsignaturas.fxml'.";
        assert buttonGuardar != null : "fx:id=\"buttonGuardar\" was not injected: check your FXML file 'VentanaAsignaturas.fxml'.";
        assert buttonLimpiar != null : "fx:id=\"buttonLimpiar\" was not injected: check your FXML file 'VentanaAsignaturas.fxml'.";
        assert buttonNo != null : "fx:id=\"buttonNo\" was not injected: check your FXML file 'VentanaAsignaturas.fxml'.";
        assert buttonSi != null : "fx:id=\"buttonSi\" was not injected: check your FXML file 'VentanaAsignaturas.fxml'.";
        assert buttonTerminar != null : "fx:id=\"buttonTerminar\" was not injected: check your FXML file 'VentanaAsignaturas.fxml'.";
        assert columnHorasPractica != null : "fx:id=\"columnHorasPractica\" was not injected: check your FXML file 'VentanaAsignaturas.fxml'.";
        assert columnHorasTeoria != null : "fx:id=\"columnHorasTeoria\" was not injected: check your FXML file 'VentanaAsignaturas.fxml'.";
        assert columnNombreMateria != null : "fx:id=\"columnNombreMateria\" was not injected: check your FXML file 'VentanaAsignaturas.fxml'.";
        assert columnNrc != null : "fx:id=\"columnNrc\" was not injected: check your FXML file 'VentanaAsignaturas.fxml'.";
        assert fieldCreditos != null : "fx:id=\"fieldCreditos\" was not injected: check your FXML file 'VentanaAsignaturas.fxml'.";
        assert fieldNombre != null : "fx:id=\"fieldNombre\" was not injected: check your FXML file 'VentanaAsignaturas.fxml'.";
        assert fieldNrc != null : "fx:id=\"fieldNrc\" was not injected: check your FXML file 'VentanaAsignaturas.fxml'.";
        assert fieldPractica != null : "fx:id=\"fieldPractica\" was not injected: check your FXML file 'VentanaAsignaturas.fxml'.";
        assert fieldTeoria != null : "fx:id=\"fieldTeoria\" was not injected: check your FXML file 'VentanaAsignaturas.fxml'.";
        assert fondo != null : "fx:id=\"fondo\" was not injected: check your FXML file 'VentanaAsignaturas.fxml'.";
        assert labelCreditos != null : "fx:id=\"labelCreditos\" was not injected: check your FXML file 'VentanaAsignaturas.fxml'.";
        assert labelNombre != null : "fx:id=\"labelNombre\" was not injected: check your FXML file 'VentanaAsignaturas.fxml'.";
        assert labelNrc != null : "fx:id=\"labelNrc\" was not injected: check your FXML file 'VentanaAsignaturas.fxml'.";
        assert labelPractica != null : "fx:id=\"labelPractica\" was not injected: check your FXML file 'VentanaAsignaturas.fxml'.";
        assert labelTeoria != null : "fx:id=\"labelTeoria\" was not injected: check your FXML file 'VentanaAsignaturas.fxml'.";
        assert menu != null : "fx:id=\"menu\" was not injected: check your FXML file 'VentanaAsignaturas.fxml'.";
        assert tableAsignaturas != null : "fx:id=\"tableAsignaturas\" was not injected: check your FXML file 'VentanaAsignaturas.fxml'.";
        assert textConfirmacion != null : "fx:id=\"textConfirmacion\" was not injected: check your FXML file 'VentanaAsignaturas.fxml'.";
        assert ventanaAlumno != null : "fx:id=\"ventanaAlumno\" was not injected: check your FXML file 'VentanaAsignaturas.fxml'.";


    }

}
