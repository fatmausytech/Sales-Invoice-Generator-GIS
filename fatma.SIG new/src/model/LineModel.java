package model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class LineModel extends AbstractTableModel {

    private ArrayList<Line> linesArray;
    private String[] tableHeaders = {"Item Name", "Item Price", "Count", "Item Total"};

    public LineModel(ArrayList<Line> linesArray) {
        this.linesArray = linesArray;
    }
    @Override
    public int getRowCount() {
        return linesArray == null ? 0 : linesArray.size();
    }
    @Override
    public int getColumnCount() {
        return tableHeaders.length;
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (linesArray == null) {
            return null;
        } else {
            Line line = linesArray.get(rowIndex);
            return switch (columnIndex) {
                case 0 -> line.getLineItem();
                case 1 -> line.getLinePrice();
                case 2 -> line.getLineCount();
                case 3 -> line.getLineTotal();
                default -> null;
            }
        }
        return null;
    }
    @Override
    public String getColumnName(int column) {
        return tableHeaders[column];
    }

}
