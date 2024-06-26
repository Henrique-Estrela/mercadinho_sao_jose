/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views;

import Controller.AtendimentoController;
import Controller.ClienteController;
import Models.Cliente;
import Models.FilaAtendimento;
import Utils.ComboItem;
import java.util.ArrayList;
import java.util.Queue;

/**
 *
 * @author Vinicius
 */
public class JPAtender extends javax.swing.JPanel {

    /**
     * Creates new form JPClientes
     */
   
    private final ClienteController clienteController;
    private final AtendimentoController atendimentoController;

    public JPAtender() {
        initComponents();
        //
        this.clienteController = new ClienteController();
        this.atendimentoController = new AtendimentoController();
        //        
    }
    
    public void refresh() {
        updateDados();
    }

    private void updateDados() {
        jCCliente.removeAllItems();
        jTFCodigo.setText("");
        jTFNome.setText("");
        jTFCodigo1.setText("");
        jTFNome1.setText("");
        jTFCodigo2.setText("");
        jTFNome2.setText("");
        jTFCodigo3.setText("");
        jTFNome3.setText("");

        ArrayList<Cliente> clientes = clienteController.consultarClienteForaFila();
        for (Cliente c : clientes) {
            jCCliente.addItem(new ComboItem(c.getId(), c.getNome()));
        }

        Integer index = 0;
        Queue<FilaAtendimento> filaAtendimentos = atendimentoController.consultarFila();
        for (FilaAtendimento f : filaAtendimentos) {
            if (index == 0) {
                jTFCodigo.setText(f.getIdFila().toString());
                jTFNome.setText(f.getCliente().getNome());
            } else if (index == 1) {
                jTFCodigo1.setText(f.getIdFila().toString());
                jTFNome1.setText(f.getCliente().getNome());
            } else if (index == 2) {
                jTFCodigo2.setText(f.getIdFila().toString());
                jTFNome2.setText(f.getCliente().getNome());
            } else if (index == 3) {
                jTFCodigo3.setText(f.getIdFila().toString());
                jTFNome3.setText(f.getCliente().getNome());
            } else if (index == 4) {
                break;
            }
            index++;

        }
    }
        /**
         * This method is called from within the constructor to initialize the
         * form. WARNING: Do NOT modify this code. The content of this method is
         * always regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTFNome = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTFCodigo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jBAtenderP = new javax.swing.JButton();
        jBAdFila = new javax.swing.JButton();
        jCCliente = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jTFNome1 = new javax.swing.JTextField();
        jTFCodigo1 = new javax.swing.JTextField();
        jTFCodigo2 = new javax.swing.JTextField();
        jTFNome2 = new javax.swing.JTextField();
        jTFNome3 = new javax.swing.JTextField();
        jTFCodigo3 = new javax.swing.JTextField();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Fila de Atendimento");
        jPanel1.add(jLabel4);

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setToolTipText("");
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Nome");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 40, 20));

        jTFNome.setEditable(false);
        jTFNome.setToolTipText("");
        jPanel2.add(jTFNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 370, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel5.setText("Próximos clientes...");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, 200, 20));
        jLabel5.getAccessibleContext().setAccessibleName("Atender");

        jTFCodigo.setEditable(false);
        jTFCodigo.setToolTipText("");
        jPanel2.add(jTFCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 110, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Código");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 50, 20));

        jBAtenderP.setBackground(new java.awt.Color(0, 153, 255));
        jBAtenderP.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jBAtenderP.setText("Atender Cliente");
        jBAtenderP.setBorder(null);
        jBAtenderP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAtenderPActionPerformed(evt);
            }
        });
        jPanel2.add(jBAtenderP, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 190, 70));

        jBAdFila.setBackground(new java.awt.Color(0, 153, 255));
        jBAdFila.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jBAdFila.setText("Adicionar Cliente");
        jBAdFila.setBorder(null);
        jBAdFila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAdFilaActionPerformed(evt);
            }
        });
        jPanel2.add(jBAdFila, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 390, 190, 30));

        jCCliente.setEditable(true);
        jCCliente.setToolTipText("");
        jPanel2.add(jCCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 350, 190, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel6.setText("Cliente a ser atendido...");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 250, 20));

        jTFNome1.setEditable(false);
        jTFNome1.setToolTipText("");
        jPanel2.add(jTFNome1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, 370, 30));

        jTFCodigo1.setEditable(false);
        jTFCodigo1.setToolTipText("");
        jPanel2.add(jTFCodigo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 110, 30));

        jTFCodigo2.setEditable(false);
        jTFCodigo2.setToolTipText("");
        jPanel2.add(jTFCodigo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 110, 30));

        jTFNome2.setEditable(false);
        jTFNome2.setToolTipText("");
        jPanel2.add(jTFNome2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, 370, 30));

        jTFNome3.setEditable(false);
        jTFNome3.setToolTipText("");
        jPanel2.add(jTFNome3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, 370, 30));

        jTFCodigo3.setEditable(false);
        jTFCodigo3.setToolTipText("");
        jPanel2.add(jTFCodigo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 110, 30));

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jBAtenderPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAtenderPActionPerformed
        // TODO add your handling code here:                            
        atendimentoController.atenderDaFila();
        updateDados();
    }//GEN-LAST:event_jBAtenderPActionPerformed

    private void jBAdFilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAdFilaActionPerformed
        // TODO add your handling code here:
        atendimentoController.adicionarCliente(((ComboItem) jCCliente.getModel().getSelectedItem()).getKey());
        updateDados();
    }//GEN-LAST:event_jBAdFilaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAdFila;
    private javax.swing.JButton jBAtenderP;
    private javax.swing.JComboBox<ComboItem> jCCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTFCodigo;
    private javax.swing.JTextField jTFCodigo1;
    private javax.swing.JTextField jTFCodigo2;
    private javax.swing.JTextField jTFCodigo3;
    private javax.swing.JTextField jTFNome;
    private javax.swing.JTextField jTFNome1;
    private javax.swing.JTextField jTFNome2;
    private javax.swing.JTextField jTFNome3;
    // End of variables declaration//GEN-END:variables
}
