package model;

public class Line {
    private Header header;
    
    private String lineItem;
    private double linePrice;
    private int lineCount;

    public Line() {
    }

    public Line(Header header, String lineItem, double linePrice, int lineCount) {
        this.header = header;
        this.lineItem = lineItem;
        this.linePrice = linePrice;
        this.lineCount = lineCount;
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public String getLineItem() {
        return lineItem;
    }

    public void setLineItem(String lineItem) {
        this.lineItem = lineItem;
    }

    public double getLinePrice() {
        return linePrice;
    }

    public void setLinePrice(double linePrice) {
        this.linePrice = linePrice;
    }

    public int getLineCount() {
        return lineCount;
    }

    public void setLineCount(int lineCount) {
        this.lineCount = lineCount;
    }
    
    public double getLineTotal() {
        return linePrice * lineCount;
    }

    @Override
    public String toString() {
        return header.getHeaderNumber() + "," + lineItem + "," + linePrice + "," + lineCount;
    }
}
