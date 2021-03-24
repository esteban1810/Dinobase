package controlador;

import view.paleontologo.PaleontologoIndex;
import view.paleontologo.PaleontologoForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.ConsultasPaleontologo;
import clase.Paleontologo;
import javax.swing.JTextField;

public class PaleontologoCtrl implements ActionListener {

    private static String cedula;
    
    private Paleontologo paleontologo;
    private ConsultasPaleontologo paleontologoModelo;
    private MenuCtrl menuCtrl;
    private PaleontologoIndex peloentologoIndex;
    private PaleontologoForm peloentologoForm;
    
    private DefaultTableModel modelo;
    private ArrayList<Paleontologo> lista;
    
    private JTextField nombre;

    public PaleontologoCtrl() {
        this.paleontologo = new Paleontologo();
        this.paleontologoModelo = new ConsultasPaleontologo();

        peloentologoIndex = new PaleontologoIndex();
        peloentologoForm = new PaleontologoForm();
        modelo = new DefaultTableModel();
        menuCtrl = new MenuCtrl();
        lista = new ArrayList();

        this.peloentologoIndex.buscarBtn.addActionListener(this);
        this.peloentologoIndex.mostrarBtn.addActionListener(this);
        this.peloentologoIndex.nuevoBtn.addActionListener(this);
        this.peloentologoIndex.todoBtn.addActionListener(this);
        this.peloentologoIndex.selecBtn.addActionListener(this);
        this.peloentologoIndex.regresarBtn.addActionListener(this);
        this.peloentologoIndex.setLocationRelativeTo(null);

        this.peloentologoForm.registrarBtn.addActionListener(this);
        this.peloentologoForm.eliminarBtn.addActionListener(this);
        this.peloentologoForm.limpiarBtn.addActionListener(this);
        this.peloentologoForm.modificarBtn.addActionListener(this);
        this.peloentologoForm.regresarBtn.addActionListener(this);
        this.peloentologoForm.setLocationRelativeTo(null);
        paleontologoModelo.todosPaleontologos(lista);
        cargarTabla();
    }
    
    public PaleontologoCtrl(JTextField nombre) {
        this();
        this.nombre = nombre;
    }


    public void iniciar() {
        peloentologoIndex.setVisible(true);
        peloentologoIndex.setTitle("Paleontologos");
        peloentologoIndex.setLocationRelativeTo(null);
    }

    public static String getCedula() {
        return cedula;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == peloentologoForm.registrarBtn) {
            presionarRegistrarBtn();
        } else
            
        if (e.getSource() == peloentologoIndex.todoBtn) {
            paleontologoModelo.todosPaleontologos(lista);
            cargarTabla();
        } else 
            
        if (e.getSource() == peloentologoIndex.mostrarBtn) {
            presionarMostrarBtn();
        } else 
        
        if (e.getSource() == peloentologoForm.modificarBtn) {
            presionarModificarBtn();
        } else 
        
        if (e.getSource() == peloentologoForm.eliminarBtn) {
            presionarEliminarBtn();
        } else 
        
        if (e.getSource() == peloentologoIndex.nuevoBtn) {
            presionarNuevoBtn();
        } else 
        
        if (peloentologoForm.regresarBtn == e.getSource()) {
            presionarRegresarBtn();
        } else 
        
        if (e.getSource() == peloentologoIndex.buscarBtn) {
            presionarBuscarBtn();
        } else 
        
        if (e.getSource() == peloentologoIndex.selecBtn) {
            presionarSelecBtn();
        } else 
        
        if (e.getSource() == peloentologoForm.limpiarBtn) {
            limpiar();
        } else 
        
