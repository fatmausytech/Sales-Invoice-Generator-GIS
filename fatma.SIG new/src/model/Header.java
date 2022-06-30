package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Header {
    private int headerNumber;
    private String headerCustomer;
    private Date headerDate;
    private ArrayList<Line> lines;
    private DateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");

    public Header() {
    }

    public Header(int headerNumber, String headerCustomer, Date headerDate) {
        this.headerNumber = headerNumber;
        this.headerCustomer = headerCustomer;
        this.headerDate = headerDate;
    }


    public Date getHeaderDate() {
        return headerDate;
    }

    public void setHeaderDate(Date headerDate) {
        this.headerDate = headerDate;
    }

    public int getHeaderNumber() {
        return headerNumber;
    }

    public void setHeaderNumber(int headerNumber) {
        this.headerNumber = headerNumber;
    }

    public String getHeaderCustomer() {
        return headerCustomer;
    }

    public void setHeaderCustomer(String headerCustomer) {
        this.headerCustomer = headerCustomer;
    }

    public ArrayList<Line> getLines() {
        if (lines == null) {
            lines = new ArrayList<>();
        }
        return lines;
    }

    public void setLines(ArrayList<Line> lines) {
        this.lines = lines;
    }
    
    public double getHeaderTotal() {
        double total = 0.0;
        
        for (int i = 0; i < getLines().size(); i++) {
            total += getLines().get(i).getLineTotal();
        }
        
        return total;
    }

    @Override
    public String toString() {
        return headerNumber + "," + dateFormatter.format(headerDate) + "," + headerCustomer;
    }
    
}
