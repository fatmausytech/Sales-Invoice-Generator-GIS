package sig.model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import sig.view.InvoiceFrame;

/**
 *
 * @author Fatma
 */
public class InvoiceHead_TableModel extends AbstractTableModel{
  
    private ArrayList <InvoiceHeader> invoicesArray;
    private String[] colum_return = {"Invoice No.","Invoice Date","Customer Name","Invoice Total"}; 

    public InvoiceHead_TableModel(ArrayList<InvoiceHeader> invoicesArray) {
        this.invoicesArray = invoicesArray;
    }
    
    @Override
    public int getRowCount() {
     return invoicesArray.size();   
    }

    @Override
    public int getColumnCount() {
        return colum_return.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InvoiceHeader invoice = invoicesArray.get(rowIndex);
        switch (columnIndex){
            case 0:
                return invoice.getNum();
            case 1:
                return InvoiceFrame.Date.format(invoice.getInv_date());
            case 2:
                return invoice.getCust_name();
            case 3:
                return invoice.get_Total_Inv();
                
                
        }
        return "null";
    }
  
    @Override
    public String getColumnName (int column) {
            return colum_return [column];
    }
}
