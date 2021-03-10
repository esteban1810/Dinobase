package controlador;

import view.paleontologo.PaleontologoIndex;
import view.paleontologo.PaleontologoForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.ConsultasPaleontologo;
import modelo.ConsultasTaxonomia;
import clase.Paleontologo;
import clase.Taxonomia;

public class PaleontologoCtrl implements ActionListener {

    private static String cedula;
    private Paleontologo mod;
    private ConsultasPaleontologo modC;
    private PaleontologoIndex frm;
    private PaleontologoForm frmReg;
    private MenuCtrl ctrlM;
    private DefaultTableModel modelo;
    private ArrayList<Paleontologo> lista;
    private boolean tax;

    public PaleontologoCtrl(Paleontologo mod, ConsultasPaleontologo modC) {
        this.mod = mod;
        this.modC = modC;

        frm = new PaleontologoIndex();
        frmReg = new PaleontologoForm();
        modelo = new DefaultTableModel();
        ctrlM = new MenuCtrl();
        lista = new ArrayList();

        this.frm.buscarBtn.addActionListener(this);
        this.frm.mostrarBtn.addActionListener(this);
        this.frm.nuevoBtn.addActionListener(this);
        this.frm.todoBtn.addActionListener(this);
        this.frm.selecBtn.addActionListener(this);
        this.frm.regresarBtn.addActionListener(this);
        this.frm.setLocationRelativeTo(null);

        this.frmReg.registrarBtn.addActionListener(this);
        this.frmReg.eliminarBtn.addActionListener(this);
        this.frmReg.limpiarBtn.addActionListener(this);
        this.frmReg.modificarBtn.addActionListener(this);
        this.frmReg.regresarBtn.addActionListener(this);
        this.frmReg.setLocationRelativeTo(null);
//        this.frmReg.fechaN.setEnabled(false);
        modC.todosPaleontologos(lista);
        cargarTabla();
    }

    public PaleontologoCtrl(Paleontologo mod, ConsultasPaleontologo modC, boolean tax) {
        this(mod, modC);
        this.tax = tax;
        cedula = "NaN";
    }

    public void iniciar() {
        frm.setVisible(true);
        frm.setTitle("Paleontologos");
        frm.setLocationRelativeTo(null);
    }

    public static String getCedula() {
        return cedula;
    }

