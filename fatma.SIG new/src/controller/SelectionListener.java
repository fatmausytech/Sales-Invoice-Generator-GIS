package controller;

import model.Header;
import model.Line;
import model.LineModel;
import view.Form;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SelectionListener implements ListSelectionListener {
    private Form form;
    public SelectionListener(Form form) {
        this.form = form;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        int selectedInvIndex = form.getHeadersTable().getSelectedRow();
        if (selectedInvIndex != -1) {
            Header selectedInv = form.getHeadersArray().get(selectedInvIndex);
            ArrayList<Line> lines = selectedInv.getLines();
            LineModel lineTableModel = new LineModel(lines);
            form.setLinesArray(lines);
            form.getLinesTable().setModel(lineTableModel);
            form.getCustomerNameLabel().setText(selectedInv.getHeaderCustomer());
            form.getInvoiceNumberLabel().setText("" + selectedInv.getHeaderNumber());
            form.getInvoiceTotalLabel().setText("" + selectedInv.getHeaderTotal());
            form.getInvoiceDateLabel().setText(Form.dateFormat.format(selectedInv.getHeaderDate()));
        }
    }

}
