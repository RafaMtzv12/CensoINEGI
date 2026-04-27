/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.sql.*;
import javax.swing.table.DefaultTableModel;
import dao.Conexion;
import dao.ViviendaDAO;


/**
 *
 * @author RJMV
 */
public class ViviendaView extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ViviendaView.class.getName());

    /**
     * Creates new form ViviendaView
     */
    public ViviendaView() {
        initComponents();
        cbxTipoVivienda.removeAllItems();
        cargarTipos();
        cargarMunicipios();
        cargarLocalidades();  
        cargarActividades();
    }
    
    public void cargarTipos() {
        try {
            cbxTipoVivienda.removeAllItems();

            Connection conn = Conexion.getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM tipo_vivienda");

            while (rs.next()) {
                cbxTipoVivienda.addItem(
                    rs.getInt("id") + " - " + rs.getString("nombre")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void cargarMunicipios() {
        try {
            cbxMunicipio.removeAllItems();

            Connection conn = Conexion.getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM municipio");

            while (rs.next()) {
                cbxMunicipio.addItem(
                    rs.getInt("id") + " - " + rs.getString("nombre")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void cargarLocalidades() {
        try {
            cbxLocalidad.removeAllItems();

            Connection conn = Conexion.getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM localidad");

            while (rs.next()) {
                cbxLocalidad.addItem(
                    rs.getInt("id") + " - " + rs.getString("nombre")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void cargarActividades() {
        try {
            cbxActividad.removeAllItems();
            Connection conn = Conexion.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM actividad");

            while (rs.next()) {
                cbxActividad.addItem(rs.getInt("id") + " - " + rs.getString("nombre"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void cargarTabla() {
        System.out.println("CARGANDO TABLA...");
        try {
            Connection conn = Conexion.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM vivienda");

            DefaultTableModel modelo = new DefaultTableModel();

            modelo.addColumn("ID");
            modelo.addColumn("Tipo");
            modelo.addColumn("Municipio");
            modelo.addColumn("Localidad");

            while (rs.next()) {
                Object[] fila = new Object[4];
                fila[0] = rs.getInt("id");
                fila[1] = rs.getString("tipo");
                fila[2] = rs.getString("municipio");
                fila[3] = rs.getString("localidad");

                modelo.addRow(fila);
            }

            tablaViviendas.setModel(modelo);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbxTipoVivienda = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnListar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaViviendas = new javax.swing.JTable();
        cbxMunicipio = new javax.swing.JComboBox<>();
        cbxLocalidad = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cbxActividad = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cbxTipoVivienda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Tipo de vivienda:");

        jLabel2.setText("Municipio:");

        jLabel3.setText("Localidad:");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(this::btnGuardarActionPerformed);

        btnListar.setText("Listar");
        btnListar.addActionListener(this::btnListarActionPerformed);

        tablaViviendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaViviendas);

        cbxMunicipio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxLocalidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Actividad Economica:");

        cbxActividad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbxTipoVivienda, 0, 112, Short.MAX_VALUE)
                                    .addComponent(cbxMunicipio, 0, 112, Short.MAX_VALUE)
                                    .addComponent(cbxLocalidad, 0, 112, Short.MAX_VALUE)
                                    .addComponent(cbxActividad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnGuardar)
                                .addGap(64, 64, 64)
                                .addComponent(btnListar))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxTipoVivienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbxMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbxLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbxActividad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnListar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        try {
       if (cbxMunicipio.getSelectedItem() == null) {
           javax.swing.JOptionPane.showMessageDialog(this, "Selecciona un municipio");
           return;
       }

       if (cbxLocalidad.getSelectedItem() == null) {
           javax.swing.JOptionPane.showMessageDialog(this, "Selecciona una localidad");
           return;
       }

       if (cbxTipoVivienda.getSelectedItem() == null) {
           javax.swing.JOptionPane.showMessageDialog(this, "Selecciona un tipo de vivienda");
           return;
       }

       if (cbxActividad.getSelectedItem() == null) {
           javax.swing.JOptionPane.showMessageDialog(this, "Selecciona una actividad");
           return;
       }

       String selectedM = cbxMunicipio.getSelectedItem().toString();
       int municipio_id = Integer.parseInt(selectedM.split(" - ")[0]);

       String selectedL = cbxLocalidad.getSelectedItem().toString();
       int localidad_id = Integer.parseInt(selectedL.split(" - ")[0]);

       String selectedT = cbxTipoVivienda.getSelectedItem().toString();
       int tipo_id = Integer.parseInt(selectedT.split(" - ")[0]);

       String act = cbxActividad.getSelectedItem().toString();
       int actividad_id = Integer.parseInt(act.split(" - ")[0]);

       model.Vivienda v = new model.Vivienda();
       v.setTipoId(tipo_id);
       v.setMunicipioId(municipio_id);
       v.setLocalidadId(localidad_id);

       ViviendaDAO dao = new ViviendaDAO();
       int idVivienda = dao.insertar(v);

       if (idVivienda == 0) {
           javax.swing.JOptionPane.showMessageDialog(this, "Error al guardar vivienda");
           return;
       }

       Connection conn = Conexion.getConnection();

       PreparedStatement ps = conn.prepareStatement(
           "INSERT INTO vivienda_actividad(vivienda_id, actividad_id) VALUES (?,?)"
       );

       ps.setInt(1, idVivienda);
       ps.setInt(2, actividad_id);

       ps.executeUpdate();
       
       javax.swing.JOptionPane.showMessageDialog(this, "Registro guardado correctamente");

   } catch (Exception e) {
       e.printStackTrace();
       javax.swing.JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
   }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        cargarTabla();        // TODO add your handling code here:
    }//GEN-LAST:event_btnListarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new ViviendaView().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnListar;
    private javax.swing.JComboBox<String> cbxActividad;
    private javax.swing.JComboBox<String> cbxLocalidad;
    private javax.swing.JComboBox<String> cbxMunicipio;
    private javax.swing.JComboBox<String> cbxTipoVivienda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaViviendas;
    // End of variables declaration//GEN-END:variables
}
