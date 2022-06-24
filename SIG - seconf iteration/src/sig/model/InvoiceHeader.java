package sig.model;

import java.util.ArrayList;
import java.util.Date;

public class InvoiceHeader {
    private int num;
    private String cust_name;
    private Date inv_date;
    private ArrayList<InvoiceLine> lines;

    public InvoiceHeader() {
    }

    public InvoiceHeader(int num, String cust_name, Date inv_date) {
        this.num = num;
        this.cust_name = cust_name;
        this.inv_date = inv_date;
    }

    public Date getInv_date() {
        return inv_date;
    }

    public void setInv_date(Date inv_date) {
        this.inv_date = inv_date;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getCust_name() {
        return cust_name;
    }

    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }
    
    public ArrayList<InvoiceLine> Getlines() {
        if(lines == null) {
            lines = new ArrayList<> ();
        }
        return lines;
    }
    
    public void setLines (ArrayList<InvoiceLine> lines) {
        this.lines = lines;
        
    }
    public double get_Total_Inv() {
        double total = 0.0;
        
        for (int i =0; i< lines.size(); i++) {
            total += lines.get(i).get_Total_Line();
            
        }
        return total;    
    }

    @Override
    public String toString() {
        return "InvoiceHeader{" + "num=" + num + ", cust_name=" + cust_name + ", inv_date=" + inv_date + '}';
    }
    
}
