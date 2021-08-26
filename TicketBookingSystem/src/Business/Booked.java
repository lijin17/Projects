/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author lenovo
 */
public class Booked {
    int row;
    int col;
    String whichflight;
    BookedDirect bookd;

    public Booked() {
        bookd=new BookedDirect();
    }

    public String getWhichflight() {
        return whichflight;
    }

    public void setWhichflight(String whichflight) {
        this.whichflight = whichflight;
    }

    public BookedDirect getBookd() {
        return bookd;
    }

    public void setBookd(BookedDirect bookd) {
        this.bookd = bookd;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
    
}
