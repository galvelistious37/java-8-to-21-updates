package com.johnny.io;

import java.io.*;
import java.util.Arrays;

public class ReadingWritingExample {
    public static void main(String[] args) {
//        copyTextFile(false);
//        copyTextFile(true);
//        copyBinaryFile(false);
//        copyBinaryFile(true);
    }

    private static void copyTextFile(boolean buffering){
        File src = new File("C:\\Users\\Johnny\\coding\\java-projects\\java-8-to-21-updates\\src\\main\\java\\com\\johnny\\io\\ReadingWritingExample.java");
        File dest = new File("C:\\Users\\Johnny\\coding\\java-projects\\java-8-to-21-updates\\src\\main\\java\\com\\johnny\\io\\ReadingWritingExample2.java");

        try(var rdr = new BufferedReader(new FileReader(src));
            var wtr = new BufferedWriter(new FileWriter(dest))){
            if(buffering){
                String str = null;
                while((str = rdr.readLine()) != null){
                    wtr.write(str);
                    wtr.newLine();;
                }
            } else {
                int b;
                while ((b = rdr.read()) != -1){
                    wtr.write(b);
                }
            }
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    private static void copyBinaryFile(boolean buffering){
        System.out.println("Working Directory " + System.getProperty("user.dir"));
        File src = new File("./target/classes/com/johnny/io/ReadingWritingExample.class");
        File dest = new File("./target/classes/com/johnny/io/ReadingWritingExample2.class");

        try(var in = new BufferedInputStream(new FileInputStream(src));
            var out = new BufferedOutputStream(new FileOutputStream(dest))){
            if(buffering){
                var buffer = new byte[1024];
                int numBytesRead = 0;
                while((numBytesRead = in.read(buffer)) > 0){
                    out.write(buffer, 0, numBytesRead);
                    out.flush();
                }
            } else {
                int b;
                while((b = in.read()) != -1){
                    out.write(b);
                }
            }
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
