package com.johnny.nio.book;

import java.io.Serializable;

public class Book implements Serializable {
    private BookMarker p = new BookMarker();
    private String theAuthor;

    public Book(){
        theAuthor = "Unknown";
    }

    public String getTheAuthor() {
        return theAuthor;
    }

    public void setTheAuthor(String theAuthor) {
        this.theAuthor = theAuthor;
    }

    @Override
    public String toString() {
        return "Book{" +
                "p=" + p +
                ", theAuthor='" + theAuthor + '\'' +
                '}';
    }
}
