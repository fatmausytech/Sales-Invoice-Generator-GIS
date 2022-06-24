/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sig.model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Fatma
 */
public class InvoiceLine_TableModel extends AbstractTableModel{
    private ArrayList <InvoiceLine> linesArray;
    private String[] colum_return = {"Item Name","Unit Price","Count","Line Total"};

    public InvoiceLine_TableModel(ArrayList<InvoiceLine> linesArray) {
        this.linesArray = linesArray;
    }
      
    
    @Override
    public int getRowCount() {
        return linesArray.size();
    }

    @Override
    public int getColumnCount() {
        return colum_return.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InvoiceLine line = linesArray.get(rowIndex);
        switch (columnIndex) {
            case 0: return line.getItem();
            case 1: return line.getPrice();
            case 2: return line.getCount();
            case 3: return line.get_Total_Line();
            default: return "null";
        }
    }

    @Override
    public String getColumnName(int column) {
      return colum_return[column];
    }
    
}
