package sig.view;

import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTable;
import sig.controller.Invoice_Actions;
import sig.controller.TableSel_Listener;
import sig.model.InvoiceHead_TableModel;
import sig.model.InvoiceHeader;

public class InvoiceFrame extends javax.swing.JFrame {

    /**
     * Creates new form InvoiceFrame
     */
    public InvoiceFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        inv_head_tbl = new javax.swing.JTable();
        create_invoice_button = new javax.swing.JButton();
        delete_invoice_button = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        inv_num_lable = new javax.swing.JLabel();
        inv_date_lable = new javax.swing.JLabel();
        cust_name_lable = new javax.swing.JLabel();
        inv_total = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        inv_line_tbl = new javax.swing.JTable();
        save_button = new javax.swing.JButton();
        cancel_button = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        load_files = new javax.swing.JMenuItem();
        save_files = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        inv_head_tbl.setModel(new javax.swing.table.DefaultTableModel(
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
        inv_head_tbl.getSelectionModel().addListSelectionListener(selectListener);
        jScrollPane1.setViewportView(inv_head_tbl);

        create_invoice_button.setText("Create New Inoice");
        create_invoice_button.addActionListener(actionListener);

        delete_invoice_button.setText("Delete Invoice");
        delete_invoice_button.addActionListener(actionListener);

        jLabel1.setText("Invoice Num:");

        jLabel2.setText("Invoice Date:");

        jLabel3.setText("Customer Name:");

        jLabel4.setText("Total:");

        inv_line_tbl.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(inv_line_tbl);

        save_button.setText("Save");
        save_button.addActionListener(actionListener);

        cancel_button.setText("Cancel");
        cancel_button.addActionListener(actionListener);

        jMenu1.setText("File");

        load_files.setText("Load Files");
        load_files.addActionListener(new Invoice_Actions());
        load_files.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                load_filesActionPerformed(evt);
            }
        });
        jMenu1.add(load_files);

        save_files.setText("Save Files");
        save_files.addActionListener(new Invoice_Actions());
        jMenu1.add(save_files);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(inv_total)
                                    .addComponent(cust_name_lable)
                                    .addComponent(inv_date_lable)
                                    .addComponent(inv_num_lable)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(create_invoice_button)
                        .addGap(52, 52, 52)
                        .addComponent(delete_invoice_button)
                        .addGap(213, 213, 213)
                        .addComponent(save_button)
                        .addGap(73, 73, 73)
                        .addComponent(cancel_button)))
                .addContainerGap(265, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(inv_num_lable))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(inv_date_lable))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cust_name_lable))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(inv_total))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(create_invoice_button)
                        .addComponent(save_button)
                        .addComponent(cancel_button))
                    .addComponent(delete_invoice_button))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void load_filesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_load_filesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_load_filesActionPerformed

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
            java.util.logging.Logger.getLogger(InvoiceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InvoiceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InvoiceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InvoiceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InvoiceFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel_button;
    private javax.swing.JButton create_invoice_button;
    private javax.swing.JLabel cust_name_lable;
    private javax.swing.JButton delete_invoice_button;
    private javax.swing.JLabel inv_date_lable;
    private javax.swing.JTable inv_head_tbl;
    private javax.swing.JTable inv_line_tbl;
    private javax.swing.JLabel inv_num_lable;
    private javax.swing.JLabel inv_total;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem load_files;
    private javax.swing.JButton save_button;
    private javax.swing.JMenuItem save_files;
    // End of variables declaration//GEN-END:variables

    private Invoice_Actions actionListener = new Invoice_Actions(this);
    private ArrayList<InvoiceHeader> Invoices_Array;
    private InvoiceHeaderTableModel headerTableModel;
    public static SimpleDateFormat Date = new SimpleDateFormat("dd-MM-yyyy");
    private TableSel_Listener selectListener = new TableSel_Listener(this);
    
    
    public void setInvoices_Array(ArrayList<InvoiceHeader> Invoices_Array) {
        this.Invoices_Array = Invoices_Array;
    }

    public ArrayList<InvoiceHeader> getInvoices_Array() {
        return Invoices_Array;
    }

 
    
    public InvoiceHeader getInvObject(int code) {
        for(InvoiceHeader inv :Invoices_Array) {
            if (inv.getNum()== code) {
                return inv;
            }
            
        } 
        return null;
    }

    public InvoiceHeaderTableModel getHeaderTableModel() {
        return headerTableModel;
    }

    public void setHeaderTableModel(InvoiceHeaderTableModel headerTableModel) {
        this.headerTableModel = headerTableModel;
    }

    public JTable getInv_head_tbl() {
        return inv_head_tbl;
    }

    public JTable getInv_line_tbl() {
        return inv_line_tbl;
    }

    public void setHeaderTableModel(InvoiceHead_TableModel headerTableModel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object getInvHTbl() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public JLabel getCust_name_lable() {
        return cust_name_lable;
    }

    public JLabel getInv_date_lable() {
        return inv_date_lable;
    }

    public JLabel getInv_num_lable() {
        return inv_num_lable;
    }

    public JLabel getInv_total() {
        return inv_total;
    }

    ActionListener getActionListeners() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}


