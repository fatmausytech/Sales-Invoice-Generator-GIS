package controller;

import model.Header;
import model.HeaderModel;
import model.Line;
import model.LineModel;
import view.Form;
import view.AddHeader;
import view.AddLine;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class ActionListeners implements ActionListener {
    private Form form;
    private AddHeader addHeader;
    private AddLine addLine;

    public ActionListeners() {
    }
    public ActionListeners(Form form) {
        this.form = form;
    }
    public ActionListeners(AddHeader headerDialog, AddLine lineDialog) {
        this.addHeader = headerDialog;
        this.addLine = lineDialog;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Load File":
                loadFile();
                break;
            case "Save File":
                saveFile();
                break;
            case "Create New Invoice":
                createNewInvoice();
                break;
            case "Delete Invoice":
                deleteInvoice();
                break;
            case "New Line":
                createNewLine();
                break;
            case "Delete Line":
                deleteLine();
                break;
            case "AddHeader OK":
                addHeaderOK();
                break;
            case "AddHeader Cancel":
                addHeaderCancel();
                break;
            case "AddLine OK":
                addLineOK();
                break;
            case "AddLine Cancel":
                addLineCancel();
                break;
        }
    }
    private void loadFile() {
        JFileChooser fileChooser = new JFileChooser();
        try {
            int result = fileChooser.showOpenDialog(form);
            if (result == JFileChooser.APPROVE_OPTION) {
                File headerFile = fileChooser.getSelectedFile();
                Path headerPath = Paths.get(headerFile.getAbsolutePath());
                List<String> headerLines = Files.readAllLines(headerPath);
                ArrayList<Header> invoiceHeaders = new ArrayList<>();
                for (String headerLine : headerLines) {
                    String[] arr = headerLine.split(",");
                    String str1 = arr[0];
                    String str2 = arr[1];
                    String str3 = arr[2];
                    int code = Integer.parseInt(str1);
                    Date invoiceDate = Form.dateFormat.parse(str2);
                    Header header = new Header(code, str3, invoiceDate);
                    invoiceHeaders.add(header);
                }
                form.setHeadersArray(invoiceHeaders);
                result = fileChooser.showOpenDialog(form);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File lineFile = fileChooser.getSelectedFile();
                    Path linePath = Paths.get(lineFile.getAbsolutePath());
                    List<String> linesOfLine = Files.readAllLines(linePath);
                    for (String lineOfLine : linesOfLine) {
                        String[] arr = lineOfLine.split(",");
                        String str1 = arr[0];
                        String str2 = arr[1];
                        String str3 = arr[2];
                        String str4 = arr[3];
                        int invCode = Integer.parseInt(str1);
                        double price = Double.parseDouble(str3);
                        int count = Integer.parseInt(str4);
                        Header inv = form.getObject(invCode);
                        Line line = new Line(inv, str2, price, count);
                        inv.getLines().add(line);
                    }
                System.out.println("................................... Start Files Reading ...........................");
                System.out.println("---------- Header File ---------------");
                System.out.println(invoiceHeaders);
                System.out.println("---------- Line File ---------------");
                for (String lineOfLine : linesOfLine){
                System.out.println(lineOfLine);
                }
                System.out.println("................................... End Files Reading .............................");
                }
                HeaderModel headerTableModel = new HeaderModel(invoiceHeaders);
                form.setHeaderTableModel(headerTableModel);
                form.getHeadersTable().setModel(headerTableModel);  
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(form, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(form, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ArrayIndexOutOfBoundsException ex){
            JOptionPane.showMessageDialog(form, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch(NullPointerException ex) {
            JOptionPane.showMessageDialog(form, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void saveFile() {
        ArrayList<Header> invoicesArray = form.getHeadersArray();
        JFileChooser fileChooser = new JFileChooser();
        try {
            int result = fileChooser.showSaveDialog(form);
            if (result == JFileChooser.APPROVE_OPTION) {
                File headerFile = fileChooser.getSelectedFile();
                FileWriter headerFileWriter = new FileWriter(headerFile);
                String headers = "";
                String lines = "";
                for (Header header : invoicesArray) {
                    headers += header.toString();
                    headers += "\n";
                    for (Line line : header.getLines()) {
                        lines += line.toString();
                        lines += "\n";
                    }
                }
                headers = headers.substring(0, headers.length()-1);
                lines = lines.substring(0, lines.length()-1);
                result = fileChooser.showSaveDialog(form);
                File lineFile = fileChooser.getSelectedFile();
                FileWriter lineFileWriter = new FileWriter(lineFile);
                headerFileWriter.write(headers);
                lineFileWriter.write(lines);
                headerFileWriter.close();
                lineFileWriter.close();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(form, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    } 
    private void createNewInvoice() {
        addHeader = new AddHeader(form);
        addHeader.setVisible(true);
    }
    private void deleteInvoice() {
        int selectedInvoiceIndex = form.getHeadersTable().getSelectedRow();
        if (selectedInvoiceIndex != -1) {
            form.getHeadersArray().remove(selectedInvoiceIndex);
            form.getHeaderTableModel().fireTableDataChanged();
            form.getLinesTable().setModel(new LineModel(null));
            form.setLinesArray(null);
            form.getCustomerNameLabel().setText("");
            form.getInvoiceNumberLabel().setText("");
            form.getInvoiceTotalLabel().setText("");
            form.getInvoiceDateLabel().setText("");
        }
    }
    private void createNewLine() {
        addLine = new AddLine(form);
        addLine.setVisible(true);  
    }
    private void deleteLine() {
        int selectedLineIndex = form.getLinesTable().getSelectedRow();
        int selectedInvoiceIndex = form.getHeadersTable().getSelectedRow();
        if (selectedLineIndex != -1) {
            form.getLinesArray().remove(selectedLineIndex);
            LineModel lineTableModel = (LineModel) form.getLinesTable().getModel();
            lineTableModel.fireTableDataChanged();
            form.getInvoiceTotalLabel().setText("" + form.getHeadersArray().get(selectedInvoiceIndex).getHeaderTotal());
            form.getHeaderTableModel().fireTableDataChanged();
            form.getHeadersTable().setRowSelectionInterval(selectedInvoiceIndex, selectedInvoiceIndex);
        }
    } 
    private void addHeaderCancel() {
        addHeader.setVisible(false);
        addHeader.dispose();
        addHeader = null;
    }
    private void addHeaderOK() {
        try {
        addHeader.setVisible(false);
        String custName = addHeader.getCustomerField().getText();
        String str = addHeader.getDateField().getText();
        Date d = new Date();
        try {
            d = Form.dateFormat.parse(str);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(form, "Cannot parse date, resetting to today.", "Invalid date format", JOptionPane.ERROR_MESSAGE);
        }
        int invNum = 0;
        for (Header inv : form.getHeadersArray()) {
            if (inv.getHeaderNumber() > invNum) {
                invNum = inv.getHeaderNumber();
            }
        }
        invNum++;
        Header newInv = new Header(invNum, custName, d);
        form.getHeadersArray().add(newInv);
        form.getHeaderTableModel().fireTableDataChanged();
        addHeader.dispose();
        addHeader = null;
        }catch (NullPointerException ex){
            JOptionPane.showMessageDialog(form, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void addLineCancel() {
        addLine.setVisible(false);
        addLine.dispose();
        addLine = null;
    }
    private void addLineOK() {
        try {
        addLine.setVisible(false);
        String name = addLine.getItemNameField().getText();
        String str1 = addLine.getItemCountField().getText();
        String str2 = addLine.getItemPriceField().getText();
        int count = 1;
        double price = 1;
        try {
            count = Integer.parseInt(str1);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(form, "Cannot convert number", "Invalid number format", JOptionPane.ERROR_MESSAGE);
        }
        try {
            price = Double.parseDouble(str2);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(form, "Cannot convert price", "Invalid number format", JOptionPane.ERROR_MESSAGE);
        }
        int selectedInvHeader = form.getHeadersTable().getSelectedRow();
        if (selectedInvHeader != -1) {
            Header invHeader = form.getHeadersArray().get(selectedInvHeader);
            Line line = new Line(invHeader,name, price, count);
            //invHeader.getLines().add(line);
            form.getLinesArray().add(line);
            LineModel lineTableModel = (LineModel) form.getLinesTable().getModel();
            lineTableModel.fireTableDataChanged();
            form.getHeaderTableModel().fireTableDataChanged();
        }
        form.getHeadersTable().setRowSelectionInterval(selectedInvHeader, selectedInvHeader);
        addLine.dispose();
        addLine = null;
        }catch (IllegalArgumentException ex){
            JOptionPane.showMessageDialog(form, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
