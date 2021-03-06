/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Estructuras.Matriz;
import Estructuras.Nodo_Matriz;
import javax.swing.JOptionPane;

/**
 *
 * @author Denis
 */
public class Eliminar extends javax.swing.JFrame {

    /**
     * Creates new form Eliminar
     */
    public Matriz Tablero;
    public String saludo = "a";

    public Eliminar() {
        initComponents();
    }

    Eliminar(Matriz Tablero) {
        initComponents();
        this.Tablero = Tablero;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BtEliminar = new javax.swing.JButton();
        CbFormato = new javax.swing.JComboBox();
        BtCancelar = new javax.swing.JButton();
        TxEliminar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        BtEliminar.setText("Eliminar");
        BtEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtEliminarActionPerformed(evt);
            }
        });

        CbFormato.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Fila", "Columna" }));

        BtCancelar.setText("Cancelar");
        BtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CbFormato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CbFormato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtEliminar)
                    .addComponent(BtCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtEliminarActionPerformed
        String a = TxEliminar.getText();
        //Tablero.Raiz=new Nodo_Matriz(35,45);
        if (a.length() != 0 && isNumeric(a)) {
            int indice = Integer.parseInt(a);
            if (CbFormato.getSelectedItem().toString().equals("Fila") && Verificar(indice, "Fila")) {
                Tablero.eliminarFila(indice);
                //System.out.println("Se Puede");
                JOptionPane.showMessageDialog(null, "Fila Eliminada Exitosamente");
                this.dispose();
            } else if (Verificar(indice, "Columna")) {
                Tablero.eliminarColumna(indice);
                //System.out.println("Se Puede");
                JOptionPane.showMessageDialog(null, "Columna Eliminada Exitosamente");
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo realizar esta accion");
                //System.out.println("No se Puede");
            }
        }
    }//GEN-LAST:event_BtEliminarActionPerformed

    private void BtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_BtCancelarActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Eliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Eliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Eliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Eliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Eliminar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtCancelar;
    private javax.swing.JButton BtEliminar;
    private javax.swing.JComboBox CbFormato;
    private javax.swing.JTextField TxEliminar;
    // End of variables declaration//GEN-END:variables
    private boolean isNumeric(String str) {
        {
            try {
                double d = Double.parseDouble(str);
            } catch (NumberFormatException nfe) {
                return false;
            }
            return true;
        }
    }

    private boolean Verificar(int indice, String Tipo) {
        Nodo_Matriz Aux1 = Tablero.Raiz;
        if (Tipo.equals("Fila")) {
            while (Aux1 != null && Aux1.Y != indice) {
                Aux1 = Aux1.abajo;
            }
            if (Aux1 != null) {
                while (Aux1 != null) {
                    if (Aux1.Objeto != null && (Aux1.Objeto.tipo.equals("Principal") || Aux1.Objeto.tipo.equals("Castillo"))) {
                        return false;
                    }
                    Aux1 = Aux1.derecha;
                }
            } else {
                return false;
            }
        } else {
            while (Aux1 != null && Aux1.X != indice) {
                Aux1 = Aux1.derecha;
            }
            if (Aux1 != null) {
                while (Aux1 != null) {
                    if (Aux1.Objeto != null && (Aux1.Objeto.tipo.equals("Principal") || Aux1.Objeto.tipo.equals("Castillo"))) {
                        return false;
                    }
                    Aux1 = Aux1.abajo;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
