/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sig.controller;

import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import sig.model.InvoiceHeader;
import sig.model.InvoiceLine;
import sig.model.InvoiceLine_TableModel;
import sig.view.InvoiceFrame;

/**
 *
 * @author compo
 */
public class TableSel_Listener implements ListSelectionListener{ 

    private InvoiceFrame frame;

    public TableSel_Listener(InvoiceFrame frame) {
        this.frame = frame;
    }
  
    @Override
    public void valueChanged(ListSelectionEvent e) {
        int Sel_Inv_Index = frame.getInv_head_tbl().getSelectedRow();
        System.out.println("The Invoice was sellected ." + Sel_Inv_Index);
        InvoiceHeader selected_Inv =  frame.getInvoices_Array().get(Sel_Inv_Index);
        ArrayList<InvoiceLine> lines = selected_Inv.Getlines();
        InvoiceLine_TableModel lineTableModel = new InvoiceLine_TableModel(lines);
        frame.getInv_head_tbl().setModel(lineTableModel);
        frame.getCust_name_lable().setText(selected_Inv.getCust_name());
        frame.getInv_num_lable().setText("" +selected_Inv.getNum());
        frame.getInv_total().setText(""+ selected_Inv.get_Total_Inv());
        frame.getInv_date_lable().setText(InvoiceFrame.Date.format(selected_Inv.getInv_date()));
        
    }   
}
