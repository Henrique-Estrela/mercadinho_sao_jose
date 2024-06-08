/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views;

import Controller.ClienteController;
import Models.Cliente;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Vinicius
 */
public class JPQuarto extends javax.swing.JPanel {

    /**
     * Creates new form JPClientes
     */
    private final ClienteController clienteController;
    private FormState formState;

    public JPQuarto() {
        initComponents();
        this.clienteController = new ClienteController();
        this.formState = FormState.SEARCH;
        //
        atualizarTabela();        
        updateButtons();
        //
        addListenerSelectionTable();
    }
    
    public void addListenerSelectionTable() {
        jTableCliente.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!jTableCliente.getSelectionModel().isSelectionEmpty()) {
                    updateEdits();
                }
            }
        });
    }
    
    public void updateButtons() {
        if (FormState.SEARCH == formState) {
            jBNovo.setEnabled(true);
            jBEditar.setEnabled(true);
            jBCancelar.setEnabled(false);
            jBGravar.setEnabled(false); 
        } else if (FormState.INSERT == formState) {
            jBNovo.setEnabled(false);
            jBEditar.setEnabled(false);
            jBCancelar.setEnabled(true);
            jBGravar.setEnabled(true);
        } else if (FormState.EDIT == formState) {
            jBNovo.setEnabled(false);
            jBEditar.setEnabled(false);
            jBCancelar.setEnabled(true);
            jBGravar.setEnabled(true);            
        }
    }
    
    public void updateEdits() {        
        jTFNome.setText("");
        jTFTelefone.setText("");
        jTFCPF.setText("");
        jTFDataNasc.setText("");
        //        
        Object nome = jTableCliente.getValueAt(jTableCliente.getSelectedRow(), 1);
        Object telefone = jTableCliente.getValueAt(jTableCliente.getSelectedRow(), 2);
        Object cpf = jTableCliente.getValueAt(jTableCliente.getSelectedRow(), 3);
        Object dataNasc = jTableCliente.getValueAt(jTableCliente.getSelectedRow(), 4);        
        //
        jTFCodigo.setText(jTableCliente.getValueAt(jTableCliente.getSelectedRow(), 0).toString());
        if (nome != null) {
            jTFNome.setText(nome.toString());
        }
        if (telefone != null) {
            jTFTelefone.setText(telefone.toString());
        }
        if (cpf != null) {
            jTFCPF.setText(cpf.toString());
        }
        if (dataNasc != null) {
            jTFTelefone.setText(dataNasc.toString());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCliente = new javax.swing.JTable();
        jBGravar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTFNome = new javax.swing.JTextField();
        jBEditar = new javax.swing.JButton();
        jBNovo = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTFCodigo = new javax.swing.JTextField();
        jBCancelar = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Tela Quartos");
        jPanel1.add(jLabel4);

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setToolTipText("");
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Num. Quarto", "Tamanho", "Reservado"
            }
        ));
        jTableCliente.setMinimumSize(new java.awt.Dimension(0, 0));
        jTableCliente.setShowGrid(false);
        jScrollPane1.setViewportView(jTableCliente);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 570, 130));

        jBGravar.setText("Gravar");
        jBGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGravarActionPerformed(evt);
            }
        });
        jPanel2.add(jBGravar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 290, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Reservado:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, 20));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Tamanho:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, 20));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Num: Quarto:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 90, 20));

        jTFNome.setToolTipText("");
        jPanel2.add(jTFNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 210, 30));

        jBEditar.setText("Editar");
        jBEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEditarActionPerformed(evt);
            }
        });
        jPanel2.add(jBEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 100, -1));

        jBNovo.setText("Novo");
        jBNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBNovoActionPerformed(evt);
            }
        });
        jPanel2.add(jBNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Código:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 50, 20));

        jTFCodigo.setEditable(false);
        jTFCodigo.setToolTipText("");
        jPanel2.add(jTFCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 210, 30));

        jBCancelar.setText("Cancelar");
        jBCancelar.setActionCommand("");
        jBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(jBCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 100, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "D" }));
        jComboBox1.setToolTipText("");
        jPanel2.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, -1, 30));

        jComboBox2.setEditable(true);
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "P", "M", "G" }));
        jComboBox2.setToolTipText("");
        jPanel2.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, -1, 30));

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jBGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGravarActionPerformed
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        try {              
            if (formState == FormState.INSERT) {  
                clienteController.inserirCliente(new Cliente(0,
                        jTFNome.getText(),
                        jTFTelefone.getText(),
                        jTFCPF.getText(),
                        df.parse(jTFDataNasc.getText())));
            
            } else if (formState == FormState.EDIT) {
                clienteController.editarCliente(new Cliente(Integer.valueOf(jTFCodigo.getText()), 
                                                        jTFNome.getText(), 
                                                        jTFTelefone.getText(), 
                                                        jTFCPF.getText(),
                                                        df.parse(jTFDataNasc.getText())));
            }        
        } catch (ParseException ex) {
                Logger.getLogger(JPQuarto.class.getName()).log(Level.SEVERE, null, ex);
            }
        //
        atualizarTabela();
        //
        formState = FormState.SEARCH;
        updateButtons();
    }//GEN-LAST:event_jBGravarActionPerformed

    private void jBEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEditarActionPerformed
        // TODO add your handling code here:    
        updateEdits();
        //
        formState = FormState.EDIT;
        //
        updateButtons();
    }//GEN-LAST:event_jBEditarActionPerformed

    private void jBNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBNovoActionPerformed
        jTFNome.setText("");
        jTFTelefone.setText("");
        jTFCPF.setText("");
        //
        formState = FormState.INSERT;
        //
        updateButtons();
    }//GEN-LAST:event_jBNovoActionPerformed

    private void jBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarActionPerformed
        // TODO add your handling code here:
       
        formState = FormState.SEARCH;
        //
        updateButtons();       
    }//GEN-LAST:event_jBCancelarActionPerformed

    private void atualizarTabela() {
        DefaultTableModel model = (DefaultTableModel) jTableCliente.getModel();
        model.setRowCount(0);
        ArrayList<Cliente> lista = clienteController.conultarCliente();

        for (Cliente c : lista) {
            Object[] dados = {c.getId(), c.getNome(), c.getCpf(), c.getTelefone(), c.getDataNasc()};
            model.addRow(dados);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBCancelar;
    private javax.swing.JButton jBEditar;
    private javax.swing.JButton jBGravar;
    private javax.swing.JButton jBNovo;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFCodigo;
    private javax.swing.JTextField jTFNome;
    private javax.swing.JTable jTableCliente;
    // End of variables declaration//GEN-END:variables
}
