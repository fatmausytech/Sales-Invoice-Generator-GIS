package model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import view.Form;

public class HeaderModel extends AbstractTableModel {
    private ArrayList<Header> headersArray;
    private String[] tableHeaders = {"No.", "Date", "Customer", "Total"};

    public HeaderModel(ArrayList<Header> headersArray) {
        this.headersArray = headersArray;
    }
    @Override
    public int getRowCount() {
        return headersArray.size();
    }
    @Override
    public int getColumnCount() {
        return tableHeaders.length;
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Header header = headersArray.get(rowIndex);
        switch (columnIndex) {
            case 0 -> {return header.getHeaderNumber();}
            case 1 -> {return Form.dateFormat.format(header.getHeaderDate());}
            case 2 -> {return header.getHeaderCustomer();}
            case 3 -> {return header.getHeaderTotal();}
        }
        return null;
    }
    @Override
    public String getColumnName(int header) {
        return tableHeaders[header];
    }
}
