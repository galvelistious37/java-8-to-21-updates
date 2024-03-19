package com.johnny.nio;

import com.johnny.nio.book.Book;

import java.io.*;

public class Serialization {
    public static void main(String[] args) {
        serializeBook();
        deserializeBook();
    }

    private static void serializeBook(){
        String book = "./src/main/java/com/johnny/nio/book/book.ser";
        try(var out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(book)))){
            Book b = new Book();
            b.setTheAuthor("John Robertson");
            out.writeObject(b);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void deserializeBook(){
        String book = "./src/main/java/com/johnny/nio/book/book.ser";
        try(var in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(book)))){
            Book b = (Book) in.readObject();
            System.out.println("AFTER: " + b);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
