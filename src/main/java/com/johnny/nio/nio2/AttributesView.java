package com.johnny.nio.nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

public class AttributesView {
    public static void main(String[] args) throws IOException {
        var path = Path.of("./src/main/java/com/johnny/nio/nio2/Attributes.java");
        System.out.println(path);
        BasicFileAttributes view = Files.readAttributes(path, BasicFileAttributes.class);
        System.out.println("isDirectory: " + view.isDirectory());
        System.out.println("isRegularFile: " + view.isRegularFile());
        System.out.println("isSymbolicLink: " + view.isSymbolicLink());
        System.out.println("size: " + view.size());
        System.out.println("lastModifiedTime: " + view.lastModifiedTime());

        BasicFileAttributeView updView = Files.getFileAttributeView(path, BasicFileAttributeView.class);
        BasicFileAttributes attrs = updView.readAttributes();
        final long THIRTY_MINS_MSEC = 1000 * 60 * 30;
        FileTime lastModifiedTime = FileTime.fromMillis(attrs.lastModifiedTime().toMillis() + THIRTY_MINS_MSEC);
        updView.setTimes(lastModifiedTime, null, null);
        view = Files.readAttributes(path, BasicFileAttributes.class);
        System.out.println("lastModifiedTime: " + view.lastModifiedTime());
    }
}
