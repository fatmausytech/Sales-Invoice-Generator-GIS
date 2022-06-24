package sig.view;

import javax.swing.JButton;
import javax.swing.JTextField;

public class HeaderDialog extends javax.swing.JDialog {
    private InvoiceFrame form;
    public HeaderDialog (InvoiceFrame form) {
       initComponents();
       
       ok.addActionListener(form.getActionListeners());
       cancel.addActionListener(form.getActionListeners());

    }

    @SuppressWarnings("unchecked")
                          

    // Variables declaration - do not modify                     
    private javax.swing.JButton cancel;
    private javax.swing.JTextField customerField;
    private javax.swing.JTextField dateField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton ok;
    // End of variables declaration                   

    public InvoiceFrame Form() {
        return form;
    }

    public void setForm(InvoiceFrame form) {
        this.form = form;
    }

    public JButton getCancel() {
        return cancel;
    }

    public void setCancel(JButton cancel) {
        this.cancel = cancel;
    }

    public JTextField getCustomerField() {
        return customerField;
    }

    public void setCustomerField(JTextField customerField) {
        this.customerField = customerField;
    }

    public JTextField getDateField() {
        return dateField;
    }

    public void setDateField(JTextField dateField) {
        this.dateField = dateField;
    }

    public JButton getOk() {
        return ok;
    }

    public void setOk(JButton ok) {
        this.ok = ok;
    }

    private void initComponents() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