    public void actionPerformed(ActionEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (e.getSource() == frmReg.registrarBtn) {
            mod.setNombre(frmReg.nombreTF.getText());
            mod.setApellidos(frmReg.apellidosTF.getText());
            mod.setCedula(frmReg.cedulaTF.getText());
            mod.setFechaN(new Date(frmReg.fechaN.getDate().getTime()));
            if (!this.validaciones()) {
                return;
            }
            if (modC.registrar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar");
            }
            limpiar();
        } else if (e.getSource() == frm.todoBtn) {
            modC.todosPaleontologos(lista);
            cargarTabla();
        } else if (e.getSource() == frm.mostrarBtn) {
            int fila = frm.tablaPaleontologos.getSelectedRow();
            this.frmReg.registrarBtn.setVisible(false);
            this.frmReg.modificarBtn.setVisible(true);
            this.frmReg.eliminarBtn.setVisible(true);
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione alguna fila");
                return;
            }
            mod.setCedula(frm.tablaPaleontologos.getValueAt(fila, 0).toString());
            modC.buscar(mod);
            frmReg.setVisible(true);
            frm.setVisible(false);
            frmReg.cedulaTF.setText(mod.getCedula());
            frmReg.nombreTF.setText(mod.getNombre());
            frmReg.apellidosTF.setText(mod.getApellidos());
            frmReg.fechaN.setDate(mod.getFechaN());
        } else if (e.getSource() == frmReg.modificarBtn) {
            String ced = mod.getCedula();
            System.out.println("no pasa");
            frmReg.setVisible(true);
            frm.setVisible(false);
            mod.setCedula(frmReg.cedulaTF.getText());
            mod.setNombre(frmReg.nombreTF.getText());
            mod.setApellidos(frmReg.apellidosTF.getText());
            mod.setFechaN(new Date(frmReg.fechaN.getDate().getTime()));
            if (modC.modificar(mod, ced)) {
                JOptionPane.showMessageDialog(null, "Registro modificado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar");
            }
            frmReg.setVisible(false);
            frm.setVisible(true);
            frmReg.setVisible(false);
            limpiarTabla();
            modC.todosPaleontologos(lista);
            cargarTabla();
            limpiar();
        } else if (e.getSource() == frmReg.eliminarBtn) {
            mod.setCedula(frmReg.cedulaTF.getText());

            if (modC.eliminar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar");
            }
            frmReg.setVisible(false);
            frm.setVisible(true);
            frmReg.setVisible(false);
            limpiarTabla();
            modC.todosPaleontologos(lista);
            cargarTabla();
            limpiar();
        } //        
        else if (e.getSource() == frm.nuevoBtn) {
            frm.setVisible(false);
            frmReg.setVisible(true);
            frmReg.eliminarBtn.setVisible(false);
            frmReg.modificarBtn.setVisible(false);
            frmReg.registrarBtn.setVisible(true);
//            limpiar();
        } else if (frmReg.regresarBtn == e.getSource()) {
            frmReg.setVisible(false);
            frm.setVisible(true);
            frmReg.setVisible(false);
            limpiarTabla();
            modC.todosPaleontologos(lista);
            cargarTabla();
            limpiar();
        } else if (e.getSource() == frm.buscarBtn) {
            lista.clear();
            limpiarTabla();
            modC.coincidencias(lista, frm.buscarTF.getText());
            if (lista.size() == 0) {
                JOptionPane.showMessageDialog(null, "No se encontraron coincidencias");
                return;
            }
            cargarTabla();
        } else if (e.getSource() == frm.selecBtn) {
            int fila = frm.tablaPaleontologos.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione alguna fila");
                return;
            }
            cedula = frm.tablaPaleontologos.getValueAt(fila, 0).toString();
            frm.setVisible(false);
        } else if (e.getSource() == frmReg.limpiarBtn) {
            limpiar();

        } else if (e.getSource() == frm.regresarBtn) {
            frm.setVisible(false);
            ctrlM.iniciar();
            ctrlM.desbloquear(ctrlM.getNickname());

        }

    }

    public void limpiar() {
        frmReg.nombreTF.setText(null);
        frmReg.apellidosTF.setText(null);
        frmReg.cedulaTF.setText(null);
        frmReg.fechaN.setDate(null);
    }

    public void cargarTabla() {
        modelo = new DefaultTableModel();
        frm.tablaPaleontologos.setModel(modelo);

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
        if (this.frmReg.cedulaTF.getText().length() <= 29 && this.frmReg.cedulaTF.getText().length() > 0) {
            if (!this.frmReg.cedulaTF.getText().matches("[A-Z0-9]+")) {
                JOptionPane.showMessageDialog(null, "Error al capturar la cedula, inténtelo de nuevo.");
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error al capturar la cedula, inténtelo de nuevo.");
            return false;
        }
        if(!this.frmReg.nombreTF.getText().matches("^([A-Za-záéíóúÑÁÉÍÓÚñ]+[\\s]?[A-Za-zÁÉÍÓÚñáéíóúÑ]+[\\s]?[A-Za-zÁÉÍÓÚñáéíóúÑ]+)$")){
            JOptionPane.showMessageDialog(null, "Error al capturar Nombre, inténtelo de nuevo.");
            return false;
        }
        
        if(!this.frmReg.apellidosTF.getText().matches("^([A-Za-záéíóúÑÁÉÍÓÚñ]+[\\s]?[A-Za-zÁÉÍÓÚñáéíóúÑ]+[\\s]?[A-Za-zÁÉÍÓÚñáéíóúÑ]+)$")){
            JOptionPane.showMessageDialog(null, "Error al capturar Apellidos, inténtelo de nuevo.");
            return false;
        }
        
        
        if (this.frmReg.fechaN.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Error al capturar fecha, inténtelo de nuevo.");
            return false;
        }

        return true;
    }
}
