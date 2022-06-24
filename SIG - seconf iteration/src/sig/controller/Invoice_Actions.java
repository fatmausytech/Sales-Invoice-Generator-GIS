package sig.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.stage.FileChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import sig.model.InvoiceHead_TableModel;
import sig.model.InvoiceHeader;
import sig.model.InvoiceLine;
import sig.view.InvoiceFrame;


public class Invoice_Actions implements ActionListener {
   private InvoiceFrame frame;
   
   
   
   
    public Invoice_Actions (InvoiceFrame frame ){
    this.frame = frame;
    
}
    @Override
   public void actionPerformed(ActionEvent e) {
      switch (e.getActionCommand()) {
          
          case "Load Files":
              Load_Files();
              break;
              
          case "Save Files":
               Save_Files();
              break;
             
          case "Create New Inoice":
              Create_New_Inv();
              break;
                      
          case "Delete Invoice":
              Delete_Inv();
              break;
              
          case "Save":
              Save();
              break;
                          
          case "Cancel":
              Cancel();
              break;
                  
      }  
    }

    private void Load_Files() {
        JFileChooser f_Chooser = new JFileChooser();
        try {
            
        int result = f_Chooser.showOpenDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            
           File head_File = f_Chooser.getSelectedFile();
           Path headerPath = Paths.get(head_File.getAbsolutePath());
           List<String> headerLines = Files.readAllLines(headerPath);
           ArrayList<InvoiceHeader> invoice_Head = new ArrayList<>();
           
           for (String headerLine : headerLines) {
               
              String[] input_arr=  headerLine.split(",");
              String inp1 = input_arr[0];
              String inp2 = input_arr[1];
              String inp3 = input_arr[2];
              
              int code = Integer.parseInt(inp1);
              Date inv_date= InvoiceFrame.Date.parse(inp2);
              InvoiceHeader header = new InvoiceHeader(code, inp3, inv_date);
              invoice_Head.add(header);
           }
          frame.setInvoices_Array(invoice_Head);
           
          result = f_Chooser.showOpenDialog(frame);
          if (result == JFileChooser.APPROVE_OPTION){
              
              File File_Line = f_Chooser.getSelectedFile();
              Path Path_Line = Paths.get(File_Line.getAbsolutePath());
              List<String> lines_Line = Files.readAllLines(Path_Line);
              ArrayList<InvoiceLine> invoice_lines = new ArrayList<>();
              
              for (String Lline : lines_Line) {
                  String [] arr = Lline.split(",");
                  String inp1 = arr[0];
                  String inp2 = arr[1];
                  String inp3 = arr[2];
                  String inp4 = arr[3];
                  int inv_code = Integer.parseInt(inp1);
                  double price = Double.parseDouble(inp3);
                  int count = Integer.parseInt(inp4);
                  InvoiceHeader inv = frame.getInvObject(inv_code);
                  InvoiceLine line = new InvoiceLine(inp4, price, count, inv);
                  inv.Getlines().add(line);
              }
              
          }
          InvoiceHead_TableModel headerTableModel = new InvoiceHead_TableModel(invoice_Head);
          frame.setHeaderTableModel(headerTableModel);
          frame.getInv_head_tbl().setModel(headerTableModel);       
          
            System.out.println("File Readed successfully");
        }
            } 
        catch (IOException ex) {
            JOptionPane.showMessageDialog(frame , ex.getMessage() , "Error!!" ,JOptionPane.ERROR_MESSAGE);
        }
        catch (ParseException ex) {
            JOptionPane.showMessageDialog(frame , ex.getMessage() , "Error!!" ,JOptionPane.ERROR_MESSAGE);
        }

    private void Save_Files() {
       
    }

    private void Create_New_Inv() {
        
    }

    private void Delete_Inv() {
       
    }

    private void Save() {
        
    }

    private void Cancel() {
       
    }
    
}
