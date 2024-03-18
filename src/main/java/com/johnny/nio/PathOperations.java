package com.johnny.nio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathOperations {
    public static void main(String[] args) {
//        pathInfo(Paths.get("C:\\Users\\Johnny\\coding\\java-projects\\java-8-to-21-updates\\pom.xml"));
        pathInfo(Paths.get("abc\\def\\ghi\\jkl")); // Does not exist but still works
    }

    private static void pathInfo(Path path){
        System.out.println("toString: " + path);
        System.out.println("getNameCount: " + path.getNameCount());
        for(int i = 0; i < path.getNameCount(); i++){
            System.out.println("getName("+i+"): " + path.getName(i));
        }
        System.out.println("getFileName: " + path.getFileName());
        System.out.println("getParent: " + path.getParent());
        System.out.println("getRoot: " + path.getRoot());

        System.out.println("subPath(0, 3): " + path.subpath(0, 3));
        System.out.println("subPath(1, 4): " + path.subpath(1, 4));
        System.out.println("subPath(2, 3): " + path.subpath(2, 3));

        System.out.println("isAbsolute: " + path.isAbsolute());
    }
}