        if (e.getSource() == peloentologoIndex.regresarBtn) {
            peloentologoIndex.setVisible(false);
            menuCtrl.iniciar();
            menuCtrl.desbloquear(menuCtrl.getNickname());

        }

    }

    public void limpiar() {
        peloentologoForm.nombreTF.setText(null);
        peloentologoForm.apellidosTF.setText(null);
        peloentologoForm.cedulaTF.setText(null);
        peloentologoForm.fechaN.setDate(null);
    }

    public void cargarTabla() {
        modelo = new DefaultTableModel();
        peloentologoIndex.tablaPaleontologos.setModel(modelo);

        modelo.addColumn("Cedula");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Fecha de nacimiento");

        Object[] fila = new Object[14];

        for (int i = 0; i < lista.size(); i++) {
            fila = lista.get(i).arreglo();
            modelo.addRow(fila);
        }
    }

    public void limpiarTabla() {
        int filas = modelo.getRowCount();
        System.out.println(modelo.getRowCount());
        for (int i = 0; filas > i; i++) {
            modelo.removeRow(0);
        }
    }

    public boolean validaciones() {
        if (this.peloentologoForm.cedulaTF.getText().length() <= 29 && this.peloentologoForm.cedulaTF.getText().length() > 0) {
            if (!this.peloentologoForm.cedulaTF.getText().matches("[A-Z0-9]+")) {
                JOptionPane.showMessageDialog(null, "Error al capturar la cedula, inténtelo de nuevo.");
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error al capturar la cedula, inténtelo de nuevo.");
            return false;
        }
        if(!this.peloentologoForm.nombreTF.getText().matches("^([A-Za-záéíóúÑÁÉÍÓÚñ]+[\\s]?[A-Za-zÁÉÍÓÚñáéíóúÑ]+[\\s]?[A-Za-zÁÉÍÓÚñáéíóúÑ]+)$")){
            JOptionPane.showMessageDialog(null, "Error al capturar Nombre, inténtelo de nuevo.");
            return false;
        }
        
        if(!this.peloentologoForm.apellidosTF.getText().matches("^([A-Za-záéíóúÑÁÉÍÓÚñ]+[\\s]?[A-Za-zÁÉÍÓÚñáéíóúÑ]+[\\s]?[A-Za-zÁÉÍÓÚñáéíóúÑ]+)$")){
            JOptionPane.showMessageDialog(null, "Error al capturar Apellidos, inténtelo de nuevo.");
            return false;
        }
        
        
        if (this.peloentologoForm.fechaN.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Error al capturar fecha, inténtelo de nuevo.");
            return false;
        }

        return true;
    }

    private void presionarRegistrarBtn() {
        paleontologo.setNombre(peloentologoForm.nombreTF.getText());
        paleontologo.setApellidos(peloentologoForm.apellidosTF.getText());
        paleontologo.setCedula(peloentologoForm.cedulaTF.getText());
        paleontologo.setFechaN(new Date(peloentologoForm.fechaN.getDate().getTime()));
        if (!this.validaciones()) {
            return;
        }
        if (paleontologoModelo.registrar(paleontologo)) {
            JOptionPane.showMessageDialog(null, "Registro Guardado");
        } else {
            JOptionPane.showMessageDialog(null, "Error al guardar");
        }
        limpiar();
    }

    private void presionarMostrarBtn() {
        int fila = peloentologoIndex.tablaPaleontologos.getSelectedRow();
        this.peloentologoForm.registrarBtn.setVisible(false);
        this.peloentologoForm.modificarBtn.setVisible(true);
        this.peloentologoForm.eliminarBtn.setVisible(true);
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione alguna fila");
            return;
        }
        paleontologo.setCedula(peloentologoIndex.tablaPaleontologos.getValueAt(fila, 0).toString());
        paleontologoModelo.buscar(paleontologo);
        peloentologoForm.setVisible(true);
        peloentologoIndex.setVisible(false);
        peloentologoForm.cedulaTF.setText(paleontologo.getCedula());
        peloentologoForm.nombreTF.setText(paleontologo.getNombre());
        peloentologoForm.apellidosTF.setText(paleontologo.getApellidos());
        peloentologoForm.fechaN.setDate(paleontologo.getFechaN());
    }

    private void presionarModificarBtn() {
        String ced = paleontologo.getCedula();
        peloentologoForm.setVisible(true);
        peloentologoIndex.setVisible(false);
        paleontologo.setCedula(peloentologoForm.cedulaTF.getText());
        paleontologo.setNombre(peloentologoForm.nombreTF.getText());
        paleontologo.setApellidos(peloentologoForm.apellidosTF.getText());
        paleontologo.setFechaN(new Date(peloentologoForm.fechaN.getDate().getTime()));
        if (paleontologoModelo.modificar(paleontologo, ced)) {
            JOptionPane.showMessageDialog(null, "Registro modificado");
        } else {
            JOptionPane.showMessageDialog(null, "Error al modificar");
        }
        peloentologoForm.setVisible(false);
        peloentologoIndex.setVisible(true);
        peloentologoForm.setVisible(false);
        limpiarTabla();
        paleontologoModelo.todosPaleontologos(lista);
        cargarTabla();
        limpiar();
    }

    private void presionarEliminarBtn() {
        paleontologo.setCedula(peloentologoForm.cedulaTF.getText());

        if (paleontologoModelo.eliminar(paleontologo)) {
            JOptionPane.showMessageDialog(null, "Registro Eliminado");
        } else {
            JOptionPane.showMessageDialog(null, "Error al eliminar");
        }
        peloentologoForm.setVisible(false);
        peloentologoIndex.setVisible(true);
        peloentologoForm.setVisible(false);
        limpiarTabla();
        paleontologoModelo.todosPaleontologos(lista);
        cargarTabla();
        limpiar();
    }

    private void presionarNuevoBtn() {
        peloentologoIndex.setVisible(false);
        peloentologoForm.setVisible(true);
        peloentologoForm.eliminarBtn.setVisible(false);
        peloentologoForm.modificarBtn.setVisible(false);
        peloentologoForm.registrarBtn.setVisible(true);
//            limpiar();
    }

    private void presionarRegresarBtn() {
        peloentologoForm.setVisible(false);
        peloentologoIndex.setVisible(true);
        peloentologoForm.setVisible(false);
        limpiarTabla();
        paleontologoModelo.todosPaleontologos(lista);
        cargarTabla();
        limpiar();
    }

    private void presionarBuscarBtn() {
        String cadenaBuscada = peloentologoIndex.buscarTF.getText();
        
        if(cadenaBuscada.isEmpty()){
            return;
        }
        
        lista.clear();
        limpiarTabla();
        
        lista = paleontologoModelo.coincidencias(cadenaBuscada);
        
        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se encontraron coincidencias");
            return;
        }
        
        cargarTabla();
    }

    private void presionarSelecBtn() {
        int fila = peloentologoIndex.tablaPaleontologos.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione alguna fila");
            return;
        }
        cedula = peloentologoIndex.tablaPaleontologos.getValueAt(fila, 0).toString();
        nombre.setText(cedula);
        peloentologoIndex.setVisible(false);
    }
}
